import axiosInstance from './axiosInstance';
import { Post } from '../interfaces/Post';

export const fetchPosts = async (): Promise<Post[]> => {
  const response = await axiosInstance.get('/posts');
  return response.data;
};

export const fetchPost = async (id: number): Promise<Post> => {
  const response = await axiosInstance.get(`/posts/${id}`);
  return response.data;
};

export const createPost = async (post: Omit<Post, 'id'>): Promise<Post> => {
  const response = await axiosInstance.post('/posts', post);
  return response.data;
};