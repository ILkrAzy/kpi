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
        <li class="sidemenu-item-dropdown">
          <a class="accordion-toggle collapsed toggle-switch" href="#">
            <i class="fa fa-folder sidebar-icon"></i>
            <span class="sidebar-title">Projects</span>
            <b class="caret"></b>
          </a>
          <ul id="submenu-2" class="panel-collapse collapse panel-switch submenu" role="menu">
            <li>
              <router-link to="/projecttypes" href="#">
                <i class="fa fa-caret-right sidebar-icon"></i>
                <span class="sidebar-title">Project types</span>
              </router-link>
            </li>
            <li>
              <router-link to="/projects" href="#">
                <i class="fa fa-caret-right sidebar-icon"></i>
                <span class="sidebar-title">Projects</span>
              </router-link>
            </li>
          </ul>
        </li>
        <li>
          <router-link to="/kpis" href="#">
            <i class="fa fa-list sidebar-icon"></i>
            <span class="sidebar-title">KPIs</span>
          </router-link>
        </li>
      </ul>
    </aside>
  </div>
</template>

<script>
  import $ from 'jquery';

  export default {
    name: 'sidebar',
    mounted() {
      $('.sidemenu-item-dropdown').click(function onSideDropdownClick() {
        if ($(window).width() > 992 && !$('#wrapper').hasClass('wrapper-minibar')) {
          $(this).toggleClass('sidemenu-item-dropdown-open');
        }
      });
    },
    data() {
      return {
      };
    },
    methods: {
      abc() {

      },
    },
  };

</script>

