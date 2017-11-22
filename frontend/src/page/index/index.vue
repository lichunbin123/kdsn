<template>
  <div>
    <el-header>
      <usping-header></usping-header>
    </el-header>
    <el-main>
      <el-row type="flex" class="row-bg" style="padding-top: 10%" justify="space-around">
        <el-col :span="8">
          <el-row class="sub-title">汇聚智能</el-row>
          <el-row>
            <el-col :span="2"><img src="/static/logo.png" style="height: 40px"/></el-col>
            <el-col :span="20">
              <el-input
                placeholder="请输入搜索内容"
                prefix-icon="el-icon-search">
              </el-input>
            </el-col>
            <el-col :span="2">
              <el-button type="primary" icon="el-icon-search">搜索</el-button>
            </el-col>
          </el-row>
        </el-col>
      </el-row>
      <el-row type="flex" class="row-bg" justify="space-between">
        <el-col :span="8"><img src="/static/index/know.png" @click="goNews" style="height: 160px;float: right"/>
        </el-col>
        <el-col :span="8" style="text-align: center"><img src="/static/index/service.png" @click="goTask"
                                                          style="height: 160px"/></el-col>
        <el-col :span="8"><img src="/static/index/shop.png" style="height: 160px;float: left"/></el-col>
      </el-row>
    </el-main>
  </div>
</template>

<script>
  import ElInput from '../../../node_modules/element-ui/packages/input/src/input.vue'
  import ElMain from '../../../node_modules/element-ui/packages/main/src/main.vue'
  import ElCol from 'element-ui/packages/col/src/col'
  import ElHeader from '../../../node_modules/element-ui/packages/header/src/main.vue'
  import UspingHeader from '../../components/layout/header.vue'

  export default {
    components: {
      UspingHeader,
      ElHeader,
      ElCol,
      ElMain,
      ElInput
    },
    name: 'index',
    methods: {
      goNews () {
        this.$router.push('/news')
      },
      goTask () {
        this.$router.push('/task')
      }
    }
  }
</script>

<style>
  body {
    background: #ffffff
  }

  .el-row {
    margin-bottom: 20px;

  &
  :last-child {
    margin-bottom: 0;
  }

  }
  .el-col {
    border-radius: 4px;
  }

  .bg-purple-dark {
    background: #99a9bf;
  }

  .bg-purple {
    background: #d3dce6;
  }

  .bg-purple-light {
    background: #e5e9f2;
  }

  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }

  .row-bg {
    padding: 10px 0;
    /*background-color: #f9fafc;*/
  }

  .sub-title {
    font-family: "Microsoft YaHei";
    text-align: center;
    font-size: 34px;
  }
</style>
