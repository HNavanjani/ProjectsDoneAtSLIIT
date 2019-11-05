const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const User=require('../../model/users/local_passenger');
const constants=require('../../constants');

//post temp local users
router.post("/", (req, res, next) => {
    const user = new User({
      _id: new mongoose.Types.ObjectId(), //construcyor function automatically create and give a new & unique id
      userid: req.body.userid,
      loanstatus: constants.LOAN_STATUS,
      finestatus: constants.FINE_STATUS,
      cardtype: req.body.cardtype,
      cardnumber: req.body.cardnumber,
      amount: req.body.amount,
      initialamountstatus: constants.INITIAL_AMAOUNT_STATUS,
      loanamount: constants.LOAN_AMOUNT,
      fineamount: constants.FINE_AMOUNT
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

   

  

  //update (amount), (loan details), (fine details) of local user
    router.put("/id/:userid", function(req, res, next) {
      User.findById({ _id: req.params.userid }, req.body).then(
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