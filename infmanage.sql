/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : infmanage

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2010-06-07 07:44:00
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL auto_increment,
  `adminname` varchar(20) collate utf8_bin NOT NULL,
  `password` varchar(20) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '1');

-- ----------------------------
-- Table structure for `class`
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `classID` int(11) NOT NULL auto_increment,
  `classname` varchar(20) NOT NULL,
  `majorID` int(11) NOT NULL,
  `grade` int(11) NOT NULL,
  `teacherID` int(20) NOT NULL,
  `canupload` varchar(20) NOT NULL default 'false',
  PRIMARY KEY  (`classID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '信息工程', '1', '1', '1', 'true');
INSERT INTO `class` VALUES ('2', '软件工程', '2', '2', '3', 'false');
INSERT INTO `class` VALUES ('3', '软件概论', '1', '1', '1', 'false');
INSERT INTO `class` VALUES ('4', '编译原理', '3', '2', '3', 'false');
INSERT INTO `class` VALUES ('5', 'C语言', '4', '1', '1', 'true');
INSERT INTO `class` VALUES ('6', '组成原理', '2', '2', '6', 'false');
INSERT INTO `class` VALUES ('7', '马哲', '4', '1', '7', 'false');
INSERT INTO `class` VALUES ('8', '高数', '5', '2', '8', 'false');
INSERT INTO `class` VALUES ('9', '智能导论', '6', '3', '9', 'false');
INSERT INTO `class` VALUES ('10', '数据结构', '7', '4', '10', 'false');
INSERT INTO `class` VALUES ('11', '数据库', '8', '4', '11', 'false');
INSERT INTO `class` VALUES ('12', '计算机图形学', '9', '2', '12', 'false');
INSERT INTO `class` VALUES ('13', '毛概', '10', '3', '13', 'false');
INSERT INTO `class` VALUES ('14', '离散数学', '11', '2', '14', 'false');

-- ----------------------------
-- Table structure for `major`
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `majorID` int(11) NOT NULL auto_increment,
  `majorname` varchar(20) NOT NULL,
  PRIMARY KEY  (`majorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '智能系');
INSERT INTO `major` VALUES ('2', '软工系');
INSERT INTO `major` VALUES ('3', 'major3');
INSERT INTO `major` VALUES ('4', 'major4');
INSERT INTO `major` VALUES ('5', '物理系');
INSERT INTO `major` VALUES ('6', '化学系');
INSERT INTO `major` VALUES ('7', '历史系');
INSERT INTO `major` VALUES ('8', '音乐系');
INSERT INTO `major` VALUES ('9', '生科系');
INSERT INTO `major` VALUES ('10', '数学系');
INSERT INTO `major` VALUES ('11', '政法系');
INSERT INTO `major` VALUES ('12', '文学院');
INSERT INTO `major` VALUES ('13', '小语种');

