<template>
  <div @click="redirectPage">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span v-if="msg[0]"><el-tag>推荐产品:</el-tag><a :href="msg.slice(-1)[0].source_url">{{ msg.slice(-1)[0].product_title }}</a></span>
        <span v-else>加载中</span>
      </div>
      <div>
        <span v-if="msg[0]"> {{ msg.slice(-1)[0].product_content }}></span>
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
  import ElTag from '../../../node_modules/element-ui/packages/tag/src/tag.vue'

  export default {
    components: {ElTag},
    name: 'recommend-product',
    props: ['msg'],
    watch: {
      msg: function (newMsg) {
        console.log(newMsg)
      }
    },
    methods: {
      redirectPage: function () {
        this.$router.push('/product')
      }
    }
  }
</script>
