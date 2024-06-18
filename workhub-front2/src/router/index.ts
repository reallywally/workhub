import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import Login from '../views/Login.vue';
import { useAuthStore } from '../stores/auth';

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home,
        beforeEnter: (to, from, next) => {
            const authStore = useAuthStore();
            if (!authStore.isAuthenticated) {
                next('/login');
            } else {
                next();
            }
        },
    },
    {
        path: '/login',
        name: 'Login',
        component: Login,
        beforeEnter: (to, from, next) => {
            const authStore = useAuthStore();
            if (authStore.isAuthenticated) {
                next('/');
            } else {
                next();
            }
        },
    },
];

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes,
});

export default router;
