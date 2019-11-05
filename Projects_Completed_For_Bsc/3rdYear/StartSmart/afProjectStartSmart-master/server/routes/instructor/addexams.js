const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const Exam=require('../../model/instructor/addexam');
router.post("/", (req, res, next) => {
    const exam = new Exam({
      _id: new mongoose.Types.ObjectId(), //construcyor function automatically create and give a new & unique id
      examid: req.body.examid,
      examtype: req.body.examtype,
      subname: req.body.subname,
      year: req.body.year,
      sem: req.body.sem,
      content: req.body.content,
      date: req.body.date
    });
    exam
      .save()
      .then(result => {
        console.log(result);
      })
      .catch(err => console.log(err));
  
    res.status(200).json({
      message: "created product successfully",
      createdbrs: exam 
    });
  });

  router.get("/", (req, res, next) => {
    Exam.find()
      .select("_id examid examtype subname year sem content date")
      .exec()
      .then(docs => {
        const response = {
          count: docs.length,
          exam: docs.map(doc => {
            return {
                _id:doc._id,
                examid: doc.examid,
                examtype: doc.examtype,
                subname: doc.subname,
                year: doc.year,
                sem: doc.sem,
                content: doc.content,
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

  router.patch('/:examId',(req,res,next)=>{
    const examid = req.params.examId;
    Exam.update({_id:examid},{$set:{date:req.body.date}})
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

    router.get("/examid", (req, res, next) => {
      const examid = req.params.examid;
      Exam.find()
        .select("examid")
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

    router.delete("/:examId", (req, res, next) => {
      const id = req.params.examId;
      Exam.remove({ examid: id })
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