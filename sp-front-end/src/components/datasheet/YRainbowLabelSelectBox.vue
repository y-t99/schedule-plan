<template>
  <div style="display: inline-block">
    <div
      class="rainbow-label-select-box-wrap"
      :class="[{ 'rainbow-label-select-box-wrap-active': isSelectWrap }]"
      @click="isSelectWrap = !isSelectWrap"
      @blur="rainbowColorSelectBoxDropOnBlur()"
    >
      <y-rainbow-label
        :customBackgroundColor="selectEmun.rainbowColor"
        style="margin: 0px"
      >
        {{ selectEmun.text }}
      </y-rainbow-label>
    </div>
    <!-- 绝对定位 -->
    <div class="rainbow-label-select-box-drop-down-wrap" v-show="isSelectWrap">
      <div
        class="rainbow-label-select-box-drop-down-select default-scrollbar"
        @mouseenter="changeLeftSelect(false)"
        @mouseleave="changeLeftSelect(true)"
      >
        <ul>
          <li v-for="item in enabledSelectEmuns" :key="item.rainbowColor">
            <y-rainbow-label
              class="rainbow-label-select-box-drop-down-item"
              @click="changeEmun(item)"
              :customBackgroundColor="item.rainbowColor"
            >
              {{ item.text }}
            </y-rainbow-label>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import YRainbowLabel from "./YRainbowLabel.vue";
export default {
  components: {
    YRainbowLabel,
  },
  data() {
    return {
      selectEmun: { rainbowColor: "#fff", text: "请选择分类" },
      isSelectWrap: false,
      isLeftSelect: true,
    };
  },
  props: {
    enabledSelectEmuns: {
      default: [
        {
          rainbowColor: "#e18c9c",
          text: "枚举一",
        },
        {
          rainbowColor: "#fde3b6",
          text: "枚举二",
        },
        {
          rainbowColor: "#a2daf1",
          text: "枚举三",
        },
        {
          rainbowColor: "#dbd4d3",
          text: "枚举四",
        },
        {
          rainbowColor: "yellow",
          text: "枚举五",
        },
      ],
    },
    fieldIndex: {
      default: "",
    },
  },
  emits: ["changeEmun"],
  methods: {
    rainbowColorSelectBoxdropOnBlur() {
      if (this.isLeftSelect) {
        this.isSelectWrap = false;
      }
    },
    changeEmun(emun) {
      this.selectEmun = emun;
      this.isSelectWrap = false;
      this.$emit("changeEmun", emun.text, this.fieldIndex);
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
@import "./css/scrollbar.css";
ul,
ol {
  list-style: none;
  margin: 0px;
  padding: 0px;
}
/* 选择值样式 */
.rainbow-label-select-box-wrap {
  margin: 5px;
  padding: 8px 10px;
  width: 200px;
  height: auto;
  border-radius: 3px;
  cursor: pointer;
  text-align: left;
  border-style: solid;
  border-width: 1px;
  border-color: rgb(224, 224, 230);
}
.rainbow-label-select-box-wrap:hover {
  border-color: #409eff;
}
.rainbow-label-select-box-wrap-active {
  border-color: #409eff;
}
/* 选择盒子定位 */
.rainbow-label-select-box-drop-down-wrap {
  position: absolute;
  z-index: 9999;
}
/* 选择盒子样式 */
.rainbow-label-select-box-drop-down-select {
  position: relative;
  left: 5px;
  width: 200px;
  max-height: 128px;
  margin-top: 3px;
  padding: 10px;
  border-radius: 5px;
  box-shadow: 0px 0px 3px 1px #cccccc;
  background-color: #fff;
  text-align: left;
  overflow: scroll;
}
/* 颜色选择单选 */
.rainbow-label-select-box-drop-down-item {
  display: block;
  margin: 5px;
}

.rainbow-label-select-box-drop-down-item:hover {
  box-shadow: var(--shadow-v1);
  cursor: pointer;
}
</style>
