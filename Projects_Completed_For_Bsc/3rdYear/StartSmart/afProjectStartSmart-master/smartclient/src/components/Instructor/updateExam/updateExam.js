import React, { Component } from 'react';

class UpdateAssignment extends Component{

    updateassignmentss(e){

        e.preventDefault();
        console.log(this.refs.cname.value);
        console.log(this.refs.exid.value);
        console.log(this.refs.date.value);

    }

    render(){
        return(
            <div>
            <div>
            <h1>Edit Exam</h1>
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
            <label>Exam ID</label>
        <input
        type="text"
        name="subjectname"
        className="form-control"
        ref="exid"
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
                Update Exam
              </button>
            </div>
            </form>
            </div>
            </div>
    )
    }
}
export default UpdateAssignment;