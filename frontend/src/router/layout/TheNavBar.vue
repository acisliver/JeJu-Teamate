<template>
  <div class="the-nav-bar">
    <v-app-bar
      color="primary"
    >
<!--      <v-app-bar-nav-icon class="white&#45;&#45;text"></v-app-bar-nav-icon>-->
      <v-toolbar-title>
        <strong class="heading white--text">Jeju Teammate</strong>
      </v-toolbar-title>

      <v-spacer/>

      <v-toolbar-items id="menu">
        <router-link :to="{name: 'find-team'}" class="white--text">팀 찾기</router-link>
        <router-link :to="{name: 'register-team'}" class="white--text">팀 등록</router-link>
        <router-link :to="{name: 'login'}" class="white--text">로그인</router-link>
        <router-link :to="{name: 'sign-up'}" class="white--text">회원가입</router-link>
      </v-toolbar-items>
    </v-app-bar>
  </div>
</template>

<script>
export default {
  name: "TheNavBar"
}
</script>

<style lang="scss">
#menu{
  display: flex;
  align-items: center;
}
a {
  text-decoration: none;
  font-weight: bold;
  color: #2c3e50;
  align-items: center;
  padding-left: 1rem;

  &.router-link-exact-active {
     color: rgba(53, 210, 25, 0.47);
   }
}

</style>