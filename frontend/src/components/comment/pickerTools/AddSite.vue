<template>
  <div>
    <el-form>
    <label>
      请输入您想要爬取得网址:
      <el-input v-model="data.siteUrl" id="siteUrl"></el-input>
    </label>
    <el-row>
      <el-button>提交</el-button>
    </el-row>
    </el-form>
    <el-row>
      <el-label>您提交过的申请</el-label>
    </el-row>
    <el-row>
      <el-table>

      </el-table>
    </el-row>
  </div>
</template>

<script>
  export default {
    name: 'add-site-tool',
    data () {
      return {
        data: {
          siteUrl: '',
          applyUser: JSON.parse(this.$cookie.get('authorizedUser')).id
        }
      }
    },
    methods: {
      submitForm: function () {

      }
    }
  }
</script>
