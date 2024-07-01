<template>
  <div id="y-kanban-card-wrap" class="y-kanban-card-grid">
    <div id="y-kanban-card-header-wrap" class="span-col-2">
      <slot name="header"></slot>
    </div>
    <div id="y-kanban-card-tool-wrap">
      <slot name="tool"></slot>
    </div>
    <div id="y-kanban-card-body-wrap" class="span-col-3">
      <slot name="body"></slot>
    </div>
    <div id="y-kanban-card-footer-wrap" class="span-col-3">
      <slot name="footer"></slot>
    </div>
  </div>
</template>

<script>
export default {
};
</script>

<style>
#y-kanban-card-wrap {
  margin: 5px;
  padding: 5px 10px;
  box-shadow: 0px 0px 3px 1px #cccccc;
  width: 180px;
  border-radius: 10px;
  text-align: left;
}
#y-kanban-card-header-wrap {
  min-height: 20px;
}
#y-kanban-card-tool-wrap {
  min-height: 20px;
}
#y-kanban-card-body-wrap {
  min-height: 40px;
}
#y-kanban-card-footer-wrap {
  min-height: 20px;
}
.y-kanban-card-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 10px;
}
.span-col-2 {
  grid-column: span 2 / auto;
}

.span-col-3 {
  grid-column: span 3 / auto;
}
</style>