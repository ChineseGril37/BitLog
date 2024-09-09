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
@import "assets/css/common.css";
.background{
  font-family: Sinter-Regular,system-ui;
  background-color: rgb(255, 255, 254);
}
</style>
