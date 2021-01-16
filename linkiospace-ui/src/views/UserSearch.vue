<template>
  <v-container align="center" max-width="434" class="m-3 list mx-auto">
    <v-container align="center" class="list mx-auto">
      <v-row align="center" class="list px-3 mx-auto">
        <v-col cols="12" md="9" align="center">
          <v-text-field
            v-model="userCode"
            name="userCode"
            label="Search by UserCode"
            type="text"
            :counter="4"
            v-validate="'required'"
            :rules="
              [(v) => !!v || 'User Code is required'] && [
                (v) => !!v || this.userCodeCorrect == false,
              ]
            "
            required
          ></v-text-field>
          <v-alert
            border="top"
            color="red lighten-2"
            dark
            class="alert alert-danger"
            role="alert"
            v-if="errors.has('userCode')"
            >Please enter correct user code !
          </v-alert>
        </v-col>
        <v-col cols="12" md="3" align="center">
          <v-btn small name="form" @click="findUserByUserCode"> Search </v-btn>
        </v-col>
      </v-row>

      <v-container v-if="userCodeCorrect">
        <v-card
          elevation="15"
          class="mx-auto m-3"
          height="300"
          width="600"
          tile
        >
          <v-img height="55%" class="m-3" src="../assets/parallax.jpg"></v-img>
          <v-avatar
            size="100"
            class="ml-8"
            outlined
            style="
              border: 7px solid white;
              background-image: linear-gradient(#2590fb, #0a02ad);
              position: absolute;
              top: 90px;
            "
          >
            <span class="white--text headline">{{
              this.user.firstName.charAt(0) + " " + this.user.lastName.charAt(0)
            }}</span>
          </v-avatar>
          <v-list-item class="ml-4 mt-6" color="rgba(0, 0, 0, .4)">
            <v-list-item-content>
              <v-list-item-title class="title"
                >{{ user.firstName }} {{ user.lastName }}</v-list-item-title
              >
              <v-list-item-subtitle
                >{{ user.jobTitle }} at
                {{ user.companyName }}</v-list-item-subtitle
              >
            </v-list-item-content>
          </v-list-item>
        </v-card>

        <v-col cols="12" class="mt-9" align="center">
          <v-btn small name="form" @click="addUserAsConnection"
            >Add User To Your Connections
          </v-btn>
        </v-col>
      </v-container>
      <v-alert
          border="top"
          color="red lighten-2"
          dark
          class="alert alert-danger"
          role="alert"
          v-if="message"
          >{{ message }}
        </v-alert>
    </v-container>
  </v-container>
</template>

<script>
import UserService from "../services/user.service";

export default {
  name: "UserSearch",
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
  },
  data() {
    return {
      user: null,
      userCode: "",
      userCodeCorrect: false,
      message: "",
    };
  },
  methods: {
    findUserByUserCode() {
      this.$validator.validateAll().then((isValid) => {
        if (!isValid ) {
          this.userCodeCorrect = false;
          this.message = "User with this user code does not exist !";
        }
        else if (this.userCodeCorrect) {
          UserService.findUserByUserCode(this.userCode).then(
            (response) => {
              this.message = false;
              this.userCodeCorrect = true;
              this.user = response.data;
              console.log(response.data);
            },
            (error) => {
              this.message =
                (error.response &&
                  error.response.data &&
                  error.response.data.message) ||
                error.message ||
                error.toString();
            }
          );
        }
      });

      this.userCodeCorrect = true;
    },
    addUserAsConnection() {
      if (this.userCode == this.$store.state.auth.user.userCode) {
        return this.$alert("You can't add yourself as connection!");
      }

      return this.$confirm("Are you sure you want to add it?").then(() => {
        UserService.addUserAsConnection(this.userCode)
          .then((response) => {
            this.user = response.data;
            console.log(response.data);
          })
          .catch((e) => {
            console.log(e);
          });
        window.location.href = "http://localhost:8081/user/connections";
      });
    },
  },
};
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>