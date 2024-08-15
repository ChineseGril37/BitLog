<template>

  <v-main class="background">
    <v-container class="background">
      <v-row>
        <v-col cols="2">
          <v-sheet rounded="lg">
            <v-list rounded="lg">
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

        <v-col >
          <v-sheet
            min-height="90vh"
            rounded="lg"
            class="font_set"
          >
            <!-- 帖子展示框 -->

            <div>{{postList}}</div>
            <div>{{postList[0]}}</div>
          </v-sheet>
        </v-col>
      </v-row>
    </v-container>
  </v-main>
</template>

<script setup lang="ts" name="Post">
import { onMounted, ref } from 'vue'
import request from '@/api/axios'
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
let sideBar = ref([
  {title:'热门'},
  {title:'Java',type:'Java'},
  {title:'Vue',type:'Vue'},
  {title:'数据库',type:'Database'},
  {title:'Redis',type:'Redis'},
  {title:'Spring Boot',type:'SpringBoot'},
])
function sort(type){
  request.get('post/sort',{params:{type:type,selectType:'Views'}}).then(res=>{
    postList.value = res.data.list
  })
}
</script>

<style scoped>
.background{
  height: 100%;
  padding-top: 12px;
}
</style>
