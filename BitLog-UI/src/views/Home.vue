<template>
  <!--上导航栏-->
    <v-app-bar class="font_set" flat>
      <v-container class="mx-auto d-flex align-center justify-center ">
        <div class="site_name font_set">BitLog</div>

        <v-btn
          class="header_btn font_set"
          v-for="link in links"
          :text="link.title"
          @click="header_click(link.url)"
          variant="text"
        ></v-btn>

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

    <v-main class="background">
      <v-container>
        <v-row>
          <v-col cols="2">
            <v-sheet rounded="lg">
              <v-list rounded="lg">
                <v-list-item
                  v-for="n in 5"
                  :key="n"
                  :title="`Java ${n}`"
                  link
                  class="font_set"
                ></v-list-item>

                <v-divider class="my-2"></v-divider>

                <v-list-item
                  color="grey-lighten-4"
                  title="Refresh"
                  class="font_set"
                  link
                ></v-list-item>
              </v-list>
            </v-sheet>
          </v-col>

          <v-col >
            <v-sheet
              min-height="90vh"
              rounded="lg"
              class="font_set"
            >
              <Post/>
              <!--  -->
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
</template>


<script>
import axios from 'axios'
import Post from '@/views/Post/Index.vue'

export default {
  components: { Post },
  data: () => ({
    links: [
      {title:'博客',url:'/post'},
      {title:'随笔',url:'/mood'},
      {title:'资源',url:'/resources'},
      {title:'友链',url:'/friends'},
    ],
  }),
  methods:{
    header_click(url){
      axios.get(url).then(res=>{

      })
    },
  }
}
</script>

<style scoped>
.background{
  font-family: Sinter-Regular,system-ui;
  background-color: rgb(25, 25, 25);
  height: 100%;
  padding-top: 12px;
}
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
.font_set{
  color:rgba(210,210,210);
  font-family: Sinter-Regular,system-ui;
}
</style>
