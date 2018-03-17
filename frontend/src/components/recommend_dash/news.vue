<template>
  <div @click="redirectPage">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span v-if="msg[0]"><el-tag type="warning">推荐知识:</el-tag>  <a :href="msg.slice(-1)[0].source_url">{{ msg.slice(-1)[0].news_title }}</a></span>
        <span v-else>加载中</span>
      </div>
      <div>
        <span v-if="msg[0]">{{ msg.slice(-1)[0].news_summary }}</span>
      </div>
    </el-card>
  </div>
</template>


<style>
  .el-card {
    margin-bottom: 20px;
  }
</style>

<script>
  export default {
    name: 'recommend-news',
    props: ['msg'],
    watch: {
      msg: function (newMsg) {
        console.log(newMsg)
      }
    },
    methods: {
      redirectPage: function () {
        this.$router.push('/news')
      }
    }
  }
</script>
