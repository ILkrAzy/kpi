<template>
  <div id="navbar-wrapper">
    <header>
      <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand kpi-logo" href="#" style="color: #3BAFEA;">KPI System</a>
            <a id="sidebar-toggle" class="sidebar-toggle" style="height: 50px" href="#">
              <i class="fa fa-chevron-left"></i>
              <i class="fa fa-chevron-right"></i>
            </a>
            <!--<div style="height: 46px; border-right: 1px solid; border-color: #074c6e; width: 3px; float: left; margin-top: 2px; margin-bottom: 2px;"></div>-->
          </div>
          <div id="navbar-collapse" class="collapse navbar-collapse">
            <div id="navbar-search-box" class="navbar-form navbar-left" role="search">
              <div class="input-group col-sm-12 col-md-12">
                <input type="text" class="form-control" placeholder="Search">
                <span class="input-group-btn">
                                    <button class="btn" type="button">
                                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                                    </button>
                                </span>
              </div>
            </div>
            <ul class="nav navbar-nav navbar-right">
              <li class="dropdown">
                <a id="user-profile" href="#" class="dropdown-toggle" data-toggle="dropdown"><img
                  src="static/images/default_avatar.jpg"
                  class="img-responsive img-thumbnail img-circle">
                  {{ user }}
                  <b class="caret"></b>
                </a>
                <ul id="user-profile-dropdown" style="margin-top: 1px;" class="dropdown-menu dropdown-block"
                    role="menu">
                  <li><a href="#">Profile</a></li>
                  <li><a href="#">Admin</a></li>
                  <li class="divider"></li>
                  <li><a href="#" v-on:click="logout">Logout</a></li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </header>
  </div>
</template>

<script>

  import auth from '../auth';

  export default {
    name: 'navbar',
    data() {
      return {
        user: auth.getUser(),
      };
    },
    methods: {
      logout() {
        auth.logout();
      },
    },
  };
</script>

