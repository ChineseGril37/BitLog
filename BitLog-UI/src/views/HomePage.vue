<template>
  <div class="home-page">
    <v-container class="main_container">
      <!-- 欢迎区域 -->
      <section class="welcome-section text-center py-12">
        <h1 class="display-1 font-weight-bold mb-4">欢迎来到 BitLog</h1>
        <p class="text-h6 text-grey-darken-1 mb-8">
          记录技术成长，分享编程心得
        </p>
        <v-btn 
          color="primary" 
          size="large" 
          @click="navigateToBlog"
          class="mr-4"
        >
          开始阅读
        </v-btn>
        <v-btn 
          color="secondary" 
          size="large" 
          variant="outlined"
          @click="navigateToMood"
        >
          查看随笔
        </v-btn>
      </section>

      <!-- 最新文章预览 -->
      <section class="recent-posts py-8">
        <h2 class="text-h4 mb-6">最新文章</h2>
        <v-row>
          <v-col 
            v-for="post in recentPosts" 
            :key="post.id"
            cols="12" 
            md="6" 
            lg="4"
          >
            <v-card 
              class="post-card h-100"
              @click="navigateToPost(post.id)"
              hover
            >
              <v-card-title class="text-h6">
                {{ post.title }}
              </v-card-title>
              <v-card-text>
                <p class="text-body-2 text-grey-darken-1">
                  {{ post.shortcut || '暂无摘要' }}
                </p>
                <div class="mt-4">
                  <v-chip 
                    v-if="post.type" 
                    size="small" 
                    color="primary" 
                    variant="outlined"
                    class="mr-2"
                  >
                    {{ post.type }}
                  </v-chip>
                  <span class="text-caption text-grey">
                    {{ formatDate(post.createtime) }}
                  </span>
                </div>
              </v-card-text>
            </v-card>
          </v-col>
        </v-row>
        
        <div class="text-center mt-8">
          <v-btn 
            color="primary" 
            variant="outlined"
            @click="navigateToBlog"
          >
            查看更多文章
          </v-btn>
        </div>
      </section>
    </v-container>
  </div>
</template>

<script setup lang="ts">
import { onMounted, ref } from 'vue'
import { useRouter } from 'vue-router'
import request from '@/api/axios'

const router = useRouter()
const recentPosts = ref([])

onMounted(() => {
  fetchRecentPosts()
})

async function fetchRecentPosts() {
  try {
    const response = await request.get('post/list')
    if (response.status === 200) {
      // 获取最新的6篇文章
      recentPosts.value = (response.data.list || []).slice(0, 6)
    }
  } catch (error) {
    console.error('获取最新文章失败:', error)
  }
}

function navigateToBlog() {
  router.push({ name: 'blog-list' })
}

function navigateToMood() {
  router.push({ name: 'mood' })
}

function navigateToPost(postId: number) {
  router.push({ 
    name: 'blog-detail', 
    params: { id: postId } 
  })
}

function formatDate(dateString: string) {
  if (!dateString) return ''
  const date = new Date(dateString)
  return date.toLocaleDateString('zh-CN')
}
</script>

<style scoped>
@import "../assets/css/common.css";

.home-page {
  min-height: 100vh;
}

.welcome-section {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
  border-radius: 12px;
  margin: 2rem 0;
}

.recent-posts {
  margin: 2rem 0;
}

.post-card {
  cursor: pointer;
  transition: transform 0.2s ease-in-out;
}

.post-card:hover {
  transform: translateY(-4px);
}

@media (max-width: 768px) {
  .welcome-section {
    padding: 2rem 1rem;
  }
  
  .welcome-section h1 {
    font-size: 2rem;
  }
}
</style>