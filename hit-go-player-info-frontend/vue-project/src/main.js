import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import Axios from 'axios'

const app = createApp(App)

app.use(createPinia())


app.use(ElementPlus)

app.mount('#app')
