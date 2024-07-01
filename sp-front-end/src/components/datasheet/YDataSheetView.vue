<template>
  <div class="y-datasheet-view shadow-v5">
    <div>
      <ul class="y-data-sheet-fileds-wrap flex-start">
        <li style="width: 20px"></li>
        <li v-for="item in structure" :key="item.name">
          <div class="y-button">
            {{ item.name }}
          </div>
        </li>
      </ul>
      <ul
        class="y-data-sheet-fileds-wrap flex-start"
        v-for="(row, index) in rows"
        :key="index"
      >
        <li style="width: 20px"></li>
        <li v-for="(item, index) in row" :key="index">
          <div style="font-size: 13px" v-if="structure[index].type == 'String'">
            {{ item }}
          </div>
          <div v-else-if="structure[index].type == 'Date'">
            <y-format-date-text :timestamp="item" />
          </div>
          <div v-else-if="structure[index].type == 'Emun'">
            <y-rainbow-label
              :customBackgroundColor="emunsMap[iescape(structure[index].name)][iescape(item)]"
              v-if="structure[index].readUI=='rainbow_label'"
              >{{ item }}</y-rainbow-label
            >
            <y-rainbow2-d-label
              style="text-align: center;"
              :customBackgroundColor="emunsMap[iescape(structure[index].name)][iescape(item)]"
              v-else-if="structure[index].readUI=='rainbow_2d_label'"
              >{{ item }}
              </y-rainbow2-d-label
            >
          </div>
          <div v-else class="y-button">未知类型</div>
        </li>
      </ul>
      <ul class="y-data-sheet-datas-wrap flex-start">
        <li style="width: 20px">
          <div
            class="y-button"
            style="font-size: 18px; font-weight: 600"
            @click="showModal = true"
          >
            +
          </div>
        </li>
      </ul>
    </div>
    <n-modal
      v-model:show="showModal"
      preset="card"
      class="y-data-sheet-view-row-input-card default-scrollbar"
    >
      <template #header>
        <div>😀添加一条记录吧</div>
      </template>
      <div>
        <y-row-input-card
          :structure="structure"
          :dstId="dstId"
          @add-data-storage="addDataStorage"
        />
      </div>
    </n-modal>
  </div>
</template>

<script lang="js">
import { NModal } from "naive-ui";
import YRowInputCard from "./YRowInputCard.vue";
import YFormatDateText from './YFormatDateText.vue';
import YRainbowLabel from './YRainbowLabel.vue';
import YRainbow2DLabel from './YRainbow2DLabel.vue';
export default {
  data() {
    return {
      structure: [],
      showModal: false,
      emunsMap: {},
      iescape: null,
    };
  },
  watch: {
    structure(newStructure) {
      // escape
      for(let i = 0; i < newStructure.length; i++) {
        const field = newStructure[i];
        if(field.type == "Emun") {
          let emunMap = {};
          let list = field.property.emuns;
          for(let j = 0; j < list.length; j++) {
            let emun = list[j];
            emunMap[escape(emun.text)] = emun.rainbowColor;
          }
          this.emunsMap[escape(field.name)] = emunMap;
        }
      }
    }
  },
  props: {
    tableStructureJson: {
      required: true,
    },
    dstId: {
      required: true,
    },
    rows: {
      required: true,
    },
  },
  created() {
    this.iescape = (value) => {
      return escape(value);
    }
    this.structure = JSON.parse(this.tableStructureJson);
  }, 
  components: {
    NModal,
    YRowInputCard,
    YFormatDateText,
    YRainbowLabel,
    YRainbow2DLabel,
  },
  emits: ["addDataStorage"],
  methods: {
    addDataStorage() {
      this.showModal = false;
      this.$emit("addDataStorage");
    }
  }
};
</script>

<style>
@import "./css/shadow.css";
@import "./css/common.css";
@import "./css/scrollbar.css";
.y-datasheet-view {
  width: 960px;
  height: 500px;
  border-radius: 10px;
  padding: 40px;
}
.y-data-sheet-fileds-wrap li {
  width: 150px;
  margin: 10px;
  text-align: center;
}
.y-data-sheet-fileds-wrap:hover {
  border-radius: 5px;
  box-shadow: var(--shadow-v2);
  cursor: pointer;
}
.y-data-sheet-datas-wrap li {
  width: 150px;
  margin: 10px;
  text-align: center;
}
.y-data-sheet-datas-wrap:hover {
  border-radius: 5px;
  box-shadow: var(--shadow-v2);
}
.y-data-sheet-view-row-input-card {
  width: 285px;
  max-height: 500px;
}
</style>
