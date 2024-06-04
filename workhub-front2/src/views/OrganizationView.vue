<template>
  <div>
    <h1>Organization</h1>
    <el-button type="primary" @click="showAddDepartmentForm = true">Add Department</el-button>
    <el-button type="primary" @click="showAddEmployeeForm = true">Add Employee</el-button>

    <el-dialog title="Add Department" :visible.sync="showAddDepartmentForm">
      <DepartmentForm @close="showAddDepartmentForm = false" @submit="handleAddDepartment" />
    </el-dialog>

    <el-dialog title="Add Employee" :visible.sync="showAddEmployeeForm">
      <EmployeeForm @close="showAddEmployeeForm = false" @submit="handleAddEmployee" />
    </el-dialog>

    <OrganizationTree />
  </div>
</template>

<script>
import OrganizationTree from '../components/Organization/OrganizationTree.vue';
import DepartmentForm from '../components/Organization/DepartmentForm.vue';
import EmployeeForm from '../components/Organization/EmployeeForm.vue';
import { useOrganizationStore } from '../stores/organization';
import { ref } from 'vue';

export default {
  components: {
    OrganizationTree,
    DepartmentForm,
    EmployeeForm
  },
  setup() {
    const showAddDepartmentForm = ref(false);
    const showAddEmployeeForm = ref(false);
    const organizationStore = useOrganizationStore();

    const handleAddDepartment = async (department) => {
      await organizationStore.addDepartment(department);
      showAddDepartmentForm.value = false;
    };

    const handleAddEmployee = async (employee) => {
      await organizationStore.addEmployee(employee);
      showAddEmployeeForm.value = false;
    };

    return {
      showAddDepartmentForm,
      showAddEmployeeForm,
      handleAddDepartment,
      handleAddEmployee
    };
  }
};
</script>
