/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-05-10 00:45:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `UserInfo`;
CREATE TABLE `UserInfo` (
  `userInfoId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `userName`varchar(30) NOT NULL COMMENT '用户名',
  `age` varchar(10) NOT NULL COMMENT '年龄',
  `sex` varchar(10) NOT NULL COMMENT '性别',
  PRIMARY KEY (`userInfoid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
