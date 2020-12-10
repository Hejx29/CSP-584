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

 Date: 04/12/2020 03:18:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ContactInfo
-- ----------------------------
DROP TABLE IF EXISTS `ContactInfo`;
CREATE TABLE `ContactInfo` (
  `contactid` int NOT NULL,
  `customerid` varchar(25) DEFAULT NULL,
  `customername` varchar(45) DEFAULT NULL,
  `customeremail` varchar(45) DEFAULT NULL,
  `customerphone` varchar(45) DEFAULT NULL,
  `customermessage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`contactid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of ContactInfo
-- ----------------------------
BEGIN;
INSERT INTO `ContactInfo` VALUES (31436, '1', 'Nicola Castanon', 'NicolaCastanon@gmail.com', '3129986739', 'interested in cleaning service');
INSERT INTO `ContactInfo` VALUES (31546, '3', 'Alex Buel', 'AlexBuel@gmail.com', '3128659937', 'interested in repair service');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
