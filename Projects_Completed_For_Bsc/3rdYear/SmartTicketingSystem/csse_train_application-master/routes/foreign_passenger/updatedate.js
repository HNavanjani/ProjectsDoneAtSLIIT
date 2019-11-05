const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const User=require('../../model/users/foreign_passenger');
const constants=require('../../constants');
var moment = require("moment");
var momentt = require("moment-timezone");

var fineamountt=5555;
 router.patch('/:refUserId',(req,res,next)=>{
    const refUserId = req.params.refUserId;
    User.update({_id:refUserId},{$set:{fineamount:fineamountt}})
    .exec()
    .then(result => {
       console.log(result);
       res.status(200).json(result);
    })
    
       console.log(err);
       res.status(500).json({
         error:err
       });
    });

router.put("/id/:userid", function(req, res, next) {
    //console.log("date "+req.params.date);
    var day=new Date();
    console.log("day "+day);
    var dd=moment(day).add('months', 2);
    const formatted=new moment(dd,'yyyyMMddHHmmssfff').toDate()
    console.log("substracted date "+formatted);

    User.findByIdAndUpdate({ _id: req.params.userid }, {expireDate:formatted}).then(
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