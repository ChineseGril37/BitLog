<template>
  <!-- 上导航栏 -->
  <v-app-bar
    scroll-behavior="elevate"
    color="rgb(248, 245, 242)"
    class="font_set rounded"
  >
    <v-container class="d-flex align-center justify-center">
      <!-- 网站抬头logo -->
      <router-link to="/" class="logo_container">
        <img
          src="/BitLog_logo_noBackground.png"
          class="site_logo"
        >
        <div class="site_name logo_font">BitLog</div>
      </router-link>
      <router-link
        class="header_btn font_set"
        v-for="link in navigationLinks"
        :key="link.path"
        :to="link.path"
      >
        {{ link.title }}
      </router-link>
      <v-spacer></v-spacer>
      <v-responsive max-width="260">
        <v-text-field
          density="compact"
          label="搜索"
          rounded="lg"
          variant="solo-filled"
          bg-color="#f45d48"
          hide-details
          single-line
        ></v-text-field>
      </v-responsive>
    </v-container>
  </v-app-bar>

  <!-- 主内容区域 -->
  <v-main>
    <router-view />
  </v-main>

  <!-- 备案和信息栏 -->
  <footer class="more_information font_set">
    <div class="information_container">BitLog</div>
  </footer>
</template>

<script setup lang="ts">
const navigationLinks = [
  { title: '博客', path: '/blog' },
  { title: '随笔', path: '/mood' },
  { title: '资源', path: '/resources' },
  { title: '友链', path: '/friends' },
]
</script>

<style scoped>
@import "../assets/css/common.css";
@import "../assets/css/home.css";

.logo_container {
  display: flex;
  align-items: center;
  text-decoration: none;
  margin-right: 2rem;
}

.site_logo {
  height: 40px;
  margin-right: 8px;
}

.header_btn {
  margin: 0 1rem;
  text-decoration: none;
  color: inherit;
}

.header_btn:hover {
  color: #f45d48;
}

.more_information {
  background-color: rgb(248, 245, 242);
  padding: 1rem;
  text-align: center;
  margin-top: auto;
}
</style>