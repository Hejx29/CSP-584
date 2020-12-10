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

 Date: 04/12/2020 03:19:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ToolOrders
-- ----------------------------
DROP TABLE IF EXISTS `ToolOrders`;
CREATE TABLE `ToolOrders` (
  `orderId` int unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `productId` int DEFAULT NULL,
  `productName` varchar(255) DEFAULT NULL,
  `fullName` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `creditNo` varchar(40) DEFAULT NULL,
  `buyId` int DEFAULT NULL,
  `deliveryMethod` varchar(255) DEFAULT NULL,
  `pickupLocation` varchar(1024) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of ToolOrders
-- ----------------------------
BEGIN;
INSERT INTO `ToolOrders` VALUES (14, '1', 1, 'hammer', 'Nicola Castanon', '3123580867', 'NicolaCastanon@gmail.com', '60615', '234 East 55th st', 'Chicago', 'IL', '10.99', '5500 4000 0000 4907', 213234, 'pickup', '500 Bayonne Crossing Way', 1, '2020-12-03 21:32:34');
INSERT INTO `ToolOrders` VALUES (15, '1', 2, 'shovel', 'Nicola Castanon', '3123580867', 'NicolaCastanon@gmail.com', '60615', '234 East 55th st', 'Chicago', 'IL', '12.99', '5500 4000 0000 4907', 213234, 'pickup', '500 Bayonne Crossing Way', 1, '2020-12-03 21:32:34');
INSERT INTO `ToolOrders` VALUES (16, '1', 4, 'Knot Filling & Wood Repair Kit', 'Nicola Castanon', '3129986739', 'NicolaCastanon@gmail.com', '60618', '3681 Oakmound Road', 'Chicago', 'IL', '170.0', '5500 4000 0000 4907', 213322, 'pickup', '8331 S Stewart Ave', 1, '2020-12-03 21:33:22');
INSERT INTO `ToolOrders` VALUES (17, '1', 14, 'WOOD CARVING TOOL SET', 'Nicola Castanon', '3129986739', 'NicolaCastanon@gmail.com', '60618', '3681 Oakmound Road', 'Chicago', 'IL', '22.99', '5500 4000 0000 4907', 213322, 'pickup', '8331 S Stewart Ave', 1, '2020-12-03 21:33:22');
INSERT INTO `ToolOrders` VALUES (18, '1', 3, 'pliers', 'Nicola Castanon', '3129986739', 'NicolaCastanon@gmail.com', '60618', '3681 Oakmound Road', 'Chicago', 'IL', '12.99', '5500 4000 0000 4907', 215022, 'delivery', '', 1, '2020-12-03 21:50:22');
INSERT INTO `ToolOrders` VALUES (19, '1', 14, 'WOOD CARVING TOOL SET', 'Nicola Castanon', '3129986739', 'NicolaCastanon@gmail.com', '60618', '3681 Oakmound Road', 'Chicago', 'IL', '22.99', '5500 4000 0000 4907', 215022, 'delivery', '', 1, '2020-12-03 21:50:22');
INSERT INTO `ToolOrders` VALUES (20, '1', 14, 'WOOD CARVING TOOL SET', 'Nicola Castanon', '3129986739', 'NicolaCastanon@gmail.com', '60618', '3681 Oakmound Road', 'Chicago', 'IL', '22.99', '5500 4000 0000 4907', 215034, 'delivery', '', 1, '2020-12-03 21:50:34');
INSERT INTO `ToolOrders` VALUES (21, '1', 3, 'pliers', 'Nicola Castanon', '3129986739', 'NicolaCastanon@gmail.com', '60618', '3681 Oakmound Road', 'Chicago', 'IL', '12.99', '5500 4000 0000 4907', 215149, 'delivery', '', 1, '2020-12-03 21:51:49');
INSERT INTO `ToolOrders` VALUES (22, '1', 11, 'Screws and Nuts, 1440PCS', 'Nicola Castanon', '3129986739', 'NicolaCastanon@gmail.com', '60618', '3681 Oakmound Road', 'Chicago', 'IL', '19.99', '5500 4000 0000 4907', 215149, 'delivery', '', 1, '2020-12-03 21:51:49');
INSERT INTO `ToolOrders` VALUES (23, '1', 4, 'Knot Filling & Wood Repair Kit', 'Nicola Castanon', '3129986739', 'NicolaCastanon@gmail.com', '60618', '3681 Oakmound Road', 'Chicago', 'IL', '170.0', '5500 4000 0000 4907', 215208, 'delivery', '', 1, '2020-12-03 21:52:08');
INSERT INTO `ToolOrders` VALUES (24, '1', 14, 'WOOD CARVING TOOL SET', 'Nicola Castanon', '3129986739', 'NicolaCastanon@gmail.com', '60618', '3681 Oakmound Road', 'Chicago', 'IL', '22.99', '5500 4000 0000 4907', 215208, 'delivery', '', 1, '2020-12-03 21:52:08');
INSERT INTO `ToolOrders` VALUES (25, '2', 1, 'hammer', 'Sarah Radovic', '3127085984', 'SarahRadovic@gmail.com', '60615', '234 East 55th st', 'Chicago', 'IL', '10.99', '9476 2846 1832 1129', 215317, 'delivery', '', 1, '2020-12-03 21:53:17');
INSERT INTO `ToolOrders` VALUES (26, '2', 6, 'Wood Markers', 'Sarah Radovic', '3127085984', 'SarahRadovic@gmail.com', '60615', '234 East 55th st', 'Chicago', 'IL', '7.99', '9476 2846 1832 1129', 215317, 'delivery', '', 1, '2020-12-03 21:53:17');
INSERT INTO `ToolOrders` VALUES (27, '2', 9, 'Moving Kit', 'Sarah Radovic', '3127085984', 'SarahRadovic@gmail.com', '60615', '234 East 55th st', 'Chicago', 'IL', '12.98', '9476 2846 1832 1129', 215317, 'delivery', '', 1, '2020-12-03 21:53:17');
INSERT INTO `ToolOrders` VALUES (28, '2', 12, 'Floor Repair', 'Sarah Radovic', '3127085984', 'SarahRadovic@gmail.com', '60615', '234 East 55th st', 'Chicago', 'IL', '22.99', '9476 2846 1832 1129', 215317, 'delivery', '', 1, '2020-12-03 21:53:17');
INSERT INTO `ToolOrders` VALUES (29, '2', 13, 'Taping Knife', 'Sarah Radovic', '3127085984', 'SarahRadovic@gmail.com', '60615', '234 East 55th st', 'Chicago', 'IL', '9.99', '9476 2846 1832 1129', 215317, 'delivery', '', 1, '2020-12-03 21:53:17');
INSERT INTO `ToolOrders` VALUES (30, '2', 8, 'Anti-tip Wall Anchor Kit', 'Sarah Radovic', '3127085984', 'SarahRadovic@gmail.com', '60615', '234 East 55th st', 'Chicago', 'IL', '11.99', '9476 2846 1832 1129', 215331, 'delivery', '', 1, '2020-12-03 21:53:31');
INSERT INTO `ToolOrders` VALUES (31, '2', 9, 'Moving Kit', 'Sarah Radovic', '3127085984', 'SarahRadovic@gmail.com', '60615', '234 East 55th st', 'Chicago', 'IL', '12.98', '9476 2846 1832 1129', 215331, 'delivery', '', 1, '2020-12-03 21:53:31');
INSERT INTO `ToolOrders` VALUES (32, '2', 5, 'Self-Adhesive Leather', 'Sarah Radovic', '3127085984', 'SarahRadovic@gmail.com', '60615', '234 East 55th st', 'Chicago', 'IL', '14.98', '9476 2846 1832 1129', 215339, 'delivery', '', 1, '2020-12-03 21:53:39');
INSERT INTO `ToolOrders` VALUES (33, '2', 6, 'Wood Markers', 'Sarah Radovic', '3127085984', 'SarahRadovic@gmail.com', '60615', '234 East 55th st', 'Chicago', 'IL', '7.99', '9476 2846 1832 1129', 215349, 'delivery', '', 1, '2020-12-03 21:53:49');
INSERT INTO `ToolOrders` VALUES (34, '2', 3, 'pliers', 'Sarah Radovic', '3127085984', 'SarahRadovic@gmail.com', '60615', '234 East 55th st', 'Chicago', 'IL', '12.99', '9476 2846 1832 1129', 220159, 'pickup', '8331 S Stewart Ave', 1, '2020-12-03 22:01:59');
INSERT INTO `ToolOrders` VALUES (35, '2', 6, 'Wood Markers', 'Sarah Radovic', '3127085984', 'SarahRadovic@gmail.com', '60615', '234 East 55th st', 'Chicago', 'IL', '7.99', '9476 2846 1832 1129', 220159, 'pickup', '8331 S Stewart Ave', 1, '2020-12-03 22:01:59');
INSERT INTO `ToolOrders` VALUES (36, '2', 2, 'shovel', 'Sarah Radovic', '3127085984', 'SarahRadovic@gmail.com', '60615', '234 East 55th st', 'Chicago', 'IL', '12.99', '9476 2846 1832 1129', 221944, 'pickup', '8331 S Stewart Ave', 1, '2020-12-03 22:19:44');
INSERT INTO `ToolOrders` VALUES (37, '2', 9, 'Moving Kit', 'Sarah Radovic', '3127085984', 'SarahRadovic@gmail.com', '60615', '234 East 55th st', 'Chicago', 'IL', '12.98', '9476 2846 1832 1129', 221944, 'pickup', '8331 S Stewart Ave', 1, '2020-12-03 22:19:44');
INSERT INTO `ToolOrders` VALUES (38, '2', 10, 'Furniture Strap', 'Sarah Radovic', '3127085984', 'SarahRadovic@gmail.com', '60615', '234 East 55th st', 'Chicago', 'IL', '8.99', '9476 2846 1832 1129', 221944, 'pickup', '8331 S Stewart Ave', 1, '2020-12-03 22:19:44');
INSERT INTO `ToolOrders` VALUES (39, '2', 12, 'Floor Repair', 'Sarah Radovic', '3127085984', 'SarahRadovic@gmail.com', '60615', '234 East 55th st', 'Chicago', 'IL', '22.99', '9476 2846 1832 1129', 221944, 'pickup', '8331 S Stewart Ave', 1, '2020-12-03 22:19:44');
INSERT INTO `ToolOrders` VALUES (40, '3', 8, 'Anti-tip Wall Anchor Kit', 'Alex Buel', '3128659937', 'AlexBuel@gmail.com', '60616', '4471 Tator Patch Road', 'Chicago', 'IL', '35.97', '8735 0347 2340 3442', 222121, 'delivery', '', 3, '2020-12-03 22:21:21');
INSERT INTO `ToolOrders` VALUES (41, '3', 10, 'Furniture Strap', 'Alex Buel', '3128659937', 'AlexBuel@gmail.com', '60616', '4471 Tator Patch Road', 'Chicago', 'IL', '8.99', '8735 0347 2340 3442', 222121, 'delivery', '', 1, '2020-12-03 22:21:21');
INSERT INTO `ToolOrders` VALUES (42, '3', 11, 'Screws and Nuts, 1440PCS', 'Alex Buel', '3128659937', 'AlexBuel@gmail.com', '60616', '4471 Tator Patch Road', 'Chicago', 'IL', '19.99', '8735 0347 2340 3442', 222121, 'delivery', '', 1, '2020-12-03 22:21:21');
INSERT INTO `ToolOrders` VALUES (43, '3', 3, 'pliers', 'Alex Buel', '3128659937', 'AlexBuel@gmail.com', '60616', '4471 Tator Patch Road', 'Chicago', 'IL', '12.99', '8735 0347 2340 3442', 222143, 'pickup', '10900 S Doty Ave', 1, '2020-12-03 22:21:43');
INSERT INTO `ToolOrders` VALUES (44, '3', 7, 'Furniture Anti-Tip Kit', 'Alex Buel', '3128659937', 'AlexBuel@gmail.com', '60616', '4471 Tator Patch Road', 'Chicago', 'IL', '21.98', '8735 0347 2340 3442', 222143, 'pickup', '10900 S Doty Ave', 1, '2020-12-03 22:21:43');
INSERT INTO `ToolOrders` VALUES (45, '3', 14, 'WOOD CARVING TOOL SET', 'Alex Buel', '3128659937', 'AlexBuel@gmail.com', '60616', '4471 Tator Patch Road', 'Chicago', 'IL', '22.99', '8735 0347 2340 3442', 222143, 'pickup', '10900 S Doty Ave', 1, '2020-12-03 22:21:43');
INSERT INTO `ToolOrders` VALUES (46, '3', 3, 'pliers', 'Alex Buel', '3128659937', 'AlexBuel@gmail.com', '60616', '4471 Tator Patch Road', 'Chicago', 'IL', '12.99', '8735 0347 2340 3442', 223054, 'pickup', '10900 S Doty Ave', 1, '2020-12-03 22:30:54');
INSERT INTO `ToolOrders` VALUES (47, '3', 4, 'Knot Filling & Wood Repair Kit', 'Alex Buel', '3128659937', 'AlexBuel@gmail.com', '60616', '4471 Tator Patch Road', 'Chicago', 'IL', '170.0', '8735 0347 2340 3442', 223054, 'pickup', '10900 S Doty Ave', 1, '2020-12-03 22:30:54');
INSERT INTO `ToolOrders` VALUES (48, '3', 11, 'Screws and Nuts, 1440PCS', 'Alex Buel', '3128659937', 'AlexBuel@gmail.com', '60616', '4471 Tator Patch Road', 'Chicago', 'IL', '19.99', '8735 0347 2340 3442', 223054, 'pickup', '10900 S Doty Ave', 1, '2020-12-03 22:30:54');
INSERT INTO `ToolOrders` VALUES (49, '4', 1, 'hammer', 'Edgar Haroop', '3128769937', 'EdgarHaroop@gmail.com', '60615', '10 West 93rd st', 'Chicago', 'IL', '10.99', '7465 2398 2004 2931', 223154, 'delivery', '', 1, '2020-12-03 22:31:54');
INSERT INTO `ToolOrders` VALUES (50, '4', 4, 'Knot Filling & Wood Repair Kit', 'Edgar Haroop', '3128769937', 'EdgarHaroop@gmail.com', '60615', '10 West 93rd st', 'Chicago', 'IL', '170.0', '7465 2398 2004 2931', 223154, 'delivery', '', 1, '2020-12-03 22:31:54');
INSERT INTO `ToolOrders` VALUES (51, '4', 10, 'Furniture Strap', 'Edgar Haroop', '3128769937', 'EdgarHaroop@gmail.com', '60615', '10 West 93rd st', 'Chicago', 'IL', '8.99', '7465 2398 2004 2931', 223154, 'delivery', '', 1, '2020-12-03 22:31:54');
INSERT INTO `ToolOrders` VALUES (52, '4', 11, 'Screws and Nuts, 1440PCS', 'Edgar Haroop', '3128769937', 'EdgarHaroop@gmail.com', '60615', '10 West 93rd st', 'Chicago', 'IL', '19.99', '7465 2398 2004 2931', 223154, 'delivery', '', 1, '2020-12-03 22:31:54');
INSERT INTO `ToolOrders` VALUES (53, '4', 12, 'Floor Repair', 'Edgar Haroop', '3128769937', 'EdgarHaroop@gmail.com', '60615', '10 West 93rd st', 'Chicago', 'IL', '22.99', '7465 2398 2004 2931', 223154, 'delivery', '', 1, '2020-12-03 22:31:54');
INSERT INTO `ToolOrders` VALUES (54, '4', 13, 'Taping Knife', 'Edgar Haroop', '3128769937', 'EdgarHaroop@gmail.com', '60615', '10 West 93rd st', 'Chicago', 'IL', '19.98', '7465 2398 2004 2931', 223154, 'delivery', '', 2, '2020-12-03 22:31:54');
INSERT INTO `ToolOrders` VALUES (55, '4', 1, 'hammer', 'Edgar Haroop', '3128769937', 'EdgarHaroop@gmail.com', '60615', '10 West 93rd st', 'Chicago', 'IL', '10.99', '7465 2398 2004 2931', 223421, 'delivery', '', 1, '2020-12-03 22:34:21');
INSERT INTO `ToolOrders` VALUES (56, '4', 7, 'Furniture Anti-Tip Kit', 'Edgar Haroop', '3128769937', 'EdgarHaroop@gmail.com', '60615', '10 West 93rd st', 'Chicago', 'IL', '21.98', '7465 2398 2004 2931', 223421, 'delivery', '', 1, '2020-12-03 22:34:21');
INSERT INTO `ToolOrders` VALUES (57, '4', 10, 'Furniture Strap', 'Edgar Haroop', '3128769937', 'EdgarHaroop@gmail.com', '60615', '10 West 93rd st', 'Chicago', 'IL', '8.99', '7465 2398 2004 2931', 225446, 'delivery', '', 1, '2020-12-03 22:54:46');
INSERT INTO `ToolOrders` VALUES (58, '4', 2, 'shovel', 'Edgar Haroop', '3128769937', 'EdgarHaroop@gmail.com', '60615', '10 West 93rd st', 'Chicago', 'IL', '12.99', '7465 2398 2004 2931', 225505, 'delivery', '', 1, '2020-12-03 22:55:05');
INSERT INTO `ToolOrders` VALUES (59, '4', 9, 'Moving Kit', 'Edgar Haroop', '3128769937', 'EdgarHaroop@gmail.com', '60615', '10 West 93rd st', 'Chicago', 'IL', '12.98', '7465 2398 2004 2931', 225518, 'delivery', '', 1, '2020-12-03 22:55:18');
INSERT INTO `ToolOrders` VALUES (60, '5', 8, 'Anti-tip Wall Anchor Kit', 'Cary Mcenaney', '3124458785', 'CaryMcenaney@gmail.com', '60605', '4725 John Calvin Drive', 'Chicago', 'IL', '11.99', '3476 1237 8317 2983', 120809, 'delivery', '', 1, '2020-12-04 12:08:09');
INSERT INTO `ToolOrders` VALUES (61, '5', 11, 'Screws and Nuts, 1440PCS', 'Cary Mcenaney', '3124458785', 'CaryMcenaney@gmail.com', '60605', '4725 John Calvin Drive', 'Chicago', 'IL', '19.99', '3476 1237 8317 2983', 120809, 'delivery', '', 1, '2020-12-04 12:08:09');
INSERT INTO `ToolOrders` VALUES (62, '5', 6, 'Wood Markers', 'Cary Mcenaney', '3124458785', 'CaryMcenaney@gmail.com', '60605', '4725 John Calvin Drive', 'Chicago', 'IL', '7.99', '3476 1237 8317 2983', 120826, 'delivery', '', 1, '2020-12-04 12:08:26');
INSERT INTO `ToolOrders` VALUES (63, '5', 7, 'Furniture Anti-Tip Kit', 'Cary Mcenaney', '3124458785', 'CaryMcenaney@gmail.com', '60605', '4725 John Calvin Drive', 'Chicago', 'IL', '21.98', '3476 1237 8317 2983', 120826, 'delivery', '', 1, '2020-12-04 12:08:26');
INSERT INTO `ToolOrders` VALUES (64, '5', 10, 'Furniture Strap', 'Cary Mcenaney', '3124458785', 'CaryMcenaney@gmail.com', '60605', '4725 John Calvin Drive', 'Chicago', 'IL', '8.99', '3476 1237 8317 2983', 120826, 'delivery', '', 1, '2020-12-04 12:08:26');
INSERT INTO `ToolOrders` VALUES (65, '5', 8, 'Anti-tip Wall Anchor Kit', 'Cary Mcenaney', '3124458785', 'CaryMcenaney@gmail.com', '60605', '4725 John Calvin Drive', 'Chicago', 'IL', '11.99', '3476 1237 8317 2983', 120852, 'pickup', '8331 S Stewart Ave', 1, '2020-12-04 12:08:52');
INSERT INTO `ToolOrders` VALUES (66, '5', 9, 'Moving Kit', 'Cary Mcenaney', '3124458785', 'CaryMcenaney@gmail.com', '60605', '4725 John Calvin Drive', 'Chicago', 'IL', '12.98', '3476 1237 8317 2983', 120852, 'pickup', '8331 S Stewart Ave', 1, '2020-12-04 12:08:52');
INSERT INTO `ToolOrders` VALUES (67, '5', 11, 'Screws and Nuts, 1440PCS', 'Cary Mcenaney', '3124458785', 'CaryMcenaney@gmail.com', '60605', '4725 John Calvin Drive', 'Chicago', 'IL', '39.98', '3476 1237 8317 2983', 120852, 'pickup', '8331 S Stewart Ave', 2, '2020-12-04 12:08:52');
INSERT INTO `ToolOrders` VALUES (68, '5', 12, 'Floor Repair', 'Cary Mcenaney', '3124458785', 'CaryMcenaney@gmail.com', '60605', '4725 John Calvin Drive', 'Chicago', 'IL', '22.99', '3476 1237 8317 2983', 120852, 'pickup', '8331 S Stewart Ave', 1, '2020-12-04 12:08:52');
INSERT INTO `ToolOrders` VALUES (69, '5', 2, 'shovel', 'Cary Mcenaney', '3124458785', 'CaryMcenaney@gmail.com', '60605', '4725 John Calvin Drive', 'Chicago', 'IL', '12.99', '3476 1237 8317 2983', 120951, 'delivery', '', 1, '2020-12-04 12:09:51');
INSERT INTO `ToolOrders` VALUES (70, '5', 2, 'shovel', 'Cary Mcenaney', '3124458785', 'CaryMcenaney@gmail.com', '60605', '4725 John Calvin Drive', 'Chicago', 'IL', '12.99', '3476 1237 8317 2983', 121522, 'pickup', '8331 S Stewart Ave', 1, '2020-12-04 12:15:22');
INSERT INTO `ToolOrders` VALUES (71, '5', 9, 'Moving Kit', 'Cary Mcenaney', '3124458785', 'CaryMcenaney@gmail.com', '60605', '4725 John Calvin Drive', 'Chicago', 'IL', '12.98', '3476 1237 8317 2983', 121522, 'pickup', '8331 S Stewart Ave', 1, '2020-12-04 12:15:22');
INSERT INTO `ToolOrders` VALUES (72, '5', 4, 'Knot Filling & Wood Repair Kit', 'Cary Mcenaney', '3124458785', 'CaryMcenaney@gmail.com', '60605', '4725 John Calvin Drive', 'Chicago', 'IL', '170.0', '3476 1237 8317 2983', 121540, 'delivery', '', 1, '2020-12-04 12:15:40');
INSERT INTO `ToolOrders` VALUES (73, '5', 5, 'Self-Adhesive Leather', 'Cary Mcenaney', '3124458785', 'CaryMcenaney@gmail.com', '60605', '4725 John Calvin Drive', 'Chicago', 'IL', '14.98', '3476 1237 8317 2983', 121540, 'delivery', '', 1, '2020-12-04 12:15:40');
INSERT INTO `ToolOrders` VALUES (74, '5', 9, 'Moving Kit', 'Cary Mcenaney', '3124458785', 'CaryMcenaney@gmail.com', '60605', '4725 John Calvin Drive', 'Chicago', 'IL', '12.98', '3476 1237 8317 2983', 121540, 'delivery', '', 1, '2020-12-04 12:15:40');
INSERT INTO `ToolOrders` VALUES (75, '5', 14, 'WOOD CARVING TOOL SET', 'Cary Mcenaney', '3124458785', 'CaryMcenaney@gmail.com', '60605', '4725 John Calvin Drive', 'Chicago', 'IL', '45.98', '3476 1237 8317 2983', 121816, 'delivery', '', 2, '2020-12-04 12:18:16');
INSERT INTO `ToolOrders` VALUES (76, '6', 11, 'Screws and Nuts, 1440PCS', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '19.99', '2376 2938 1293 2378', 121930, 'delivery', '', 1, '2020-12-04 12:19:30');
INSERT INTO `ToolOrders` VALUES (77, '6', 1, 'hammer', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '10.99', '2376 2938 1293 2378', 121957, 'pickup', '201 N Nellis Blvd', 1, '2020-12-04 12:19:57');
INSERT INTO `ToolOrders` VALUES (78, '6', 2, 'shovel', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '12.99', '2376 2938 1293 2378', 121957, 'pickup', '201 N Nellis Blvd', 1, '2020-12-04 12:19:57');
INSERT INTO `ToolOrders` VALUES (79, '6', 4, 'Knot Filling & Wood Repair Kit', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '170.0', '2376 2938 1293 2378', 121957, 'pickup', '201 N Nellis Blvd', 1, '2020-12-04 12:19:57');
INSERT INTO `ToolOrders` VALUES (80, '6', 6, 'Wood Markers', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '7.99', '2376 2938 1293 2378', 121957, 'pickup', '201 N Nellis Blvd', 1, '2020-12-04 12:19:57');
INSERT INTO `ToolOrders` VALUES (81, '6', 8, 'Anti-tip Wall Anchor Kit', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '11.99', '2376 2938 1293 2378', 121957, 'pickup', '201 N Nellis Blvd', 1, '2020-12-04 12:19:57');
INSERT INTO `ToolOrders` VALUES (82, '6', 12, 'Floor Repair', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '22.99', '2376 2938 1293 2378', 121957, 'pickup', '201 N Nellis Blvd', 1, '2020-12-04 12:19:57');
INSERT INTO `ToolOrders` VALUES (83, '6', 13, 'Taping Knife', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '9.99', '2376 2938 1293 2378', 121957, 'pickup', '201 N Nellis Blvd', 1, '2020-12-04 12:19:57');
INSERT INTO `ToolOrders` VALUES (84, '6', 14, 'WOOD CARVING TOOL SET', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '22.99', '2376 2938 1293 2378', 121957, 'pickup', '201 N Nellis Blvd', 1, '2020-12-04 12:19:57');
INSERT INTO `ToolOrders` VALUES (85, '6', 1, 'hammer', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '10.99', '2376 2938 1293 2378', 122112, 'delivery', '', 1, '2020-12-04 12:21:12');
INSERT INTO `ToolOrders` VALUES (86, '6', 2, 'shovel', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '12.99', '2376 2938 1293 2378', 122112, 'delivery', '', 1, '2020-12-04 12:21:12');
INSERT INTO `ToolOrders` VALUES (87, '6', 3, 'pliers', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '12.99', '2376 2938 1293 2378', 122112, 'delivery', '', 1, '2020-12-04 12:21:12');
INSERT INTO `ToolOrders` VALUES (88, '6', 14, 'WOOD CARVING TOOL SET', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '22.99', '2376 2938 1293 2378', 122112, 'delivery', '', 1, '2020-12-04 12:21:12');
INSERT INTO `ToolOrders` VALUES (89, '6', 6, 'Wood Markers', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '15.98', '2376 2938 1293 2378', 122255, 'delivery', '', 2, '2020-12-04 12:22:55');
INSERT INTO `ToolOrders` VALUES (90, '6', 7, 'Furniture Anti-Tip Kit', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '21.98', '2376 2938 1293 2378', 122255, 'delivery', '', 1, '2020-12-04 12:22:55');
INSERT INTO `ToolOrders` VALUES (91, '6', 8, 'Anti-tip Wall Anchor Kit', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '11.99', '2376 2938 1293 2378', 122255, 'delivery', '', 1, '2020-12-04 12:22:55');
INSERT INTO `ToolOrders` VALUES (92, '6', 10, 'Furniture Strap', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '8.99', '2376 2938 1293 2378', 122255, 'delivery', '', 1, '2020-12-04 12:22:55');
INSERT INTO `ToolOrders` VALUES (93, '6', 11, 'Screws and Nuts, 1440PCS', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '19.99', '2376 2938 1293 2378', 122255, 'delivery', '', 1, '2020-12-04 12:22:55');
INSERT INTO `ToolOrders` VALUES (94, '6', 12, 'Floor Repair', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '22.99', '2376 2938 1293 2378', 122255, 'delivery', '', 1, '2020-12-04 12:22:55');
INSERT INTO `ToolOrders` VALUES (95, '6', 13, 'Taping Knife', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '9.99', '2376 2938 1293 2378', 122255, 'delivery', '', 1, '2020-12-04 12:22:55');
INSERT INTO `ToolOrders` VALUES (96, '6', 3, 'pliers', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '12.99', '2376 2938 1293 2378', 122612, 'delivery', '', 1, '2020-12-04 12:26:12');
INSERT INTO `ToolOrders` VALUES (97, '6', 4, 'Knot Filling & Wood Repair Kit', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '170.0', '2376 2938 1293 2378', 122612, 'delivery', '', 1, '2020-12-04 12:26:12');
INSERT INTO `ToolOrders` VALUES (98, '6', 10, 'Furniture Strap', 'Torri Pettway', '3128774486', 'TorriPettway@gmail.com', '60610', '1137 Nash Street', 'Chicago', 'IL', '8.99', '2376 2938 1293 2378', 122612, 'delivery', '', 1, '2020-12-04 12:26:12');
INSERT INTO `ToolOrders` VALUES (99, '7', 13, 'Taping Knife', 'Marceline Westfield', '3124469852', 'MarcelineWestfield@gmail.com', '60620', '2795 Vesta Drive', 'Chicago', 'IL', '9.99', '8642 1923 0374 2446', 122705, 'delivery', '', 1, '2020-12-04 12:27:05');
INSERT INTO `ToolOrders` VALUES (100, '7', 1, 'hammer', 'Marceline Westfield', '3124469852', 'MarcelineWestfield@gmail.com', '60620', '2795 Vesta Drive', 'Chicago', 'IL', '10.99', '8642 1923 0374 2446', 122731, 'pickup', '3705 E South St', 1, '2020-12-04 12:27:31');
INSERT INTO `ToolOrders` VALUES (101, '7', 4, 'Knot Filling & Wood Repair Kit', 'Marceline Westfield', '3124469852', 'MarcelineWestfield@gmail.com', '60620', '2795 Vesta Drive', 'Chicago', 'IL', '170.0', '8642 1923 0374 2446', 122731, 'pickup', '3705 E South St', 1, '2020-12-04 12:27:31');
INSERT INTO `ToolOrders` VALUES (102, '7', 5, 'Self-Adhesive Leather', 'Marceline Westfield', '3124469852', 'MarcelineWestfield@gmail.com', '60620', '2795 Vesta Drive', 'Chicago', 'IL', '14.98', '8642 1923 0374 2446', 122731, 'pickup', '3705 E South St', 1, '2020-12-04 12:27:31');
INSERT INTO `ToolOrders` VALUES (103, '7', 8, 'Anti-tip Wall Anchor Kit', 'Marceline Westfield', '3124469852', 'MarcelineWestfield@gmail.com', '60620', '2795 Vesta Drive', 'Chicago', 'IL', '23.98', '8642 1923 0374 2446', 122731, 'pickup', '3705 E South St', 2, '2020-12-04 12:27:31');
INSERT INTO `ToolOrders` VALUES (104, '7', 10, 'Furniture Strap', 'Marceline Westfield', '3124469852', 'MarcelineWestfield@gmail.com', '60620', '2795 Vesta Drive', 'Chicago', 'IL', '8.99', '8642 1923 0374 2446', 122731, 'pickup', '3705 E South St', 1, '2020-12-04 12:27:31');
INSERT INTO `ToolOrders` VALUES (105, '7', 11, 'Screws and Nuts, 1440PCS', 'Marceline Westfield', '3124469852', 'MarcelineWestfield@gmail.com', '60620', '2795 Vesta Drive', 'Chicago', 'IL', '19.99', '8642 1923 0374 2446', 122731, 'pickup', '3705 E South St', 1, '2020-12-04 12:27:31');
INSERT INTO `ToolOrders` VALUES (106, '7', 12, 'Floor Repair', 'Marceline Westfield', '3124469852', 'MarcelineWestfield@gmail.com', '60620', '2795 Vesta Drive', 'Chicago', 'IL', '22.99', '8642 1923 0374 2446', 122731, 'pickup', '3705 E South St', 1, '2020-12-04 12:27:31');
INSERT INTO `ToolOrders` VALUES (107, '7', 14, 'WOOD CARVING TOOL SET', 'Marceline Westfield', '3124469852', 'MarcelineWestfield@gmail.com', '60620', '2795 Vesta Drive', 'Chicago', 'IL', '22.99', '8642 1923 0374 2446', 122731, 'pickup', '3705 E South St', 1, '2020-12-04 12:27:31');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
