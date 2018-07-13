const state = {
  token: null
}


const getters = {

  globalHeader: (state) => {
    return {
      headers: {
        token: state.authorization,
        'Access-Control-Allow-Origin': '*'
      }
    }
  }
}

const mutations = {
  setAuthoriztion ({commit, state}, token) {
    state.token = token
  }
}

const actions = {

}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
