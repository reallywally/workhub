<template>
  <el-form :model="localEmployee" label-width="120px">
    <el-form-item label="Name">
      <el-input v-model="localEmployee.name" required></el-input>
    </el-form-item>
    <el-form-item label="Position">
      <el-input v-model="localEmployee.position" required></el-input>
    </el-form-item>
    <el-form-item label="Department">
      <el-select v-model="localEmployee.departmentId" placeholder="Select department" required>
        <el-option
            v-for="department in departments"
            :key="department.id"
            :label="department.name"
            :value="department.id"
        ></el-option>
      </el-select>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="handleSubmit">Submit</el-button>
      <el-button @click="handleClose">Cancel</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { ref, watch, defineProps, defineEmits } from 'vue';
import { useOrganizationStore } from '../../stores/organization';

export default {
  props: {
    employee: {
      type: Object,
      default: () => ({ name: '', position: '', departmentId: null })
    }
  },
  emits: ['close', 'submit'],
  setup(props, { emit }) {
    const organizationStore = useOrganizationStore();
    const localEmployee = ref({ ...props.employee });

    watch(props.employee, (newVal) => {
      localEmployee.value = { ...newVal };
    });

    const handleSubmit = () => {
      emit('submit', localEmployee.value);
    };

    const handleClose = () => {
      emit('close');
    };

    return {
      localEmployee,
      handleSubmit,
      handleClose,
      departments: organizationStore.departments
    };
  }
};
</script>
