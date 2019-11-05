const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const Train=require('../../model/trial/train');

router.post("/", (req, res, next) => {
    const train = new Train({
      _id: new mongoose.Types.ObjectId(), //construcyor function automatically create and give a new & unique id
      name: req.body.name,
      age: req.body.age
    });
    train
      .save()
      .then(result => {
        console.log(result);
      })
      .catch(err => console.log(err));
  
    res.status(200).json({
      message: "created product successfully",
      createdbrs: train 
    });
  });


  router.get("/", function(req, res, next) {
    Train.find({}).then(function(train) {
      res.send(train);
    });
  });

module.exports=router;