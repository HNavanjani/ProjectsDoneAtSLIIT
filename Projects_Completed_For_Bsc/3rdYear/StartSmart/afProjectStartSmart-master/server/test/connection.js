const mongoose = require("mongoose");
mongoose.Promise = global.Promise;
before(function(done) {
    this.timeout(30000);
    mongoose.connect(
        "mongodb+srv://tharuka:tharuka12345@afprojectstartsmart-ycawy.mongodb.net/test?retryWrites=true&w=majority",
        {
            useNewUrlParser: true
        }
    );
    mongoose.connection
        .once("open", function() {
            console.log("Successfully Connected to the Database");
            done();
        })
        .on("error", function(error) {
            console.log.log(error);
        });
});