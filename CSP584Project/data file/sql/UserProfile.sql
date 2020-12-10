/*
 Navicat Premium Data Transfer

 Source Server         : local_mysql
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : homehub

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 04/12/2020 03:19:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for UserProfile
-- ----------------------------
DROP TABLE IF EXISTS `UserProfile`;
CREATE TABLE `UserProfile` (
  `username` varchar(45) NOT NULL,
  `street` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zipCode` int DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of UserProfile
-- ----------------------------
BEGIN;
INSERT INTO `UserProfile` VALUES ('1', '3681 Oakmound Road', 'Chicago', 'IL', 60618, '3129986739', 'NicolaCastanon@gmail.com');
INSERT INTO `UserProfile` VALUES ('2', '234 East 55th st', 'Chicago', 'IL', 60615, '3127085984', 'SarahRadovic@gmail.com');
INSERT INTO `UserProfile` VALUES ('3', '4471 Tator Patch Road', 'Chicago', 'IL', 60616, '3128659937', 'AlexBuel@gmail.com');
INSERT INTO `UserProfile` VALUES ('4', '10 West 93rd st', 'Chicago', 'IL', 60615, '3128769937', 'EdgarHaroop@gmail.com');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
