<template>
  <div class="blog-detail">
    <!-- 文章头部信息 -->
    <header v-if="article.title" class="article-header mb-4">
      <h1 class="article-title">{{ article.title }}</h1>
      <div class="article-meta">
        <span class="meta-item">
          <v-icon size="small">mdi-calendar</v-icon>
          {{ formatDate(article.createtime) }}
        </span>
        <span class="meta-item">
          <v-icon size="small">mdi-eye</v-icon>
          {{ article.views || 0 }} 次阅读
        </span>
        <span class="meta-item">
          <v-icon size="small">mdi-heart</v-icon>
          {{ article.likes || 0 }} 点赞
        </span>
        <span v-if="article.type" class="meta-item">
          <v-chip size="small" color="primary" variant="outlined">
            {{ article.type }}
          </v-chip>
        </span>
      </div>
    </header>

    <!-- Markdown 内容 -->
    <article class="article-content">
      <v-md-preview 
        v-if="article.file" 
        :text="article.file"
        class="markdown-content"
      />
      
      <!-- 加载状态 -->
      <div v-else-if="loading" class="text-center pa-8">
        <v-progress-circular indeterminate color="primary" />
        <p class="mt-4">正在加载文章内容...</p>
      </div>
      
      <!-- 错误状态 -->
      <div v-else class="text-center pa-8">
        <v-icon size="64" color="error">mdi-alert-circle-outline</v-icon>
        <p class="text-h6 mt-4">文章内容加载失败</p>
        <v-btn @click="fetchArticle" color="primary" class="mt-4">
          重新加载
        </v-btn>
      </div>
    </article>

    <!-- 返回按钮 -->
    <div class="article-actions mt-6">
      <v-btn 
        @click="goBack" 
        color="primary" 
        variant="outlined"
        prepend-icon="mdi-arrow-left"
      >
        返回列表
      </v-btn>
    </div>
  </div>
</template>

<script setup lang="ts">
import { onBeforeMount, ref } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import request from '@/api/axios'

const route = useRoute()
const router = useRouter()

const article = ref<any>({})
const loading = ref(false)

// 获取文章ID
const articleId = route.params.id

onBeforeMount(() => {
  if (articleId) {
    fetchArticle()
  } else {
    console.error('文章ID不存在')
    router.push({ name: 'blog-list' })
  }
})

async function fetchArticle() {
  loading.value = true
  try {
    const response = await request.get('/post/selectById', { 
      params: { id: articleId } 
    })
    
    if (response.status === 200) {
      article.value = response.data
    } else {
      console.error('获取文章失败:', response.message)
      alert(response.message || '获取文章失败')
    }
  } catch (error) {
    console.error('获取文章出错:', error)
    alert('获取文章出错，请稍后重试')
  } finally {
    loading.value = false
  }
}

function formatDate(dateString: string) {
  if (!dateString) return ''
  const date = new Date(dateString)
  return date.toLocaleDateString('zh-CN', {
    year: 'numeric',
    month: 'long',
    day: 'numeric'
  })
}

function goBack() {
  router.push({ name: 'blog-list' })
}
</script>

<style scoped>
@import "../../assets/css/common.css";
@import "../../assets/css/article.css";

.blog-detail {
  max-width: 100%;
  margin: 0 auto;
  padding: 1rem;
}

.article-header {
  border-bottom: 1px solid #e0e0e0;
  padding-bottom: 1rem;
}

.article-title {
  font-size: 2rem;
  font-weight: 600;
  color: #1a1a1a;
  margin-bottom: 1rem;
  line-height: 1.3;
}

.article-meta {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
  align-items: center;
}

.meta-item {
  display: flex;
  align-items: center;
  gap: 0.25rem;
  color: #666;
  font-size: 0.875rem;
}

.article-content {
  margin: 2rem 0;
}

.markdown-content {
  background: transparent;
}

.article-actions {
  border-top: 1px solid #e0e0e0;
  padding-top: 1rem;
}

@media (max-width: 768px) {
  .blog-detail {
    padding: 0.5rem;
  }
  
  .article-title {
    font-size: 1.5rem;
  }
  
  .article-meta {
    gap: 0.5rem;
  }
}
</style>