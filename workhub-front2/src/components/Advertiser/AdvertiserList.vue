<template>
  <h2>Advertiser List</h2>
  <el-button type="primary" @click="addAdvertiser()">Add New Advertiser</el-button>
  <el-table :data="advertisers">
    <el-table-column prop="id" label="ID"></el-table-column>
    <el-table-column prop="name" label="Name"></el-table-column>
    <el-table-column label="Actions">
      <template v-slot="scope">
        <el-button @click="editAdvertiser(scope.row)">Edit</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import { useAdvertiserStore } from '../../stores/advertiser';
import { onMounted } from 'vue';
import { useRouter } from 'vue-router';

export default {
  setup() {
    const advertisers = [];
    const advertiserStore = useAdvertiserStore();
    const router = useRouter();

    onMounted(() => {
      advertiserStore.fetchAdvertisers()
    });

    const viewAdvertiser = (id) => {
      router.push(`/advertiser/${id}`);
    };

    const addAdvertiser = () => {
      router.push('/advertiser/new');
    };

    const editAdvertiser = (advertiser) => {
      router.push({ name: 'AdvertiserEdit', params: { id: advertiser.id } });
    };

    return {
      viewAdvertiser,
      addAdvertiser,
      editAdvertiser,
    };
  }
};
</script>

<style scoped>

</style>