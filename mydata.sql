/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50714
 Source Host           : localhost
 Source Database       : mydata

 Target Server Type    : MySQL
 Target Server Version : 50714
 File Encoding         : utf-8

 Date: 10/09/2016 14:40:59 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `GOODS`
-- ----------------------------
DROP TABLE IF EXISTS `GOODS`;
CREATE TABLE `GOODS` (
  `GID` int(10) NOT NULL,
  `GNAME` varchar(20) NOT NULL,
  `GPRICE` decimal(18,1) NOT NULL,
  `GNUM` int(11) NOT NULL,
  PRIMARY KEY (`GID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
--  Table structure for `GSALES`
-- ----------------------------
DROP TABLE IF EXISTS `GSALES`;
CREATE TABLE `GSALES` (
  `GSID` int(10) NOT NULL,
  `GID` int(10) NOT NULL,
  `SID` int(10) NOT NULL,
  `SDATE` datetime NOT NULL,
  `SNUM` int(11) NOT NULL,
  PRIMARY KEY (`GSID`),
  KEY `GID` (`GID`),
  KEY `SID` (`SID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `SALESMAN`
-- ----------------------------
DROP TABLE IF EXISTS `SALESMAN`;
CREATE TABLE `SALESMAN` (
  `SID` int(10) NOT NULL,
  `SNAME` varchar(20) NOT NULL,
  `SPASSWORD` varchar(20) NOT NULL,
  PRIMARY KEY (`SID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
