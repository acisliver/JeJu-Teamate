<template>
  <div class="the-footer">
    <v-footer
        dark
        padless
    >
      <v-card
          class="flex"
          flat
          tile
      >
        <v-card-title class="secondary">
          <strong class="subheading">Get connected with us on SNS</strong>

          <v-spacer></v-spacer>

          <v-btn
              v-for="icon in icons"
              :key="icon"
              class="mx-4"
              dark
              icon
          >
            <v-icon size="24px">
              {{ icon }}
            </v-icon>
          </v-btn>
        </v-card-title>

        <v-card-text class="py-2 white--text text-center">
          {{ new Date().getFullYear() }} — <strong>포털서비스개발론</strong>
        </v-card-text>
      </v-card>
    </v-footer>
  </div>
</template>

<script>
export default {
  name: "TheFooter",
  data: () => ({
    icons: [
      'mdi-facebook',
      'mdi-instagram',
      'mdi-email ',
    ],
  }),
}
</script>

<style scoped>
  .the-footer{
    width: 100%;
    /*하단고정*/
    position: absolute;
    bottom:0;
  }
</style>