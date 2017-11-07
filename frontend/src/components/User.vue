<template>
  <div>
    <ul v-for="(item,index) in user">
      <li>{{ item }}</li>
    </ul>
  </div>
</template>

<script>
  import api from '../api'

  //  var data = api.getUser()

  //  console.log(api.getUser())

  export default {
    name: 'List',
    data () {
//      var data = api.getUser()
      let data = '[]'
      api.getUser().then(({
                            data
                          }) => {
        if (data.code === 401) {
          console.log('token')
          this.$router.push('/login')
          this.$store.dispatch('UserLogout')
          console.log(localStorage.token)
        } else {
          this.user = data
        }
      })
      return {
        msg: Object.valueOf(data),
        user: ''
      }
    }
  }
</script>
