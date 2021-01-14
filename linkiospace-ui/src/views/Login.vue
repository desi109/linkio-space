<template>
  <v-app>
    <v-container
      fluid
      style="width: 35%"
      bg
      fill-height
      grid-list-md
      text-xs-center
    >
      <v-layout row wrap align-center>
        <v-flex>
          <v-flex mb-3>
            <h2>Log In</h2>
          </v-flex>

          <v-form name="form" class="form-group" @submit.prevent="handleLogin">
            <v-layout column>
              <v-flex>
                <v-text-field
                  v-model="user.email"
                  v-validate="'required|email'"
                  :rules="
                    [(v) => !!v || 'Email is required'] && [
                      (v) => /.+@.+\..+/.test(v) || 'E-mail must be valid',
                    ]
                  "
                  required
                  name="email"
                  label="Email"
                  type="email"
                >
                </v-text-field>
              </v-flex>
              <v-flex>
                <v-text-field
                  v-model="user.password"
                  v-validate="'required'"
                  :rules="[(v) => !!v || 'Password is required']"
                  required
                  name="password"
                  label="Password"
                  type="password"
                ></v-text-field>
              </v-flex>

              <v-flex class="form-group text-xs-center" mt-5>
                <v-btn
                  type="submit"
                  class="btn primary btn-block"
                  :disabled="loading"
                >
                  <span
                    v-show="loading"
                    class="spinner-border spinner-border-sm"
                  ></span>
                  <span>Log in</span>
                </v-btn>
              </v-flex>

              <v-alert
                border="top"
                color="red lighten-2"
                dark
                class="alert alert-danger"
                role="alert"
                v-if="errors.has('email') || errors.has('password')"
                >Please enter credentials !</v-alert
              >

              <v-alert
                v-if="message"
                border="top"
                color="red lighten-2"
                dark
                class="alert alert-danger"
                role="alert"
                >{{ message }} !</v-alert
              >
            </v-layout>
          </v-form>
        </v-flex>
      </v-layout>
    </v-container>
  </v-app>
</template>

<script>
import User from "../models/user";
export default {
  name: "Login",
  data() {
    return {
      user: new User("", ""),
      loading: false,
      message: "",
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  created() {
    if (this.loggedIn) {
      this.$router.push("/profile");
    }
  },
  methods: {
    handleLogin() {
      this.loading = true;
      this.$validator.validateAll().then((isValid) => {
        if (!isValid) {
          this.loading = false;
          return;
        }
        if (this.user.email && this.user.password) {
          this.$store.dispatch("auth/login", this.user).then(
            () => {
              this.$router.push("/profile");
            },
            (error) => {
              this.loading = false;
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
    },
  },
};
</script>

<style scoped>
label {
  display: block;
  margin-top: 10px;
}
.card-container.card {
  max-width: 350px !important;
  padding: 40px 40px;
}
.card {
  background-color: #f7f7f7;
  padding: 20px 25px 30px;
  margin: 0 auto 25px;
  margin-top: 50px;
  -moz-border-radius: 2px;
  -webkit-border-radius: 2px;
  border-radius: 2px;
  -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}
.profile-img-card {
  width: 96px;
  height: 96px;
  margin: 0 auto 10px;
  display: block;
  -moz-border-radius: 50%;
  -webkit-border-radius: 50%;
  border-radius: 50%;
}
</style>
