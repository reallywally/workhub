import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import About from '../views/About.vue';
import BoardView from '../views/BoardView.vue';
import BoardDetail from '../components/Board/BoardDetail.vue';
import BoardForm from '../components/Board/BoardForm.vue';
import OrganizationView from '../views/OrganizationView.vue';
import LoginView from '../views/LoginView.vue';
import { useAuthStore } from '../stores/auth';

const routes = [
    { path: '/home', name: 'Home', component: Home },
    { path: '/about', name: 'About', component: About },

    { path: '/board', name: 'Board', component: BoardView },
    { path: '/board/:id', name: 'BoardDetail', component: BoardDetail },
    { path: '/board/new', name: 'BoardForm', component: BoardForm },
    { path: '/board/edit/:id', name: 'EditBoardForm', component: BoardForm },

    { path: '/organization', name: 'Organization', component: OrganizationView, meta: { requiresAuth: true } },
    { path: '/login', name: 'Login', component: LoginView },
    { path: '/', redirect: '/home' }
];

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes
});

/*
router.beforeEach(async (to, from, next) => {
    const authStore = useAuthStore();
    if (!authStore.user) {
        await authStore.checkAuth();
    }
    if (to.matched.some(record => record.meta.requiresAuth) && !authStore.user) {
        next('/login');
    } else {
        next();
    }
});
*/

export default router;