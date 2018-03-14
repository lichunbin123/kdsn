<template>
  <div>
    <usping-header :searchInput="input" @on-result-change="onSearchInputChange"
                   @on-search-click="onSearchClick"/>
    <el-container style="border: 1px solid #eee">
      <el-aside width="80%" style="background-color: rgb(238, 241, 246)">
        <div>
          <ul v-for="(item,index) in list">
            <el-row>
              <el-col :span="23">
                <el-card class="box-card">
                  <div slot="header" class="clearfix">
                    <span><a :href='item.source_url'>{{item.product_title}}</a></span>
                    <!--<div style="float: right">{{item}}</div>-->
                    <div class="block" style="float: right">
                      <i class="el-icon-document" style="font-size:16px"
                         @click="openPurchaseDashboard(item)">我要购买</i>
                    </div>
                  </div>
                  <div>
                    {{ item.product_content }}
                  </div>
                  <hr>
                  <i class="el-icon-edit" style="font-size:16px"
                     @click="openCommentDashboard(item)">评论</i>
                </el-card>
              </el-col>
            </el-row>
          </ul>
          <ul v-if="total">
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

      <el-container style="width: 20%;" id="right-panel">
        <el-row>
          <el-col>
            向您推荐
          </el-col>
          <el-col :span="24">
            <recommend-service :msg="recommend_service_data"/>
            <recommend-news :msg="recommend_news_data"/>
          </el-col>
        </el-row>
      </el-container>
    </el-container>

    <purchase-dashboard :item-data="currentProductData" :dialog-visible="purchaseDashboardVisible" @on-visible-change="onPurchaseDashboardVisibleChange"/>


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
</style>A

<script>
  import UspingHeader from '../../components/layout/header.vue'
  import RecommendService from '../../components/recommend_dash/task.vue'
  import RecommendNews from '../../components/recommend_dash/news.vue'
  import parser from '../../config/parse'
  import ProductSearcher from '../../api/search/product_search'
  import TaskSearcher from '../../api/search/task_search'
  import NewsSearcher from '../../api/search/news_search'
  import PurchaseDashboard from '../../components/product/PurchaseDashboard'

  export default {
    components: {
      PurchaseDashboard,
      RecommendNews,
      RecommendService,
      UspingHeader},
    data () {
      return {
        input: '',
        list: [],
        total: 0,
        currentPage: 1,
        pageSize: 10,
        recommend_service_data: [],
        recommend_news_data: [],
        purchaseDashboardVisible: false,
        currentProductData: []
      }
    },
    created: function () {
      this.randomInitialRecommendation()
      this.loadRandomData()
    },
    methods: {
      clearData: function () {
        this.list = []
      },
      loadData: function () {
        this.loadRandomData()
      },
      loadRandomData: function () {
        var tmpThis = this
        ProductSearcher.randomSearch((this.currentPage - 1) * this.pageSize, this.pageSize).then(function (resp) {
          var hits = resp.hits.hits
          tmpThis.total = resp.hits.total
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
      onPurchaseDashboardVisibleChange: function (val) {
        this.purchaseDashboardVisible = val
      },
      openPurchaseDashboard: function (item) {
        // set purchase Dashboard flag
        // open the dashboard
        // dashboard as un
        this.currentProductData.push(item)
        console.log(item.product_title)

        this.purchaseDashboardVisible = true
      },
      search: function () {
        var tmpThis = this
        ProductSearcher.esSearchProduct((this.currentPage - 1) * this.pageSize, this.pageSize, this.input).then(function (resp) {
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
      searchForRecommend: function () {
        var tmpThis = this
        // 搜索产品
        TaskSearcher.esSearchTask(0, 1, this.input).then(function (resp) {
          var hits = resp.hits.hits
          console.log('请求成功')
          parser.parseEs(hits).forEach(function (value) {
            tmpThis.recommend_service_data.push(value)
          })
          console.log(tmpThis.recommend_service_data)
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
      flushPage: function () {
        this.clearData()
        this.loadData()
      },
      randomInitialRecommendation () {
        var tmpThis = this
        NewsSearcher.randomSearch(0, 1, 'news').then(function (resp) {
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
        TaskSearcher.randomSearch(0, 1).then(function (resp) {
          var hits = resp.hits.hits
          console.log('请求成功')
          parser.parseEs(hits).forEach(function (value) {
            tmpThis.recommend_service_data.push(value)
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
