<template>
  <div class="inner-addon right-addon">
    <i class="el-icon-search"></i>
    <input type="text" class="form-control" />
  </div>
</template>

<script>
  export default {
    name: 'usping-search'
  }
</script>

<style>
  .inner-addon {
    position: relative;
  }

  /* style icon */
  .inner-addon .glyphicon {
    position: absolute;
    padding: 10px;
    pointer-events: none;
  }

  /* align icon */
  .left-addon .glyphicon  { left:  0px;}
  .right-addon .glyphicon { right: 0px;}

  /* add padding  */
  .left-addon input  { padding-left:  30px; }
  .right-addon input { padding-right: 30px; }
</style>
