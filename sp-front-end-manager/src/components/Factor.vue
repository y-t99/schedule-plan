<template>
  <n-layout class="y-card-default-style y-max-wh">
    <div class="grid">
      <div class="span-col-2">
        <n-select v-model:value="queryCategory" :options="categoryOptions" placeholder=""/>
      </div>
      <div>
        <n-button size="medium" @click="queryFactorsByCategoryId"
          >查找</n-button
        >
      </div>
      <div class="span-col-8"></div>
      <div>
        <n-button size="medium" @click="factorModalClick"
          >添加新的因素</n-button
        >
      </div>
      <div class="span-col-12 factor-table">
        <n-spin :show="dataLoading">
          <n-data-table
            size="small"
            :columns="columns"
            :row-key="rowKey"
            :data="data"
            :pagination="pagination"
          />
        </n-spin>
      </div>
      <n-modal
        v-model:show="factorModal"
        :mask-closable="false"
        preset="card"
        class="factor-modal-wrap"
      >
        <template #header>
          <div>😁添加一个因素吧</div>
        </template>
        <n-spin :show="creating">
          <div class="grid">
            <div class="span-col-2 factor-modal-label">名称</div>
            <div class="span-col-4">
              <n-input
                v-model:value="newFactor.name"
                type="text"
                placeholder="名称"
              />
            </div>
            <div class="span-col-2 factor-modal-label">所属类别</div>
            <div class="span-col-4">
              <n-select
                v-model:value="newFactor.factorCategoryId"
                :options="categoryOptions"
                placeholder=""
              />
            </div>
            <div class="span-col-2 factor-modal-label">值选择类型</div>
            <div class="span-col-4">
              <n-select
                v-model:value="newFactor.selectType"
                :options="selectTypeOptions"
              />
            </div>
            <div class="span-col-2 factor-modal-label">值获取方式</div>
            <div class="span-col-4">
              <n-select
                v-model:value="newFactor.inputType"
                :options="inputTypeOptions"
              />
            </div>
            <div class="span-col-2 factor-modal-label">可选列表值</div>
            <div class="span-col-10">
              <n-dynamic-tags
                v-model:value="newFactor.inputList"
                :disabled="inputListIsEnable"
              />
            </div>
            <div class="span-col-11"></div>
            <div>
              <n-button size="medium" @click="createFactor">添加</n-button>
            </div>
          </div>
        </n-spin>
      </n-modal>
      <n-modal
        v-model:show="updatingFactorModal"
        :mask-closable="false"
        preset="card"
        class="factor-modal-wrap"
      >
        <template #header>
          <div>😉因素更新</div>
        </template>
        <n-spin :show="updating">
          <div class="grid">
            <div class="span-col-2 factor-modal-label">名称</div>
            <div class="span-col-4">
              <n-input
                v-model:value="oldFactor.name"
                type="text"
                placeholder="名称"
              />
            </div>
            <div class="span-col-2 factor-modal-label">所属类别</div>
            <div class="span-col-4">
              <n-select
                v-model:value="oldFactor.factorCategoryId"
                :options="categoryOptions"
              />
            </div>
            <div class="span-col-2 factor-modal-label">值选择类型</div>
            <div class="span-col-4">
              <n-select
                v-model:value="oldFactor.selectType"
                :options="selectTypeOptions"
              />
            </div>
            <div class="span-col-2 factor-modal-label">值获取方式</div>
            <div class="span-col-4">
              <n-select
                v-model:value="oldFactor.inputType"
                :options="inputTypeOptions"
              />
            </div>
            <div class="span-col-2 factor-modal-label">可选列表值</div>
            <div class="span-col-10">
              <n-dynamic-tags
                v-model:value="oldFactor.inputList"
                :disabled="inputListIsEnable02"
              />
            </div>
            <div class="span-col-11"></div>
            <div>
              <n-button size="medium" @click="updateFacotr">更新</n-button>
            </div>
          </div>
        </n-spin>
      </n-modal>
    </div>
  </n-layout>
