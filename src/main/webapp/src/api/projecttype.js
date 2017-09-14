import axios from 'axios';
import auth from '../auth';

export default {
  add(type) {
    return axios.post('/api/projecttypes', type, {
      headers: auth.getAuthHeader(),
    });
  },
  getProjectTypes() {
    return axios.get('/api/projecttypes', {
      headers: auth.getAuthHeader(),
    });
  },
};
