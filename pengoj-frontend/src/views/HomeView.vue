<template>
  <div class="home">
    <MdEditor :value="value" :handle-change="onChange" />
    <img alt="Vue logo" src="../assets/logo.png" />
    <HelloWorld msg="Welcome to Your Vue.js + TypeScript App" />
  </div>
</template>

<script setup lang="ts">
import { defineComponent, ref } from "vue";
import HelloWorld from "@/components/HelloWorld.vue"; // @ is an alias to /src
import MdEditor from "@/components/MdEditor.vue";

const value = ref();

const onChange = (v: string) => {
  value.value = v;
};
</script>
