import Vue from 'vue';
import Router from 'vue-router';

// lazy load the components
const Users = () => import('@/components/users/Users');
const Home = () => import('@/components/Home');
const Login = () => import('@/components/Login');
const ProjectTypes = () => import('@/components/projects/ProjectTypes');

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
  mode: 'history',
});