-- ----------------------------
-- Table structure for `stu_class`
-- ----------------------------
DROP TABLE IF EXISTS `stu_class`;
CREATE TABLE `stu_class` (
  `ID` int(11) NOT NULL auto_increment,
  `stuID` int(11) NOT NULL,
  `classID` int(11) NOT NULL,
  `grade` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_class
-- ----------------------------
INSERT INTO `stu_class` VALUES ('1', '1', '1', '1', '82');
INSERT INTO `stu_class` VALUES ('2', '1', '2', '1', '81');
INSERT INTO `stu_class` VALUES ('3', '2', '1', '1', '60');
INSERT INTO `stu_class` VALUES ('4', '2', '2', '2', '59');
INSERT INTO `stu_class` VALUES ('5', '3', '3', '1', '58');
INSERT INTO `stu_class` VALUES ('6', '3', '4', '2', '60');
INSERT INTO `stu_class` VALUES ('7', '4', '4', '3', '71');
INSERT INTO `stu_class` VALUES ('8', '5', '5', '4', '72');
INSERT INTO `stu_class` VALUES ('9', '6', '6', '1', '80');
INSERT INTO `stu_class` VALUES ('12', '9', '2', '3', '83');
INSERT INTO `stu_class` VALUES ('13', '8', '4', '1', '88');
INSERT INTO `stu_class` VALUES ('14', '1', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('15', '2', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('16', '3', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('17', '4', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('18', '5', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('19', '6', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('20', '1', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('21', '2', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('22', '3', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('23', '4', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('24', '5', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('25', '6', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('26', '1', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('27', '2', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('28', '3', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('29', '4', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('30', '5', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('31', '6', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('32', '1', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('33', '2', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('34', '3', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('35', '4', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('36', '5', '1', '2', '80');
INSERT INTO `stu_class` VALUES ('37', '6', '1', '2', '80');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `ID` int(11) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `homeAdd` varchar(20) NOT NULL,
  `majorID` int(11) NOT NULL,
  `grade` int(11) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'zc', '3', 'beijing', '1', '1');
INSERT INTO `student` VALUES ('2', 'zj', '1', '衡水', '1', '2');
INSERT INTO `student` VALUES ('3', '张三', '1', '廊坊', '4', '2');
INSERT INTO `student` VALUES ('4', '李四', '1', '唐山', '4', '2');
INSERT INTO `student` VALUES ('5', 'tk', '1', '石景山', '4', '1');
INSERT INTO `student` VALUES ('6', '小山东', '1', '山东', '3', '3');
INSERT INTO `student` VALUES ('8', 'lm', '1', '丰台', '5', '4');
INSERT INTO `student` VALUES ('9', 'ly', '1', '天津', '6', '3');
INSERT INTO `student` VALUES ('10', 'jy', '1', 'beijing', '6', '2');
INSERT INTO `student` VALUES ('11', 'xk', '1', '广安门', '6', '2');
INSERT INTO `student` VALUES ('12', 'gsy', '1', 'beijing', '7', '1');
INSERT INTO `student` VALUES ('13', 'fy', '1', 'beijing', '7', '2');
INSERT INTO `student` VALUES ('14', 'gb', '1', '通州', '7', '3');
INSERT INTO `student` VALUES ('16', 'wxx', '1', 'beijing ', '8', '4');
INSERT INTO `student` VALUES ('17', 'lxx', '1', 'beijing', '8', '4');
INSERT INTO `student` VALUES ('18', 'mzy', '1', 'beijing', '8', '4');
INSERT INTO `student` VALUES ('19', 'ln', '1', '山东', '9', '3');
INSERT INTO `student` VALUES ('20', 'sg', '1', 'beijing', '9', '3');
INSERT INTO `student` VALUES ('21', 'muscal', '1', 'beijing', '9', '4');
INSERT INTO `student` VALUES ('22', 'drf', '1', '中关村', '9', '4');
INSERT INTO `student` VALUES ('23', 'dl', '1', 'beijing', '9', '3');
INSERT INTO `student` VALUES ('24', 'a2', 'a2', 'a2', '22', '22');
INSERT INTO `student` VALUES ('25', '翟涛', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('26', '张三', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('27', '李四', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('28', '王五', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('29', '刘六', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('30', '张明', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('31', '李佳', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('32', '李继', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('33', '翟涛', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('34', '张三', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('35', '李四', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('36', '王五', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('37', '刘六', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('38', '张明', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('39', '李佳', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('40', '李继', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('41', '翟涛', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('42', '张三', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('43', '李四', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('44', '王五', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('45', '刘六', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('46', '张明', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('47', '李佳', '111111', '北京', '5', '1');
INSERT INTO `student` VALUES ('48', '李继', '111111', '北京', '5', '1');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `ID` int(11) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `homeAdd` varchar(20) NOT NULL,
  `majorID` int(11) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'lj', '1', '北京', '1');
INSERT INTO `teacher` VALUES ('2', 'hxy', '1', '北京', '1');
INSERT INTO `teacher` VALUES ('3', 'wws', '2', '北京', '2');
INSERT INTO `teacher` VALUES ('4', 'zc', '1', 'beijing', '1');
INSERT INTO `teacher` VALUES ('5', 'llz', '1', '北京', '2');
INSERT INTO `teacher` VALUES ('6', 'md', '1', 'beijing', '3');
INSERT INTO `teacher` VALUES ('7', 'ah', '1', 'beijing', '4');
INSERT INTO `teacher` VALUES ('8', 'alj', '1', 'beijing', '5');
INSERT INTO `teacher` VALUES ('9', 'aw', '1', 'beijing', '6');
INSERT INTO `teacher` VALUES ('10', 'allz', '1', 'beijing', '7');
INSERT INTO `teacher` VALUES ('11', 'amd', '1', 'beijing', '8');
INSERT INTO `teacher` VALUES ('12', 'blj', '1', 'beijing', '9');
INSERT INTO `teacher` VALUES ('13', 'bhxy', '1', 'beijing', '10');
INSERT INTO `teacher` VALUES ('14', 'bwws', '1', 'beijing', '11');
INSERT INTO `teacher` VALUES ('15', 'bllz', '1', 'beijing', '12');
