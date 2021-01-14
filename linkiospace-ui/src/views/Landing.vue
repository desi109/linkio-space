<template>
  <v-app>
    <v-parallax dark src="../assets/parallax.jpg">
      <v-layout align-center column>
        <v-container>
          <v-row class="text-center">
            <v-col cols="12">
              <v-img
                :src="require('../assets/logo.png')"
                class="my-3"
                contain
                height="200"
              />
            </v-col>
            <v-col class="mb-2">
              <h1 class="display-2 font-weight-bold mb-3">
                Welcome to Linkio.Space
              </h1>
              <h6 class="subheading fot-weight-regular">
                Build your linked space now!
              </h6>
            </v-col>
          </v-row>
        </v-container>
      </v-layout>
    </v-parallax>

    <v-container>
      <v-row class="text-center mt-5">
        <v-col class="mt-10">
          <p class="subheading fot-weight-regular">
            For best work experiance, digitalis your professional contact.
            <br />Join <a href="/"><b>us</b></a
            >.
          </p>
        </v-col>
      </v-row>
      <v-img
        :src="require('../assets/network.jpeg')"
        class="my-3"
        contain
        height="300"
      />
    </v-container>
  </v-app>
</template>

<script>
export default {
  name: "Landing",
  data: () => ({}),
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
  },
};
</script>