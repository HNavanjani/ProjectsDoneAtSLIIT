const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");

const Admin = require("../../model/admin/adminModel");

router.post("/", (req, res, next) => {
  const admin = new Admin({
    _id: new mongoose.Types.ObjectId(), //construcyor function automatically create and give a new & unique id
    name: req.body.name,
    email: req.body.email,
    username: req.body.username,
    password: req.body.password,
    registeredDate: req.body.registeredDate
  });
  admin
    .save()
    .then(result => {
      console.log(result);
    })
    .catch(err => console.log(err));

  res.status(200).json({
    message: "Admin Added Successfully",
    createdbrs: admin
  });
});

/*
router.patch("/:assignmentId", (req, res, next) => {
  const id = req.params.assignmentId;
  Assignment.update({ _id: id }, { $set: { date: req.body.date } })
    .exec()
    .then(result => {
      console.log(result);
      res.status(200).json(result);
    });

  console.log(err);
  res.status(500).json({
    error: err
  });
});
*/

router.get("/", (req, res, next) => {
  Admin.find()
    .select("_id name email password username registeredDate")
    .exec()
    .then(docs => {
      const response = {
        count: docs.length,
        admin: docs.map(doc => {
          return {
            name: doc.name,
            email: doc.email,
            username: doc.username,
            registeredDate: doc.registeredDate
          };
        })
      };
      if (docs.length > 0) {
        res.status(200).json(response);
      } else {
        res.status(404).json({
          message: "No Entry Found"
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

module.exports = router;
