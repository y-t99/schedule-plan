<template>
  <div class="y-row-input-card">
    <ul>
      <li v-for="(field, index) in structure" :key="field.name">
        <div>
          <div class="y-button">{{ field.name }}</div>
        </div>
        <div class="y-row-input-ui">
          <n-input
            v-if="field.setUI == 'text_box'"
            type="text"
            v-model:value="row[index]"
            :placeholder="field.comment"
            size="small"
          />
          <y-rainbow-label-select-box
            class="y-row-input-ui-little-padding"
            v-else-if="field.setUI == 'rainbow_select_box'"
            :enabledSelectEmuns="structure[index].property.emuns"
            :fieldIndex="index"
            @change-emun="changeEmun"
          />
          <n-date-picker
            v-else-if="field.setUI == 'date_box'"
            v-model:value="row[index]"
            :placeholder="field.comment"
            size="small"
          />
          <div v-else class="y-button">未知输入UI</div>
        </div>
      </li>
      <li>
        <div style="float: right">
          <div class="y-button" @click="addDataStorage">添加</div>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import { NDatePicker, NInput } from "naive-ui";
import YRainbowLabelSelectBox from "./YRainbowLabelSelectBox.vue";
import { addDataStorage } from "../../service/TmsService.js";
export default {
  components: {
    NDatePicker,
    NInput,
    YRainbowLabelSelectBox,
  },
  data() {
    return {
      row: [],
      watchStructure: [],
    };
  },
  watch: {
    watchStructure(structure) {
      this.row = new Array(structure.length).fill(null);
    },
  },
  props: {
    structure: {
      required: true,
      default: [],
    },
    dstId: {
      required: true,
    },
  },
  created() {
    this.watchStructure = this.structure;
  },
  emits: ["addDataStorage"],
  methods: {
    changeEmun(text, index) {
      this.row[index] = text;
    },
    addDataStorage() {
      let rowList = JSON.stringify(this.row);
      let dataStorageDTO = {
        rowList,
        tableStructureId: this.dstId,
      };
      const that = this;
      addDataStorage(dataStorageDTO).then((response) => {
        const data = response.data;
        if (data.code == 200) {
          that.$emit("addDataStorage");
        }
      });
    },
  },
};
</script>

<style>
@import "./css/common.css";
@import "./css/grid.css";
@import "./css/scrollbar.css";
@import "./css/shadow.css";
.y-row-input-card li {
  margin: 5px 0px;
}
.y-row-input-ui {
  padding: 0px 8px;
}
.y-row-input-ui-little-padding {
  margin-left: -4px;
}
</style>
