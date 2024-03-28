<script setup lang="ts">
import {defineProps, onMounted, ref} from 'vue'
import axios from "axios";

const props = defineProps({
  postId: {
    type: [Number, String],
    required: true
  }
})

const post = ref({
  title: '',
  content: ''
})

onMounted(() => {
  axios.get(`/api/posts/${props.postId}`)
      .then((response) => {
        post.value = response.data;
      });
})
</script>

<template>
  <h2>{{ post.title }}</h2>
  <h2>{{ post.content }}</h2>
</template>


<style scoped>

</style>