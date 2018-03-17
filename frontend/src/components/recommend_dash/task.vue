<template>
  <div @click="redirectPage">
    <el-card class="box-card">
        <span v-if="msg[0]"><el-tag type="success">推荐服务</el-tag> <a :href="msg.slice(-1)[0].source_url"> {{ msg.slice(-1)[0].task_title }}</a></span>
        <span v-else>加载中</span>
    </el-card>
  </div>
</template>

<style>
  .el-card {
    margin-bottom: 20px;
  }
</style>

<script>
  import ElTag from '../../../node_modules/element-ui/packages/tag/src/tag.vue'

  export default {
    components: {ElTag},
    name: 'recommend-service',
    props: ['msg'],
    watch: {
      msg: function (newMsg) {
        console.log('产生变化:' + newMsg)
      }
    },
    methods: {
      redirectPage: function () {
        this.$router.push('/task')
      }
    }
  }
</script>
