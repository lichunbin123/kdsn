<template>
    <el-menu
      class="el-menu-demo"
      mode="horizontal"
      background-color="#fff"
      style='border: 0px;font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;'
      active-text-color="#ffd04b">
      <el-menu-item index="1"><img src="/static/logo.png" style="height: 60px"><span style="color: black;font-size: 22px">  汇聚智能</span></el-menu-item>
      <el-submenu index="2" style="float: right">
        <template slot="title">我的UsPing</template>
        <el-menu-item index="2-1">选项1</el-menu-item>
        <el-menu-item index="2-2">选项2</el-menu-item>
        <el-menu-item index="2-3">登出</el-menu-item>
      </el-submenu>
      <el-menu-item v-if="msg" index="3" style="float: right">您当前未登录</el-menu-item>
    </el-menu>
</template>

<script>
  export default {
    name: 'usping-header',
    data () {
      console.log('获取到token' + localStorage.getItem('token'))
      return {
        msg: localStorage.getItem('token')
      }
    }
  }
</script>
