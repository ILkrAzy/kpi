<template>
  <div id="sidebar-wrapper">
    <aside id="sidebar">
      <ul id="sidemenu" class="sidebar-nav">
        <li>
          <router-link to="/users" href="#">
            <i class="fa fa-users sidebar-icon"></i>
            <span class="sidebar-title">Users</span>
          </router-link>
        </li>
        <li>
          <router-link to="/projecttypes" href="#">
            <i class="fa fa-folder sidebar-icon"></i>
            <span class="sidebar-title">Project types</span>
          </router-link>
        </li>
        <li>
          <a class="accordion-toggle collapsed toggle-switch" href="#submenu-3">
            <i class="fa fa-list sidebar-icon"></i>
            <span class="sidebar-title">KPIs</span>
            <!--<b class="caret"></b>-->
          </a>
        </li>
      </ul>
    </aside>
  </div>
</template>

<script>
  export default {
    name: 'sidebar',
  };
</script>

