/**
 * main.ts
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */
//外部引入全局字体
import "@/assets/font/Sinter-font/Sinter-font.css"
// Plugins
import { registerPlugins } from '@/plugins/vuetify'

// Components
import App from './App.vue' // 引入App根组件
// Composables
import  { createApp } from 'vue'  // 引入createApp用于创建应用
import router from '@/router' // 引入路由器
const app = createApp(App)  // 创建一个名为app的应用
// 引入 v-md-editor 插件，编辑md文件
import VueMarkdownEditor from '@kangc/v-md-editor';
import '@kangc/v-md-editor/lib/style/base-editor.css';
import vuepressTheme from '@kangc/v-md-editor/lib/theme/vuepress.js';
import '@kangc/v-md-editor/lib/theme/style/vuepress.css';
import Prism from 'prismjs';
// 引入预览组件
import VMdPreview from '@kangc/v-md-editor/lib/preview';
import '@kangc/v-md-editor/lib/style/preview.css';
import githubTheme from '@kangc/v-md-editor/lib/theme/github.js';
import '@kangc/v-md-editor/lib/theme/style/github.css';
// highlightjs
import hljs from 'highlight.js';
VMdPreview.use(githubTheme, {
  Hljs: hljs,
});

registerPlugins(app)
// 使用路由器
app.use(router)
// 挂载v-md-editor 插件
VueMarkdownEditor.use(vuepressTheme, {Prism});
app.use(VueMarkdownEditor)
app.use(VMdPreview)
// 挂载整个应用到app容器中
app.mount('#app')
