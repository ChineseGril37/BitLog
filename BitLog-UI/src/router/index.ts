import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history:createWebHistory(),//路由器工作模式
  routes://路由规则
  [
    {
      path: '/',
      name: 'Home',
      redirect:'/post',
      component: () => import('../views/Home.vue'),
      children:[
        {
          path: '/post',
          name: 'post',
          component: () => import('../views/Post/index.vue'),
        },
        {
          path: '/article',
          name: 'article',
          component: () => import('../views/Post/Article.vue'),
        },
        {
          path: '/mood',
          name: 'mood',
          component: () => import('../views/Mood/index.vue'),
        },
        {
          path: '/resource',
          name: 'resource',
          component: () => import('../views/Resource/index.vue'),
        },
        {
          path: '/friends',
          name: 'friend',
          component: () => import('@/views/Friends/index.vue'),
        }
      ]
    },
  ]
})
export default router
