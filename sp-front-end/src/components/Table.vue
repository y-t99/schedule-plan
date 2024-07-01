<template>
  <!-- <div class="y-table"> -->
  <div class="row--top-20">
    <div style="min-height: 390px">
      <div  class="default-scrollbar" style="height: 370px; overflow:scroll;">
        <n-space justify="center">
          <n-empty
            v-if="!card.rows || card.rows.length == 0"
            description="没有记录噢~ 添加一个吧😊"
          >
          </n-empty>
          <table v-else style="min-width: 900px;"> 
            <thead class="table__thead">
              <tr>
                <th class="table__th">
                  <input id="selectAll" type="checkbox" class="table__select-row" />
                </th>
                <th class="table__th">时间</th>
                <th class="table__th">标题</th>
                <th class="table__th">优先级</th>
                <th class="table__th">主题</th>
                <th class="table__th">进度</th>
                <th class="table__th">描述</th>
                <th class="table__th"></th>
              </tr>
            </thead>

            <tbody class="table__tbody">
              <tr
                class="table-row"
                :class="item.isDelay == 1 ? 'table-row--red' : ''"
                v-for="(item, index) in card.rows"
                :key="index"
              >
                <td class="table-row__td">
                  <input id="" type="checkbox" class="table__select-row" />
                </td>
                <td data-column="time" class="table-row__td">
                  <div class="">
                    <p class="table-row__time_point">
                      {{ proxyDayjs(item.timePoint).format("HH:mm") }}
                    </p>
                    <span
                      class="table-row__small"
                      v-if="item.duration != null && item.duration != 0"
                      >{{ getDurationView(item.durationView, item.duration) }}</span
                    >
                  </div>
                </td>
                <td data-column="title" class="table-row__td">
                  <!-- <div class="table-row__img"></div> -->
                  <div class="table-row__info">
                    <p class="table-row__title">{{ item.title }}</p>
                  </div>
                </td>
                <td data-column="priority" class="table-row__td">
                  <p class="table-row__priority status" :class="color[item.priority]">
                    {{ priority[item.priority] }}
                  </p>
                </td>
                <td data-column="subject" class="table-row__td">
                  <div class="table-row__info">
                    <p class="table-row__subject">
                      {{ item.scheduleFactorCategoryName }}
                    </p>
                  </div>
                </td>
                <td data-column="progress" class="table-row__td">
                  <p
                    class="table-row__progress status finish-wrap"
                    :class="item.isFinish == 0 ? 'status--grey' : 'status--green'"
                    @click="toggleFinishState(item)"
                  >
                    {{ item.isFinish == 0 ? "未完成" : "完成" }}
                  </p>
                  <br />
                  <p
                    class="table-row__progress status finish-wrap"
                    v-if="item.isFinish == 1"
                    :class="item.isDelay == 1 ? 'status--red' : 'status--green'"
                    @click="toggleDelayState(item)"
                  >
                    {{ item.isDelay == 0 ? "未拖延" : "拖延" }}
                  </p>
                </td>
                <td data-column="descript" class="table-row__td">
                  <div class="table-row__info">
                    <div class="table-row__descript">
                      <n-ellipsis style="max-width: 240px">
                        {{ item.description }}
                      </n-ellipsis>
                    </div>
                  </div>
                </td>

                <td class="table-row__td">
                  <n-button
                    class="table-row__ellipsis"
                    text
                    @click="addFactor(item.scheduleFactorCategoryId, item.id)"
                  >
                    <n-icon>
                      <ellipsis-horizontal-outline />
                    </n-icon>
                  </n-button>
                  <n-button class="table-row__edit" @click="rowModal(item.id)">
                    <n-icon>
                      <pencil-alt />
                    </n-icon>
                  </n-button>
                  <svg
                    data-toggle="tooltip"
                    data-placement="bottom"
                    title="Delete"
                    version="1.1"
                    class="table-row__bin"
                    xmlns="http://www.w3.org/2000/svg"
                    xmlns:xlink="http://www.w3.org/1999/xlink"
                    x="0px"
                    y="0px"
                    viewBox="0 0 512 512"
                    style="enable-background: new 0 0 512 512"
                    xml:space="preserve"
                  >
                    <g>
                      <g>
                        <path
                          d="M436,60h-90V45c0-24.813-20.187-45-45-45h-90c-24.813,0-45,20.187-45,45v15H76c-24.813,0-45,20.187-45,45v30    c0,8.284,6.716,15,15,15h16.183L88.57,470.945c0.003,0.043,0.007,0.086,0.011,0.129C90.703,494.406,109.97,512,133.396,512    h245.207c23.427,0,42.693-17.594,44.815-40.926c0.004-0.043,0.008-0.086,0.011-0.129L449.817,150H466c8.284,0,15-6.716,15-15v-30    C481,80.187,460.813,60,436,60z M196,45c0-8.271,6.729-15,15-15h90c8.271,0,15,6.729,15,15v15H196V45z M393.537,468.408    c-0.729,7.753-7.142,13.592-14.934,13.592H133.396c-7.792,0-14.204-5.839-14.934-13.592L92.284,150h327.432L393.537,468.408z     M451,120h-15H76H61v-15c0-8.271,6.729-15,15-15h105h150h105c8.271,0,15,6.729,15,15V120z"
                          style="fill: rgb(158, 171, 180)"
                        ></path>
                      </g>
                    </g>
                    <g>
                      <g>
                        <path
                          d="M256,180c-8.284,0-15,6.716-15,15v212c0,8.284,6.716,15,15,15s15-6.716,15-15V195C271,186.716,264.284,180,256,180z"
                          style="fill: rgb(158, 171, 180)"
                        ></path>
                      </g>
                    </g>
                    <g>
                      <g>
                        <path
                          d="M346,180c-8.284,0-15,6.716-15,15v212c0,8.284,6.716,15,15,15s15-6.716,15-15V195C361,186.716,354.284,180,346,180z"
                          style="fill: rgb(158, 171, 180)"
                        ></path>
                      </g>
                    </g>
                    <g>
                      <g>
                        <path
                          d="M166,180c-8.284,0-15,6.716-15,15v212c0,8.284,6.716,15,15,15s15-6.716,15-15V195C181,186.716,174.284,180,166,180z"
                          style="fill: rgb(158, 171, 180)"
                        ></path>
                      </g>
                    </g>
                  </svg>
                </td>
              </tr>
            </tbody>
          </table>
          <n-modal
            class="custom-card"
            v-model:show="factorModal"
            preset="card"
            :style="bodyStyle"
            title="来记录您日程的更多信息吧😘"
            :bordered="false"
            :segmented="segmented"
          >
            <template #header-extra>😥更多信息日程历史会更加丰富噢！</template>
            <div class="flex-start margin-5">
              <div class="y-button factory-category-label">活动类型：</div>
              <n-select
                class="factory-category-input"
                v-model:value="factoryCategoryId"
                :options="factoryCategoryOptions"
                @update:value="updateFactorMeta"
              />
            </div>
            <div class="flex-start margin-5">
              <div class="y-button factory-category-label">提示：</div>
              <div class="y-button">
                {{ factorMeta.tip }}
              </div>
            </div>
            <div class="flex-start margin-5">
              <div class="y-button factory-category-label">活动详情：</div>
              <div v-if="factorMeta.inputType == 1">
                <n-select
                  v-if="factorMeta.selectType == 1"
                  v-model:value="si"
                  :options="inputListOptions"
                  class="factory-category-input"
                  placeholder=""
                />
                <n-select
                  v-if="factorMeta.selectType == 2"
                  multiple
                  v-model:value="mi"
                  :options="inputListOptions"
                  class="factory-category-input"
                  placeholder=""
                />
              </div>
              <div v-else-if="factorMeta.inputType == 2">
                <n-dynamic-tags v-model:value="tags" :max="maxTags" />
              </div>
            </div>
            <template #footer>
              <div class="y-table-footer-wrap">
                <div v-if="isUpdate" class="y-button" @click="updateFactor">更新信息</div>
                <div v-else class="y-button" @click="pushFactor">添加信息</div>
              </div>
            </template>
          </n-modal>
          <n-modal
            v-model:show="updateRowModal"
            :mask-closable="false"
            preset="card"
            class="y-table-row-modal-wrap"
            ><template #header>
              <div>😘规划修改</div>
            </template>
            <div>
              <n-spin :show="rowSpinShow">
                <div class="y-table-row-grid">
                  <div class="y-table-row-modal-label">起点</div>
                  <div class="y-table-row-span-col-3">
                    <n-time-picker
                      v-model:value="rowInfo.timePoint"
                      placeholder="开始时间点"
                    />
                  </div>
                  <div class="y-table-row-modal-label">
                    <n-switch size="small" v-model:value="rowInfo.hasDuration" />
                  </div>
                  <div class="y-table-row-modal-label">时长</div>
                  <div class="y-table-row-span-col-2">
                    <n-input-number
                      :min="0"
                      :disabled="!rowInfo.hasDuration"
                      v-model:value="rowInfo.duration"
                    />
                  </div>
                  <div class="y-table-row-span-col-2">
                    <n-select
                      placeholder="单位"
                      v-model:value="rowInfo.durationTimeUnit"
                      :disabled="!rowInfo.hasDuration"
                      :options="durationTimeUnitOptions"
                    />
                  </div>
                  <div class="y-table-row-modal-label">标题</div>
                  <div class="y-table-row-span-col-3">
                    <n-input
                      type="text"
                      v-model:value="rowInfo.title"
                      placeholder="标题"
                    />
                  </div>
                  <div class="y-table-row-modal-label">优先级</div>
                  <div class="y-table-row-span-col-2">
                    <n-select
                      placeholder="优先级"
                      v-model:value="rowInfo.priority"
                      :render-Option="renderOption"
                      :options="priorityOptions"
                    />
                  </div>
                  <div class="y-table-row-modal-label">主题</div>
                  <div class="y-table-row-span-col-2">
                    <n-select
                      placeholder="主题"
                      v-model:value="rowInfo.subject"
                      :options="subjectOptions"
                    />
                  </div>
                  <div class="y-table-row-modal-label">描述</div>
                  <div class="y-table-row-span-col-9">
                    <n-input
                      type="text"
                      v-model:value="rowInfo.description"
                      placeholder="描述"
                    />
                  </div>
                  <div class="y-table-row-span-col-9"></div>
                  <div><n-button @click="updateRow">更新</n-button></div>
                </div>
              </n-spin>
            </div>
          </n-modal>
        </n-space>
      </div>
      <div class="block-hidden-line">

        </div>
    </div>
  </div>
  <!-- </div> -->
