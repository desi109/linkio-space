import Vue from 'vue';
import App from './App.vue';
import { router } from './router';
import store from './store';
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import * as VeeValidate from 'vee-validate';
import Vuex from 'vuex';
import VueSimpleAlert from 'vue-simple-alert';
import vuetify from './plugins/vuetify';
import { library } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

import {
  faEdit,
  faTrash,
  faInfo,
  faHome,
  faUser,
  faUserPlus,
  faSignInAlt,
  faSignOutAlt
} from '@fortawesome/free-solid-svg-icons';

library.add(faEdit, faTrash, faInfo, faHome, faUser, faUserPlus, faSignInAlt, faSignOutAlt);

Vue.config.productionTip = false;

Vue.use(VeeValidate);
Vue.component('font-awesome-icon', FontAwesomeIcon);

Vue.use(Vuex);
Vue.use(VueSimpleAlert);

var vm = new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app');

vm.$forceUpdate();