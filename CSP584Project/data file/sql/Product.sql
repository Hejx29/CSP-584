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

 Date: 04/12/2020 03:18:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Product
-- ----------------------------
DROP TABLE IF EXISTS `Product`;
CREATE TABLE `Product` (
  `ProductId` int NOT NULL,
  `ProductName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `ProductImage` varchar(45) DEFAULT NULL,
  `ProductPrice` varchar(45) DEFAULT NULL,
  `ProductInventory` varchar(45) DEFAULT NULL,
  `ProductStatus` varchar(45) DEFAULT 'New',
  `ProductDescribe` text,
  PRIMARY KEY (`ProductId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Product
-- ----------------------------
BEGIN;
INSERT INTO `Product` VALUES (1, 'hammer', 'HAMMERS.png', '10.99', '55', 'Old', 'The 1-Piece Steel Hammer has optimal weight distribution for a controlled swing');
INSERT INTO `Product` VALUES (2, 'shovel', 'Shovel.jpg', '12.99', '44', 'Old', 'Mutual Industries D-Handle round point shovel features secure, comfortable control and has high-density steel spades for long lasting performance');
INSERT INTO `Product` VALUES (3, 'pliers', 'PLIERS.jpg', '12.99', '46', 'Old', 'A combination plier comes with induction hardened cutting edges and diamond serrated jaws, and has plastisol grips for added comfort.');
INSERT INTO `Product` VALUES (4, 'Knot Filling & Wood Repair Kit', 'KnotKit.png', '170.00', '23', 'Old', 'Professional Knot Filling & Wood Repair');
INSERT INTO `Product` VALUES (5, 'Self-Adhesive Leather', 'selftape.png', '14.98', '12', 'Old', 'With this leather repair patch, you can finally bring your favorite furniture and clothes back to life! Repair Patch First aid works on leather, vinyl and many other upholsteryfabrics, such as car seats, sofas, handbags, suitcases and more');
INSERT INTO `Product` VALUES (6, 'Wood Markers', 'woodmarkers.png', '7.99', '35', 'Old', 'This 13 piece kit includes 6 Repair Markers, 6 paper wrapped wax sticks and 1 wax stick sharpener packaged in a blister card');
INSERT INTO `Product` VALUES (7, 'Furniture Anti-Tip Kit', 'Anti-TipKit.png', '21.98', '64', 'Old', 'Furniture Anti-Tip Kit consists of an aircraft grade steel cable that connects on one end to your furniture with a bracket installed into a stud on the wall.');
INSERT INTO `Product` VALUES (8, 'Anti-tip Wall Anchor Kit', 'Anti-Wall.png', '11.99', '36', 'Old', 'Anti-tip Kit are made with durable steel and structured under mechanical design, it doesn’t bend or break under pressure. The steel cables are design for heavy duty, it can hold 300 lbs.');
INSERT INTO `Product` VALUES (9, 'Moving Kit', 'movingkit.png', '12.98', '43', 'Old', 'Furniture movers with EVA foam felt pads backing to grip and protect, durable feature can be used or moved again and again.');
INSERT INTO `Product` VALUES (10, 'Furniture Strap', 'furniture strap.png', '8.99', '65', 'New', '[Child Safety] CRANACH furniture straps are designed to protect children and pets from the dumping of furniture, even during earthquakes and windstorms. CRANACH Furniture anchors for baby proofing safety first. ');
INSERT INTO `Product` VALUES (11, 'Screws and Nuts, 1440PCS', 'screws and nuts.png', '19.99', '55', 'New', 'There are a total of 1440 pieces 304 stainless steel screws and nuts sets in 3 sizes: M2, M3,M4 with matching nuts, flat washers and spring washers meet different people’s demands.');
INSERT INTO `Product` VALUES (12, 'Floor Repair', 'floor repair.png', '22.99', '76', 'New', 'BECOME THE PRO YOURSELF- Choose similar color of wax，melt the wax and fill in the scratch,Smooth after cooling. fix the scuffed furniture yourself');
INSERT INTO `Product` VALUES (13, 'Taping Knife', 'taping knife.png', '9.99', '36', 'New', 'Paint Scrapers that get the job done with a superior finish. Makes repair and refinishing jobs quick and easy');
INSERT INTO `Product` VALUES (14, 'WOOD CARVING TOOL SET', 'WOOD CARVING TOOL SET.png', '22.99', '45', 'New', 'Great for carving linoleum.');
INSERT INTO `Product` VALUES (66, 'Beverage Cooler', 'beverage cooler.jpg', '299.99', '20', 'Old', 'The freestanding design is ready to use out of the box, and adjustable shelves let you create customized storage for different sized bottles.');
INSERT INTO `Product` VALUES (67, 'Bagless Upright Vacuum', 'Dyson - V11.jpg', '439.99', '17', 'Old', 'Twice the suction of any cord-free vacuum*. Cord-free cleaning, made easier. Intelligently optimizes suction and run time, to deep clean everywhere. ');
INSERT INTO `Product` VALUES (68, 'Air Fryer', 'air fryer.jpg', '139.99', '36', 'Old', 'Cook your favorite dishes in this Cuisinart air fryer toaster oven, and this Cuisinart air fryer toaster oven is whisper quite to minimize disruptions.');
INSERT INTO `Product` VALUES (111, 'test111', 'stardand cleaning.png', '10.22', '45', 'New', 'Hello');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
