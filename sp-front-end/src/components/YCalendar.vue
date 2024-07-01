<template>
  <n-card class="y-card-max-width">
    <template #header>
      <n-space justify="space-between">
        <n-text class="calendar-text-year-month-font-size"
          >{{ year }} 年 {{ month }} 月</n-text
        >
        <n-button-group class="y-calendar-button-group-no-padding">
          <n-button text style="font-size: 24px" @click="lastMouth()">
            <n-icon>
              <ChevronLeftOutlined />
            </n-icon>
          </n-button>
          <n-button text style="font-size: 24px" @click="nextMouth()">
            <n-icon>
              <ChevronRightOutlined />
            </n-icon>
          </n-button>
        </n-button-group>
      </n-space>
    </template>
    <template #default>
      <n-table
        :bordered="false"
        :single-line="false"
        :bottom-bordered="false"
        class="y-calendar-delete-table-border"
      >
        <tr>
          <td v-for="(item, index) in weeks" :key="index">
            <n-text depth="3">{{ item }}</n-text>
          </td>
        </tr>

        <tr v-for="(item, index) in calendar" :key="index">
          <td v-for="(it, i) in item" :key="i">
            <n-text v-if="it != 0">
              <n-button v-if="it == day" size="tiny" circle style="color:#fff; font-weight:500; background-color:#409EFF; border-color:#409EFF;" disabled="true" @click="changeDay(it)">
                {{ it }}
              </n-button>
              <n-button v-else size="tiny" circle @click="changeDay(it)">
                {{ it }}
              </n-button>
            </n-text>
          </td>
        </tr>
      </n-table>
    </template>
  </n-card>
</template>

<script>
import {
  NCard,
  NSpace,
  NText,
  NButtonGroup,
  NButton,
  NIcon,
  NTable,
} from "naive-ui";
import { ChevronLeftOutlined, ChevronRightOutlined } from "@vicons/material";
import dayjs from "dayjs";
export default {
  components: {
    "n-card": NCard,
    "n-space": NSpace,
    "n-text": NText,
    "n-button-group": NButtonGroup,
    "n-button": NButton,
    "n-icon": NIcon,
    "n-table": NTable,
    ChevronLeftOutlined,
    ChevronRightOutlined,
  },
  data() {
    return {
      year: 0,
      month: 0,
      day: 0,
      calendar: [],
      weeks: ["一", "二", "三", "四", "五", "六", "日" ],
      value: 0,
    };
  },
  emits:['changeDay'],
  methods: {
    // 获得日历
    getCalendar(y, m) {
      const time = dayjs().year(y).month(m);
      // 这个月第一天
      const fristDayOfMonth = time.date(1);
      // 这个月最后一天
      const endDayOfMonth = time.endOf("month");
      // 这个月第一天是星期几，星期日为0。
      const weekOfFristDay = fristDayOfMonth.day();
      // 列表存储位置指针
      let index = 0;
      this.calendar = [];
      // 列表
      const list = this.calendar;
      list.push([]);
      if (index < weekOfFristDay) {
        list[0].push(0);
        index++;
      }
      let currentDay = 1;
      while (currentDay <= endDayOfMonth.date()) {
        if (index % 7 == 0) {
          list.push([]);
        }
        list[parseInt(index / 7)].push(currentDay);
        currentDay++;
        index++;
      }
    },
    // 修改day
    changeDay(newDay) {
      this.day = newDay;
      const dayStr = dayjs().year(this.year).month(this.month - 1).date(this.day).format('YYYYMMDD') ;
      this.$emit('changeDay', dayStr);
    },
    lastMouth() {
      const newDate = dayjs().year(this.year).month(this.month - 1).subtract('1', 'month');
      this.refreshCalendar(newDate);
    },
    nextMouth() {
      const newDate = dayjs().year(this.year).month(this.month - 1).add('1', 'month');
      this.refreshCalendar(newDate);
    },
    refreshCalendar(yearMonth) {
      // 年
      this.year = yearMonth.year();
      // 这个月是第几个月
      this.month = yearMonth.month() + 1;
      // 今天是这个月第几天
      this.day = yearMonth.date();
      this.getCalendar(this.year, this.month - 1);
      this.changeDay(this.day);
    }
  },
  created() {
    const now = dayjs();
    this.refreshCalendar(now);
  },
};
</script>

<style>
.calendar-text-year-month-font-size {
  font-size: 18px;
}
.y-calendar-delete-table-border td {
  border: none;
  text-align: center;
  padding: 8px;
}
.y-card-max-width {
  width: 320px;
  border-radius: 15px;
  --shadow: rgba(18, 22, 33, 0.24);
  box-shadow: 0 1px 4px -1px var(--shadow);
}
.y-calendar-button-group-no-padding {
  padding: 0px !important;
  margin: 0px;
}
</style>