<template>
  <!--上导航栏-->
    <v-app-bar class="font_set" flat>
      <v-container class="mx-auto d-flex align-center justify-center ">
        <!-- 网站抬头logo -->
        <a href="/">
          <div class="site_name font_set" >BitLog</div>
        </a>
        <RouterLink
          class="header_btn font_set"
          active-class=""
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
            flat
            hide-details
            single-line
          ></v-text-field>
        </v-responsive>
      </v-container>
    </v-app-bar>
  <RouterView></RouterView>
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
.site_name{
  font-weight: 400;
  margin-right: 1dvw;
  font-size: 24px;
  letter-spacing: 1px;
  padding: 2dvw 0;
}
.header_btn{
  padding: 0 1dvw;
  margin: 0 1.5dvw  ;
  font-size: 18px;
}
* {
  text-decoration: none;
}
</style>
