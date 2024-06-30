<template>
  <v-layout class="rounded rounded-md background">
    <v-app-bar class="home_header" color="surface-variant" title="BitLog">
      <div>Application bar</div>
      <button>这是一个按钮</button>
    </v-app-bar>
    <v-navigation-drawer>
      <v-list>
        <v-list-item></v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-main class="d-flex align-center justify-center" style="min-height: 300px;">
      Main Content
    </v-main>
  </v-layout>
</template>
<script setup lang="ts">

</script>

<style scoped>
.background{
  font-family: Sinter-Regular,system-ui;
  background-color: rgb(255, 255, 255);
  color: black;
  height: 100%;
}
.home_header{
  color: black;
  background-color: rgba(251,251,253);
  font-size: 200%;
  height: 5%;
}
</style>
