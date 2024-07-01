<template>
  <div style="width: 1266px">
    <n-layout>
      <n-card class="y-card-default-style">
        <n-space justify="space-between">
          <n-layout>
            <n-space justify="space-between" style="padding: 0px; margin: 0px">
              <n-layout>
                <n-avatar
                  :size="80"
                  src="/logo.svg"
                  round
                  :style="{
                    backgroundColor: '#ffffff',
                  }"
              /></n-layout>
              <n-layout>
                <n-text class="y-card-hi">yuanyuan，今天又是充满希望的一天！</n-text>
                <br />
                <n-text strong depth="3">今日多云转晴，20℃-25℃！</n-text>
              </n-layout>
            </n-space>
          </n-layout>
          <n-layout>
            <table class="y-card-message">
              <tr>
                <td><n-text depth="3">待办</n-text></td>
                <td><n-text depth="3">消息</n-text></td>
              </tr>
              <tr>
                <td>
                  <span class="data-font"> {{ toDoCount }}</span>
                </td>
                <td>
                  <span class="data-font"> {{ messageCount }}</span>
                </td>
              </tr>
            </table>
          </n-layout>
        </n-space>
      </n-card>
    </n-layout>

    <div class="y-flex-column">
      <n-modal v-model:show="logShow" class="log-card" preset="card">
        <n-data-table
          size="small"
          :columns="columns"
          :row-key="rowKey"
          :data="data"
          :pagination="pagination"
        />
      </n-modal>
      <n-modal v-model:show="showAppendLog" class="questions-card" preset="card">
        <template #header>
          <div style="text-align: left; font-size: 14px; color: #666">日志添加</div>
        </template>
        <div>
          <div>
            <div class="y-button">标题</div>
            <div style="padding: 5px 10px">
              <n-input
                size="small"
                placeholder=""
                v-model:value="pushLogData.title"
              ></n-input>
            </div>
          </div>
          <div>
            <div class="y-button">版本</div>
            <div style="padding: 5px 10px">
              <n-input
                size="small"
                placeholder=""
                v-model:value="pushLogData.version"
              ></n-input>
            </div>
          </div>
          <div>
            <div class="y-button">内容</div>
            <div style="padding: 5px 10px">
              <n-input
                size="small"
                placeholder=""
                type="textarea"
                v-model:value="pushLogData.content"
              ></n-input>
            </div>
          </div>
          <div>
            <div class="y-button">版本更新类型</div>
            <div style="padding: 5px 10px">
              <n-select
                size="small"
                placeholder=""
                :options="versionTypes"
                v-model:value="pushLogData.type"
              ></n-select>
            </div>
          </div>
          <div>
            <div style="padding: 5px 10px; text-align: right">
              <div class="y-button" @click="pushLog">提交</div>
            </div>
          </div>
        </div>
      </n-modal>
      <n-card class="notify-card">
        <div style="font-size: 14px; color: #666; margin: 0px 0px 10px">
          更新日志
          <div class="y-button" style="float: right" @click="appendLog">添加</div>
        </div>
        <n-timeline>
          <n-timeline-item title="sp 前后台项目搭建成功" time="2022-01-01" />
          <n-timeline-item title="sp 因素库建立成功" time="2022-01-10" />
          <n-timeline-item title="sp 日程模块基础功能完成" time="2022-01-30" />
          <n-timeline-item title="sp 计划模块基础功能完成" time="2022-02-10" />
          <n-timeline-item title="sp v1.0.0 发版" time="2022-02-20" type="info" />
          <n-timeline-item
            title="修复vika.cn链接无法打开"
            time="2022-02-21"
            type="warning"
          />
          <n-timeline-item time="2022-02-21" type="warning">
            枚举值添加时，输入一个字后输入框就失去焦点。
          </n-timeline-item>
        </n-timeline>
        <div style="text-align: center; margin-top: 5px">
          <div class="y-button" @click="showLogCard">更多</div>
        </div>
      </n-card>
      <div class="y-flex-row">
        <n-card class="notify-card">
          <template #header>
            <div style="text-align: left; font-size: 14px; color: #666">通知</div>
          </template>
          <template #header-extra>
            <div class="y-button" @click="notifyPushButton()">修改</div>
          </template>
          <div style="text-align: left">
            <div style="font-size: 13px">{{ notify.title }}</div>

            <div
              style="
                font-size: 12px;
                margin: 5px 0px;
                padding-left: 5px;
                white-space: pre-line;
              "
            >
              {{ notify.content }}
            </div>
          </div>
        </n-card>
        <n-modal v-model:show="notifyPush" class="questions-card" preset="card">
          <template #header>
            <div style="text-align: left; font-size: 14px; color: #666">问题反馈</div>
          </template>
          <div>
            <div>
              <div class="y-button">标题</div>
              <div style="padding: 5px 10px">
                <n-input
                  size="small"
                  placeholder=""
                  v-model:value="pushNotify.title"
                ></n-input>
              </div>
            </div>
            <div>
              <div class="y-button">内容</div>
              <div style="padding: 5px 10px">
                <n-input
                  placeholder=""
                  type="textarea"
                  v-model:value="pushNotify.content"
                ></n-input>
              </div>
            </div>
            <div>
              <div style="padding: 5px 10px; text-align: right">
                <div class="y-button" @click="pushNoticeButton">提交</div>
              </div>
            </div>
          </div>
        </n-modal>
        <n-card class="notify-card">
          <template #header>
            <div style="text-align: left; font-size: 14px; color: #666">资源</div>
          </template>
          <template #header-extra>
            <div class="y-button">添加</div>
          </template>
          <div style="text-align: left">
            <div
              style="font-size: 12px; margin: 5px 0px; padding-left: 5px"
              class="y-flex-between"
            >
              <div class="y-button">🔗 vika.cn</div>
              <div class="y-button">修改</div>
            </div>
          </div>
        </n-card>

        <n-card class="notify-card">
          <template #header>
            <div style="text-align: left; font-size: 14px; color: #666">联系我们</div>
          </template>
          <template #header-extra>
            <div class="y-button">添加</div>
          </template>
          <div style="text-align: left">
            <div
              style="font-size: 12px; margin: 5px 0px; padding-left: 5px"
              class="y-flex-between"
            >
              <div class="y-button">邮箱：13060889537@sina.cn</div>
              <div class="y-button">修改</div>
            </div>
            <div
              style="font-size: 12px; margin: 5px 0px; padding-left: 5px"
              class="y-flex-between"
            >
              <div class="y-button">微信：whxxhnzy</div>
              <div class="y-button">修改</div>
            </div>
          </div>
        </n-card>
      </div>

      <n-card class="notify-card">
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
      </n-card>
      <n-modal v-model:show="accountShow">
        <n-card style="width: 180px">
          <div class="y-flex-row">
            <div class="y-flex-row-center">
              <div class="y-button">昵称</div>
              <div class="y-button">{{ name }}</div>
            </div>
            <div class="y-flex-row-center">
              <div class="y-button">账号</div>
              <div class="y-button">{{ account }}</div>
            </div>
          </div>
        </n-card>
      </n-modal>
      <div style="display: inline-block; width: 270px; margin-top: 10px">
        <n-space vertical :size="12">
          <n-alert
            :show-icon="false"
            type="info"
            v-for="(item, index) in verifications"
            :key="index"
          >
            {{ item.account }} 申请账号<br />
            <div style="text-align: right">
              <div class="y-button" @click="accountInfoShow(index)">资料查看</div>
              <div class="y-button">同意</div>
              <div class="y-button">拒绝</div>
            </div>
          </n-alert>
          <n-alert :show-icon="false" closable>
            拒绝 {{ disaggreementNotify }} 申请账号 <br />
          </n-alert>
          <n-alert
            :show-icon="false"
            type="success"
            closable
            v-for="name in agreementNotifies"
            :key="name"
          >
            同意 {{ name }} 申请账号<br />
          </n-alert>
        </n-space>
      </div>
    </div>
  </div>
