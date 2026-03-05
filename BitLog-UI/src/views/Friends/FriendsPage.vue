<template>
  <v-container class="main_container">
    <div class="friends-page">
      <header class="page-header mb-6">
        <h1 class="text-h3 font-weight-bold">友链</h1>
        <p class="text-h6 text-grey-darken-1">与志同道合的朋友们互相学习</p>
      </header>

      <!-- 友链内容区域 -->
      <section class="friends-content">
        <v-card class="pa-6">
          <div class="text-center">
            <v-icon size="64" color="grey-lighten-1">mdi-account-group-outline</v-icon>
            <p class="text-h6 mt-4 text-grey-darken-1">友链功能正在开发中...</p>
            <p class="text-body-1 text-grey">期待与更多朋友建立联系</p>
          </div>
        </v-card>
      </section>
    </div>
  </v-container>
</template>

<script setup lang="ts">
// 友链页面逻辑
</script>

<style scoped>
@import "../../assets/css/common.css";

.friends-page {
  max-width: 800px;
  margin: 0 auto;
}

.page-header {
  text-align: center;
  padding: 2rem 0;
}

.friends-content {
  margin: 2rem 0;
}
</style>