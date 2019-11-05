const mongoose = require("mongoose");

const Schema = mongoose.Schema;

// Create Schema

const vehicleDetailsSchema = new Schema({
    _id: mongoose.Schema.Types.ObjectId,

    Regnumber: {
        type: String,
        required: true
    },
    name: {
        type: String,
        required: true
    },
    routeID: {
        type: String,
        required: true
    },
    DriverID: {
        type: String,
        required: true
    },
    type: {
        type: String,
        required: true
    }
});

module.exports = mongoose.model('vehicle', vehicleDetailsSchema);