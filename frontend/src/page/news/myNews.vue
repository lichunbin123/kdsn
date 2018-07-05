<template>
  <div>
    <usping-header :searchInput="input" @on-result-change="onSearchInputChange"
                   @on-search-click="onSearchClick"/>
    <el-container style="border: 1px solid #eee">
      <el-aside width="80%" style="background-color: rgb(238, 241, 246)">
        <div>
          <ul v-for="(item, index) in news">
            <!--评论面板-->
            <el-row>
              <el-col :span="23">
                <el-card class="box-card">
                  <div slot="header" class="clearfix">
                    <span><a :href='item.source_url'>{{item.news_title}}</a></span>
                    <div style="float: right">{{item.source_site}}</div>
                    <el-button v-if="currentUser" @click="openChatboard(item)">联系作者</el-button>
                    <div class="block" style="float: right">
                      <el-rate/>
                    </div>
                  </div>
                  <div>
                    {{ item.news_content }}
                  </div>
                  <hr>
                  <span>
                    <i class="el-icon-edit" style="font-size:16px"
                       @click="openCommentDashBoard(item)">评论</i>
                  </span>
                  <span>
                    <i class="el-icon-edit" style="font-size:16px"
                       @click="openNoteBoard(item.id)">笔记</i>
                  </span>
                  <div v-if="item.isCommentHide">
                    <!--输入面板-->
                    <div class="comment-input">
                      <el-input
                        type="textarea"
                        :rows="1"
                        placeholder="请输入评论内容!"
                        v-model="item.commentArea">
                      </el-input>
                      <el-button @click="submitComment(item)">提交</el-button>
                    </div>
                    <!--提示面板-->
                    <div class="alert-dashboard">
                      <el-alert v-if="item.submitCheck"
                                title="不能提交没有内容的评论!"
                                type="error"
                                :closable="false">
                      </el-alert>
                      <el-alert v-if="item.submitCommentSucceed"
                                title="评论提交成功,感谢您的参与!"
                                type="success"
                                :closable="false">
                      </el-alert>
                    </div>
                    <!--加载面板-->
                    <div class="loading-dashboard" v-if="!item.loading">
                      <el-table
                        v-loading="loading"
                        style="width: 100%">
                        <el-table-column
                          prop="date"
                          label="日期"
                          width="180">
                        </el-table-column>
                        <el-table-column
                          prop="name"
                          label="姓名"
                          width="180">
                        </el-table-column>
                        <el-table-column
                          prop="address"
                          label="地址">
                        </el-table-column>
                      </el-table>
                    </div>
                    <!--评论列表-->
                    <div v-if="item.loading">
                      <ul v-for="comment in item.commentList" style="background: whitesmoke;">
                        <div>
                          <span style="color: dimgrey;font-weight: bolder;font-size: 18px" >{{ comment.userName }}</span>: {{ comment.commentContent }}
                          <span style="float: right;color: #d3d3d3">{{ comment.commentDate | timeFilter }}</span>
                        </div>
                        <span></span>
                        <hr style="border: whitesmoke">
                      </ul>
                    </div>
                  </div>
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
                  layout="sizes, prev, pager, next"
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
            <recommend-product :msg="recommend_product_data"/>
            <recommend-service :msg="recommend_service_data"/>
          </el-col>

        </el-row>
      </el-container>

    </el-container>
    <chat-board :sender="JSON.parse(this.$cookie.get('authorizedUser'))" :receiver="currentChatter" :dialog-visible="chatboardVisible"
                @on-visible-change="onchatboardVisibleChange"/>
    <note-board :current-news-id="currentNewsId" @on-note-visible-change="onNoteBoardVisibleChange" :dialog-visible="noteboardVisible"/>

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
  import api from '../../api'
  import UspingHeader from '../../components/layout/header.vue'
  import ElInput from '../../../node_modules/element-ui/packages/input/src/input.vue'
  import ElButton from '../../../node_modules/element-ui/packages/button/src/button.vue'
  import parser from '../../config/parse'
  import ElCol from 'element-ui/packages/col/src/col'
  import { VueEditor } from 'vue2-editor'
  import ElRow from 'element-ui/packages/row/src/row'
  import RecommendProduct from '../../components/recommend_dash/product.vue'
  import RecommendService from '../../components/recommend_dash/task.vue'
  import TaskSearcher from '../../api/search/task_search'
  import ProductSearcher from '../../api/search/product_search'
  import NewsSearcher from '../../api/search/news_search'
  import ChatBoard from '../../components/message/ChatBoard'
  import NoteBoard from '../../components/comment/NoteBoard'

  export default {
    components: {
      NoteBoard,
      ChatBoard,
      RecommendService,
      RecommendProduct,
      ElRow,
      ElCol,
      ElButton,
      ElInput,
      UspingHeader,
      VueEditor
    },
    data () {
      return {
        input: '',
        news: [],
        loading: [],
        total: 0,
        currentPage: 1,
        pageSize: 10,
        currentUser: this.$cookie.get('authorizedUser') || null,
        customToolbar: [
          [' ', 'underline'],
          [{'list': 'ordered'}, {'list': 'bullet'}],
          ['image', 'code-block']
        ],
        recommend_service_data: [],
        recommend_product_data: [],
        chatboardVisible: false,
        noteboardVisible: false,
        currentChatter: '',
        currentNewsId: '',
        searchText: this.$route.params.searchParam
      }
    },
    created: function () {
      this.loadData(this.$route.params.searchParam || '测试')
    },
    methods: {
      clearData: function () {
        this.news = []
      },
      loadData: function (searchText) {
        let tmpThis = this
        NewsSearcher.esSearchNewsWithSource((this.currentPage - 1) * this.pageSize, this.pageSize, searchText || '测试').then(function (resp) {
          let hits = resp.hits.hits
          console.log('请求成功')
          tmpThis.total = resp.hits.total
          parser.parseEs(hits).forEach(function (value) {
            tmpThis.news.push(value)
          })
          console.log(tmpThis.news)
          console.log('解析成功')
          console.log(hits)
        }, function (err) {
          if (err !== undefined) {
            console.log('请求错误')
          }
        })
        this.randomInitialRecommendation()
      },
      flushPage: function () {
        this.clearData()
        this.loadData()
      },
      openChatboard: function (item) {
        this.currentChatter = item['news_publisher']
        console.log('publisher is' + item['news_publisher'])
        console.log('trying to open the chat board')
        this.chatboardVisible = true
      },
      openNoteBoard: function (newsId) {
        if (this.$cookie.get('authorizedUser') == null || this.$cookie.get('authorizedUser') === undefined) {
          this.$message('登录后才能做笔记！')
          return
        }
        this.currentNewsId = newsId
        this.noteboardVisible = true
      },
      onchatboardVisibleChange: function (val) {
        this.chatboardVisible = val
      },
      onNoteBoardVisibleChange: function (val) {
        this.noteboardVisible = val
      },
      submitComment: function (item) {
        this.$set(item, 'submitCheck', false)
        this.$set(item, 'submitCommentSucceed', false)
        if (item.commentArea === undefined || item.length === 0) {
          this.$set(item, 'submitCheck', true)
          return
        }

        api.postComment(
          this.$cookie.get('token'),
          {
            newsId: item.id,
            userId: JSON.parse(this.$cookie.get('authorizedUser')).id,
            userName: JSON.parse(this.$cookie.get('authorizedUser')).username,
            commentContent: item.commentArea
          })
          .then(({
                   data
                 }) => {
            this.$set(item, 'submitCommentSucceed', true)
            item.commentList.push({
              newsId: item.id,
              userId: JSON.parse(this.$cookie.get('authorizedUser')).id,
              userName: JSON.parse(this.$cookie.get('authorizedUser')).username,
              commentContent: item.commentArea,
              commentDate: Date.parse(new Date())
            })
            console.log(this.news)
            item.commentArea = ''
          })
      },
      getCommentWithNewsId: function (item) {
        api.getCommentWithNewsId(
          this.$cookie.get('token'),
          item.id
        )
          .then(({
                   data
                 }) => {
            console.log(data)
            this.$set(item, 'commentList', data)
            this.$set(item, 'loading', true)
          })
      },
      getNoteWithNewsIdAndUserId: function (item) {
        api.getNoteWithNewsIdAndUserId(
          this.$cookie.get('token'),
          item.id,
          JSON.parse(this.$cookie.get('authorizedUser')).id
        )
          .then(({
                   data
                 }) => {
            console.log(data)
            this.$set(item, 'commentList', data)
            this.$set(item, 'loading', true)
          })
      },
      openCommentDashBoard: function (item) {
        if (item.isCommentHide === undefined || item.isCommentHide === false) {
          this.$set(item, 'isCommentHide', true)
        } else {
          this.$set(item, 'isCommentHide', false)
        }
        this.getCommentWithNewsId(item)
      },
      search: function () {
        var tmpThis = this
        NewsSearcher.esSearchNews((this.currentPage - 1) * this.pageSize, this.pageSize, this.input).then(function (resp) {
          var hits = resp.hits.hits
          console.log('请求成功')
          parser.parseEs(hits).forEach(function (value) {
            tmpThis.news.push(value)
          })
          console.log(tmpThis.news)
          console.log('解析成功')
          console.log(hits)
        }, function (err) {
          if (err !== undefined) {
            console.log('请求错误')
          }
        })
        console.log(this.news)
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
      },
      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage
        this.flushPage()
      },
      handleSizeChange: function (size) {
        this.pageSize = size
        this.flushPage()
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
      },
      randomInitialRecommendation () {
        var tmpThis = this
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
        ProductSearcher.randomSearch(0, 1, 'product').then(function (resp) {
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
    },
    filters: {
      timeFilter: function (value) {
        var newDate = new Date(value)
        return newDate.toLocaleDateString()
      }
    }
  }
</script>
