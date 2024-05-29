<template>
  <div id="app">
    <template v-if="$route.path.startsWith('/user')">
      <router-view />
    </template>
    <template v-else>
      <BasicLayout />
    </template>
  </div>
</template>

<style>
#app {
}
</style>

<script setup lang="ts">
import BasicLayout from "@/layouts/BasicLayout";
import { onMounted } from "vue";
import { useRoute } from "vue-router";

/**
 * 全局初始化函数
 */
const doInit = () => {
  console.log("hello! Welcome come to Peng Project");
};

onMounted(() => {
  doInit();
});
</script>
