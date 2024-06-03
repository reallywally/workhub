import { defineStore } from 'pinia';
import axios from 'axios';

export const useBoardStore = defineStore('board', {
    state: () => ({
        posts: [],
        post: null
    }),
    actions: {
        async fetchPosts() {
            const response = await axios.get('/api/posts');
            this.posts = response.data;
        },
        async fetchPost(id) {
            const response = await axios.get(`/api/posts/${id}`);
            this.post = response.data;
        },
        async createPost(post) {
            await axios.post('/api/posts', post);
            await this.fetchPosts();
        },
        async updatePost(post) {
            await axios.put(`/api/posts/${post.id}`, post);
            await this.fetchPosts();
        }
    }
});