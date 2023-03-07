import { createStore } from "vuex";

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
      state.isLoggedIn = isLoggedIn;
      localStorage.setItem('email', state.email)
      localStorage.setItem('isLoggedIn', isLoggedIn);
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
    setLogOut(state, isLoggedIn) {
      state.isLoggedIn = isLoggedIn;
      localStorage.removeItem("isLoggedIn");
      localStorage.removeItem("email");
    },
  },
  actions: {},
  modules: {},
});

export default store;
