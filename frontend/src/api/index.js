import axios from 'axios'
import Vue from '../main.js'

axios.defaults.timeout = 5000

var elasticsearch = require('elasticsearch')
var client = new elasticsearch.Client({
  host: 'localhost:9200',
  log: 'trace'
})
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
  // 新闻获取
  getNews (token) {
    return instance.get('/api/news/news',
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      })
  },
  getNewsForUser (token, pageSize, pageNumber) {
    return instance.get('/api/news/findForUser?pageSize=' + (pageSize || 10) + '&pageNumber=' + (pageNumber || 0),
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      })
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
  getProduct (token) {
    return instance.get('/api/product/product',
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
  esCommonSearch (content) {
    return client.search({
      q: content
    })
  },
  esSearchNews (from, size) {
    return client.search({
      from: from || 0,
      size: size || 10,
      body: {
        query: {
          bool: {
            must: {
              term: {
                text: 'b'
              }
            }
          }
        }
      }
    })
  }

}
