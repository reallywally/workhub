<template>
  <el-form :model="localDepartment" label-width="120px">
    <el-form-item label="Name">
      <el-input v-model="localDepartment.name"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="handleSubmit">Submit</el-button>
      <el-button @click="handleClose">Cancel</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { ref, watch, defineProps, defineEmits } from 'vue';

export default {
  props: {
    department: {
      type: Object,
      default: () => ({ name: '' })
    }
  },
  emits: ['close', 'submit'],
  setup(props, { emit }) {
    const localDepartment = ref({ ...props.department });

    watch(props.department, (newVal) => {
      localDepartment.value = { ...newVal };
    });

    const handleSubmit = () => {
      emit('submit', localDepartment.value);
    };

    const handleClose = () => {
      emit('close');
    };

    return {
      localDepartment,
      handleSubmit,
      handleClose
    };
  }
};
</script>
