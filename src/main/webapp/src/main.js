// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import axios from 'axios';
import VuePaginate from 'vue-paginate';
import 'jquery';
import 'bootstrap';
import 'notifyjs-browser';
import 'bootstrap-select';
import App from './App';
import router from './router';
import auth from './auth';
import store from './store';

require('bootstrap/dist/css/bootstrap.min.css');
require('font-awesome/css/font-awesome.min.css');
require('bootstrap-select/dist/css/bootstrap-select.min.css');
require('../static/styles/kpi.css');

Vue.config.productionTip = false;
Vue.use(VuePaginate);

axios.interceptors.request.use((config) => {
  Object.assign(config.headers.common, auth.getAuthHeader());
  return config;
});

router.beforeEach((to, from, next) => {
  if (to.name !== 'Login' && !auth.isAuth()) {
    next({
      path: '/login',
      query: {
        redirect: to.fullPath,
      },
    });
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
