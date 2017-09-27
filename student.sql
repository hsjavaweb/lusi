/*
Navicat MySQL Data Transfer

Source Server         : lus
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2017-09-27 17:23:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `name` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `number` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('lusi', 'nv', '19', '5050416');
INSERT INTO `student` VALUES ('zhangsan', 'nan', '19', '5050422');
INSERT INTO `student` VALUES ('wangwu', 'nan', '20', '5050434');
