<template>
  <div class="y-datasheet-wrap grid-5">
    <div class="span-col-1">
      <ul class="y-datasheet-sider">
        <li>
          <div
            class="y-button"
            @click="view = 'table'"
            :class="[{ 'y-datasheet-sider-li-active': view == 'table' }]"
          >
            数据格
          </div>
        </li>
        <li>
          <div
            class="y-button"
            @click="view = 'kanban'"
            :class="[{ 'y-datasheet-sider-li-active': view == 'kanban' }]"
          >
            看板
          </div>
        </li>
      </ul>
    </div>
    <div class="span-col-4 flex-center">
      <div v-if="view == 'table'">
        <y-data-sheet-view
          :tableStructureJson="datasheetMeta.tableStructureJson"
          :dstId="datasheetMeta.id"
          :rows="rows"
          @add-data-storage="addDataStorage"
        />
      </div>
      <div v-else-if="view == 'kanban'">
        <y-kanban-view
          :tableStructureJson="datasheetMeta.tableStructureJson"
          :rows="rows"
        />
      </div>
    </div>
  </div>
</template>

<script>
import YDataSheetView from "./YDataSheetView.vue";
import YKanbanView from "./YKanbanView.vue";
import { queryDataStorage } from "../../service/TmsService.js";
export default {
  data() {
    return {
      view: "table",
      datasheetMeta: {},
      structure: {},
      rows: [],
    };
  },
  components: {
    YDataSheetView,
    YKanbanView,
  },
  methods: {
    addDataStorage() {
      this.queryDataStorage();
    },
    queryDataStorage() {
      let that = this;
      queryDataStorage(that.datasheetMeta.id).then((response) => {
        const data = response.data;
        if (data.code == 200) {
          const rows = [];
          const records = data.data;
          for (let i = 0; i < records.length; i++) {
            rows.push(JSON.parse(records[i].rowList));
          }
          that.rows = rows;
        }
      });
    },
  },
  created() {
    this.datasheetMeta = this.$route.params;
    this.queryDataStorage();
  },
};
</script>

<style>
@import "./css/grid.css";
@import "./css/common.css";
@import "./css/shadow.css";
.y-datasheet-wrap {
  height: 600px;
  padding: 50px 100px;
}
.y-datasheet-sider {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.y-datasheet-sider li div {
  width: 120px;
  height: 40px;
  line-height: 40px;
  border-radius: 5px;
  text-align: center;
  padding: 5px 10px;
  margin: 20px;
}

.y-datasheet-sider li div:hover {
  box-shadow: var(--shadow-v1);
}

.y-datasheet-sider-li-active {
  box-shadow: var(--shadow-v1);
}
</style>
