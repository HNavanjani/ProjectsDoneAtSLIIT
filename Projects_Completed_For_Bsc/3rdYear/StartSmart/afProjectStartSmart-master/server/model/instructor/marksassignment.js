const mongoose= require('mongoose');
const marksassignment = mongoose.Schema({
    _id:mongoose.Schema.Types.ObjectId,
    cname:{type:String,required:true},
    subname:{type:String,required:true},
    assnumber:{type:Number, required:true},
    std:{type:String,required:true},
    marks:{type:Number,required:true}
    
    });
    module.exports = mongoose.model('marksassignment', marksassignment);