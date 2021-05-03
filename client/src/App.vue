<template>
  <v-app>
    <my-app-bar></my-app-bar>
    <v-main>
      <HelloWorld/>
    </v-main>
  </v-app>
</template>

<script>
import HelloWorld from './components/HelloWorld';
import MyAppBar from './components/MyAppBar';

export default {
  name: 'App',

  components: {
    MyAppBar,
    HelloWorld,
  },

  data: () => ({
    //
  }),
};
</script>
