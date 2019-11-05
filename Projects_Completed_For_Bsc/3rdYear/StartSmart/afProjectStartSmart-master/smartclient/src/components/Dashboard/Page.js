import React from "react";
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
  Container,
  Button
} from "reactstrap";

import Login from "../Login/Login"

export default class Page extends React.Component {
  constructor(props) {
    super(props);

    this.toggle = this.toggle.bind(this);
    this.state = {
      isOpen: false,
      visible: false
    };
  }
  toggle() {
    this.setState({
      isOpen: !this.state.isOpen
    });
  }
  render() {
    const buttonText = this.state.visible ? "Log Out" : "Sign In";
    return (
      <div>
        <Container>
          <Navbar color="info" light expand="xl">
            <NavbarBrand className="text-white" href="/">
              <img
                width="300"
                height="100"
                src={require("../../images/logo1.png")}
              />
            </NavbarBrand>
            <font align="center" color="yellow" size="6">
              <strong>Student and Instructor Information System</strong>
            </font>
            <NavbarToggler onClick={this.toggle} />
            <Collapse isOpen={this.state.isOpen} navbar>
              <Nav className="ml-auto" navbar>
                <NavItem>
                  <font size="4">
                    <NavLink className="text-white" href="/components/">
                      About
                    </NavLink>
                  </font>
                </NavItem>
                <UncontrolledDropdown nav inNavbar>
                  <DropdownToggle className="text-white" nav caret>
                    <font size="4">Account</font>
                  </DropdownToggle>
                  <DropdownMenu right>
                    <font size="4">
                      <DropdownItem>Task 1</DropdownItem>
                      <DropdownItem>Task 2</DropdownItem>
                      <DropdownItem divider />
                      <DropdownItem>Notifications</DropdownItem>
                    </font>
                  </DropdownMenu>
                </UncontrolledDropdown>
                <NavItem>
                  <font size="4">
                    <NavLink className="text-white" href="/components/">
                      Sign Up
                    </NavLink>
                  </font>
                </NavItem>
              </Nav>
            </Collapse>
          </Navbar>
          <br />
          {this.state.visible ? (
            <Login/>
          ) : (
            <div>
              <font size="5" color="black">
                <strong>Sign In to Start Smart</strong>
              </font>
            </div>
          )}
          <br />
          <Button
            color="primary"
            onClick={() => {
              this.setState({ visible: !this.state.visible });
            }}
          >
            {buttonText}
          </Button>
        </Container>
      </div>
    );
  }
}
