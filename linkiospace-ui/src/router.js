import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';
import Login from './views/Login.vue';
import Register from './views/Register.vue';
import AdminBoardUsersList from './views/AdminBoardUsersList.vue';
import AdminBoardUser from './views/AdminBoardUser.vue';
import Profile from './views/Profile.vue';
import UserConnections from './views/UserConnections.vue';
import UserSearch from './views/UserSearch.vue';
import NotFound from './views/NotFound.vue';
import Landing from './views/Landing.vue';
import UserDetails from './views/UserDetails.vue';


Vue.use(Router);

export const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Landing',
      component: Landing
    },
    {
      path: '/home',
      name: 'Home',
      component: Home
    },
    {
      path: '*',
      name: 'NotFound',
      component: NotFound
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Registrer',
      component: Register
    },
    {
      path: '/profile',
      name: 'Profile',
      component: Profile
    },
    {
      path: '/admin/users',
      name: 'AdminBoardUsersList',
      component: AdminBoardUsersList
    },
    {
      path: '/admin/users/:id',
      name: 'AdminBoardUser',
      component: AdminBoardUser
    },
    {
      path: '/user/search',
      name: 'UserSearch',
      component: UserSearch
    },
    {
      path: '/user/connections',
      name: 'UserConnections',
      component: UserConnections
    },
    {
      path: '/user/details/:userCode',
      name: 'UserDetails',
      component: UserDetails
    }
  ]
});



/*
router.beforeEach((to, from, next) => {
   const publicPages = ['/login', '/register', '/', '/home'];
   const authRequired = !publicPages.includes(to.path);
   const loggedIn = localStorage.getItem('user');

   // trying to access a restricted page + not logged in
   // redirect to login page
   if (authRequired && !loggedIn) {
     next('/');
   } else {
     next();
   }
 });
 */


