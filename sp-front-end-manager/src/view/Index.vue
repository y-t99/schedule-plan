<template>
  <n-config-provider
    :locale="zhCN"
    :date-locale="dateZhCN"
    :theme-overrides="theme.themeOverrids"
  >
    <n-message-provider>
      <n-layout position="absolute">
        <n-layout has-sider class="y-index-layout-wrap">
          <n-layout-sider
            class="y-layout-sider-wrap"
            bordered
            collapse-mode="width"
            :collapsed-width="64"
            :width="240"
            :native-scrollbar="false"
          >
            <sider-nav />
          </n-layout-sider>
          <n-layout>
            <n-layout-header
              bordered
              content-style="padding: 24px;"
              class="y-layout-header-wrap"
            >
              <Header />
            </n-layout-header>
            <n-layout-content content-style="padding:15px" class="y-main-body">
              <n-layout class="y-content-wrap">
                <router-view></router-view>
              </n-layout>
            </n-layout-content>
          </n-layout>
        </n-layout>
      </n-layout>
    </n-message-provider>
  </n-config-provider>
</template>

<script>
import {
  NConfigProvider,
  NLayoutSider,
  NLayout,
  NLayoutHeader,
  NLayoutContent,
  NSpace,
  NMessageProvider,
} from "naive-ui";
import useThemeStore from "../theme/index";
import SiderNav from "../components/SiderNav.vue";
import Header from "../components/Header.vue";
export default {
  components: {
    NConfigProvider,
    NLayoutSider,
    NLayout,
    NLayoutHeader,
    NLayoutContent,
    NSpace,
    SiderNav,
    Header,
    NMessageProvider,
  },
  setup() {
    const theme = useThemeStore();
    return {
      theme,
    };
  },
};
</script>
<style>
.n-config-provider,
.y-index-layout-wrap,
.y-content-wrap {
  background-color: #f6f9f8;
  height: 100%;
}
.y-content-wrap {
    width: 1266px;
}
.y-layout-sider-wrap {
  box-shadow: rgba(29, 35, 41, 0.05) 2px 0px 8px 0px;
}
.y-layout-header-wrap {
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  z-index: 11;
  box-shadow: rgba(29, 35, 41, 0.05) 2px 0px 8px 0px;
}
.y-main-body {
  padding-top: 55px;
  height: 100%;
  background-color: #f6f9f8;
}
</style>