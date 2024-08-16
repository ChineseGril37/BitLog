<template>
  <div class="post_table">
    <div @click="post_herf">
      {{list.title}}
    </div>
  </div>
</template>

<script setup lang="ts">

//挂载props传入的具体博客数据
defineProps(['list'])
function post_herf(){
  //点击post的div链接到所属贴页面

}
</script>
<style scoped src="../assets/css/Post.css">
</style>
