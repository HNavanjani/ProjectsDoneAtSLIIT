const mongoose= require('mongoose');
const markexam = mongoose.Schema({
    _id:mongoose.Schema.Types.ObjectId,
    examtype:{type:String,required:true},
    examid:{type:Number,required:true},
    std:{type:String, required:true},
    cname:{type:String,required:true},
    subname:{type:String,required:true},
    marks:{type:Number,required:true}
    
    });
    module.exports = mongoose.model('markexam', markexam);