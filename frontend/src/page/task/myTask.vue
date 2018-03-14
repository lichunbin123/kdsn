<template>
  <div>
    <usping-header :searchInput="input" @on-result-change="onSearchInputChange"
                   @on-search-click="onSearchClick"></usping-header>
    <el-container style="border: 1px solid #eee">
      <el-aside width="80%" style="background-color: rgb(238, 241, 246)">
        <div>
          <ul v-for="(item,index) in list">
            <el-row>
              <el-col :span="23">
                <el-card class="box-card">
                      <a :href='item.source_url'>{{item.task_title}}</a>
                  <!--<div style="float: right">{{item}}</div>-->
                  <div class="block" style="float: right">
                  </div>
                  <div>
                  </div>
                </el-card>
              </el-col>
            </el-row>
          </ul>
          <ul>
            <el-row v-if="total">
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

      <el-container style="width: 20%;" id="right-panel">
        <el-row>
          <el-col>
            向您推荐
          </el-col>
          <el-col :span="24">
            <recommend-product :msg="recommend_product_data"></recommend-product>
            <recommend-news :msg="recommend_news_data"></recommend-news>
          </el-col>

        </el-row>
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

  #right-panel > .el-row {
    width: 80%;
    margin: 10px auto;
  }

</style>

<script>
  import UspingHeader from '../../components/layout/header.vue'
  import parser from '../../config/parse'
  import RecommendProduct from '../../components/recommend_dash/product.vue'
  import RecommendNews from '../../components/recommend_dash/news.vue'
  import TaskSearcher from '../../api/search/task_search'
  import ProductSearcher from '../../api/search/product_search'
  import NewsSearcher from '../../api/search/news_search'

  export default {
    components: {
      RecommendNews,
      RecommendProduct,
      UspingHeader
    },
    data () {
      return {
        input: '',
        list: [],
        total: 0,
        currentPage: 1,
        pageSize: 10,
        recommend_product_data: [],
        recommend_news_data: []
      }
    },
    flushPage: function () {
      this.clearData()
      this.loadRandomData()
    },
    created: function () {
      this.randomInitialRecommendation()
      this.loadRandomData()
    },
    methods: {
      clearData: function () {
        this.list = []
      },
      loadRandomData: function () {
        var tmpThis = this
        TaskSearcher.randomSearch((this.currentPage - 1) * this.pageSize, this.pageSize).then(function (resp) {
          var hits = resp.hits.hits
          console.log('请求成功')
          tmpThis.total = resp.hits.total
          parser.parseEs(hits).forEach(function (value) {
            tmpThis.list.push(value)
          })
          console.log(tmpThis.hits)
          console.log('解析成功')
          console.log(hits)
        }, function (err) {
          if (err !== undefined) {
            console.log('请求错误')
          }
        })
      },
      loadData: function () {
        this.loadRandomData()
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
      },
      search: function () {
        var tmpThis = this
        TaskSearcher.esSearchTaskWithSource((this.currentPage - 1) * this.pageSize, this.pageSize, this.input).then(function (resp) {
          var hits = resp.hits.hits
          console.log('请求成功')
          parser.parseEs(hits).forEach(function (value) {
            tmpThis.list.push(value)
          })
          console.log(tmpThis.hits)
          console.log('解析成功')
          console.log(hits)
        }, function (err) {
          if (err !== undefined) {
            console.log('请求错误')
          }
        })
        console.log(this.news)
      },
      onSearchInputChange: function (val) {
        if (val.length === 0) {
          this.flushPage()
        }
        this.input = val
      },
      onSearchClick: function () {
        this.clearData()
        this.search()
        this.searchForRecommend()
      },
      searchForRecommend: function () {
        var tmpThis = this
        // 搜索产品
        ProductSearcher.esSearchProduct(0, 1, this.input).then(function (resp) {
          var hits = resp.hits.hits
          console.log('请求成功')
          parser.parseEs(hits).forEach(function (value) {
            tmpThis.recommend_product_data.push(value)
          })
          console.log(tmpThis.recommend_product_data)
          console.log('product解析成功')
          console.log(hits)
        }, function (err) {
          if (err !== undefined) {
            console.log('请求错误')
          }
        })
        // 搜索服务
        NewsSearcher.esSearchNews(0, 1, this.input).then(function (resp) {
          var hits = resp.hits.hits
          console.log('请求成功')
          parser.parseEs(hits).forEach(function (value) {
            tmpThis.recommend_news_data.push(value)
          })
          console.log(tmpThis.recommend_news_data)
          console.log('product解析成功')
          console.log(hits)
        }, function (err) {
          if (err !== undefined) {
            console.log('请求错误')
          }
        })
      },
      randomInitialRecommendation () {
        var tmpThis = this
        NewsSearcher.randomSearch(0, 1).then(function (resp) {
          var hits = resp.hits.hits
          console.log('请求成功')
          parser.parseEs(hits).forEach(function (value) {
            tmpThis.recommend_news_data.push(value)
          })
        }, function (err) {
          if (err !== undefined) {
            console.log('请求错误')
          }
        })
        ProductSearcher.randomSearch(0, 1).then(function (resp) {
          var hits = resp.hits.hits
          console.log('请求成功')
          parser.parseEs(hits).forEach(function (value) {
            tmpThis.recommend_product_data.push(value)
          })
        }, function (err) {
          if (err !== undefined) {
            console.log('请求错误')
          }
        })
      }
    }
  }
</script>
