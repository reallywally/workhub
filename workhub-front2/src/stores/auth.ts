import { defineStore } from 'pinia';
import axios from 'axios';

export const useAuthStore = defineStore('auth', {
    state: () => ({
        user: null,
        token: null
    }),
    actions: {
        async login(credentials) {
            const response = await axios.post('/api/login', credentials);
            this.user = response.data.user;
            this.token = response.data.token;
            localStorage.setItem('token', this.token);
        },
        logout() {
            this.user = null;
            this.token = null;
            localStorage.removeItem('token');
        },
        async checkAuth() {
            const token = localStorage.getItem('token');
            if (token) {
                const response = await axios.get('/api/me', {
                    headers: { Authorization: `Bearer ${token}` }
                });
                this.user = response.data;
                this.token = token;
            }
        }
    }
});
