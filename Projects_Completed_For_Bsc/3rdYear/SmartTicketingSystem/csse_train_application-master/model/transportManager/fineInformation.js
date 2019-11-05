const mongoose = require("mongoose");
const Schema = mongoose.Schema;

// Create Schema

const FineInformationSchema = new Schema({
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
  routeName: {
    type: String,
    required: true
  },
  day: {
    type: String
  },
  hour: {
    type: String
  },
  fine: {
    type: String
  },
  emaila: {
    type: String
  }
});

module.exports = FineInformation = mongoose.model(
  "fineInformation",
  FineInformationSchema
);
