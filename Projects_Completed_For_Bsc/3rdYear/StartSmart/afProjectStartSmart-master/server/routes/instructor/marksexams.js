const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const Mexam=require('../../model/instructor/marksexam');

router.post("/", (req, res, next) => {
    const mexam = new Mexam({
      _id: new mongoose.Types.ObjectId(), //construcyor function automatically create and give a new & unique id
      examtype: req.body.examtype,
      examid: req.body.examid,
      std: req.body.std,
      cname: req.body.cname,
      subname: req.body.subname,
      marks: req.body.marks
    });
    mexam
      .save()
      .then(result => {
        console.log(result);
      })
      .catch(err => console.log(err));
  
    res.status(200).json({
      message: "created product successfully",
      createdbrs: mexam 
    });
  });

  router.get("/", (req, res, next) => {
    Mexam.find()
      .select("_id examid examtype subname std marks cname")
      .exec()
      .then(docs => {
        const response = {
          count: docs.length,
          mexam: docs.map(doc => {
            return {
                
                examid: doc.examid,
                examtype: doc.examtype,
                subname: doc.subname,
                std: doc.std,
                marks: doc.marks,
                cname: doc.cname
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

  module.exports=router;