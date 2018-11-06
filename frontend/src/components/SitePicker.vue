<template>
  <div>
    <el-dialog
      title="搜索管理"
      :visible.sync="localVisible"
      width="30%"
      :before-close="onBeforeClose">
      <el-tabs :tab-position="tabPosition" style="height: 200px;overflow: auto">
        <el-tab-pane label="来源定制">
          <el-container>
            <el-main>
              <el-tree
                :data="menuData"
                style="overflow: auto;"
                ref="tree"
                show-checkbox
                node-key="id"
                :default-checked-keys="checked_list">
              </el-tree>
            </el-main>
            <el-footer>
              <el-button @click="submitMenu">保存</el-button>
            </el-footer>
          </el-container>
        </el-tab-pane>
        <el-tab-pane label="增加来源"><add-site-tool></add-site-tool></el-tab-pane>
        <el-tab-pane label="我的评论">我的评论</el-tab-pane>
        <el-tab-pane label="我的笔记">我的笔记</el-tab-pane>
        <el-tab-pane label="我的经验">我的经验</el-tab-pane>
      </el-tabs>
      <span>
    <el-button @click="localVisible = false">取 消</el-button>
    <el-button type="primary" @click="localVisible = false">确 定</el-button>
  </span>
    </el-dialog>
  </div>

</template>

<script>
  import api from '../api'
  import ElButton from '../../node_modules/element-ui/packages/button/src/button.vue'
  import ElFooter from '../../node_modules/element-ui/packages/footer/src/main.vue'
  import ElContainer from '../../node_modules/element-ui/packages/container/src/main.vue'
  import ElHeader from '../../node_modules/element-ui/packages/header/src/main.vue'
  import ElMain from '../../node_modules/element-ui/packages/main/src/main.vue'
  import parser from '../config/parse'
  import MenuSearcher from '../api/menu/menu'
  import AddSiteTool from './comment/pickerTools/AddSite'

  export default {
    components: {
      AddSiteTool,
      ElMain,
      ElHeader,
      ElContainer,
      ElFooter,
      ElButton
    },
    name: 'usping-site-picker',
    props: {
      dialogVisible: Boolean
    },
    watch: {
      dialogVisible (val) {
        this.localVisible = val
      },
      localVisible (val) {
        if (val === true) {
          this.loadMenu()
        }
        this.$emit('on-visible-change', val)
      }
    },
    data () {
      return {
        localVisible: this.dialogVisible,
        checked_list: [],
        menuData: [],
        defaultProps: {
          children: 'children',
          label: 'label'
        },
        count: 1,
        tabPosition: 'left'
      }
    },
    methods: {
      handleCheckChange (data, checked, indeterminate) {
        console.log(data, checked, indeterminate)
      },
      handleNodeClick (data) {
        console.log(data)
      },
      handleClick (tab, event) {
        console.log(tab, event)
      },
      loadNode (node, resolve) {
        if (node.level === 0) {
          return resolve([{name: 'region1'}, {name: 'region2'}])
        }
        if (node.level > 3) return resolve([])

        var hasChild
        if (node.data.name === 'region1') {
          hasChild = true
        } else if (node.data.name === 'region2') {
          hasChild = false
        } else {
          hasChild = Math.random() > 0.5
        }

        setTimeout(() => {
          var data
          if (hasChild) {
            data = [{
              name: 'zone' + this.count++
            }, {
              name: 'zone' + this.count++
            }]
          } else {
            data = []
          }
          resolve(data)
        }, 500)
      },
      onBeforeClose: function (done) {
        this.localVisible = false
      },
      loadMenu: function () {
        var tmpThis = this
//        console.log(MenuSearcher.getMenu(5))
        MenuSearcher.getMenu(5).then((res) => {
          console.log(res)
          console.log('----------------------------------------')
          tmpThis.menuData = res
        })
      },
      submitMenu: function () {
        api.submitMenu(this.$cookie.get('token')
          , parser.convertMenu(this.$rmeefs.tree.getCheckedNodes(true), JSON.parse(this.$cookie.get('authorizedUser')).id))
      }
    }
  }
</script>

<style>
  .el-tree-node__content {
    overflow: auto;
  }

  .el-tree-node.is-expanded > .el-tree-node__children {
    display: inline;
  }
</style>
