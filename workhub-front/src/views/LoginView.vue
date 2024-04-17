<template>
<el-row>
  <el-col :span="10" :offset="7">
    <el-form label-position="top">
      <el-form-item label="이메일">
        <el-input v-model="state.login.email"></el-input>
      </el-form-item>
      <el-form-item label="비밀번호">
        <el-input v-model="state.login.password" type="password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="doLogin">Login</el-button>
      </el-form-item>
    </el-form>
  </el-col>
</el-row>
</template>

<script setup lang="ts">
import {reactive} from "vue"
import Login from "@/entity/user/Login"

const state = reactive({
  login: new Login(),
})

function doLogin() {
  console.log(state.login)
}

</script>

<style scoped>

</style>