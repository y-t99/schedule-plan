<template>
  <div class="y-tabs-footer-wrap">
    <div class="hide"></div>
    <n-modal
      v-model:show="rowModal"
      :mask-closable="false"
      preset="card"
      class="row-modal-wrap"
      ><template #header>
        <div>😀添加一个规划吧</div>
      </template>
      <div>
        <n-spin :show="rowSpinShow">
          <div class="grid">
            <div class="modal-label">起点</div>
            <div class="span-col-3">
              <n-time-picker v-model:value="timePoint" placeholder="开始时间点" />
            </div>
            <div class="modal-label">
              <n-switch size="small" v-model:value="hasDuration" />
            </div>
            <div class="modal-label">时长</div>
            <div class="span-col-2">
              <n-input-number
                :min="0"
                :disabled="!hasDuration"
                v-model:value="duration"
              />
            </div>
            <div class="span-col-2">
              <n-select
                placeholder="单位"
                v-model:value="durationTimeUnit"
                :disabled="!hasDuration"
                :options="durationTimeUnitOptions"
              />
            </div>
            <div class="modal-label">标题</div>
            <div class="span-col-3">
              <n-input type="text" v-model:value="title" placeholder="标题" />
            </div>
            <div class="modal-label">优先级</div>
            <div class="span-col-2">
              <n-select
                placeholder="优先级"
                v-model:value="priority"
                :render-Option="renderOption"
                :options="priorityOptions"
              />
            </div>
            <div class="modal-label">主题</div>
            <div class="span-col-2">
              <n-select
                placeholder="主题"
                v-model:value="subject"
                :options="subjectOptions"
              />
            </div>
            <div class="modal-label">描述</div>
            <div class="span-col-9">
              <n-input type="text" v-model:value="description" placeholder="描述" />
            </div>
            <div class="span-col-9"></div>
            <div><n-button @click="createRow">添加</n-button></div>
          </div>
        </n-spin>
      </div>
    </n-modal>
    <n-modal v-model:show="rateModal">
      <n-card style="width: 350px;">
        <template #header> 日程卡完成满意度 </template>
        <div style="font-size:14; color:#666;margin: 20px 3px 10px">
          请对你今天的日程卡打个分吧😊
        </div>
        <div style="text-align: center; margin-bottom: 10px;" >
          <n-rate color="#409EFF" @update:value="updateRate" v-model:value="rate"/>
        </div>
      </n-card>
    </n-modal>
    <n-modal v-model:show="emoModal">
      <n-card style="width: 400px;">
        <template #header> 今天你的心情如何😜 </template>
        <div style="font-size:14; color:#666;margin: 10px 3px 10px">
          请对你今天的心情吧😊
        </div>
        <div style="text-align: center; margin-bottom: 10px;" >
          <div class="grid-5">
            <div class="span-col-1 emo-wrap" v-for="(pnsn, index) in pnsns" :key="index" @click="chooseEmo(pnsn)">
              <div :class="{'emo-title': !pnsn.isChoose, 'emo-active': pnsn.isChoose, }">{{pnsn.title}}</div>
              <div>{{pnsn.emo}}</div>
            </div>
          </div>
        </div>
      </n-card>
    </n-modal>
    <nav class="tabbar-footer">
      <ul>
        <li class="add">
          <a href="javascript:void(0);" @click="tabClick(1)">
            <div></div>
            <span>添加记录</span>
          </a>
        </li>
        <li class="emo">
          <a href="javascript:void(0);" @click="tabClick(2)">
            <div></div>
            <span>心情</span>
          </a>
        </li>
        <li class="sa">
          <a href="javascript:void(0);" @click="tabClick(3)">
            <div></div>
            <span>自我评分</span>
          </a>
        </li>
      </ul>
    </nav>
  </div>
</template>

