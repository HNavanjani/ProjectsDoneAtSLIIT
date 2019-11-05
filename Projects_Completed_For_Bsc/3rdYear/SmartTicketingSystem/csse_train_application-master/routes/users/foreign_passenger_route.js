const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");

const ForeignPassenger =  require('../../model/users/foreign_passenger');
const checkAuth = require('../../middleware/check-auth');

//get foreign passenger
router.get("/", (req, res, next) => {
    ForeignPassenger.find()
        .select("_id fPassengerName fPassengerAge fPassengerPassportNumber finestatus cardtype cardnumber amount initialamountstatus fineamount expireDate refUserId")
        .exec()
        .then(docs => {
            const response = {
                count: docs.length,
                localPassenger: docs.map(doc => {
                    return {
                        _id:doc._id,
                        fPassengerName: doc.fPassengerName,
                        fPassengerAge: doc.fPassengerAge,
                        fPassengerPassportNumber: doc.fPassengerPassportNumber,
                        finestatus: doc.finestatus,
                        cardtype: doc.cardtype,
                        cardnumber: doc.cardnumber,
                        amount: doc.amount,
                        initialamountstatus: doc.initialamountstatus,
                        fineamount: doc.fineamount,
                        expireDate: doc.expireDate,
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

//get specific foreign user data
router.get("/id/:id", (req, res, next) => {
    const id = req.params.id;
    ForeignPassenger.findOne({ refUserId: req.params.id })
        .select("_id refUserId expireDate")
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

//delete foreign passenger
/*router.delete("/:foreignPassengerId", (req, res, next) => {
    ForeignPassenger.remove({ _id: req.params.foreignPassengerId })
        .exec()
        .then(result => {
            res.status(200).json({
                message: 'Foreign user has been deleted'
            });
        })
        .catch(err => {
            console.log(err)
            res.status(500).json({
                error: err
            })
        });

});*/
router.delete("/:foreignPassengerId", checkAuth, (req, res, next) => {
    ForeignPassenger.remove({ _id: req.params.foreignPassengerId })
        .exec()
        .then(result => {
            res.status(200).json({
                message: 'Foreign user has been deleted'
            });
        })
        .catch(err => {
            console.log(err)
            res.status(500).json({
                error: err
            })
        });

});

//update foreign passenger
/*router.patch("/:foreignPassengerId", (req, res, next) => {
    const id = req.params.foreignPassengerId;
    ForeignPassenger.update({ _id: id }, { $set: { cardnumber: req.body.cardnumber } })
        .exec()
        .then(result => {
            console.log(result);
            res.status(200).json(result);
        });
    console.log(err);
    res.status(500).json({
        error: err
    });
});*/

module.exports=router;