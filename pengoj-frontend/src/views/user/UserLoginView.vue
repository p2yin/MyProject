<template>
  <div id="userLoginView">
    <h1 style="margin-bottom: 16px">Login</h1>
    <a-form
      style="max-width: 480px; margin: 0 auto"
      label-align="left"
      auto-label-width
      :model="form"
      @submit="handleSubmit"
    >
      <a-form-item field="userAccount" label="Account">
        <a-input
          v-model="form.userAccount"
          placeholder="Please enter your Account"
        />
      </a-form-item>

      <a-form-item
        field="userPassword"
        tooltip="Password no less than 8 digits"
        label="Password"
      >
        <a-input-password
          v-model="form.userPassword"
          placeholder="Please enter your password"
          allow-clear
        />
      </a-form-item>

      <a-form-item>
        <a-button type="primary" html-type="submit" style="width: 120px">
          SignIn
        </a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script setup lang="ts">
import { reactive } from "vue";
import { UserControllerService, UserLoginRequest } from "../../../generated";
import message from "@arco-design/web-vue/es/message";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

/**
 * 表单信息
 */
const form = reactive({
  userAccount: "",
  userPassword: "",
} as UserLoginRequest);

const router = useRouter();
const store = useStore();
/**
 * 提交表单
 */

const handleSubmit = async () => {
  const res = await UserControllerService.userLoginUsingPost(form);
  // 登陆成功，跳转到主页
  if (res.code === 0) {
    await store.dispatch("user/getLoginUser");
    router.push({
      path: "/",
      replace: true,
    });
  } else {
    message.error("Failed, " + res.message);
  }
  alert(JSON.stringify(form));
};
</script>
