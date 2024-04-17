<script setup lang="ts">
import Header from "@/components/Header.vue";
import Content from "@/components/Content.vue";
import Menu from "@/components/Menu.vue";
</script>

<template>
  <el-row>
    <el-col :span="22" :offset="1">
      <Header/>
    </el-col>
  </el-row>
  <el-row>
    <el-col :span="22" :offset="1">
      <Menu/>
    </el-col>
  </el-row>
  <el-row>
    <el-col :span="22" :offset="1">
      <Content/>
    </el-col>
  </el-row>
</template>

<style>
body {
  font-family: Pretendard, -apple-system, BlinkMacSystemFont, system-ui, Roboto,
  "Helvetica Neue", "Segoe UI", "Apple SD Gothic Neo", "Noto Sans KR",
  "Malgun Gothic", "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol",
  sans-serif;
}
</style>
