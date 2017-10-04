import api from '../../api/projecttype';
import * as mutationTypes from '../mutation-types';

const state = {
  types: [],
};

const getters = {
  allTypes: states => states.types,
};

// actions
const actions = {
  add({ commit }, type) {
    api.add(type).then(() => commit(mutationTypes.ADD_PROJECT_TYPE, type));
  },
  getProjectTypes({ commit }) {
    api.getProjectTypes().then(res => commit(mutationTypes.UPDATE_PROJECT_TYPES, res.data));
  },
  delete({ commit }, type) {
    api.delete(type).then(() => commit(mutationTypes.DELETE_PROJECT_TYPE, type));
  },
};

// mutations
const mutations = {
  [mutationTypes.ADD_PROJECT_TYPE](states, type) {
    states.types.push(type);
  },
  [mutationTypes.UPDATE_PROJECT_TYPES](states, types) {
    states.types.splice(0, states.types.length);
    types.forEach(e => states.types.push(e));
  },
  [mutationTypes.DELETE_PROJECT_TYPE](states, type) {
    api.deleteUser(type).then(() => {
      const index = states.types.indexOf(type);
      states.types.splice(index, 1);
    });
  },
};

export default {
  state,
  getters,
  actions,
  mutations,
};
