<template>

  <v-main class="main_background">
    <v-container class="main_container">
      <v-row>
        <v-col cols="2" class="list_col">
          <v-sheet class="border_radius">
            <v-list class="border_radius">
              <v-list-item
                v-for="n in sideBar"
                :key="n.title"
                :title="`${n.title}`"
                link
                class="font_set"
                @click="sort(n.type)"
              ></v-list-item>
            </v-list>
          </v-sheet>
        </v-col>

        <v-col class="list_col">
          <v-sheet
            min-height="188dvh"
            class="font_set post_sheet border_radius"
          >
            <!-- 排序筛选器 -->

            <!-- 帖子展示框 -->
            <post-chunk
              class="post_chunk"
              v-for="postInfo in postList"
              :list="postInfo"
            ></post-chunk>
          </v-sheet>
        </v-col>
      </v-row>
    </v-container>
  </v-main>
</template>

<script setup lang="ts" name="Post">
import { onMounted, ref } from 'vue'
import request from '@/api/axios'
import PostChunk from '@/components/postChunk.vue'
onMounted(() => {
  /*
  console.log(`the component is now mounted.postList=`)
  console.log(postList)
  */
  fetchData()
})
let postList = ref()
function fetchData(){
  sort()
}
let sideBar = [
  {title:'热门'},
  {title:'Java',type:'Java'},
  {title:'Vue',type:'Vue'},
  {title:'数据库',type:'Database'},
  {title:'Redis',type:'Redis'},
  {title:'Spring Boot',type:'SpringBoot'}]
function sort(type){
  request.get('post/sort',{params:{type:type,selectType:'Views'}}).then(res=>{
    postList.value = res.data.list
  })
}
</script>

<style scoped src="../../assets/css/Post.css">
</style>
