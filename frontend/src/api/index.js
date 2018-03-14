import axios from 'axios'
import Vue from '../main.js'

axios.defaults.timeout = 5000

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
  instance,
  // 用户注册
  userRegister (data) {
    return instance.post('/api/register', data)
  },
  // 用户登录
  UserLogin (data) {
    return instance.post('/api/login', data
    )
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
    return instance.post('/auth/login', data,
      {
        headers: {
          'Access-Control-Allow-Origin': '*'
        }
      })
  },
  logout () {
    console.log('尝试登出')
    Vue.vue.$cookie.delete('token')
    console.log('删除token')
    Vue.vue.$cookie.delete('authorizedUser')
  },
  getTask (token) {
    return instance.get('/api/task/task',
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      })
  },
  getTaskForUser (token, pageSize, pageNumber) {
    return instance.get('/api/task/getTaskForUser?pageSize=' + pageSize + '&pageNumber=' + pageNumber,
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      })
  },
  getProduct (token) {
    return instance.get('/api/product/product',
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      })
  },
  getProductForUser (token, pageSize, pageNumber) {
    return instance.get('/api/product/getProductForUser?pageSize=' + pageSize + '&pageNumber=' + pageNumber,
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      })
  },
  postComment (token, data) {
    return instance.post('/api/comment/comment',
      data,
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      })
  },
  getCommentWithUserIdAndNewsId (token, userId, newsId) {
    return instance.get('/api/comment/findByUserIdAndNewsId?userId=' + userId + '&newsId=' + newsId,
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      })
  },
  getCommentWithNewsId (token, newsId) {
    return instance.get('/api/comment/findByNewsId?newsId=' + newsId,
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      })
  },
  getNoteWithNewsIdAndUserId (token, newsId, userId) {
    return instance.get('/api/note/findByNewsIdAndUserId?newsId=' + newsId + '&userId=' + userId,
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      })
  },
  postNote (token, data) {
    return instance.post('/api/note/note',
      data,
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      })
  },
  modifyNoteState (token, data) {
    return instance.post('/api/note/makePublic',
      data,
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      })
  },
  testDistinct (token) {
    // TODO should bechange for getting the menu of current user
    // everytime should flush
    return instance.get('/api/news/testDistinct',
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      })
  },
  submitMenu (token, data) {
    return instance.post('/api/menu/saveMenu',
      data,
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      })
  }

}
