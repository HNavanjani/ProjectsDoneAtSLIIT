import React, { Component } from 'react'
import axios from "axios";
import {Link} from "react-router-dom";
class Login extends Component {
    constructor() {
        super()
        this.state = {
            name: '',
            password: '',
            type:''
        }
        this.onChange = this.onChange.bind(this)
        this.onSubmit = this.onSubmit.bind(this)
    }

    onChange (e) {
        this.setState({ [e.target.name]: e.target.value })
    }

    onSubmit (e) {
        e.preventDefault()

        const user = {
            name: this.state.name,
            password: this.state.password,
            type: this.state.type
        }
        axios
            .post("http://localhost:3000/user/login", user)
            .then(res => console.log(res.data));


    }

    render () {
        return (
            <div className="container">
                <div className="row">
                    <div className="col-md-6 mt-5 mx-auto">
                        <form noValidate onSubmit={this.onSubmit}>
                            <h1 className="h3 mb-3 font-weight-normal">Please sign in</h1>
                            <div className="form-group">
                                <label htmlFor="email">User Name</label>
                                <input type="email"
                                    className="form-control"
                                    name="name"
                                    placeholder="Enter username"
                                    value={this.state.name}
                                    onChange={this.onChange} />
                            </div>
                            <div className="form-group">
                                <label htmlFor="password">Password</label>
                                <input type="password"
                                    className="form-control"
                                    name="password"
                                    placeholder="Enter Password"
                                    value={this.state.password}
                                    onChange={this.onChange} />
                            </div>
                            <div className="form-group">
                                <label htmlFor="email">User Type</label>
                                <input type="email"
                                       className="form-control"
                                       name="type"
                                       placeholder="Enter username"
                                       value={this.state.type}
                                       onChange={this.onChange} />
                            </div>

                            <button type="submit" className="btn btn-lg btn-primary btn-block" as={Link} to="/home" >
                                Sign in
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        )
    }
}

export default Login