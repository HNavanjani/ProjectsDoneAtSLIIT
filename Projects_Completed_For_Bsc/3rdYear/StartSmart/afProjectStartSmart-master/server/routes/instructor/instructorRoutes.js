const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const nodemailer = require("nodemailer");

const Instructor = require("../../model/instructor/instructor");

router.get("/", (req, res, next) => {
  Instructor.find()
    .select("_id name email password username registeredDate")
    .exec()
    .then(docs => {
      const response = {
        count: docs.length,
        instructor: docs.map(doc => {
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
          message: "No Entry Found ! "
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

router.post("/", (req, res) => {
  const instructor = new Instructor({
    _id: new mongoose.Types.ObjectId(), //construcyor function automatically create and give a new & unique id
    name: req.body.name,
    email: req.body.email,
    username: req.body.username,
    password: req.body.password,
    registeredDate: req.body.registeredDate
  });
  instructor.save().then(result => res.json(result));
  /*
  res.status(200).json({
    message: "Instructor Added Successfully !",
    createdbrs: instructor
  });
*/
  //Notify Instructor via email
  var CPRef = Math.floor(Math.random() * 1000000 + 1);

  var output = `
<p>Hello ${req.body.name}, </p>
<p>Welcome to Start Smart :) We are glad to inform you that you have been added to the Start Smart Student and Instructor Information System as an Instructor. 
Your username : ${req.body.username} Your password : ${req.body.password}</p>
<p>Thank you very much for being part of Start Smart Honored Instrutors ! </p>
<h4>This email notification ID is : TTR${CPRef}</h4>
  
</p>
<h3>In order to continue the registration procedure, please Sign In to Start Smart with your username and password.</h3>
<br/>
<p>Thanks,</p>
<p>Start Smart</p>

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
    from: '"Start Smart" <alpha.4spirits@gmail.com>',
    to: req.body.email,
    subject: "[Start Smart] Welcome to Start Smart",
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
});

module.exports = router;
