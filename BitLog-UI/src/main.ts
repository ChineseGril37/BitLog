/**
 * main.ts
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */
//外部引入全局字体
import "@/assets/font/Sinter-font/Sinter-font.css"
// Plugins
import { registerPlugins } from '@/plugins/vuetify/index'

// Components
import App from './App.vue' // 引入App根组件
// Composables
import  { createApp } from 'vue'  // 引入createApp用于创建应用
import router from '@/router' // 引入路由器
const app = createApp(App)  // 创建一个名为app的应用
registerPlugins(app)
// 使用路由器
app.use(router)
// 挂载整个应用到app容器中
app.mount('#app')
