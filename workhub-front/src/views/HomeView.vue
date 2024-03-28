<script setup lang="ts">

import axios from "axios";
import {ref} from "vue";
import {useRouter} from "vue-router";

const router = useRouter();

const posts = ref([])

axios.get("/api/posts?page=0&size=5")
    .then((response) => {
      posts.value.push(...response.data);
    });

</script>

<template>
  <ul>
    <li v-for="post in posts" :key="post.id">
      <div>
        <router-link :to="{name:'read', params:{postId: post.id}}">{{ post.title }}</router-link>
      </div>
      <div>
        <p>{{ post.content }}</p>
      </div>
    </li>
  </ul>
</template>
