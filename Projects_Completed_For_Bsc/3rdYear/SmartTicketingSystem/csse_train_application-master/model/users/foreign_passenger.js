const mongoose = require('mongoose');

const foreignPassengerSchema = mongoose.Schema({
    _id: mongoose.Schema.Types.ObjectId,
    fPassengerName: { type: String, required: true },
    fPassengerAge: { type: Number, required: true },
    fPassengerPassportNumber: { type: Number, required: true },
    finestatus: { type: Number, required: true },
    cardtype: { type: String, required: true },
    cardnumber: { type: Number, required: true },
    amount: { type: Number, required: true },
    initialamountstatus: { type: Number, required: true },
    fineamount: { type: Number, required: true },
    expireDate: { type: Date, required: true },
    refUserId: { type: String, required: true }
});

module.exports = mongoose.model('Foreignpassenger', foreignPassengerSchema);