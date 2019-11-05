const mongoose = require("mongoose");
const User = mongoose.Schema({
    name: { type: String, required: true },
    password: { type: String, required: true },
    type: { type: String, required: true },

});
module.exports = mongoose.model("users", User);
