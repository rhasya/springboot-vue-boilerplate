<template>
  <v-app-bar
    app
    color="primary"
    dark
  >
    <div class="d-flex align-center">
      <v-img
        alt="Vuetify Logo"
        class="shrink mr-2"
        contain
        src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
        transition="scale-transition"
        width="40"
      />
      <v-toolbar-title>springboot-vue-boilerplate</v-toolbar-title>
    </div>
    <v-spacer></v-spacer>
    <v-btn :to="{path: '/' }" :plain="true">Home</v-btn>
    <v-btn :to="{path: '/about'}" :plain="true">About</v-btn>
    <v-btn :to="{path: '/admin'}" :plain="true">Admin</v-btn>
    <v-btn :to="{path: '/signin'}" :plain="true">Sign In</v-btn>
  </v-app-bar>
</template>