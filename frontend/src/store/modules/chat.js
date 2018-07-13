import messageApi from '../../api/message'

const state = {
  messageList: {},
  current: {},
  chatWithNow: null
}

const getters = {
  currentMessageList: (state) => {
    // if (state.chatWithNow === null) {
    //   return []
    // }
    //
    // if (state.chatWithNow in state.messageDict){
    //   return state.messageList[state.chatWithNow]
    // }
    // return []
   return state.messageList
    // if (state.chatWithNow === null) {
    //   console.log('empty so far')
    //   return []
    // }
    // if (state.messageDict.hasOwnProperty('admin')) {
    //   console.log('matched key')
    //   return state.messageDict[state.chatWithNow]
    // }
    // else {
    //   console.log('chat with now is' + state.chatWithNow)
    //   console.log('nono matched key')
    //   console.log(Object.keys(state.messageDict))
    //   return [{'senderUsername': 'dd'}]
    // }
  }
}

const actions = {
  setChatWith ({commit, state}, payload) {
    state.chatWithNow = payload.chatWithNow
  },
  pushIntoMessage ({commit, state}, payload) {
    state.messageList = payload.messageList
  }
}

const mutations = {
  // datamap -> {userId, messageList}
  // pushIntoMessage (state, message) {
  //   console.log('消息获取成功')
  //   state.messageDict['rh5555'] = message
  //   console.log(state.messageDict['rh5555'])
  //   console.log(state.chatWithNow)
  //   // if (dataMap.userId in )
  // }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
