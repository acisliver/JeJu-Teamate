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

//번들링
const Home = () => import(/* webpackChunkName: "home" */ './views/HomeView')
const RecruitBoard = () => import(/* webpackChunkName: "recruitBoard" */ './views/RecruitBoardView')
const RegisterTeam = () => import(/* webpackChunkName: "registerTeam" */ './views/RegisterTeamView')
const Login = () => import(/* webpackChunkName: "login" */ './views/LoginView')
const MyPage  = () => import(/* webpackChunkName: "login" */ './views/MyPageView')
const SignUp = () => import(/* webpackChunkName: "login" */ './views/SignUpView')

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/recruit-board',
    name: 'recruit-board',
    component: RecruitBoard
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/my-page',
    name: 'my-page',
    component: MyPage
  },
  {
    path: '/sign-up',
    name: 'sign-up',
    component: SignUp
  },
  {
    path: '/register-team',
    name: 'register-team',
    component: RegisterTeam
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router



