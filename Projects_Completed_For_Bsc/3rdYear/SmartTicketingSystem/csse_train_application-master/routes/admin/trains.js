const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const Train = require("../../model/admin/train");

//post train
router.post("/", (req, res, next) => {
  const train = new Train({
    _id: new mongoose.Types.ObjectId(), //construcyor function automatically create and give a new & unique id
    tname: req.body.tname,
    startstation: req.body.startstation,
    destination: req.body.destination,
    distance: req.body.distance,
    fare: req.body.fare
  });
  train
    .save()
    .then(result => {
      console.log(result);
    })
    .catch(err => console.log(err));

  res.status(200).json({
    message: "created product successfully",
    createdbrs: train,
      createdbrs: train ,
    createdbrs: train,
      createdbrs: train ,
    createdbrs: train
  });
});


//get train
router.get("/", (req, res, next) => {
  Train.find()
    .select("_id tname startstation destination distance priceperkm")
    .exec()
    .then(docs => {
      const response = {
        count: docs.length,
        train: docs.map(doc => {
          return {
            _id: doc._id,
            tname: doc.tname,
            startstation: doc.startstation,
            destination: doc.destination,
            distance: doc.distance,
            priceperkm: doc.priceperkm
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

router.get("/availabletrains", function(req, res, next) {
  Train.find({}).then(function(trains) {
    res.send(trains);
  });
})
  router.put("/id/:userid", function(req, res, next) {
    Train.findByIdAndUpdate({ _id: req.params.userid }, req.body).then(
      function() {
        Train.findOne({ _id: req.params.userid })
          .then(function(user) {
            res.send(user);
          })
          .catch(next);
      }
    );
});

module.exports = router;
