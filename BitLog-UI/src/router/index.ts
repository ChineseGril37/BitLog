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
          name: '博客',
          component: () => import('../views/Post/index.vue'),
        },
        {
          path: '/post/article',
          name: '文章',
          component: () => import('../views/Post/Article.vue'),
        },
        {
          path: '/mood',
          name: '随笔',
          component: () => import('../views/Mood/index.vue'),
        },
        {
          path: '/resource',
          name: '资源',
          component: () => import('../views/Resource/index.vue'),
        },
        {
          path: '/friends',
          name: '友链',
          component: () => import('@/views/Friends/index.vue'),
        }
      ]
    },
  ]
})
export default router
