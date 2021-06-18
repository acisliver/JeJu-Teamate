<template>
  <div class="recruit-view">
    <h2>나의 이력서</h2>
    <write-recruit v-if="!exist && !isUpdate"/>
    <read-recruit v-if="exist && !isUpdate" :recruit="exist" @child="update"/>
    <update-recruit  v-if="isUpdate" :recruit="exist"/>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "RecruitView",
  data() {
    return {
      exist: null,
      isUpdate: false
    }
  },
  components: {
    WriteRecruit: () => import("../../components/Recruit/WriteRecruit"),
    ReadRecruit: () => import("../../components/Recruit/ReadRecruit"),
    UpdateRecruit: () => import("../../components/Recruit/UpdateRecruit")
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
  },
  methods: {
    update(){
      console.log(1)
      this.isUpdate = true
    }
  }
}
</script>

<style scoped>

</style>