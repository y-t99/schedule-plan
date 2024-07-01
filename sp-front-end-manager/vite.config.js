import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import path from "path"
export default defineConfig({
  plugins: [vue()],
  configureWebpack: {
    resolve: {
      extensions: [".ts", ".tsx", ".js", ".json"],
      alias: [
        {
          find: '@',
          replacement: path.resolve(__dirname, 'src')
        }
      ]
    },
    module: {
      rules: [
        {
          test: /\.tsx?$/,
          loader: 'ts-loader',
          exclude: /node_modules/,
          options: {
            appendTsSuffixTo: [/\.vue$/],
          }
        },
      ]
    }
  },
  server: {
    host: '0.0.0.0',
    port: 9090,
  },
})