<template>
  <div>
    <el-card>
      <h1>{{ isEdit ? 'Edit Post' : 'Create Post' }}</h1>
      <el-form @submit.prevent="handleSubmit" label-width="120px">
        <el-form-item label="Title">
          <el-input v-model="post.title" required></el-input>
        </el-form-item>
        <el-form-item label="Content">
          <el-input type="textarea" v-model="post.content" required></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" native-type="submit">Submit</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import { useBoardStore } from '../../stores/board';
import { ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import axios from 'axios';

export default {
  setup() {
    const boardStore = useBoardStore();
    const route = useRoute();
    const router = useRouter();
    const isEdit = ref(route.params.id !== undefined);
    const post = ref({ title: '', content: '' });

    onMounted(async () => {
      if (isEdit.value) {
        await boardStore.fetchPost(route.params.id);
        post.value = { ...boardStore.post };
      }
    });

    const handleSubmit = async () => {
      if (isEdit.value) {
        await boardStore.updatePost(post.value);
      } else {
        await createPost(post.value);
      }
      router.push('/board');
    };

    const createPost = async (newPost) => {
      await axios.post('/api/posts', newPost);
      await boardStore.fetchPosts();
    };

    return {
      post,
      isEdit,
      handleSubmit
    };
  }
};
</script>
