<template>
  <div>人员信息：</div>
  <hr>
  <div>姓名：{{person.name}}</div>
  <hr>
  <button @click="changeName">改名</button>
</template>

<script setup lang="ts" name="Post">
  import {ref} from 'vue'
  let person = ref({
    name:'张三',
    age:18,
    tel:13888888888
  })
  function changeName(){
    person.value.name = '李四'
  }
</script>

<style scoped>

</style>
