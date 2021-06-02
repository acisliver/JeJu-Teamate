import Vue from 'vue'
import VueRouter from 'vue-router'

//새로고침 시 홈 화면이 아닌 원래 화면이 나타나게 하는 것(SPA 단점)
const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(() => {
        return window.location.reload()
    })
};

const Home =() => import(/* webpackChunkName: "home" */ './views/Home.vue')

const routes = [
    {
        path:'/',
        name:'home',
        component:Home,
    }
]

Vue.use(VueRouter)

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
