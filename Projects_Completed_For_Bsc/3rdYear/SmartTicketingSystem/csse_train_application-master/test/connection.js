const mongoose = require("mongoose");

mongoose.Promise = global.Promise;

before(function(done) {
  this.timeout(500000);

  mongoose.connect(
  "mongodb+srv://admin:admin123@cssetraindb-sqygr.mongodb.net/test?retryWrites=true&w=majority",
    //"mongodb://localhost/csse_1",

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
