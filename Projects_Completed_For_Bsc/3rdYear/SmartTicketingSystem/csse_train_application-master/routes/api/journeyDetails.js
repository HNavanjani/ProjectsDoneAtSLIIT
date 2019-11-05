const express = require("express");
var moment = require("moment");
var momentt = require("moment-timezone");

const router = express.Router();
const ValidJourneydetails = require("../../model/transportManager/validJourneyDetails");
const InValidJourneydetails = require("../../model/transportManager/invalidJourneyDetails");

//get data from db

//get all

router.get("/journeydetails", function(req, res, next) {
  ValidJourneydetails.find({}).then(function(validjourneydetails) {
    res.send(validjourneydetails);
  });
});

//Find with conditions
router.get("/journeydetails/:startingLocation/:hour", (req, res) => {
  ValidJourneydetails.find({
    startingLocation: req.params.startingLocation,
    //day: req.params.day,
    hour: req.params.hour
  }).then(validJourneydetails => res.json(validJourneydetails));
});

//add data to db
router.post("/journeydetails", function(req, res, next) {
  //For stats

  console.log(req.body.journeryDate);
  var fomatted_journeydate = momentt(req.body.journeryDate)
    .tz("GMT")
    .format("YYYY-DD-MM");

  var currentdate = new Date();

  var fomatted_currentdate = moment(currentdate.toString())
    .tz("GMT")
    .format("YYYY-DD-MM");

  var day = momentt(req.body.journeryDate)
    .tz("GMT")
    .format("ddd");
  console.log(day);
  var hour = momentt(req.body.journeryDate)
    .tz("GMT")
    .format("H");

  console.log(hour);
  console.log(fomatted_journeydate);
  console.log(fomatted_currentdate);

  //Token Validity check


  if (fomatted_journeydate == fomatted_currentdate) {
    ValidJourneydetails.create(req.body)
      .then(function(validjourneydetails) {
        res.send(validjourneydetails);
      })
      .catch(next);
  } else {
    InValidJourneydetails.create(req.body)
      .then(function(invalidjourneydetails) {
        res.send(invalidjourneydetails);
      })
      .catch(next);
  }
});

module.exports = router;
