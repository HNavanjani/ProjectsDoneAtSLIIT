const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const Assignment=require('../../model/instructor/addassignment');

router.post("/", (req, res, next) => {
    const assignment = new Assignment({
      _id: new mongoose.Types.ObjectId(), //construcyor function automatically create and give a new & unique id
      cname: req.body.cname,
      subname: req.body.subname,
      assignmentNumber: req.body.assignmentNumber,
      assignment: req.body.assignment,
      date: req.body.date
    });
    assignment
      .save()
      .then(result => {
        console.log(result);
      })
      .catch(err => console.log(err));
  
    res.status(200).json({
      message: "created product successfully",
      createdbrs: assignment 
    });
  });

router.put('/_id/:_id',(req,res,next)=>{
const id = req.params.assignmentid;
Assignment.update({_id:id},{$set:{date:req.body.date}})
.exec()
.then(result => {
   console.log(result);
   res.status(200).json(result);
})

   console.log(err);
   res.status(500).json({
     error:err
   });
});

router.get("/", (req, res, next) => {
    Assignment.find()
      .select("_id cname subname assignmentNumber assignment date")
      .exec()
      .then(docs => {
        const response = {
          count: docs.length,
          assignment: docs.map(doc => {
            return {
              cname: doc.cname,
              subname: doc.subname,
              assignmentNumber: doc.assignmentNumber,
              assignment: doc.assignment,
              date: doc.date
            };
          })
        };
        if (docs.length > 0) {
          res.status(200).json(response);
        } else {
          res.status(404).json({
            message: "no entry found"
          });
        }
      })
      .catch(err => {
        console.log(err);
        res.status(500).json({
          error: err
        });
      });
  });


  router.get("/id/:id", (req, res, next) => {
    const id = req.params.id;
    Assignment.findOne({ assignmentNumber: req.params.id })
      .select("_id cname subname assignmentNumber assignment")
      .exec()
      .then(result => {
        res.status(200).json({ result });
      })
      .catch(err => {
        console.log(err);
        res.status(500).json({
          error: err
        });
      });
  });

  router.delete("/:assignmentId", (req, res, next) => {
    const id = req.params.assignmentId;
    Assignment.remove({ assignmentNumber: id })
      .exec()
      .then(result => {
        res.status(200).json({ result });
      })
      .catch(err => {
        console.log(err);
        res.status(500).json({
          error: err
        });
      });
  });


  

module.exports=router;