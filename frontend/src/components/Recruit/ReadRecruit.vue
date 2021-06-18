<template>
  <div class="read-recruit">
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
          <strong class="title">자기소개서</strong>
          <v-spacer></v-spacer>
          <div>
            <v-icon>mdi-account</v-icon>
            {{ recruit.user.nickName }}
          </div>
        </v-row>
        {{ recruit.content }}
      </v-card-text>
    </v-card>
    <v-btn @click="updateRecruit()">수정</v-btn>
    <v-btn @click="deleteRecruit()">삭제</v-btn>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ReadRecruit",
  data() {
    return {
      isUpdate: true,
    }
  },
  props: {
    recruit: {
      type: Object,
      required: true
    },
  },
  methods: {
    updateRecruit(){
      this.$emit("child", this.isUpdate)
      console.log(this.isUpdate)
    },
    deleteRecruit(){
      confirm("삭제하시겠습니까?")
      let config = {
        headers: {
          token: localStorage.getItem('token')
        }
      }
      axios.delete("/api/delete-recruit", config)
          .then(res=>{
            if(res.data === 200) {
              alert("삭제 완료")
              this.$router.push({name:"home"})
            }
          })
          .catch(e => console.log(e))
    }
  }
}
</script>

<style scoped>

</style>