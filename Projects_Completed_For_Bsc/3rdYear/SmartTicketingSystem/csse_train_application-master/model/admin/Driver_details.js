const mongoose = require("mongoose");

const Schema = mongoose.Schema;

// Create Schema

const DriverDetailsSchema = new Schema({
    _id: mongoose.Schema.Types.ObjectId,

    DiverID: {
        type: String,
        required: true
    },
    nameofDriver: {
        type: String,
        required: true
    },
    Address: {
        type: String,
        required: true
    },
    Phone: {
        type: String,
        required: true
    }

});

module.exports = mongoose.model('Driver', DriverDetailsSchema);