</template>

<script>
import {
  NSpace,
  NLayout,
  NAvatar,
  NCard,
  NText,
  NTimeline,
  NTimelineItem,
  NAlert,
  NModal,
  NInput,
  NDataTable,
  NTag,
  NButton,
  NSelect,
} from "naive-ui";
import {
  notifyList,
  notice,
  pushNotice,
  defaultLogs,
  logs,
  log,
  removeLog,
} from "../service/WorkTableService";
import { h } from "vue";
import dayjs from "dayjs";
export default {
  data() {
    return {
      accountShow: false,
      logShow: false,
      showAppendLog: false,
      toDoCount: 0,
      messageCount: 0,
      agreementNotifies: [],
      disaggreementNotify: "",
      verifications: [],
      name: "",
      account: "",
      notifyPush: false,
      notify: {
        title: "",
        content: "",
      },
      pushNotify: {
        title: "",
        content: "",
      },
      defaultLogData: [],
      columns: [],
      data: [],
      pagination: {
        pageSize: 5,
      },
      versionTypes: [
        { value: 0, label: "日常更新" },
        { value: 1, label: "大版本更新" },
        { value: 2, label: "BUG修复" },
      ],
      pushLogData: {
        title: "",
        content: "",
        version: "",
        type: 0,
      },
    };
  },
  methods: {
    rowKey(row) {
      return row.id;
    },
    showLogCard() {
      const that = this;
      logs().then((data) => {
        const m = data.data.data;
        that.data = m;
        that.logShow = true;
      });
    },
    accountInfoShow(index) {
      this.accountShow = true;
      this.name = this.verifications[index].name;
      this.account = this.verifications[index].account;
    },
    notifyPushButton() {
      this.notifyPush = true;
      this.pushNotify.title = this.notify.title;
      this.pushNotify.content = this.notify.content;
    },
    pushNoticeButton() {
      const that = this;
      pushNotice(this.pushNotify.title, this.pushNotify.content).then((data) => {
        const m = data.data.data;
        that.notify.title = m.title;
        that.notify.content = m.content;
        that.notifyPush = false;
      });
    },
    // 创建数据列表列格式
    createColums() {
      const that = this;
      const deleteLog = (id) => {
        removeLog(id).then((data) => {
          logs().then((data) => {
            const m = data.data.data;
            that.data = m;
          });
        });
      };
      return [
        {
          title: "版本标题",
          key: "title",
          align: "center",
        },
        {
          title: "版本内容",
          key: "content",
          align: "center",
        },
        {
          title: "版本",
          key: "version",
          align: "center",
          render(row) {
            return h(
              NTag,
              {
                style: {
                  marginRight: "6px",
                },
                type: "info",
              },
              {
                default: () => row.version,
              }
            );
          },
        },
        {
          title: "日期",
          key: "timePoint",
          align: "center",
          render(row) {
            return dayjs.unix(row.timePoint).format("YYYY-MM-DD");
          },
        },
        {
          title: "操作",
          key: "actions",
          align: "center",
          render(row) {
            return h(
              NButton,
              {
                size: "small",
                onClick: () => deleteLog(row.id),
              },
              { default: () => "删除" }
            );
          },
        },
      ];
    },
    appendLog() {
      this.showAppendLog = true;
    },
    pushLog() {
      const that = this;
      log(
        that.pushLogData.title,
        that.pushLogData.content,
        that.pushLogData.version,
        that.pushLogData.type
      ).then((data) => {
        that.showAppendLog = false;
      });
    },
  },
  components: {
    NLayout,
    NSpace,
    NAvatar,
    NCard,
    NText,
    NTimeline,
    NTimelineItem,
    NAlert,
    NModal,
    NInput,
    NDataTable,
    NTag,
    NButton,
    NSelect,
  },
  created() {
    const that = this;
    // 创建数据列表列格式
    this.columns = this.createColums();
    notifyList().then((data) => {
      const m = data.data.data;
      that.toDoCount = m.toDoCount;
      that.messageCount = m.messageCount;
      that.agreementNotifies = m.agreementNotifies;
      that.disaggreementNotify = m.disagreementNotify;
      that.verifications = m.verifications;
    });
    notice().then((data) => {
      const m = data.data.data;
      that.notify.title = m.title;
      that.notify.content = m.content;
    });
    defaultLogs().then((data) => {
      const m = data.data.data;
      that.defaultLogData = m;
    });
  },
};
</script>

<style>
@import "../common/style.css";
.y-card-hi {
  font-size: 24px;
  font-weight: 600;
}
.y-card-message td {
  width: 80px;
  height: 40px;
  text-align: center;
}
.y-card-message .data-font {
  font-weight: 500;
  font-size: 25px;
}
.notify-card {
  vertical-align: top;
  display: inline-block;
  max-width: 310px;
  margin: 10px 20px 0px 0px;
  border-radius: 15px;
}
.questions-card {
  width: 450px;
  border-radius: 15px;
}
.log-card {
  width: 700px;
  border-radius: 15px;
}
.append-log-card {
  width: 500px;
  border-radius: 15px;
}
</style>
