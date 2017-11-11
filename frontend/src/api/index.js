import axios from 'axios'

axios.defaults.timeout = 5000

// const instance = axios.create({
//   headers: {'Acce  ss-Control-Allow-Origin': '*'}
// })

let instance = axios.create({
  baseURL: `http://localhost:8080`,
  timeout: 10000,
  headers: {
    'access-control-allow-origin': 'http://localhost:8080',
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  }
})

// const config = {Authorization: localStorage.getItem('token')}

axios.defaults.baseURL = 'http://localhost:8080'

// axios拦截响应
instance.interceptors.response.use(response => {
  return response
}, err => {
  return Promise.reject(err)
})

export default {
  // 用户注册
  userRegister (data) {
    return instance.post('/api/register', data)
  },
  // 用户登录
  UserLogin (data) {
    return instance.post('/api/login', data)
  },
  // 获取用户
  getUser () {
    // return instance.get('/')
    console.log('发送请求')
    return instance.get('/api/auth/user', {headers: {Authorization: localStorage.getItem('token')}})
  },
  // 删除用户
  delUser (data) {
    return instance.post('/api/delUser', data)
  },
  login (data) {
    return instance.post('/auth/login', data)
  }
}