<template>
  <div class="y-plan-wrap">
    <div class="grid-3">
      <div
        class="span-col-1 y-plan-item-wrap"
        v-for="datasheetMeta in datasheetMetas"
        :key="datasheetMeta.id"
        @click="intoDatasheet(datasheetMeta)"
      >
        <div class="y-plan-item shadow-v4">
          <div>
            <img class="y-plan-item-img" src="/plan.jpg" />
            <div>
              <div class="y-plan-item-title">{{ datasheetMeta.tableName }}</div>
              <p class="y-plan-item-comment">{{ datasheetMeta.comment }}</p>
            </div>
          </div>
        </div>
      </div>
      <div class="span-col-1 y-plan-item-wrap">
        <div class="y-plan-item shadow-v4" @click="showModal = true">
          <div>
            <img class="y-plan-item-img" src="/more.jpg" />
            <div class="y-plan-item-title">更多模板</div>
            <p class="y-plan-item-comment">点击创建属于您自己的模板吧😊</p>
          </div>
        </div>
      </div>
    </div>
    <n-modal
      v-model:show="showModal"
      preset="card"
      class="y-plan-add-pane default-scrollbar"
    >
      <template #header>
        <div>😀添加一个计划模板吧</div>
      </template>
      <div>
        <y-data-sheet-structure @add-new-dataSheet="addNewDataSheet" />
      </div>
    </n-modal>
  </div>
</template>

<script>
import { NModal } from "naive-ui";
import YDataSheetStructure from "./datasheet/YDataSheetStructure.vue";
import { addDatasheet, queryAllDatasheetMeta } from "../service/TmsService.js";
import { userInfo } from "../service/config";
export default {
  data() {
    return {
      showModal: false,
      datasheetMetas: [],
    };
  },
  components: {
    NModal,
    YDataSheetStructure,
  },
  created() {
    this.queryAllDatasheetMeta();
  },
  methods: {
    addNewDataSheet(structure) {
      structure["userId"] = userInfo().id;
      structure.tableStructureJson = JSON.stringify(structure.tableStructureJson);
      const that = this;
      addDatasheet(structure).then(
        response => {
          const data = response.data;
          if(data.code == 200) {
            that.queryAllDatasheetMeta();
            this.showModal = false;
          } 
        }
      );
    },
    queryAllDatasheetMeta() {
      const userId = userInfo().id;
      const that = this;
      queryAllDatasheetMeta(userId).then((response) => {
        const data = response.data;
        if (data.code == 200) {
          that.datasheetMetas = data.data;
        }
      });
    },
    intoDatasheet(meta) {
      this.$router.replace({ name: 'datasheet' , params: meta});
    }
  },
};
</script>

<style>
@import "./datasheet/css/common.css";
@import "./datasheet/css/grid.css";
@import "./datasheet/css/shadow.css";
@import "./datasheet/css/scrollbar.css";
.y-plan-wrap {
  min-height: 700px;
  padding: 50px 100px;
}
.y-plan-item-wrap {
  text-align: center;
}
.y-plan-item {
  display: inline-block;
  border-style: none;
  border-radius: 10px;
  padding: 1px;
}
.y-plan-item-img {
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
  width: 300px;
  height: 120px;
}
.y-plan-item-title {
  padding: 0px 10px;
  text-align: left;
  font-size: 14px;
  color: #666666;
}
.y-plan-item-comment {
  padding: 0px 10px;
  text-align: left;
  font-size: 13px;
  color: #666666;
}
.y-plan-add-pane {
  width: 400px;
  max-height: 600px;
  overflow: scroll;
}
.y-plan-add-pane-footer {
  text-align: right;
}
</style>
