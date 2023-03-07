import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import store from "../store";

const auth = function() {
  return { 
    requiresAuth: true,
    beforeEnter: (to, from, next) => {
      if (!Boolean(localStorage.getItem('isLoggedIn'))) {
        next('/login')
      } else {
        next()
      }
    }
  }
}

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
      meta: auth()
    },
    {
      path: "/login",
      name: "login",
      component: () => import("../views/LoginView.vue"),
    },
    {
      path: "/add-book",
      name: "add-book",
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import("../views/AddBookView.vue"),
      meta: auth()
    },
    {
      path: "/add-peminjam",
      name: "add-peminjam",
      component: () => import("../views/AddPeminjamView.vue"),
      meta: auth()
    },
    {
      path: "/update-book",
      name: "update",
      component: () => import("../views/UpdateBookView.vue"),
      meta: auth()
    },
    {
      path: "/delete-book",
      name: "delete-book",
      component: () => import("../views/DeleteBookView.vue"),
      meta: auth()
    },
    {
      path: "/detail-peminjam",
      name: "detail-peminjam",
      component: () => import("../views/DetailPeminjamView.vue"),
      meta: auth()
    },
    {
      path: "/detail-books",
      name: "detail-books",
      component: () => import("../views/DetailBookView.vue"),
      meta: auth()
    },
    { 
      path: "/update-book/:id",
      name: "update-with-id",
      component: () => import("../views/UpdateDataBookView.vue"),
      meta: auth()
    },
    {
      path: '/admin-profile',
      name: 'admin-profile',
      component: () => import('../views/AdminProfileView.vue'),
      meta: auth()
    }
  ],
});

export default router;
