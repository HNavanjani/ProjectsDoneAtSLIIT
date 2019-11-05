const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const course=require('../../model/Course/CourseDetails');

router.post("/", (req, res, next) => {
    const courses = new course({

    coursename: req.body.coursename,
    duration:  req.body.duration,
    numcredits:  req.body.numcredits,
    numsubjects:  req.body.numsubjects,
    numsemester:  req.body.numsemester,
    semprice:  req.body.semprice,
    subdetails: req.body.subdetails
    });
courses
    .save()
    .then(result => {
    console.log(result);
})
.catch(err => console.log(err));

res.status(200).json({
    message: "course Added Successfully",
    createdbrs: courses
});
});

router.get('/', function (req, res) {
    course.find({}, function (err, users) {
        if (err) return res.status(500).json({
            "error": "Error encountered Please try again."
        });
        res.status(200).json({
            "data": users
        });
    });
});
module.exports = router;