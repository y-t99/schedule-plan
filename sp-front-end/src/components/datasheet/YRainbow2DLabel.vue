<template>
  <div class="y-rainbow-2d-label-rainbow-wrap">
    <div
      class="y-rainbow-2d-label-rainbow"
      :style="{ 'background-color': customBackgroundColor }"
    >
      <div>
        <slot></slot>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    customBackgroundColor: {
      default: "#fff",
    },
  },
};
</script>

<style>
.y-rainbow-2d-label-rainbow-wrap {
  text-align: left;
}
.y-rainbow-2d-label-rainbow {
  display: inline-block;
  margin: 3px 0px;
  padding: 2px 10px;
  border-radius: 5px;
  font-size: 12px;
}
</style>
