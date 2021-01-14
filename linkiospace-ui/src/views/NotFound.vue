<template>
  <v-container my-10>
    <v-row class="text-center m-5">
      <v-col cols="12">
        <h1 class="display-2">Whoops, 404</h1>
        <p>The page you were looking for does not exist</p>
        <v-btn
          style="text-decoration: none"
          class="m-1"
          depressed
          to="/"
          color="primary"
        >
          <span class="ml-3 mr-3"
            ><font-awesome-icon icon="home" /> Get me out of here!
          </span>
        </v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
export default {};
</script>