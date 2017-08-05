<template>
  <div id="sidebar-wrapper">
    <aside id="sidebar">
      <ul id="sidemenu" class="sidebar-nav">
        <li>
          <router-link to="/users" class="active" href="#">
            <i class="fa fa-users sidebar-icon"></i>
            <span class="sidebar-title">Users</span>
          </router-link>
        </li>
        <li class="sidemenu-item-dropdown">
          <a class="accordion-toggle collapsed toggle-switch" href="#submenu-2">
            <i class="fa fa-folder sidebar-icon"></i>
            <span class="sidebar-title">Projects</span>
            <b class="caret"></b>
          </a>
          <ul id="submenu-2" class="panel-collapse collapse panel-switch submenu" role="menu">
            <li>
              <a href="#">
                <i class="fa fa-caret-right sidebar-icon"></i>
                <span class="sidebar-title">Projects</span>
              </a>
            </li>
            <li>
              <a href="#">
                <i class="fa fa-caret-right sidebar-icon"></i>
                <span class="sidebar-title">Project Types</span>
              </a>
            </li>
          </ul>
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

