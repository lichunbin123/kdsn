<template>
  <div class="Reset-app">
    <usping-header/>
    <div style="z-index: 999">
      <el-form ref="resetPasswordForm" :model="resetPasswordForm" :rules="rules" label-position="left"
               label-width="80px"
               class="demo-ruleForm login-container">
        <h3 class="title" style="text-align: center">重置密码</h3>
        <el-form-item label="账户" prop="userAccount">
          <el-input v-model="resetPasswordForm.userAccount" placeholder="请输入用户名称，由英文和数字组成"></el-input>
        </el-form-item>
        <el-form-item label="新密码" prop="userPassword">
          <el-input type="password" v-model="resetPasswordForm.userPassword"
                    placeholder="请输入密码，由8位到12位英文和数字组成"></el-input>
        </el-form-item>
        <el-form-item label="电子邮箱" prop="userEmail">
          <el-input v-model="resetPasswordForm.userEmail" placeholder="请输入电子邮箱"></el-input>
        </el-form-item>
        <el-form-item label="验证码" prop="code">
          <el-input v-model="resetPasswordForm.code" placeholder="请输入验证码"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="sendCode('resetPasswordForm')" type="primary">发送验证码</el-button>
          <el-button @click="resetForm('resetPasswordForm')" type="primary">确认无误，提交</el-button>
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
  import UspingHeader from "../../components/layout/header";

  export default {
    components: {UspingHeader},
    name: 'reset-page',
    data() {
      return {
        resetPasswordForm: {
          userAccount: '',
          userPassword: '',
          userEmail: '',
          code: '',
        },
        rules: {
          userAccount: [
            {required: true, message: '请输入用户名称，由英文和数字组成', trigger: 'blur'},
            {min: 5, max: 10, message: '长度在 3 到 5 个字符', trigger: 'blur'}
          ],
          userPassword: [
            {required: true, message: '请输入用户名称，由英文和数字组成', trigger: 'blur'},
            {min: 5, max: 10, message: '长度在 5 到 10 个字符', trigger: 'blur'}
          ],
          userEmail: [
            {required: true, message: '请输入邮箱', trigger: 'blur'}
          ],
          code: [
            {min: 4, max: 4, message: '长度为4个字符', trigger: 'blur'}
          ],
        },
      }
    },
    methods: {
      sendCode: function (formName) {
        var varthis = this
        this.$refs[formName].validate((valid) => {
          if (valid) {
            let opt = this.resetPasswordForm
            api.sendCode(opt).then(
              ({
                 data
               }) => {
                if (data.successStatus !== true) {
                  console.log(varthis.$cookie.get('token'))
                  this.$message('输入有误,请重新输入!')
                } else {
                  console.log('当前得到的数据是' + JSON.stringify(data.responseData[0]))
                  this.$cookie.set('token', data.responseData[0].authorizationToken, {expires: '100day'})
                  this.$cookie.set('authorizedUser', JSON.stringify(data.responseData[0]), {expires: '10min'})
                }
              }
            )
          }
        })
      },
      resetForm: function (formName) {
        var varthis = this
        this.$refs[formName].validate((valid) => {
          if (valid) {
            let opt = this.resetPasswordForm
            api.resetForm(opt).then(
              ({
                 data
               }) => {
                if (data.successStatus !== true) {
                  console.log(varthis.$cookie.get('token'))
                  this.$message('输入有误,请重新输入!')
                } else {
                  console.log('当前得到的数据是' + JSON.stringify(data.responseData[0]))
                  this.$cookie.set('token', data.responseData[0].authorizationToken, {expires: '100day'})
                  this.$cookie.set('authorizedUser', JSON.stringify(data.responseData[0]), {expires: '10min'})
                }
              }
            )
          }
        })

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

  #register-app {
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

