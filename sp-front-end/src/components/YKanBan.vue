<template>
  <div class="scrollbar-wrap">
    <n-scrollbar style="height: 360px; padding: 10px 0px 20px;" x-scrollable>
      <div class="y-kan-ban-wrap">
        <!-- 类别选择框 -->
        <y-label-with-tool :customBackgroundColor="groupSelectColor">
          <template v-slot:main>
            <div class="selected-wrap">{{ groupByItem.text }}</div>
          </template>
          <template v-slot:tool>
            <button
              class="drop-down"
              @click="isSelectWrap = !isSelectWrap"
              @blur="dropDownButtonOnBlur()"
            >
              ▼
            </button>
            <div class="drop-down-wrap" v-show="isSelectWrap">
              <div class="drop-down-select">
                <ul>
                  <ol v-for="item in groupByItems" :key="item.text">
                    <div
                      class="drop-down-item"
                      @click="changeGroup(item)"
                      @mouseenter="isLeftSelect = false"
                      @mouseleave="isLeftSelect = true"
                    >
                      {{ item.text }}
                    </div>
                  </ol>
                </ul>
              </div>
            </div>
          </template>
        </y-label-with-tool>
        <n-empty
            v-if="groupByItem.text == ''"
            description="请选择一个类别查看吧😊"
            style="margin:50px 0px;"
          >
          </n-empty>
        <n-empty
          v-else-if="groupByItem.text != '' && JSON.stringify(groups) === '{}'"
          description="没有记录呀😭，快去数据格添加吧！"
          style="margin:50px 0px;"
        >
        </n-empty>
        <!-- 数据展示区 -->
        <n-space style="flex-flow: row nowrap; margin: 10px 0px;">
          <n-space vertical v-for="(group, category) in groups" :key="category">
            <y-label-with-tool :customBackgroundColor="emunStyle[category]">
              <template v-slot:main>
                <div class="category-wrap">{{ textStyle[category] }}</div>
              </template>
            </y-label-with-tool>
            <y-kan-ban-card v-for="item in group" :key="item.id">
              <template v-slot:header>
                <div class="title-wrap">{{ item.title }}</div>
              </template>
              <template v-slot:body>
                <!-- 优先级 -->
                <div class="field-wrap" v-if="groupByItem.value != 'priority'">
                  <div class="field-name-wrap">优先级</div>
                  <div
                    class="rainbow-wrap"
                    :style="{ 'background-color': emunStyles['priority'][item.priority] }">
                    {{ textStyles["priority"][item.priority] }}
                  </div>
                </div>
                <!-- 主题 -->
                <div
                  class="field-wrap"
                  v-if="groupByItem.value != 'scheduleFactorCategoryId'"
                >
                  <div class="field-name-wrap">主题</div>
                  <div
                    class="rainbow-wrap"
                    :style="{
                      'background-color':
                        emunStyles['scheduleFactorCategoryId'][
                          item.scheduleFactorCategoryId
                        ],
                    }"
                  >
                    {{
                      textStyles["scheduleFactorCategoryId"][
                        item.scheduleFactorCategoryId
                      ]
                    }}
                  </div>
                </div>
                <!-- 拖延情况 -->
                <div class="field-wrap" v-if="groupByItem.value != 'isDelay'">
                  <div class="field-name-wrap">拖延情况</div>
                  <div
                    class="rainbow-wrap"
                    :style="{ 'background-color': emunStyles['isDelay'][item.isDelay] }"
                  >
                    {{ textStyles["isDelay"][item.isDelay] }}
                  </div>
                </div>
                <!-- 完成情况 -->
                <div class="field-wrap" v-if="groupByItem.value != 'isFinish'">
                  <div class="field-name-wrap">完成情况</div>
                  <div
                    class="rainbow-wrap"
                    :style="{ 'background-color': emunStyles['isFinish'][item.isFinish] }"
                  >
                    {{ textStyles["isFinish"][item.isFinish] }}
                  </div>
                </div>
                <!-- 描述 -->
                <div class="field-wrap">
                  <div class="field-name-wrap">描述</div>
                  <div class="text-wrap">{{ item.description }}</div>
                </div>
              </template>
              <template v-slot:footer>
                <div class="time-wrap">
                  {{ parseTime(item.timePoint) }}
                  {{ "  " + getDurationView(item.durationView, item.duration) }}
                </div>
              </template>
            </y-kan-ban-card>
          </n-space>
        </n-space>
      </div></n-scrollbar
    >
  </div>
</template>

