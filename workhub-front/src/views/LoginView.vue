<template>
  <el-row>
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
  </el-row>
</template>

<script setup lang="ts">
import {reactive} from "vue"
import Login from "@/entity/user/Login"
import AxiosHttpClient from "@/http/AxiosHttpClient";
import {AxiosError} from "axios";
import {ElMessage} from "element-plus";

const state = reactive({
  login: new Login(),
})

function doLogin() {
  const httpClient = new AxiosHttpClient()

  httpClient
  .request({
    method: "POST",
    url: "/api/auth/login",
    data: state.login
  })
  .then((response) => {
    console.log(response)
  })
  .catch((e) => {
    ElMessage({type: "error", message: e})
  })
}

</script>

<style scoped>

</style>