const express = require("express");
const user = express.Router();
const jwt = require("jsonwebtoken");
const bcrypt = require("bcrypt");

const User = require("../../model/User/UserlogModel")


process.env.SECRET_KEY = 'secret'

user.post('/', (req, res) => {
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
})
})

user.post('/login', (req, res) => {
    User.findOne({
        name: req.body.name
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