import React from "react";
import { useNavigate } from "react-router-dom";
import { createPost } from "../../api/postApi";
import PostForm from "../../components/post/PostForm";

const PostFormPage: React.FC = () => {
  const navigate = useNavigate();

  const handleCreatePost = async (post: { title: string; content: string }) => {
    await createPost(post);
    navigate("/posts");
  };

  return <PostForm onSubmit={handleCreatePost} />;
};

export default PostFormPage;
