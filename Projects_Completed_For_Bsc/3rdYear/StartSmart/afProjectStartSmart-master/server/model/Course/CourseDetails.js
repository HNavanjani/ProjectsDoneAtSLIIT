const mongoose = require("mongoose");
const coursedetails = mongoose.Schema({

    coursename: { type: String, required: true },
    duration: { type: String, required: true },
    numcredits: { type: String, required: true },
    numsubjects: { type: String, required: true },
    numsemester: { type: String, required: true  },
    semprice: { type: Number, required: true  },
    subdetails: { type: String, required: true  }
});
module.exports = mongoose.model("coursedetails", coursedetails);
