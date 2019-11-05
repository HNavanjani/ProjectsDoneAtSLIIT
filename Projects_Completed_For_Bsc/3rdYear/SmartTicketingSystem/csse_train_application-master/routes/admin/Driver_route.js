const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const Driver=require('../../model/admin/Driver_details');

//post driver details
router.post("/", (req, res, next) => {
    const driver = new Driver({
        _id: new mongoose.Types.ObjectId(),
        DiverID: req.body.DiverID,
        nameofDriver: req.body.nameofDriver,
        Address: req.body.Address,
        Phone: req.body.Phone
    });
    driver
        .save()
        .then(result => {
            console.log(result);
        })
        .catch(err => console.log(err));

    res.status(200).json({
        message: "created product successfully",
        createdbrs: driver
    });
});


// //get driver details
// router.get("/", (req, res, next) => {
//     Driver.find()
//         .select("")
//         .exec()
//         .then(docs => {
//             const response = {
//                 count: docs.length,
//                 driver: docs.map(doc => {
//                     return {
//                         DiverID: docs.DiverID,
//                         nameofDriver: docs.nameofDriver,
//                         Address: docs.Address,
//                         Phone: docs.Phone
//                     };
//                 })
//             };
//             if (docs.length > 0) {
//                 res.status(200).json(response);
//             } else {
//                 res.status(404).json({
//                     message: "no entry found"
//                 });
//             }
//         })
//         .catch(err => {
//             console.log(err);
//             res.status(500).json({
//                 error: err
//             });
//         });
// });

//driver details update
router.put("/driver/:id", function(req, res, next) {
    Driver.findByIdAndUpdate({ DiverID: req.params.DiverID }, req.body).then(
        function() {
            Driver.findOne({ DiverID: req.params.DiverID})
                .then(function(driver) {
                    res.send(driver);
                })
                .catch(next);
        }
    );
});

router.get("/", (req, res, next) => {
    Driver.find()
        .select("_id DiverID nameofDriver Address Phone")
        .exec()
        .then(docs => {
            console.log(docs);
            const response = {
                count: docs.length,

                driver: docs.map(docs => {
                    return {
                        _id:docs.id,
                        DiverID: docs.DiverID,
                        nameofDriver: docs.nameofDriver,
                        Address: docs.Address,
                        Phone: docs.Phone
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

//update driver information
router.put("/:DiverID", (req, res, next) => {
    const id = req.params.DiverID;
    console.log(id);
    Driver.update({ _id: id }, { $set: {
            DiverID: req.body.DiverID,
            nameofDriver: req.body.nameofDriver,
            Address: req.body.Address,
            Phone: req.body.Phone} })
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