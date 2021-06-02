<template>
  <div id="app">


  </div>
</template>

<script>
import request from "request"

export default {
  name: 'App',
  components: {

  },
  methods: {
    helloApi() {
      request('http://localhost:8080/api/hello', function (e, res, body){
        console.log('error', e)
        console.log('statusCode', res && res.statusCode)
        console.log('body', body)
      })
    }
  },
  mounted() {
    this.helloApi()
  }
}
</script>

<style>

</style>
