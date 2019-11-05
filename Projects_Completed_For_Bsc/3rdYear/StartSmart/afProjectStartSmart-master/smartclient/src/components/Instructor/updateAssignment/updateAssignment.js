import React, { Component } from 'react';
import axios from "axios";
class UpdateAssignment extends Component{

    updateassignmentss(e){

        e.preventDefault();
        var cname=this.refs.cname.value;
        var subname=this.refs.subname.value;
        var assnum=this.refs.assnum.value;
        var date=this.refs.date.value;


        axios.get("http://localhost:5000/addassignment/id/"+assnum).then(response => {
      

      var result=response.data.result;
      var postcname=result.cname;
      var postsubname=result.subname;
      var postassnum=result.assignmentNumber; 
      var postasse=result.assignment;
      var postdate=date;
      axios.delete("http://localhost:5000/addassignment/"+assnum).then(response=>{
          console.log(response);
      });

      axios.post(
        "http://localhost:5000/addassignment",
        {
            cname: postcname,
            subname: postsubname,
            assignmentNumber: postassnum,
            assignment: postasse,
            date: postdate
        },
        { headers: { Accept: "application/json" } }
      );
      console.log("posted");
    });
    }

    render(){
        return(
            <div>
            <div>
            <h1>Edit Assignment</h1>
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
            <label>Assignment Number</label>
        <input
        type="text"
        name="assignmentnumber"
        className="form-control"
        ref="assnum"
            />
            </div>
            <div className="form-group">
              <label>Due Date</label>
              <input type="date" 
              name="duedate" 
              className="form-control" 
              ref="date" />
            </div>

            <div className="form-group">
            <button
                type="button"
                className="btn btn-warning btn-block"
                onClick={this.updateassignmentss.bind(this)}
              >
                Update Assignment
              </button>
            </div>
            </form>
            </div>
            </div>
    )
    }
}
export default UpdateAssignment;