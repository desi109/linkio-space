<template>
  <v-container align="center" class="m-2 list mx-auto">
    <v-card elevation="15" class="mx-auto mb-15 m-3" tile>
      <v-img height="160" class="m-3" src="../assets/parallax.jpg"></v-img>
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
          userDetails.firstName.charAt(0) + " " + userDetails.lastName.charAt(0)
        }}</span>
      </v-avatar>
      <v-list-item class="ml-4 mt-6" color="rgba(0, 0, 0, .4)">
        <v-list-item-content>
          <v-list-item-title class="title"
            >{{ userDetails.firstName }}
            {{ userDetails.lastName }}</v-list-item-title
          >
          <v-list-item-subtitle
            >{{ userDetails.jobTitle }} at
            {{ userDetails.companyName }}</v-list-item-subtitle
          >
        </v-list-item-content>
      </v-list-item>

      <v-form
        v-if="!enableUserInformation"
        class="p-4"
        ref="form"
        lazy-validation
      >
        <v-row>
          <v-col cols="12" md="4">
            <v-text-field
              readonly
              v-model="userDetails.email"
              name="email"
              label="Email"
              type="email"
            >
            </v-text-field>
          </v-col>

          <v-col cols="12" md="4">
            <v-text-field
              readonly
              v-model="userDetails.userCode"
              name="userCode"
              label="userCode"
              type="text"
            >
            </v-text-field>
          </v-col>

          <v-col cols="12" md="4">
            <v-text-field
              readonly
              v-model="userDetails.phoneNumber"
              name="phoneNumber"
              label="Phone"
              type="text"
            >
            </v-text-field>
          </v-col>
        </v-row>

        <v-row>
          <v-col cols="12" md="6">
            <v-text-field
              readonly
              v-model="userDetails.firstName"
              name="firstName"
              label="firstName"
              type="text"
            ></v-text-field>
          </v-col>
          <v-col cols="12" md="6">
            <v-text-field
              readonly
              v-model="userDetails.lastName"
              label="Last Name"
              name="lastName"
              type="text"
            ></v-text-field>
          </v-col>
        </v-row>

        <v-row>
          <v-col cols="12" md="6">
            <v-text-field
              readonly
              v-model="userDetails.jobTitle"
              label="Job"
              name="jobTitle"
              type="text"
            ></v-text-field>
          </v-col>
          <v-col cols="12" md="6">
            <v-text-field
              readonly
              v-model="userDetails.companyName"
              label="Company Name"
              name="companyName"
              type="text"
            ></v-text-field>
          </v-col>
        </v-row>

        <v-row>
          <v-col cols="12">
            <v-textarea
              readonly
              v-model="userDetails.bio"
              filled
              outlined
              color="teal"
            >
              <template v-slot:label>
                <div>Bio <small>(optional)</small></div>
              </template>
            </v-textarea>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="12">
            <v-text-field
              readonly
              v-model="userDetails.websitePortfolioLink"
              label="Website/Portfolio"
              name="websitePortfolioLink"
              type="text"
            >
            </v-text-field>
          </v-col>
        </v-row>
      </v-form>
    </v-card>
  </v-container>
</template>

<script>
import UserService from "../services/user.service";

export default {
  name: "AdminBoardUsers",
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
  },
  data() {
    return {
      userDetails: null,
      message: "",
    };
  },
  methods: {
    getUser(id) {
      UserService.getUserInfoByUserId(id)
        .then((response) => {
          this.userDetails = response.data;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
  mounted() {
    this.message = "";
    this.getUser(this.$route.params.id);
  },
};
</script>
