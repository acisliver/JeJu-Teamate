<template>
  <v-app>
    <the-nav-bar/>

    <the-view/>

    <the-footer/>
  </v-app>
</template>

<script>
import axios from "axios";

export default {
  name: 'App',
  components: {
    TheNavBar: () => import("./router/layout/TheNavBar"),
    TheView: () => import("./router/layout/TheView"),
    TheFooter: () => import("./router/layout/TheFooter"),
  },
  methods: {
    helloApi() {
      axios.get('http://localhost:8080/api/hello')
          .then(res => {
            console.log('body', res.data)
            console.log(res)
          })
          .catch(error => console.log('error', error))
    }
  },
  mounted() {
    this.helloApi()
  }
}
</script>

<style>

</style>
