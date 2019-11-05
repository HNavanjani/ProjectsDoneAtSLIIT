const mongoose = require("mongoose");
const InstructorSchema = mongoose.Schema({
  name: { type: String, required: true },
  email: { type: String, required: true },
  password: { type: String, required: true },
  username: { type: String, required: true },
  registeredDate: { type: Date, default: Date.now }
});
module.exports = mongoose.model("instructor", InstructorSchema);
