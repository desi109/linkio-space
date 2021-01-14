<template>
  <v-app>
    <v-container
      fluid
      style="width: 40%"
      bg
      fill-height
      grid-list-md
      text-xs-center
    >
      <v-layout row wrap align-center>
        <v-flex>
          <v-flex mb-3>
            <h2>Sign In</h2>
          </v-flex>

          <form name="form" @submit.prevent="handleRegister">
            <v-flex v-if="!successful">
              <v-flex class="form-group">
                <v-text-field
                  v-model="user.firstName"
                  v-validate="'required|min:2|max:40'"
                  :rules="[(v) => !!v || 'This field is required']"
                  required
                  type="text"
                  label="First Name"
                  name="firstName"
                ></v-text-field>
                <v-alert
                  v-if="submitted && errors.has('firstName')"
                  class="alert-danger"
                  color="red lighten-2"
                  >{{ errors.first("firstName") }} !</v-alert
                >
              </v-flex>

              <v-flex class="form-group">
                <v-text-field
                  v-model="user.lastName"
                  v-validate="'required|min:2|max:40'"
                  :rules="[(v) => !!v || 'This field is required']"
                  required
                  type="text"
                  label="Last Name"
                  name="lastName"
                ></v-text-field>
                <v-alert
                  v-if="submitted && errors.has('lastName')"
                  class="alert-danger"
                  color="red lighten-2"
                  >{{ errors.first("lastName") }} !</v-alert
                >
              </v-flex>

              <v-flex class="form-group">
                <v-text-field
                  v-model="user.email"
                  v-validate="'required|min:4|max:40'"
                  :rules="
                    [(v) => !!v || 'This field is required'] && [
                      (v) => /.+@.+\..+/.test(v) || 'E-mail must be valid',
                    ]
                  "
                  required
                  name="email"
                  label="Email"
                  type="email"
                >
                </v-text-field>
                <v-alert
                  v-if="submitted && errors.has('email')"
                  class="alert-danger"
                  color="red lighten-2"
                  >{{ errors.first("email") }} !</v-alert
                >
              </v-flex>

              <v-flex class="form-group">
                <v-text-field
                  v-model="user.password"
                  v-validate="'required|min:6|max:40'"
                  type="password"
                  :rules="[(v) => !!v || 'This field is required']"
                  required
                  label="Password"
                  name="password"
                ></v-text-field>
                <v-alert
                  v-if="submitted && errors.has('password')"
                  class="alert-danger"
                  color="red lighten-2"
                >
                  {{ errors.first("password") }} !
                </v-alert>
              </v-flex>

              <v-flex class="form-group">
                <v-text-field
                  v-model="user.phoneNumber"
                  v-validate="'required|min:7|max:12'"
                  :rules="[(v) => !!v || 'This field is required']"
                  required
                  type="text"
                  label="Phone Number"
                  name="phoneNumber"
                ></v-text-field>
                <v-alert
                  v-if="submitted && errors.has('phoneNumber')"
                  class="alert-danger"
                  color="red lighten-2"
                >
                  {{ errors.first("phoneNumber") }} !
                </v-alert>
              </v-flex>

              <v-flex class="form-group">
                <v-text-field
                  v-model="user.jobTitle"
                  v-validate="'required|min:2|max:40'"
                  :rules="[(v) => !!v || 'This field is required']"
                  required
                  type="text"
                  label="Job"
                  name="jobTitle"
                ></v-text-field>
                <v-alert
                  v-if="submitted && errors.has('jobTitle')"
                  class="alert-danger"
                  color="red lighten-2"
                >
                  {{ errors.first("jobTitle") }} !
                </v-alert>
              </v-flex>

              <v-flex class="form-group">
                <v-text-field
                  v-model="user.companyName"
                  v-validate="'required|min:2|max:40'"
                  :rules="[(v) => !!v || 'This field is required']"
                  required
                  type="text"
                  label="Company Name"
                  name="companyName"
                ></v-text-field>
                <v-alert
                  v-if="submitted && errors.has('companyName')"
                  class="alert-danger"
                  color="red lighten-2"
                >
                  {{ errors.first("companyName") }} !
                </v-alert>
              </v-flex>

              <v-flex mt-7 class="form-group">
                <button class="btn btn-primary btn-block">Sign Up</button>
              </v-flex>
            </v-flex>
          </form>

          <v-flex
            v-if="message"
            class="alert"
            :class="successful ? 'alert-success' : 'alert-danger'"
          >
            {{ message }}
          </v-flex>
        </v-flex>
      </v-layout>
    </v-container>
  </v-app>
</template>

<script>
import User from "../models/user";
export default {
  name: "Register",
  data() {
    return {
      user: new User("", "", "", "", "", "", "", "", "", ""),
      submitted: false,
      successful: false,
      message: "",
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  mounted() {
    if (this.loggedIn) {
      this.$router.push("/profile");
    }
  },
  methods: {
    handleRegister() {
      this.message = "";
      this.submitted = true;
      this.$validator.validate().then((isValid) => {
        if (isValid) {
          this.$store.dispatch("auth/register", this.user).then(
            (data) => {
              this.message = data.message;
              this.successful = true;
            },
            (error) => {
              this.message =
                (error.response &&
                  error.response.data &&
                  error.response.data.message) ||
                error.message ||
                error.toString();
              this.successful = false;
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
