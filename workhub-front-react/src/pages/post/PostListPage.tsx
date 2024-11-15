import React, { useEffect, useState } from "react";
import { fetchPosts } from "../../api/postApi";
import PostList from "../../components/post/PostList";
import { Post } from "../../interfaces/Post";

const PostListPage: React.FC = () => {
  const [posts, setPosts] = useState<Post[]>([]);

  useEffect(() => {
    const loadPosts = async () => {
      const data = await fetchPosts();
      setPosts(data);
    };
    loadPosts();
  }, []);

  return <PostList posts={posts} />;
};

export default PostListPage;
