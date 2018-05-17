<template>

</template>

<script>
  import api from '../../api/message'
  import AMap from '../../components/es5.min'

  export default ({
    name: 'ping-es',
    data () {
      return {
        data: [],
        map: ''
      }
    },
    created: function () {
//
      api.testConnection(this.$cookie.get('token'))

      this.map = new AMap.Map('container', {
        resizeEnable: true,
        zoom: 11,
        center: [116.397428, 39.90923]
      })
    }
  })
</script>
