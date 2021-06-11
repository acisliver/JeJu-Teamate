<template>
  <div class="my-page-view">
    <h2>마이페이지</h2>
    <h3>개인정보 관리</h3>
    <personal-data/>
    <h3>팀 관리</h3>
    <team-management/>
  </div>
</template>

<script>
export default {
  name: "MyPageView",
  components: {
    PersonalData: () => import("../../components/PersonalData"),
    TeamManagement: () => import("../../components/TeamManagement")
  }
}
</script>

<style scoped>

</style>