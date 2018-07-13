<template>
  <div>
    <el-dialog
      title="知识笔记"
      :visible.sync="localVisible"
      style="width: 80%"
    >
      <div v-if="noteBefore">
        已有笔记
        <span v-if="noteData.publicState === 1">
          <el-tag type="success">已分享</el-tag>
        </span>
        <span v-else>
          <el-button @click="shareNote">分享</el-button>
        </span>

        <el-button @click="editNote">编辑</el-button>
        <el-popover
          ref="popDelete"
          placement="top"
          width="160"
          trigger="click"
          v-model="deletePopVisible">
          <p>确认要删除吗？</p>
          <div style="text-align: right; margin: 0">
            <el-button size="mini" type="text" @click="deleteNote">取消</el-button>
            <el-button type="primary" size="mini" @click="deletePopVisible = false">确定</el-button>
          </div>
        </el-popover>
        <el-button v-popover:popDelete>删除</el-button>
      </div>
      <vue-editor :disabled="!editAble" v-model="noteData.noteContent || ''"/>
      <el-button @click="submitNote">提交</el-button>



    </el-dialog>
  </div>
</template>

<script>
  import api from '../../api'
  import { VueEditor } from 'vue2-editor'

  export default {
    name: 'note-board',
    components: {
      VueEditor
    },
    props: {
      dialogVisible: Boolean,
      currentNewsId: String
    },
    watch: {
      dialogVisible (val) {
        this.localVisible = val
        console.log('change listened')
      },
      localVisible (val) {
        if (val === true) {
          this.initNotePanel()
        }
        this.$emit('on-note-visible-change', val)
      },
      currentNewsId (newsId) {
        this.noteData.newsId = newsId
      },
      currentContent (val) {
        this.currentContent = val
      }
    },
    data () {
      return {
        localVisible: this.dialogVisible,
        noteContent: 'contented',
        noteBefore: false,
        noteData: {
          noteContent: '',
          userId: JSON.parse(this.$cookie.get('authorizedUser')).userId,
          newsId: this.currentNewsId,
          publicState: 0
        },
        editAble: true,
        deletePopVisible: false
      }
    },
    methods: {
      submitNote: function () {
        // pass
        if (this.noteBefore === true) {
          api.postNoteUpdate(
            this.$cookie.get('token'),
            this.noteData
          )
          return
        }
        api.postNote(
          this.$cookie.get('token'),
          this.noteData
        )
      },
      initNotePanel: function () {
        let varThis = this
        api.getNoteWithNewsIdAndUserId(
          this.$cookie.get('token'),
          this.currentNewsId,
          JSON.parse(this.$cookie.get('authorizedUser')).userId
        )
          .then(({
                   data
                 }) => {
            if (data.success && data.empty) {
              console.log('无数据')
            } else {
              varThis.noteBefore = true
              varThis.noteData = data.data[0]
            }
          })
      },
      editNote: function () {
        this.editAble = true
      },
      shareNote: function () {
        api.modifyNoteState(
          this.$cookie.get('token'), this.noteData
        )
          .then(({
                   data
                 }) => {
            if (data.success) {
              this.noteData.publicState = 1
              this.$message('分享成功')
            } else {
              this.$message('分享失败，请稍后重试')
            }
          })
      },
      deleteNote: function () {
        this.deletePopVisible = false
        api.deleteNote(
          this.$cookie.get('token'),
          this.noteData.noteId
        )
      }
    }
  }
</script>
