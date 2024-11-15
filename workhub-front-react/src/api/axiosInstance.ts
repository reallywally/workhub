import axios from 'axios';

const axiosInstance = axios.create({
  baseURL: 'https://your-api-url.com/api',
  headers: { 'Content-Type': 'application/json' },
});

export default axiosInstance;