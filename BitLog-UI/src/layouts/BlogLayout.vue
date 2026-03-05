<template>
  <v-container class="main_container d-flex flex-row">
    <!-- 侧边栏 -->
    <aside class="blog-sidebar">
      <div class="float_fix">
        <div class="list_float">
          <v-sheet class="border_radius">
            <v-list class="border_radius">
              <v-list-item
                class="font_set"
                v-for="category in categories"
                :key="category.title"
                :title="category.title"
                link
                @click="handleCategoryClick(category)"
              ></v-list-item>
            </v-list>
          </v-sheet>
        </div>
      </div>
    </aside>

    <!-- 主内容区域 -->
    <main class="blog-content">
      <router-view @category-change="handleCategoryChange" />
    </main>
  </v-container>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()

const categories = ref([
  { title: '热门', type: '' },
  { title: 'Java', type: 'Java' },
  { title: 'Vue', type: 'Vue' },
  { title: 'Spring Boot', type: 'SpringBoot' },
  { title: 'BitLog', type: 'BitLog' },
  { title: 'Redis', type: 'Redis' },
])

const emit = defineEmits(['category-change'])

function handleCategoryClick(category: any) {
  // 如果当前在博客详情页，跳转到博客列表页并应用筛选
  if (router.currentRoute.value.name === 'blog-detail') {
    router.push({ 
      name: 'blog-list', 
      query: { category: category.type } 
    })
  } else {
    // 如果在博客列表页，直接触发筛选
    emit('category-change', category.type)
  }
}

function handleCategoryChange(categoryType: string) {
  emit('category-change', categoryType)
}
</script>

<style scoped>
@import "../assets/css/common.css";
@import "../assets/css/post.css";

.blog-sidebar {
  flex: 0 0 250px;
  margin-right: 1rem;
}

.blog-content {
  flex: 1;
  min-width: 0;
}

.float_fix {
  position: sticky;
  top: 100px;
}
</style>