<template>
  <n-config-provider
    :locale="zhCN"
    :date-locale="dateZhCN"
    :theme-overrides="theme.themeOverrids"
  >
    <n-message-provider>
      <router-view></router-view>
    </n-message-provider>
  </n-config-provider>
</template>

<script>
import { NConfigProvider, NMessageProvider } from "naive-ui";
import useThemeStore from "./theme/index";
export default {
  name: "App",
  data() {
    return {};
  },
  components: {
    NConfigProvider,
    NMessageProvider,
  },
  methods: {},
  setup() {
    const theme = useThemeStore();
    return {
      theme,
    };
  },
};
</script>

<style>
body {
  margin: 0px;
  padding: 0px;
  font-family: Helvetica, 'Hiragino Sans GB', 'Microsoft Yahei', '微软雅黑', Arial, sans-serif;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
