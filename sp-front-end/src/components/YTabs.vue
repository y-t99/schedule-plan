<template>
  <div class="y-tabs-wrap">
    <nav class="tabbar">
      <ul>
        <li class="table" :class="cur == 1 ? 'active' : ''">
          <a href="javascript:void(0);" @click="tabClick(1)">
            <div></div>
            <span>数据格</span></a
          >
        </li>
        <li class="board" :class="cur == 2 ? 'active' : ''">
          <a href="javascript:void(0);" @click="tabClick(2)">
            <div></div>
            <span>看板</span></a
          >
        </li>
        <li class="Gantt" :class="cur == 3 ? 'active' : ''">
          <a href="javascript:void(0);" @click="toExpectation">
            <div></div>
            <span>甘特图</span></a
          >
        </li>
      </ul>
    </nav>
  </div>
</template>

<script>
import { useMessage } from 'naive-ui'
export default {
  data() {
    return {
      cur: 1,
    };
  },
  emits:['tabClick'],
  setup () {
    const message = useMessage();
    return {
      toExpectation () {
        message.info("功能还没有噢！请期待呀😊");
      }
    }
  },
  methods: {
    tabClick(index) {
      this.cur = index;
      this.$emit('tabClick', this.cur);
    },
  },
};
</script>

<style>
.tabbar {
  --primary: #409EFF;
  --background: #fff;
  --inactive: #99a3ba;
  --shadow: rgba(18, 22, 33, 0.24);
  --line: #cdd9ed;
  background: var(--background);
  box-shadow: 0 -1px 4px -1px var(--shadow);
  border-radius: 21px 21px 0px 0px;
  width: 270px;
  -webkit-tap-highlight-color: transparent;
  overflow: hidden;
}
.tabbar::after {
  display: block;
  content: "";
  height: 10px;
  width: 270px;
  position: absolute;
  top: 135;
  left: 30;
  background-color: #fff;
}
.tabbar ul {
  margin: 0;
  padding: 0 12px;
  list-style: none;
  display: grid;
  position: relative;
  overflow: hidden;
  text-align: center;
  grid-template-columns: repeat(3, minmax(0, 1fr));
}
.tabbar ul li {
  position: relative;
}
.tabbar ul li:before,
.tabbar ul li:after {
  content: "";
  background: var(--background);
  height: 44px;
  width: 84px;
  position: absolute;
  top: 0;
  left: 50%;
  margin-left: -42px;
}
.tabbar ul li:before {
  border-radius: 0 48% 0 0;
}
.tabbar ul li:after {
  border-radius: 48% 0 0 0;
}
.tabbar ul li a {
  padding: 20px 0 10px 0;
  display: block;
  text-decoration: none;
  position: relative;
  z-index: 1;
  color: var(--primary);
  transition: transform 0.2s ease;
}
.tabbar ul li a:active {
  transform: scale(0.9);
}
.tabbar ul li a:before,
.tabbar ul li a:after {
  content: "";
  top: 0;
  left: 50%;
  position: absolute;
  background: var(--primary);
  border-radius: 1px;
  width: 2px;
  margin-left: -1px;
  transform-origin: 50% 0;
  transform: translateY(-14px) scaleX(0.6);
}
.tabbar ul li a:before {
  height: 8px;
}
.tabbar ul li a:after {
  height: 4px;
}
.tabbar ul li a div {
  background: var(--inactive);
  width: 24px;
  height: 24px;
  margin: 0 auto 4px auto;
}
.tabbar ul li a div:before {
  --y: -100%;
  content: "";
  display: block;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  transform: translateY(var(--y));
  position: absolute;
  transition: transform 0.4s linear;
  background: var(--primary);
}
.tabbar ul li a span {
  display: block;
  font-weight: 500;
  font-size: 14px;
  opacity: 0;
  transition: opacity 0.36s linear;
}
.tabbar ul li.active:before {
  -webkit-animation: before 1.1s ease;
  animation: before 1.1s ease;
}
.tabbar ul li.active:after {
  -webkit-animation: after 1.1s ease;
  animation: after 1.1s ease;
}
.tabbar ul li.active a {
  -webkit-animation: bounce 0.9s linear 0.3s;
  animation: bounce 0.9s linear 0.3s;
}
.tabbar ul li.active a:before {
  -webkit-animation: drop 0.4s linear 0.1s forwards;
  animation: drop 0.4s linear 0.1s forwards;
}
.tabbar ul li.active a:after {
  -webkit-animation: drop 0.5s linear 0.13s forwards;
  animation: drop 0.5s linear 0.13s forwards;
}
.tabbar ul li.active a div:before {
  --y: 0;
  transition-delay: 0.3s;
}
.tabbar ul li.active a span {
  opacity: 1;
  transition-delay: 0.38s;
}
.tabbar ul li.table a div {
  -webkit-mask-box-image: url("/table.svg");
  -webkit-mask: url("/table.svg");
  mask: url("/table.svg");
}
.tabbar ul li.board a div {
  -webkit-mask-box-image: url("/kanban.svg");
  -webkit-mask: url("/kanban.svg");
  mask: url("/kanban.svg");
}
.tabbar ul li.Gantt a div {
  -webkit-mask-box-image: url("/gante.svg");
  -webkit-mask: url("/gante.svg");
  mask: url("/gante.svg");
}

@-webkit-keyframes bounce {
  40% {
    transform: translateY(9px);
  }
  55% {
    transform: translateY(-1px);
  }
  70% {
    transform: translateY(4px);
  }
}

@keyframes bounce {
  40% {
    transform: translateY(9px);
  }
  55% {
    transform: translateY(-1px);
  }
  70% {
    transform: translateY(4px);
  }
}
@-webkit-keyframes drop {
  50% {
    transform: translateY(10px) scaleY(1.2) scaleX(0.5);
  }
  100% {
    transform: translateY(20px) scaleY(0) scaleX(0.5);
  }
}
@keyframes drop {
  50% {
    transform: translateY(10px) scaleY(1.2) scaleX(0.5);
  }
  100% {
    transform: translateY(20px) scaleY(0) scaleX(0.5);
  }
}
@-webkit-keyframes before {
  45%,
  55% {
    transform: translateX(-41px);
  }
}
@keyframes before {
  45%,
  55% {
    transform: translateX(-41px);
  }
}
@-webkit-keyframes after {
  45%,
  55% {
    transform: translateX(41px);
  }
}
@keyframes after {
  45%,
  55% {
    transform: translateX(41px);
  }
}
.y-tabs-wrap {
  box-sizing: border-box;
  -webkit-font-smoothing: antialiased;
}

.y-tabs-wrap {
  box-sizing: inherit;
}
.y-tabs-wrap:before,
.y-tabs-wrap:after {
  box-sizing: inherit;
}

.y-tabs-wrap {
  font-family: "Roboto", Arial;
  display: flex;
  justify-content: left;
  align-items: center;
}
</style>