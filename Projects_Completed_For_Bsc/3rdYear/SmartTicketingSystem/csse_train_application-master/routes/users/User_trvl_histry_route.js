const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const Travel=require('../../model/users/User_Trvel_history');

const Localpassenger = require('../../model/users/local_passenger');



router.post('/routeDetails/:userId', (req, res, next) => {
    //check the user type
    Localpassenger.find({refUserId: req.body.userId})
        .exec()
        .then(user => {
            if (user.length >= 1) {
                const routedetails = new Travel({
                    userID: req.body.refUserId,
                    journeryDate: req.body.journeryDate,
                    startingLocation: req.body.startingLocation,
                    destinationLocation: req.body.destinationLocation,
                    distance: req.body.distance,
                    fare: req.body.fare,
                    routeID: req.body.routeID
                });
                routedetails
                    .save()
                    .then(result => {
                        console.log(result);
                    })
                    .catch(err => console.log(err));

                res.status(200).json({
                    message: "successfuly added",
                    createdbrs: routedetails
                });
            }
        });
});

//post user travelling data
    router.post("/", (req, res, next) => {
        const travel = new Travel({
            userID: req.body.userID,
            journeryDate: req.body.journeryDate,
            startingLocation: req.body.startingLocation,
            destinationLocation: req.body.destinationLocation,
            distance: req.body.distance,
            fare: req.body.fare,
            routeID: req.body.routeID
        });
        travel
            .save()
            .then(result => {
                console.log(result);
            })
            .catch(err => console.log(err));

        res.status(200).json({
            message: "successfuly added",
            createdbrs: travel
        });
    });



router.get("/", (req, res, next) => {
    Travel.find()
        .select("_id userID journeryDate startingLocation destinationLocation distance fare routeID")
        .exec()
        .then(docs => {
            console.log(docs)
            const response = {

                count: docs.length,

                travel: docs.map(docs => {
                    return {
                        _id:docs._id,
                        userID: docs.userID,
                        journeryDate: docs.journeryDate,
                        startingLocation: docs.startingLocation,
                        destinationLocation: docs.destinationLocation,
                        distance: docs.distance,
                        fare: docs.fare,
                        routeID: docs.routeID

                    }
                })
            };
            if (docs.length > 0) {
                console.log(docs);
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

module.exports=router;