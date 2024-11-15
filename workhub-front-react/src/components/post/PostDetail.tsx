import React from "react";
import { Typography, Button } from "@mui/material";
import { Post } from "../../interfaces/Post";

interface PostDetailProps {
  post: Post;
  onBack: () => void;
}

const PostDetail: React.FC<PostDetailProps> = ({ post, onBack }) => {
  return (
    <div>
      <Typography variant="h4">{post.title}</Typography>
      <Typography variant="body1">{post.content}</Typography>
      <Button variant="contained" onClick={onBack}>
        목록으로
      </Button>
    </div>
  );
};

export default PostDetail;
