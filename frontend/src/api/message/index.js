import store from '../../store'
// import api from '../index'
//
// let instance = api.instance
//
// export default {
//   testConnection: function (token) {
//     return instance.get('/api/message/test',
//       {
//         headers: {
//           Authorization: token,
//           'Access-Control-Allow-Origin': '*'
//         }
//       }
//     )
//   },
//   sendMessage: function (token, data) {
//     return instance.post('/api/message/sendMessage',
//       data,
//       {
//         headers: {
//           Authorization: token,
//           'Access-Control-Allow-Origin': '*'
//         }
//       }X
//     )
//   },
//   fetchMessage: function (token, data) {
//     return instance.post('/api/message/fetchMessage',
//       data,
//       {
//         headers: {
//           Authorization: token,
//           'Access-Control-Allow-Origin': '*'
//         }
//       }
//     )
//   }
// }

import SockJS from 'sockjs-client'
import Stomp from 'webstomp-client'

var socket = new SockJS('http://localhost:8080/socket')
var stompClient = Stomp.over(socket)

window.connected = false

export default {
  connect () {
    // stompClient.connect(
    //   {},
    //   frame => {
    //     console.log(frame)
    //     stompClient.subscribe('/queue/chat', tick => {
    //       console.log(tick)
    //       this.received_messages.push(JSON.parse(tick.body).content)
    //       varThis.connected = true
    //     })
    //   },
    //   error => {
    //     console.log(error)
    //     // connected = false
    //   }
    // )
    return stompClient.connect({},
      function (frame) {
        console.log(frame)
        console.log('sure connected')
        window.connected = true
        stompClient.subscribe('/queue/chat', tick => {
          console.log(tick)
          console.log('message subscribed got')
          store.dispatch('chat/pushIntoMessage', JSON.parse(tick.body))
          console.log('message subscribed got and made it ')
        })
        console.log('subscribed')
      },
      function (error) {
        console.log(error)
        console.log('Error occurred')
      })
  },
  sendMessage (data) {
    return stompClient.send(
      '/app/sendMessage',
      JSON.stringify(data)
    )
  },
  fetchMessage (data) {
    return stompClient.send(
      '/app/fetchMessage',
      JSON.stringify(data)
    )
  },
  getConnectStatus () {
    return window.connected
  }
}