</template>

<script>
import { h } from "vue";
import {
  factorCategoryQueryAll,
  factorCreate,
  factorQueryAll,
  factorQueryByCategoryId,
  factorQueryById,
  factorUpdate,
} from "../service/SmsService.js";
import {
  NLayout,
  NDataTable,
  NTag,
  NButton,
  NSelect,
  NModal,
  NInput,
  NDynamicTags,
  NSpin,
  useMessage,
} from "naive-ui";
export default {
  data() {
    return {
      // 列表定义
      columns: [],
      // 列表数据
      data: [],
      // 行数
      pagination: {
        pageSize: 9,
      },
      // 分类查询的分类id值
      queryCategory: undefined,
      // 创建模拟框显示值
      factorModal: false,
      // 类别选择框
      categoryOptions: [],
      // 值选择类型选择框
      selectTypeOptions: [
        {
          label: "单选",
          value: 1,
        },
        {
          label: "多选",
          value: 2,
        },
      ],
      // 值输入类型选择框
      inputTypeOptions: [
        {
          label: "列表选择",
          value: 1,
        },
        {
          label: "手动输入",
          value: 2,
        },
      ],
      // 新因素值
      newFactor: {
        name: "",
        factorCategoryId: undefined,
        selectType: 1,
        inputType: 1,
        inputList: [],
      },
      // 是否正在创建
      creating: false,
      // 数据是否正在加载
      dataLoading: false,
      // 更新模拟框
      updatingFactorModal: false,
      // 是否正在更新
      updating: false,
      // 旧的因素值
      oldFactor: {
        name: "",
        factorCategoryId: undefined,
        selectType: 1,
        inputType: 1,
        inputList: [],
      },
    };
  },
  // 调整可选值列表是否可改。
  computed: {
    inputListIsEnable() {
      if (this.oldFactor.inputType == 2) {
        this.newFactor.inputList = [];
      }
      return this.newFactor.inputType == 1 ? false : true;
    },
    inputListIsEnable02() {
      if (this.oldFactor.inputType == 2) {
        this.oldFactor.inputList = [];
      }
      return this.oldFactor.inputType == 1 ? false : true;
    },
  },
  components: {
    NLayout,
    NDataTable,
    NSelect,
    NButton,
    NModal,
    NInput,
    NDynamicTags,
    NSpin,
  },
  setup() {
    let message = useMessage();
    return {
      info(infoMessage) {
        message.info(infoMessage);
      },
    };
  },
  methods: {
    rowKey(row) {
      return row.id;
    },
    // 点击添加新因素按钮
    factorModalClick() {
      this.factorModal = true;
      this.newFactor = {
        name: "",
        factorCategoryId: undefined,
        selectType: 1,
        inputType: 1,
        inputList: [],
      };
    },
    // 更新类别选择框
    updateCategoryOptions() {
      const that = this;
      factorCategoryQueryAll().then((response) => {
        const data = response.data.data;
        for (let i = 0; i < data.length; i++) {
          that.categoryOptions.push({
            label: data[i].name,
            value: data[i].id,
          });
        }
      });
    },
    // 点击模拟框创建按钮
    createFactor() {
      this.creating = true;
      const factor = { ...this.newFactor };
      let inputListStr = "";
      for (let i = 0; i < factor.inputList.length; i++) {
        inputListStr += factor.inputList[i];
        inputListStr += ",";
      }
      factor.inputList = inputListStr.substring(0, inputListStr.length - 1);
      let isSuccess = "创建成功";
      let that = this;
      factorCreate(factor).then((response) => {
        that.updateFactorData();
      });
      this.creating = false;
      this.factorModal = false;
      this.info(isSuccess);
    },
    // 更新数据表格中的数据
    updateFactorData() {
      this.dataLoading = true;
      this.data = undefined;
      factorQueryAll().then((response) => {
        let factors = response.data.data;
        this.data = factors;
      });
      this.dataLoading = false;
    },
    // 点击查询按钮
    queryFactorsByCategoryId() {
      const that = this;
      factorQueryByCategoryId(this.queryCategory).then((response) => {
        that.data = response.data.data;
        that.info("查询成功");
      });
    },
    // 创建数据列表列格式
    createColums({ updateFactorModel }) {
      return [
        {
          title: "因素名称",
          key: "name",
          align: "center",
        },
        {
          title: "类别名称",
          key: "categoryName",
          align: "center",
          render(row) {
            return h(
              NTag,
              {
                style: {
                  marginRight: "6px",
                },
                type: "info",
              },
              {
                default: () => row.categoryName,
              }
            );
          },
        },
        {
          title: "值选择类型",
          key: "selectType",
          align: "center",
          render(row) {
            let selectType = row.selectType;
            if (selectType == 1) {
              selectType = "单选";
            } else if (selectType == 2) {
              selectType = "多选";
            } else {
              selectType = "未知选择类型";
            }
            return selectType;
          },
        },
        {
          title: "值获取方式",
          align: "center",
          key: "inputType",
          render(row) {
            let inputType = row.inputType;
            if (inputType == 1) {
              inputType = "列表选择";
            } else if (inputType == 2) {
              inputType = "手动输入";
            } else {
              inputType = "未知输入方式";
            }
            return inputType;
          },
        },
        {
          title: "操作",
          key: "actions",
          align: "center",
          render(row) {
            return h(
              NButton,
              {
                size: "small",
                onClick: () => updateFactorModel(row.id),
              },
              { default: () => "修改" }
            );
          },
        },
      ];
    },
    // 点击模拟框更新按钮
    updateFacotr() {
      this.updating = true;
      const that = this;
      const factor = { ...this.oldFactor };
      let inputListStr = "";
      for (let i = 0; i < factor.inputList.length; i++) {
        inputListStr += factor.inputList[i];
        inputListStr += ",";
      }
      factor.inputList = inputListStr.substring(0, inputListStr.length - 1);
      console.log(factor);
      factorUpdate(factor).then(() => {
        that.updating = false;
        that.updatingFactorModal = false;
        that.info("更新完成");
        that.updateFactorData();
      });
    },
  },
  created() {
    const that = this;
    // 创建数据列表列格式
    this.columns = this.createColums({
      // 点击修改因素按钮
      updateFactorModel(id) {
        that.updatingFactorModal = true;
        that.updating = true;
        factorQueryById(id).then((response) => {
          let oldFactorData = response.data.data;
          oldFactorData.inputList = oldFactorData.inputList.split(",");
          that.oldFactor = oldFactorData;
          that.updating = false;
        });
      },
    });

    // 1、获取全部的因素分类信息
    this.updateCategoryOptions();
    // 2、获取数据
    this.updateFactorData();
  },
};
</script>

<style>
@import "../common/style.css";
.grid {
  display: grid;
  grid-template-columns: repeat(12, 1fr);
  grid-gap: 10px;
  padding: 30px;
}
.span-col-2 {
  grid-column: span 2 / auto;
}
.span-col-4 {
  grid-column: span 4 / auto;
}
.span-col-8 {
  grid-column: span 8 / auto;
}
.span-col-10 {
  grid-column: span 10 / auto;
}
.span-col-11 {
  grid-column: span 11 / auto;
}
.span-col-12 {
  grid-column: span 12 / auto;
}
.factor-table {
  margin-top: 20px;
}
.factor-modal-wrap {
  width: 700px;
}
.factor-modal-label {
  display: -webkit-flex;
  display: flex;
  -webkit-align-items: center;
  align-items: center;
  -webkit-justify-content: center;
  justify-content: center;
}
</style>