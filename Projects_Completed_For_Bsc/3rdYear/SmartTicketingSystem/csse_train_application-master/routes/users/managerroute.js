const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");

const Manager = require('../../model/users/manager');

//get managers
router.get("/", (req, res, next) => {
    Manager.find()
        .select("_id managerName ManagerAge refUserId")
        .exec()
        .then(docs => {
            const response = {
                count: docs.length,
                train: docs.map(doc => {
                    return {
                        _id:doc._id,
                        managerName: doc.managerName,
                        ManagerAge: doc.ManagerAge,
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
//update
router.put("/id/:managerid", function(req, res, next) {
    Manager.findByIdAndUpdate({ _id: req.params.managerid }, req.body).then(
        function() {
            Manager.findOne({ _id: req.params.managerid })
                .then(function(manager) {
                    res.send(manager);
                })
                .catch(next);
        }
    );
});

//delete manager
router.delete("/:managerId", (req, res, next) => {
    Manager.remove({ _id: req.params.managerId })
        .exec()
        .then(result => {
            res.status(200).json({
                message: 'Manager has been deleted'
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