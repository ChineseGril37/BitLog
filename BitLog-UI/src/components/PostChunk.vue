<template>
  <div class="post_table">
    <a class="font_set article_title"
       href="/post/article"
       @click="pushArticle"
    >
      {{list.title}}</a>
    <div>分类{{list.type}}</div>
    <div>{{list.shortcut}}</div>
    <div>
      <svg width="18" height="18" viewBox="0 0 48 35" fill="none" xmlns="http://www.w3.org/2000/svg"><path d="M24 36C35.0457 36 44 24 44 24C44 24 35.0457 12 24 12C12.9543 12 4 24 4 24C4 24 12.9543 36 24 36Z" fill="none" stroke="#f5f5f7" stroke-width="4" stroke-linejoin="round"/><path d="M24 29C26.7614 29 29 26.7614 29 24C29 21.2386 26.7614 19 24 19C21.2386 19 19 21.2386 19 24C19 26.7614 21.2386 29 24 29Z" fill="none" stroke="#f5f5f7" stroke-width="4" stroke-linejoin="round"/></svg>
      {{list.views}}
    </div>
    <div>
      <svg width="18" height="18" viewBox="0 0 48 41" fill="none" xmlns="http://www.w3.org/2000/svg"><path d="M15 8C8.92487 8 4 12.9249 4 19C4 30 17 40 24 42.3262C31 40 44 30 44 19C44 12.9249 39.0751 8 33 8C29.2797 8 25.9907 9.8469 24 12.6738C22.0093 9.8469 18.7203 8 15 8Z" fill="none" stroke="#f5f5f7" stroke-width="4" stroke-linecap="round" stroke-linejoin="round"/></svg>
      {{list.likes}}
    </div>
  </div>
</template>

<script setup lang="ts">
//挂载props传入的具体博客数据
defineProps(['list'])
function pushArticle(){
  console.log('push article')
  console.log(this.list)
}
</script>
<style scoped>
@import "../assets/css/common.css";
@import "../assets/css/post-chunk.css";
</style>
