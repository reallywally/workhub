import { defineStore } from 'pinia';
import axios from 'axios';

export const useAdvertiserStore = defineStore('advertiser', {
    state: () => ({
        advertisers: [],
        post: null
    }),
    actions: {
        async fetchAdvertisers() {
            const response = await axios.get('/api/advertisers?page=1&size=30');
            this.advertisers = response.data;
        },
        async fetchAdvertiser(id) {
            const response = await axios.get(`/api/advertisers/${id}`);
            this.advertisers = response.data;
        },
        async createAdvertiser(advertiser) {
            await axios.post('/api/advertisers', advertiser);
            await this.fetchAdvertisers();
        },
        async updateAdvertiser(advertiser) {
            await axios.put(`/api/advertisers/${advertiser.id}`, advertiser);
            await this.fetchAdvertisers();
        }
    }
});