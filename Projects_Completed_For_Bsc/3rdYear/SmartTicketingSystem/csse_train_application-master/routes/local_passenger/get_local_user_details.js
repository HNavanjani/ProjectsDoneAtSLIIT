const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const User=require('../../model/users/local_passenger');
const constants=require('../../constants');

router.get("/", (req, res, next) => {
    User.find()
      .select("_id refUserId loanstatus finestatus cardtype cardnumber amount initialamountstatus loanamount fineamount")
      .exec()
      .then(docs => {
        const response = {
          count: docs.length,
          user: docs.map(doc => {
            return {
                _id:doc._id, 
                userid: doc.userid,
                loanstatus: doc.loanstatus,
                finestatus: doc.finestatus,
                cardtype: doc.cardtype,
                cardnumber: doc.cardnumber,
                amount: doc.amount,
                initialamountstatus: doc.initialamountstatus,
                loanamount: doc.loanamount,
                fineamount: doc.fineamount,
                refUserId:doc.refUserId
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


  //get local user details for the given user id
  router.get("/id/:id", (req, res, next) => {
    const id = req.params.id;
    User.findOne({ refUserId: req.params.id })
      .select("_id lPassengerName refUserId loanstatus finestatus cardtype cardnumber amount initialamountstatus loanamount fineamount")
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