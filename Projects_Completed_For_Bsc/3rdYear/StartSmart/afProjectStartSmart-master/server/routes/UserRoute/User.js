const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const jwt = require("jsonwebtoken");
const bcrypt = require("bcrypt");
const User = require("../../model/User/UserlogModel")


process.env.SECRET_KEY = 'secret'


router.post('/', function (req, res) {
    const userData = {
            name: req.body.name,
            password: req.body.password,
            type: req.body.type

        }
    User.findOne({
        name: req.body.name
    })
        .then(user => {
        if (!user) {
        bcrypt.hash(req.body.password, 10, (err, hash) => {
            userData.password = hash
            User.create(userData)
                .then(user => {
                res.json({ status: user.email + ' registered!' })
            })
    .catch(err => {
            res.send('error: ' + err)
        })
    })
    } else {
        res.json({ error: 'User already exists' })
    }
})
.catch(err => {
        res.send('error: ' + err)
    }),
        function (err, cart) {
            if (err) return res.status(500).json({
                "error": "Error encountered Please try again."
            });
            res.status(201).json({
                "data": cart
            });
        }

})

router.post('/login', (req, res) => {
    User.findOne({
        name: req.body.name,
        type:req.body.type
    })
        .then(user => {
        if (user) {
            if (bcrypt.compareSync(req.body.password, user.password)) {
                const payload = {
                    name: user.name,
                    password: user.password,
                    type:user.type
                }
                let token = jwt.sign(payload, process.env.SECRET_KEY, {
                    expiresIn: 1440
                })
                res.send(token)
            } else {
                res.json({ error: "User does not exist" })
            }
        } else {
            res.json({ error: "User does not exist" })
        }
    })
.catch(err => {
    res.send('error: ' + err)
})
})

router.get('/', function (req, res) {
    User.find({}, function (err, users) {
        if (err) return res.status(500).json({
            "error": "Error encountered Please try again."
        });
        res.status(200).json({
            "data": users
        });
    });
});
module.exports = router;