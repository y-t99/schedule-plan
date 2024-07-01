<template>
  <n-space vertical size="large">
    <n-layout>
      <n-layout-header bordered class="y-default-box-shadow">
        <n-space justify="space-between">
          <n-space justify="center" class="y-logo-wrap">
            <n-image width="30" src="/logo.svg" />
          </n-space>
          <n-layout>
            <n-avatar size="20">
              <n-icon>
                <calendar-clear-outline />
              </n-icon>
            </n-avatar>
          </n-layout>
          <n-layout style="padding: 10px 20px 0 0">
            <n-button text @click="activate">
              <n-icon size="28">
                <Menu />
              </n-icon>
            </n-button>
            <n-drawer v-model:show="active" :width="502">
              <n-drawer-content closable>
                <template #header>🙆‍♀️yuanyuan</template>
                <div style="text-align: center; margin: 10px 0px">
                  <n-avatar :size="60" src="./irene.jpg" />
                </div>
                <div style="margin-top: 30px">
                  <div class="grid-4">
                    <div class="info-title-wrap span-col-1">邮箱：</div>
                    <div class="info-content-wrap span-col-3" v-if="!changeEmail" @click="changeEmail=true">{{localUserInfo.email}}</div>
                    <div class="change-input span-col-3" v-else ><n-input type="text" size="small" v-model:value="localUserInfo.email" @blur="pushInfo('email')"></n-input></div>
                    <div class="info-title-wrap span-col-1">喜欢说的话：</div>
                    <div class="info-content-wrap span-col-3" v-if="!changeSaying" @click="changeSaying=true">
                     {{localUserInfo.saying}}
                    </div>
                    <div class="change-input span-col-3" v-else ><n-input type="textarea" size="small" v-model:value="localUserInfo.saying" @blur="pushInfo('saying')"></n-input></div>
                    <div class="info-title-wrap span-col-1" >爱好：</div>
                    <div class="info-content-wrap span-col-3" v-if="!changeLikedThing" @click="changeLikedThing=true">{{localUserInfo.likedThing}}</div>
                    <div class="change-input span-col-3" v-else ><n-input type="text" size="small" v-model:value="localUserInfo.likedThing" @blur="pushInfo('likedThing')"></n-input></div>
                    <div class="info-title-wrap span-col-1">喜欢的书籍：</div>
                    <div class="info-content-wrap span-col-3" v-if="!changeLikedBook" @click="changeLikedBook=true">{{localUserInfo.likedBook}}</div>
                    <div class="change-input span-col-3" v-else ><n-input type="text" size="small" v-model:value="localUserInfo.likedBook" @blur="pushInfo('likedBook')"></n-input></div>
                    <div class="info-title-wrap span-col-1">SP生活时长：</div>
                    <div class="info-content-wrap span-col-3">🎉已经在SP47天啦🎉</div>
                  </div>
                </div>

                <template #footer>
                  <n-button>登出</n-button>
                </template>
              </n-drawer-content>
            </n-drawer>
          </n-layout>
        </n-space>
        <n-space justify="center">
          <n-layout>
            <n-menu
              mode="horizontal"
              :options="menuOptions"
              icon-size="30"
              activeIconSize="30"
            />
          </n-layout>
        </n-space>
      </n-layout-header>
      <router-view></router-view>
      <n-layout-footer>
        <Footer />
      </n-layout-footer>
    </n-layout>
  </n-space>
</template>

<script>
import Footer from "../components/Footer.vue";
import {
  NLayout,
  NSpace,
  NLayoutFooter,
  NLayoutHeader,
  NMenu,
  NAvatar,
  NButton,
  NDrawerContent,
  NDrawer,
  NIcon,
  NImage,
  NInput,
} from "naive-ui";
import { h, ref, resolveComponent } from "vue";
import { renderIcon } from "../common/common.js";
import { userInfo } from '../service/config';
import {
  Calendar,
  TabletLandscape,
  FootstepsSharp,
  Menu,
  CalendarClearOutline,
} from "@vicons/ionicons5";
export default {
  components: {
    "n-space": NSpace,
    "n-layout": NLayout,
    "n-layout-header": NLayoutHeader,
    "n-layout-footer": NLayoutFooter,
    "n-menu": NMenu,
    "n-avatar": NAvatar,
    "n-button": NButton,
    "n-drawer": NDrawer,
    "n-drawer-content": NDrawerContent,
    "n-icon": NIcon,
    "calendar-clear-outline": CalendarClearOutline,
    Menu,
    Footer,
    NImage,
    NInput,
  },
  data() {
    return {
      changeEmail: false,
      changeSaying: false,
      changeLikedThing: false,
      changeLikedBook: false,
      localUserInfo: {},
    }
  },
  methods: {
    pushInfo(field) {
      if(field == "email") {
        this.changeEmail = false;
      } else if(field == "saying") {
        this.changeSaying = false;
      } else if(field == "likedThing") {
        this.changeLikedThing = false;
      } else if(field == "likedBook") {
        this.changeLikedBook = false;
      }
    },
  },
  created() {
    console.log(userInfo());
    this.localUserInfo = userInfo();
  },
  setup() {
    // 导航栏相关变量
    const menuOptions = [
      {
        label: () =>
          h(
            resolveComponent("router-link"),
            {
              to: {
                name: "schedule",
              },
            },
            h("span", { class: "y-label-text y-label-text-font" }, "日程")
          ),
        key: "schedule",
        icon: renderIcon(Calendar),
      },
      {
        label: () =>
          h(
            resolveComponent("router-link"),
            {
              to: {
                name: "plan",
              },
            },
            h("span", { class: "y-label-text y-label-text-font" }, "计划")
          ),
        key: "plan",
        icon: renderIcon(TabletLandscape),
      },
      {
        label: () =>
          h(
            resolveComponent("router-link"),
            { 
               to: {
                name: "history",
              },
             },
            h("span", { class: "y-label-text-font" }, "历史")
          ),
        key: "history",
        icon: renderIcon(FootstepsSharp),
      },
    ];
    // 抽屉相关变量
    const active = ref(false);
    const activate = () => {
      active.value = true;
    };
    return {
      active,
      activate,
      menuOptions,
    };
  },
};
</script>

<style>
@import "../common/style.css";
@import "../components/datasheet/css/grid.css";
@import "../components/datasheet/css/common.css";
.n-layout-header {
  padding: 0px 0px 20px;
}
.y-label-text {
  margin-right: 250px;
}
.y-label-text-font {
  font-size: 20px;
}
.n-button-group {
  padding-right: 20px;
}
.y-logo-wrap {
  padding: 10px 0 0 10px;
}
.info-title-wrap {
  font-size: 14px;
  color: #666;
  text-align: right;
  margin: 10px;
}
.info-title-wrap:hover {
  cursor: pointer;
}
.info-content-wrap {
  font-size: 14px;
  color: #666;
  margin: 10px;
  white-space: pre-line;
}

.info-content-wrap:hover {
  cursor: pointer;
  color: #409eff;
}
.change-input {
      display: flex;
    align-items: center;
}
</style>