const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const Vehicle=require('../../model/admin/Vehicle_details');

//post driver details
router.post("/", (req, res, next) => {
    const vehicle = new Vehicle({
        _id: new mongoose.Types.ObjectId(),
        Regnumber: req.body.Regnumber,
        name: req.body.name,
        routeID: req.body.routeID,
        DriverID: req.body.DriverID,
        type: req.body.type
    });
    vehicle
        .save()
        .then(result => {
            console.log(result);
        })
        .catch(err => console.log(err));

    res.status(200).json({
        message: "created product successfully",
        createdbrs: vehicle
    });
});


router.get("/", (req, res, next) => {
    Vehicle.find()
    .select("_id Regnumber name routeID DriverID type")
    .exec()
    .then(docs => {
        console.log(docs);
        const response = {
            count: docs.length,

            vehicle: docs.map(docs => {
                return {
                    _id:docs.id,
                    Regnumber: docs.Regnumber,
                    name: docs.name,
                    routeID: docs.routeID,
                    DriverID: docs.DriverID,
                    type: docs.type
                }
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


router.put("/:Regnumber", (req, res, next) => {
    const id = req.params.Regnumber;
    console.log(id);
    Vehicle.update({ _id: id }, { $set: {
            Regnumber: req.body.Regnumber,
            name: req.body.name,
            routeID: req.body.routeID,
            DriverID: req.body.DriverID,
            type: req.body.type} })
        .exec()
        .then(result => {
            console.log(result);
            res.status(200).json(result);
        }).catch(err =>{
        console.log(err);
        res.status(500).json({
            error: err
        });
    });
})

module.exports=router;