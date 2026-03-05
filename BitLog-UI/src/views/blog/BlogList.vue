<template>
  <v-sheet color="#fffffe" class="font_set">
    <!-- 博客文章列表 -->
    <post-chunk
      v-for="postInfo in postList"
      :key="postInfo.id"
      :list="postInfo"
      @click="navigateToArticle(postInfo.id)"
    />
    
    <!-- 加载状态 -->
    <div v-if="loading" class="text-center pa-4">
      <v-progress-circular indeterminate color="primary" />
    </div>
    
    <!-- 空状态 -->
    <div v-if="!loading && (!postList || postList.length === 0)" class="text-center pa-8">
      <v-icon size="64" color="grey-lighten-1">mdi-post-outline</v-icon>
      <p class="text-h6 mt-4 text-grey-darken-1">暂无文章</p>
    </div>
  </v-sheet>
</template>

<script setup lang="ts">
import { onMounted, ref, watch } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import request from '@/api/axios'
import PostChunk from '@/components/PostChunk.vue'

const route = useRoute()
const router = useRouter()

const postList = ref([])
const loading = ref(false)

// 监听路由查询参数变化
watch(() => route.query.category, (newCategory) => {
  if (newCategory !== undefined) {
    fetchPosts(newCategory as string)
  }
}, { immediate: true })

onMounted(() => {
  fetchPosts(route.query.category as string || '')
})

async function fetchPosts(categoryType: string = '') {
  loading.value = true
  try {
    const response = await request.get('post/sort', {
      params: {
        type: categoryType,
        selectType: 'Views'
      }
    })
    
    if (response.status === 200) {
      postList.value = response.data.list || []
    } else {
      console.error('获取文章列表失败:', response.message)
      postList.value = []
    }
  } catch (error) {
    console.error('获取文章列表出错:', error)
    postList.value = []
  } finally {
    loading.value = false
  }
}

function navigateToArticle(articleId: number) {
  router.push({
    name: 'blog-detail',
    params: { id: articleId }
  })
}

// 暴露给父组件的方法
defineExpose({
  fetchPosts
})
</script>

<style scoped>
@import "../../assets/css/post.css";
@import "../../assets/css/common.css";
</style>