import Vue from 'vue';
import Vuex from 'vuex';
import user from './modules/user';
import projecttypes from './modules/projecttypes';

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    user,
    projecttypes,
  },
});
