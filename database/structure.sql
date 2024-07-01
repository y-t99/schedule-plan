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

 Date: 25/02/2022 01:38:35
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

SET FOREIGN_KEY_CHECKS = 1;
