/*
Navicat MySQL Data Transfer

Source Server         : mysql-localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : course

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-05-08 22:42:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for choosemess
-- ----------------------------
DROP TABLE IF EXISTS `choosemess`;
CREATE TABLE `choosemess` (
  `stu_no` varchar(20) NOT NULL,
  `course_no` varchar(20) NOT NULL,
  `course_name` varchar(20) DEFAULT NULL,
  `tech_no` varchar(20) DEFAULT NULL,
  `tech_name` varchar(20) DEFAULT NULL,
  `course_time` varchar(20) DEFAULT NULL,
  `course_score` varchar(20) DEFAULT NULL,
  `course_describe` varchar(20) DEFAULT NULL,
  `course_number` int(11) DEFAULT NULL,
  `course_status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`stu_no`,`course_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of choosemess
-- ----------------------------
INSERT INTO `choosemess` VALUES ('201340602033', '000234', '模拟电子技术', '000122', null, '40', '1', '考试', '35', '1');
INSERT INTO `choosemess` VALUES ('201340602034', '000232', '电子电力技术', '000122', null, '60', '2', '考试', '35', '1');

-- ----------------------------
-- Table structure for coursemess
-- ----------------------------
DROP TABLE IF EXISTS `coursemess`;
CREATE TABLE `coursemess` (
  `course_no` varchar(20) NOT NULL,
  `tech_no` varchar(20) DEFAULT NULL,
  `course_name` varchar(20) DEFAULT NULL,
  `course_time` varchar(20) DEFAULT NULL,
  `course_score` varchar(20) DEFAULT NULL,
  `course_describe` varchar(20) DEFAULT NULL,
  `course_number` int(11) DEFAULT NULL,
  `course_sumno` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_no`),
  KEY `fk_tech_no` (`tech_no`),
  CONSTRAINT `fk_tech_no` FOREIGN KEY (`tech_no`) REFERENCES `teachermess` (`tech_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coursemess
-- ----------------------------
INSERT INTO `coursemess` VALUES ('000232', '000122', '电子电力技术', '60', '2', '考试', '34', '35');
INSERT INTO `coursemess` VALUES ('000234', '000122', '模拟电子技术', '40', '1', '考试', '34', '35');
INSERT INTO `coursemess` VALUES ('000654', '000123', '马克思主义理论', '30', '2', '考试', '60', '60');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `account` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('admin', 'admin', 'admin');

-- ----------------------------
-- Table structure for studentmess
-- ----------------------------
DROP TABLE IF EXISTS `studentmess`;
CREATE TABLE `studentmess` (
  `stu_no` varchar(20) NOT NULL,
  `stu_major` varchar(20) DEFAULT NULL,
  `stu_name` varchar(20) DEFAULT NULL,
  `stu_sex` varchar(20) DEFAULT NULL,
  `stu_password` varchar(20) DEFAULT NULL,
  `stu_cardno` varchar(20) DEFAULT NULL,
  `stu_grade` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`stu_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studentmess
-- ----------------------------
INSERT INTO `studentmess` VALUES ('201340602033', '电子信息工程', '李燕晓', '男', '123123', null, '2013级');
INSERT INTO `studentmess` VALUES ('201340602034', '电子信息工程', '李英桢', '男', '121212', null, '2013级');

-- ----------------------------
-- Table structure for sysmess
-- ----------------------------
DROP TABLE IF EXISTS `sysmess`;
CREATE TABLE `sysmess` (
  `sys_start` int(11) DEFAULT NULL,
  `sys_choosenum` int(11) DEFAULT NULL,
  `sys_time` varchar(20) DEFAULT NULL,
  `sys_f2` varchar(20) DEFAULT NULL,
  `sys_f3` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysmess
-- ----------------------------
INSERT INTO `sysmess` VALUES ('1', '2', '2017-05-20 10:30 ', null, null);

-- ----------------------------
-- Table structure for teachermess
-- ----------------------------
DROP TABLE IF EXISTS `teachermess`;
CREATE TABLE `teachermess` (
  `tech_no` varchar(20) NOT NULL,
  `tech_major` varchar(20) DEFAULT NULL,
  `tech_name` varchar(20) DEFAULT NULL,
  `tech_sex` varchar(20) DEFAULT NULL,
  `tech_password` varchar(20) DEFAULT NULL,
  `tech_title` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tech_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teachermess
-- ----------------------------
INSERT INTO `teachermess` VALUES ('000122', '电子系', '刘鑫', '男', '123123', '教授');
INSERT INTO `teachermess` VALUES ('000123', '马克思系', '桑涛', '男', '123123', '副教授');
SET FOREIGN_KEY_CHECKS=1;
