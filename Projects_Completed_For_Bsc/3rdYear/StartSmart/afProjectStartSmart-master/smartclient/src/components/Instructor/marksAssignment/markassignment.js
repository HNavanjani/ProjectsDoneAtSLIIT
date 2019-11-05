import React, { Component } from 'react';
import axios from "axios";

class markAssignment extends Component{

    entermarks(e){

        e.preventDefault();
        var cname=this.refs.cname.value;
        var subname=this.refs.subname.value;
        var std=this.refs.std.value;
        var assnum=this.refs.assnum.value;
        var marks=this.refs.marks.value;

        axios.post(
            "http://localhost:5000/markassignment",
            {
                cname: cname,
                subname: subname,
                assnumber: assnum,
                std: std,
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
            <label>Course Name</label>
        <input
        type="text"
        name="coursename"
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
            <label>Student ID number</label>
        <input
        type="text"
        name="subjectname"
        className="form-control"
        ref="std"
            />
            </div>
            
            <div className="form-group">
            <label>Assignment Number</label>
        <input
        type="text"
        name="subjectname"
        className="form-control"
        ref="assnum"
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
export default markAssignment;