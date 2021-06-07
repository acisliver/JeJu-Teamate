<template>
  <div class="the-view">
    <div class="container">
      <router-view/>
    </div>
  </div>
</template>

<script>
export default {
  name: "TheView"
}
</script>

<style scoped>
  .container{
    text-align: center;
    justify-content: center;
  }
</style>