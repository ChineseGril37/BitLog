<template>
  <v-app>
    <v-main class="background">
      <router-view></router-view>
    </v-main>
  </v-app>
</template>

<script setup lang="ts">
</script>
<style>
.background{
  font-family: Sinter-Regular,system-ui;
  background-color: rgb(25, 25, 25);
  color:rgba(210,210,210);
}
.font_set{
  color:rgba(210,210,210)
}
</style>
