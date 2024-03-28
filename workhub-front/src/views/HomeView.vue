<script setup lang="ts">

import axios from "axios";
import {ref} from "vue";

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
        <h1>{{ post.title }}</h1>
      </div>
      <div>
        <p>{{ post.content }}</p>
      </div>
    </li>
  </ul>
</template>