</template>

<script>
import {
  NSpace,
  NButton,
  NIcon,
  NEllipsis,
  NEmpty,
  NModal,
  NDynamicTags,
  NSelect,
  NSpin,
  NTimePicker,
  NInputNumber,
  NInput,
  NSwitch,
  NTooltip,
} from "naive-ui";
import { EllipsisHorizontalOutline } from "@vicons/ionicons5";
import { PencilAlt } from "@vicons/fa";
import dayjs from "dayjs";
import { h } from "vue";
import { userInfo } from "../service/config";
import {
  getFactorMeta,
  pushFactor,
  getFactorValue,
  putFactor,
  getRowMeta,
  putRow,
  queryCard,
  toggleFinish,
  toggleDelay,
} from "../service/SmsService.js";
export default {
  data() {
    return {
      rowSpinShow: false,
      rowInfo: {
        id: null,
        title: "",
        timePoint: 0,
        hasDuration: false,
        duration: 0,
        durationTimeUnit: 1,
        priority: "",
        subject: "",
        description: "",
      },
      durationTimeUnitOptions: [
        { label: "小时", value: 3600 },
        { label: "分钟", value: 60 },
        { label: "秒", value: 1 },
      ],
      priorityOptions: [
        { label: "普通", value: 0 },
        { label: "重要紧急", value: 1 },
        { label: "紧急不重要", value: 2 },
        { label: "重要不紧急", value: 3 },
        { label: "不重要不紧急", value: 4 },
      ],
      renderOption: ({ node, option }) =>
        h(NTooltip, null, {
          trigger: () => node,
          default: () => option.label,
        }),
      subjectOptions: null,
      rowMeta: {},
      priority: ["普通", "紧急重要", "紧急不重要", "重要不紧急", "不重要不紧急"],
      color: [
        "status--grey",
        "status--red",
        "status--yellow",
        "status--blue",
        "status--grey",
      ],
      factorModal: false,
      bodyStyle: {
        width: "600px",
      },
      segmented: {
        content: "soft",
        footer: "soft",
      },
      tags: [],
      factoryCategoryOptions: [],
      factorMeta: {
        factoryCategoryId: null,
        tip: "",
        inputType: "",
        selectType: "",
        inputList: "",
      },
      factoryCategoryId: null,
      optionsMap: {},
      inputListOptions: [],
      si: "",
      mi: [],
      maxTags: 5,
      curRowId: null,
      isUpdate: false,
      curRactorId: null,
      updateRowModal: false,
      subjectOptionsMap: {},
    };
  },
  props: {
    card: {
      type: Object,
      required: true,
    },
  },
  components: {
    NSpace,
    EllipsisHorizontalOutline,
    NButton,
    NIcon,
    PencilAlt,
    NEllipsis,
    NEmpty,
    NModal,
    NDynamicTags,
    NSelect,
    NSpin,
    NTimePicker,
    NInputNumber,
    NInput,
    NSwitch,
  },
  methods: {
    getDurationView(view, duration) {
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
    proxyDayjs(unixTime) {
      return dayjs(unixTime);
    },
    addFactor(scheduleFactorCategoryId, rowId) {
      // 当前行记录
      this.curRowId = rowId;
      const that = this;
      // 获取类别下的因素
      getFactorMeta(scheduleFactorCategoryId).then((response) => {
        const data = response.data.data;
        // 类别下的因素List
        that.factoryCategoryOptions = [];
        // 类别下的因素map key为factorId
        that.optionsMap = {};
        for (let i = 0; i < data.length; i++) {
          let option = {
            label: data[i].name,
            value: data[i].id,
            tip: data[i].tip,
            inputType: data[i].inputType,
            selectType: data[i].selectType,
            inputList: data[i].inputList,
          };
          that.factoryCategoryOptions.push(option);
          that.optionsMap[data[i].id] = option;
        }
      });

      getFactorValue(rowId).then((response) => {
        const data = response.data.data;
        if (data != null) {
          that.factoryCategoryId = data.factorId;
          that.updateState(that.factoryCategoryId);
          if (that.factorMeta.inputType == 1) {
            if (that.factorMeta.selectType == 1) {
              that.si = data.factorValues;
            } else {
              that.mi = data.factorValues.split(",");
            }
          } else {
            that.tags = data.factorValues.split(",");
          }
          that.isUpdate = true;
          that.curRactorId = data.id;
        } else {
          if (that.factoryCategoryOptions.length != 0) {
            // 选第一个作为默认选项。
            that.factoryCategoryId = that.factoryCategoryOptions[0].value;
            that.updateState(that.factoryCategoryId);
          }
          that.isUpdate = false;
        }
        that.factorModal = true;
      });

      
    },
    updateFactor() {
      let rowId = this.curRowId;
      let id = this.curRactorId;
      let factorId = this.factoryCategoryId;
      let factorValues;
      if (this.factorMeta.inputType == 1) {
        if (this.factorMeta.selectType == 1) {
          factorValues = this.si;
        } else {
          factorValues = this.mi.join(",");
        }
      } else {
        factorValues = this.tags.join(",");
      }
      putFactor({
        id,
        rowId,
        factorId,
        factorValues,
      });
      this.factorModal = false;
    },
    pushFactor() {
      let rowId = this.curRowId;
      let factorId = this.factoryCategoryId;
      let factorValues;
      if (this.factorMeta.inputType == 1) {
        if (this.factorMeta.selectType == 1) {
          factorValues = this.si;
        } else {
          factorValues = this.mi.join(",");
        }
      } else {
        factorValues = this.tags.join(",");
      }
      pushFactor({
        rowId,
        factorId,
        factorValues,
      });
      this.factorModal = false;
    },
    updateState(newId) {
      this.factorMeta = this.optionsMap[newId];
      if (this.factorMeta.inputType == 1) {
        this.inputListOptions = [];
        this.si = "";
        this.mi = [];
        let inputList = this.factorMeta.inputList.split(",");
        for (let i = 0; i < inputList.length; i++) {
          this.inputListOptions.push({
            label: inputList[i],
            value: inputList[i],
          });
        }
      } else if (this.factorMeta.inputType == 2) {
        this.tags = [];
        if (this.factorMeta.selectType == 1) {
          this.maxTags = 1;
        } else {
          this.maxTags = 5;
        }
      }
    },
    rowModal(rowId) {
      if (this.subjectOptions == null) {
        let that = this;
        getRowMeta().then((response) => {
          that.rowMeta = response.data.data;
          const factorCategories = that.rowMeta.smsFactorCategories;
          that.subjectOptions = [];
          for (let i = 0; i < factorCategories.length; i++) {
            let category = factorCategories[i];
            let subject = {
              label: category.name,
              value: category.id,
              id: category.id,
            };
            that.subjectOptions.push(subject);
            that.subjectOptionsMap[subject.id] = subject;
          }
          that._rowModal(rowId);
          that.updateRowModal = true;
        });
      } else {
        this._rowModal(rowId);
        this.updateRowModal = true;
      }
    },

    updateRow() {
      let rowInfo = this.rowInfo;
      let duration = null;
      if (rowInfo.hasDuration) {
        duration =
          rowInfo.duration * rowInfo.durationTimeUnit;
      }
      let that = this;
      putRow({
        id: rowInfo.id,
        title: rowInfo.title,
        timePoint: rowInfo.timePoint,
        duration: duration,
        durationView: rowInfo.durationView,
        priority: rowInfo.priority,
        scheduleFactorCategoryId: rowInfo.subject,
        scheduleFactorCategoryName: that.subjectOptionsMap[rowInfo.subject]['label'],
        description: rowInfo.description
      }).then(() => {
        let deepThis = that;
        queryCard(userInfo().id, that.card.cardSn).then((response) => {
          deepThis.card.rows = response.data.data.rows;
          deepThis.updateRowModal = false;
        });
      });
    },
    toggleFinishState(item) {
      if(item.isFinish == 1) {
        item.isFinish = 0;
        item.isDelay = 0;
        toggleDelay(item.id, item.isDelay);
      } else {
        item.isFinish = 1;
      }
      toggleFinish(item.id, item.isFinish);
    },
    toggleDelayState(item) {
      if(item.isDelay == 0) {
        item.isDelay = 1;
      } else {
        item.isDelay = 0;
      }
      toggleDelay(item.id, item.isDelay);
    },
    _rowModal(rowId) {
      let rows = this.card.rows;
      for (let i = 0; i < rows.length; i++) {
        let row = rows[i];
        if (row.id == rowId) {
          let rowInfo = this.rowInfo;
          rowInfo.id = rowId;
          rowInfo.title = row.title;
          rowInfo.timePoint = row.timePoint;
          if (row.duration != null) {
            rowInfo.hasDuration = true;
            let unit = this.durationTimeUnitOptions[row.durationView];
            rowInfo.durationTimeUnit = unit.value;
            rowInfo.duration = row.duration / unit.value;
          } else {
             rowInfo.hasDuration = false;
            rowInfo.duration = 0;
            rowInfo.durationTimeUnit = 1;
          }
          rowInfo.priority = row.priority;
          rowInfo.subject = row.scheduleFactorCategoryId;
          rowInfo.description = row.description;
          break;
        }
      }
    },
    updateFactorMeta() {
      this.factorMeta = this.optionsMap[this.factoryCategoryId];
      if(this.factorMeta.selectType == 1) {
        this.maxTags = 1;
      } else {
        this.maxTags = 5;
      }
    }
  },
};
</script>

<style>
@import "../common/table.css";
@import "./datasheet/css/common.css";
@import "./datasheet/css/scrollbar.css";
@import "../common/rowModal.css";
.y-table {
  border: 1px solid rgb(239, 239, 245);
  --shadow: rgba(18, 22, 33, 0.24);
  box-shadow: 0 1px 4px -1px var(--shadow);
  border-radius: 0px 21px 21px 21px;
  padding-bottom: 30px;
}
.y-table-footer-wrap {
  text-align: right;
}
.y-table-footer-wrap div {
  font-size: 14px;
}
.factory-category-label {
  font-size: 14px;
}
.factory-category-input {
  display: inline-block;
  width: 200px;
}
.finish-wrap {
  cursor: pointer;
}
.finish-wrap:active {
  color: #409eff;
}
.block-hidden-line{
  border-color: white;
  border-style: solid;
  position: relative;
  top: -2px;
}
</style>
