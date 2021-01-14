<template>
  <v-container align="center" class="mb-15 list mx-auto">
    <v-row align="center" class="list px-3 mt-15 mx-auto"> </v-row>
    <v-card class="mx-auto" tile>
      <v-card-title>Users</v-card-title>

      <v-data-table
        :headers="headers"
        :items="users"
        disable-pagination
        :hide-default-footer="true"
      >
        <template v-slot:[`item.actions`]="{ item }">
          <v-icon small class="mr-2" @click="deleteUser(item.id)">{{
            icons.mdiDelete
          }}</v-icon>
          <v-icon
            small
            class="mr-2"
            @click="getAdminBoardUserDetails(item.id)"
            >{{ icons.mdiAccount }}</v-icon
          >
        </template>
      </v-data-table>
    </v-card>
  </v-container>
</template>

<script>
import UserService from "../services/user.service";
import { mdiAccount, mdiDelete } from "@mdi/js";

export default {
  name: "AdminBoardUsersList",
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
        { text: "Id", value: "id", sortable: false },
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
      this.getAdminBoard();
    },
    getAdminBoard() {
      UserService.getAdminBoard()
        .then((response) => {
          this.users = response.data.map(this.getDisplayUser);
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    getDisplayUser(user) {
      return {
        id: user.id,
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
    deleteUser(id) {
      return this.$confirm("Do you want to delete this user?").then(() => {
        UserService.deleteUserProfile(id)
          .then((response) => {
            console.log(response.data);
            window.location.href = "http://localhost:8081/admin/users";
          })
          .catch((e) => {
            console.log(e);
          });
      });
    },
    getAdminBoardUserDetails(id) {
      this.$router.push({ name: "AdminBoardUser", params: { id: id } });
    },
  },
  mounted() {
    this.getAdminBoard();
  },
};
</script>

<style>
.list {
  max-width: 750px;
}
</style>
