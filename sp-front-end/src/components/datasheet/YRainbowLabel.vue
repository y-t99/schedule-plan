<template>
  <div
    id="rainbow-label-wrap"
    class="rainbow-label-shadow"
    :style="{ 'background-color': customBackgroundColor }"
  >
    <div style="display:inline-block">
      <slot></slot>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    customBackgroundColor: {
      type: String,
      default: "#fff",
    },
  },
};
</script>

<style>
@import "./css/shadow.css";

#rainbow-label-wrap {
  margin: 5px;
  padding: 3px 15px;
  border-radius: 15px;
  font-size: 12px;
  font-weight: 600;
  text-align: center !important;
  vertical-align: middle;
  /*flex 布局*/
  display: inline-flex !important;
  /*实现垂直居中*/
  align-items: center;
  justify-content: center;
}

</style>
