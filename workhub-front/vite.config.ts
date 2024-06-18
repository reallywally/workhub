import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueJsx from '@vitejs/plugin-vue-jsx'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    vueJsx(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  server: {
    // api 요청을 8080 포트로 프록시
    proxy: {
      "/api": {
        target: "http://localhost:8080",
        // rewrite: (path) => path.replace(/^\/api/, '')
      }
    }
  }
})
