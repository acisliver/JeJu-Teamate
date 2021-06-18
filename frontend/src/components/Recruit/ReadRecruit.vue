<template>
  <div class="read-recruit">
    <v-card>
      <v-card-text>
        <v-row
            class="mb-4"
            align="center"
        >
          <v-avatar
              color="grey"
              class="mr-4"
          ></v-avatar>
          <strong class="title">자기소개서</strong>
          <v-spacer></v-spacer>
          <div>
            <v-icon>mdi-account</v-icon>
            {{ recruit.user.nickName }}
          </div>
        </v-row>
        {{ recruit.content }}
      </v-card-text>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "ReadRecruit",
  props: {
    recruit: {
      type: Object,
      required: true
    }
  }
}
</script>

<style scoped>

</style>