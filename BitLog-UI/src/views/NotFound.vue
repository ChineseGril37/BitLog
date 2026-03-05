<template>
  <v-container class="main_container d-flex align-center justify-center">
    <div class="not-found-page text-center">
      <v-icon size="120" color="grey-lighten-1">mdi-emoticon-sad-outline</v-icon>
      <h1 class="text-h2 font-weight-bold mt-4 mb-2">404</h1>
      <p class="text-h5 text-grey-darken-1 mb-6">页面未找到</p>
      <p class="text-body-1 text-grey mb-8">
        抱歉，您访问的页面不存在或已被移动
      </p>
      <v-btn 
        color="primary" 
        size="large"
        @click="goHome"
        prepend-icon="mdi-home"
      >
        返回首页
      </v-btn>
    </div>
  </v-container>
</template>

<script setup lang="ts">
import { useRouter } from 'vue-router'

const router = useRouter()

function goHome() {
  router.push({ name: 'home' })
}
</script>

<style scoped>
@import "../assets/css/common.css";

.not-found-page {
  min-height: 60vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>