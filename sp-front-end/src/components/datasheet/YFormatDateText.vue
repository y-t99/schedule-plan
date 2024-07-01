<template>
  <div class="y-format-date-text-wrap">
    {{ dataFormat() }}
  </div>
</template>

<script>
import dayjs from "dayjs";
export default {
  props: {
    format: {
      type: String,
      default: "YYYY/MM/DD"
    },
    timestamp: {
      type: [Number, String],
      require: true,
    },
  },
  methods: {
    dataFormat() {
      return dayjs(this.timestamp).format(this.format);
    }
  },
};
</script>

<style>
.y-format-date-text-wrap {
  margin: 2px;
  padding: 3px;
  display: inline-block;
  font-size: 14px;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}
</style>
