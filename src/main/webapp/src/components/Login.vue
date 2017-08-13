<template>
  <div style="min-height: 100%" class="kpi-background-color kpi-signin-page-layout signin-body">
    <img src="/static/images/kpi-logo.png" style="width: 100px;">
    <br/>
    <h4 class="text-white">Welcome to KPI System</h4>
    <div class="signin-blank"></div>
    <div class="signin-blank"></div>
    <br/><br/>
    <h3 class="text-white">Sign in</h3>
    <br/>
    <form v-on:submit="submit" class="signin-form">
      <div id="error-panel" v-if="error" class="alert alert-danger alert-dismissable fade in signin-fail">
        Invalid username/password!
      </div>
      <br/>

      <div class="input-group input-group-lg signin-input-group">
        <span class="input-group-addon"><i class="fa fa-user"></i></span>
        <!-- process focus for input so that there is a outer highlight of it later - relate to box-shadow -->
        <input id="username" v-model="credentials.username" type="text" class="form-control" name="username" placeholder="Username or Email" required>
      </div>
      <br/>

      <div class="input-group input-group-lg signin-input-group">
        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
        <input id="password" v-model="credentials.password" type="password" class="form-control" name="password" placeholder="Password" required>
      </div>
      <br/>

      <div class="input-group input-group-lg signin-input-group">
        <button type="submit" class="btn btn-lg btn-success signin-btn" id="signin">SIGN IN</button>
      </div>
      <br/>
      <a href="#" class="btn-link">Lost your password?</a>
    </form>
    <footer class="footer">
      <div class="container">
        <p>© 2017<a href="#"> KPI Team</a>, All rights reserved 2017-2018.</p>
      </div>
    </footer>
  </div>
</template>

<script>

  import auth from '../auth';

  export default {
    name: 'login',
    data() {
      return {
        credentials: {
          username: '',
          password: '',
        },
        error: false,
      };
    },
    methods: {
      submit(event) {
        event.preventDefault();
        const credentials = {
          username: this.credentials.username,
          password: this.credentials.password,
        };
        auth.login(this, credentials, '/');
      },
    },
  };
</script>

