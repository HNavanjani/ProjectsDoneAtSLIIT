const mongoose = require("mongoose");

const Schema = mongoose.Schema;

// Create Schema

const usertravelDetailsSchema = new Schema({
    userID: {
        type: String,
        required: true
    },
    journeryDate: {
        type: Date,
        required: true
    },
    startingLocation: {
        type: String,
        required: true
    },
    destinationLocation: {
        type: String,
        required: true
    },
    distance: {
        type: Number,
        required: true
    },
    fare: {
        type: Number,
        required: true
    },
    routeID: {
        type: String,
        required: true
    }

});


module.exports = mongoose.model('historyuser', usertravelDetailsSchema);
