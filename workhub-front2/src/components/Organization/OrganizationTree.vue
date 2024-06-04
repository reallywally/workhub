<template>
  <el-tree
      :data="treeData"
      node-key="id"
      :props="defaultProps"
      :highlight-current="true"
      @node-click="handleNodeClick"
  >
    <span class="custom-tree-node" slot-scope="{ node, data }">
      <span>{{ data.name }}</span>
      <span>
        <el-button type="text" size="small" @click="editDepartment(data)">Edit</el-button>
        <el-button type="text" size="small" @click="deleteDepartment(data.id)">Delete</el-button>
      </span>
    </span>
  </el-tree>

  <el-dialog title="Edit Department" :visible.sync="showEditDepartmentForm">
    <DepartmentForm :department="selectedDepartment" @close="showEditDepartmentForm = false" @submit="handleUpdateDepartment" />
  </el-dialog>

  <el-dialog title="Edit Employee" :visible.sync="showEditEmployeeForm">
    <EmployeeForm :employee="selectedEmployee" @close="showEditEmployeeForm = false" @submit="handleUpdateEmployee" />
  </el-dialog>
</template>

<script>
import { useOrganizationStore } from '../../stores/organization';
import { ref, onMounted, computed } from 'vue';
import DepartmentForm from './DepartmentForm.vue';
import EmployeeForm from './EmployeeForm.vue';

export default {
  components: {
    DepartmentForm,
    EmployeeForm
  },
  setup() {
    const organizationStore = useOrganizationStore();
    const showEditDepartmentForm = ref(false);
    const showEditEmployeeForm = ref(false);
    const selectedDepartment = ref(null);
    const selectedEmployee = ref(null);

    const defaultProps = {
      children: 'children',
      label: 'name'
    };

    onMounted(() => {
      organizationStore.fetchDepartments();
      organizationStore.fetchEmployees();
    });

    const treeData = computed(() => {
      const departments = organizationStore.departments.map(department => {
        return {
          ...department,
          children: organizationStore.employees.filter(employee => employee.departmentId === department.id)
        };
      });
      return departments;
    });

    const handleNodeClick = (data) => {
      console.log(data);
    };

    const editDepartment = (department) => {
      selectedDepartment.value = { ...department };
      showEditDepartmentForm.value = true;
    };

    const deleteDepartment = async (id) => {
      await organizationStore.deleteDepartment(id);
    };

    const handleUpdateDepartment = async (department) => {
      await organizationStore.updateDepartment(department);
      showEditDepartmentForm.value = false;
    };

    const editEmployee = (employee) => {
      selectedEmployee.value = { ...employee };
      showEditEmployeeForm.value = true;
    };

    const deleteEmployee = async (id) => {
      await organizationStore.deleteEmployee(id);
    };

    const handleUpdateEmployee = async (employee) => {
      await organizationStore.updateEmployee(employee);
      showEditEmployeeForm.value = false;
    };

    return {
      treeData,
      defaultProps,
      handleNodeClick,
      showEditDepartmentForm,
      showEditEmployeeForm,
      selectedDepartment,
      selectedEmployee,
      editDepartment,
      deleteDepartment,
      handleUpdateDepartment,
      editEmployee,
      deleteEmployee,
      handleUpdateEmployee
    };
  }
};
</script>

<style>
.custom-tree-node {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
