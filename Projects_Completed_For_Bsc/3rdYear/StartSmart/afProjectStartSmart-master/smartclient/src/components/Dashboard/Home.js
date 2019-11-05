import React, { Component } from "react";
import {
  Card,
  Button,
  CardImg,
  CardTitle,
  CardText,
  CardColumns,
  CardSubtitle,
  CardBody
} from "reactstrap";

import AdminDashboard from "../Dashboard/AdminDashboard";
import StudentDashboard from "../Dashboard/StudentDashboard";
import InstructorDashboard from "../Dashboard/InstructorDashboard";

export default class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      visibleS: false,
      visibleI: false,
      visibleA: false
    };
  }
  render() {
    return (
      <CardColumns>
        <Card>
          <CardImg
            top
            width="100%"
            src={require("../../images/student.png")}
            alt="Card image cap"
          />
          <CardBody>
            <CardTitle>
              <strong>Student</strong>
            </CardTitle>
            <CardSubtitle>Access Student Functions</CardSubtitle>
            <CardText>Click to access Student Functions.</CardText>
            {this.state.visibleS ? (
              <StudentDashboard />
            ) : (
              <div> Launch to View Student Activities </div>
            )}
            <br />
            <Button
              color="success"
              onClick={() => {
                this.setState({ visibleS: true });
              }}
            >
              Launch
            </Button>
          </CardBody>
        </Card>

        <Card>
          <CardImg
            top
            width="100%"
            src={require("../../images/teacher.png")}
            alt="Card image cap"
          />

          <CardBody>
            <CardTitle>
              {" "}
              <strong>Instructor</strong>
            </CardTitle>

            <CardSubtitle>Instructor Functions</CardSubtitle>
            <CardText>Click to access Instructor Functions.</CardText>
            {this.state.visibleI ? (
              <InstructorDashboard />
            ) : (
              <div> Launch to View Instructor Activities </div>
            )}
            <br />
            <Button
              color="success"
              onClick={() => {
                this.setState({ visibleI: true });
              }}
            >
              Launch
            </Button>
          </CardBody>
        </Card>
        <Card>
          <CardImg
            top
            width="100%"
            src={require("../../images/admin.png")}
            alt="Card image cap"
          />
          <CardBody>
            <CardTitle>
              {" "}
              <strong>Administrator</strong>
            </CardTitle>
            <CardSubtitle>Access Admin Functions</CardSubtitle>
            <CardText>Click here to access Admin Funcitons.</CardText>
            {this.state.visibleA ? (
              <AdminDashboard />
            ) : (
              <div> Launch to View Administrator Activities </div>
            )}
            <br />
            <Button
              color="success"
              onClick={() => {
                this.setState({ visibleA: true });
              }}
            >
              Launch
            </Button>
          </CardBody>
        </Card>
      </CardColumns>
    );
  }
}
