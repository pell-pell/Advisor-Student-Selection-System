/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : selection

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 13/12/2024 14:02:15
*/
USE selection;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '账号',
  `pwd` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123456', 'admin');

-- ----------------------------
-- Table structure for admission_catalog
-- ----------------------------
DROP TABLE IF EXISTS `admission_catalog`;
CREATE TABLE `admission_catalog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `secondary_subject_id` int(11) NULL DEFAULT NULL COMMENT '二级学科ID',
  `year` int(11) NULL DEFAULT NULL COMMENT '招生年度',
  `total_quota` int(11) NULL DEFAULT NULL COMMENT '总招生数',
  `recommend_quota` int(11) NULL DEFAULT NULL COMMENT '推免数',
  `supplemental_quota` int(11) NULL DEFAULT NULL COMMENT '学科补充指标',
  `additional_notes` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `preliminary_exam_subjects` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '初试科目',
  `subject_retest` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学科复试科目',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '招生目录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admission_catalog
-- ----------------------------
INSERT INTO `admission_catalog` VALUES (1, 1, 2024, 100, 10, 5, '测试', '马斯克科目一', '马斯克科目二');

-- ----------------------------
-- Table structure for admissioninfo
-- ----------------------------
DROP TABLE IF EXISTS `admissioninfo`;
CREATE TABLE `admissioninfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `candidate_id` int(11) NULL DEFAULT NULL COMMENT '考生ID',
  `mentor_id` int(11) NULL DEFAULT NULL COMMENT '导师ID',
  `admission_status` int(11) NULL DEFAULT NULL COMMENT '录取状态0.未录取，1.录取',
  `mentor_admission_signature` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '导师签字录取确认',
  `final_selection_status` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最终选择结果状态',
  `result_time` datetime(0) NULL DEFAULT NULL COMMENT '最终选择结果确认时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '考生录取信息表' ROW_FORMAT = Dynamic;

-- Remaining content adjusted similarly
-- ----------------------------
-- Disable foreign key checks temporarily
-- ----------------------------
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Records of admissioninfo
-- ----------------------------
INSERT INTO `admissioninfo` VALUES (1, 1, 1, 0, '问问', '问问', '2024-12-11 08:00:00');

-- ----------------------------
-- Table structure for application_preferences
-- ----------------------------
DROP TABLE IF EXISTS `application_preferences`;
CREATE TABLE `application_preferences`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `candidate_id` int(11) NULL DEFAULT NULL COMMENT '考生ID',
  `primary_subject_id` int(11) NULL DEFAULT NULL COMMENT '报考的一级学科ID',
  `secondary_subject_id` int(11) NULL DEFAULT NULL COMMENT '报考的二级学科ID',
  `preferred_mentorone_id` int(11) NULL DEFAULT NULL COMMENT '第一志愿导师ID',
  `preferred_mentortwo_id` int(11) NULL DEFAULT NULL COMMENT '第二志愿导师ID',
  `preferred_mentorthree_id` int(11) NULL DEFAULT NULL COMMENT '第三志愿导师ID',
  `accept_adjustment` int(11) NULL DEFAULT NULL COMMENT '是否接受方向调整',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '报考志愿表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of application_preferences
-- ----------------------------
INSERT INTO `application_preferences` VALUES (1, 1, 1, 1, 1, 1, 1, 0);

-- ----------------------------
-- Table structure for candidate_info
-- ----------------------------
DROP TABLE IF EXISTS `candidate_info`;
CREATE TABLE `candidate_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `birth_date` date NULL DEFAULT NULL COMMENT '生日',
  `id_card` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `region` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生源地',
  `undergraduate_major` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '本科专业',
  `undergraduate_school` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '本科学院',
  `school_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '本科学院类型',
  `email` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `photo` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `pwd` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `resume` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个人简历',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '考生信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of candidate_info
-- ----------------------------
INSERT INTO `candidate_info` VALUES (1, '马化腾', '2024-12-05', '111111', '广东深圳', '计算机', '深圳大学', '985', '3581209648@qq.com', '13800000000', '/mm_20241212191211.jpg', '123456', '我很牛逼');

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学院名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学院表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES (1, '达摩学院');
INSERT INTO `college` VALUES (2, '阿里学院');
INSERT INTO `college` VALUES (3, '腾讯学院');

