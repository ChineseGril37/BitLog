/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80039 (8.0.39)
 Source Host           : localhost:3306
 Source Schema         : bitlog

 Target Server Type    : MySQL
 Target Server Version : 80039 (8.0.39)
 File Encoding         : 65001

 Date: 21/08/2024 21:23:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `post_id` int NOT NULL COMMENT '评论所属帖子',
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL COMMENT '评论者邮箱',
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NULL DEFAULT NULL COMMENT '评论显示昵称(默认显示邮箱)',
  `likes` int NULL DEFAULT NULL COMMENT '点赞数',
  `timestamp` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '评论时间戳',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'md文件ID',
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL COMMENT '文件名',
  `file_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL COMMENT '文件地址',
  `file_size` double NOT NULL COMMENT '文件大小',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `updatetime` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id` DESC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file
-- ----------------------------

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '帖子id',
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_520_ci NULL DEFAULT NULL COMMENT '帖子标题',
  `type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_520_ci NULL DEFAULT NULL COMMENT '帖子分类',
  `author` int NOT NULL COMMENT '创建者',
  `createtime` timestamp NULL DEFAULT NULL COMMENT '创建时间戳',
  `updatetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间戳',
  `likes` int NULL DEFAULT NULL COMMENT '点赞数',
  `views` int NOT NULL COMMENT '浏览次数',
  `hotpoint` double NULL DEFAULT NULL COMMENT '热度值',
  `shortcut` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_520_ci NULL DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_unicode_520_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (1, 'SpringBoot全局异常处理详解', 'Java', 1, '2024-06-10 22:00:51', '2024-08-20 15:47:56', 13, 2, 32, '在SpringBoot的开发中，为了提高程序运行的鲁棒性，我们经常需要对各种程序异常进行处理，但是如果在每个出异常的地方进行单独处理的话，这会引入大量业务不相关的异常处理代码，增加了程序的耦合，同时未来想改变异常的处理逻辑，也变得比较困难。这篇文章带大家了解一下如何优雅的进行全局异常处理。');
INSERT INTO `post` VALUES (2, ' 如何实现全局拦截', 'SpringBoot', 2, '2024-06-11 17:58:06', '2024-08-21 15:25:59', 4, 12, 15, ' ResponseEntityExceptionHandler中包装了各种SpringMVC在处理请求时可能抛出的异常的处理，处理结果都是封装成一个ResponseEntity对象。');
INSERT INTO `post` VALUES (3, 'Spring AOP 详细深入讲解', 'SpringBoot', 1, '2024-08-08 15:45:35', '2024-08-20 15:48:41', 1, 5, 33, 'Spring AOP（Aspect-Oriented Programming）是Spring框架提供的一种面向切面编程的技术。它通过将横切关注点（例如日志记录、事务管理、安全性检查等）从主业务逻辑代码中分离出来，以模块化的方式实现对这些关注点的管理和重用。');
INSERT INTO `post` VALUES (4, 'SpringBoot 如何优雅的进行全局异常处理？', 'SpringBoot', 1, '2024-07-05 09:44:02', '2024-08-20 15:48:43', 5, 22, 14, '在SpringBoot的开发中，为了提高程序运行的鲁棒性，我们经常需要对各种程序异常进行处理，但是如果在每个出异常的地方进行单独处理的话，这会引入大量业务不相关的异常处理代码，增加了程序的耦合，同时未来想改变异常的处理逻辑，也变得比较困难。这篇文章带大家了解一下如何优雅的进行全局异常处理。');
INSERT INTO `post` VALUES (5, 'BitLog开发记录', 'BitLog', 1, '2024-08-20 16:08:01', '2024-08-20 16:23:20', 12, 312, 44, '根据设置的大类分类查看：暂拟前端、后端、MySQL、Debug、个人学习\r\n\r\n帖子查看排序：热度(默认)、最多浏览、最多点赞、最新发布、最早发布');
INSERT INTO `post` VALUES (6, 'BitLog开发过程中遇到的失误和BUG', 'BitLog', 1, '2024-08-20 16:23:24', '2024-08-20 16:23:42', 1, 12, 7, '开发过程中的故事');
INSERT INTO `post` VALUES (7, 'Vuetify实现瀑布流', 'Vue', 2, NULL, NULL, 12, 23, 33, 'Vuetify作为Vue的一个重要组件...');

-- ----------------------------
-- Table structure for post_tag
-- ----------------------------
DROP TABLE IF EXISTS `post_tag`;
CREATE TABLE `post_tag`  (
  `post_id` int NOT NULL COMMENT '联合主键-帖ID',
  `tag_id` int NOT NULL COMMENT '联合主键-TagID',
  PRIMARY KEY (`post_id`, `tag_id`) USING BTREE,
  INDEX `tag_id`(`tag_id` ASC) USING BTREE,
  CONSTRAINT `post_tag_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `post_tag_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post_tag
-- ----------------------------

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'TagID',
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL COMMENT 'Tag名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (1, 'Java');
INSERT INTO `tag` VALUES (2, 'SpringBoot');
INSERT INTO `tag` VALUES (3, 'Vue');
INSERT INTO `tag` VALUES (4, 'Redis');
INSERT INTO `tag` VALUES (5, 'BitLog');
INSERT INTO `tag` VALUES (6, 'MySQL');
INSERT INTO `tag` VALUES (7, 'TypeScript');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL COMMENT '用户ID',
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL COMMENT '用户名',
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL COMMENT '邮箱',
  `type` tinyint NULL DEFAULT NULL COMMENT '用户类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
