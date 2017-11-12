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
      api.getUser(this.$cookie.get('token')).then(({
                            data
                          }) => {
        if (data.code === 401) {
          console.log('token')
          this.$router.push('/login')
          this.$store.dispatch('UserLogout')
          console.log(this.$cookie.get('token'))
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
