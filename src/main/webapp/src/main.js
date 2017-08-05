// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import VuePaginate from 'vue-paginate';
import 'jquery';
import 'bootstrap';
import App from './App';
import router from './router';
import auth from './auth';
import store from './store';

require('bootstrap/dist/css/bootstrap.min.css');
require('font-awesome/css/font-awesome.min.css');
require('../static/styles/kpi-side.css');


Vue.config.productionTip = false;
Vue.use(VuePaginate);

router.beforeEach((to, from, next) => {
  if (to.name !== 'Login' && !auth.isAuth()) {
    next('/login');
  }
  next();
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  store,
  router,
  template: '<App/>',
  components: { App },
});
