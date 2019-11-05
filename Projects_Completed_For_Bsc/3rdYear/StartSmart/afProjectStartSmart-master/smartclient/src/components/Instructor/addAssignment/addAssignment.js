import React, { Component } from "react";
import { Container, Button, ButtonGroup } from "reactstrap";
import axios from "axios";

class AddAssignment extends Component {
  addassignmentss(e) {
    e.preventDefault();
    var cnamee=this.refs.crsName.value;
    var subnamee=this.refs.subName.value;
    var assnum=this.refs.assNum.value;
    var ass=this.refs.ass.value;
    var date=this.refs.date.value;
    var d1 = new Date();
    var m1=d1.getMonth();
    var curdate=d1.getFullYear();
    var d2 = new Date(date);
    var m2=d2.getMonth();
    var duedate=d2.getDay();
    
    console.log(d1);
    console.log(curdate+"  and  "+duedate);
    if(m1 < m2) {
        console.log("greater");
    } 
    else {
        console.log("a NOT equals b");
    }

    axios.post(
        "http://localhost:5000/addassignment",
        {
            cname: cnamee,
            subname: subnamee,
            assignmentNumber: assnum,
            assignment: ass,
            date: date
        },
        { headers: { Accept: "application/json" } }
      );
      console.log("posted");

    axios.get("http://localhost:5000/addassignment").then(response => {
      console.log(response.data);
    });
  }
  render() {
    return (
      <Container>
        <div>
          <h1>Generate Assignment</h1>
        </div>
        <div className="container">
          <form className="form">
            <div className="form-group">
              <label>Course Name</label>
              <input type="text" name="coursename" className="form-control" ref="crsName" />
            </div>
            <div className="form-group">
              <label>Subject Name</label>
              <input type="text" name="subjectname" className="form-control" ref="subName" />
            </div>
            <div className="form-group">
              <label>Assignment Number</label>
              <input
                type="text"
                name="assignmentnumber"
                className="form-control"
                ref="assNum"
              />
            </div>
            <div className="form-group">
              <label>Assignment</label>
              <textarea rows="4" cols="30" ref="ass">

</textarea>
            </div>
            <div className="form-group">
              <label>Due Date</label>
              <input type="date" name="duedate" className="form-control" ref="date" />
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
export default AddAssignment;
