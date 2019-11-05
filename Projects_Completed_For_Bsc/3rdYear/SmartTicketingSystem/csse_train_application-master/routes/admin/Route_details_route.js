const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const Route=require('../../model/admin/Route_details');



router.post("/", (req, res, next) => {
    const route = new Route({
        routeID: req.body.routeID,
        startingLocation: req.body.startingLocation,
        destinationLocation: req.body.destinationLocation,
        distance: req.body.distance,
        fare: req.body.fare
    });
    route
        .save()
        .then(result => {
            console.log(result);
        })
        .catch(err => console.log(err));

    res.status(201).json({
        message: "created product successfully",
        createdbrs: route
    });
});

router.get("/", (req, res, next) => {
    Route.find()
        .select("_id routeID startingLocation destinationLocation distance fare")
        .exec()
        .then(docs => {
            console.log(docs);
            const response = {
                count: docs.length,

                route: docs.map(docs => {
                    return {
                        routeID: docs.routeID,
                        startingLocation: docs.startingLocation,
                        destinationLocation: docs.destinationLocation,
                        distance: docs.distance,
                        fare: docs.fare
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

//route  details find
router.get("/rout/:routeID", function(req, res, next) {
    const id = req.params.routeID;
    Route.findById(id)
        .exec()
        .then(doc =>{
            console.log(doc);
            if(doc){
                res.status(200).json(doc);
            }
            else{
                res.status(404).json({message:'no valide data'})
            }
        }).catch(err =>{
            console.log(err);
            res.status(500).json({error:err})
        }

    )

});



//update foreign passenger
router.put("/route/:routeID", (req, res, next) => {
    const id = req.params.routeID;
    console.log(id);
    Route.update({ _id: id }, { $set: {
            startingLocation: req.body.startingLocation,
            destinationLocation: req.body.destinationLocation,
            distance: req.body.distance,
            fare: req.body.fare} })
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