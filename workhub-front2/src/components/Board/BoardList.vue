<template>
  <el-table :data="posts" style="width: 100%">
    <el-table-column prop="title" label="Title"></el-table-column>
    <el-table-column label="Actions">
      <template #default="scope">
        <el-button type="primary" @click="viewPost(scope.row.id)">View</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import { useBoardStore } from '../../stores/board';
import { onMounted } from 'vue';
import { useRouter } from 'vue-router';

export default {
  setup() {
    const boardStore = useBoardStore();
    const router = useRouter();

    onMounted(() => {
      boardStore.fetchPosts();
    });

    const viewPost = (id) => {
      router.push(`/board/${id}`);
    };

    return {
      posts: boardStore.posts,
      viewPost
    };
  }
};
</script>
