const mongoose= require('mongoose');
const addinstructorSchema = mongoose.Schema({
    //_id:mongoose.Schema.Types.ObjectId,
    cname:{type:String,required:true},
    subname:{type:String,required:true},
    assignmentNumber:{type:Number, required:true},
    assignment:{type:String,required:true},
    date:{type:String,required:true}
    
    });
    module.exports = mongoose.model('addinstructors', addinstructorSchema);