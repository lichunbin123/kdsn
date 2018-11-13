<template>
  <div>
    <el-form :model="addSiteForm" label-position="left"
             label-width="0px"  @submit.native.prevent="submitForm">
    <label>
      请输入您想要爬取的网站名:
      <el-input v-model="addSiteForm.siteName" id="siteName"  @keyup.enter.native="submitForm"></el-input>
    </label>
      <label>
        请输入您想要爬取的网址:
        <el-input v-model="addSiteForm.siteUrl" id="siteUrl"  @keyup.enter.native="submitForm"></el-input>
      </label>
      <el-button @click="submitForm">提交</el-button>
    </el-form>
    <el-row>
      <label>您提交过的申请</label>
    </el-row>
    <el-row>
      <el-table>

      </el-table>
    </el-row>
  </div>
</template>

<script>
  import api from '@/api/index'

  export default {
    name: 'add-site-tool',
    data () {
      return {
        addSiteForm: {
          siteName: '',
          siteUrl: '',
          applyUser: JSON.parse(this.$cookie.get('authorizedUser')).id
        }
      }
    },
    methods: {
      clearData: function () {
        this.addSiteForm.siteName = ''
        this.addSiteForm.siteUrl = ''
      },
      submitForm: function () {
        api.submitSource(
          this.$cookie.get('token'),
          this.addSiteForm
        ).then(
          res => {
            this.clearData()
            let data = res.data
            console.log(data)
            this.$message(
              data.messageContent
            )
          }
        ).catch(
          error => {
            this.clearData()
            console.log(error.data)
          }
        )
      }
    }
  }
</script>
