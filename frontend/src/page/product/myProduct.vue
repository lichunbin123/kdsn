<template>
  <div>
    <usping-header></usping-header>

    <el-container style="border: 1px solid #eee">
      <el-aside width="80%" style="background-color: rgb(238, 241, 246)">
        <div>
          <ul v-for="(item,index) in products">
            <el-row>
              <el-col :span="23">
                <el-card class="box-card">
                  <div slot="header" class="clearfix">
                    <span><a :href='item'>{{item}}</a></span>
                    <!--<div style="float: right">{{item}}</div>-->
                    <div class="block" style="float: right">
                      <el-rate></el-rate>
                    </div>
                  </div>
                  <div>
                    {{ item }}
                  </div>
                  <div>
                    <!--{{ item }}-->
                  </div>
                </el-card>
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
        products: ''
      }
    },
    created: function () {
      api.getProduct(this.$cookie.get('token')).then(({
                                                     data
                                                   }) => {
        if (data.code === 401) {
          console.log(this.$cookie.get('token'))
        } else {
          this.products = data
        }
      })
    }

  }
</script>
