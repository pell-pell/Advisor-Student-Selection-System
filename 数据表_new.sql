/*
 Navicat Premium Data Transfer

 Source Server         : �������ݿ�
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
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `account` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '�˺�',
  `pwd` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '����',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '�ǳ�',
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
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `secondary_subject_id` int(11) NULL DEFAULT NULL COMMENT '����ѧ��ID',
  `year` int(11) NULL DEFAULT NULL COMMENT '�������',
  `total_quota` int(11) NULL DEFAULT NULL COMMENT '��������',
  `recommend_quota` int(11) NULL DEFAULT NULL COMMENT '������',
  `supplemental_quota` int(11) NULL DEFAULT NULL COMMENT 'ѧ�Ʋ���ָ��',
  `additional_notes` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '��ע',
  `preliminary_exam_subjects` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '���Կ�Ŀ',
  `subject_retest` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ѧ�Ƹ��Կ�Ŀ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '����Ŀ¼��' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admission_catalog
-- ----------------------------
INSERT INTO `admission_catalog` VALUES (1, 1, 2024, 100, 10, 5, '����', '��˹�˿�Ŀһ', '��˹�˿�Ŀ��');

-- ----------------------------
-- Table structure for admissioninfo
-- ----------------------------
DROP TABLE IF EXISTS `admissioninfo`;
CREATE TABLE `admissioninfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `candidate_id` int(11) NULL DEFAULT NULL COMMENT '����ID',
  `mentor_id` int(11) NULL DEFAULT NULL COMMENT '��ʦID',
  `admission_status` int(11) NULL DEFAULT NULL COMMENT '¼ȡ״̬0.δ¼ȡ��1.¼ȡ',
  `mentor_admission_signature` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '��ʦǩ��¼ȡȷ��',
  `final_selection_status` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '����ѡ����״̬',
  `result_time` datetime(0) NULL DEFAULT NULL COMMENT '����ѡ����ȷ��ʱ��',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '����¼ȡ��Ϣ��' ROW_FORMAT = Dynamic;

-- Remaining content adjusted similarly
-- ----------------------------
-- Disable foreign key checks temporarily
-- ----------------------------
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Records of admissioninfo
-- ----------------------------
INSERT INTO `admissioninfo` VALUES (1, 1, 1, 0, '����', '����', '2024-12-11 08:00:00');

-- ----------------------------
-- Table structure for application_preferences
-- ----------------------------
DROP TABLE IF EXISTS `application_preferences`;
CREATE TABLE `application_preferences`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `candidate_id` int(11) NULL DEFAULT NULL COMMENT '����ID',
  `primary_subject_id` int(11) NULL DEFAULT NULL COMMENT '������һ��ѧ��ID',
  `secondary_subject_id` int(11) NULL DEFAULT NULL COMMENT '�����Ķ���ѧ��ID',
  `preferred_mentorone_id` int(11) NULL DEFAULT NULL COMMENT '��һ־Ը��ʦID',
  `preferred_mentortwo_id` int(11) NULL DEFAULT NULL COMMENT '�ڶ�־Ը��ʦID',
  `preferred_mentorthree_id` int(11) NULL DEFAULT NULL COMMENT '����־Ը��ʦID',
  `accept_adjustment` int(11) NULL DEFAULT NULL COMMENT '�Ƿ���ܷ������',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '����־Ը��' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of application_preferences
-- ----------------------------
INSERT INTO `application_preferences` VALUES (1, 1, 1, 1, 1, 1, 1, 0);

-- ----------------------------
-- Table structure for candidate_info
-- ----------------------------
DROP TABLE IF EXISTS `candidate_info`;
CREATE TABLE `candidate_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '����',
  `birth_date` date NULL DEFAULT NULL COMMENT '����',
  `id_card` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '���֤',
  `region` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '��Դ��',
  `undergraduate_major` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '����רҵ',
  `undergraduate_school` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '����ѧԺ',
  `school_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '����ѧԺ����',
  `email` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '����',
  `phone` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '�绰',
  `photo` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ͷ��',
  `pwd` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '����',
  `resume` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '���˼���',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '������Ϣ��' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of candidate_info
-- ----------------------------
INSERT INTO `candidate_info` VALUES (1, '����', '2024-12-05', '111111', '�㶫����', '�����', '���ڴ�ѧ', '985', '3581209648@qq.com', '13800000000', '/mm_20241212191211.jpg', '123456', '�Һ�ţ��');

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ѧԺ����',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'ѧԺ��' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES (1, '��ĦѧԺ');
INSERT INTO `college` VALUES (2, '����ѧԺ');
INSERT INTO `college` VALUES (3, '��ѶѧԺ');

-- ----------------------------
-- Table structure for mentor
-- ----------------------------
DROP TABLE IF EXISTS `mentor`;
CREATE TABLE `mentor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '����',
  `pwd` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '����',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ְ��',
  `email` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '��ʦ����',
  `phone` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '�绰',
  `photo` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '��Ƭ',
  `bio` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '���',
  `eligible_for_admission` int(11) NULL DEFAULT NULL COMMENT '�Ƿ�߱������ʸ�0��1.��',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '��ʦ��' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mentor
-- ----------------------------
INSERT INTO `mentor` VALUES (1, '����1', '123456', 'ѧ����˶ʿ����ʦ', '3581209648@qq.com', '13631722145', '/gzh_20241212163125.jpg', '���ưְ��޵�', 0);

-- ----------------------------
-- Table structure for mentor_choice_confirmation
-- ----------------------------
DROP TABLE IF EXISTS `mentor_choice_confirmation`;
CREATE TABLE `mentor_choice_confirmation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `mentor_id` int(11) NULL DEFAULT NULL COMMENT '��ʦID',
  `candidate_id` int(11) NULL DEFAULT NULL COMMENT '����ID',
  `preference_order` int(11) NULL DEFAULT NULL COMMENT 'ѧ��ѡ���־Ը˳�� (1-3)',
  `confirmed` int(11) NULL DEFAULT NULL COMMENT '�Ƿ�ȷ��ѡ�� (0 = δȷ��, 1 = ȷ��)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '��ʦѡ��ȷ�ϱ�' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pretest_scores
-- ----------------------------
DROP TABLE IF EXISTS `pretest_scores`;
CREATE TABLE `pretest_scores`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `candidate_id` int(11) NULL DEFAULT NULL COMMENT '����ID',
  `shuxue_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '������ѧ�ɼ�',
  `foreign_language_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '��������ɼ�',
  `comprehensive_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '�������γɼ�',
  `retest_major_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '����רҵ�ɼ�',
  `retest_total_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '�����ܳɼ�',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '���Գɼ���' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pretest_scores
-- ----------------------------
INSERT INTO `pretest_scores` VALUES (1, 1, 100.00, 90.00, 80.00, 70.00, 340.00);

-- ----------------------------
-- Table structure for primary_subject
-- ----------------------------
DROP TABLE IF EXISTS `primary_subject`;
CREATE TABLE `primary_subject`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ѧ������',
  `college_id` int(11) NULL DEFAULT NULL COMMENT '����ѧԺID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'һ��ѧ�Ʊ�' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of primary_subject
-- ----------------------------
INSERT INTO `primary_subject` VALUES (1, '����ѧ', 1);
INSERT INTO `primary_subject` VALUES (2, '��ѧ', 1);
INSERT INTO `primary_subject` VALUES (3, '����ѧ', 1);
INSERT INTO `primary_subject` VALUES (4, '����ѧ', 2);

-- ----------------------------
-- Table structure for retest_scores
-- ----------------------------
DROP TABLE IF EXISTS `retest_scores`;
CREATE TABLE `retest_scores`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `candidate_id` int(11) NULL DEFAULT NULL COMMENT '����ID',
  `shuxue_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '������ѧ�ɼ�',
  `foreign_language_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '��������ɼ�',
  `comprehensive_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '�������γɼ�',
  `retest_major_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '����רҵ�ɼ�',
  `retest_total_score` decimal(11, 2) NULL DEFAULT NULL COMMENT '�����ܳɼ�',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '���Գɼ���' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of retest_scores
-- ----------------------------
INSERT INTO `retest_scores` VALUES (1, 1, 100.00, 90.00, 80.00, 80.00, 350.00);

-- ----------------------------
-- Table structure for secondary_subject
-- ----------------------------
DROP TABLE IF EXISTS `secondary_subject`;
CREATE TABLE `secondary_subject`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '����ѧ������',
  `primary_subject_id` int(11) NULL DEFAULT NULL COMMENT 'һ��ѧ��ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '����ѧ�Ʊ�' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of secondary_subject
-- ----------------------------
INSERT INTO `secondary_subject` VALUES (1, '��˹����ѧ', 1);
INSERT INTO `secondary_subject` VALUES (2, '����������ѧ', 4);

SET FOREIGN_KEY_CHECKS = 1;
