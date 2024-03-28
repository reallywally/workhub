import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

// 엘리먼트 플러스
import ElementPlus from 'element-plus'
import'element-plus/dist/index.css'

// 부트스트랩 유틸
import "bootstrap/dist/css/bootstrap-utilities.css"

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(ElementPlus)

app.mount('#app')
