import React, { Component } from "react";
import { Container, Button, ButtonGroup } from "reactstrap";
import axios from "axios";

class AddExam extends Component {
  addassignmentss(e) {
    e.preventDefault();
    var exid = this.refs.exid.value;
    var extype = this.refs.extype.value;
    var subName = this.refs.subName.value;
    var year = this.refs.year.value;
    var sem = this.refs.sem.value;
    var content = this.refs.content.value;
    var date = this.refs.date.value;

    var d1 = new Date();
    var m1 = d1.getMonth();
    var curdate = d1.getFullYear();
    var d2 = new Date(date);
    var m2 = d2.getMonth();
    var duedate = d2.getDay();

    axios.post(
      "http://localhost:5000/addexam",
      {
        examid: exid,
        examtype: extype,
        subname: subName,
        year: year,
        sem: sem,
        content: content,
        date: date
      },
      { headers: { Accept: "application/json" } }
    );
    console.log("posted");

  }
  render() {
    return (
      <Container>
        <div>
          <h1>Generate Exams</h1>
        </div>
        <div className="container">
          <form className="form">
            <div className="form-group">
              <label>Exam ID</label>
              <input
                type="text"
                name="coursename"
                className="form-control"
                ref="exid"
              />
            </div>
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
              <label>Subject Name</label>
              <input
                type="text"
                name="subjectname"
                className="form-control"
                ref="subName"
              />
            </div>
            <div className="form-group">
              <label>Year</label>
              <input
                type="text"
                name="assignmentnumber"
                className="form-control"
                ref="year"
              />
            </div>
            <div className="form-group">
              <label>Semester</label>
              <input
                type="text"
                name="assignmentnumber"
                className="form-control"
                ref="sem"
              />
            </div>
            <div className="form-group">
              <label>Content</label>
              <textarea rows="4" cols="30" ref="content" />
            </div>
            <div className="form-group">
              <label>Due Date</label>
              <input
                type="date"
                name="duedate"
                className="form-control"
                ref="date"
              />
            </div>
            <div className="form-group">
              <button
                type="button"
                className="btn btn-warning btn-block"
                onClick={this.addassignmentss.bind(this)}
              >
                Generate Assignments
              </button>
            </div>
          </form>
        </div>
      </Container>
    );
  }
}
export default AddExam;
