<template>
  <div>
    <usping-header/>

    <el-container style="border: 1px solid #eee">
      <el-aside width="80%" style="background-color: rgb(238, 241, 246)">
        <div>
          <ul v-for="(item,index) in news">
            <!--评论面板-->
            <el-row>
              <el-col :span="23">
                <el-card class="box-card">
                  <div slot="header" class="clearfix">
                    <span><a :href='item.url'>{{item.title}}</a></span>
                    <div style="float: right">{{item.source}}</div>
                    <div class="block" style="float: right">
                      <el-rate/>
                    </div>
                  </div>
                  <div>
                    {{ item.summary }}
                  </div>
                  <hr>
                  <span>
                    <i class="el-icon-edit" style="font-size:16px"
                       @click="openCommentDashBoard(item)">评论</i>
                  </span>
                  <div v-if="item.isHide">
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
                      <el-alert v-if="item.submitSucceed"
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
                      <ul v-for="comment in item.commentList">
                        <div>
                          {{ comment.userName }}:{{ comment.commentContent }}
                          <span style="float: right">{{ comment.commentDate }}</span>
                        </div>
                      </ul>
                    </div>
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
  import ElInput from '../../../node_modules/element-ui/packages/input/src/input.vue'
  import ElButton from '../../../node_modules/element-ui/packages/button/src/button.vue'

  export default {
    components: {
      ElButton,
      ElInput,
      UspingHeader
    },
    data () {
      return {
        news: '',
        loading: []
      }
    },
    created: function () {
//      api.getNews(this.$cookie.get('token')).then(({
//                                                     data
//                                                   }) => {
//        if (data.code === 401) {
//          console.log('token')
//          this.$router.push('/login')
//          this.$store.dispatch('UserLogout')
//          console.log(this.$cookie.get('token'))
//        } else {
//          this.news = data
//        }
//      })
//      this.search()
      this.search()
    },
    methods: {
      submitComment: function (item) {
        this.$set(item, 'submitCheck', false)
        this.$set(item, 'submitSucceed', false)
        if (item.commentArea === undefined || item.commentArea.length === 0) {
          this.$set(item, 'submitCheck', true)
          return
        }

        api.postComment(
          this.$cookie.get('token'),
          {
            newsId: item.id,
            userId: JSON.parse(this.$cookie.get('authorizedUser')).id,
            userName: JSON.parse(this.$cookie.get('authorizedUser')).name,
            commentContent: item.commentArea
          })
          .then(({
                   data
                 }) => {
            this.$set(item, 'submitSucceed', true)
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
      openCommentDashBoard: function (item) {
        if (item.isHide === undefined || item.isHide === false) {
          this.$set(item, 'isHide', true)
        } else {
          this.$set(item, 'isHide', false)
        }
        this.getCommentWithNewsId(item)
      },
      search: function () {
        var a = this
        api.esBoolSearch().then(function (resp) {
          var hits = resp.hits.hits
          a.news = hits
          console.log(hits)
          console.log('请求成功')
        }, function (err) {
          if (err !== undefined) {
            console.log('请求错误')
          }
        })
      }
    }

  }
</script>
