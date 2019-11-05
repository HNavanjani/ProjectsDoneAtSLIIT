const mongoose = require('mongoose');

const managerSchema = mongoose.Schema({
    _id: mongoose.Schema.Types.ObjectId,
    managerName: { type: String, required: true },
    ManagerAge: { type: Number, required: true },
    refUserId: { type: String, required: true }
});

module.exports = mongoose.model('Manager', managerSchema);