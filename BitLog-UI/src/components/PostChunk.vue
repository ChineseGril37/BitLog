<template>
  <div class="post_table">
    <a :href="'/post/article?id='+list.id" class="font_set">
      {{list.title}}</a>
  </div>
</template>

<script setup lang="ts">

//挂载props传入的具体博客数据
defineProps(['list'])
</script>
<style scoped>
@import "../assets/css/common.css";
@import "../assets/css/post-chunk.css";
</style>
