<template>
  <div class="inline-grid-4" style="width: 100%; text-align:left ">
    <div class="span-col-1 wrap">
      <div class="title">彩虹标签</div>
      <y-rainbow-label :customBackgroundColor="textColor">hello world</y-rainbow-label>
    </div>
    <div class="span-col-1 wrap">
      <div class="title">颜色选择框</div>
      <y-rainbow-color-select-box @change-color="onChangeColor"></y-rainbow-color-select-box>
    </div>
    <div class="span-col-1 wrap">
      <div  class="title">彩虹标签选择框</div>
      <y-rainbow-label-select-box></y-rainbow-label-select-box>
    </div>
    <div class="span-col-1 wrap">
      <div class="title">格式化标签</div>
      <y-format-date-text :timestamp="timestamp"></y-format-date-text>
    </div>
    <div class="span-col-1 wrap">
      <div class="title">日期选择</div>
      <n-date-picker v-model:value="timestamp" type="date" clearable />
    </div>
    <div class="span-col-1 wrap">
      <div class="title">数据表结构填写</div>
      <y-data-sheet-structure></y-data-sheet-structure>
    </div>
    <div class="span-col-1 wrap">
      <div class="title">记录填写卡片</div>
      <y-row-input-card/>
    </div>
    <div class="span-col-1 wrap">
      <div class="title"></div>
      <y-rainbow2-d-label :customBackgroundColor="textColor">
        hello world
      </y-rainbow2-d-label>
    </div>
    <div class="span-col-1 wrap">
      <div class="title"></div>
    </div>
  </div>
</template>

<script>
import YRainbowLabel from "../components/datasheet/YRainbowLabel.vue";
import YRainbowColorSelectBox from "../components/datasheet/YRainbowColorSelectBox.vue";
import YRainbowLabelSelectBox from "../components/datasheet/YRainbowLabelSelectBox.vue";
import YFormatDateText from "../components/datasheet/YFormatDateText.vue";
import YDataSheetStructure from "../components/datasheet/YDataSheetStructure.vue"
import YRowInputCard from "../components/datasheet/YRowInputCard.vue";
import YRainbow2DLabel from "../components/datasheet/YRainbow2DLabel.vue";
import dayjs from "dayjs";
import { NDatePicker } from "naive-ui";
export default {
  data() {
    return {
      timestamp: null,
      textColor: "#fff",
    }
  },
  created() {
    this.timestamp = dayjs().valueOf();
  },
  components: {
    YRainbowLabel,
    YRainbowColorSelectBox,
    YRainbowLabelSelectBox,
    YFormatDateText,
    NDatePicker,
    YDataSheetStructure,
    YRowInputCard,
    YRainbow2DLabel,
  },
  methods: {
    onChangeColor(color) {
      this.textColor = color;
    }
  }
};
</script>

<style>
@import "../components/datasheet/css/grid.css";
.title {
  font-size: 14px;
  margin: 10px 0px;
  color: #666;
}
.wrap {
  padding: 10px;
}
</style>
