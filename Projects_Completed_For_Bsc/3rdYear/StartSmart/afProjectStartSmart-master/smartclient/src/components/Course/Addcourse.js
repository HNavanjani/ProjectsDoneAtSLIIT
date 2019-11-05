import React,{Component} from 'react';
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import axios from "axios";

class Addcourse extends Component{

    constructor(props) {
        super(props);

        this.onusername = this.onusername.bind(this);
        this.onduration = this.onduration.bind(this);
        this.oncredits = this.oncredits.bind(this);
        this.onsubjects = this.onsubjects.bind(this);
        this.onsemester = this.onsemester.bind(this);
        this.onprice = this.onprice.bind(this);
        this.ondetails = this.ondetails.bind(this);

        this.state = {
            coursename:"",
            courseduration:"",
            credits:"",
            subjects:"",
            semester:"",
            semesterprice:"",
            subjdetails:""

        };

    }
    onusername(e) {
        this.setState({ coursename: e.target.value });
    }
    onduration(e) {
        this.setState({ courseduration: e.target.value });
    }
    oncredits(e) {
        this.setState({ credits: e.target.value });
    }
    onduration(e) {
        this.setState({ subjects: e.target.value });
    }
    onsubjects(e) {
        this.setState({ semester: e.target.value });
    }
    onsemester(e) {
        this.setState({ semesterprice: e.target.value });
    }
    onprice(e) {
        this.setState({ subjdetails: e.target.value });
    }

    onSubmit(e) {
        e.preventDefault();

        const course = {
            coursename: this.state.coursename,
            courseduration: this.state.courseduration,
            credits: this.state.credits,
            subjects: this.state.subjects,
            semester: this.state.semester,
            semesterprice: this.state.semesterprice,
            subjdetails: this.state.subjdetails
        };
        axios
            .post("http://localhost:5000/course", course)
            .then(res => console.log(res.data));

        this.state = {
            coursename:"",
            courseduration:"",
            credits:"",
            subjects:"",
            semester:"",
            semesterprice:"",
            subjdetails:""

        };
    }

    render(){
        return(
            <div className="container">

                <div className="paddingcenter">
                    <fieldset>
                        <legend>Course Creating</legend>
                        <Form.Label>Course Name</Form.Label>
                        <Form.Control placeholder="Enter Course Name" md="3" value={this.state.coursename} onChange={this.onusername} name="coursename"/>
                        <br></br>
                        <Form.Label>Course Duration</Form.Label>
                        <Form.Control placeholder="Enter Course Duration" md="3"  value={this.state.duration} onChange={this.onduration} name="courseduration"/>
                        <br></br>
                        <Form.Label>Number of Credits</Form.Label>
                        <Form.Control placeholder="Enter Number of Credits" md="3"  value={this.state.Credits} onChange={this.oncredits} name="credits"/>
                        <br></br>
                        <Form.Label>Number of Subjects</Form.Label>
                        <Form.Control component="textarea" placeholder="Enter Number of Subjects" md="3"  value={this.state.Subjects} onChange={this.onsubjects} name="subjects" />
                        <br></br>
                        <Form.Label>Number of Semester's</Form.Label>
                        <Form.Control component="textarea" placeholder="Enter Number of Semester's" md="3"  value={this.state.Semester} onChange={this.onsemester} name="semester"/>
                        <br></br>
                        <Form.Label>Course Semester Price</Form.Label>
                        <Form.Control componentclass="textarea" placeholder="Enter Course Semester Price" md="3"  value={this.state.Price} onChange={this.onprice} name="semesterprice"/>
                        <br></br>
                        <Form.Label>Course Subject Details</Form.Label>
                        <br></br>
                        <input type="textarea" name ="text" id="text" md="5"  value={this.state.Details} onChange={this.ondetails} name="subjdetails" />
                        <br></br>
                        <Button variant="outline-success">Submit</Button>
                    </fieldset>
                </div>


            </div>
        )
    }
}