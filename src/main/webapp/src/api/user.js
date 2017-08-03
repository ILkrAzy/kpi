import axios from 'axios';
import auth from '../auth';


export default {
  getUsers() {
    return axios.get('/api/users', {
      headers: auth.getAuthHeader(),
    });
  },
};
