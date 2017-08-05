import axios from 'axios';
import router from '../router';

const LOGIN_URL = '/api/login';

export default {

  authenticated: false,
  checkAuthed: false,

  login(context, creds, redirect) {
    const self = this;
    axios.post(LOGIN_URL, creds).then((data) => {
      localStorage.setItem('id_token', data.data);

      self.authenticated = true;

      if (redirect) {
        router.push(redirect);
      }
    }).catch(() => false);
    return true;
  },

  logout() {
    localStorage.removeItem('id_token');
    this.authenticated = false;
  },

  isAuth() {
    if (!this.checkAuthed) {
      this.checkAuth();
    }
    return this.authenticated;
  },

  checkAuth() {
    this.checkAuthed = true;
    const jwt = localStorage.getItem('id_token');
    if (jwt) {
      this.authenticated = true;
    } else {
      this.authenticated = false;
    }
  },

  getAuthHeader() {
    return {
      Authorization: `Bearer ${localStorage.getItem('id_token')}`,
    };
  },
};
