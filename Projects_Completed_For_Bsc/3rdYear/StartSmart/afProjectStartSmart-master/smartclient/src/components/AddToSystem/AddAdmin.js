import React, { Component } from "react";
import axios from "axios";
import {
  Container,
  Col,
  Row,
  Button,
  Form,
  FormGroup,
  Label,
  Input
} from "reactstrap";

export default class AddAdmin extends Component {
  constructor(props) {
    super(props);

    this.updateusername = this.updateusername.bind(this);
    this.updatepassword = this.updatepassword.bind(this);
    this.updatename = this.updatename.bind(this);
    this.updateemail = this.updateemail.bind(this);
    this.onSubmit = this.onSubmit.bind(this);

    this.state = {
      username: "",
      password: "",
      name: "",
      email: ""
    };
  }

  updateusername(e) {
    this.setState({ username: e.target.value });
  }

  updatepassword(e) {
    this.setState({ password: e.target.value });
  }
  updatename(e) {
    this.setState({ name: e.target.value });
  }
  updateemail(e) {
    this.setState({ email: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();

    const meo = {
      username: this.state.username,
      password: this.state.password,
      name: this.state.name,
      email: this.state.email
    };
    axios
      .post("http://localhost:3000/admin/", meo)
      .then(res => console.log(res.data));

    this.setState({
      username: "",
      password: "",
      name: "",
      email: ""
    });
  }

  render() {
    return (
      <Container>
        <Form onSubmit={this.onSubmit}>
          <Label>
            <strong>
              <font size="4">Add Administrator Details</font>
            </strong>
          </Label>
          <Row form>
            <Col md={6}>
              <FormGroup>
                <Label>User Name</Label>
                <Input
                  type="text"
                  name="username"
                  value={this.state.username}
                  onChange={this.updateusername}
                  id="userName"
                  placeholder="Enter User Name"
                />
              </FormGroup>
            </Col>
            <Col md={6}>
              <FormGroup>
                <Label>Password</Label>
                <Input
                  type="password"
                  name="password"
                  value={this.state.password}
                  onChange={this.updatepassword}
                  id="examplePassword"
                  placeholder="Enter a Password"
                />
              </FormGroup>
            </Col>
          </Row>
          <FormGroup>
            <Label> Name</Label>
            <Input
              type="text"
              name="name"
              value={this.state.name}
              onChange={this.updatename}
              id="Name"
              placeholder="Enter Name"
            />
          </FormGroup>

          <FormGroup>
            <Label>Email</Label>
            <Input
              type="email"
              name="name"
              value={this.state.email}
              onChange={this.updateemail}
              id="exampleEmail"
              placeholder="Enter Email"
            />
          </FormGroup>

          <Button type="submit" className="btn btn-success">
            ADD
          </Button>
        </Form>
      </Container>
    );
  }
}
