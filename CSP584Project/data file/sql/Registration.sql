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

 Date: 04/12/2020 03:19:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Registration
-- ----------------------------
DROP TABLE IF EXISTS `Registration`;
CREATE TABLE `Registration` (
  `username` varchar(30) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `repassword` varchar(45) DEFAULT NULL,
  `usertype` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Registration
-- ----------------------------
BEGIN;
INSERT INTO `Registration` VALUES ('1', '1', '1', 'customer');
INSERT INTO `Registration` VALUES ('2', '2', '2', 'customer');
INSERT INTO `Registration` VALUES ('3', '3', '3', 'customer');
INSERT INTO `Registration` VALUES ('4', '4', '4', 'customer');
INSERT INTO `Registration` VALUES ('5', '5', '5', 'customer');
INSERT INTO `Registration` VALUES ('6', '6', '6', 'customer');
INSERT INTO `Registration` VALUES ('7', '7', '7', 'customer');
INSERT INTO `Registration` VALUES ('sm1', '123', '123', 'retailer');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
