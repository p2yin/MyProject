import HomeView from "@/views/ExampleView.vue";
import UserLayout from "@/layouts/UserLaout.vue";
import UserLoginView from "@/views/user/UserLoginView.vue";
import UserRegisterView from "@/views/user/UserRegisterView.vue";
import AdminView from "@/views/AdminView.vue";
import NoAuthView from "@/views/NoAuthView.vue";
import { RouteRecordRaw } from "vue-router";
import ACCESS_ENUM from "../access/accessEnum";
import AddQuestionView from "@/views/question/AddQuestionView.vue";
import ManageQuestionView from "@/views/question/ManageQuestionView.vue";

export const routes: Array<RouteRecordRaw> = [
  {
    path: "/user",
    name: "用户!",
    component: UserLayout,
    children: [
      {
        path: "/user/login",
        name: "登录",
        component: UserLoginView,
      },
      {
        path: "/user/register",
        name: "注册",
        component: UserRegisterView,
      },
    ],
    meta: {
      hideInMenu: true,
    },
  },
  {
    path: "/add/question",
    name: "Add Question",
    component: AddQuestionView,
    // meta: {
    //   access: ACCESS_ENUM.ADMIN,
    // },
  },
  {
    path: "/update/question",
    name: "Update Question",
    component: AddQuestionView,
    // meta: {
    //   access: ACCESS_ENUM.ADMIN,
    // },
  },
  {
    path: "/manage/question",
    name: "Manage Question",
    component: ManageQuestionView,
    // meta: {
    //   access: ACCESS_ENUM.ADMIN,
    // },
  },
  {
    path: "/",
    name: "View Question",
    component: HomeView,
  },
  {
    path: "/hide",
    name: "Hide page",
    component: HomeView,
    meta: {
      hideInMenu: true,
    },
  },
  {
    path: "/noAuth",
    name: "No authority page",
    component: NoAuthView,
  },
  {
    path: "/admin",
    name: "Only admin visible",
    component: AdminView,
    meta: {
      access: ACCESS_ENUM.ADMIN,
    },
  },
  {
    path: "/about",
    name: "About My",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
];
