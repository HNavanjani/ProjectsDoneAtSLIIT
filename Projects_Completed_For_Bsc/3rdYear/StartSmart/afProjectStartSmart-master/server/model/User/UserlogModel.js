const mongoose= require('mongoose');
const users = mongoose.Schema({
    name:{type:String,required:true},
    password:{type:String,required:true},
    type:{type:String, required:true},

});
module.exports = mongoose.model('users', users);