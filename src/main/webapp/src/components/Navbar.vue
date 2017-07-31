<template>
  <nav class="navbar navbar-inverse navbar-fixed-top megamenu" role="navigation">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="sr-only"> Toggle navigation </span> <span class="icon-bar"> </span>
          <span class="icon-bar"> </span> <span class="icon-bar"> </span></button>
        <router-link to="/" class="navbar-brand navbar-logo" > <img src="/static/images/kpi-home-logo.png"
                                                                    alt="KPI Home"></router-link>
      </div>
      <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
          <li>
            <router-link to="/users">Users</router-link>
          </li>
          <li><router-link to="/bar">KPIs</router-link></li>
          <li><router-link to="/bar">Projects</router-link></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li>
            <a href="#" class="dropdown-toggle user-info" data-toggle="dropdown"
               id="navbar-userprof-fullname">
              Lanh Dang
              <img class="avatar" src="/assets/images/avatar.png"/>
              <span class="caret"></span>
            </a>
            <ul class="dropdown-menu kpi-menu-dropdown">
              <li><a href="#" id="navbar-userprof-profile">Profile</a></li>
              <li><a href="../signin.html" id="navbar-userprof-signout">Sign out</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script>
  export default {
    name: 'navbar',
  };
</script>

