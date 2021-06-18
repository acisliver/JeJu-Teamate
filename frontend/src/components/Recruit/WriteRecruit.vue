<template>
  <div class="write-recruit">
    <h2>이력서 작성</h2>
    <v-textarea
        v-model="content"
        filled
        rows="4"
        height="600"
    ></v-textarea>
    <v-btn @click="saveContent({content})">저장</v-btn>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "WriteRecruit",
  data() {
    return {
      content: null
    }
  },
  methods: {
    saveContent(contentObj){
      let config = {
        headers: {
          token: localStorage.getItem('token')
        }
      }
      console.log(contentObj)
      axios
          .post('/api/write-recruit', contentObj, config)
          .then(res => {
            alert('저장 완료')
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