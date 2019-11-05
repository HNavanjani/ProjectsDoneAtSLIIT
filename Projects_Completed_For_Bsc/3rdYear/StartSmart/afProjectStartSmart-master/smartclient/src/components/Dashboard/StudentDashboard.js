import React, {Component} from "react";
import { Container, Button, ButtonGroup, Modal, ModalHeader, ModalBody, ModalFooter } from "reactstrap";
//import { BrowserRouter as Router, Route, Link, Switch, Redirect, NavLink } from 'react-router-dom';

import ViewAssignmentAndUpload from "../../components/Student/viewAssignmentAndUpload/viewAssignmentAndUpload";
import ViewExamAndUpload from "../../components/Student/viewExamAndUpload/viewExamAndUpload";

class StudentDashboard extends Component {

    constructor(){
        super();

        this.state = {
            visibleUploadAssignment: false,
            visibleUploadExam: false
        };
        this.state = {
            modalUploadAssignment: false,
            modalUploadExam: false
        };

        this.toggleUploadAssignment = this.toggleUploadAssignment.bind(this);
        this.toggleUploadExam = this.toggleUploadExam.bind(this);

    }
    toggleUploadAssignment() {
        this.setState(prevState => ({
            modalUploadAssignment: !prevState.modalUploadAssignment
        }));
    }
    toggleUploadExam() {
        this.setState(prevState => ({
            modalUploadExam: !prevState.modalUploadExam
        }));
    }

 render() {
     return (
         <Container>
         <ButtonGroup>
         <Button size="md" color="info" onClick={this.toggleUploadAssignment}>
         Assignments
         </Button>
         <Modal
     isOpen={this.state.modalUploadAssignment}
     toggle={this.toggleUploadAssignment}
     className={this.props.className}
         >
         <ModalHeader toggle={this.toggleUploadAssignment}>Assignments</ModalHeader>
         <ModalBody>
         <ViewAssignmentAndUpload />
         </ModalBody>
         <ModalFooter>
         <Button color="secondary" onClick={this.toggleUploadAssignment}>
         Cancel
         </Button>
         </ModalFooter>
         </Modal>
         <Button size="md" color="info" onClick={this.toggleUploadExam}>
         Exams
         </Button>
         <Modal
     isOpen={this.state.modalUploadExam}
     toggle={this.toggleUploadExam}
     className={this.props.className}
         >
         <ModalHeader toggle={this.toggleUploadExam}>Exams</ModalHeader>
         <ModalBody>
         <ViewExamAndUpload />
         </ModalBody>
         <ModalFooter>
         <Button color="secondary" onClick={this.toggleUploadExam}>
         Cancel
         </Button>
         </ModalFooter>
         </Modal>
         </ButtonGroup>
         </Container>
 );
 }
};

export default StudentDashboard;
