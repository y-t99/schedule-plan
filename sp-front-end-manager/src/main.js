import { createApp } from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import App from './App.vue'
import { setupStore } from './store'
import { router } from './router'

const app = createApp(App);

app.use(VueAxios, axios);
app.use(router);
setupStore(app);
app.mount('#app');