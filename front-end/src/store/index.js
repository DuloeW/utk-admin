import {createStore} from "vuex";

const store = createStore({
  state: {
    isLoggedIn: false,
    email: "",
    password: "",
    kode: "",
  },
  getters: {},
  mutations: {
    setLoggedIn(state, isLoggedIn) {
      state.isLoggedIn = isLoggedIn
      localStorage.setItem('email', state.email)
      localStorage.setItem('isLoggedIn', state.isLoggedIn);
    },
    setAdminEmail(state, email) {
      state.email = email;
    },
    setAdminPassword(state, password) {
      state.password = password;
    },
    setAdminKode(state, kode) {
      state.kode = kode;
    },
  },
  actions: {},
  modules: {},
});

export default store;
