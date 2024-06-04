<template>
  <div class="login-container">
    <h1>Login</h1>
    <LoginForm @login="handleLogin" />
  </div>
</template>

<script>
import LoginForm from '../components/Auth/LoginForm.vue';
import { useAuthStore } from '../stores/auth';
import { useRouter } from 'vue-router';

export default {
  components: {
    LoginForm
  },
  setup() {
    const authStore = useAuthStore();
    const router = useRouter();

    const handleLogin = async (credentials) => {
      await authStore.login(credentials);
      router.push('/home');
    };

    return {
      handleLogin
    };
  }
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
