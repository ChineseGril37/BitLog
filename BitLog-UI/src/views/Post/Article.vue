<template>
  <v-container class="main_container">
    <div>
      <v-md-preview :text="article.file"></v-md-preview>
<!--      <v-md-editor v-model="article.shortcut" height="400px"></v-md-editor>-->
    </div>
  </v-container>

</template>
<script setup lang="ts">
//首先在setup中定义
import { useRoute } from 'vue-router'
import { onBeforeMount, ref } from 'vue'
import request from '@/api/axios'
// query props传参
const route = useRoute()
const userId = route.query.id
// 使用 ref 来包裹 article 确保其是响应式的
const article = ref({})
// 在页面加载完成前调用fetch函数获取具体文章信息
onBeforeMount(() => {
  fetchArticle()
})
function fetchArticle(){
  request.get('/post/selectById', { params: { id: userId } })
    .then(res => {
      if(res.status === 200){
        article.value = res.data  // 将获取到的数据赋值给 article
        //console.log(article.value)
      }
      else {
        alert(res.message)
      }
    })
}
</script>

<style scoped>
@import "../../assets/css/common.css";
@import "../../assets/css/article.css";
</style>
