import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(), // 路由器工作模式
  routes: [ // 路由规则
    {
      path: '/',
      component: () => import('../layouts/MainLayout.vue'),
      children: [
        {
          path: '',
          name: 'home',
          component: () => import('../views/HomePage.vue')
        },
        {
          path: 'blog',
          component: () => import('../layouts/BlogLayout.vue'),
          children: [
            {
              path: '',
              name: 'blog-list',
              component: () => import('../views/blog/BlogList.vue')
            },
            {
              path: ':id(\\d+)', // 限制id必须为数字
              name: 'blog-detail',
              component: () => import('../views/blog/BlogDetail.vue'),
              props: true // 将路由参数作为props传递给组件
            }
          ]
        },
        {
          path: 'mood',
          name: 'mood',
          component: () => import('../views/Mood/MoodPage.vue')
        },
        {
          path: 'resources',
          name: 'resources',
          component: () => import('../views/resources/ResourcesPage.vue')
        },
        {
          path: 'friends',
          name: 'friends',
          component: () => import('../views/Friends/FriendsPage.vue')
        }
      ]
    },
    // 重定向旧路由到新路由，保持向后兼容
    {
      path: '/post',
      redirect: '/blog'
    },
    {
      path: '/article',
      redirect: (to) => {
        // 如果有查询参数id，重定向到对应的文章详情页
        if (to.query.id) {
          return `/blog/${to.query.id}`
        }
        return '/blog'
      }
    },
    {
      path: '/resource',
      redirect: '/resources'
    },
    // 404页面
    {
      path: '/:pathMatch(.*)*',
      name: 'not-found',
      component: () => import('../views/NotFound.vue')
    }
  ]
})

// 路由守卫 - 确保路由参数的有效性
router.beforeEach((to, from, next) => {
  // 验证博客详情页的id参数
  if (to.name === 'blog-detail') {
    const id = to.params.id
    if (!id || isNaN(Number(id))) {
      // 如果id无效，重定向到博客列表页
      next({ name: 'blog-list' })
      return
    }
  }
  next()
})

export default router
