<template>
  <div class="login-box">
    <h2>Sign in</h2>
    <div>
      <v-text-field label="Username"
        spellcheck="false"
        v-model="username"/>
      <v-text-field label="Pasword"
        type="password"
        v-model="password"/>
    </div>
    <div class="d-flex">
      <v-btn color="primary" @click="signIn">Sign In</v-btn>
    </div>
  </div>
</template>
<script>
export default {
  name: 'SignIn',
  data() {
    return {
      id: '',
      password: '',
    }
  },
  methods: {
    signIn() {
      if (this.username == '' || this.password == '') return;
      alert(`sign in using ${this.username} / ${this.password}`)
    }
  }
}
</script>

<style scoped>
div.login-box {
  width: 400px;
  height: 800px;
  margin: auto;
}
</style>