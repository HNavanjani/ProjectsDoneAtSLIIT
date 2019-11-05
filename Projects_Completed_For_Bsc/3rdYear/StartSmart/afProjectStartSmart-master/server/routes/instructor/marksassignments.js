const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const Massignment=require('../../model/instructor/marksassignment');

router.post("/", (req, res, next) => {
    const massignment = new Massignment({
      _id: new mongoose.Types.ObjectId(), //construcyor function automatically create and give a new & unique id
      cname: req.body.cname,
      subname: req.body.subname,
      assnumber: req.body.assnumber,
      std: req.body.std,
      marks: req.body.marks
    });
    massignment
      .save()
      .then(result => {
        console.log(result);
      })
      .catch(err => console.log(err));
  
    res.status(200).json({
      message: "created product successfully",
      createdbrs: massignment 
    });
  });

  router.get("/", (req, res, next) => {
    Massignment.find()
      .select("_id cname subname assnumber std marks ")
      .exec()
      .then(docs => {
        const response = {
          count: docs.length,
          massignment: docs.map(doc => {
            return {
                
              _id: doc._id,
              cname: doc.cname,
              subname: doc.subname,
              assnumber: doc.assnumber,
              std: doc.std,
              marks: doc.marks
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