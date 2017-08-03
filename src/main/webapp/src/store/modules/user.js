import api from '../../api/user';
import * as types from '../mutation-types';

const state = {
  users: [],
};

// getters
const getters = {
  allUsers: states => states.users,
};

// actions
const actions = {
  getUsers({ commit }) {
    api.getUsers().then(res => commit(types.UPDATE_USERS, res.data));
  },
  deleteUser({ commit }, user) {
    commit(types.DELETE_USER, user);
  },
};

// mutations
const mutations = {
  [types.UPDATE_USERS](states, users) {
    states.users.splice(0, states.users.length);
    users.forEach(e => states.users.push(e));
  },
  [types.DELETE_USER](states, user) {
    const index = states.users.indexOf(user);
    states.users.splice(index, 1);
  },
};

export default {
  state,
  getters,
  actions,
  mutations,
};
