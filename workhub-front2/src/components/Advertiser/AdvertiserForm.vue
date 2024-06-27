<template>
  <div>
    <h1> advertiser form</h1>
    <el-card>
      <el-form label-width="120px">
        <el-form-item label="사업자 등록 번호">
          <el-input v-model="state.advertiserWrite.businessNumber" required></el-input>
        </el-form-item>
        <el-form-item label="법인명">
          <el-input type="textarea" v-model="state.advertiserWrite.businessName" required></el-input>
        </el-form-item>
        <el-form-item label="광고주명(한글)">
          <el-input type="textarea" v-model="state.advertiserWrite.advertiserName" required></el-input>
        </el-form-item>
        <el-form-item label="광고주명(영어)">
          <el-input type="textarea" v-model="state.advertiserWrite.advertiserNameEng" required></el-input>
        </el-form-item>
        <el-form-item label="전화번호">
          <el-input type="textarea" v-model="state.advertiserWrite.businessPhone"></el-input>
        </el-form-item>
        <el-form-item label="비고">
          <el-input type="textarea" v-model="state.advertiserWrite.note"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="save()">저장</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import {reactive} from 'vue';
import {useRouter} from 'vue-router';
import {ElMessage} from 'element-plus'
import {container} from 'tsyringe'
import AdvertiserWrite from "@/entity/advertiser/AdvertiserWrite";
import AdvertiserRepository from "@/repository/AdvertiserRepository";
import HttpError from "@/http/HttpError";

const state = reactive({
  advertiserWrite: new AdvertiserWrite(),
})

const ADVERTISER_REPOSITORY = container.resolve(AdvertiserRepository)
const router = useRouter()

function save() {
  ADVERTISER_REPOSITORY.write(state.advertiserWrite)
      .then(() => {
        ElMessage({type: 'success', message: '광고주 등록이 완료되었습니다.'})
        router.replace('/advertiser')
      })
      .catch((e: HttpError) => {
        ElMessage({type: 'error', message: e.getMessage()})
      })
}
</script>
