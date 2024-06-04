import { defineStore } from 'pinia';
import axios from 'axios';

export const useOrganizationStore = defineStore('organization', {
    state: () => ({
        departments: [],
        employees: []
    }),
    actions: {
        async fetchDepartments() {
            const response = await axios.get('/api/departments');
            this.departments = response.data;
        },
        async addDepartment(department) {
            await axios.post('/api/departments', department);
            await this.fetchDepartments();
        },
        async updateDepartment(department) {
            await axios.put(`/api/departments/${department.id}`, department);
            await this.fetchDepartments();
        },
        async deleteDepartment(id) {
            await axios.delete(`/api/departments/${id}`);
            await this.fetchDepartments();
        },
        async fetchEmployees() {
            const response = await axios.get('/api/employees');
            this.employees = response.data;
        },
        async addEmployee(employee) {
            await axios.post('/api/employees', employee);
            await this.fetchEmployees();
        },
        async updateEmployee(employee) {
            await axios.put(`/api/employees/${employee.id}`, employee);
            await this.fetchEmployees();
        },
        async deleteEmployee(id) {
            await axios.delete(`/api/employees/${id}`);
            await this.fetchEmployees();
        }
    }
});