<script>
import {
  NModal,
  NTimePicker,
  NSwitch,
  NSelect,
  NInputNumber,
  NInput,
  NButton,
  NTooltip,
  NSpin,
  NCard,
  useMessage,
  NRate,
} from "naive-ui";
import { h } from "vue";
import { getRowMeta, createCardRow } from "../service/SmsService.js";
export default {
  setup() {
    const message = useMessage();
    return {
      info(infoMessage) {
        message.info(infoMessage);
      },
    };
  },
  data() {
    return {
      pnsns: [
        {title: "专心的", emo: "✍️", isChoose: false},
        {title: "有兴致的", emo: "🤩", isChoose: false},
        {title: "机智的", emo: "😏", isChoose: false},
        {title: "兴奋的", emo: "😁", isChoose: false},
        {title: "热心的", emo: "😀", isChoose: false},
        {title: "有灵感的", emo: "🤔", isChoose: false},
        {title: "自豪的", emo: "😊", isChoose: false},
        {title: "坚决的", emo: "👊", isChoose: false},
        {title: "坚定的", emo: "✊", isChoose: false},
        {title: "活跃的", emo: "😛", isChoose: false},
        {title: "心烦的", emo: "😕", isChoose: false},
        {title: "难过的", emo: "😞", isChoose: false},
        {title: "内疚的", emo: "😢", isChoose: false},
        {title: "惊恐的", emo: "😫", isChoose: false},
        {title: "憎恶的", emo: "😠", isChoose: false},
        {title: "急躁的", emo: "😡", isChoose: false},
        {title: "羞耻的", emo: "😳", isChoose: false},
        {title: "紧张的", emo: "😣", isChoose: false},
        {title: "不安的", emo: "😟", isChoose: false},
        {title: "害怕的", emo: "😨", isChoose: false},
      ],
      cur: 1,
      rowModal: false,
      emoModal: false,
      rateModal: false,
      duration: 0,
      hasDuration: false,
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
      durationTimeUnit: 60,
      rowMeta: {},
      subject: undefined,
      subjectOptions: [],
      priority: 0,
      renderOption: ({ node, option }) =>
        h(NTooltip, null, {
          trigger: () => node,
          default: () => option.label,
        }),
      timePoint: undefined,
      rowSpinShow: false,
      title: undefined,
      description: undefined,
      rate: 0,
    };
  },
  props: {
    card: {
      type: Object,
      required: true,
    },
  },
  components: {
    NModal,
    NTimePicker,
    NSwitch,
    NSelect,
    NInputNumber,
    NInput,
    NButton,
    NSpin,
    NRate,
    NCard,
  },
  methods: {
    tabClick(index) {
      this.cur = index;
      const that = this;
      if (index == 1) {
        this.rowModal = true;
        this.timePoint = undefined;
        this.title = "";
        this.priority = 0;
        this.subject = 0;
        this.description = "";
        this.hasDuration = false;
        this.durationTimeUnit = 1;
        this.duration = 0;
        getRowMeta().then((response) => {
          that.rowMeta = response.data.data;
          const factorCategories = that.rowMeta.smsFactorCategories;
          that.subjectOptions = [];
          for (let i = 0; i < factorCategories.length; i++) {
            let category = factorCategories[i];
            that.subjectOptions.push({
              label: category.name,
              value: i,
              id: category.id,
            });
          }
          that.subject = 0;
        });
      } else if (index == 2) {
        this.emoModal = true;
      } else if (index == 3) {
        if(this.card.reasonableness) {
          this.rate = this.card.reasonableness;
        }else {
          this.rate = 0;
        }
        this.rateModal = true;
      }
      return false;
    },
    createRow() {
      this.rowSpinShow = true;
      const cardId = this.card.id;
      const timePoint = this.timePoint;
      let duration = null;
      if (this.hasDuration) {
        duration = this.durationTimeUnit * this.duration;
      }
      const title = this.title;
      const priority = this.priority;
      const scheduleFactorCategoryId = this.subjectOptions[this.subject].id;
      const scheduleFactorCategoryName = this.subjectOptions[this.subject].label;
      const description = this.description;
      let durationView = 0;
      if (this.durationTimeUnit == 60) {
        durationView = 1;
      } else if (this.durationTime == 1) {
        durationView = 2;
      }
      const parameter = {
        cardId,
        timePoint,
        duration,
        title,
        priority,
        scheduleFactorCategoryId,
        scheduleFactorCategoryName,
        description,
        durationView,
      };
      const that = this;
      createCardRow(parameter).then((response) => {
        that.card.rows = response.data.data;
        that.rowSpinShow = false;
        that.rowModal = false;
        that.info("添加成功");
      });
    },
    updateRate(value) {
      console.log(value);
    },
    chooseEmo(pnsn) {
      pnsn.isChoose = !pnsn.isChoose;
    }
  },

};
</script>

