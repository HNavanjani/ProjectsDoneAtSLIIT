const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const User=require('../../model/users/foreign_passenger');
const constants=require('../../constants');



router.get("/id/:id", (req, res, next) => {
    const id = req.params.id;
    User.findOne({ refUserId: req.params.id })
      .select("refUserId cardtype cardnumber amount loanamount fineamount")
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