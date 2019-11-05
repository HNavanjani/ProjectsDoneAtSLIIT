const express = require("express");
const app = express();
const morgan = require("morgan");
const bodyPorser = require("body-parser");
const mongoose = require("mongoose");
const cors = require('cors');

//file upload
const fileUpload = require('express-fileupload');
const path = require('path');
const crypto = require('crypto');
const multer = require('multer');
const GridFsStorage = require('multer-gridfs-storage');
const Grid = require('gridfs-stream');
const methodOverride = require('method-override');


const instructorAddAssignment = require("./routes/instructor/addassignments");
const admin = require("./routes/admin/adminRoutes");
const instructor = require("./routes/instructor/instructorRoutes");
const instructorAddExam=require("./routes/instructor/addexams");
const markAssignment=require("./routes/instructor/marksassignments");
const markExam=require("./routes/instructor/marksexams");

mongoose.connect(
  "mongodb+srv://tharuka:tharuka12345@afprojectstartsmart-ycawy.mongodb.net/test?retryWrites=true&w=majority",
  {
    useNewUrlParser: true
  }
);

app.use(morgan("dev"));
app.use(bodyPorser.urlencoded({ extended: false }));
app.use(bodyPorser.json());
app.use(cors());

//file upload
app.use(fileUpload());
app.use(methodOverride('_method'));


app.use("/addassignment", instructorAddAssignment);
app.use("/admin", admin);
app.use("/instructor", instructor);
app.use("/addexam",instructorAddExam);
app.use("/markassignment",markAssignment);
app.use("/markexam",markExam);

app.use((req, res, next) => {
  const error = new Error("Not Found");
  error.status = 404;
  next(error);
});

//file upload
let gfs; //init gfs

/*conn.once('open', () => {
  //init stream
  gfs = Grid(mongoose.mongo);
  gfs.collection('uploads'); //mongodb collection
})*/
//file upload -- create storage engine
/*const storage = new GridFsStorage({
  url: 'mongodb+srv://tharuka:tharuka12345@afprojectstartsmart-ycawy.mongodb.net/test?retryWrites=true&w=majority',
  file: (req, file) => {
    return new Promise((resolve, reject) => {
      crypto.randomBytes(16, (err, buf) => {
        if (err) {
          return reject(err);
        }
        const filename = buf.toString('hex') + path.extname(file.originalname);
        const fileInfo = {
          filename: filename,
          bucketName: 'uploads'
        };
        resolve(fileInfo);
      });
    });
  }
});
const upload = multer({ storage });*/

app.get("/", (req, res, next) => {
  res.status(200).json({
    message: "its working"
  });
});
app.use((error, req, res, next) => {
  res.status(error.status || 500);
  res.json({
    error: {
      message: error.message
    }
  });
});

/*
//@route POST /upload
//@desc Uploads file to DB
app.post('/upload', upload.single('file'), (req,res) => {
  console.log(req.body);
  res.json({file: req.file});
  //res.redirect('/');
});
*/
//file upload endpoint
app.post('/upload', (req,res) => {
  if(req.files == null){
    return res.status(400).json({msg: 'No File Uploaded'});
  }
  const file = req.files.file;

  file.mv(`${__dirname}/../smartclient/public/uploads/${file.name}`, err => {
    if (err){
      console.error(err);
      return res.status(500).send(err);
    }

    res.json({ fileName: file.name, filePath: `/uploads/${file.name}`});
  })
});


module.exports = app;
