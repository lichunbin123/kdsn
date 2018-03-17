<template>
  <div>
    <el-dialog
      v-bind:title="board_title"
      :visible.sync="localVisible">


      <div v-for="item in messageList">
        <div v-if="item.senderUsername == sender">
          <el-row>
            <el-card style="float: right;background-color: #56ff36">
              <p style="margin: 0px; width: 200px">{{ item.messageContent }}</p>
            </el-card>
          </el-row>
        </div>
        <div v-else>
          <el-row>
            <el-card style="float: left">
              <p style="margin: 0px; width: 200px">{{ item.messageContent }}</p>
            </el-card>
          </el-row>
        </div>
      </div>

      <el-input style="width: 70%" v-model="chatContent" placeholder="请输入聊天内容"></el-input>
      <el-button style="width:10%;float:right" type="primary" @click="sendMessage">发送</el-button>
    </el-dialog>
  </div>
</template>

<style>


  p {
    word-break: break-all;
  }

  .talktext p {
    /* remove webkit p margins */
    -webkit-margin-before: 0em;
    -webkit-margin-after: 0em;
  }

</style>

<script>
  import messageApi from '../../api/message'

  export default {
    name: 'chat-board',
    props: {
      'receiver': String,
      'dialogVisible': Boolean
    },
    watch: {
      dialogVisible (val) {
        this.localVisible = val
        console.log('change listened')
      },
      localVisible (val) {
        if (val === true) {
          this.fetchMessage()
          return
        }
        this.$emit('on-visible-change', val)
      }
    },
    data () {
      return {
        localVisible: this.dialogVisible,
        chatContent: '',
        messageList: []
      }
    },
    computed: {
      board_title: function () {
        return '您当前正在与' + this.receiver + '交流'
      },
      sender: function () {
        return JSON.parse(this.$cookie.get('authorizedUser')).username
      }
    },
    methods: {
      sendMessage: function () {
        var varThis = this
        messageApi.sendMessage(
          this.$cookie.get('token'),
          {
            senderUsername: this.sender,
            receiverUsername: this.receiver,
            messageContent: this.chatContent
          }
        ).then(function (response) {
          varThis.messageList.push({
            senderUsername: varThis.sender,
            receiverUsername: varThis.receiver,
            messageContent: varThis.chatContent
          })
          varThis.chatContent = ''
        }).catch(function (error) {
          console.log(error)
          varThis.chatContent = ''
          varThis.$message('当前网络错误，消息发送失败')
        })
      },
      fetchMessage: function () {
        var varThis = this
        messageApi.fetchMessage(
          this.$cookie.get('token'),
          {
            senderUsername: this.sender,
            receiverUsername: this.receiver
          }
        ).then(function (response) {
          varThis.messageList = response.data.data
          console.log(response)
        }).catch(function (error) {
          console.log(error)
        })
      }
    }
  }
</script>
