import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import store from "../store";

const requireAuth = (to, from, next) => {
  if (!store.state.isLoggedIn) {
    next('/login')
  } else {
    next()
  }
}

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
      meta: { requiresAuth: true },
      beforeEnter: requireAuth
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
    },
    {
      path: "/add-peminjam",
      name: "add-peminjam",
      component: () => import("../views/AddPeminjamView.vue"),
    },
    {
      path: "/update-book",
      name: "update",
      component: () => import("../views/UpdateBookView.vue"),
    },
    {
      path: "/delete-book",
      name: "delete-book",
      component: () => import("../views/DeleteBookView.vue"),
    },
    {
      path: "/detail-peminjam",
      name: "detail-peminjam",
      component: () => import("../views/DetailPeminjamView.vue"),
    },
    {
      path: "/detail-books",
      name: "detail-books",
      component: () => import("../views/DetailBookView.vue"),
    },
    {
      path: "/update-book/:id",
      name: "update-with-id",
      component: () => import("../views/UpdateDataBookView.vue"),
    },
  ],
});

export default router;
