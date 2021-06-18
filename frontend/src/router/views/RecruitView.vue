<template>
  <div class="recruit-view">
    <h2>나의 이력서</h2>
    <write-recruit v-if="!exist"/>
    <read-recruit v-if="exist" :recruit="exist"/>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "RecruitView",
  data() {
    return {
      exist: null
    }
  },
  components: {
    WriteRecruit: () => import("../../components/Recruit/WriteRecruit"),
    ReadRecruit: () => import("../../components/Recruit/ReadRecruit")
  },
  mounted() {
    const config = {
      headers: {
        token: localStorage.getItem("token")
      }
    }
    axios.get("/api/read-recruit", config)
        .then(res => {
          if(res.data === null)
            this.exist = null
          else this.exist = res.data
        })
        .catch(e => console.log(e))
  }
}
</script>

<style scoped>

</style>