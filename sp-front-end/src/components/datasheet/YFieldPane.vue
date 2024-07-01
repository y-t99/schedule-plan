<template>
  <div>
    <div>
      <div class="y-field-pane-title-wrap">名称</div>
      <n-input type="text" placeholder="" v-model:value="fieldJson.name" />
    </div>
    <div>
      <div class="y-field-pane-title-wrap">类型</div>
      <n-select size="medium" :options="types" placeholder="" v-model:value="type" />
    </div>
    <div>
      <div class="y-field-pane-title-wrap">字段值显示UI组件</div>
      <n-select
        size="medium"
        v-model:value="readUI"
        :options="readUIs"
        placeholder=""
        :disabled="readUIs.length == 0"
      />
    </div>
    <div>
      <div class="y-field-pane-title-wrap">字段值输入UI组件</div>
      <n-select
        size="medium"
        v-model:value="writeUI"
        :options="writeUIs"
        placeholder=""
        :disabled="writeUIs.length == 0"
      />
    </div>
    <div>
      <div class="y-field-pane-title-wrap">备注</div>
      <n-input type="textarea" placeholder="" v-model:value="fieldJson.comment" />
    </div>
    <div v-if="type == 'Emun'">
      <div class="y-field-pane-meta-wrap">
        <div class="y-field-pane-title-wrap">枚举值（至少一个）</div>
        <button class="y-button" @click="addEmun">添加枚举值</button>
      </div>
      <div class="y-field-pane-emun-value-wrap grid-1">
        <n-empty
          show-icon="false"
          description="至少需要一个字段噢😁"
          v-if="emuns.length == 0"
        />
        <div v-for="item in emuns" :key="item.text" class="span-col-1 emun-wrap">
          <div v-if="item.isReady">
            <div class="flext-space-between">
              <y-rainbow-label
                :customBackgroundColor="item.rainbowColor"
                style="display: inline-block"
                v-if="readUI=='rainbow_label'"
              >
                {{ item.text }}
              </y-rainbow-label>
              <y-rainbow2-d-label
                :customBackgroundColor="item.rainbowColor"
                v-else-if="readUI=='rainbow_2d_label'"
              >
                {{ item.text }}
              </y-rainbow2-d-label>
              <div style="display: inline-block">
                <button class="y-button" @click="item.isReady = false">修改</button>
                <button class="y-button" @click="deleteEmun(item)">删除</button>
              </div>
            </div>
          </div>
          <div v-else>
            <div class="emun-text-wrap">
              <n-input type="text" v-model:value="item.text" placeholder="" />
            </div>
            <y-rainbow-color-select-box
              style="vertical-align: middle"
              :temp="item"
              :defaultColor="item.rainbowColor"
              @change-color="onChangeColor"
            />
            <button class="y-button" @click="emunReady(item)">确定</button>
          </div>
        </div>
      </div>
    </div>
    <div style="text-align: center; margin: 10px">
      <div class="y-button" @click="addNewField">提交</div>
    </div>
  </div>
</template>

<script>
import { NSelect, NInput, NEmpty } from "naive-ui";
import YRainbowColorSelectBox from "./YRainbowColorSelectBox.vue";
import YRainbowLabel from "./YRainbowLabel.vue";
import YRainbow2DLabel from './YRainbow2DLabel.vue';
export default {
  data() {
    return {
      types: [
        {
          label: "字符串",
          value: "String",
        },
        {
          label: "枚举",
          value: "Emun",
        },
        {
          label: "时间",
          value: "Date",
        },
      ],
      writeUIs: [],
      readUIs: [],
      type: "",
      writeUI: null,
      readUI: null,
      emuns: [],
      fieldJson: {
        type: null,
        name: null,
        setUI: null,
        readUI: null,
        comment: null,
        property: {},
      },
    };
  },
  components: {
    NSelect,
    NInput,
    YRainbowColorSelectBox,
    YRainbowLabel,
    NEmpty,
    YRainbow2DLabel,
  },
  watch: {
    type(newType) {
      this.writeUI = null;
      this.readUI = null;
      if (newType == "String") {
        this.writeUIs = [
          {
            label: "文本框",
            value: "text_box",
          },
        ];
        this.readUIs = [
          {
            label: "文本",
            value: "text",
          },
        ];
      } else if (newType == "Emun") {
        this.writeUIs = [
          {
            label: "彩虹标签选择框",
            value: "rainbow_select_box",
          },
        ];
        this.readUIs = [
          {
            label: "彩虹标签",
            value: "rainbow_label",
          },
          {
            label: "彩虹标签2",
            value: "rainbow_2d_label",
          },
        ];
      } else if (newType == "Date") {
        this.writeUIs = [
          {
            label: "时间选择框",
            value: "date_box",
          },
        ];
        this.readUIs = [
          {
            label: "格式化标签",
            value: "format_label",
          },
        ];
      }
    },
  },
  emits: ["addNewField"],
  methods: {
    addNewField() {
      this.fieldJson.type = this.type;
      this.fieldJson.setUI = this.writeUI;
      this.fieldJson.readUI = this.readUI;
      if (this.type == "Emun") {
        this.fieldJson.property["emuns"] = this.emuns;
      }
      this.$emit("addNewField", this.fieldJson);
    },
    addEmun() {
      let rainbowString = {
        text: "",
        rainbowColor: "",
        isReady: false,
      };
      this.emuns.push(rainbowString);
    },
    emunReady(item) {
      if (item.text != "" && item.rainbowColor != "") {
        item.isReady = true;
      }
    },
    onChangeColor(color, item) {
      item.rainbowColor = color;
    },
    deleteEmun(item) {
      for (let i = 0; i < this.emuns.length; i++) {
        if (this.emuns[i] == item) {
          this.emuns.splice(i, 1);
        }
      }
    },
  },
};
</script>

<style>
.y-field-pane-title-wrap {
  font-size: 13px;
  margin: 2px 0px;
  padding: 3px 0px;
  color: #666666;
}
.y-field-pane-meta-wrap {
  display: flex;
  justify-content: space-between;
  align-items: middle;
}
.y-field-pane-emun-value-wrap {
  display: inline-flex;
  padding: 3px 0px;
  justify-content: space-between;
  align-items: center;
}
.emun-text-wrap {
  display: inline-block;
  vertical-align: middle;
  max-width: 140px;
}
.emun-wrap {
  padding: 3px 0px;
}
</style>
