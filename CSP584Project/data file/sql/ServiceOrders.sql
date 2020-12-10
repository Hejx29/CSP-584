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

 Date: 04/12/2020 03:19:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ServiceOrders
-- ----------------------------
DROP TABLE IF EXISTS `ServiceOrders`;
CREATE TABLE `ServiceOrders` (
  `orderId` int NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `productId` int DEFAULT NULL,
  `serviceName` varchar(45) DEFAULT NULL,
  `serviceDetail` varchar(500) DEFAULT NULL,
  `serviceDate` date NOT NULL,
  `serviceTime` time NOT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `zip` int DEFAULT NULL,
  `street` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `serviceHour` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `creditNo` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of ServiceOrders
-- ----------------------------
BEGIN;
INSERT INTO `ServiceOrders` VALUES (22212, '1', 2, 'Deep Clean', 'need deep Clean', '2020-12-01', '20:20:00', 'Nicola', ' Castanon', '3129986739', 'NicolaCastanon@gmail.com', 60618, '3681 Oakmound Road', 'Chicago', 'IL', '3h', '90.0$', '500 4000 0000 4907');
INSERT INTO `ServiceOrders` VALUES (22213, '1', 2, 'Windows Tinting', 'need Windows Tinting', '2020-11-25', '15:20:00', 'Nicola', 'Castanon', '3129986739', 'NicolaCastanon@gmail.com', 60618, '3681 Oakmound Road', 'Chicago', 'IL', '1h', '35.0$', '500 4000 0000 4907');
INSERT INTO `ServiceOrders` VALUES (22919, '1', 13, 'Light Fixture Installation', 'need light fixture installation', '2020-11-30', '21:29:00', 'Nicola', 'Castanon', '3129986739', 'NicolaCastanon@gmail.com', 60618, '3681 Oakmound Road', 'Chicago', 'IL', '1h', '35.0$', '500 4000 0000 4907');
INSERT INTO `ServiceOrders` VALUES (23224, '2', 22, 'Laminate floor repair', 'need laminate floor repair', '2020-11-25', '15:00:00', 'Sarah', ' Radovic', '3127085984', 'SarahRadovic@gmail.com', 60615, '234 East 55th st', 'Chicago', 'IL', '1h', '130.0$', '9476 2846 1832');
INSERT INTO `ServiceOrders` VALUES (23323, '2', 1, 'Standard Clean', 'need standard clean', '2020-11-09', '06:32:00', 'Sarah', 'Radovic', '3127085984', 'SarahRadovic@gmail.com', 60615, '234 East 55th st', 'Chicago', 'IL', '1h', '20.0$', '9476 2846 1832');
INSERT INTO `ServiceOrders` VALUES (23449, '2', 12, 'Electric Wiring Repair', 'need electric wiring repair', '2020-12-07', '20:35:00', 'Sarah', 'Radovic', '3127085984', 'SarahRadovic@gmail.com', 60615, '234 East 55th st', 'Chicago', 'IL', '1h', '75.0$', '9476 2846 1832');
INSERT INTO `ServiceOrders` VALUES (23720, '3', 70, 'Tub Drain Repair', 'need tub repair', '2020-11-16', '19:45:00', 'Alex', 'Buel', '3128659937', 'AlexBuel@gmail.com', 60616, '4471 Tator Patch Road', 'Chicago', 'IL', '1h', '70.0$', '8735 0347 2340 3442');
INSERT INTO `ServiceOrders` VALUES (23830, '3', 18, 'Doors Repair', 'need doors repair service', '2020-10-15', '22:40:00', 'Alex', 'Buel', '3128659937', 'AlexBuel@gmail.com', 60616, '4471 Tator Patch Road', 'Chicago', 'IL', '3h', '420.0$', '8735 0347 2340 3440');
INSERT INTO `ServiceOrders` VALUES (23931, '3', 1, 'Standard Clean', 'need standard clean', '2020-11-18', '21:40:00', 'Alex', 'Buel', '3128659937', 'AlexBuel@gmail.com', 60616, '4471 Tator Patch Road', 'Chicago', 'IL', '1h', '20.0$', '8735 0347 2340 3440');
INSERT INTO `ServiceOrders` VALUES (24144, '4', 16, 'Leaky faucet repair', 'need Leaky faucet repair', '2020-11-21', '13:42:00', 'Edgar', ' Haroop', '3128769937', 'EdgarHaroop@gmail.com', 60615, '10 West 93rd st', 'Chicago', 'IL', '1h', '99.0$', '7465 2398 2004');
INSERT INTO `ServiceOrders` VALUES (24419, '4', 70, 'Tub Drain Repair', 'need tub repair', '2020-10-16', '22:44:00', 'Edgar', 'Haroop', '3128769937', 'EdgarHaroop@gmail.com', 60615, '10 West 93rd st', 'Chicago', 'IL', '1h', '70.0$', '7465 2398 2004');
INSERT INTO `ServiceOrders` VALUES (24525, '4', 19, 'Wood Furniture Repair', 'need wood furniture repair', '2020-06-11', '22:45:00', 'Edgar', 'Haroop', '3128769937', 'EdgarHaroop@gmail.com', 60615, '10 West 93rd st', 'Chicago', 'IL', '1h', '69.0$', '7465 2398 2004');
INSERT INTO `ServiceOrders` VALUES (24749, '5', 16, 'Leaky faucet repair', 'need leaky repair service', '2020-06-19', '20:48:00', 'Cary', 'Mcenaney', '3124458785', 'CaryMcenaney@gmail.com', 60605, '4725 John Calvin Drive', 'Chicago', 'IL', '1h', '99.0$', '3476 1237 8317 2983');
INSERT INTO `ServiceOrders` VALUES (24840, '5', 2, 'Deep Clean', 'need deep Clean service', '2020-09-18', '16:48:00', 'Cary', 'Mcenaney', '3124458785', 'CaryMcenaney@gmail.com', 60605, '4725 John Calvin Drive', 'Chicago', 'IL', '1h', '30.0$', '7465 2398 2004');
INSERT INTO `ServiceOrders` VALUES (24956, '5', 17, 'Water heater repair ', 'need water heater repair service', '2020-08-22', '06:00:00', 'Cary', 'Mcenaney', '3124458785', 'CaryMcenaney@gmail.com', 60605, '4725 John Calvin Drive', 'Chicago', 'IL', '3h', '135.0$', '7465 2398 2004');
INSERT INTO `ServiceOrders` VALUES (25200, '6', 7, 'Full Decorating', 'need full decorating', '2020-11-15', '20:50:00', 'Torri', 'Pettway', '3128774486', 'TorriPettway@gmail.com', 60610, '1137 Nash Street', 'Chicago', 'IL', '6h', '480.0$', '2376 2938 1293 2378');
INSERT INTO `ServiceOrders` VALUES (25359, '6', 12, 'Electric Wiring Repair', 'need electric wiring repair', '2020-11-30', '20:53:00', 'Torri', 'Pettway', '3128774486', 'TorriPettway@gmail.com', 60610, '1137 Nash Street', 'Chicago', 'IL', '2h', '150.0$', '2376 2938 1293 2378');
INSERT INTO `ServiceOrders` VALUES (25526, '6', 21, 'Wood furniture repair', 'wood furniture repair', '2020-08-14', '17:58:00', 'Torri', 'Pettway', '3128774486', 'TorriPettway@gmail.com', 60610, '1137 Nash Street', 'Chicago', 'IL', '3h', '900.0$', '2376 2938 1293 2378');
INSERT INTO `ServiceOrders` VALUES (25804, '7', 12, 'Electric Wiring Repair', 'need electric wiring repair', '2020-08-15', '22:56:00', 'Marceline', 'Westfield', '3124469852', 'MarcelineWestfield@gmail.com', 60620, '2795 Vesta Drive', 'Chicago', 'IL', '2h', '150.0$', '8642 1923 0374 ');
INSERT INTO `ServiceOrders` VALUES (25917, '7', 14, 'Outlet Installation', 'need outlet installation service', '2020-01-16', '20:00:00', 'Marceline', 'Westfield', '3124469852', 'MarcelineWestfield@gmail.com', 60620, '2795 Vesta Drive', 'Chicago', 'IL', '2h', '100.0$', '8642 1923 0374 ');
INSERT INTO `ServiceOrders` VALUES (30048, '7', 17, 'Water heater repair ', 'need water heater repair service', '2020-05-17', '21:00:00', 'Marceline', 'Westfield', '3124469852', 'MarcelineWestfield@gmail.com', 60620, '2795 Vesta Drive', 'Chicago', 'IL', '4h', '180.0$', '8642 1923 0374 ');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
