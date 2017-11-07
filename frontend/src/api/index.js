import axios from 'axios'

axios.defaults.timeout = 5000
axios.defaults.headers.post['Content-Type'] = 'application/json'
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*'
axios.defaults.headers.get['Access-Control-Allow-Origin'] = '*'
axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*'

// const instance = axios.create({
//   headers: {'Access-Control-Allow-Origin': '*'}
// })

const instance = axios.create({
  baseURL: `http://localhost:8081`,
  headers: {
    'Access-Control-Allow-Origin': 'http://localhost:8080',
    'Content-Type': 'application/json',
    'token': 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyaDU1NTUiLCJpYXQiOjE1MTAwNzE2MDMsImlzcyI6ImNjIn0.mbUSwm5RQLHurG75igxVvm1AnE_-A6c9bP-3_WoTLqw'
  }
})

instance.defaults.headers.post['Content-Type'] = 'application/json'
instance.defaults.headers.get['Content-Type'] = 'application/json'

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
    return instance.get('http://localhost:8080/api/auth/user')
  },
  // 删除用户
  delUser (data) {
    return instance.post('/api/delUser', data)
  }
}
