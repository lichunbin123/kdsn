<template>
  <div class="hello">
    <el-dialog
      title="购买产品"
      :visible.sync="localVisible"
      style="width:80%">
      <el-form :model="product_data" label-width="80px">
        <el-form-item label="商品名称">
          <el-input v-model="product_data.product_title"></el-input>
        </el-form-item>
        <el-form-item label="商品价格">
          <el-input v-model="product_data.product_price"></el-input>
        </el-form-item>
        <el-form-item label="需求数量">
          <span v-if="product_data.purchase_quantity"><el-input v-model="product_data.purchase_quantity"></el-input></span>
            <span v-else><el-input>未知</el-input></span>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitPurchaseRequest">立即购买</el-button>
          <el-button>取消请求</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
  import purchaseApi from '../../api/product/product'

  export default {
    name: 'purchase-dashboard',
    props: {
      dialogVisible: Boolean,
      itemData: Array
    },
    watch: {
      dialogVisible (val) {
        this.localVisible = val
      },
      itemData (val) {
        if (val && val.length !== 0) {
          this.product_data = val[0]
        }
      },
      localVisible (val) {
        this.$emit('on-visible-change', val)
      }
    },
    data () {
      return {
        localVisible: this.dialogVisible,
        product_data: {}
      }
    },
    methods: {
      submitPurchaseRequest: function () {
        // pass
        this.product_data['customer_id'] = JSON.parse(this.$cookie.get('authorizedUser')).id
        this.product_data['vendor_id'] = this.product_data['publisher_id'] || 0

        purchaseApi.purchaseProduct(
          this.$cookie.get('token'),
          this.product_data
        )
      }
    }
  }
</script>

<style>

</style>
