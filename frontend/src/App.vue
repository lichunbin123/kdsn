<template>
  <div id="app">
    <p>
      <transition name="slide">
        <router-view/>
      </transition>
    </p>
    <!--<router-link to="/home">家</router-link>-->
    <!--<router-link to="/hello">欢迎页</router-link>-->
  </div>
</template>

<script>
  import UspingHeader from './components/layout/header.vue'

  export default {
    components: {UspingHeader},
    name: 'app'
  }
</script>

<style>

</style>
