<template>
  <div>
    <usping-header></usping-header>

    <el-container style="border: 1px solid #eee">
      <el-aside width="80%" style="background-color: rgb(238, 241, 246)">
        <div>
          <ul v-for="(item,index) in list">
            <el-row>
              <el-col :span="23">
                <el-card class="box-card">
                  <div slot="header" class="clearfix">
                    <span><a :href='item.url'>{{item.title}}</a></span>
                    <!--<div style="float: right">{{item}}</div>-->
                    <div class="block" style="float: right">
                      <el-rate></el-rate>
                    </div>
                  </div>
                  <div>
                    {{ item.title }}
                  </div>
                  <div>
                    <!--{{ item }}-->
                  </div>
                </el-card>
              </el-col>
            </el-row>
          </ul>
          <ul>
            <el-row>
              <el-col :span="23">
                <el-pagination
                  @size-change="handleSizeChange"
                  @current-change="handleCurrentChange"
                  :page-size="pageSize"
                  layout="total,sizes, prev, pager, next"
                  :total="total">
                </el-pagination>
              </el-col>
            </el-row>
          </ul>
        </div>
      </el-aside>

      <el-container>
        test
      </el-container>

    </el-container>
  </div>
</template>

<style>
  .el-aside {
    color: #333;
  }

  .el-container {
    /*position: fixed;*/
    height: auto;
  }
</style>

<script>
  import api from '../../api'
  import UspingHeader from '../../components/layout/header.vue'

  export default {
    components: {UspingHeader},
    data () {
      return {
        list: [],
        total: 0,
        currentPage: 1,
        pageSize: 10
      }
    },
    created: function () {
//      api.getTask(this.$cookie.get('token')).then(({
//                                                     data
//                                                   }) => {
//        if (data.code === 401) {
//          console.log(this.$cookie.get('token'))
//        } else {
//          this.tasks = data
//        }
//      })
      this.loadData()
    },
    methods: {
      clearData: function () {
        this.list = []
      },
      loadData: function () {
        api.getTaskForUser(
          this.$cookie.get('token'),
          this.pageSize,
          this.currentPage
        ).then(({
                  data
                }) => {
          var tmpThis = this
          data['data'].forEach(function (v) {
            tmpThis.list.push(v)
          })
          this.total = data['total']
        }
        )
      },
      flushData: function () {
        this.clearData()
        this.loadData()
      },
      handleSizeChange: function (pageSize) {
        this.pageSize = pageSize
        this.flushData()
      },
      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage
        this.flushData()
      }
    }

  }
</script>
