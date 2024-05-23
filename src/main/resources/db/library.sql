/*
 Navicat Premium Data Transfer

 Source Server         : LYT_DB
 Source Server Type    : MySQL
 Source Server Version : 80027 (8.0.27)
 Source Host           : 101.201.143.127:3307
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 80027 (8.0.27)
 File Encoding         : 65001

 Date: 22/12/2022 01:13:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
BEGIN;
INSERT INTO `admin` (`adminname`, `password`) VALUES ('admin', '123456');
INSERT INTO `admin` (`adminname`, `password`) VALUES ('new', '333');
COMMIT;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_publish` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `book_id` int NOT NULL,
  `book_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `book_category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `book_author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of book
-- ----------------------------
BEGIN;
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('清华大学出版社', 222, 'Spring快速入门', '计算机', '路飞话');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('四川大学出版社', 516, '计算机组成与体系结构', '教材', '李泽楷');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('吉林出版社', 1223, '老人与海', '小说', 'lbw');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('清华大学', 3331, 'Vue实战', '计算机', '薛家尽');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('机械工业出版社', 9283, '计算机网络', '教材', '纽约大学');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('四川大学', 11112, '夺命大使馆', '小说', 'fyc');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('中国工信出版社', 12357, 'C语言编程初学指南', '计算机', '李强');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('机械工业出版社', 23412, '计算机文化', '教材', '吕云翔');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('北方工业大学出版社', 28381, '操作系统', '教材', '李玉政');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('北京大学', 32121, '数据结构', '教材', '罗建森');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('四川大学出版社', 32156, '线性代数', '教材', '吕德华');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('日本出版社', 53412, '嫌疑犯X的献身', '小说', '东野圭吾');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('南海出版公司', 54663, '“小猫当当”系列', '儿童读物', '清野幸子');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('中国文学出版社', 56278, '城南旧事', '小说', '林海音');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('南海出版公司', 65142, '一百万只猫', '儿童读物', '婉达·盖格');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('商务印书馆', 65433, '牛津字典', '工具书', '集团');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('海燕出版社 ', 76223, '小飞侠', '儿童读物', '詹姆斯·巴里');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('二十一世纪出版社', 76889, '小泥人', '儿童读物', '伊东宽');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('明天出版社', 99643, '一园青菜成了精', '儿童读物', '周翔');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('商务印书馆', 333321, '新华词典', '工具书', '集团');
INSERT INTO `book` (`book_publish`, `book_id`, `book_name`, `book_category`, `book_author`) VALUES ('湖北美术出版社', 444777, '小熊不刷牙', '儿童读物', '依伐拉纳');
COMMIT;

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `book_id` int NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `borrow_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  `book_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of borrow
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for borrowhistory
-- ----------------------------
DROP TABLE IF EXISTS `borrowhistory`;
CREATE TABLE `borrowhistory` (
  `book_id` int NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `borrow_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  `book_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of borrowhistory
-- ----------------------------
BEGIN;
INSERT INTO `borrowhistory` (`book_id`, `user_name`, `borrow_date`, `return_date`, `book_name`, `status`) VALUES (222, 'user', '2022-12-21', '2023-01-21', 'Spring快速入门', '已还');
INSERT INTO `borrowhistory` (`book_id`, `user_name`, `borrow_date`, `return_date`, `book_name`, `status`) VALUES (516, 'user', '2022-12-21', '2023-01-21', '计算机组成与体系结构', '已还');
COMMIT;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int NOT NULL,
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of category
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for deletebook
-- ----------------------------
DROP TABLE IF EXISTS `deletebook`;
CREATE TABLE `deletebook` (
  `book_publish` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `book_id` int NOT NULL,
  `book_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `book_category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `book_author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of deletebook
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`username`, `password`) VALUES ('Jack', 'D0970714757783E6CF17B26FB8E2298F');
INSERT INTO `user` (`username`, `password`) VALUES ('user', 'E10ADC3949BA59ABBE56E057F20F883E');
COMMIT;

-- ----------------------------
-- View structure for arrive_reminder
-- ----------------------------
DROP VIEW IF EXISTS `arrive_reminder`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `arrive_reminder` AS select 1 AS `user_name`,1 AS `bname`,1 AS `email`;

-- ----------------------------
-- Procedure structure for do_sec_kill
-- ----------------------------
DROP PROCEDURE IF EXISTS `do_sec_kill`;
delimiter ;;
CREATE PROCEDURE `do_sec_kill`(IN bn varchar(30), IN uid int, OUT st int)
BEGIN
	declare num int;
    declare bid int;
    declare t_error integer default 0;
    declare continue handler for sqlexception set t_error=1;
    start transaction;
    
    select count(*) into num from book where ISBN=bn and state=0;
    select book_id into bid from book where ISBN=bn and state=0 order by book_id limit 0, 1;
	if num > 0 then
		insert into reservation(user_id, book_id, deadline) values(uid, bid, date_add(now(), interval 10 day));
		update book set state=1 where book_id=bid;
		set st = 1;
	else
		set st=0;
	end if;
    
    if t_error=1 then
		rollback;
        set st=-4;
	else
		commit;
	end if;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
