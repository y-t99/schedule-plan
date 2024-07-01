<template>
  <div style="display: inline-block">
    <div
      class="rainbow-color-select-box-wrap rainbow-color-select-box-shadow inline-grid-3 grid-gap-0px"
      @click="isSelectWrap = !isSelectWrap"
      @blur="rainbowColorSelectBoxDropOnBlur()"
    >
      <div
        class="span-col-1 selected-color-display shadow-v2"
        :style="{ 'background-color': selectedColorDisplay }"
      ></div>
      <div class="span-col-2 selected-color-value">{{ selectedColorValue }}</div>
    </div>
    <!-- 绝对定位 -->
    <div class="rainbow-color-select-box-drop-down-wrap" v-show="isSelectWrap">
      <div
        class="rainbow-color-select-box-drop-down-select"
        @mouseenter="changeLeftSelect(false)"
        @mouseleave="changeLeftSelect(true)"
      >
        <div class="inline-grid-5 grid-gap-0px">
          <div
            v-for="item in enabledSelectColor"
            :key="item"
            class="rainbow-color-select-box-drop-down-item span-col-1"
            :style="{ 'background-color': item }"
            @click="rainbowColorSelectBoxChangeColor(item)"
          ></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selectedColorDisplay: "#ffffff",
      selectedColorValue: "",
      enabledSelectColor: [
        "#e18c9c",
        "#fde3b6",
        "#a2daf1",
        "#dbd4d3",
        "#e9e5d7",
        "#c2e6b2",
        "#bcead8",
        "#d6d7e9",
        "#DCD6FF",
        "#F9F9FF",
        "#E8EAED",
        "#EDEAFF",
        "#E2F6EF",
        "#BDECDA",
        "#FFF9E3",
        "#FFEAD6",
        "#FBECEB",
        "#FFE8EC",
        "#FFCED8",
        "#D8D9EB",
      ],
      isSelectWrap: false,
      isLeftSelect: true,
    };
  },
  props: {
    defaultColor: {
      default: "",
    },
    temp: {
      type: Object,
    },
  },
  created() {
    if(this.defaultColor !=null && this.defaultColor != "") {
      this.selectedColorDisplay = this.defaultColor;
      this.selectedColorValue = this.defaultColor;
    }
  },
  emits: ["changeColor"],
  methods: {
    rainbowColorSelectBoxdropOnBlur() {
      if (this.isLeftSelect) {
        this.isSelectWrap = false;
      }
    },
    rainbowColorSelectBoxChangeColor(color) {
      this.selectedColorValue = color;
      this.selectedColorDisplay = color;
      this.isSelectWrap = false;
      this.$emit("changeColor", color, this.temp);
    },
    changeLeftSelect(flag) {
      this.isLeftSelect = flag;
    },
  },
};
</script>

<style>
@import "./css/shadow.css";
@import "./css/grid.css";
/* 选择显示div样式 */
.rainbow-color-select-box-wrap {
  margin: 5px;
  width: 150px;
  height: 30px;
  border-radius: 5px;
  cursor: pointer;
}
/* 选择颜色样式 */
.selected-color-display {
  border-top-left-radius: 5px;
  border-bottom-left-radius: 5px;
  max-height: 30px;
}
/* 选择值样式 */
.selected-color-value {
  padding: 5px 0px;
  font-family: Courier, monospace;
  font-weight: 700;
  max-height: 30px;
  text-align: center;
}
/* 选择盒子定位 */
.rainbow-color-select-box-drop-down-wrap {
  position: absolute;
  z-index: 9999;
}
/* 选择盒子样式 */
.rainbow-color-select-box-drop-down-select {
  position: relative;
  left: -25px;
  width: 200px;
  margin-top: 3px;
  margin-bottom: 5px;
  padding: 10px;
  border-radius: 5px;
  box-shadow: 0px 0px 3px 1px #cccccc;
  background-color: #fff;
}
/* 颜色选择单选 */
.rainbow-color-select-box-drop-down-item {
  margin: 5px;
  width: 30px;
  height: 30px;
  border-radius: 15px;
}

.rainbow-color-select-box-drop-down-item:hover {
  box-shadow: var(--shadow-v1);
  cursor: pointer;
}
</style>
