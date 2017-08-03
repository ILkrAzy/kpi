import Vue from 'vue';
import Router from 'vue-router';
import Users from '@/components/Users';
import Home from '@/components/Home';
import Login from '@/components/Login';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login,
    },
    {
      path: '/',
      name: 'Home',
      component: Home,
      children: [
        {
          path: '/users',
          name: 'Users',
          component: Users,
        },
      ],
    },
  ],
});
