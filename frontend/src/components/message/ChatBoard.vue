<template>
  <div>
    <el-dialog
      v-bind:title="board_title"
      :visible.sync="localVisible">


      <div v-for="item in messageList">
        <div v-if="item.senderUsername && item.senderUsername === sender">
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
  import {mapMutations, mapGetters, mapActions} from 'vuex'

  export default {
    name: 'chat-board',
    props: {
      'receiver': String,
      'dialogVisible': Boolean
    },
    computed: {
      board_title: function () {
        return '您当前正在与' + this.receiver + '交流'
      },
      sender: function () {
        return JSON.parse(this.$cookie.get('authorizedUser')).userAccount
      },
      currentSendMessage: function () {
        return {
          senderAccount: this.sender,
          receiverAccount: this.receiver,
          messageContent: this.chatContent
        }
      },
      ...mapGetters('chat', {
        messageList: 'currentMessageList'
      }),
      ...mapActions('chat', [
        'pushIntoMessage',
        'setChatWith'
      ]),
    },
    watch: {
      dialogVisible(val) {
        this.localVisible = val
        console.log('change listened')
      },
      localVisible(val) {
        if (val === true) {
          console.log('正在获取')
          this.fetchMessage()
          this.clearInput()
          this.$store.dispatch('chat/setChatWith', {
            'chatWithNow': this.receiver
          })
          console.log('获取成功')
          console.log('得到的数据是' + this.messageList)
          return
        }
        this.$emit('on-visible-change', val)
      }
    },
    data() {
      return {
        localVisible: this.dialogVisible,
        chatContent: ''
      }
    },
    created: function () {
      if (messageApi.getConnectStatus() === false) {
        messageApi.connect()
      }
      console.log('The data is ' + this.messageList)
    },
    methods: {
      pushIntoList: function () {
        this.$store.dispatch('chat/pushIntoMessage', this.currentSendMessage)
      },
      clearInput: function () {
        this.chatContent = ''
      },
      sendMessage: function () {
        messageApi.sendMessage(
          this.currentSendMessage
        )
        console.log('current message send is' + this.currentSendMessage)
        this.pushIntoList()
        // .catch(function (error) {
        //   console.log(error)
        //   varThis.chatContent = ''
        //   varThis.$message('当前网络错误，消息发送失败')
        // })
      },
      fetchMessage: function () {
        messageApi.fetchMessage(
          this.currentSendMessage
        )
      },
      ...mapActions('chat', [
        'chat/pushIntoMessage'
      ])
    }
  }
</script>
