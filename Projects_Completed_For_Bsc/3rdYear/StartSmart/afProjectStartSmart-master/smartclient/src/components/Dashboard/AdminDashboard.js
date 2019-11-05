import React, { Component } from "react";
import {
  Container,
  Button,
  ButtonGroup,
  Modal,
  ModalHeader,
  ModalBody,
  ModalFooter
} from "reactstrap";

import AddAdmin from "../AddToSystem/AddAdmin";
import AddInstructor from "../AddToSystem/AddInstructor";

export default class AdminDashboard extends Component {
  constructor(props) {
    super(props);
    this.state = {
      visibleA: false,
      visibleI: false
    };
    this.state = {
      modalA: false,
      modalI: false
    };

    this.toggleA = this.toggleA.bind(this);
    this.toggleI = this.toggleI.bind(this);
  }

  toggleA() {
    this.setState(prevState => ({
      modalA: !prevState.modalA
    }));
  }

  toggleI() {
    this.setState(prevState => ({
      modalI: !prevState.modalI
    }));
  }

  render() {
    return (
      <Container>
        <ButtonGroup>
          <Button size="md" color="info" onClick={this.toggleA}>
            Add Administrators
          </Button>

          <Modal
            isOpen={this.state.modalA}
            toggle={this.toggleA}
            className={this.props.className}
          >
            <ModalHeader toggle={this.toggleA}>Add Administrators</ModalHeader>
            <ModalBody>
              <AddAdmin />
            </ModalBody>
            <ModalFooter>
              <Button color="secondary" onClick={this.toggleA}>
                Cancel
              </Button>
            </ModalFooter>
          </Modal>

          <Button size="md" onClick={this.toggleI} color="info">
            Add Instructors
          </Button>

          <Modal
            isOpen={this.state.modalI}
            toggle={this.toggleI}
            className={this.props.className}
          >
            <ModalHeader toggle={this.toggleI}>Add Instructors</ModalHeader>
            <ModalBody>
              <AddInstructor />
            </ModalBody>
            <ModalFooter>
              <Button color="secondary" onClick={this.toggleI}>
                Cancel
              </Button>
            </ModalFooter>
          </Modal>
        </ButtonGroup>
        <ButtonGroup>
          <Button size="md" color="info">
            Add Courses
          </Button>
          <br />
          <Button size="md" color="info">
            Assign Instructors
          </Button>
        </ButtonGroup>{" "}
        <br />
        {this.state.visibleA ? <AddAdmin /> : null}
      </Container>
    );
  }
}
