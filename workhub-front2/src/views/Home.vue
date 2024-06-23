<template>
  <div>
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal">
      <el-menu-item index="1">
        <router-link to="/">Home</router-link>
      </el-menu-item>
      <el-menu-item index="2">
        <router-link to="/board">Board</router-link>
      </el-menu-item>
      <el-menu-item index="3">
        <router-link to="/advertiser">Advertiser</router-link>
      </el-menu-item>
      <el-button @click="logout">Logout</el-button>
    </el-menu>
    <router-view></router-view>
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
