<template>
  <div class="main_container">id={{id}}</div>
</template>
<script setup lang="ts">
defineProps(['id'])
function fetch(){
  request.get("/post/article",{params:{id:this.id}}).then((res)=>{
    console.log(res)
  })
}
</script>

<style scoped>
@import "../../assets/css/common.css";
@import "../../assets/css/article.css";
</style>
