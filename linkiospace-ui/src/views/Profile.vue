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
          currentUserProfile.firstName.charAt(0) +
          " " +
          currentUserProfile.lastName.charAt(0)
        }}</span>
      </v-avatar>
      <v-list-item class="ml-4 mt-6" color="rgba(0, 0, 0, .4)">
        <v-list-item-content>
          <v-list-item-title class="title"
            >{{ currentUserProfile.firstName }}
            {{ currentUserProfile.lastName }}</v-list-item-title
          >
          <v-list-item-subtitle
            >{{ currentUserProfile.jobTitle }} at
            {{ currentUserProfile.companyName }}</v-list-item-subtitle
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
            <v-btn
              class="m-2 ml-4 p-2 primary lighten-1"
              small
              @click="enableUserInformation = !enableUserInformation"
            >
              Edit Your Information
            </v-btn>
          </v-col>
        </v-row>

        <v-row>
          <v-col cols="12" md="4">
            <v-text-field
              readonly
              v-model="currentUserProfile.email"
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
          </v-col>

          <v-col cols="12" md="4">
            <v-text-field
              readonly
              v-model="currentUserProfile.userCode"
              name="userCode"
              label="userCode"
              type="text"
            >
            </v-text-field>
          </v-col>

          <v-col cols="12" md="4">
            <v-text-field
              readonly
              v-model="currentUserProfile.phoneNumber"
              :rules="[(v) => !!v || 'This field is required']"
              required
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
              v-model="currentUserProfile.firstName"
              :rules="[(v) => (v || '').length > 0 || 'This field is required']"
              required
              name="firstName"
              label="firstName"
              type="text"
            ></v-text-field>
          </v-col>
          <v-col cols="12" md="6">
            <v-text-field
              readonly
              v-model="currentUserProfile.lastName"
              :rules="[(v) => (v || '').length > 0 || 'This field is required']"
              required
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
              v-model="currentUserProfile.jobTitle"
              :rules="[(v) => (v || '').length > 0 || 'This field is required']"
              required
              label="Job"
              name="jobTitle"
              type="text"
            ></v-text-field>
          </v-col>
          <v-col cols="12" md="6">
            <v-text-field
              readonly
              v-model="currentUserProfile.companyName"
              :rules="[(v) => (v || '').length > 0 || 'This field is required']"
              required
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
              v-model="currentUserProfile.bio"
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
              v-model="currentUserProfile.websitePortfolioLink"
              label="Website/Portfolio"
              name="websitePortfolioLink"
              type="text"
            >
            </v-text-field>
          </v-col>
        </v-row>
      </v-form>

      <v-form
        v-if="enableUserInformation"
        class="p-4"
        ref="form"
        lazy-validation
      >
        <v-row>
          <v-col cols="12" md="4">
            <v-alert
              border="left"
              dense
              color="primary lighten-2"
              elevation="19"
              type="info"
              >Now you can edit your profile.</v-alert
            >
          </v-col>
          <v-col cols="12" md="4">
            <v-btn
              class="m-2 ml-4 p-2"
              color="success lighten-1"
              @click="saveUserInformationChanges"
              small
            >
              Save
            </v-btn>
          </v-col>
        </v-row>

        <v-row>
          <v-col cols="12" md="4">
            <v-text-field
              v-model="userDetails.email"
              :rules="
                [(v) => !!v || 'This field is required'] && [
                  (v) => /.+@.+\..+/.test(v) || 'E-mail must be valid',
                ]
              "
              required
              name="editEmail"
              label="Email"
              type="email"
            ></v-text-field>
          </v-col>

          <v-col cols="12" md="4">
            <v-text-field
              v-model="currentUserProfile.userCode"
              readonly
              label="User Code"
              name="userCode"
              type="text"
            >
            </v-text-field>
          </v-col>

          <v-col cols="12" md="4">
            <v-text-field
              v-model="userDetails.phoneNumber"
              :rules="[(v) => !!v || 'This field is required']"
              required
              name="editPhoneNumber"
              type="text"
              label="Phone"
            >
            </v-text-field>
          </v-col>
        </v-row>

        <v-row>
          <v-col cols="12" md="6">
            <v-text-field
              v-model="userDetails.firstName"
              :rules="[(v) => (v || '').length > 0 || 'This field is required']"
              required
              label="First Name"
              name="editFirstName"
              type="text"
            ></v-text-field>
          </v-col>
          <v-col cols="12" md="6">
            <v-text-field
              v-model="userDetails.lastName"
              :rules="[(v) => (v || '').length > 0 || 'This field is required']"
              required
              label="Last Name"
              name="editLastName"
              type="text"
            ></v-text-field>
          </v-col>
        </v-row>

        <v-row>
          <v-col cols="12" md="6">
            <v-text-field
              v-model="userDetails.jobTitle"
              :rules="[(v) => (v || '').length > 0 || 'This field is required']"
              required
              label="Job Title"
              name="editJobTitle"
              type="text"
            ></v-text-field>
          </v-col>

          <v-col cols="12" md="6">
            <v-text-field
              v-model="userDetails.companyName"
              :rules="[(v) => (v || '').length > 0 || 'This field is required']"
              required
              label="Company Name"
              name="editCompanyName"
              type="text"
            ></v-text-field>
          </v-col>
        </v-row>

        <v-row>
          <v-col cols="12">
            <v-textarea
              v-model="userDetails.bio"
              :counter="1000"
              filled
              outlined
              color="teal"
              name="editBio"
              type="text"
              label="Bio"
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
              v-model="userDetails.websitePortfolioLink"
              :counter="100"
              name="editWebsitePortfolioLink"
              type="text"
              label="Website/Portfolio"
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
  name: "Profile",
  data() {
    return {
      currentUserProfile: null,
      userDetails: null,
      enableUserInformation: false,
      enableUserPassword: false,
      message: "",
      password: "",
      passwordVerification: "",
    };
  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
  },
  methods: {
    getUser(id) {
      UserService.getUserProfileInfo(id)
        .then((response) => {
          this.userDetails = response.data;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    saveUserInformationChanges() {
      return this.$confirm("Do you want to save your information?").then(() => {
        UserService.updateUserInformation(this.userDetails.id, this.userDetails)
          .then((response) => {
            console.log(response.data);
            this.message = "The user was updated successfully!";
          })
          .catch((e) => {
            console.log(e);
          });
        window.location.href = "http://localhost:8081/profile";
      });
    },
  },
  mounted() {
    if (!this.currentUser) {
      this.$router.push("/login");
    }

    this.message = "";
    this.getUser(this.$store.state.auth.user.id);
    UserService.getUserProfileInfo(this.$store.state.auth.user.id)
      .then((response) => {
        this.currentUserProfile = response.data;
        console.log(response.data);
      })
      .catch((e) => {
        console.log(e);
      });
  },
};
</script>
