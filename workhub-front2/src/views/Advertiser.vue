<template>
  <div>
    <h1>Advertiser</h1>
    <router-link to="/advertiser/new">Create New Advertiser</router-link>
    <AdvertiserList />
  </div>
</template>

<script>
import BoardList from '../components/Board/BoardList.vue';
import AdvertiserList from "@/components/Advertiser/AdvertiserList.vue";

export default {
  components: {
    AdvertiserList,
  }
};
</script>