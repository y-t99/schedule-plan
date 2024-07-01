import { createRouter, createWebHistory } from "vue-router";
import Schedule from "../components/Schedule.vue";
import YPlan from "../components/YPlan.vue";
import Index from '../view/Index.vue'
import IndexAnimation from "../components/IndexAnimation.vue"
import Login from '../view/Login.vue';
import Test from '../view/Test.vue';
import YDataSheet from '../components/datasheet/YDataSheet.vue';
import YHistory from '../components/YHistory.vue';
import { userInfo, } from '../service/config';

const routes = [{
        path: "/",
        name: "index",
        component: Index,
        children: [{
                path: "/",
                name: "indexAnimation",
                component: IndexAnimation,
            },
            {
                path: "/schedule",
                name: "schedule",
                component: Schedule
            },
            {
                path: "/plan",
                name: "plan",
                component: YPlan
            },
            {
                path: "/history",
                name: "history",
                component: YHistory
            },
            {
                path: "/datasheet",
                name: "datasheet",
                component: YDataSheet
            },
        ]
    },
    {
        path: "/login",
        name: "login",
        component: Login,
        meta: {
            isPublicResource: true,
        }
    },
    {
        path: "/test",
        name: "test",
        component: Test,
        meta: {
            isPublicResource: true,
        }
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

router.beforeEach((to) => {
    // 访问非公共资源 且没有登录。
    if (!to.meta.isPublicResource && !userInfo().isLogin) {
        return {
            path: '/login',
            // 保存我们所在的位置，以便以后再来
            query: { redirect: to.fullPath },
        }
    }
    // 校验token是否过期
})

export {
    router
}