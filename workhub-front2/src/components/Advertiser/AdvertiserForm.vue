<template>
  <div>
    <h1> advertiser form</h1>
    <el-card>
      <el-form @submit.prevent="handleSubmit" label-width="120px">
        <el-form-item label="사업자 등록 번호">
          <el-input v-model="advertiser.businessNumber" required></el-input>
        </el-form-item>
        <el-form-item label="법인명">
          <el-input type="textarea" v-model="advertiser.businessName" required></el-input>
        </el-form-item>
        <el-form-item label="광고주명(한글)">
          <el-input type="textarea" v-model="advertiser.advertiserName" required></el-input>
        </el-form-item>
        <el-form-item label="광고주명(영어)">
          <el-input type="textarea" v-model="advertiser.advertiserNameEng" required></el-input>
        </el-form-item>
        <el-form-item label="전화번호">
          <el-input type="textarea" v-model="advertiser.businessPhone"></el-input>
        </el-form-item>
        <el-form-item label="비고">
          <el-input type="textarea" v-model="advertiser.note"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" native-type="submit">저장</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import { useAdvertiserStore } from '../../stores/advertiser';
import {onMounted, ref} from 'vue';
import { useRouter } from 'vue-router';

export default {
  setup() {
    const advertiserStore = useAdvertiserStore();
    const router = useRouter();
    const advertiser = ref({
      businessNumber: '',
      businessName: '',
      advertiserName: '',
      advertiserNameEng: '',
      businessPhone: '',
      note: '',
    });


    const handleSubmit = async () => {
      await advertiserStore.createAdvertiser(advertiser.value);
      router.push('/advertiser');
    };

    return {
      advertiser,
      handleSubmit
    };
  }
};
</script>
