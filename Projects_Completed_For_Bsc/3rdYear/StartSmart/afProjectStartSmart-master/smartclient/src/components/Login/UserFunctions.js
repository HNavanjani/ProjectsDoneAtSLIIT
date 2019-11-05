import axios from 'axios'

export const login = user => {
    return axios
        .post('/user', {
            email: user.email,
            password: user.password,
            type:user.type
        })
        .then(res => {
            localStorage.setItem('usertoken', res.data)
            return res.data
        })
        .catch(err => {
            console.log(err)
        })
}

