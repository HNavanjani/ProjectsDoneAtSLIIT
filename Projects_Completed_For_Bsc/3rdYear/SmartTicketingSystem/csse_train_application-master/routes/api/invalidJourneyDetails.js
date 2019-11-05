const express = require("express");
var moment = require("moment");
const router = express.Router();
const InValidJourneydetails = require("../../model/transportManager/invalidJourneyDetails");
var icount;
//get data from db

//get all
router.get("/invalidjourneydetails", function(req, res, next) {
  InValidJourneydetails.find({}).then(function(invalidjourneydetails) {
    res.send(invalidjourneydetails);
    icount = InValidJourneydetails.countDocuments({}, function(err, count) {
      console.log(count);
    });
  });
});

//Find with conditions
router.get("/invalidjourneydetails/:startingLocation/:hour", (req, res) => {
  InValidJourneydetails.find({
    startingLocation: req.params.startingLocation,
    //day: req.params.day,
    hour: req.params.hour
  }).then(inValidJourneydetails => res.json(inValidJourneydetails));
});

//delete data from db

router.delete("/invalidjourneydetails/:id", function(req, res, next) {
  InValidJourneydetails.findByIdAndRemove({ _id: req.params.id })
    .then(function(inValidjourneydetail) {
      res.send(inValidjourneydetail);
    })
    .catch(next);
});

exports.icount = icount;
module.exports = router;
