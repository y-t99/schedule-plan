<template>
  <n-space justify="end" class="y-header-message-wrap">
    <n-button text>
      <n-space justify="space-between">
        <n-avatar
          size="small"
          round
          src="/logo.svg"
          :style="{
            backgroundColor: '#ffffff',
          }"
        />
        <div class="y-name-wrap">yuanyuan</div>
      </n-space>
    </n-button>
  </n-space>
</template>

<script>
import { NSpace, NButton, NAvatar } from "naive-ui";
export default {
  components: {
    NSpace,
    NButton,
    NAvatar,
  },
};
</script>

<style>
.y-header-message-wrap {
  padding: 15px 20px 5px 0;
}
.y-name-wrap {
  line-height: 25px;
  margin-left: -7px;
}
</style>