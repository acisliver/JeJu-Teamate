<template>
  <div class="sign-up row justify-center">
    <v-card style="width: 20rem; margin: 5rem;">
      <v-card-text>
        <v-text-field
            v-model="userName"
            :rules="[rules.requiredRule]"
            label="아이디"
            required
        ></v-text-field>
        <v-text-field
            v-model="password"
            :rules="[rules.requiredRule]"
            label="비밀번호"
            maxlength="25"
            counter="25"
            required
            :append-icon="isShow1 ? 'mdi-eye' : 'mdi-eye-off'"
            :type="isShow1 ? 'text' : 'password'"
            @click:append="isShow1 = !isShow1"
        ></v-text-field>
        <v-text-field
            v-model="rePassword"
            :rules="[rules.requiredRule]"
            label="비밀번호 재입력"
            maxlength="25"
            counter="25"
            required
            :append-icon="isShow2 ? 'mdi-eye' : 'mdi-eye-off'"
            :type="isShow2 ? 'text' : 'password'"
            @click:append="isShow2 = !isShow2"
        ></v-text-field>
        <v-select
            :items="roles"
            v-model="role"
            dense
            filled
            label="분야를 정해주세요"
            class="ma-0 mt-1"
        ></v-select>
      </v-card-text>

      <v-divider class="mt-12"></v-divider>

      <v-card-actions>
        <v-btn
            text
            @click="$router.back()"
        >
          취소
        </v-btn>
        <v-spacer></v-spacer>

        <v-btn
            color="primary"
            text
            @click="signup({userName, password, role}), validatePassword({password, rePassword})"
        >
          제출
        </v-btn>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "SignUpView",
  data () {
    return {
      userName: null,
      password: null,
      rePassword: null,
      isShow1: false,
      isShow2: false,
      roles: ["프로그래머", "디자이너", "기획자"],
      role: null,
      rules: {
        requiredRule: v => !!v || '필수입력입니다.',
        maxCharRule: v => v.length <= 25 || '최대 25자 입니다',
        passwordRule: v => {
          //8-25자리 비밀번호
          const pattern = /^.*(?=^.{8,25}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/
          return pattern.test(v) || '비밀번호 형식이 맞지 않습니다'
        },
        emailRule: v => {
          const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
          return pattern.test(v) || '이메일 형식이 아닙니다'
        },
        phoneNumRule: v => {
          const pattern = /^\d{3}-\d{3,4}-\d{4}$/;
          return pattern.test(v) || '전화번호 형식이 맞지 않습니다'
        }
      },
    }
  },
  methods: {
    validatePassword(password, repassword){
      if(password !==repassword){
        return
      }
    },
    signup(signupObj) {
      console.log(signupObj)
      axios
          .post("/api/signup",signupObj)
          .then(res => {
            this.$router.push({ name: "Login"})
            console.log(res.data)
          })
          .catch(err => {
            console.log(err)
          })
    }
  }
}
</script>

<style scoped>

</style>