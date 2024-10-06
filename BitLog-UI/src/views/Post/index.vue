<template>
    <v-container class="main_container d-flex flex-row">
      <!-- 类型筛选器 -->
      <div class="float_fix">
        <div class="list_float">
          <v-sheet class="border_radius">
            <v-list class="border_radius">
              <v-list-item
                class="font_set"
                v-for="n in sideBar"
                :key="n.title"
                :title="`${n.title}`"
                link
                @click="sort(n.type)"
              ></v-list-item>
            </v-list>
          </v-sheet>
        </div>
      </div>
      <div class=" post_container">
        <v-sheet
          color="#fffffe"
        class="font_set"
      >
        <!-- 排序筛选器 -->

        <!-- 帖子展示框 -->
        <post-chunk
          v-for="postInfo in postList"
          :list="postInfo"
          link
        ></post-chunk>
      </v-sheet>
      </div>
    </v-container>
</template>

<script setup lang="ts" name="Post">
import { onMounted, ref } from 'vue'
import request from '@/api/axios'
import PostChunk from '@/components/PostChunk.vue'
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
  {title:'Spring Boot',type:'SpringBoot'},
  {title:'BitLog',type:'BitLog'},
  {title:'Redis',type:'Redis'},]
function sort(type){
  request.get('post/sort',{params:{type:type,selectType:'Views'}}).then(res=>{
    postList.value = res.data.list
  })
}
</script>

<style scoped>
@import "../../assets/css/post.css";
@import "../../assets/css/common.css";
</style>
