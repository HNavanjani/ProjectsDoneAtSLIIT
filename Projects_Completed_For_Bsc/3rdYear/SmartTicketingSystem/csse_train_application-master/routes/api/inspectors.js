const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const Inspector = require("../../model/transportManager/inspectors");

var ObjectId = require("mongodb").ObjectID;

//get data from db
///*
//get all
router.get("/inspectors", function(req, res, next) {
  Inspector.find({}).then(function(inspectors) {
    res.send(inspectors);
  });
});
//*/

/*
//get specific
router.get("/inspectors/:name", (req, res) => {
  inspector.findOne({ name: req.params.name }).then(inspector => res.json(inspector));
});
*/

//add data to db
router.post("/inspectors", function(req, res, next) {
  Inspector.create(req.body)
    .then(function(inspector) {
      res.send(inspector);
    })
    .catch(next);
});

//update data of db
router.put("/inspectors/:id", function(req, res, next) {
  Inspector.findByIdAndUpdate({ _id: req.params.id }, req.body).then(
    function() {
      Inspector.findOne({ _id: req.params.id })
        .then(function(inspector) {
          res.send(inspector);
        })
        .catch(next);
    }
  );
});

//delete data from db

router.delete("/inspectors/:id", function(req, res, next) {
  Inspector.findByIdAndRemove({ _id: req.params.id })
    .then(function(inspector) {
      res.send(inspector);
    })
    .catch(next);
});

module.exports = router;
