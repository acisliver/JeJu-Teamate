<template>
  <div class="update-recruit">
    <h2>이력서 수정</h2>
    <v-textarea
        v-model="recruit.content"
        filled
        rows="4"
        height="600"
    ></v-textarea>
    <v-btn @click="updateContent()">저장</v-btn>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "UpdateRecruit",
  props: {
    recruit: {
      type: Object,
      required: true
    }
  },
  methods: {
    updateContent(contentObj){
      let config = {
        headers: {
          token: localStorage.getItem('token')
        }
      }
      console.log(contentObj)
      axios
          .put('/api/update-recruit', contentObj, config)
          .then(res => {
            alert('수정 완료')
            console.log(res)
            this.$router.back()
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