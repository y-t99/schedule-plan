<template>
  <div class="y-datasheet-structure-wrap">
    <div class="y-datasheet-structure-meta-tap" v-if="isMetaTap">
      <div>
        <div class="y-datasheet-structure-title-wrap">表名</div>
        <n-input
          v-model:value="structure.tableName"
          type="text"
          placeholder="添加一个表名吧😊"
        />
      </div>
      <div>
        <div class="y-datasheet-structure-title-wrap">备注</div>
        <n-input
          v-model:value="structure.comment"
          type="textarea"
          placeholder="添加一个备注吧😘"
        />
      </div>
      <div>
        <div class="y-datasheet-structure-field-meta-wrap">
          <div class="y-datasheet-structure-title-wrap">字段</div>
          <button class="y-button" @click="isMetaTap = false">添加字段</button>
        </div>
        <n-empty
          show-icon="false"
          description="添加一个字段吧😁"
          v-if="
            structure.tableStructureJson == null || structure.tableStructureJson.length == 0
          "
        />
        <ul>
          <li v-for="field in structure.tableStructureJson" :key="field.name">
            <div class="flext-space-between">
              <div class="y-datasheet-structure-title-wrap">
                {{ field.name }} : {{ field.type }}
              </div>
              <div style="display: inline-block">
                <button class="y-button" @click="deleteEmun(field)">删除</button>
              </div>
            </div>
          </li>
        </ul>
      </div>
      <div style="text-align: center; margin: 10px">
        <div class="y-button" @click="addNewDataSheet">提交</div>
      </div>
    </div>
    <div class="y-datasheet-structure-field-tap" v-else>
      <div>
        <button class="y-button" @click="isMetaTap = true">不添加啦😜</button>
      </div>
      <y-field-pane @add-new-field="onAddNewField"></y-field-pane>
    </div>
  </div>
</template>

<script>
import { NInput, NEmpty } from "naive-ui";
import YFieldPane from "./YFieldPane.vue";
export default {
  data() {
    return {
      isMetaTap: true,
      structure: {
        tableName: null,
        comment: null,
        tableStructureJson: [],
      },
    };
  },
  components: {
    NInput,
    NEmpty,
    YFieldPane,
  },
  methods: {
    onAddNewField(fieldJson) {
      this.isMetaTap = true;
      this.structure.tableStructureJson.push(fieldJson);
    },
    deleteEmun(item) {
      for (let i = 0; i < this.structure.tableStructureJson.length; i++) {
        if (this.structure.tableStructureJson[i] == item) {
          this.structure.tableStructureJson.splice(i, 1);
        }
      }
    },
    addNewDataSheet() {
      this.$emit("addNewDataSheet", this.structure);
      this.structure = {
        tableName: null,
        comment: null,
        tableStructureJson: [],
      };
    },
  },
};
</script>

<style>
@import "./css/common.css";
.y-datasheet-structure-wrap {
  padding: 10px 0px;
}
.y-datasheet-structure-title-wrap {
  font-size: 13px;
  margin: 2px 0px;
  padding: 3px 0px;
  color: #666666;
}
.y-datasheet-structure-field-meta-wrap {
  display: flex;
  justify-content: space-between;
  vertical-align: middle;
}
.y-datasheet-structure-button-wrap {
  display: inline-block;
  background-color: #ffffff;
  color: #666666;
  border-style: none;
  font-size: 12px;
  height: auto;
  padding: 3px 10px;
  margin: auto;
  margin-left: 0px;
  margin-right: 0px;
  outline: 0;
}
.y-datasheet-structure-button-wrap:hover {
  color: #409eff;
  cursor: pointer;
}
.y-datasheet-structure-button-wrap:active {
  color: #666666;
}
</style>
