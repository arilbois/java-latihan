import { createApp } from 'vue'
import App from './App.vue'

import './assets/main.css'

import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
Vue.config.productionTip = false

createApp(App).mount('#app')

new Vue({
  render: h => h(App),
}).$mount('#app')