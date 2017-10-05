import axios from 'axios';

export default {
  getUsers() {
    return axios.get('/api/users');
  },
  addUser(user) {
    return axios.post('/api/users', user);
  },
  deleteUser(user) {
    // return axios.delete('/api/users', user, {
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
        data: ['ADMIN'],
      };
      setTimeout(() => {
        resolve(roles);
      }, 100);
    });
  },
};
