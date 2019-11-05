const mongoose = require('mongoose');

const localPassengerSchema = mongoose.Schema({
    _id: mongoose.Schema.Types.ObjectId,
    lPassengerName: { type: String, required: true },
    lPassengerAge: { type: Number, required: true },
    lPassengerPhone: { type: String, required: true },
    lPassengerNic: { type: String, required: true },
    loanstatus: { type: Number, required: true },
    finestatus: { type: Number, required: true },
    cardtype: { type: String, required: true },
    cardnumber: { type: Number, required: true },
    amount: { type: Number, required: true },
    initialamountstatus: { type: Number, required: true },
    loanamount: { type: Number, required: true },
    fineamount: { type: Number, required: true },
    refUserId: { type: String, required: true }
});

module.exports = mongoose.model('Localpassenger', localPassengerSchema);