/*
 Navicat MySQL Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50651
 Source Host           : localhost:3306
 Source Schema         : sp

 Target Server Type    : MySQL
 Target Server Version : 50651
 File Encoding         : 65001

 Date: 25/02/2022 01:38:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dms_common_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dms_common_dictionary`;
CREATE TABLE `dms_common_dictionary`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `dict_code` int(11) NOT NULL COMMENT '字典代码',
  `dict_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典名称',
  `data_code` int(11) NOT NULL COMMENT '字典数据代码',
  `data_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典数据名称',
  `data_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典数据数据值',
  `is_fixed` int(11) NOT NULL COMMENT '是否固定',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '通用字典' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dms_common_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for mms_notice
-- ----------------------------
DROP TABLE IF EXISTS `mms_notice`;
CREATE TABLE `mms_notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT ' 标题',
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `time_point` bigint(20) NOT NULL COMMENT ' 时间点',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mms_notice
-- ----------------------------

-- ----------------------------
-- Table structure for mms_question
-- ----------------------------
DROP TABLE IF EXISTS `mms_question`;
CREATE TABLE `mms_question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT ' 标题',
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT ' 内容',
  `time_point` bigint(20) NOT NULL COMMENT '时间点',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `user_avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户头像',
  `user_nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mms_question
-- ----------------------------

-- ----------------------------
-- Table structure for mms_resource_link
-- ----------------------------
DROP TABLE IF EXISTS `mms_resource_link`;
CREATE TABLE `mms_resource_link`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `type` int(11) NOT NULL COMMENT '资源类型 0-资源链接 1-联系我们',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mms_resource_link
-- ----------------------------

-- ----------------------------
-- Table structure for mms_version_log
-- ----------------------------
DROP TABLE IF EXISTS `mms_version_log`;
CREATE TABLE `mms_version_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT ' 标题',
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT ' 内容',
  `version` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT ' 版本号',
  `time_point` bigint(20) NOT NULL COMMENT ' 时间',
  ` type` int(11) NOT NULL DEFAULT 0 COMMENT '版本更新类型 0-日常更新 1-大版本更新 2-bug修复',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mms_version_log
-- ----------------------------

-- ----------------------------
-- Table structure for sms_factor
-- ----------------------------
DROP TABLE IF EXISTS `sms_factor`;
CREATE TABLE `sms_factor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID号',
  `factor_category_id` int(11) NOT NULL COMMENT '因素类别ID号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `select_type` int(11) NULL DEFAULT 1 COMMENT '值选择类型;1-单选，2-多学',
  `input_type` int(11) NULL DEFAULT 1 COMMENT '值获取方式;1-列表，2-手工输入',
  `input_list` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '可选值列表;可选值列表，逗号隔开',
  `sort` int(11) NULL DEFAULT 0 COMMENT '排序',
  `tip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT ' 输入提示',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '因素库' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sms_factor
-- ----------------------------
INSERT INTO `sms_factor` VALUES (1, 1, '起床时间', 1, 1, '6点以前,6-7点,7-8点,8点以后', 0, '起床时间大约在哪个时间区间');
INSERT INTO `sms_factor` VALUES (2, 1, '睡觉时间', 1, 1, '23点以前,23点-23:30,23:30-24:00,24点以后', 0, '睡觉时间大约在哪个时间区间');
INSERT INTO `sms_factor` VALUES (4, 1, '运动时间', 1, 1, '30分钟以内,30分钟-60分钟,60分钟以上', 0, '运动时间大约在哪个时间区间');
INSERT INTO `sms_factor` VALUES (5, 2, '专业自主阅读', 2, 2, '', 0, '阅读书籍等，例：深入java虚拟机');
INSERT INTO `sms_factor` VALUES (6, 2, '专业作业', 2, 2, '', 0, '专业课程名称或作业名称等，例：数据结构、Linux第二次实验报告');
INSERT INTO `sms_factor` VALUES (7, 2, '专业自主研讨、实验、训练', 2, 2, '', 0, '专业课程名称或课题等，例：计算机网络、benchmark测试体系研讨');
INSERT INTO `sms_factor` VALUES (8, 2, '专业上课时间', 1, 2, '', 0, '专业课程名称等，例：操作系统');
INSERT INTO `sms_factor` VALUES (9, 5, '手机刷屏时间', 2, 2, '', 0, 'APP，例：抖音、微博');
INSERT INTO `sms_factor` VALUES (10, 5, '电子游戏时间', 2, 2, '', 0, '游戏名称，例：王者荣耀');
INSERT INTO `sms_factor` VALUES (11, 5, '追影视时间', 2, 2, '', 0, '影视名，例：开端');
INSERT INTO `sms_factor` VALUES (12, 5, '约会聚会时间', 1, 2, '', 0, '聚会类型，例：同学聚会,家庭聚会,情侣约会,商业交谈,其他');
INSERT INTO `sms_factor` VALUES (13, 4, '社团组织工作时间', 1, 2, '', 0, '工作名称等，例：组织捐衣活动');
INSERT INTO `sms_factor` VALUES (14, 4, '社团组织活动', 1, 2, '', 0, '活动名称等，例：夺标寻宝');
INSERT INTO `sms_factor` VALUES (15, 4, '义工志愿者时间', 1, 2, '', 0, '义工类型等，例：交通指挥员');
INSERT INTO `sms_factor` VALUES (16, 4, '校外兼职时间', 1, 2, '', 0, '兼职类型等，例：足球教练、奶茶店服务员');
INSERT INTO `sms_factor` VALUES (17, 4, '校内勤工助学时间', 1, 2, '', 0, '职务名称等，例：图书馆管理员');
INSERT INTO `sms_factor` VALUES (18, 3, '文学著作阅读时间', 1, 2, '', 0, '阅读书籍等，例：伊斯坦布尔假期');
INSERT INTO `sms_factor` VALUES (19, 3, '艺术欣赏时间', 1, 2, '', 0, '作品或艺术活动、地点，例：美术博物馆');
INSERT INTO `sms_factor` VALUES (20, 3, '历史阅读时间', 2, 2, '', 0, ' 阅读书籍等，例：万历十五年');
INSERT INTO `sms_factor` VALUES (21, 1, '吃饭时间', 2, 2, '', 0, '吃什么呀，例：大排档');

-- ----------------------------
-- Table structure for sms_factor_category
-- ----------------------------
DROP TABLE IF EXISTS `sms_factor_category`;
CREATE TABLE `sms_factor_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '因素类名称',
  `count` int(11) NOT NULL DEFAULT 0 COMMENT '元素数量;类别中元素数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '因素分类' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sms_factor_category
-- ----------------------------
INSERT INTO `sms_factor_category` VALUES (1, '生活健康投入', 4);
INSERT INTO `sms_factor_category` VALUES (2, '专业学习投入', 4);
INSERT INTO `sms_factor_category` VALUES (3, '综合素养投入', 3);
INSERT INTO `sms_factor_category` VALUES (4, '实践能力投入', 5);
INSERT INTO `sms_factor_category` VALUES (5, '社交娱乐投入', 4);

-- ----------------------------
-- Table structure for sms_schedule_base_row
-- ----------------------------
DROP TABLE IF EXISTS `sms_schedule_base_row`;
CREATE TABLE `sms_schedule_base_row`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID号',
  `card_id` int(11) NOT NULL COMMENT 'card的ID号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `time_point` bigint(11) NOT NULL COMMENT '时间点',
  `duration` int(11) NULL DEFAULT NULL COMMENT '时长',
  `duration_view` int(11) NULL DEFAULT 0 COMMENT '时长展示格式;0-小时，1-分钟，2-秒，3-时间点 ',
  `relation_id` int(11) NULL DEFAULT NULL COMMENT '关联row的ID号',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `is_delay` int(1) NULL DEFAULT NULL COMMENT '是否拖延 0-未拖延 1-拖延',
  `is_finish` int(1) NOT NULL COMMENT '是否完成',
  `priority` int(11) NOT NULL DEFAULT 0 COMMENT '优先级;0-普通（默认）1-重要紧急 2-紧急不重要 3-重要不紧急 4-不重要不紧急',
  `schedule_factor_category_id` int(11) NULL DEFAULT NULL COMMENT '日程主题ID号',
  `schedule_factor_category_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日程主题title',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '日程记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sms_schedule_base_row
-- ----------------------------
INSERT INTO `sms_schedule_base_row` VALUES (1, 1, '微积分', 1638788430000, 3600, 0, NULL, '😘微积分-函数学习', 0, 0, 3, 2, '专业学习投入');
INSERT INTO `sms_schedule_base_row` VALUES (2, 1, 'JUC', 1638795600000, 3600, 0, NULL, 'JUC框架代码学习', 0, 0, 3, 2, '专业学习投入');
INSERT INTO `sms_schedule_base_row` VALUES (3, 2, '等待', 1638806399000, 1, 2, NULL, '等待第二天到来呀😇', 0, 0, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (4, 21, '🚗测试', 1641657600000, 3600, 0, NULL, '测试', 0, 0, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (6, 21, '🏪测试', 1641661200000, 3600, 0, NULL, '测试', 0, 0, 2, 3, '综合素养投入');
INSERT INTO `sms_schedule_base_row` VALUES (7, 21, '🎶测试', 1641664800000, 3600, 0, NULL, '测试', 1, 1, 1, 2, '专业学习投入');
INSERT INTO `sms_schedule_base_row` VALUES (8, 21, '🐷测试', 1641668400000, 3600, 0, NULL, '测试', 1, 1, 3, 4, '实践能力投入');
INSERT INTO `sms_schedule_base_row` VALUES (9, 21, '🚴‍♀️测试', 1641672000000, 3600, 0, NULL, '测试', 0, 0, 4, 5, '社交娱乐投入');
INSERT INTO `sms_schedule_base_row` VALUES (10, 60, '🌞起床', 1645228800000, NULL, 1, NULL, '🌞起床喽', 1, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (11, 59, '🌞起床', 1645228800000, NULL, 1, NULL, '🌞起床喽', 1, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (12, 61, '🌞起床', 1645228800000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (13, 54, '🌞起床', 1645228800000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (14, 62, '🌞起床', 1645228800000, NULL, 1, NULL, '🌞起床喽', 1, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (15, 63, '🌞起床', 1645228800000, NULL, 1, NULL, '🌞起床喽', 1, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (16, 45, '🌞起床', 1645230600000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (17, 46, '🌞起床', 1645230600000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (18, 47, '🌞起床', 1645230600000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (19, 48, '🌞起床', 1645230600000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (20, 53, '🌞起床', 1645230600000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (21, 58, '🌞起床', 1645230600000, NULL, 1, NULL, '🌞起床喽', 0, 0, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (22, 57, '🌞起床', 1645236300000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (23, 49, '🌞起床', 1645230600000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (24, 64, '🌞起床', 1645230600000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (25, 50, '🌞起床', 1645230600000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (26, 51, '🌞起床', 1645230600000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (27, 52, '🌞起床', 1645230600000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (28, 55, '🌞起床', 1645248600000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (29, 56, '🌞起床', 1645237800000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (30, 65, '🌞起床', 1645228800000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (31, 66, '🌞起床', 1645228800000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (32, 67, '🌞起床', 1645230600000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (33, 68, '🌞起床', 1645230600000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (34, 69, '🌞起床', 1645230600000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (35, 70, '🌞起床', 1645237800000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (36, 71, '🌞起床', 1645237800000, NULL, 1, NULL, '🌞起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (37, 1, '🌞起床', 1645230600000, NULL, 1, NULL, '🌞起床喽', 0, 0, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (38, 72, '🐷起床', 1645317000000, NULL, 1, NULL, '起床喽', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (39, 55, '🍚吃饭', 1645335000000, 3600, 0, NULL, '吃水煮鱼看家有儿女，真香😘', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (40, 55, '😍玩游戏', 1645331400000, 10800, 0, NULL, '英雄联盟，启动！', 0, 1, 0, 5, '社交娱乐投入');
INSERT INTO `sms_schedule_base_row` VALUES (41, 55, '🎯毕设', 1645342200000, 7200, 0, NULL, '🚀完成计划模块', 1, 1, 1, 2, '专业学习投入');
INSERT INTO `sms_schedule_base_row` VALUES (42, 55, '🥣晚餐', 1645349400000, 3600, 0, NULL, '来点🍔配B站短视频', 0, 1, 0, 1, '生活健康投入');
INSERT INTO `sms_schedule_base_row` VALUES (43, 55, '🎯毕设', 1645353000000, 18000, 0, NULL, '🚀完成基础功能', 0, 1, 1, 2, '专业学习投入');
INSERT INTO `sms_schedule_base_row` VALUES (44, 55, '📱刷手机', 1645371000000, 0, 0, NULL, '🤪刷会手机', 0, 1, 0, 5, '社交娱乐投入');

-- ----------------------------
-- Table structure for sms_schedule_card
-- ----------------------------
DROP TABLE IF EXISTS `sms_schedule_card`;
CREATE TABLE `sms_schedule_card`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID号',
  `card_sn` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '计划卡序列号',
  `user_id` int(11) NOT NULL COMMENT '用户ID号',
  `pnsns` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'PNSNS情绪值，允许多选',
  `reasonableness` int(11) NULL DEFAULT NULL COMMENT '合理性;1-不合理 2-较不合理 3-较合理 4-合理 5-非常合理',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_card_index`(`user_id`, `card_sn`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 75 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '日程卡' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sms_schedule_card
-- ----------------------------
INSERT INTO `sms_schedule_card` VALUES (1, '20211206', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (2, '20211205', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (3, '20211213', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (4, '20211207', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (5, '20211214', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (6, '20211208', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (7, '20211215', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (8, '20211216', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (9, '20211217', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (10, '20211218', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (11, '20211211', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (12, '20211212', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (13, '20211219', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (14, '20211220', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (15, '20211202', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (16, '20211204', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (17, '20211203', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (18, '20211230', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (19, '20211210', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (20, '20211209', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (21, '20220109', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (22, '20220106', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (23, '20220105', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (24, '20220104', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (25, '20220107', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (26, '20220103', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (27, '20220102', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (28, '20220108', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (29, '20220110', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (30, '20220111', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (31, '20220112', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (32, '20220113', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (33, '20220120', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (34, '20220119', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (35, '20220118', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (36, '20220117', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (37, '20220116', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (38, '20220115', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (39, '20220114', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (40, '20220121', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (41, '20220122', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (42, '20220101', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (43, '20220126', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (44, '20220127', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (45, '20220207', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (46, '20220208', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (47, '20220209', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (48, '20220210', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (49, '20220214', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (50, '20220216', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (51, '20220217', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (52, '20220218', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (53, '20220211', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (54, '20220204', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (55, '20220219', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (56, '20220220', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (57, '20220213', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (58, '20220212', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (59, '20220202', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (60, '20220201', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (61, '20220203', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (62, '20220205', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (63, '20220206', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (64, '20220215', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (65, '20220221', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (66, '20220222', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (67, '20220223', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (68, '20220224', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (69, '20220225', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (70, '20220226', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (71, '20220227', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (72, '20220228', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (73, '20220124', 1, NULL, NULL);
INSERT INTO `sms_schedule_card` VALUES (74, '20220125', 1, NULL, NULL);

-- ----------------------------
-- Table structure for sms_schedule_row_factor_value
-- ----------------------------
DROP TABLE IF EXISTS `sms_schedule_row_factor_value`;
CREATE TABLE `sms_schedule_row_factor_value`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID号',
  `row_id` int(11) NOT NULL COMMENT '数据记录ID号',
  `factor_id` int(11) NOT NULL COMMENT '因素ID号',
  `factor_values` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '因素元素值列表;元素间用逗号隔开',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '记录与因素关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sms_schedule_row_factor_value
-- ----------------------------
INSERT INTO `sms_schedule_row_factor_value` VALUES (2, 4, 1, '6点以前');
INSERT INTO `sms_schedule_row_factor_value` VALUES (3, 6, 18, '伊斯坦布尔假期');
INSERT INTO `sms_schedule_row_factor_value` VALUES (4, 7, 7, 'benchmark,计算机网络');
INSERT INTO `sms_schedule_row_factor_value` VALUES (5, 10, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (6, 11, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (7, 12, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (8, 14, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (9, 15, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (10, 27, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (11, 26, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (12, 25, 1, '6-7点');
INSERT INTO `sms_schedule_row_factor_value` VALUES (13, 24, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (14, 23, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (15, 28, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (16, 13, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (17, 16, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (18, 17, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (19, 18, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (20, 19, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (21, 20, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (22, 21, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (23, 35, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (24, 36, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (25, 34, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (26, 33, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (27, 32, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (28, 31, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (29, 30, 1, '8点以后');
INSERT INTO `sms_schedule_row_factor_value` VALUES (30, 39, 21, '水煮鱼');
INSERT INTO `sms_schedule_row_factor_value` VALUES (31, 40, 10, '英雄联盟');
INSERT INTO `sms_schedule_row_factor_value` VALUES (32, 41, 6, '毕设');
INSERT INTO `sms_schedule_row_factor_value` VALUES (33, 42, 21, '汉堡,炸鸡,可乐');
INSERT INTO `sms_schedule_row_factor_value` VALUES (34, 43, 6, '毕设');
INSERT INTO `sms_schedule_row_factor_value` VALUES (35, 44, 9, '腾讯视频,小说,韩剧TV,冲浪');

-- ----------------------------
-- Table structure for tms_attribute
-- ----------------------------
DROP TABLE IF EXISTS `tms_attribute`;
CREATE TABLE `tms_attribute`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attribute_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性代码',
  `attribute_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性名称',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '描述',
  `is_null` tinyint(255) NOT NULL DEFAULT 0 COMMENT ' 属性值是否可以为空 0为可为空 1为不能为空',
  `attribut_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性类型，有String、Object、List，Object还有属性，list有成员类。',
  `object_id` int(11) NOT NULL COMMENT '属性属于哪个类，id为0代表为字段类。',
  `object_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类名称，为了防止自联表获取所属类名称。不可用于属性查找类名称。',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tms_attribute
-- ----------------------------
INSERT INTO `tms_attribute` VALUES (1, 'type', '类型', '自定义表字段的数据类型', 1, 'string', 0, 'field');
INSERT INTO `tms_attribute` VALUES (2, 'set_ui', '设值ui', '字段前端设值组件', 1, 'string', 0, 'field');
INSERT INTO `tms_attribute` VALUES (3, 'name', '名称', ' 字段名称', 1, 'string', 0, 'field');
INSERT INTO `tms_attribute` VALUES (4, 'set_ui_style', '设置ui样式', '字段前端设值组件样式定义', 0, 'object', 0, 'field');
INSERT INTO `tms_attribute` VALUES (5, 'comment', '注释', '字段注释', 0, 'string', 0, 'field');
INSERT INTO `tms_attribute` VALUES (6, 'property', '属性', ' 字段属性', 0, 'object', 0, 'field');
INSERT INTO `tms_attribute` VALUES (7, 'read_ui', '读值ui', '字段前端值展示UI', 1, 'string', 0, 'field');
INSERT INTO `tms_attribute` VALUES (8, 'read_ui_style', '读值ui样式', '字段前端值展示组件样式', 0, 'object', 0, 'field');
INSERT INTO `tms_attribute` VALUES (9, 'emuns', '枚举', '字段属性-枚举属性', 0, 'list', 6, 'property');
INSERT INTO `tms_attribute` VALUES (10, 'rainbow_string', '带有彩虹色的字符串', ' 枚举属性成员', 1, 'object', 8, 'emuns');
INSERT INTO `tms_attribute` VALUES (11, 'text', '文本', ' 带有彩虹色的字符串的文本值', 1, 'string', 10, 'rainbow_string');
INSERT INTO `tms_attribute` VALUES (12, 'rainbow_color', '彩虹色', ' 带有彩虹色的字符串的彩虹色', 1, 'string', 10, 'rainbow_string');

-- ----------------------------
-- Table structure for tms_attribute_definition_dict
-- ----------------------------
DROP TABLE IF EXISTS `tms_attribute_definition_dict`;
CREATE TABLE `tms_attribute_definition_dict`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `attribute_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性值代码',
  `attribute_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '属性值名称',
  `attributet_id` int(11) NOT NULL COMMENT '属性id',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '注释',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '可视化表管理-表属性定义相关字典数据' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tms_attribute_definition_dict
-- ----------------------------
INSERT INTO `tms_attribute_definition_dict` VALUES (2, 'string', ' 字符串', 1, '表字段类型-字符串');
INSERT INTO `tms_attribute_definition_dict` VALUES (3, 'date', '日期', 1, '表字段类型-时间');
INSERT INTO `tms_attribute_definition_dict` VALUES (4, 'emun', '枚举', 1, '表字段类型-枚举');
INSERT INTO `tms_attribute_definition_dict` VALUES (5, 'text_box', '文本框', 2, 'ui组件-文本框');
INSERT INTO `tms_attribute_definition_dict` VALUES (6, 'select_box', '选择框', 2, 'ui组件-选择框');
INSERT INTO `tms_attribute_definition_dict` VALUES (7, 'date_box', '时间选择框', 2, 'ui组件-时间选择框');
INSERT INTO `tms_attribute_definition_dict` VALUES (8, 'text', '文本', 7, 'ui组件-文本');
INSERT INTO `tms_attribute_definition_dict` VALUES (9, 'label', '标签', 7, 'ui组件-标签');
INSERT INTO `tms_attribute_definition_dict` VALUES (10, 'rainbow_label', '彩虹标签', 7, ' ui组件-彩虹标签');
INSERT INTO `tms_attribute_definition_dict` VALUES (11, 'format_label', '格式化标签', 7, 'ui组件-格式化标签');
INSERT INTO `tms_attribute_definition_dict` VALUES (12, 'rainbow_select_box', ' 彩虹标签选择框', 2, 'ui组件-彩虹选择框');

-- ----------------------------
-- Table structure for tms_data_storage
-- ----------------------------
DROP TABLE IF EXISTS `tms_data_storage`;
CREATE TABLE `tms_data_storage`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `table_structure_id` int(11) NOT NULL COMMENT '表结构id',
  `row_list` varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '记录数据;列表对象',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '可视化表管理-表数据存储' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tms_data_storage
-- ----------------------------
INSERT INTO `tms_data_storage` VALUES (3, 2, '[\"标题\",1644940800000,\"完成\",\"重要\"]');
INSERT INTO `tms_data_storage` VALUES (4, 2, '[\"标题\",1644940800000,\"完成\",\"重要\"]');
INSERT INTO `tms_data_storage` VALUES (5, 2, '[\"标题\",1644940800000,\"未完成\",\"普通\"]');
INSERT INTO `tms_data_storage` VALUES (6, 2, '[\"标题\",1644940800000,\"未完成\",\"不重要\"]');
INSERT INTO `tms_data_storage` VALUES (7, 2, '[\"标题\",1644940800000,\"完成\",\"重要\"]');
INSERT INTO `tms_data_storage` VALUES (8, 2, '[\"完成计划模块基本功能\",1645113600000,\"未完成\",\"紧急\"]');
INSERT INTO `tms_data_storage` VALUES (9, 2, '[\"计划模块基本功能\",1645113600000,\"完成\",\"重要\"]');
INSERT INTO `tms_data_storage` VALUES (10, 3, '[\"测试\",\"枚举A\"]');
INSERT INTO `tms_data_storage` VALUES (11, 4, '[\"测试A\",\"枚举1\",\"枚举1\"]');
INSERT INTO `tms_data_storage` VALUES (12, 4, '[\"测试B\",\"枚举2\",\"枚举2\"]');

-- ----------------------------
-- Table structure for tms_structure_definition
-- ----------------------------
DROP TABLE IF EXISTS `tms_structure_definition`;
CREATE TABLE `tms_structure_definition`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `user_id` int(11) NOT NULL COMMENT '用户id;自定义表结构所属的用户id',
  `table_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '表名称;表名称',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT ' 表描述',
  `table_structure_json` varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '表结构;json对象，表结构的定义，属性及其属性值在表`attribute`和`attribute_definition_dict`中查看',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '可视化表管理-表结构定义' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tms_structure_definition
-- ----------------------------
INSERT INTO `tms_structure_definition` VALUES (2, 1, 'todo', 'todo 记录表', '[{\"type\":\"String\",\"name\":\"标题\",\"setUI\":\"text_box\",\"readUI\":\"text\",\"comment\":\"todo 记录标题\",\"property\":{}},{\"type\":\"Date\",\"name\":\"日期\",\"setUI\":\"date_box\",\"readUI\":\"format_label\",\"comment\":\"todo 日期\",\"property\":{}},{\"type\":\"Emun\",\"name\":\"完成情况\",\"setUI\":\"rainbow_select_box\",\"readUI\":\"rainbow_label\",\"comment\":\"todo 完成情况\",\"property\":{\"emuns\":[{\"text\":\"完成\",\"rainbowColor\":\"#bcead8\",\"isReady\":true},{\"text\":\"未完成\",\"rainbowColor\":\"#FFCED8\",\"isReady\":true}]}},{\"type\":\"Emun\",\"name\":\"优先级\",\"setUI\":\"rainbow_select_box\",\"readUI\":\"rainbow_label\",\"comment\":\"todo优先级\",\"property\":{\"emuns\":[{\"text\":\"紧急\",\"rainbowColor\":\"#e18c9c\",\"isReady\":true},{\"text\":\"重要\",\"rainbowColor\":\"#DCD6FF\",\"isReady\":true},{\"text\":\"普通\",\"rainbowColor\":\"#E8EAED\",\"isReady\":true},{\"text\":\"不重要\",\"rainbowColor\":\"#F9F9FF\",\"isReady\":true}]}}]');
INSERT INTO `tms_structure_definition` VALUES (4, 1, '彩虹标签2展示', '彩虹标签2展示', '[{\"type\":\"String\",\"name\":\"标题\",\"setUI\":\"text_box\",\"readUI\":\"text\",\"comment\":\"标题呀\",\"property\":{}},{\"type\":\"Emun\",\"name\":\"枚举A\",\"setUI\":\"rainbow_select_box\",\"readUI\":\"rainbow_2d_label\",\"comment\":\"枚举A\",\"property\":{\"emuns\":[{\"text\":\"枚举1\",\"rainbowColor\":\"#a2daf1\",\"isReady\":true},{\"text\":\"枚举2\",\"rainbowColor\":\"#dbd4d3\",\"isReady\":true}]}},{\"type\":\"Emun\",\"name\":\"枚举B\",\"setUI\":\"rainbow_select_box\",\"readUI\":\"rainbow_2d_label\",\"comment\":\"枚举B\",\"property\":{\"emuns\":[{\"text\":\"枚举1\",\"rainbowColor\":\"#fde3b6\",\"isReady\":true},{\"text\":\"枚举2\",\"rainbowColor\":\"#DCD6FF\",\"isReady\":true}]}}]');

-- ----------------------------
-- Table structure for tms_type_ui_relation
-- ----------------------------
DROP TABLE IF EXISTS `tms_type_ui_relation`;
CREATE TABLE `tms_type_ui_relation`  (
  `type_id` int(11) NOT NULL COMMENT ' 类型id',
  `is_input` tinyint(4) NOT NULL COMMENT '1为输入 0为输出',
  `ui_id` int(11) NOT NULL COMMENT 'ui id',
  PRIMARY KEY (`type_id`, `is_input`, `ui_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tms_type_ui_relation
-- ----------------------------
INSERT INTO `tms_type_ui_relation` VALUES (2, 0, 8);
INSERT INTO `tms_type_ui_relation` VALUES (2, 1, 5);
INSERT INTO `tms_type_ui_relation` VALUES (3, 0, 11);
INSERT INTO `tms_type_ui_relation` VALUES (3, 1, 7);
INSERT INTO `tms_type_ui_relation` VALUES (4, 0, 10);
INSERT INTO `tms_type_ui_relation` VALUES (4, 1, 12);

-- ----------------------------
-- Table structure for ums_user
-- ----------------------------
DROP TABLE IF EXISTS `ums_user`;
CREATE TABLE `ums_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID号',
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `is_forbid` int(11) NOT NULL DEFAULT 0 COMMENT '禁止;是否禁止 0 否 1 是',
  `statue` int(11) NOT NULL DEFAULT 0 COMMENT '账号状态 0 申请中 1 使用中 2 注销 3拒绝申请',
  `is_notify` int(11) NOT NULL DEFAULT 0 COMMENT '是否需要提示账号状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ums_user
-- ----------------------------
INSERT INTO `ums_user` VALUES (1, 'yuanyuan', 'yuanyuan', '$2a$10$DKhb73S7NIQHSAFO8c6tw.cnhd7BNftw63d48Q0w3L8GDNwajRF76', NULL, NULL, 0, 0, 0);

-- ----------------------------
-- Table structure for ums_user_info
-- ----------------------------
DROP TABLE IF EXISTS `ums_user_info`;
CREATE TABLE `ums_user_info`  (
  `user_id` int(11) NOT NULL COMMENT ' userid',
  `liked_book` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '喜欢的书籍',
  `liked_thing` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '喜欢的东西',
  `saying` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ums_user_info
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
