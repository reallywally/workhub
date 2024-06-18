<template>
  <div class="login-container">
    <h1>Login</h1>

    <el-form @submit.prevent="handleLogin">
      <el-form-item>
        <el-input v-model="email" placeholder="email"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input type="password" v-model="password" placeholder="Password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" native-type="submit">Login</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>


<script setup>
import {ref} from 'vue';
import {useRouter} from 'vue-router';
import {useAuthStore} from '../stores/auth';
import {ElMessage} from 'element-plus';

const email = ref('');
const password = ref('');
const router = useRouter();
const authStore = useAuthStore();

const handleLogin = () => {
  const credentials = {
    email: email.value,
    password: password.value
  };
  authStore.login(credentials);
  router.push('/');
};
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
