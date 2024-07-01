/** 导航模式 */
export enum EnumNavMode {
  'vertical' = '左侧菜单模式',
  'horizontal' = '顶部菜单模式',
  'vertical-mix' = '左侧菜单混合模式',
  'horizontal-mix' = '顶部菜单混合模式'
}

/** 导航风格 */
export enum EnumNavTheme {
  'dark' = '暗色侧边栏',
  'light' = '白色侧边栏',
  'header-dark' = '暗色的侧边栏和顶栏'
}

/** 多页签风格 */
export enum EnumMultiTabMode {
  'button' = '按钮风格',
  'chrome' = '谷歌风格'
}

/** 水平模式的菜单位置 */
export enum EnumHorizontalMenuPosition {
  'flex-start' = '居左',
  'center' = '居中',
  'flex-end' = '居右'
}

/** 动画类型 */
export enum EnumAnimate {
  'zoom-fade' = '渐变',
  'zoom-out' = '闪现',
  'fade-slide' = '滑动',
  'fade' = '消退',
  'fade-bottom' = '底部消退',
  'fade-scale' = '缩放消退'
}