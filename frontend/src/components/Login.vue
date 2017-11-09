<template>
  <el-form ref="dynamicValidateForm" :model="dynamicValidateForm" :rules="rules" label-position="left" label-width="0px"
           class="demo-ruleForm login-container">
    <h3 class="title">系统登录</h3>
    <el-form-item prop="username">
      <el-input type="text" v-model="dynamicValidateForm.username" :rules="rules.username" auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item prop="pwd">
      <el-input type="password" v-model="dynamicValidateForm.pwd" :rules="rules.pwd" auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-checkbox v-model="checked" checked class="remember">记住密码</el-checkbox>
    <el-form-item style="width:100%;">
      <el-button type="primary" style="width:100%;" @click="login('dynamicValidateForm')">登录</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
  import api from '../api'

  //  api.login({'username': 'rh5555'})

  export default {
    name: 'login',
    data () {
      return {
        dynamicValidateForm: {
          username: '',
          pwd: ''
        },
        rules: {
          username: [
            {required: true, message: '请输入账号', trigger: 'blur'}
          ],
          pwd: [
            {required: true, message: '请输入密码', trigger: 'blur'}
          ]
        },
        checked: true
      }
    },
    methods: {
      login: function (formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            let opt = this.dynamicValidateForm
            api.login(opt).then(({
                                   data
                                 }) => {
              if (data.code === 401) {
                console.log('token')
                console.log(localStorage.token)
              } else {
                console.log(data)
                localStorage.setItem('token', data)
              }
            }
            )
          }
        })
//        api.login({'username': 'rh5555'}).then(({
//                              data
//                            }) => {
//          if (data.code === 401) {
//            console.log('token')
//            this.$router.push('/login')
//            this.$store.dispatch('UserLogout')
//            console.log(localStorage.token)
//          } else {
//            console.log(data)
//            localStorage.setItem('token', data)
//          }
//        })
      }
    }
  }
</script>


<style>
  body {
    background: #DFE9FB;
  }

  .login-container {
    width: 350px;
    margin-left: 38%;
  }
</style>
