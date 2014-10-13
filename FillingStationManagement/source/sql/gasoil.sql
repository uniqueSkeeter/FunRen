/*
Navicat MySQL Data Transfer

Source Server         : localhost_3307
Source Server Version : 50617
Source Host           : localhost:3307
Source Database       : gasoil

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2014-05-26 09:55:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ashcard
-- ----------------------------
DROP TABLE IF EXISTS `ashcard`;
CREATE TABLE `ashcard` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `ASN` varchar(20) NOT NULL,
  `BAL` decimal(12,2) DEFAULT NULL,
  `AMN` decimal(12,2) DEFAULT NULL,
  `CTC` smallint(5) DEFAULT NULL,
  `DS` smallint(5) DEFAULT NULL,
  `SDATETIME` datetime DEFAULT NULL,
  `GMAC` varchar(4) DEFAULT NULL,
  `PSAM_TID` varchar(6) DEFAULT NULL,
  `PSAM_TTC` int(10) DEFAULT NULL,
  `StationNo` varchar(8) DEFAULT NULL,
  `RJID` int(10) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `StationNo` (`StationNo`),
  KEY `RJID` (`RJID`),
  CONSTRAINT `ashcard_ibfk_2` FOREIGN KEY (`RJID`) REFERENCES `fk_t_cardrjbb` (`RJID`),
  CONSTRAINT `ashcard_ibfk_1` FOREIGN KEY (`StationNo`) REFERENCES `stationinfo` (`StationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ashcard
-- ----------------------------

-- ----------------------------
-- Table structure for blackcard
-- ----------------------------
DROP TABLE IF EXISTS `blackcard`;
CREATE TABLE `blackcard` (
  `CardID` varchar(20) NOT NULL,
  `STATIONNO` varchar(8) DEFAULT NULL,
  `RJID` int(10) DEFAULT NULL,
  KEY `STATIONNO` (`STATIONNO`),
  KEY `RJID` (`RJID`),
  CONSTRAINT `blackcard_ibfk_2` FOREIGN KEY (`RJID`) REFERENCES `fk_t_cardrjbb` (`RJID`),
  CONSTRAINT `blackcard_ibfk_1` FOREIGN KEY (`STATIONNO`) REFERENCES `stationinfo` (`StationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blackcard
-- ----------------------------

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `CARNO` varchar(20) DEFAULT NULL,
  `ASN` varchar(20) DEFAULT NULL,
  `GUESTNO` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------

-- ----------------------------
-- Table structure for class_info
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info` (
  `Emp` varchar(3) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `start_time` varchar(5) DEFAULT NULL,
  `end_time` varchar(5) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `operator_id` int(15) DEFAULT NULL,
  PRIMARY KEY (`Emp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_info
-- ----------------------------

-- ----------------------------
-- Table structure for cylinders_info
-- ----------------------------
DROP TABLE IF EXISTS `cylinders_info`;
CREATE TABLE `cylinders_info` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `cylinders_no` varchar(20) DEFAULT NULL,
  `cylinders_type` varchar(10) DEFAULT NULL,
  `cylinders_cap` varchar(20) DEFAULT NULL,
  `cylinders_sale_date` date DEFAULT NULL,
  `cylinders_app_date` date DEFAULT NULL,
  `cylinders_col_date` date DEFAULT NULL,
  `cylinders_stats` int(5) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `USERID` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `USERID` (`USERID`),
  KEY `cylinders_no` (`cylinders_no`),
  CONSTRAINT `cylinders_info_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `fk_zd_userinfo` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cylinders_info
-- ----------------------------

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `type` varchar(2) NOT NULL,
  `name` varchar(20) NOT NULL,
  `value` varchar(10) NOT NULL,
  `use_stats` int(1) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `operator_id` int(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for employee_info
-- ----------------------------
DROP TABLE IF EXISTS `employee_info`;
CREATE TABLE `employee_info` (
  `id` smallint(5) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL,
  `USERNUMBER` int(10) NOT NULL,
  `post_type` int(5) NOT NULL,
  `id_number` int(20) NOT NULL,
  `education` int(5) DEFAULT NULL,
  `landscape` int(5) DEFAULT NULL,
  `class_id` int(15) NOT NULL,
  `banktype` varchar(2) DEFAULT NULL,
  `BANKno` varchar(50) DEFAULT NULL,
  `contact_addr` varchar(50) NOT NULL,
  `contact_tel` varchar(10) NOT NULL,
  `post_code` varchar(10) DEFAULT NULL,
  `post_stats` int(5) NOT NULL,
  `stats` int(5) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `operator_id` int(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee_info
-- ----------------------------

-- ----------------------------
-- Table structure for fk_tt_guestcredit
-- ----------------------------
DROP TABLE IF EXISTS `fk_tt_guestcredit`;
CREATE TABLE `fk_tt_guestcredit` (
  `ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `GUESTNAME` varchar(40) DEFAULT NULL,
  `GUESTNO` varchar(6) DEFAULT NULL,
  `INCNO` varchar(8) DEFAULT NULL,
  `transaction_before_money` decimal(8,0) DEFAULT NULL,
  `transaction_after_money` decimal(8,0) DEFAULT NULL,
  `AMN` decimal(8,2) DEFAULT NULL,
  `JYLX` varchar(6) DEFAULT NULL,
  `ZFFS` varchar(6) DEFAULT NULL,
  `TAX` varchar(20) DEFAULT NULL,
  `BJID` int(10) DEFAULT NULL,
  `RJID` int(10) DEFAULT NULL,
  `USERID` varchar(20) DEFAULT NULL,
  `USERNAME` varchar(20) DEFAULT NULL,
  `BZ` char(1) DEFAULT NULL,
  `STATIONNO` varchar(8) DEFAULT NULL,
  `WORKDATE` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `BJID` (`BJID`),
  KEY `RJID` (`RJID`),
  KEY `USERID` (`USERID`),
  KEY `STATIONNO` (`STATIONNO`),
  CONSTRAINT `fk_tt_guestcredit_ibfk_4` FOREIGN KEY (`STATIONNO`) REFERENCES `stationinfo` (`StationID`),
  CONSTRAINT `fk_tt_guestcredit_ibfk_1` FOREIGN KEY (`BJID`) REFERENCES `fk_t_cardrjbb` (`BJID`),
  CONSTRAINT `fk_tt_guestcredit_ibfk_2` FOREIGN KEY (`RJID`) REFERENCES `fk_t_cardrjbb` (`RJID`),
  CONSTRAINT `fk_tt_guestcredit_ibfk_3` FOREIGN KEY (`USERID`) REFERENCES `fk_zd_userinfo` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fk_tt_guestcredit
-- ----------------------------

-- ----------------------------
-- Table structure for fk_t_card
-- ----------------------------
DROP TABLE IF EXISTS `fk_t_card`;
CREATE TABLE `fk_t_card` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `CARDEXNO` varchar(8) DEFAULT NULL,
  `CARDNO` varchar(20) DEFAULT NULL,
  `CARDSTATUS` char(1) DEFAULT NULL,
  `CARDTYPE` varchar(2) DEFAULT NULL,
  `GUESTNAME` varchar(20) DEFAULT NULL,
  `GUESTTYPE` varchar(2) DEFAULT '1',
  `GUESTNUM` varchar(18) DEFAULT '1234567890',
  `GUESTPOST` varchar(8) DEFAULT NULL,
  `GUESTADD` varchar(40) DEFAULT NULL,
  `GUESTTEL` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `GUESTNO` varchar(6) DEFAULT NULL,
  `CARDBAL` decimal(8,2) DEFAULT '0.00',
  `CARDINC` decimal(8,2) DEFAULT '0.00',
  `CARDDEC` decimal(8,2) DEFAULT '0.00',
  `BEGDATE` datetime DEFAULT NULL,
  `ENDDATE` datetime DEFAULT NULL,
  `deposit` decimal(8,0) DEFAULT NULL,
  `cylinders_no` varchar(20) DEFAULT NULL,
  `beizhu` varchar(50) DEFAULT NULL,
  `BJID` int(10) DEFAULT NULL,
  `RJID` int(10) DEFAULT NULL,
  `STATIONNO` varchar(8) DEFAULT NULL,
  `xoil` char(4) DEFAULT NULL,
  `xeareflag` char(2) DEFAULT NULL,
  `xeare` char(80) DEFAULT NULL,
  `xvol` char(4) DEFAULT NULL,
  `xcount` char(2) DEFAULT NULL,
  `xamn` char(8) DEFAULT NULL,
  `xcarno` char(32) DEFAULT NULL,
  `USERID` varchar(20) DEFAULT NULL,
  `USERNAME` varchar(20) DEFAULT NULL,
  `CARNO` varchar(16) DEFAULT NULL,
  `password` varchar(16) DEFAULT '0',
  `lostflag` char(1) DEFAULT NULL,
  `BZ` char(1) DEFAULT '0',
  `PRE` decimal(8,2) DEFAULT NULL,
  `WORKDATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `cylinders_no` (`cylinders_no`),
  KEY `BJID` (`BJID`),
  KEY `RJID` (`RJID`),
  KEY `STATIONNO` (`STATIONNO`),
  KEY `USERID` (`USERID`),
  CONSTRAINT `fk_t_card_ibfk_5` FOREIGN KEY (`USERID`) REFERENCES `fk_zd_userinfo` (`USERID`),
  CONSTRAINT `fk_t_card_ibfk_1` FOREIGN KEY (`cylinders_no`) REFERENCES `cylinders_info` (`cylinders_no`),
  CONSTRAINT `fk_t_card_ibfk_2` FOREIGN KEY (`BJID`) REFERENCES `fk_t_cardrjbb` (`BJID`),
  CONSTRAINT `fk_t_card_ibfk_3` FOREIGN KEY (`RJID`) REFERENCES `fk_t_cardrjbb` (`RJID`),
  CONSTRAINT `fk_t_card_ibfk_4` FOREIGN KEY (`STATIONNO`) REFERENCES `stationinfo` (`StationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fk_t_card
-- ----------------------------

-- ----------------------------
-- Table structure for fk_t_cardin
-- ----------------------------
DROP TABLE IF EXISTS `fk_t_cardin`;
CREATE TABLE `fk_t_cardin` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `WORKDATE` datetime DEFAULT NULL,
  `WORKER` varchar(20) DEFAULT NULL,
  `CARDTYPE` varchar(2) DEFAULT NULL,
  `CARDSUM` int(10) DEFAULT NULL,
  `BEGEXNO` varchar(20) DEFAULT NULL,
  `ENDEXNO` varchar(20) DEFAULT NULL,
  `USERNAME` varchar(20) DEFAULT NULL,
  `BZ` char(1) DEFAULT NULL,
  `price` int(5) DEFAULT NULL,
  `send_num` int(10) DEFAULT NULL,
  `reciv_num` int(10) DEFAULT NULL,
  `stats` varchar(10) DEFAULT NULL,
  `BJID` int(10) DEFAULT NULL,
  `RJID` int(10) DEFAULT NULL,
  `USERID` varchar(20) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `STATIONNO` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `BJID` (`BJID`),
  KEY `RJID` (`RJID`),
  KEY `USERID` (`USERID`),
  KEY `STATIONNO` (`STATIONNO`),
  CONSTRAINT `fk_t_cardin_ibfk_4` FOREIGN KEY (`STATIONNO`) REFERENCES `stationinfo` (`StationID`),
  CONSTRAINT `fk_t_cardin_ibfk_1` FOREIGN KEY (`BJID`) REFERENCES `fk_t_cardrjbb` (`BJID`),
  CONSTRAINT `fk_t_cardin_ibfk_2` FOREIGN KEY (`RJID`) REFERENCES `fk_t_cardrjbb` (`RJID`),
  CONSTRAINT `fk_t_cardin_ibfk_3` FOREIGN KEY (`USERID`) REFERENCES `fk_zd_userinfo` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fk_t_cardin
-- ----------------------------

-- ----------------------------
-- Table structure for fk_t_cardrjbb
-- ----------------------------
DROP TABLE IF EXISTS `fk_t_cardrjbb`;
CREATE TABLE `fk_t_cardrjbb` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `WORKDATE` datetime DEFAULT NULL,
  `CARDINC` decimal(8,2) DEFAULT NULL,
  `CARDDEC` decimal(8,2) DEFAULT NULL,
  `CARDBAL` decimal(8,2) DEFAULT NULL,
  `CARDBAL2` decimal(8,2) DEFAULT NULL,
  `CARDBAL1` decimal(8,2) DEFAULT NULL,
  `SENDCOUNT` decimal(8,2) DEFAULT NULL,
  `BADCOUNT` decimal(8,2) DEFAULT NULL,
  `CARDCOUNT` decimal(8,2) DEFAULT NULL,
  `RJID` int(10) DEFAULT NULL,
  `RJRQ` datetime DEFAULT NULL,
  `BJID` int(10) DEFAULT NULL,
  `BJRQ` datetime DEFAULT NULL,
  `USERNAME` varchar(20) DEFAULT NULL,
  `USERID` varchar(20) DEFAULT NULL,
  `BZ` char(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `USERID` (`USERID`),
  KEY `RJID` (`RJID`),
  KEY `BJID` (`BJID`),
  CONSTRAINT `fk_t_cardrjbb_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `fk_zd_userinfo` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fk_t_cardrjbb
-- ----------------------------

-- ----------------------------
-- Table structure for fk_t_credit
-- ----------------------------
DROP TABLE IF EXISTS `fk_t_credit`;
CREATE TABLE `fk_t_credit` (
  `ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `WORKDATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `GUESTNAME` varchar(18) DEFAULT NULL,
  `INCNO` varchar(8) DEFAULT NULL,
  `CARDNO` varchar(20) DEFAULT NULL,
  `CARDINC` decimal(8,2) DEFAULT NULL,
  `CARDBEG` decimal(8,2) DEFAULT '0.00',
  `CARDBAL` decimal(8,2) DEFAULT NULL,
  `INCTYPE` varchar(6) DEFAULT NULL,
  `BJID` int(10) DEFAULT NULL,
  `RJID` int(10) DEFAULT NULL,
  `USERNAME` varchar(20) DEFAULT NULL,
  `RECTYPE` varchar(2) DEFAULT NULL,
  `BZ` char(1) DEFAULT NULL,
  `STATIONNO` varchar(8) DEFAULT NULL,
  `USERID` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `BJID` (`BJID`),
  KEY `RJID` (`RJID`),
  KEY `STATIONNO` (`STATIONNO`),
  KEY `USERID` (`USERID`),
  CONSTRAINT `fk_t_credit_ibfk_4` FOREIGN KEY (`USERID`) REFERENCES `fk_zd_userinfo` (`USERID`),
  CONSTRAINT `fk_t_credit_ibfk_1` FOREIGN KEY (`BJID`) REFERENCES `fk_t_cardrjbb` (`BJID`),
  CONSTRAINT `fk_t_credit_ibfk_2` FOREIGN KEY (`RJID`) REFERENCES `fk_t_cardrjbb` (`RJID`),
  CONSTRAINT `fk_t_credit_ibfk_3` FOREIGN KEY (`STATIONNO`) REFERENCES `stationinfo` (`StationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fk_t_credit
-- ----------------------------

-- ----------------------------
-- Table structure for fk_t_guest
-- ----------------------------
DROP TABLE IF EXISTS `fk_t_guest`;
CREATE TABLE `fk_t_guest` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `GUESTNO` varchar(6) DEFAULT NULL,
  `GUESTNAME` varchar(40) DEFAULT NULL,
  `GUESTTYPE` varchar(2) DEFAULT NULL,
  `idcard_type` varchar(2) DEFAULT NULL,
  `idcard_num` varchar(20) DEFAULT NULL,
  `guest_name` varchar(16) DEFAULT NULL,
  `ADD` varchar(40) DEFAULT NULL,
  `TEL` varchar(20) DEFAULT NULL,
  `POST` varchar(8) DEFAULT NULL,
  `EMAIL` varchar(30) DEFAULT NULL,
  `banktype` varchar(2) DEFAULT NULL,
  `BANK` varchar(50) DEFAULT NULL,
  `BANKACC` varchar(50) DEFAULT NULL,
  `TAXNO` varchar(50) DEFAULT NULL,
  `CARDSUM` smallint(5) DEFAULT NULL,
  `CARDACC` decimal(8,2) DEFAULT '0.00',
  `BAL` decimal(8,2) DEFAULT '0.00',
  `DEBITACC` decimal(8,2) DEFAULT '0.00',
  `CREDITACC` decimal(8,2) DEFAULT '0.00',
  `Limit` decimal(8,2) DEFAULT '0.00',
  `InUse` smallint(5) DEFAULT '0',
  `guest_type` varchar(2) DEFAULT NULL,
  `CARDNO` varchar(20) DEFAULT NULL,
  `integration` int(10) DEFAULT NULL,
  `DY` varchar(10) DEFAULT NULL,
  `FLAG` char(1) DEFAULT NULL,
  `ETC` varchar(8) DEFAULT NULL,
  `STATIONNO` varchar(8) DEFAULT NULL,
  `BZ` char(1) DEFAULT '0',
  `beizhu` varchar(50) DEFAULT NULL,
  `BJID` int(10) DEFAULT NULL,
  `RJID` int(10) DEFAULT NULL,
  `USERID` varchar(20) DEFAULT NULL,
  `USERNAME` varchar(16) DEFAULT NULL,
  `WORKDATE` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `STATIONNO` (`STATIONNO`),
  KEY `BJID` (`BJID`),
  KEY `RJID` (`RJID`),
  KEY `USERID` (`USERID`),
  KEY `GUESTNO` (`GUESTNO`),
  CONSTRAINT `fk_t_guest_ibfk_12` FOREIGN KEY (`USERID`) REFERENCES `fk_zd_userinfo` (`USERID`),
  CONSTRAINT `fk_t_guest_ibfk_1` FOREIGN KEY (`STATIONNO`) REFERENCES `stationinfo` (`StationID`),
  CONSTRAINT `fk_t_guest_ibfk_10` FOREIGN KEY (`BJID`) REFERENCES `fk_t_cardrjbb` (`BJID`),
  CONSTRAINT `fk_t_guest_ibfk_11` FOREIGN KEY (`RJID`) REFERENCES `fk_t_cardrjbb` (`RJID`),
  CONSTRAINT `fk_t_guest_ibfk_2` FOREIGN KEY (`BJID`) REFERENCES `fk_t_cardrjbb` (`BJID`),
  CONSTRAINT `fk_t_guest_ibfk_3` FOREIGN KEY (`RJID`) REFERENCES `fk_t_cardrjbb` (`RJID`),
  CONSTRAINT `fk_t_guest_ibfk_4` FOREIGN KEY (`USERID`) REFERENCES `fk_zd_userinfo` (`USERID`),
  CONSTRAINT `fk_t_guest_ibfk_5` FOREIGN KEY (`STATIONNO`) REFERENCES `stationinfo` (`StationID`),
  CONSTRAINT `fk_t_guest_ibfk_6` FOREIGN KEY (`BJID`) REFERENCES `fk_t_cardrjbb` (`BJID`),
  CONSTRAINT `fk_t_guest_ibfk_7` FOREIGN KEY (`RJID`) REFERENCES `fk_t_cardrjbb` (`RJID`),
  CONSTRAINT `fk_t_guest_ibfk_8` FOREIGN KEY (`USERID`) REFERENCES `fk_zd_userinfo` (`USERID`),
  CONSTRAINT `fk_t_guest_ibfk_9` FOREIGN KEY (`STATIONNO`) REFERENCES `stationinfo` (`StationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fk_t_guest
-- ----------------------------

-- ----------------------------
-- Table structure for fk_zd_cardstatus
-- ----------------------------
DROP TABLE IF EXISTS `fk_zd_cardstatus`;
CREATE TABLE `fk_zd_cardstatus` (
  `CARDSTATUS` char(1) NOT NULL,
  `NOTE` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`CARDSTATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fk_zd_cardstatus
-- ----------------------------

-- ----------------------------
-- Table structure for fk_zd_cardtype
-- ----------------------------
DROP TABLE IF EXISTS `fk_zd_cardtype`;
CREATE TABLE `fk_zd_cardtype` (
  `CARDTYPE` varchar(2) NOT NULL,
  `NOTE` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`CARDTYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fk_zd_cardtype
-- ----------------------------

-- ----------------------------
-- Table structure for fk_zd_guesttype
-- ----------------------------
DROP TABLE IF EXISTS `fk_zd_guesttype`;
CREATE TABLE `fk_zd_guesttype` (
  `GUESTTYPE` varchar(2) NOT NULL,
  `TYPEMENO` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`GUESTTYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fk_zd_guesttype
-- ----------------------------

-- ----------------------------
-- Table structure for fk_zd_idtype
-- ----------------------------
DROP TABLE IF EXISTS `fk_zd_idtype`;
CREATE TABLE `fk_zd_idtype` (
  `ID` smallint(2) NOT NULL,
  `IDTYPE` char(2) DEFAULT NULL,
  `NOTE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fk_zd_idtype
-- ----------------------------

-- ----------------------------
-- Table structure for fk_zd_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `fk_zd_userinfo`;
CREATE TABLE `fk_zd_userinfo` (
  `USERID` varchar(20) NOT NULL,
  `USERNAME` varchar(20) DEFAULT NULL,
  `USERPSW` varchar(20) DEFAULT NULL,
  `CARDID` varchar(20) DEFAULT NULL,
  `USERNUMBER` smallint(5) DEFAULT NULL,
  `USERTYPE` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fk_zd_userinfo
-- ----------------------------

-- ----------------------------
-- Table structure for manger_card_info
-- ----------------------------
DROP TABLE IF EXISTS `manger_card_info`;
CREATE TABLE `manger_card_info` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `station_id` varchar(20) NOT NULL,
  `card_id` varchar(20) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `USERID` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `USERID` (`USERID`),
  CONSTRAINT `manger_card_info_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `fk_zd_userinfo` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manger_card_info
-- ----------------------------

-- ----------------------------
-- Table structure for oil_gas_info
-- ----------------------------
DROP TABLE IF EXISTS `oil_gas_info`;
CREATE TABLE `oil_gas_info` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `no` varchar(20) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `old_price` varchar(20) DEFAULT NULL,
  `new_price` varchar(20) DEFAULT NULL,
  `new_density` varchar(20) DEFAULT NULL,
  `old_density` varchar(20) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `USERID` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `USERID` (`USERID`),
  CONSTRAINT `oil_gas_info_ibfk_2` FOREIGN KEY (`USERID`) REFERENCES `fk_zd_userinfo` (`USERID`),
  CONSTRAINT `oil_gas_info_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `fk_zd_userinfo` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oil_gas_info
-- ----------------------------

-- ----------------------------
-- Table structure for operatelog
-- ----------------------------
DROP TABLE IF EXISTS `operatelog`;
CREATE TABLE `operatelog` (
  `ID` bigint(19) NOT NULL AUTO_INCREMENT,
  `rectime` datetime DEFAULT CURRENT_TIMESTAMP,
  `POS_P` tinyint(3) DEFAULT NULL,
  `POS_TTC` bigint(19) DEFAULT NULL,
  `T_TYPE` tinyint(3) DEFAULT '0',
  `sTIME` datetime DEFAULT NULL,
  `ASN` varchar(20) DEFAULT NULL,
  `BAL` decimal(19,2) DEFAULT '0.00',
  `AMN` decimal(8,2) DEFAULT '0.00',
  `CTC` int(10) DEFAULT '0',
  `TAC` varchar(4) DEFAULT NULL,
  `GMAC` varchar(4) DEFAULT NULL,
  `PSAM_TAC` varchar(4) DEFAULT NULL,
  `PSAM_ASN` varchar(20) DEFAULT NULL,
  `PSAM_TID` varchar(6) DEFAULT NULL,
  `PSAM_TTC` bigint(19) DEFAULT '0',
  `DS` tinyint(3) DEFAULT '0',
  `UNIT` tinyint(3) DEFAULT '0',
  `C_TYPE` tinyint(3) DEFAULT '0',
  `VER` tinyint(3) DEFAULT '0',
  `NZN` tinyint(3) DEFAULT '0',
  `G_CODE` varchar(4) DEFAULT NULL,
  `VOL` decimal(8,2) DEFAULT '0.00',
  `PRC` decimal(8,2) DEFAULT '0.00',
  `EMP` tinyint(3) DEFAULT '0',
  `V_TOT` decimal(13,2) DEFAULT '0.00',
  `RFU` varchar(11) DEFAULT NULL,
  `T_MAC` varchar(4) DEFAULT NULL,
  `oilname` varchar(20) DEFAULT NULL,
  `AMN2` decimal(8,2) DEFAULT '0.00',
  `ACCNO` varchar(11) DEFAULT '0',
  `ACCDATE` datetime DEFAULT NULL,
  `RJRQ` varchar(19) DEFAULT NULL,
  `STATIONNO` varchar(8) DEFAULT '0',
  `CARNO` varchar(20) DEFAULT NULL,
  `Paytype` varchar(1) DEFAULT '0',
  `BZ` tinyint(3) DEFAULT '0',
  `userno` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `STATIONNO` (`STATIONNO`),
  CONSTRAINT `operatelog_ibfk_1` FOREIGN KEY (`STATIONNO`) REFERENCES `stationinfo` (`StationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operatelog
-- ----------------------------

-- ----------------------------
-- Table structure for operate_authority
-- ----------------------------
DROP TABLE IF EXISTS `operate_authority`;
CREATE TABLE `operate_authority` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `GM_id` int(5) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  `USERID` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `GM_id` (`GM_id`),
  KEY `USERID` (`USERID`),
  CONSTRAINT `operate_authority_ibfk_2` FOREIGN KEY (`USERID`) REFERENCES `fk_zd_userinfo` (`USERID`),
  CONSTRAINT `operate_authority_ibfk_1` FOREIGN KEY (`GM_id`) REFERENCES `screen_list` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operate_authority
-- ----------------------------

-- ----------------------------
-- Table structure for pre_allocated_detail
-- ----------------------------
DROP TABLE IF EXISTS `pre_allocated_detail`;
CREATE TABLE `pre_allocated_detail` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `CARDNO` varchar(20) DEFAULT NULL,
  `GUESTNO` varchar(7) DEFAULT NULL,
  `pay_money` decimal(8,0) DEFAULT NULL,
  `bills_no` varchar(20) DEFAULT NULL,
  `STATIONNO` varchar(8) DEFAULT NULL,
  `BJID` int(10) DEFAULT NULL,
  `RJID` int(10) DEFAULT NULL,
  `USERID` varchar(20) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `GUESTNO` (`GUESTNO`),
  KEY `STATIONNO` (`STATIONNO`),
  KEY `BJID` (`BJID`),
  KEY `RJID` (`RJID`),
  KEY `USERID` (`USERID`),
  CONSTRAINT `pre_allocated_detail_ibfk_5` FOREIGN KEY (`USERID`) REFERENCES `fk_zd_userinfo` (`USERID`),
  CONSTRAINT `pre_allocated_detail_ibfk_1` FOREIGN KEY (`GUESTNO`) REFERENCES `fk_t_guest` (`GUESTNO`),
  CONSTRAINT `pre_allocated_detail_ibfk_2` FOREIGN KEY (`STATIONNO`) REFERENCES `stationinfo` (`StationID`),
  CONSTRAINT `pre_allocated_detail_ibfk_3` FOREIGN KEY (`BJID`) REFERENCES `fk_t_cardrjbb` (`BJID`),
  CONSTRAINT `pre_allocated_detail_ibfk_4` FOREIGN KEY (`RJID`) REFERENCES `fk_t_cardrjbb` (`RJID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pre_allocated_detail
-- ----------------------------

-- ----------------------------
-- Table structure for price_file
-- ----------------------------
DROP TABLE IF EXISTS `price_file`;
CREATE TABLE `price_file` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `chprice_no` varchar(20) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `dev_time` date DEFAULT NULL,
  `eff_time` date DEFAULT NULL,
  `app_num` varchar(10) DEFAULT NULL,
  `mark` varchar(10) DEFAULT NULL,
  `flag` varchar(10) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `USERID` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `USERID` (`USERID`),
  CONSTRAINT `price_file_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `fk_zd_userinfo` (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of price_file
-- ----------------------------

-- ----------------------------
-- Table structure for screen_list
-- ----------------------------
DROP TABLE IF EXISTS `screen_list`;
CREATE TABLE `screen_list` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `up_step` int(2) DEFAULT NULL,
  `step` int(2) DEFAULT NULL,
  `detail` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of screen_list
-- ----------------------------

-- ----------------------------
-- Table structure for stationinfo
-- ----------------------------
DROP TABLE IF EXISTS `stationinfo`;
CREATE TABLE `stationinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `StationID` varchar(8) DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Telephone` varchar(15) DEFAULT NULL,
  `FAX` varchar(15) DEFAULT NULL,
  `Post` varchar(8) DEFAULT NULL,
  `Addr` varchar(50) DEFAULT NULL,
  `TaxCode` varchar(20) DEFAULT NULL,
  `BankAccNo` varchar(50) DEFAULT NULL,
  `RunType` tinyint(3) DEFAULT NULL,
  `PrintCom` varchar(7) DEFAULT 'LPT1',
  `PrintType` tinyint(3) DEFAULT NULL,
  `CKDH` varchar(8) DEFAULT NULL,
  `RKDH` varchar(8) DEFAULT NULL,
  `QTDH1` varchar(8) DEFAULT NULL,
  `QTDH2` varchar(8) DEFAULT NULL,
  `N1` tinyint(3) DEFAULT '0',
  `ComPort` varchar(7) DEFAULT NULL,
  `CollectMode` char(3) DEFAULT NULL,
  `CollectInterval` decimal(3,0) DEFAULT NULL,
  `ReportFlag` smallint(5) DEFAULT '0',
  `manger` varchar(20) DEFAULT NULL,
  `up_company` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `StationID` (`StationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stationinfo
-- ----------------------------

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
