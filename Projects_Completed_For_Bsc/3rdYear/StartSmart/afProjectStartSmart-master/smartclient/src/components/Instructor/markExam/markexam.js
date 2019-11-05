import React, { Component } from 'react';
import axios from "axios";

class markExam extends Component{

    entermarks(e){

        e.preventDefault();
        var extype=this.refs.extype.value;
        var exid=this.refs.exid.value;
        var std=this.refs.std.value;
        var cname=this.refs.cname.value;
        var subname=this.refs.subname.value;
        var marks=this.refs.marks.value;

        axios.post(
            "http://localhost:5000/markexam",
            {
                examtype: extype,
                examid: exid,
                std: std,
                cname: cname,
                subname: subname,
                marks: marks
            },
            { headers: { Accept: "application/json" } }
          );
          console.log("posted");

    }

    render(){
        return(
            <div>
            <div>
            <h1>Assign Marks</h1>
            </div>
            <div className="container">
            <form className="form">
            <div className="form-group">
            <label>Exam Type</label>
        <input
        type="text"
        name="coursename"
        className="form-control" 
        ref="extype"
            />
            </div>
            <div className="form-group">
            <label>Exam ID</label>
        <input
        type="text"
        name="subjectname"
        className="form-control"
        ref="exid"
            />
            </div>
            <div className="form-group">
            <label>Student ID number</label>
        <input
        type="text"
        name="subjectname"
        className="form-control"
        ref="std"
            />
            </div>
            
            <div className="form-group">
            <label>Course Name</label>
        <input
        type="text"
        name="subjectname"
        className="form-control"
        ref="cname"
            />
            </div>
            <div className="form-group">
            <label>Subject Name</label>
        <input
        type="text"
        name="subjectname"
        className="form-control"
        ref="subname"
            />
            </div>
            <div className="form-group">
            <label>Marks</label>
        <input
        type="text"
        name="subjectname"
        className="form-control"
        ref="marks"
            />
            </div>

            <div className="form-group">
            <button
                type="button"
                className="btn btn-warning btn-block"
                onClick={this.entermarks.bind(this)}
              >
                Enter Marks
              </button>
            </div>
            </form>
            </div>
            </div>
    )
    }
}
export default markExam;