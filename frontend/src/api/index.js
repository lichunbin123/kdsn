import axios from 'axios'
import Vue from '../main.js'

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
  getUser (token) {
    console.log('request token is: ' + token)
    return instance.get('/api/auth/user',
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      })
  },
  // 删除用户
  delUser (data) {
    return instance.post('/api/delUser', data)
  },
  login (data) {
    return instance.post('/auth/login', data)
  },
  logout () {
    console.log('尝试登出')
    Vue.vue.$cookie.delete('token')
    console.log('删除token')
    Vue.vue.$cookie.delete('authorizedUser')
  },
  // 新闻获取
  getNews (token) {
    console.log('request token is: ' + token)
    return instance.get('/api/news/news',
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      })
  },
  getTask (token) {
    console.log('request token is: ' + token)
    return instance.get('/api/task/task',
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      })
  }
}
