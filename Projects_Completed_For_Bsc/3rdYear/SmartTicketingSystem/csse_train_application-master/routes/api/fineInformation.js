const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const nodemailer = require("nodemailer");
const FineInfo = require("../../model/transportManager/fineInformation");

var ObjectId = require("mongodb").ObjectID;

//add data to db
router.post("/fineinformation", function(req, res, next) {
  FineInfo.create(req.body)
    .then(function(fineinfo) {
      res.send(fineinfo);

      //Send Fine detail Email

      var MPRef = Math.floor(Math.random() * 1000000 + 1);
      var output = `
<p>Hello , </p>
<p>You have  assigned a fine amount of <strong>${req.body.fine} LKR</strong>
 for the follwing journey that you have taken. </p>
 <p>******************************************</p>
 <p>Journey Date : ${req.body.journeryDate}</p>
 <p>Starting Location : ${req.body.startingLocation}</p>
 <p>Destination Location : ${req.body.destinationLocation}</p>
 <p>Distance : ${req.body.distance}</p>
 <p>Fare : ${req.body.fare}</p>
 <p>RouteName : ${req.body.routeName}</p>
 <p>Day : ${req.body.day}</p>
 <p>Hour : ${req.body.hour}</p>
 <p>******************************************</p>
 <br/>
<h4>Your Ref # : TTA${MPRef}</h4>
</p>

<br/>

<p>Thanks,</p>
<p>TravelLight<p>
`;
      let transporter = nodemailer.createTransport({
        host: "smtp.gmail.com",
        port: 465,
        secure: true, // true for 465, false for other ports
        auth: {
          user: "alpha.4spirits@gmail.com", // generated ethereal user
          pass: "SE__2019" // generated ethereal password
        },
        tls: {
          rejectUnauthorized: false
        }
      });
      let mailOptions = {
        from: '"TravelLight" <alpha.4spirits@gmail.com>',
        to: req.body.emaila,
        subject: "[TravelLight] Payment Confirmation",
        text: "Hello",
        html: output
      };
      transporter.sendMail(mailOptions, (error, info) => {
        if (error) {
          return console.log(error);
        }
        console.log("Message sent: %s", info.messageId);
        console.log("Preview URL: %s", nodemailer.getTestMessageUrl(info));
      });
    })

    .catch(next);
});

//get all
router.get("/fineinformation", function(req, res, next) {
  FineInfo.find({}).then(function(fineInfo) {
    res.send(fineInfo);
  });
});

module.exports = router;
