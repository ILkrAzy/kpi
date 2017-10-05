import axios from 'axios';

export default {
  add(type) {
    return axios.post('/api/projecttypes', type);
  },
  getProjectTypes() {
    return axios.get('/api/projecttypes');
  },
  delete(type) {
    return axios.delete('/api/projecttypes', type.id);
  },
};
