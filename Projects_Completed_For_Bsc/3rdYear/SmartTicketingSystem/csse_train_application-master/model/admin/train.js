const mongoose = require('mongoose');
const trainScema = mongoose.Schema({
    _id: mongoose.Schema.Types.ObjectId,
    routeID: { type: String, required: true },
    startstation: { type: String, required: true },
    destination: { type: String, required: true },
    distance: { type: Number, required: true },
    fare: { type: Number, required: true }
});

module.exports = mongoose.model('trains', trainScema);
