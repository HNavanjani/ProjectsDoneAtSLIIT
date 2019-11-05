const express = require("express");
const app = express();
const morgan = require("morgan");
const bodyPorser = require("body-parser");
const mongoose = require("mongoose");
const cors = require("cors");

//Importing routes
const train = require("./routes/admin/trains");
const Driver =require("./routes/admin/Driver_route");
const Vehicle =require("./routes/admin/Vehicle_route");
const userhistroy = require("./routes/users/User_trvl_histry_route");
const routedetails_ = require("./routes/admin/Route_details_route");
const UserRoutes = require("./routes/users/user_route");
const ManagerRoutes = require("./routes/users/managerroute");
const addcredits = require("./routes/local_passenger/add_credits");
const extendexpiredate = require("./routes//foreign_passenger/extend_expiary_date");
const applyloan = require("./routes/local_passenger/apply_loan");
const addfine = require("./routes/local_passenger/apply_loan");
const LocalPassenger = require("./routes/users/local_passengerroute");
const ForeignPassenger = require("./routes/users/foreign_passenger_route");
const getlocalusers = require("./routes/local_passenger/get_local_user_details");
const getforeignusers=require("./routes/foreign_passenger/get_foreign_user_details");
const journeyDetails=require("./routes/local_passenger/journey_details");
const forignfine=require("./routes/foreign_passenger/updatefine");

//db connection

mongoose.connect(
  "mongodb+srv://admin:admin123@cssetraindb-sqygr.mongodb.net/test?retryWrites=true&w=majority",
  // "mongodb://localhost/csse_1",
  {
    useNewUrlParser: true
  }
);




//use of dependencies
app.use(morgan("dev"));
app.use(bodyPorser.urlencoded({ extended: false }));
app.use(bodyPorser.json());
app.use(cors());





//use of routes
app.use("/train", train);
app.use("/availabletrains", train);
app.use("/addcredits", addcredits);
app.use("/extentexpiarydate", extendexpiredate);
app.use("/applyloan", applyloan);
app.use("/addfine", addfine);
app.use("/localusers", applyloan);
app.use("/api", require("./routes/api/inspectors"));
app.use("/api", require("./routes/api/journeyDetails"));
app.use("/api", require("./routes/api/invalidjourneydetails"));
app.use("/api", require("./routes/api/fineinformation"));
app.use("/user", UserRoutes);
app.use("/manager", ManagerRoutes);
app.use("/localPassenger", LocalPassenger);
app.use("/localPassenger/addfine", LocalPassenger);
app.use("/foreignPassenger", ForeignPassenger);
app.use("/getlocalpassengers", getlocalusers);
app.use("/localpassengers", require("./routes/users/local_passengerroute"));
app.use("/journeyDetails",journeyDetails);
app.use("/getforeignusers",getforeignusers);
app.use("/forignfine",forignfine);


//error handling middleware
app.use(function(err, req, res, next) {
  res.status(422).send({ error: err.message });
});

app.use((req, res, next) => {
  const error = new Error("Not Found");
  error.status = 404;
  next(error);
});

module.exports = app;
