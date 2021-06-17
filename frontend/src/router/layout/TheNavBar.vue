<template>
  <div class="the-nav-bar">
    <v-app-bar
      color="primary"
    >

      <v-toolbar-title>
        <strong class="heading white--text" type="button" @click="$router.push({name: 'home'})">Jeju Teammate</strong>
      </v-toolbar-title>

      <v-spacer/>

      <v-toolbar-items id="menu">
        <router-link :to="{name: 'find-team'}" class="white--text">팀 찾기</router-link>
        <router-link :to="{name: 'register-team'}" class="white--text">팀 등록</router-link>
        <router-link v-if="!isLogin" :to="{name: 'login'}" class="white--text">로그인</router-link>
        <router-link v-if="!isLogin" :to="{name: 'sign-up'}" class="white--text">회원가입</router-link>
        <v-menu offset-y v-if="isLogin">
          <template v-slot:activator="{ on, attrs }">
            <v-btn
                text
                dark
                v-bind="attrs"
                v-on="on"
                icon
            >
              <v-app-bar-nav-icon class="white--text"></v-app-bar-nav-icon>
            </v-btn>
          </template>
          <v-list class="loginedBtn">
            <v-list-item>
              <v-list-item-title>
                <router-link :to="{
                    name: 'my-page',
                    // params: {
                    //   username: userInfo.userName
                    // }
                }">마이페이지</router-link></v-list-item-title>
            </v-list-item>
            <v-list-item>
              <v-list-item-title
                  @click="$store.dispatch('userStore/logoutAction')"
              ><router-link :to="{name: 'Home'}">로그아웃</router-link></v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </v-toolbar-items>
    </v-app-bar>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: "TheNavBar",
  data() {
    return{

    }
  },
  computed: {
    ...mapState({
      isLogin: state => state.userStore.isLogin
    })
  }
}
</script>

<style lang="scss">
#menu{
  display: flex;
  align-items: center;
}
.v-toolbar__content{
  padding: 30px;
  button{
    text-decoration: none;
    font-weight: bold;
    color: #2c3e50;
    padding: 10px;
  }
  a {
    text-decoration: none;
    font-weight: bold;
    color: #2c3e50;
    padding: 10px;

    &.router-link-exact-active {
      color: #1976d2;
    }
  }
}

//마이페이지
.loginedBtn a{
  text-decoration: none;
  font-weight: bold;
  color: #2c3e50;
  padding: 10px;
}

//로그아웃
.loginedBtn a{
  text-decoration: none;
  font-weight: bold;
  color: black;
  padding: 10px;

}

</style>