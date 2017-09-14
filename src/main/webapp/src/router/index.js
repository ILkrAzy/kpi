import Vue from 'vue';
import Router from 'vue-router';
import Users from '@/components/users/Users';
import Home from '@/components/Home';
import Login from '@/components/Login';
import ProjectTypes from '@/components/projects/ProjectTypes';

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
      redirect: '/users',
      name: 'Home',
      component: Home,
      children: [
        {
          path: '/users',
          name: 'Users',
          component: Users,
        },
        {
          path: '/projecttypes',
          name: 'ProjectTypes',
          component: ProjectTypes,
        },
      ],
    },
  ],
});
