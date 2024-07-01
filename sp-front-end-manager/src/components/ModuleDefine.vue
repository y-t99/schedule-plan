<template>
  <div class="y-card-default-style">
    <div style="padding: 30px 50px;" class="default-scrollbar">
      <h4>模板定义规则</h4>
      <n-collapse>
        <n-collapse-item title="" v-for="(attribute, index) in attributes" :key="index">
          <template #header>
            <div class="y-button" style="font-size: 16px">名称：{{attribute.attributeName}}</div>
            <div class="y-button" style="font-size: 16px">属性代码：{{attribute.attributeCode}}</div>
            <div class="y-button" style="font-size: 16px">
              备注：{{attribute.comment}}
            </div>
            <div class="y-button" style="font-size: 16px">属性所属：{{attribute.objectText}}</div>
          </template>
          <div>
            <div style="padding-left: 40px" v-for="(dict, index) in attribute.childrens" :key="index">
              <div class="y-button" style="font-size: 16px">名称：{{dict.attributeName}}</div>
              <div class="y-button" style="font-size: 16px">属性代码：{{dict.attributeCode}}</div>
              <div class="y-button" style="font-size: 16px">备注：{{dict.comment}}</div>
            </div>
          </div>
        </n-collapse-item>
      </n-collapse>
    </div>
  </div>
</template>

<script>
import { datasheetMetaQueryAll } from "../service/TmsService.js";
import { NCollapse, NCollapseItem } from "naive-ui";
export default {
  components: {
    NCollapse,
    NCollapseItem,
  },
  data() {
    return {
      attributes:[]
    };
  },
  created() {
    datasheetMetaQueryAll().then((data) => {
      this.attributes = data.data.data;
      console.log(data.data.data);
    });
  },
};
</script>

<style>
@import "../common/style.css";
</style>
