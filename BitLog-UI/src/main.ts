/**
 * main.ts
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */
//外部引入全局字体
import "@/assets/font/Sinter-font/Sinter-font.css"
// Plugins
import { registerPlugins } from '@/plugins'

// Components
import App from './App.vue'

// Composables
import { createApp } from 'vue'

const app = createApp(App)

registerPlugins(app)

app.mount('#app')
