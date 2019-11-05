const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const User = require("../../model/users/foreign_passenger");

router.put("/id/:userid", function(req, res, next) {
    User.findByIdAndUpdate({ _id: req.params.userid }, req.body).then(function() {
      User.findOne({ _id: req.params.userid })
        .then(function(user) {
          res.send(user);
        })
        .catch(next);
    });
  });
  
  module.exports = router;