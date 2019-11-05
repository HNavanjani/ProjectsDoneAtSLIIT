const mongoose = require("mongoose");
const AdminSchema = mongoose.Schema({
  _id: mongoose.Schema.Types.ObjectId,
  name: { type: String, required: true },
  email: { type: String, required: true },
  password: { type: String, required: true },
  username: { type: String, required: true },
  registeredDate: { type: Date, default: Date.now }
});
module.exports = mongoose.model("admin", AdminSchema);
