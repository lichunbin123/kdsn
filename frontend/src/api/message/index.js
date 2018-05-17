import api from '../index'

let instance = api.instance

export default {
  testConnection: function (token) {
    return instance.get('/api/message/test',
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      }
    )
  },
  sendMessage: function (token, data) {
    return instance.post('/api/message/sendMessage',
      data,
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      }
    )
  },
  fetchMessage: function (token, data) {
    return instance.post('/api/message/fetchMessage',
      data,
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      }
    )
  }
}
