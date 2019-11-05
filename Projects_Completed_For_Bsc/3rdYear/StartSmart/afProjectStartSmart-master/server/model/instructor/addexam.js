const mongoose= require('mongoose');
const addexam = mongoose.Schema({
    _id:mongoose.Schema.Types.ObjectId,
    examid:{type:Number,required:true},
    examtype:{type:String,required:true},
    subname:{type:String, required:true},
    year:{type:Number,required:true},
    sem:{type:Number,required:true},
    content:{type:String,required:true},
    date:{type:String,required:true}
    
    });
    module.exports = mongoose.model('addexam', addexam);