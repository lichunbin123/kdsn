<template>
  <div id="app">
    <p>
      <transition name="slide">
        <router-view/>
      </transition>
    </p>
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
