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
};

export default {
  state,
  getters,
  actions,
  mutations,
};
