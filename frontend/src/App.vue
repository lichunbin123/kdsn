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
  export default {
    name: 'app'
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
