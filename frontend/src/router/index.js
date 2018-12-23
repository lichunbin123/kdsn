import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/page/user/Login'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/components/Home'
import User from '@/components/User'
import IndexPage from '@/page/index/index'
import news from '@/page/news/myNews'
import task from '@/page/task/myTask'
import product from '@/page/product/myProduct'
import esping from '@/page/test/ping'
import Register from '@/page/user/Register'
import EmailInform from '@/page/user/EmailInform'
import Reset from '@/page/user/Reset'
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
      name: '默认页',
      component: IndexPage
    },
    {
      path: '/news',
      name: '新闻',
      component: news
    },
    {
      path: '/news/:searchParam',
      name: '带参新闻',
      component: news
    },
    {
      path: '/task',
      name: '任务',
      component: task
    },
    {
      path: '/product',
      name: '产品',
      component: product
    },
    {
      path: '/ping',
      name: 'es-ping',
      component: esping
    },
    {
      path: '/register',
      name: 'sign-up',
      component: Register
    },
    {
      path: '/emailinform',
      name: 'emailinform',
      component:EmailInform
    },
    {
      path: '/reset',
      name: 'reset',
      component:Reset
    },
  ]
})
export default router
