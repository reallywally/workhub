import { defineStore } from 'pinia';
import axios from 'axios';
import AxiosHttpClient from '@/http/AxiosHttpClient';
import * as path from "path";

export const useAuthStore = defineStore('auth', {
    state: () => ({
        user: null,
        token: null
    }),
    actions: {
        async login(credentials) {
            const httpClient = new AxiosHttpClient()
            console.log(credentials)
            const response = httpClient.post({
                path:'/api/auth/login',
                body: credentials
            })

            console.log(response)
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
