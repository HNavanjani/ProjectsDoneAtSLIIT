const mongoose = require("mongoose");
const Schema = mongoose.Schema;

//create inspectors schema and model
const trscema = new Schema({
  assignedroute: {
    type: String,
    required: [true, "Assigned Route field is required"]
  },
  username: {
    type: String,
    required: [true, "Username field is required"]
  },
  password: {
    type: String,
    default: "123"
  },
  name: {
    type: String,
    required: [true, "Name field is required"]
  },
  emailaddress: {
    type: String,
    required: [true, "Email address field is required"]
  },
  phone: {
    type: String,
    required: [true, "Phone field is required"]
  }
});

const Inspectors = mongoose.model("trscema", trscema);

module.exports = Inspectors;