<script>
import YLabelWithTool from "./YLabelWithTool.vue";
import YKanBanCard from "./YKanBanCard.vue";
import { NSpace, NScrollbar, NEmpty } from "naive-ui";
import dayjs from "dayjs";
import { queryRowsByGroup } from "../service/SmsService.js";
import { userInfo } from '../service/config';
export default {
  data() {
    return {
      groupSelectColor: "#999999",
      groupByItem: { text: "", value: "" },
      groupByItems: [
        { text: "优先级", value: "priority" },
        { text: "主题", value: "scheduleFactorCategoryId" },
        { text: "拖延情况", value: "isDelay" },
        { text: "完成情况", value: "isFinish" },
      ],
      isSelectWrap: false,
      isLeftSelect: true,
      emunStyles: {
        isDelay: ["#bdecda", "#ddd6d5"],
        isFinish: ["#e18c9c", "#c4e8b3"],
        priority: ["#ddd6d5", "#e18c9c", "#fae1b3", "#9fd7ed", "#e8e4d6"],
        scheduleFactorCategoryId: [
          "",
          "#bfe3af",
          "#d5d6e7",
          "#bcead8",
          "#a0d7ee",
          "#f9e0b3",
        ],
      },
      emunStyle: null,
      textStyles: {
        isDelay: ["未拖延", "拖延"],
        isFinish: ["未完成", "完成"],
        priority: ["普通", "紧急重要", "紧急不重要", "重要不紧急", "不紧急不重要"],
        scheduleFactorCategoryId: [
          "",
          "生活健康投入",
          "专业学习投入",
          "综合素养投入",
          "实践能力投入",
          "社交娱乐投入",
        ],
      },
      textStyle: null,
      groups: {},
    };
  },
  props: {
    cardSn: {
      type: String,
      required: true,
    },
  },
  watch: {
    cardSn() {
      this.updateGroups();
    },
    groupByItem() {
      this.updateGroups();
    },
  },
  components: {
    YLabelWithTool,
    YKanBanCard,
    NSpace,
    NScrollbar,
    NEmpty,
  },
  methods: {
    changeGroup(item) {
      this.groupByItem = item;
      this.isSelectWrap = false;
      this.emunStyle = this.emunStyles[item.value];
      this.textStyle = this.textStyles[item.value];
    },
    dropDownButtonOnBlur() {
      if (this.isLeftSelect) {
        this.isSelectWrap = false;
      }
    },
    parseTime(timePoint) {
      return dayjs(timePoint).format("H:mm");
    },
    getDurationView(view, duration) {
      if (duration == null || duration == 0) {
        return "";
      }

      if (view == 0) {
        return duration / 3600 + "小时";
      } else if (view == 1) {
        return duration / 60 + "分钟";
      } else if (view == 2) {
        return duration + "秒";
      } else {
        return "未知错误";
      }
    },
    updateGroups() {
      const that = this;
      queryRowsByGroup(userInfo().id, that.cardSn, that.groupByItem.value).then(
        (response) => {
          const cardWithGroupByRow = response.data.data;
          if(cardWithGroupByRow.hasData) {
            that.groups = cardWithGroupByRow.groups;
          } else {
            that.groups = {};
          }
        }
      );
    }
  },
};
</script>

<style>
ul,
ol {
  list-style: none;
  margin: 0px;
  padding: 0px;
}
.scrollbar-wrap {
  margin: 10px 0px;
}
.y-kan-ban-wrap {
  letter-spacing: 1.5px;
  margin: 10px 20px;
}
.drop-down {
  margin: 0px;
  padding: 0px;
  width: 20px;
  height: 20px;
  border-radius: 10px;
  font-size: 5px;
  color: #fff;
  border-style: solid;
  border-width: 2px;
  border-color: white;
  background-color: #999999;
}
.drop-down:active {
  color: rgb(224, 217, 217);
  border-color: rgb(224, 217, 217);
}
.drop-down:hover {
  cursor: pointer;
}
.drop-down-wrap {
  position: absolute;
  z-index: 9999;
}

.drop-down-select {
  position: relative;
  left: -150px;
  width: 175px;
  margin-top: 10px;
  padding: 5px 10px;
  border-radius: 5px;
  box-shadow: 0px 0px 3px 1px #cccccc;
  background-color: #fff;
}

.drop-down-item {
  margin: 5px;
  padding: 5px;
  width: 85%;
  height: 20px;
  line-height: 20px;
  text-align: center;
}
.drop-down-item:hover {
  border-radius: 5px;
  box-shadow: 0px 0px 3px 1px #cccccc;
  cursor: pointer;
}
.selected-wrap {
  font-size: 14px;
  color: #fff;
  text-align: center;
}
.category-wrap {
  font-size: 14px;
  font-weight: 600;
  color: #fff;
  text-align: left;
}
.field-name-wrap {
  font-size: 12px;
  color: #666666;
  text-align: left;
}
.title-wrap {
  font-size: 14px;
  text-align: left;
}
.field-wrap {
  text-align: left;
  margin: 5px 0px;
}
.rainbow-wrap {
  display: inline-block;
  margin: 3px 0px;
  padding: 2px 10px;
  border-radius: 5px;
  font-size: 12px;
}
.text-wrap {
  font-size: 13px;
  padding: 2px 5px;
}
.time-wrap {
  font-size: 13px;
}
</style>
