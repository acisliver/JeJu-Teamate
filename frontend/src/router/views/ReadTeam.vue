<template>
  <div class="read-team">
    <v-card>
      <v-card-text>
        <v-row
            class="mb-4"
            align="center"
        >
          <v-avatar
              color="grey"
              class="mr-4"
          ></v-avatar>
          <strong class="title">팀명: {{ teamInfo.name }}</strong>
          <v-spacer></v-spacer>
          <div>
            <v-icon>mdi-account</v-icon>
            {{ teamInfo.leader.nickName }}
          </div>
        </v-row>
        {{ teamInfo.intro }}
        {{teamInfo.field}}
      </v-card-text>
    </v-card>
    <v-btn @click="register">등록하기</v-btn>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ReadTeam",
  data() {
    return {
      teamInfo: null
    }
  },
  methods: {
    register(){
      console.log("등록")
      const config= {
        headers: {
          token: localStorage.getItem("token")
        }
      }
      axios.post("/api/register-team/"+this.$route.params.teamName, config)
          .then(res=> {
            console.log(res)
            this.$router.push({name: "home"})
          }).catch(e => console.log(e))
    }
  },
  mounted() {

    let params = this.$route.params
    console.log(params)
    axios.get("/api/read-team/" + params.teamName)
        .then(res=> this.teamInfo = res.data)
        .catch(e => console.log(e))
  }
}
</script>

<style scoped>

</style>