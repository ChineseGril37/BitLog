<template>
  <v-container class="main_container">
    <div class="resources-page">
      <header class="page-header mb-6">
        <h1 class="text-h3 font-weight-bold">资源</h1>
        <p class="text-h6 text-grey-darken-1">分享有用的开发资源和工具</p>
      </header>

      <!-- 资源内容区域 -->
      <section class="resources-content">
        <v-card class="pa-6">
          <div class="text-center">
            <v-icon size="64" color="grey-lighten-1">mdi-folder-outline</v-icon>
            <p class="text-h6 mt-4 text-grey-darken-1">资源功能正在开发中...</p>
            <p class="text-body-1 text-grey">即将为您提供丰富的开发资源</p>
          </div>
        </v-card>
      </section>
    </div>
  </v-container>
</template>

<script setup lang="ts">
// 资源页面逻辑
</script>

<style scoped>
@import "../../assets/css/common.css";

.resources-page {
  max-width: 800px;
  margin: 0 auto;
}

.page-header {
  text-align: center;
  padding: 2rem 0;
}

.resources-content {
  margin: 2rem 0;
}
</style>