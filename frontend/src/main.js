// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from './api'
import VueCookie from 'vue-cookie'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

import UspingFooter from './components/layout/footer.vue'
import UspingHeader from './components/layout/header'

Vue.use(ElementUI)
Vue.use(VueCookie)

Vue.$http = axios

Vue.config.productionTip = false

/* eslint-disable no-new */
var vue = new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App,
    UspingFooter,
    UspingHeader
  }
})

export default {
  vue
}
