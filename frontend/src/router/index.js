import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

//새로고침 에러 처리
const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(() => {
    return window.location.reload()
  })
};

const routes = []

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router



