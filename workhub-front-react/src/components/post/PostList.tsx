import React from "react";
import { List, ListItem, ListItemText } from "@mui/material";
import { useNavigate } from "react-router-dom";
import { Post } from "../../interfaces/Post";

interface PostListProps {
  posts: Post[];
}

const PostList: React.FC<PostListProps> = ({ posts }) => {
  const navigate = useNavigate();

  return (
    <List>
      {posts.map((post) => (
        <ListItem
          button
          key={post.id}
          onClick={() => navigate(`/posts/${post.id}`)}
        >
          <ListItemText primary={post.title} />
        </ListItem>
      ))}
    </List>
  );
};

export default PostList;