<style>
.modal-label {
  display: -webkit-flex;
  display: flex;
  -webkit-align-items: center;
  align-items: center;
  -webkit-justify-content: center;
  justify-content: center;
}
.row-modal-wrap {
  max-width: 600px;
  border-radius: 10px;
}
.grid {
  display: grid;
  grid-template-columns: repeat(10, 1fr);
  grid-gap: 10px;
}
.span-col-2 {
  grid-column: span 2 / auto;
}
.span-col-3 {
  grid-column: span 3 / auto;
}
.span-col-5 {
  grid-column: span 5 / auto;
}
.span-col-4 {
  grid-column: span 4 / auto;
}
.span-col-9 {
  grid-column: span 9 / auto;
}
.hide {
  display: inline-block;
  width: 270px;
  height: 10px;
  margin: -1px 0px;
  position: relative;
  top: -40px;
  left: 270px;
  background-color: white;
}
.tabbar-footer {
  --primary: #409eff;
  --background: #fff;
  --inactive: #99a3ba;
  --shadow: rgba(18, 22, 33, 0.24);
  --line: #cdd9ed;
  background: var(--background);
  box-shadow: 0 1px 4px -1px var(--shadow);
  border-radius: 0px 0px 21px 21px;
  width: 270px;
  -webkit-tap-highlight-color: transparent;
  overflow: hidden;
}
.tabbar-footer ul {
  margin: 0;
  padding: 0 12px;
  list-style: none;
  display: grid;
  position: relative;
  overflow: hidden;
  text-align: center;
  grid-template-columns: repeat(3, minmax(0, 1fr));
}
.tabbar-footer ul li {
  position: relative;
}
.tabbar-footer ul li a {
  padding: 20px 0 10px 0;
  display: block;
  text-decoration: none;
  position: relative;
  z-index: 1;
  color: #99a3ba;
}
.tabbar-footer ul li a:hover {
  color: var(--primary);
}
.tabbar-footer ul li a div {
  background: var(--inactive);
  width: 24px;
  height: 24px;
  margin: 0 auto 4px auto;
}
.tabbar-footer ul li a:hover div {
  background: var(--primary);
}
.tabbar-footer ul li a span {
  display: block;
  font-weight: 500;
  font-size: 14px;
}
.tabbar-footer ul li.add a div {
  -webkit-mask-box-image: url("/add.svg");
  -webkit-mask: url("/add.svg");
  mask: url("/add.svg");
}
.tabbar-footer ul li.emo a div {
  -webkit-mask-box-image: url("/emo.svg");
  -webkit-mask: url("/emo.svg");
  mask: url("/emo.svg");
}
.tabbar-footer ul li.sa a div {
  -webkit-mask-box-image: url("/sa.svg");
  -webkit-mask: url("/sa.svg");
  mask: url("/sa.svg");
}
.y-tabs-footer-wrap {
  box-sizing: border-box;
  -webkit-font-smoothing: antialiased;
}

.y-tabs-footer-wrap {
  box-sizing: inherit;
}
.y-tabs-footer-wrap:before,
.y-tabs-footer-wrap:after {
  box-sizing: inherit;
}

.y-tabs-footer-wrap {
  font-family: "Roboto", Arial;
  display: flex;
  justify-content: right;
  align-items: center;
}

.emo-wrap {
  margin: 5px;
}
.emo-wrap:hover {
  cursor: pointer;
}
.emo-title {
  font-size: 13px;
  color:#666;
}
.emo-active {
  font-size: 13px;
  font-weight: 600;
  color:#409eff;
}
</style>
