<template>
  <div
    id="y-label-tool-wrap"
    class="y-label-tool-grid"
    :style="{ 'background-color': customBackgroundColor }"
  >
    <div id="y-label-tool-main-wrap" class="span-col-3">
      <slot name="main"></slot>
    </div>
    <div id="y-label-tool-tool-wrap">
      <slot name="tool"></slot>
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
#y-label-tool-wrap {
  margin: 5px;
  padding: 5px 10px;
  box-shadow: 0px 0px 3px 1.2px #bdbcbc;
  width: 180px;
  border-radius: 5px;
  min-height: 20px;
}
.y-label-tool-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-gap: 10px;
}
.span-col-3 {
  grid-column: span 3 / auto;
}
</style>