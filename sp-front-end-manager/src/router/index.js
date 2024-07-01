import { createRouter, createWebHistory } from "vue-router";
import WorkTable from '../components/WorkTable.vue';
import Factor from '../components/Factor.vue';
import ModuleDefine from '../components/ModuleDefine.vue'
const routes = [{
        path: "/",
        name: "home",
        component: WorkTable,
    },
    {
        path: "/factor",
        name: "factor",
        component: Factor,
    },
    {
        path: "/module-define",
        name: "module-define",
        component: ModuleDefine,
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

// router.beforeEach((to) => {
//   // 访问非公共资源 且没有登录。
//   if (!to.meta.isPublicResource && !userInfo().isLogin) {
//       return {
//           path: '/login',
//           // 保存我们所在的位置，以便以后再来
//           query: { redirect: to.fullPath },
//       }
//   }
//   // 校验token是否过期
// })

export {
    router
}