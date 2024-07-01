import { createApp } from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import App from './App.vue'
import { router } from './router'
import { setupStore } from './store'


const app = createApp(App);

app.use(VueAxios, axios);

app.use(router);
setupStore(app);
app.mount('#app');