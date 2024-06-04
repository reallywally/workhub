<template>
  <el-form :model="loginForm" ref="loginFormRef" :rules="rules" label-width="100px">
    <el-form-item label="Email" prop="email">
      <el-input v-model="loginForm.email"></el-input>
    </el-form-item>
    <el-form-item label="Password" prop="password">
      <el-input type="password" v-model="loginForm.password"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="handleSubmit">Login</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { ref } from 'vue';

export default {
  emits: ['login'],
  setup(_, { emit }) {
    const loginFormRef = ref(null);
    const loginForm = ref({
      email: '',
      password: ''
    });

    const rules = {
      email: [
        { required: true, message: 'Please input email', trigger: 'blur' },
        { type: 'email', message: 'Please input valid email', trigger: ['blur', 'change'] }
      ],
      password: [
        { required: true, message: 'Please input password', trigger: 'blur' }
      ]
    };

    const handleSubmit = () => {
      loginFormRef.value.validate((valid) => {
        if (valid) {
          emit('login', loginForm.value);
        }
      });
    };

    return {
      loginFormRef,
      loginForm,
      rules,
      handleSubmit
    };
  }
};
</script>
