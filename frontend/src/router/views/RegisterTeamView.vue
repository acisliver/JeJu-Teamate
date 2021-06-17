<template>
  <div class="register-team-view row justify-center">
    <h2>팀 등록</h2>
    <v-card style="width: 20rem; margin: 5rem;">
      <v-card-text>
        <v-text-field
            v-model="name"
            :rules="[rules.requiredRule]"
            label="팀명"
            required
        ></v-text-field>
        <v-text-field
            v-model="intro"
            :rules="[rules.requiredRule]"
            label="소개"
            required
        ></v-text-field>
        <v-select
            :items="fields"
            v-model="field"
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
            @click="register({name, intro, field})"
        >
          등록
        </v-btn>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "RegisterTeamView",
  data() {
    return {
      name: null,
      intro: null,
      field: null,
      fields: ["웹", "안드로이드", "iOS", "게임", "IoT", "기타"],
      rules: {
        requiredRule: v => !!v || '필수입력입니다.',
        maxCharRule: v => v.length <= 25 || '최대 25자 입니다',
        emailRule: v => {
          const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
          return pattern.test(v) || '이메일 형식이 아닙니다'
        },
      },
    }
  },
  methods: {
    register(teamObj) {
      const config = {
          headers: {
            token: localStorage.getItem("token")
        }
      }

      console.log(teamObj)
      axios.post("/api/user/register-team",teamObj, config)
          .then(res => {
            alert("팀 등록 완료")
            console.log(res)
            this.$router.push({name: "home"})
          })
          .catch(err => {
            alert("팀 등록 실패")
            console.log(err)
          })
    }
  }
}
</script>

<style scoped>

</style>