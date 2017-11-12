import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/components/Home'
import User from '@/components/User'
import IndexPage from '@/page/index/index'
import news from '@/page/news/myNews'

// import header from '@/components/layout/header'
// import footer from '@/components/layout/footer'

Vue.use(Router)

let router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/hello',
      name: '测试',
      component: HelloWorld
    },
    {
      path: '/home',
      name: '家',
      component: Home
    },
    {
      path: '/login',
      name: '登录',
      component: Login
    },
    {
      path: '/users',
      name: '用户列表',
      component: User
    },
    {
      path: '/index',
      name: '首页',
      component: IndexPage
    }, {
      path: '/',
      name: '首页',
      component: IndexPage
    },
    {
      path: '/news',
      name: '新闻',
      component: news
    }
  ]
})

export default router
