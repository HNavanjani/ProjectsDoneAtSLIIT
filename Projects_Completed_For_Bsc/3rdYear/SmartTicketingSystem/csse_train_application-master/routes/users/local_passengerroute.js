const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");

const LocalPassenger =  require('../../model/users/local_passenger');

//get local passenger
router.get("/", (req, res, next) => {
    LocalPassenger.find()
        .select("_id lPassengerName lPassengerAge lPassengerPhone lPassengerNic loanstatus finestatus cardtype cardnumber amount initialamountstatus loanamount fineamount refUserId")
        .exec()
        .then(docs => {
            const response = {
                count: docs.length,
                localPassenger: docs.map(doc => {
                    return {
                        _id:doc._id,
                        lPassengerName: doc.lPassengerName,
                        lPassengerAge: doc.lPassengerAge,
                        lPassengerPhone: doc.lPassengerPhone,
                        lPassengerNic: doc.lPassengerNic,
                        loanstatus: doc.loanstatus,
                        finestatus: doc.finestatus,
                        cardtype: doc.cardtype,
                        cardnumber: doc.cardnumber,
                        amount: doc.amount,
                        initialamountstatus: doc.initialamountstatus,
                        loanamount: doc.loanamount,
                        fineamount: doc.fineamount,
                        refUserId: doc.refUserId
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

//get specific user data
router.get("/id/:id", (req, res, next) => {
    const id = req.params.id;
    LocalPassenger.findOne({ refUserId: req.params.id })
        .select("_id refUserId initialamountstatus")
        .exec()
        .then(result => {
            console.log(result);
            res.status(200).json({ result });
        })
        .catch(err => {
            console.log(err);
            res.status(500).json({
                error: err
            });
        });
});

//delete local passenger
router.delete("/:localPassengerId", (req, res, next) => {
    LocalPassenger.remove({ _id: req.params.localPassengerId })
        .exec()
        .then(result => {
            res.status(200).json({
                message: 'Local user has been deleted'
            });
        })
        .catch(err => {
            console.log(err)
            res.status(500).json({
                error: err
            })
        });

});


module.exports=router;