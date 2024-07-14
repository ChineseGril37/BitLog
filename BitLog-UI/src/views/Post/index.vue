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
            <!-- 博客内容 -->
            <div>姓名：{{person.name}}</div>
            <div>年龄：{{person.age}}</div>
            <div>电话：{{person.tel}}</div>
            <hr>
            <v-btn @click="changeName">改名</v-btn>
          </v-sheet>
        </v-col>
      </v-row>
    </v-container>
  </v-main>
</template>

<script setup lang="ts" name="Post">
import { ref } from 'vue'
  import request from '@/plugins/axios'
  let person = ref({
    name:'张三',
    age:18,
    tel:13888888888
  })
  let sideBar = ref([
    {title:'热门',type:''},
    {title:'Java',type:'Java'},
    {title:'Spring Boot',type:'SpringBoot'},
    {title:'Redis',type:'Redis'},
    {title:'数据库',type:'Database'},
    {title:'Vue',type:'Vue'}
  ])
  function changeName(){
    person.value.name = '李四'
  }
  function sort(type){
    request.get('post/sort',{params:{type:type}}).then(res=>{
      if(res.status == 0){
        console.log(res.data.list)
      }else {
        alert(res.message)
      }
    })
  }
</script>

<style scoped>
.background{
  height: 100%;
  padding-top: 12px;
}
</style>
