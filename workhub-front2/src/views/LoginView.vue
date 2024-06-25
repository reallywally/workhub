<template>
  <div class="login-container">
    <h1>Login</h1>

    <el-form >
      <el-form-item>
        <el-input  v-model="state.login.email" placeholder="email"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input type="password"  v-model="state.login.password" placeholder="Password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary"  @click="doLogin()">Login</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>


<script setup lang="ts">
import {reactive} from 'vue';
import Login from '@/entity/user/Login'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
import type HttpError from '@/http/HttpError'
import UserRepository from '@/repository/UserRepository'
import { container } from 'tsyringe'

const state = reactive({
  login: new Login(),
})

const USER_REPOSITORY = container.resolve(UserRepository)

function doLogin() {
  USER_REPOSITORY.login(state.login)
      .then(() => {
        ElMessage({ type: 'success', message: '환영합니다 :)' })
        location.href = '/'
      })
      .catch((e: HttpError) => {
        ElMessage({ type: 'error', message: e.getMessage() })
      })
}
</script>

<style scoped>
.login-container {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 4px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}
</style>
