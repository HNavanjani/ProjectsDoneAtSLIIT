import React, { Component } from 'react';
import FileUpload from './fileUpload';
import axios from 'axios';

class ViewAssignmentAndUpload extends Component{

    constructor(){
        super();
        this.state = {
            assignment: []
        }
    }

    componentDidMount(){
        //e.preventDefault();
        axios.get('http://localhost:5000/addassignment').then(response => {
            //console.log(response.data.assignment);
           this.setState({
               assignment: response.data.assignment
           })
        })
    }

    render() {
        let assignment = this.state.assignment.map((assignment) => {
            return(
                <tr class="table-primary" key={assignment.id}>
                <td>{assignment.cname}</td>
                <td>{assignment.subname}</td>
                <td>{assignment.assignment}</td>
                <td>{assignment.date}</td>
            </tr>
        )
        });
        return (
            <div className="container">
            <h2> Available Assignments</h2>
        <table className="table table-hover">
            <thead>
            <tr className="table-secondary">
            <th scope="col">Course Name</th>
            <th scope="col">Subject Name</th>
            <th scope="col">Available Assignment</th>
            <th scope="col">Due Date</th>
            </tr>
            </thead>
            <tbody>
            {assignment}
            </tbody>
            </table>
            <div className="container mt-4">
            <h2 className="display-4 text-center mb-4">
            Upload Assignment
            </h2>
            <FileUpload />
            </div>
    </div>
    );
    }
}
export default ViewAssignmentAndUpload;