<template>
  <n-layout has-sider>
    <n-layout-sider
      class="y-schedule-min-height y-layout-sider-wrap"
      bordered
      content-style="padding: 24px;"
      width="auto"
    >
      <y-calendar @change-day="onChangeDay" :cardId="cardId" />
      <n-card class="notify-card">
        <template #header>
          <div style="font-weight: 600; text-align: left; font-size: 14px;  color:#f0a026;">通知</div>
        </template>
        <div style="text-align: left">
          <div style="font-weight: 600; font-size: 13px">
            SP schedule - plan v1.0.0 发布啦😘
          </div>

          <div style="font-size: 12px; margin: 5px 0px; padding-left: 5px">
            🎯 日程模块发布 - 数据格、看板视图发布。
          </div>
          <div style="font-size: 12px; margin: 5px 0px; padding-left: 5px">
            🎯 计划模块发布 - 自定义计划模板，提供数据格、看板视图。
          </div>
          <div style="font-size: 12px; margin: 5px 0px; padding-left: 5px">
            🎯 历史模块发布 - 你的足迹，我们用心记录。
          </div>
        </div>
      </n-card>
    </n-layout-sider>
    <n-layout-content content-style="padding: 24px;">
      <y-tabs @tab-click="onTabClick" />
      <div class="y-tab-content-wrap">
        <y-table v-if="viewMode == 1" :card="card" />
        <y-kan-ban v-if="viewMode == 2" :cardSn="cardSn" />
      </div>
      <y-tab-footer :card="card" />
    </n-layout-content>
  </n-layout>
</template>

<script>
import { NLayout, NLayoutSider, NLayoutContent, NCard } from "naive-ui";
import YCalendar from "./YCalendar.vue";
import Table from "./Table.vue";
import YTabs from "./YTabs.vue";
import TabFooter from "./TabFooter.vue";
import { queryCard } from "../service/SmsService.js";
import { userInfo } from "../service/config";
import YKanBan from "./YKanBan.vue";
export default {
  data() {
    return {
      cardSn: undefined,
      card: {},
      viewMode: 1,
      factorMeta: [],
    };
  },
  watch: {
    cardSn(newCardSn) {
      const that = this;
      queryCard(userInfo().id, newCardSn).then((response) => {
        that.card = response.data.data;
      });
    },
  },
  components: {
    "n-layout": NLayout,
    "n-layout-content": NLayoutContent,
    "n-layout-sider": NLayoutSider,
    "y-calendar": YCalendar,
    "y-table": Table,
    YTabs,
    "y-tab-footer": TabFooter,
    YKanBan,
    NCard,
  },
  methods: {
    onChangeDay(cardSn) {
      this.cardSn = cardSn;
    },
    onTabClick(viewMode) {
      this.viewMode = viewMode;
    },
  },
  created() {},
};
</script>

<style>
.y-schedule-min-height {
  min-height: 700px;
}
.y-layout-sider-wrap {
  box-shadow: rgba(29, 35, 41, 0.05) 2px 0px 8px 0px;
}
.y-tab-content-wrap {
  border: 1px solid rgb(239, 239, 245);
  --shadow: rgba(18, 22, 33, 0.24);
  box-shadow: 0 1px 4px -1px var(--shadow);
  border-radius: 0px 21px 0px 21px;
  padding-bottom: 30px;
}
.notify-card {
  max-width: 310px;
  margin: 30px 0px 0px;
  background-color: #fdf3e4;
  border-radius: 10px;
   color:#f0a026;
}
</style>
