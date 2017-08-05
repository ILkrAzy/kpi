<template>
  <div>
    <navbar></navbar>
    <div id="wrapper">
      <sidebar></sidebar>
      <main id="page-content-wrapper" role="main">
        <router-view></router-view>
      </main>
    </div>
  </div>
</template>

<script>
  import $ from 'jquery';
  import navbar from '../components/Navbar';
  import sidebar from '../components/Sidebar';

  export default {
    name: 'home',
    components: {
      navbar,
      sidebar,
    },
    mounted() {
      let isMiniSizebar = $('#wrapper').hasClass('wrapper-minibar');
      $('#sidebar-toggle').click(() => {
        if ($(window).width() > 767) {
          $('#wrapper').toggleClass('wrapper-minibar');
        }
        isMiniSizebar = $('#wrapper').hasClass('wrapper-minibar');
        if (isMiniSizebar) {
          $('.sidemenu-item-dropdown').removeClass('sidemenu-item-dropdown-open');
          $(this).addClass('sidebar-toggle-active');
          $(this).removeClass('sidebar-toggle-disable');
        } else {
          $(this).removeClass('sidebar-toggle-active');
          $(this).addClass('sidebar-toggle-disable');
        }
      });
    },
  };
</script>

