<template>
  <v-app>
    <v-app-bar
      app
      src="./assets/parallax.jpg"
      align-center
      column
      justify-center
    >
      <div class="align-left m-1">
        <v-btn
          style="text-decoration: none"
          class="m-1"
          text
          to="/"
          color="primary lighten-1"
        >
          <v-img
            style="cursor: pointer"
            alt="Logo"
            class="shrink mr-1"
            contain
            src="./assets/logo-and-white-text.png"
            transition="scale-transition"
            width="165"
          />
        </v-btn>
      </div>

      <div class="align-left m-1">
        <v-btn
          v-if="!currentUser"
          style="text-decoration: none"
          class="m-1"
          text
          to="/home"
          color="white"
        >
          <span class="ml-3 mr-3"><font-awesome-icon icon="home" /> Home </span>
        </v-btn>
        <v-btn
          v-if="showAdminBoard"
          style="text-decoration: none"
          class="m-1"
          text
          to="/admin/users"
          color="white"
        >
          <span class="ml-2 mr-2"> Admin Board </span>
        </v-btn>
        <v-btn
          v-if="currentUser && !showAdminBoard"
          style="text-decoration: none"
          class="m-1"
          text
          to="/user/connections"
          color="white"
        >
          <span class="ml-2 mr-2">Connections</span>
        </v-btn>
        <v-btn
          v-if="currentUser && !showAdminBoard"
          style="text-decoration: none"
          class="m-1"
          text
          to="/user/search"
          color="white"
        >
          <span class="ml-2 mr-2">Search</span>
        </v-btn>
      </div>

      <v-spacer></v-spacer>

      <div class="align-right m-1">
        <v-btn
          v-if="!currentUser"
          style="text-decoration: none"
          class="m-1"
          text
          to="/register"
          color="white"
        >
          <span class="ml-2 mr-2"
            ><font-awesome-icon icon="user-plus" />Sign Up</span
          >
        </v-btn>

        <v-btn
          v-if="!currentUser"
          style="text-decoration: none"
          class="m-1"
          text
          to="/login"
          color="white"
        >
          <span class="ml-2 mr-2"
            ><font-awesome-icon icon="sign-in-alt" /> Log In</span
          >
        </v-btn>

        <v-btn
          v-if="currentUser"
          style="text-decoration: none"
          class="m-1"
          text
          to="/register"
          color="white"
        >
          <span class="ml-2 mr-2"
            ><font-awesome-icon icon="user" /> {{ currentUser.email }}
          </span>
        </v-btn>

        <v-btn
          v-if="currentUser"
          style="text-decoration: none"
          class="m-1"
          text
          href
          @click.prevent="logOut"
          color="white"
        >
          <span class="ml-2 mr-2"
            ><font-awesome-icon icon="sign-out-alt" /> Log Out
          </span>
        </v-btn>
      </div>
    </v-app-bar>

    <v-main>
      <router-view />
    </v-main>

    <v-footer padless>
      <v-card-text class="primary white--text text-center">
        <v-btn v-for="icon in icons" :key="icon" class="mx-4 white--text" icon>
          <v-icon size="24px">
            {{ icon }}
          </v-icon>
        </v-btn>
      </v-card-text>

      <v-card-text class="primary white--text text-center pb-0 pt-0">
        Contact Info
        <br />(359) 87-678-345
        <p>linkio.space@gmail.com</p>
      </v-card-text>

      <v-divider></v-divider>

      <v-card-text class="primary darken-1 text-center white--text">
        &copy; <strong> Linkio.Space </strong> {{ new Date().getFullYear() }}.
      </v-card-text>
    </v-footer>
  </v-app>
</template>

<script>
import UserService from "./services/user.service";
import { mdiLinkedin, mdiFacebook, mdiInstagram } from "@mdi/js";

export default {
  name: "App",
  data: () => ({
    icons: [mdiFacebook, mdiInstagram, mdiLinkedin],
  }),
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
    showAdminBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes("ROLE_ADMIN");
      }
      return false;
    },
  },
  methods: {
    findUserByUserCode() {
      UserService.findUserByUserCode(this.userCode)
        .then((response) => {
          this.user = response.data;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    logOut() {
      this.$store.dispatch("auth/logout");
      this.$router.push("/login");
    },
    showProfile() {
      this.$router.push("/profile");
    },
  },
};
</script>

<style>
.underline {
  text-decoration: underline;
}

.underline i.material-icons {
  text-decoration: none !important;
}
</style>
