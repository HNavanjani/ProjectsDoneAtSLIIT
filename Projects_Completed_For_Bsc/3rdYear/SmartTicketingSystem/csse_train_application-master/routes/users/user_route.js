  const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');

const User = require('../../model/users/user');
const Manager = require('../../model/users/manager');
const Localpassenger = require('../../model/users/local_passenger');
const Foreignpassenger = require('../../model/users/foreign_passenger');
const Inspector = require('../../model/transportManager/inspectors');
const constants=require('../../constants');

//Sign Up
router.post('/signup', (req, res, next) => {

    //take date after one month
   /* var todayDate = new Date();
    console.log(todayDate);
    var dd = todayDate.getDate();
    var mm = todayDate.getMonth() + 1;
    console.log(mm);
    var y = todayDate.getFullYear();

    var dateAfterOneMonth = dd + '/'+ mm + '/'+ y;*/
    var n=1; //number of months to add.
    var today=new Date(); //Today's Date
    var dateAfterOneMonth=new Date(today.getFullYear(),today.getMonth()+n,today.getDate());

    //check input email is already available
    User.find({email: req.body.email})
        .exec()
        .then(user => {
            if(user.length >= 1){
                return res.status(409).json({
                    message: 'Email already exists'
                });
            } else {
                //hash the password
                bcrypt.hash(req.body.password, 10, (err, hash) => {
                    if (err){
                        return res.status(500).json({
                            error: err
                        });
                    } else {
                        const user = new User({
                            _id: new mongoose.Types.ObjectId(), //constructor function automatically create and give a new & unique id
                            uname: req.body.uname,
                            email: req.body.email,
                            password: hash,
                            utype: req.body.utype
                        });
                        user
                            .save()
                            .then(result => {
                               // console.log(result._id)
                                const id_user = result._id
                                console.log(id_user)
                                //save manager data
                                if(result.utype = 1){
                                    const manager = new Manager({
                                        _id: new mongoose.Types.ObjectId(), //construcyor function automatically create and give a new & unique id
                                        managerName: req.body.managerName,
                                        ManagerAge: req.body.ManagerAge,
                                        refUserId: id_user
                                    });
                                    manager
                                        .save()
                                }
                                //save local passenger data
                                if(result.utype = 2){
                                    const localpassenger = new Localpassenger({
                                        _id: new mongoose.Types.ObjectId(), //construcyor function automatically create and give a new & unique id
                                        lPassengerName: req.body.lPassengerName,
                                        lPassengerAge: req.body.lPassengerAge,
                                        lPassengerPhone: req.body.lPassengerPhone,
                                        lPassengerNic: req.body.lPassengerNic,
                                        loanstatus: constants.LOAN_STATUS,
                                        finestatus: constants.FINE_STATUS,
                                        cardtype: req.body.cardtype,
                                        cardnumber: req.body.cardnumber,
                                        amount: constants.INITIAL_AMOUNT,
                                        initialamountstatus: constants.INITIAL_AMAOUNT_STATUS,
                                        loanamount: constants.LOAN_AMOUNT,
                                        fineamount: constants.FINE_AMOUNT,
                                        refUserId: id_user
                                    });
                                    localpassenger
                                        .save()
                                }
                                //save foreign user
                                if(result.utype = 3){
                                    const foreignpassenger = new Foreignpassenger({
                                        _id: new mongoose.Types.ObjectId(), //construcyor function automatically create and give a new & unique id
                                        fPassengerName: req.body.fPassengerName,
                                        fPassengerAge: req.body.fPassengerAge,
                                        fPassengerPassportNumber: req.body.fPassengerPassportNumber,
                                        finestatus: constants.FINE_STATUS,
                                        cardtype: req.body.cardtype,
                                        cardnumber: req.body.cardnumber,
                                        amount: constants.INITIAL_AMOUNT,
                                        initialamountstatus: constants.INITIAL_AMAOUNT_STATUS,
                                        fineamount: constants.FINE_AMOUNT,
                                        expireDate: dateAfterOneMonth,
                                        refUserId: id_user
                                    });
                                    foreignpassenger
                                        .save()
                                }
                                //save inspector
                                if(result.utype = 4){
                                    const inspector = new Inspector({
                                        _id: new mongoose.Types.ObjectId(), //construcyor function automatically create and give a new & unique id
                                        assignedroute: req.body.assignedroute,
                                        username: req.body.uname,
                                        password: hash,
                                        name: req.body.name,
                                        emailaddress: req.body.email,
                                        phone: req.body.phone,
                                        refUserId: id_user
                                    });
                                    inspector
                                        .save()
                                }
                                res.status(201).json({
                                    message: 'User has been created',
                                })
                            })
                            .catch(err => {
                                console.log(err)
                                res.status(500).json({
                                    error: err
                                })
                            });
                    }
                })
            }
        })
        .catch();
});

//Sign In
router.post('/login', (req, res, next) => {
    User.find({email: req.body.email})
        .exec()
        .then(user => {
            if(user.length < 1){
                return res.status(404).json({
                    message: 'Authentication Failed'
                });
            }
            bcrypt.compare(req.body.password, user[0].password, (err, result) => {
                if (err){
                    return res.status(401).json({
                        message: 'Authentication Failed'
                    });
                }
                if(result){
                   const token = jwt.sign({
                        email: user[0].email,
                        userId: user[0]._id
                    },
                    process.env.JWT_KEY,
                        {
                            expiresIn: "1h"
                        },

                        );
                    return res.status(200).json({
                        message: 'Authentication successful',
                        token: token,
                        utype: user[0].utype,
                        id: user[0]._id
                    });
                }
                return res.status(401).json({
                    message: 'Authentication Failed'
                });
            })
        })
        .catch(err => {
            console.log(err)
            res.status(500).json({
                error: err
            })
        });
});
//get users
router.get("/", (req, res, next) => {
    User.find()
        .select("_id uname email password utype")
        .exec()
        .then(docs => {
            const response = {
                count: docs.length,
                user: docs.map(doc => {
                    return {
                        _id:doc._id,
                        uname: doc.uname,
                        email: doc.email,
                        password: doc.password,
                        utype: doc.utype
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


//delete user
router.delete("/:userId", (req, res, next) => {
   User.remove({ _id: req.params.userId })
       .exec()
       .then(result => {
           res.status(200).json({
               message: 'User has been deleted'
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