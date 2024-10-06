<template>
  <!--上导航栏-->
    <v-app-bar
      scroll-behavior="elevate"
      color="rgb(248, 245, 242)"
      class="font_set rounded"
    >
      <v-container class="d-flex align-center justify-center">
        <!-- 网站抬头logo -->
        <a href="/" class="logo_container">
          <img
            src="../../public/BitLog_logo_noBackground.png"
            class="site_logo"
          >
          <div class="site_name logo_font" >BitLog</div>
        </a>
        <RouterLink
          class="header_btn font_set"
          v-for="link in links"
            :to="link.path"
            :text="link.title"
        >
        </RouterLink>
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
  <keep-alive>
    <RouterView></RouterView>
    <mavon-editor
      model-value="123"
      :toolbarsFlag="false"
      :subfield="false"
      defaultOpen="preview"
    />
  </keep-alive>
  <!--备案和信息栏-->
  <div class="more_information font_set">
    <div class="information_container">BitLog</div>
  </div>
</template>


<script>
import Post from '@/views/Post/index.vue'
export default {
  components: { Post },
  data: () => ({
    links: [
      {title:'博客',path:'/post'},
      {title:'随笔',path:'/mood'},
      {title:'资源',path:'/resource'},
      {title:'友链',path:'/friends'},
    ],
  }),
}
</script>

<style scoped>
@import "../assets/css/common.css";
@import "../assets/css/home.css";
</style>
