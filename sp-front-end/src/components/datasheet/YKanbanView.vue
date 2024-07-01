<template>
  <div class="y-kanban-view shadow-v5 default-scrollbar">
    <div class="y-kanban-view-scrollbar-wrap">
      <div>
        <!-- 类别选择框 -->
        <y-label-with-tool :customBackgroundColor="groupSelectColor">
          <template v-slot:main>
            <div class="y-kanban-selected-wrap">{{ groupByItem.text }}</div>
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
          style="margin: 50px 0px"
        />
        <n-empty
          v-else-if="groupByItem.text != '' && (rows == null || rows.length == 0)"
          description="没有记录呀😭，快去数据格添加吧！"
          style="margin: 50px 0px"
        >
        </n-empty>
        <!-- 数据展示区 -->
        <n-space style="flex-flow: row nowrap; margin: 10px 0px">
          <n-space vertical v-for="(group, category) in groups" :key="category">
            <y-label-with-tool :customBackgroundColor="categorys[category]">
              <template v-slot:main>
                <div class="y-kanban-view-category-wrap">{{ iunescape(category) }}</div>
              </template>
            </y-label-with-tool>
            <y-kan-ban-card v-for="(item, index) in group" :key="index">
              <template v-slot:body>
                <div v-for="(i, j) in item" :key="j" class="y-kanban-view-field-wrap">
                  <div v-if="j != fieldIndex">
                    <div class="y-kanban-view-field-name-wrap">
                      {{ structure[j].name }}
                    </div>
                    <div v-if="structure[j].type == 'String'">
                      <div class="y-kanban-view-string">{{ i }}</div>
                    </div>
                    <div v-if="structure[j].type == 'Date'">
                      <y-format-date-text
                        class="y-kanban-view-date"
                        :timestamp="i"/>
                    </div>
                    <div v-if="structure[j].type == 'Emun'">
                      <y-rainbow-label
                        class="y-kanban-view-emun"
                        :customBackgroundColor="emunsMap[iescape(structure[j].name)][iescape(i)]"
                        v-if="structure[j].readUI == 'rainbow_label'"
                        >{{ i }}</y-rainbow-label>
                      <y-rainbow2-d-label
                        :customBackgroundColor=" emunsMap[iescape(structure[j].name)][iescape(i)]"
                        v-else-if="structure[j].readUI == 'rainbow_2d_label'"
                        >{{ i }}</y-rainbow2-d-label>
                    </div>
                  </div>
                </div>
              </template>
            </y-kan-ban-card>
          </n-space>
        </n-space>
      </div>
    </div>
  </div>
</template>

<script>
import YLabelWithTool from "./YLabelWithTool.vue";
import YKanBanCard from "./YKanBanCard.vue";
import YFormatDateText from "./YFormatDateText.vue";
import YRainbowLabel from "./YRainbowLabel.vue";
import { NEmpty, NSpace } from "naive-ui";
import YRainbow2DLabel from "./YRainbow2DLabel.vue";
export default {
  data() {
    return {
      structure: [],
      groupSelectColor: "#999999",
      groupByItem: { text: "", value: "" },
      groupByItems: [],
      emunStyle: null,
      emunStyles: {},
      isSelectWrap: false,
      isLeftSelect: true,
      emunsMap: {},
      iescape: null,
      iunescape: null,
      categorys: {},
      groups: {},
      fieldIndex: null,
    };
  },
  props: {
    tableStructureJson: {
      required: true,
    },
    rows: {
      required: true,
    },
  },
  watch: {
    // 解析模板结构中的枚举类型的属性
    structure(newStructure) {
      for (let i = 0; i < newStructure.length; i++) {
        const field = newStructure[i];
        if (field.type == "Emun") {
          let emunMap = {};
          let list = field.property.emuns;
          for (let j = 0; j < list.length; j++) {
            let emun = list[j];
            emunMap[escape(emun.text)] = emun.rainbowColor;
          }
          this.emunsMap[escape(field.name)] = emunMap;
        }
      }
    },
  },
  created() {
    this.iescape = (value) => {
      return escape(value);
    };
    this.iunescape = (value) => {
      return unescape(value);
    };
    // 解析模板结构
    this.structure = JSON.parse(this.tableStructureJson);
    // 找出可以作为维度的字段
    for (let i = 0; i < this.structure.length; i++) {
      let field = this.structure[i];
      if (field.type == "Emun") {
        this.groupByItems.push({ text: field.name, value: i });
        this.emunStyles[field.name] = field.property.emuns;
      }
    }
  },
  components: {
    YLabelWithTool,
    NEmpty,
    NSpace,
    YKanBanCard,
    YFormatDateText,
    YRainbowLabel,
    YRainbow2DLabel,
  },
  methods: {
    dropDownButtonOnBlur() {
      if (this.isLeftSelect) {
        this.isSelectWrap = false;
      }
    },
    // 维度切换
    changeGroup(item) {
      this.groupByItem = item;
      this.isSelectWrap = false;
      this.emunStyle = this.emunStyles[item.value];

      let index = item.value;
      this.fieldIndex = index;
      let categorys = this.emunsMap[escape(item.text)];
      this.categorys = categorys;
      let keys = Object.keys(categorys);
      let tempMap = {};
      for (let i = 0; i < keys.length; i++) {
        tempMap[keys[i]] = [];
      }
      for (let i = 0; i < this.rows.length; i++) {
        let row = this.rows[i];
        let whatCategory = escape(row[index]);
        tempMap[whatCategory].push(row);
      }
      this.groups = tempMap;
    },
  },
};
</script>

<style>
@import "./css/shadow.css";
@import "./css/common.css";
@import "./css/scrollbar.css";
.y-kanban-view {
  width: 960px;
  height: 500px;
  border-radius: 10px;
  padding: 20px 40px;
  overflow: scroll;
}
.y-kanban-selected-wrap {
  font-size: 14px;
  text-align: center;
  color: #fff;
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

.y-kanban-view-category-wrap {
  font-size: 14px;
  font-weight: 600;
  color: #555;
  text-align: left;
}

.y-kanban-view-field-name-wrap {
  font-size: 12px;
  color: #666666;
  text-align: left;
}

.y-kanban-view-field-name-wrap:hover {
  color: #409eff;
  cursor: pointer;
}

.y-kanban-view-string {
  font-size: 13px;
}

.y-kanban-view-date {
  padding: 0px;
  margin: 0px;
  font-size: 13px;
}
.y-kanban-view-emun {
  height: 15px;
  margin-left: 0px;
}

.y-kanban-view-field-wrap {
  margin: 10px 0px;
}
</style>
