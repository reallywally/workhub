<template>
  <el-card>
    <h1>{{ post.title }}</h1>
    <p>{{ post.content }}</p>
    <el-button type="primary" @click="editPost">Edit Post</el-button>
  </el-card>
</template>

<script>
import { useBoardStore } from '../../stores/board';
import { onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';

export default {
  setup() {
    const boardStore = useBoardStore();
    const route = useRoute();
    const router = useRouter();
    const postId = route.params.id;

    onMounted(() => {
      boardStore.fetchPost(postId);
    });

    const editPost = () => {
      router.push(`/board/edit/${postId}`);
    };

    return {
      post: boardStore.post,
      editPost
    };
  }
};
</script>
