<template>
  <n-space justify="center" class="sider-logo-wrap">
    <n-image width="50" src="/logo.svg" />
  </n-space>
  <n-menu
    :collapsed-width="64"
    :collapsed-icon-size="22"
    :options="menuOptions"
    :default-value="defaultValue"
  />
</template>

<script>
import { NSpace, NMenu, NImage, NAvatar } from "naive-ui";
import { WorkOutlineFilled } from "@vicons/material";
import { Factor, Account } from "@vicons/carbon";
import { renderIcon } from "../common/common.js";
import { h, resolveComponent } from "vue";
export default {
  components: {
    NSpace,
    NMenu,
    NImage,
    NAvatar,
  },
  setup() {
    const menuOptions = [
      {
        label: () =>
          h(
            resolveComponent("router-link"),
            {
              to: {
                path: "/",
                params: {
                  lang: "zh-CN",
                },
              },
            },
            { default: () => "工作台" }
          ),
        key: "work-table",
        icon: renderIcon(WorkOutlineFilled),
      },
      {
        label: () =>
          h(
            resolveComponent("router-link"),
            {
              to: {
                path: "/factor",
                params: {
                  lang: "zh-CN",
                },
              },
            },
            { default: () => "因素库" }
          ),
        key: "factor-db",
        icon: renderIcon(Factor),
      },
      {
        label: () =>
          h(
            resolveComponent("router-link"),
            {
              to: {
                path: "/module-define",
                params: {
                  lang: "zh-CN",
                },
              },
            },
            { default: () => "模板定义" }
          ),
        key: "attribute-db",
        icon: renderIcon(Account),
      }
    ];
    const defaultValue = menuOptions[0].key;
    return {
      menuOptions,
      defaultValue,
    };
  },
};
</script>

<style>
.sider-logo-wrap {
  padding-top: 20px;
}
</style>