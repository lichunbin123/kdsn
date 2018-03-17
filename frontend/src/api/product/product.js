import api from '../index'

var instance = api.instance

export default {
  testConnection: function (token) {
    return instance.get('/api/product/test',
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      }
      )
  },
  purchaseProduct: function (token, data) {
    console.log('token is ' + token)
    return instance.post('/api/product/product',
      data,
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      })
  }
}
