import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import About from '../views/About.vue';
import BoardView from '../views/BoardView.vue';
import BoardDetail from '../components/Board/BoardDetail.vue';
import BoardForm from '../components/Board/BoardForm.vue';

const routes = [
    { path: '/home', name: 'Home', component: Home },
    { path: '/about', name: 'About', component: About },

    { path: '/board', name: 'Board', component: BoardView },
    { path: '/board/:id', name: 'BoardDetail', component: BoardDetail },
    { path: '/board/new', name: 'BoardForm', component: BoardForm },
    { path: '/board/edit/:id', name: 'EditBoardForm', component: BoardForm },
    { path: '/', redirect: '/home' }
];

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes
});

export default router;