<template>
  <div>
    <navbar></navbar>
    <router-view></router-view>
  </div>
</template>

<script>
  import navbar from '../components/Navbar';

  export default {
    name: 'home',
    components: {
      navbar,
    },
  };
</script>

