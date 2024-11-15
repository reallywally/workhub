import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { fetchPost } from "../../api/postApi";
import PostDetail from "../../components/post/PostDetail";
import { Post } from "../../interfaces/Post";

const PostDetailPage: React.FC = () => {
  const { id } = useParams<{ id: string }>();
  const [post, setPost] = useState<Post | null>(null);
  const navigate = useNavigate();

  useEffect(() => {
    const loadPost = async () => {
      if (id) {
        const data = await fetchPost(Number(id));
        setPost(data);
      }
    };
    loadPost();
  }, [id]);

  return post ? (
    <PostDetail post={post} onBack={() => navigate("/posts")} />
  ) : (
    <p>Loading...</p>
  );
};

export default PostDetailPage;
