import axios from 'axios';
import router from '../router';

const LOGIN_URL = '/api/login';

export default {

  authenticated: false,
  checkAuthed: false,
  user: null,

  login(context, creds, redirect) {
    const self = this;
    axios.post(LOGIN_URL, creds).then((data) => {
      localStorage.setItem('id_token', data.data);
      localStorage.setItem('current_user', creds.username);
      self.authenticated = true;
      self.user = creds.username;
      if (redirect) {
        router.push(redirect);
      } else {
        router.push('/');
      }
    }).catch(() => {
      /* eslint no-param-reassign: ["error", { "props": false }] */
      context.error = true;
    });
  },

  getUser() {
    return this.user;
  },

  logout() {
    localStorage.removeItem('id_token');
    localStorage.removeItem('current_user');
    this.authenticated = false;
    router.push('/login');
    // window.location.reload(true);
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
    this.user = localStorage.getItem('current_user');
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
