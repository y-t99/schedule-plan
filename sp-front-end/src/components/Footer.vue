<template>
  <n-modal v-model:show="questions" class="questions-card" preset="card">
    <template #header>
      <div style="text-align: left; font-size: 14px; color: #666">问题报告</div>
    </template>
    <n-timeline icon-size="40" size="large">
      <n-timeline-item time="2022-02-22 18:00">
        <template #icon>
          <n-avatar size="small" round src="./irene.jpg" />
        </template>
        <template #header> yuanyuan </template>
        <template #default>
          计算模块中，枚举类型值添加时，输入一个字后输入框就失去焦点。
        </template>
      </n-timeline-item>
      <n-timeline-item time="2022-02-23 10:00">
        <template #icon>
          <n-avatar size="small" round src="./sunyizhen.jpg" />
        </template>
        <template #header> yori </template>
        <template #default> 日程模块中，类别和因素无法对应。 </template>
      </n-timeline-item>
      <n-timeline-item time="2022-02-23 12:00">
        <template #icon>
          <n-avatar size="small" round src="./cat.jpg" />
        </template>
        <template #header> taotao </template>
        <template #default> 页面友情链接中，vika.cn无法跳转。 </template>
      </n-timeline-item>
      <n-timeline-item time="2022-02-23 12:00">
        <template #icon>
          <n-avatar size="small" round src="./huli.jpg" />
        </template>
        <template #header> jionjion </template>
        <template #default> 日程模块中，无法进行心情评定。 </template>
      </n-timeline-item>
    </n-timeline>
    <div style="text-align: center; margin-top: 5px">
      <div class="y-button">更多</div>
    </div>
  </n-modal>
  <n-modal v-model:show="versionLog" class="questions-card" preset="card">
    <template #header>
      <div style="text-align: left; font-size: 14px; color: #666">更新日志</div>
    </template>
    <n-timeline>
      <n-timeline-item title="sp 前后台项目搭建成功" time="2022-01-01" />
      <n-timeline-item title="sp 因素库建立成功" time="2022-01-10" />
      <n-timeline-item title="sp 日程模块基础功能完成" time="2022-01-30" />
      <n-timeline-item title="sp 计划模块基础功能完成" time="2022-02-10" />
      <n-timeline-item title="sp v1.0.0 发版" time="2022-02-20" type="info" />
      <n-timeline-item title="修复vika.cn链接无法打开" time="2022-02-21" type="warning" />
      <n-timeline-item time="2022-02-21" type="warning">
        枚举值添加时，输入一个字后输入框就失去焦点。
      </n-timeline-item>
    </n-timeline>
    <div style="text-align: center; margin-top: 5px">
      <div class="y-button">更多</div>
    </div>
  </n-modal>
  <n-modal v-model:show="bugPush" class="questions-card" preset="card">
    <template #header>
      <div style="text-align: left; font-size: 14px; color: #666">问题反馈</div>
    </template>
    <div>
      <div>
        <div class="y-button">标题</div>
        <div style="padding: 5px 10px">
          <n-input size="small" placeholder=""></n-input>
        </div>
      </div>
      <div>
        <div class="y-button">内容</div>
        <div style="padding: 5px 10px">
          <n-input size="small" placeholder="" type="textarea"></n-input>
        </div>
      </div>
      <div>
        <div style="padding: 5px 10px; text-align: right">
          <div class="y-button">提交</div>
        </div>
      </div>
    </div>
  </n-modal>
  <n-space vertical size="large" class="y-footer-space-style">
    <n-space justify="space-around">
      <n-layout class="y-footer-layout-color">
        <n-space vertical class="y-space-layout-text-align">
          <n-text> 资源 </n-text>
          <n-button ghost text> vika.cn </n-button>
        </n-space>
      </n-layout>
      <n-layout class="y-footer-layout-color">
        <n-space vertical class="y-space-layout-text-align">
          <n-text> 帮助 </n-text>
          <n-button ghost text @click="questions = true">常见问题</n-button>
          <n-button ghost text @click="versionLog = true">更新日志</n-button>
          <n-button ghost text @click="bugPush = true">报告BUG</n-button>
        </n-space>
      </n-layout>
      <n-layout class="y-footer-layout-color">
        <n-space vertical class="y-space-layout-text-align">
          <n-text> 联系我们 </n-text>
          <n-text> 邮箱：13060889537@sina.cn </n-text>
          <n-text> 微信：whxxhnzy </n-text>
        </n-space>
      </n-layout>
    </n-space>
    <n-divider />
    <n-layout class="y-footer-layout-color y-footer-version-wrap">
      <n-tag checkable disabled> 版本：v1.0.0 </n-tag>
    </n-layout>
  </n-space>
</template>

<script>
import {
  NLayout,
  NSpace,
  NButton,
  NDivider,
  NText,
  NTag,
  NModal,
  NTimeline,
  NTimelineItem,
  NAvatar,
  NInput,
} from "naive-ui";
export default {
  data() {
    return {
      questions: false,
      versionLog: false,
      bugPush: false,
    };
  },
  components: {
    "n-space": NSpace,
    "n-layout": NLayout,
    "n-button": NButton,
    "n-text": NText,
    "n-divider": NDivider,
    "n-tag": NTag,
    NModal,
    NTimeline,
    NTimelineItem,
    NAvatar,
    NInput,
  },
};
</script>
<style>
.y-footer-layout-color {
  background-color: rgb(250, 250, 252);
}
.y-footer-space-style {
  background-color: rgb(250, 250, 252);
  padding-top: 30px;
  border-top-style: solid;
  border-top-width: 1px;
  border-top-color: rgb(239, 239, 245);
}
.y-space-layout-text-align {
  text-align: left;
}
.questions-card {
  width: 310px;
  border-radius: 15px;
}
</style>
