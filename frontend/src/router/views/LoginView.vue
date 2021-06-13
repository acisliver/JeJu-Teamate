<template>
  <div class="login-view row justify-center">
      <v-alert
          :value="failLogin"
          dense
          outlined
          type="error"
      >
        아이디와 비밀번호를 확인해주세요
      </v-alert>

      <v-card style="width: 20rem; margin: 5rem;">
        <v-toolbar flat class="primary">
          <v-toolbar-title class="white--text">로그인</v-toolbar-title>
        </v-toolbar>
        <div class="pa-3">
          <v-text-field
              v-model="eamil"
              label="이메일"
          >
          </v-text-field>
          <v-text-field
              v-model="password"
              :append-icon="isShow ? 'mdi-eye' : 'mdi-eye-off'"
              :type="isShow ? 'text' : 'password'"
              @click:append="isShow = !isShow"
              label="비밀번호"
          >
          </v-text-field>
          <v-btn
              color="primary"
              depressed
              large
              block
              class="mb-2"
              @click="login({userName, password})"
          >로그인
          </v-btn>
          <v-btn
              large
              block
              @click="$router.push({ name:'sign-up' })"
          >
            회원가입
          </v-btn>
        </div>
      </v-card>
      <v-alert
          dense
          outlined
          type="error"
          v-show="failLogin"
      >
        아이디나 비밀번호가 틀렸습니다
      </v-alert>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "LoginView",
  data(){
    return {
      failLogin: false,
      email: '',
      password: '',
      isShow: false,
    }
  },
  methods: {
    login(loginObj){
      console.log(loginObj)
      axios.post("/api/login", loginObj)
          .then(res=>{
            const statusOk = res.status
            if(statusOk === 200){
              console.log("성공")
              localStorage.setItem("X-AUTH-TOKEN", res.headers("X-AUTH-TOKEN"))
              this.$router.push({name: 'home'})
            }
            else if(statusOk === 204){
              this.failLogin = true
            }
          })
    }
  }
}
</script>

<style scoped>

</style>