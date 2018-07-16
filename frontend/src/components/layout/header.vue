<template>
  <div>
    <el-menu
      class="el-menu-demo"
      mode="horizontal"
      background-color="#fff"
      style='border: 0px;font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;'
      active-text-color="#ffd04b">
      <el-menu-item index="1" @click="goHome"><img src="/static/logo.png" style="height: 60px"><span
        style="color: black;font-size: 22px">  汇聚智能</span></el-menu-item>
      <el-menu-item index="1" v-if="!isIndex">
        <el-input
          v-model="localInput"
          @keyup.enter.native="emitSearch"
          type="text"
          placeholder="请输入搜索内容">
        </el-input>
        <i class="el-icon-search" @click="emitSearch"></i>
      </el-menu-item>
      <el-submenu v-if="user" index="2" style="float: right">
        <template slot="title">我的UsPing</template>
        <el-menu-item index="2-1">我的usping</el-menu-item>
        <el-menu-item @click="logout" index="2-3">登出</el-menu-item>
      </el-submenu>
      <el-menu-item v-if="user" index="3" style="float: right" @click="openPicker">
        <el-badge :value="200" :max="99" class="item">
          欢迎您,{{ user.userNickname }}!
        </el-badge>
      </el-menu-item>
      <el-menu-item v-else="user" index="3" style="float: right">
        <router-link :to="{ path: '/login'}">您当前未登录,点击登录!</router-link>
      </el-menu-item>
    </el-menu>
    <usping-site-picker :dialogVisible="dialogVisible" @on-visible-change="onPickerVisible"/>
  </div>
</template>

<script>
  import api from '../../api/index'
  import UspingSitePicker from '../SitePicker.vue'

  export default {
    components: {UspingSitePicker},
    name: 'usping-header',
    props: {
      searchInput: String,
      isIndex: Number
    },
    data () {
      return {
        user: JSON.parse(this.$cookie.get('authorizedUser')),
        localInput: this.searchInput,
        dialogVisible: false
      }
    },
    watch: {
      searchInput (val) {
        this.localInput = val
      },
      localInput (val) {
        this.$emit('on-result-change', val)
      }
    },
    methods: {
      logout: function () {
        api.logout()
        this.user = ''
        this.$notify({
          title: '登出成功',
          message: '您已成功登出',
          position: 'top-right'
        })
        this.$router.push('')
      },
      goHome: function () {
        this.$router.push('/')
      },
      emitSearch: function () {
        this.$emit('on-search-click')
      },
      onPickerVisible: function (val) {
        this.dialogVisible = val
      },
      openPicker: function () {
        this.dialogVisible = true
      },
      listenEnter: function () {
        console.log('cc')
      }
    }
  }
</script>

<style>
  .item {
    margin-top: 10px;
    margin-right: 40px;
  }
</style>
