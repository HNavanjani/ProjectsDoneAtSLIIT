const mongoose = require('mongoose');
const templocaluser = mongoose.Schema({
    _id: mongoose.Schema.Types.ObjectId,
    userid: { type: String, required: true },
    loanstatus: { type: Number, required: true },
    finestatus: { type: Number, required: true },
    cardtype: { type: String, required: true },
    cardnumber: { type: Number, required: true },
    amount: { type: Number, required: true },
    initialamountstatus: { type: Number, required: true },
    loanamount: { type: Number, required: true },
    fineamount: { type: Number, required: true }
});

module.exports = mongoose.model('templocaluser', templocaluser);