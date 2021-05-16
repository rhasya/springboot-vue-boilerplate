<template>
  <div class="login-box">    
    <h2>Sign in</h2>
    <div v-show="ok == 1">
      <div>
        <v-text-field label="Username"
          spellcheck="false"
          v-model="username"/>
        <v-text-field label="Pasword"
          type="password"
          v-model="password"
          @keypress.enter="signIn"/>
      </div>
      <div class="d-flex">
        <v-btn color="primary" @click="signIn">Sign In</v-btn>
      </div>
    </div>
    <div v-show="ok == 2">
      <h3>You already signed in.</h3>
      <v-btn color="primary" @click="signOut"> Sign Out</v-btn>
    </div>
  </div>
</template>
<script>
export default {
  name: 'SignIn',
  data() {
    return {
      ok: 0,
      username: '',
      password: '',
    }
  },
  created() {
    this.fetchCheck()
  },
  watch: {
    '$route': 'fetchCheck'
  },
  methods: {    
    fetchCheck() {
      console.log('called')
      fetch('/check').then((res) => res.json()).then((data) => {
        if (data && data.ok === "1") {
          // already login
          this.ok = 2
        }
        else {
          this.ok = 1
        }
      }).catch(() => {
        this.ok = 1
      });
    },
    signIn() {
      const {username, password} = this
      if (username == '' || password == '') {
        return
      }
      fetch('/api/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: encodeURI(`username=${username}&password=${password}`)
      }).then((res) => {
        this.username = '';
        this.password = '';
        if (res.ok) {
          this.ok = 2
        }
      })
    },
    signOut() {
      fetch('/api/logout').then((res) => {
        if (res.ok) this.ok = 1
      })
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