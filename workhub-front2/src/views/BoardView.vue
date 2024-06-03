<template>
  <div>
    <h1>Board</h1>
    <router-link to="/board/new">Create New Post</router-link>
    <BoardList />
  </div>
</template>

<script>
import BoardList from '../components/Board/BoardList.vue';

export default {
  components: {
    BoardList
  }
};
</script>