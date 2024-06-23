<template>
  <h2>Advertiser List</h2>
</template>

<script>
import { useAdvertiserStore } from '../../stores/advertiser';
import { onMounted } from 'vue';
import { useRouter } from 'vue-router';

export default {
  setup() {
    const advertiserStore = useAdvertiserStore();
    const router = useRouter();

    onMounted(() => {
      advertiserStore.fetchAdvertisers()
    });

    const viewAdvertiser = (id) => {
      router.push(`/advertiser/${id}`);
    };

    return {
      posts: advertiserStore.advertisers,
    };
  }
};
</script>

<style scoped>

</style>