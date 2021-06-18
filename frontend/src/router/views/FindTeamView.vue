<template>
  <div class="recruit-board">
    <h2>팀 찾기</h2>
    <find-team :board-name="boardName" :title="title" :header="header" :page-size="pageSize"/>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "RecruitBoardView",
  data() {
    return {
      boardName: "팀원 모집",
      title: "팀명",
      header: null,
      pageSize: 10,
    }
  },
  components: {
    FindTeam: () => import("../../components/Pagination")
  },
  mounted() {
    axios.get("/api/find-team")
        .then(res =>{
          this.header = res.data
          console.log(this.header)
        })
  }
}
</script>

<style scoped>

</style>