import { defineStore } from 'pinia';
import axios from 'axios';
import AxiosHttpClient from '@/http/AxiosHttpClient';

export const useAuthStore = defineStore('auth', {
    state: () => ({
        user: null,
        token: null,
        isAuthenticated: false
    }),
    actions: {
        async login(credentials) {
            const httpClient = new AxiosHttpClient()
            const response = httpClient.post({
                path:'/api/auth/login',
                body: credentials
            })

            this.isAuthenticated = true;
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
