import axios from 'axios';
import auth from '../auth';


export default {
  getUsers() {
    return axios.get('/api/users', {
      headers: auth.getAuthHeader(),
    });
  },
  addUser(user) {
    // return axios.post('/api/users', user, {
    //   headers: auth.getAuthHeader(),
    // });
    return new Promise((resolve) => {
      setTimeout(() => {
        resolve(user);
      }, 500);
    });
  },
  deleteUser(user) {
    // return axios.post('/api/users', user, {
    //   headers: auth.getAuthHeader(),
    // });
    return new Promise((resolve) => {
      setTimeout(() => {
        resolve(user);
      }, 500);
    });
  },
  getRoles() {
    return new Promise((resolve) => {
      const roles = {
        data: ['Admin', 'Manager'],
      };
      setTimeout(() => {
        resolve(roles);
      }, 100);
    });
  },
};
