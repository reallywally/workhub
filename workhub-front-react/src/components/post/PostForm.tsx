import React, { useState } from "react";
import { TextField, Button } from "@mui/material";
import { Post } from "../../interfaces/Post";

interface PostFormProps {
  onSubmit: (post: Omit<Post, "id">) => void;
}

const PostForm: React.FC<PostFormProps> = ({ onSubmit }) => {
  const [post, setPost] = useState({ title: "", content: "" });

  const handleChange = (
    e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
  ) => {
    setPost({ ...post, [e.target.name]: e.target.value });
  };

  const handleSubmit = () => {
    onSubmit(post);
  };

  return (
    <div>
      <TextField
        label="제목"
        name="title"
        fullWidth
        margin="normal"
        value={post.title}
        onChange={handleChange}
      />
      <TextField
        label="내용"
        name="content"
        fullWidth
        margin="normal"
        multiline
        rows={4}
        value={post.content}
        onChange={handleChange}
      />
      <Button variant="contained" onClick={handleSubmit}>
        저장
      </Button>
    </div>
  );
};

export default PostForm;
