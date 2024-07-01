<template>
  <div>
    <h1> advertiser edit</h1>
    <!-- 광고주 상세 -->
    <el-card>
      <el-form label-width="120px">
        <el-form-item label="사업자 등록 번호">
          <el-input v-model="state.advertiser.businessNumber" readonly></el-input>
        </el-form-item>
        <el-form-item label="법인명">
          <el-input type="textarea" v-model="state.advertiser.businessName" required></el-input>
        </el-form-item>
        <el-form-item label="광고주명(한글)">
          <el-input type="textarea" v-model="state.advertiser.advertiserName" required></el-input>
        </el-form-item>
        <el-form-item label="광고주명(영어)">
          <el-input type="textarea" v-model="state.advertiser.advertiserNameEng" required></el-input>
        </el-form-item>
        <el-form-item label="전화번호">
          <el-input type="textarea" v-model="state.advertiser.businessPhone"></el-input>
        </el-form-item>
        <el-form-item label="비고">
          <el-input type="textarea" v-model="state.advertiser.note"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="save()">수정</el-button>
          <el-button type="dangerous" @click="remove()">삭제</el-button>
        </el-form-item>
      </el-form>
    </el-card>

    <!-- 탭 메뉴 -->
    <el-card>
      <el-tabs v-model="activeTab">
        <el-tab-pane label="Project Management" name="projectManagement">
          <ProjectManagement :advertiserId="advertiserId"/>
        </el-tab-pane>
        <el-tab-pane label="Assign Manager" name="assignManager">
          <AssignManager :advertiserId="advertiserId"/>
        </el-tab-pane>
      </el-tabs>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import {container} from "tsyringe";
import AdvertiserRepository from "@/repository/AdvertiserRepository";
import Advertiser from "@/entity/advertiser/Advertiser";
import {useRouter} from "vue-router";
import {onMounted, reactive} from "vue";
import {ElMessage, ElMessageBox} from "element-plus";

const props = defineProps<{
  advertiserId: number
}>()

const ADVERTISER_REPOSITORY = container.resolve(AdvertiserRepository)
const router = useRouter()

type StateType = {
  advertiser: Advertiser
}

const state = reactive<StateType>({
  advertiser: new Advertiser(),
})

function getAdvertiser() {
  ADVERTISER_REPOSITORY.get(props.advertiserId)
      .then((advertiser: Advertiser) => {
        console.log(advertiser)
        state.advertiser = advertiser
      })
      .catch((e) => {
        console.error(e)
      })
}

function remove() {
  ElMessageBox.confirm('정말로 삭제하시겠습니까?', 'Warning', {
    title: '삭제',
    confirmButtonText: '삭제',
    cancelButtonText: '취소',
    type: 'warning',
  }).then(() => {
    ADVERTISER_REPOSITORY.delete(props.advertiserId).then(() => {
      ElMessage({type: 'success', message: '성공적으로 삭제되었습니다.'})
      router.back()
    })
  })
}

onMounted(() => {
  getAdvertiser()
})
</script>
