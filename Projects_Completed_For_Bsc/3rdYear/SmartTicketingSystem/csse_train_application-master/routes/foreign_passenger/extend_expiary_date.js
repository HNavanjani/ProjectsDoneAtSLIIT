const express = require("express");
const router = express.Router();
const moment=require('moment');
const mongoose = require("mongoose");
const User=require('../../model/admin/temp_foreign_user_account');
const constants=require('../../constants');


// var currentdate = new Date();
// var fomatted_currentdate = moment(currentdate.toString()).format(
//   "YYYY-DD-MM"
// );
var currentdate = new Date();

//var fomatted_currentdate = moment(currentdate.toString()).format();
  

//post temp local user
router.post("/", (req, res, next) => {
    const user = new User({
      _id: new mongoose.Types.ObjectId(), //construcyor function automatically create and give a new & unique id
      userid: req.body.userid,
      finestatus: constants.FINE_STATUS,
      cardtype: req.body.cardtype,
      cardnumber: req.body.cardnumber,
      amount: req.body.amount,
      initialamountstatus: constants.INITIAL_AMAOUNT_STATUS,
      fineamount: constants.FINE_AMOUNT,
      expirydate:currentdate
      
    });
    user
      .save()
      .then(result => {
        console.log(result);
      })
      .catch(err => console.log(err));
  
    res.status(200).json({
      message: "created product successfully",
      createdbrs: user 
    });
  });

     //get temp local users
     router.get("/", (req, res, next) => {
        User.find()
          .select("_id userid finestatus cardtype cardnumber amount initialamountstatus fineamount")
          .exec()
          .then(docs => {
            const response = {
              count: docs.length,
              user: docs.map(doc => {
                return {
                    _id:doc._id, 
                    userid: doc.userid,
                    finestatus: doc.finestatus,
                    cardtype: doc.cardtype,
                    cardnumber: doc.cardnumber,
                    amount: doc.amount,
                    initialamountstatus: doc.initialamountstatus,
                    fineamount: doc.fineamount
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


  //update (amount), (loan details), (fine details) of local user
  router.put("/id/:userid", function(req, res, next) {
    User.findByIdAndUpdate({ _id: req.params.userid }, req.body).then(
      function() {
        User.findOne({ _id: req.params.userid })
          .then(function(user) {
            res.send(user);
          })
          .catch(next);
      }
    );
  });





  module.exports=router;