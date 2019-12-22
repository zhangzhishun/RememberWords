/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50642
 Source Host           : localhost:3306
 Source Schema         : remember

 Target Server Type    : MySQL
 Target Server Version : 50642
 File Encoding         : 65001

 Date: 22/12/2019 17:49:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminId` int(11) NOT NULL COMMENT '管理员ID',
  `adminName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员账号',
  `adminPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  PRIMARY KEY (`adminId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for notes
-- ----------------------------
DROP TABLE IF EXISTS `notes`;
CREATE TABLE `notes`  (
  `notesId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `userId` int(11) UNSIGNED NOT NULL COMMENT '用户ID',
  `wordsId` int(11) UNSIGNED NOT NULL COMMENT '单词ID',
  `notesTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '单词记录时间',
  PRIMARY KEY (`notesId`) USING BTREE,
  INDEX `wordsId`(`wordsId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  CONSTRAINT `wordsId` FOREIGN KEY (`wordsId`) REFERENCES `words` (`wordsId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `userPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `userSex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户性别',
  PRIMARY KEY (`userId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for words
-- ----------------------------
DROP TABLE IF EXISTS `words`;
CREATE TABLE `words`  (
  `wordsId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '单词ID',
  `wordsSpell` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单词内容',
  `wordInterpretation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单词释义',
  PRIMARY KEY (`wordsId`) USING BTREE,
  INDEX `wordsId`(`wordsId`) USING BTREE,
  INDEX `wordsConent`(`wordsSpell`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
