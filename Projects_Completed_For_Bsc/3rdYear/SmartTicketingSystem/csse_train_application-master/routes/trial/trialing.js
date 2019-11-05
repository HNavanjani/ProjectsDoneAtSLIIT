const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const Inspector = require("../../model/transportManager/inspectors");

var ObjectId = require("mongodb").ObjectID;

//add data to db
router.post("/inspectors", function(req, res, next) {
    Inspector.create(req.body)
      .then(function(inspector) {
        res.send(inspector);
      })
      .catch(next);
  });

  module.exports = router;