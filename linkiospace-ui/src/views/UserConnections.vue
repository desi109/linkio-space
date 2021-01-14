<template>
  <v-container align="center" class="list mx-auto">
    <v-row align="center" class="list mt-15 px-3 mx-auto"> </v-row>
    <v-card class="mx-auto" tile>
      <v-card-title>Your Connections</v-card-title>

      <v-data-table
        :headers="headers"
        :items="users"
        disable-pagination
        :hide-default-footer="true"
      >
        <template v-slot:[`item.actions`]="{ item }">
          <v-icon
            small
            class="mr-2"
            @click="removeUserConnection(item.userCode)"
            >{{ icons.mdiDelete }}</v-icon
          >
          <v-icon small class="mr-2" @click="getUserDetails(item.userCode)">{{
            icons.mdiAccount
          }}</v-icon>
        </template>
      </v-data-table>

      <v-card-actions v-if="users.length > 0">
        <v-btn small color="error" @click="removeAllUserConnections">
          Remove All
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-container>
</template>

<script>
import UserService from "../services/user.service";
import { mdiAccount, mdiDelete } from "@mdi/js";

export default {
  name: "UserConnections",
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
  },
  data() {
    return {
      icons: {
        mdiAccount,
        mdiDelete,
      },
      users: [],
      title: "",
      headers: [
        { text: "Name", align: "start", sortable: false, value: "name" },
        { text: "Email", value: "email", sortable: false },
        { text: "User Code", value: "userCode", sortable: false },
        { text: "Phone", value: "phone", sortable: false },
        { text: "Job", value: "job", sortable: false },
        { text: "Company", value: "company", sortable: false },
        { text: "Actions", value: "actions", sortable: false },
      ],
    };
  },
  methods: {
    refreshList() {
      this.getUserBoard();
    },
    getUserBoard() {
      UserService.getUserConnections()
        .then((response) => {
          this.users = response.data.map(this.getDisplayUser);
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    removeUserConnection(id) {
      return this.$confirm("Do you want to delete this connection?").then(
        () => {
          UserService.deleteUserConnection(id)
            .then((response) => {
              console.log(response.data);
              window.location.href = "http://localhost:8081/user/connections";
            })
            .catch((e) => {
              console.log(e);
            });
        }
      );
    },
    removeAllUserConnections() {
      return this.$confirm("Do you want to delete all connections?").then(
        () => {
          UserService.deleteAllUserConnections(this.currentUser.id)
            .then((response) => {
              console.log(response.data);
              window.location.href = "http://localhost:8081/user/connections";
            })
            .catch((e) => {
              console.log(e);
            });
        }
      );
    },
    getDisplayUser(user) {
      return {
        name:
          (user.firstName + " " + user.lastName).length > 40
            ? (user.firstName + " " + user.lastName).substr(0, 30) + "..."
            : user.firstName + " " + user.lastName,
        email:
          user.email.length > 30
            ? user.email.substr(0, 30) + "..."
            : user.email,
        userCode: user.userCode,
        phone: user.phoneNumber,
        job: user.jobTitle,
        company: user.companyName,
      };
    },
    getUserDetails(userCode) {
      this.$router.push({
        name: "UserDetails",
        params: { userCode: userCode },
      });
    },
  },
  mounted() {
    this.getUserBoard();
  },
};
</script>

<style>
.list {
  max-width: 750px;
}
</style>
