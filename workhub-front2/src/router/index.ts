import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import Login from '../views/Login.vue';
import Board from '../views/Board.vue';
import Advertiser from '../views/Advertiser.vue';
import { useAuthStore } from '../stores/auth';

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home,
        children: [
            {
                path: 'board',
                name: 'Board',
                component: Board,
                meta: { requiresAuth: true },
            },
            {
                path: 'advertiser',
                name: 'Advertiser',
                component: Advertiser,
                meta: { requiresAuth: true },
            },
        ],
    },
    {
        path: '/login',
        name: 'Login',
        component: Login,
    },
];

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes,
});

router.beforeEach((to, from, next) => {
    const authStore = useAuthStore();
    if (to.matched.some(record => record.meta.requiresAuth)) {
        if (!authStore.isAuthenticated) {
            next('/login');
        } else {
            next();
        }
    } else {
        next();
    }
});

export default router;
