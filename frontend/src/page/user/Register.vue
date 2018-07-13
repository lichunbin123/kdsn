<template>
  <div class="register-app">
    <usping-header/>

    <div v-if="submitSucceed">
      注册成功，将在{{redirectCount}}秒后返回
    </div>

    <div v-else style="z-index: 999">
      <el-form ref="registerForm" :model="registerForm" :rules="rules" label-position="left" label-width="80px"
               class="demo-ruleForm login-container">
        <h3 class="title" style="text-align: center">系统注册</h3>
        <el-form-item label="账户" prop="username">
          <el-input v-model="registerForm.username" placeholder="请输入用户名称，由英文和数字组成"></el-input>
        </el-form-item>
        <el-form-item label="用户昵称" prop="name">
          <el-input v-model="registerForm.name" placeholder="请输入用户名称，由英文和数字组成"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" v-model="registerForm.password" placeholder="请输入密码，由8位到12位英文和数字组成"></el-input>
        </el-form-item>
        <el-form-item label="行业选择">
          <el-select v-model="registerForm.industry">
            <el-option value="激光">激光</el-option>
            <el-option value="机械">机械</el-option>
            <el-option value="医疗">医疗</el-option>
            <el-option value="IT">IT</el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="手机号码" prop="phone">
          <el-input v-model="registerForm.phone" placeholder="请输入手机号码"></el-input>
        </el-form-item>
        <el-form-item label="电子邮箱">
          <el-input v-model="registerForm.email" placeholder="请输入电子邮箱"></el-input>
        </el-form-item>
        <el-form-item label="简介">
          <el-input v-model="registerForm.introduction" placeholder="请输入个人简介"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="submitRegisterForm" type="primary">确定无误，提交</el-button>
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
  import userApi from '../../api/user'
  import UspingHeader from '../../components/layout/header'

  export default {
    components: {UspingHeader},
    name: 'register-page',
    data () {
      return {
        submitSucceed: false,
        redirectCount: 3,
        registerForm: {
          username: '',
          email: '',
          phone: '',
          industry: '',
          department: null,
          comments: '',
          notValidated: '',
          agree: false,
          introduction: ''
        },
        rules: {
          username: [
              {required: true, message: '请输入用户名称，由英文和数字组成', trigger: 'blur'},
              {min: 5, max: 10, message: '长度在 3 到 5 个字符', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入用户名称，由英文和数字组成', trigger: 'blur'},
            {min: 5, max: 10, message: '长度在 5 到 10 个字符', trigger: 'blur'}
          ],
          phone: [
            // {type: 'number', required: true, message: '请输入正确的手机号', trigger: 'change'},
            {min: 11, max: 11, message: '请输入正确的手机号', trigger: 'blur'}
          ],
          industry: [
            {required: true}
          ],
          type: [
                {type: 'array', required: true, message: '请至少选择一个活动性质', trigger: 'change'}
          ],
          resource: [
                {required: true, message: '请选择活动资源', trigger: 'change'}
          ],
          desc: [
                {required: true, message: '请填写活动形式', trigger: 'blur'}
          ]
        }
      }
    },
    created: function () {
      this.formState = {}
    },
    methods: {
      submitRegisterForm: function () {
        var varThis = this
        this.$refs['registerForm'].validate((valid) => {
          if (valid) {
            userApi.submitRegisterForm(
              this.$cookie.get('token'),
              this.registerForm
            )
              .then(function (response) {
                console.log(response.status)
                varThis.$cookie.set('token', response.data.token, { expires: '100day' })
                varThis.$cookie.set('authorizedUser', JSON.stringify(response.data.authorizedUser), { expires: '10min' })
                varThis.$message('注册成功，正在跳转')
                varThis.$router.push('/')
              })
              .catch(function (code) {
                console.log(code)
                varThis.$message('当前网络错误，请稍侯重试或联系管理员')
                varThis.$router.push('')
              })
          } else {
            console.log('error submit!!')
            return false
          }
        })
      }
    },
    watch: {
      submitSucceed (val) {
        if (val === true) {
          window.setInterval(this.redirectCount -= 3, 3000)
        }
      },
      redirectCount (val) {
        if (val === 0) {
          this.$router.push('/')
        }
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
