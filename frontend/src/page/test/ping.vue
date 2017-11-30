<template>
  <div>
    <ul v-for="n in data">
      {{ n }}
    </ul>
  </div>
</template>

<script>
  import api from '../../api'

  export default ({
    name: 'ping-es',
    data () {
      return {
        data: []
      }
    },
    created: function () {
//      console.log(api.esCommonSearch('j'))
      var a = this
      api.esSearchNews().then(function (resp) {
        var hits = resp.hits.hits
        a.data = hits
      }, function (err) {
        if (err !== undefined) {
          console.log('请求错误')
        }
      })
    }
  })
</script>
