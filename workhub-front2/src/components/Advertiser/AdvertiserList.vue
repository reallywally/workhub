<template>
  <el-button type="primary" @click="addAdvertiser()">Add New Advertiser</el-button>
  <el-table :data="state.advertiserList.items">
    <el-table-column prop="id" label="ID"></el-table-column>
    <el-table-column prop="advertiserName" label="Name"></el-table-column>
    <el-table-column label="Actions">
      <template v-slot="scope">
        <el-button @click="editAdvertiser(scope.row)">Edit</el-button>
      </template>
    </el-table-column>
  </el-table>

  <div style="width: 100%; display: flex; justify-content: center">
    <el-pagination
        :background="true"
        layout="prev, pager, next"
        v-model:current-page="state.advertiserList.page"
        :total="state.advertiserList.totalCount"
        :default-page-size="3"
        @current-change="(page: number) => getList(page)"
    />
  </div>
</template>

<script setup lang="ts">
import { onMounted, reactive } from 'vue';
import { useRouter } from 'vue-router';
import { container } from 'tsyringe'
import AdvertiserRepository from '@/repository/AdvertiserRepository'
import Paging from '@/entity/data/Paging'
import Advertiser from "@/entity/advertiser/Advertiser.js";

const ADVERTISER_REPOSITORY = container.resolve(AdvertiserRepository)
const router = useRouter()

type StateType = {
  advertiserList: Paging<Advertiser>
}

const state = reactive<StateType>({
  advertiserList: new Paging<Advertiser>(),
})

function getList(page = 1) {
  ADVERTISER_REPOSITORY.getList(page).then((advertiserList) => {
    state.advertiserList = advertiserList
  })
}

function addAdvertiser() {
  router.push('/advertiser/new')
}

function editAdvertiser(advertiser: Advertiser) {
  router.push({ name: 'AdvertiserEdit', params: { advertiserId: advertiser.id } })
}

onMounted(() => {
  getList()
})
// export default {
//   setup() {
//     const advertisers = [];
//     const advertiserStore = useAdvertiserStore();
//     const router = useRouter();
//
//     onMounted(() => {
//       advertiserStore.fetchAdvertisers()
//     });
//
//     const viewAdvertiser = (id) => {
//       router.push(`/advertiser/${id}`);
//     };
//
//     const addAdvertiser = () => {
//       router.push('/advertiser/new');
//     };
//
//     const editAdvertiser = (advertiser) => {
//       router.push({ name: 'AdvertiserEdit', params: { id: advertiser.id } });
//     };
//
//     return {
//       viewAdvertiser,
//       addAdvertiser,
//       editAdvertiser,
//     };
//   }
// };
</script>

<style scoped>

</style>