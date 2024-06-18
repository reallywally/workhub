<template>
  <div>
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal">
      <el-menu-item index="1">Home</el-menu-item>
      <el-menu-item index="2">Board</el-menu-item>
    </el-menu>
    <el-button @click="logout">Logout</el-button>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { useAuthStore } from '../stores/auth';

const activeIndex = ref('1');
const router = useRouter();
const authStore = useAuthStore();

const logout = () => {
  authStore.logout();
  router.push('/login');
};
</script>