-- ----------------------------
-- Table structure for mentor
-- ----------------------------
DROP TABLE IF EXISTS `mentor`;
CREATE TABLE `mentor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `pwd` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职称',
  `email` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '导师邮箱',
  `phone` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `photo` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '照片',
  `bio` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简介',
  `eligible_for_admission` int(11) NULL DEFAULT NULL COMMENT '是否具备招生资格0否，1.是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '导师表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mentor
-- ----------------------------
INSERT INTO `mentor` VALUES (1, '马云1', '123456', '学术型硕士生导师', '3581209648@qq.com', '13631722145', '/gzh_20241212163125.jpg', '马云爸爸无敌', 0);

-- ----------------------------
-- Table structure for mentor_choice_confirmation
-- ----------------------------
DROP TABLE IF EXISTS `mentor_choice_confirmation`;
CREATE TABLE `mentor_choice_confirmation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `mentor_id` int(11) NULL DEFAULT NULL COMMENT '导师ID',
  `candidate_id` int(11) NULL DEFAULT NULL COMMENT '考生ID',
  `preference_order` int(11) NULL DEFAULT NULL COMMENT '学生选择的志愿顺序 (1-3)',
  `confirmed` int(11) NULL DEFAULT NULL COMMENT '是否确认选择 (0 = 未确认, 1 = 确认)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '导师选择确认表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pretest_scores
-- ----------------------------
DROP TABLE IF EXISTS `pretest_scores`;
CREATE TABLE `pretest_scores`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `candidate_id` int(11) NULL DEFAULT NULL COMMENT '考生ID',
  `shuxue_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '初试数学成绩',
  `foreign_language_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '初试外语成绩',
  `comprehensive_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '初试政治成绩',
  `retest_major_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '初试专业成绩',
  `retest_total_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '初试总成绩',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '初试成绩表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pretest_scores
-- ----------------------------
INSERT INTO `pretest_scores` VALUES (1, 1, 100.00, 90.00, 80.00, 70.00, 340.00);

-- ----------------------------
-- Table structure for primary_subject
-- ----------------------------
DROP TABLE IF EXISTS `primary_subject`;
CREATE TABLE `primary_subject`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学科名称',
  `college_id` int(11) NULL DEFAULT NULL COMMENT '所属学院ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '一级学科表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of primary_subject
-- ----------------------------
INSERT INTO `primary_subject` VALUES (1, '经济学', 1);
INSERT INTO `primary_subject` VALUES (2, '文学', 1);
INSERT INTO `primary_subject` VALUES (3, '教育学', 1);
INSERT INTO `primary_subject` VALUES (4, '技术学', 2);

-- ----------------------------
-- Table structure for retest_scores
-- ----------------------------
DROP TABLE IF EXISTS `retest_scores`;
CREATE TABLE `retest_scores`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `candidate_id` int(11) NULL DEFAULT NULL COMMENT '考生ID',
  `shuxue_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '复试数学成绩',
  `foreign_language_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '复试外语成绩',
  `comprehensive_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '复试政治成绩',
  `retest_major_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '复试专业成绩',
  `retest_total_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '复试总成绩',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '复试成绩表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of retest_scores
-- ----------------------------
INSERT INTO `retest_scores` VALUES (1, 1, 100.00, 90.00, 80.00, 80.00, 350.00);

-- ----------------------------
-- Table structure for secondary_subject
-- ----------------------------
DROP TABLE IF EXISTS `secondary_subject`;
CREATE TABLE `secondary_subject`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '二级学科名称',
  `primary_subject_id` int(11) NULL DEFAULT NULL COMMENT '一级学科ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '二级学科表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of secondary_subject
-- ----------------------------
INSERT INTO `secondary_subject` VALUES (1, '马斯克哲学', 1);
INSERT INTO `secondary_subject` VALUES (2, '互联网技术学', 4);

SET FOREIGN_KEY_CHECKS = 1;
