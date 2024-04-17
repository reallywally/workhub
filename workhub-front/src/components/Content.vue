<template>
  <el-main class="content">
        <router-view />
  </el-main>
</template>

<script setup lang="ts"></script>

<style scoped>
.content {
  height: calc(100vh - 60px);
}
</style>
