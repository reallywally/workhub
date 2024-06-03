<template>
  <el-container style="height: 100vh;">
    <el-aside width="200px">
      <el-menu
          :default-active="$route.path"
          class="el-menu-vertical-demo"
          @select="handleSelect">
        <el-menu-item index="/home">
          <span>Home</span>
        </el-menu-item>
        <el-menu-item index="/about">
          <span>About</span>
        </el-menu-item>
        <el-menu-item index="/board">
          <span>Board</span>
        </el-menu-item>
      </el-menu>
    </el-aside>

    <el-container>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: 'App',
  methods: {
    handleSelect(key, keyPath) {
      this.$router.push(key);
    }
  }
};
</script>

<style>
.el-menu-vertical-demo {
  width: 100%;
  height: 100%;
  border-right: none;
}
</style>
