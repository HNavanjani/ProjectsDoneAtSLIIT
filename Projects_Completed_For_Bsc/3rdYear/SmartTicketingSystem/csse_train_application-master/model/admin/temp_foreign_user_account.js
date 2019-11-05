const mongoose = require('mongoose');
const tempforeignuser = mongoose.Schema({
    _id: mongoose.Schema.Types.ObjectId,
    userid: { type: String, required: true },
    finestatus: { type: Number, required: true },
    cardtype: { type: String, required: true },
    cardnumber: { type: Number, required: true },
    amount: { type: Number, required: true },
    initialamountstatus: { type: Number, required: true },
    fineamount: { type: Number, required: true },
    expirydate: { type: String, required: true }
});

module.exports = mongoose.model('tempforeignuser', tempforeignuser);