import api from '../../api'

let instance = api.instance

export default {
  submitRegisterForm: function (token, data) {
    return instance.post('/auth/register',
      data,
      {
        headers: {
          Authorization: token,
          'Access-Control-Allow-Origin': '*'
        }
      }
    )
  },
}
