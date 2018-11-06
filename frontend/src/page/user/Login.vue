<template>
  <div class="login-app">
    <usping-header></usping-header>
    <div style="z-index: 999">
      <el-form ref="dynamicValidateForm" :model="dynamicValidateForm" :rules="rules" label-position="left"
               label-width="0px"
               class="demo-ruleForm login-container">
        <h3 class="title" style="text-align: center">系统登录</h3>
        <el-form-item prop="userAccount">
          <el-input type="text" v-model="dynamicValidateForm.userAccount" :rules="rules.userAccount" auto-complete="off"
                    placeholder="账号"></el-input>
        </el-form-item>
        <el-form-item prop="vanillaPassword">
          <el-input type="password" v-model="dynamicValidateForm.vanillaPassword" :rules="rules.vanillaPassword"
                    auto-complete="off" placeholder="密码"></el-input>
        </el-form-item>
        <el-checkbox v-model="checked" checked class="remember">记住密码</el-checkbox>
        <el-form-item style="width:100%;">
          <el-button type="primary" style="width:40%;" @click="login('dynamicValidateForm')">登录</el-button>
          <el-button type="primary" style="width:40%;" @click="redirectToRegister()">注册</el-button>
        </el-form-item>
      </el-form>
    </div>
    <vue-particles
      style="z-index: -19"
      :particleOpacity="0.7"
      :particlesNumber="80"
      shapeType="circle"
      :particleSize="4"
      linesColor="#dedede"
      :linesWidth="1"
      :lineLinked="true"
      :lineOpacity="0.4"
      :linesDistance="150"
      :moveSpeed="3"
      :hoverEffect="true"
      hoverMode="grab"
      :clickEffect="true"
      clickMode="push"
    >
    </vue-particles>
  </div>
</template>

<script>
  import api from '../../api/index'
  import UspingHeader from '../../components/layout/header'
  import md5 from 'md5'

  export default {
    components: {UspingHeader},
    name: 'login',
    data () {
      return {
        dynamicValidateForm: {
          userAccount: '',
          vanillaPassword: '',
        },
        rules: {
          userAccount: [
            {required: true, message: '请输入账号', trigger: 'blur'}
          ],
          vanillaPassword: [
            {required: true, message: '请输入密码', trigger: 'blur'}
          ]
        },
        checked: true
      }
    },
    methods: {

      login: function (formName) {
        this.dynamicValidateForm['userPassword'] = md5(this.dynamicValidateForm['vanillaPassword'])
        this.$refs[formName].validate((valid) => {
          if (valid) {
            let opt = this.dynamicValidateForm
            api.login(opt).then(({
                                   data
                                 }) => {
                if (data.code === 401) {
                  console.log('401')
                  console.log(this.$cookie.get('token'))
                } else {
                  console.log('当前得到的数据是' + data)
                  this.$cookie.set('token', data.responseData[0].authorizationToken, {expires: '100day'})
                  this.$cookie.set('authorizedUser', JSON.stringify(data.responseData[0]), {expires: '10min'})
//                let redirect = decodeURIComponent('/index')
//                this.$router.push({
//                  path: redirect
//                })
                  this.$router.go(-1)
                }
              }
            ).catch(function error(e) {
              console.log(e + '' + e.message)
              this.$alert('登录失败', '请检查您的输入!', {
                confirmButtonText: '确定',
                callback: action => {
                  this.$message({
                    type: 'info',
                    message: `action: ${action}`
                  })
                }
              })
            })
          }
        })
      }
      ,
      redirectToRegister: function () {
        this.$router.push('/register')
      }
    }
  }
</script>


<style>
  body {
    /*background: #DFE9FB;*/
  }

  .login-container {
    width: 350px;
    margin-left: 38%;
  }

  #login-app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    /*color: #2c3e50;*/
    margin-top: 60px;
  }

  #particles-js {
    background-size: cover;
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
  }
</style>
