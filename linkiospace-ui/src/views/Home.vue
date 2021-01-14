<template>
  <v-app>
    <v-parallax v-if="!currentUser" dark src="../assets/parallax.jpg">
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
            <v-col class="mb">
              <h1 class="display-2 font-weight-bold mb-3">
                Welcome to Linkio.Space
              </h1>
              <h6 class="subheading fot-weight-regular">
                Build your network now!
              </h6>
            </v-col>
          </v-row>
        </v-container>
      </v-layout>
    </v-parallax>

    <v-container my-15>
      <v-row class="text-center m-5">
        <v-col cols="12">
          <h1>Welcome to Linkio.Space</h1>
        </v-col>
        <v-col class="mb">
          <blockquote class="blockquote text-xs-center">
            It's a basic simple contact network application <br />
            with secure authentication
          </blockquote>

          <v-btn class="m-2" style="text-decoration: none" to="/register"
            >Sign Up</v-btn
          >
          <v-btn
            color="primary"
            class="m-2"
            style="text-decoration: none"
            to="/login"
            >Log In</v-btn
          >
        </v-col>
      </v-row>
    </v-container>
  </v-app>
</template>

<script>
export default {
  name: "Home",
  mounted: {
    doBefore() {
      if (localStorage.getItem("user")) {
        this.$router.push({ path: "/home" });
      }
    },
  },
};
</script>
