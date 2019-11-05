const mongoose = require('mongoose');
const practiseScema = mongoose.Schema({
    _id: mongoose.Schema.Types.ObjectId,
    name: { type: String, required: true },
    age: { type: Number, required: true }
});

module.exports = mongoose.model('practiseScema', practiseScema);
