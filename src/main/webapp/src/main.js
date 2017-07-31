// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import App from './App';
import router from './router';
import auth from './auth';

require('bootstrap/dist/css/bootstrap.min.css');
require('../static/styles/kpi.css');

Vue.config.productionTip = false;

router.beforeEach((to, from, next) => {
  if (to.name !== 'Login' && !auth.isAuth()) {
    next('/login');
  }
  next();
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App },
});
