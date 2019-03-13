/*
Navicat MySQL Data Transfer

Source Server         : hf
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : studentmanager

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2018-12-10 15:59:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `academy`
-- ----------------------------
DROP TABLE IF EXISTS `academy`;
CREATE TABLE `academy` (
  `academy_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '院系编号',
  `academy_number` varchar(15) DEFAULT NULL COMMENT '院系代号',
  `academy_name` varchar(15) DEFAULT NULL COMMENT '院系名称',
  PRIMARY KEY (`academy_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of academy
-- ----------------------------
INSERT INTO `academy` VALUES ('1', '12563', '计算机学院');
INSERT INTO `academy` VALUES ('2', '12560', '经济管理学院');
INSERT INTO `academy` VALUES ('3', '12561', '纺织学院');
INSERT INTO `academy` VALUES ('4', '12562', '土木建筑学院');
INSERT INTO `academy` VALUES ('5', '12564', '外国语学院');
INSERT INTO `academy` VALUES ('6', '12565', '马克思学院');
INSERT INTO `academy` VALUES ('7', '12566', '文学院');
INSERT INTO `academy` VALUES ('8', '12567', '信息工程学院');
INSERT INTO `academy` VALUES ('9', '12568', '机电学院');
INSERT INTO `academy` VALUES ('10', '12569', '数学与计算学院');

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `adminname` varchar(20) DEFAULT NULL COMMENT '管理员登录账号',
  `adpassword` varchar(20) NOT NULL COMMENT '登录密码',
  `adnickname` varchar(20) DEFAULT NULL COMMENT '管理员昵称',
  `gender` varchar(5) DEFAULT NULL COMMENT '性别',
  `age` tinyint(4) DEFAULT NULL COMMENT '年龄',
  `adphone` varchar(15) DEFAULT NULL COMMENT '练习方式',
  `ademail` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `adcreatetime` datetime DEFAULT NULL COMMENT '创建时间',
  `adremark` text COMMENT '备注信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `adminname` (`adminname`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'Lily', '123456', '莉莉', '女', '20', '13432564925', '12635846@qq.com', '2018-12-06 17:34:05', null);
INSERT INTO `admin` VALUES ('2', 'Tom', '123456', '托尼', '男', '22', '13433618925', '163585675@qq.com', '2018-12-06 17:34:05', null);
INSERT INTO `admin` VALUES ('3', 'CanJ', '123456', '风筝', '男', '21', '18025805131', '631968918@qq.com', '2018-12-06 17:34:05', null);

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cour_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `stu_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `cour_number` varchar(20) NOT NULL COMMENT '课程代号',
  `cour_name` varchar(10) NOT NULL COMMENT '课程名称',
  `cour_sort` varchar(10) NOT NULL COMMENT '类别',
  `cour_credit` int(11) NOT NULL COMMENT '学分',
  `cour_grade` int(11) NOT NULL COMMENT '分数',
  `teach_time` datetime NOT NULL COMMENT '上课时间',
  PRIMARY KEY (`cour_id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `stu_id` (`stu_id`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`),
  CONSTRAINT `course_ibfk_2` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '1', '1', '00213545', '高等数学', '必修', '4', '96', '2018-09-26 00:00:00');
INSERT INTO `course` VALUES ('2', '1', '2', '01048253', '数字电路', '必修', '4', '66', '2018-09-26 00:00:00');
INSERT INTO `course` VALUES ('3', '1', '3', '01048219', '工程制图', '必修', '5', '68', '2018-09-28 00:00:00');
INSERT INTO `course` VALUES ('4', '2', '1', '01052899', '数字电路', '必修', '3', '69', '2018-08-28 00:00:00');
INSERT INTO `course` VALUES ('5', '2', '2', '01048118', '蜡染技术', '必修', '1', '62', '2018-08-28 00:00:00');
INSERT INTO `course` VALUES ('11', '2', '8', '00700170', '电子技术', '必修', '3', '79', '2018-06-27 00:00:00');
INSERT INTO `course` VALUES ('13', '5', '2', '00700230', '数字电路', '必修', '3', '71', '2017-06-27 00:00:00');
INSERT INTO `course` VALUES ('14', '5', '3', '00900010', '工程制图', '必修', '3', '72', '2017-05-27 00:00:00');
INSERT INTO `course` VALUES ('15', '5', '9', '00900460', '机械制造', '必修', '4', '85', '2017-05-25 00:00:00');
INSERT INTO `course` VALUES ('16', '5', '8', '00800350', '工程制图', '必修', '4', '86', '2017-05-25 00:00:00');
INSERT INTO `course` VALUES ('17', '6', '10', '00900490', '机械系统', '必修', '5', '89', '2017-05-25 00:00:00');
INSERT INTO `course` VALUES ('18', '6', '3', '00900440', '工程制图', '选修', '5', '84', '2017-05-25 00:00:00');
INSERT INTO `course` VALUES ('19', '6', '4', '00900330', '材料成型', '必修', '5', '82', '2017-07-25 00:00:00');
INSERT INTO `course` VALUES ('28', '1', '4', '00102990', '高级会计', '必修', '1', '97', '2016-09-12 00:00:00');
INSERT INTO `course` VALUES ('29', '6', '6', '05000300', '微分方程', '必修', '2', '94', '2016-09-12 00:00:00');
INSERT INTO `course` VALUES ('31', '5', '5', '00500260', '复变函数', '必修', '4', '91', '2016-09-12 00:00:00');
INSERT INTO `course` VALUES ('33', '2', '3', '00101680', 'Java设计', '必修', '3', '93', '2016-09-18 00:00:00');
INSERT INTO `course` VALUES ('34', '1', '2', '021569', '大学英语', '必修', '3', '0', '2015-06-12 00:00:00');
INSERT INTO `course` VALUES ('35', '2', '2', '021569', '大学英语', '必修', '3', '0', '2015-06-12 00:00:00');
INSERT INTO `course` VALUES ('36', '1', '12', '1256685', '数学分析', '选修', '2', '0', '2018-12-06 00:00:00');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号id',
  `academy_id` int(11) NOT NULL,
  `stu_number` varchar(20) NOT NULL COMMENT '学号',
  `stu_name` varchar(10) NOT NULL COMMENT '姓名',
  `stu_gender` enum('男','女') NOT NULL DEFAULT '男' COMMENT '性别',
  `stu_birth` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '出生日期',
  `stu_addr` varchar(50) DEFAULT NULL COMMENT '生源地',
  PRIMARY KEY (`stu_id`),
  KEY `academy_id` (`academy_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`academy_id`) REFERENCES `academy` (`academy_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1', '3118002635', '李华', '男', '1998-03-19 00:00:00', '广东省茂名市荷花镇龙狮街56号');
INSERT INTO `student` VALUES ('2', '1', '3118002629', '刘星', '男', '1998-03-15 00:00:00', '广东省茂名市荷花镇龙狮街25号');
INSERT INTO `student` VALUES ('5', '5', '3118002623', '夏侯', '女', '1998-05-06 00:00:00', '广东省高州市根子镇上坑村35号');
INSERT INTO `student` VALUES ('6', '6', '3118002621', '小橘', '男', '1998-08-24 00:00:00', '广东省高州市根子镇上坑村25号');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师编号',
  `teach_number` varchar(15) NOT NULL COMMENT '教师代号',
  `academy_id` int(11) NOT NULL,
  `teach_name` varchar(20) NOT NULL COMMENT '教师姓名',
  `gender` enum('男','女') NOT NULL DEFAULT '男' COMMENT '性别',
  `nickname` varchar(20) DEFAULT NULL COMMENT '职称',
  PRIMARY KEY (`teacher_id`),
  KEY `academy_id` (`academy_id`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`academy_id`) REFERENCES `academy` (`academy_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '0125', '3', '谢天明', '男', '教授');
INSERT INTO `teacher` VALUES ('2', '0123', '3', '黄豪杰', '男', '教授');
INSERT INTO `teacher` VALUES ('3', '0121', '4', '狄仁杰', '男', '教授');
INSERT INTO `teacher` VALUES ('4', '0119', '4', '诸葛亮', '男', '讲师');
INSERT INTO `teacher` VALUES ('5', '0117', '4', '明世隐', '男', '讲师');
INSERT INTO `teacher` VALUES ('6', '0115', '4', '渣渣辉', '男', '博士');
INSERT INTO `teacher` VALUES ('7', '0113', '6', '易大师', '男', '博士');
INSERT INTO `teacher` VALUES ('8', '0111', '6', '公孙离', '女', '讲师');
INSERT INTO `teacher` VALUES ('9', '0109', '6', '凯特琳', '女', '教授');
INSERT INTO `teacher` VALUES ('10', '0107', '6', '金克斯', '女', '博士');
INSERT INTO `teacher` VALUES ('11', '0105', '6', '香吉士', '男', '讲师');
INSERT INTO `teacher` VALUES ('12', '0103', '9', '吕子乔', '男', '讲师');
INSERT INTO `teacher` VALUES ('13', '0101', '9', '孙尚香', '女', '教授');
INSERT INTO `teacher` VALUES ('14', '0102', '9', '蔡文姬', '女', '教授');
INSERT INTO `teacher` VALUES ('15', '0104', '9', '廖雪峰', '男', '教授');
INSERT INTO `teacher` VALUES ('16', '0106', '1', '毕向东', '男', '博士');
INSERT INTO `teacher` VALUES ('17', '0108', '1', '拉克丝', '女', '博士');
INSERT INTO `teacher` VALUES ('18', '0110', '1', '布鲁克', '男', '博士');
INSERT INTO `teacher` VALUES ('19', '0112', '1', '弗兰奇', '男', '讲师');
INSERT INTO `teacher` VALUES ('20', '0114', '2', '董必武', '男', '讲师');
INSERT INTO `teacher` VALUES ('21', '0116', '2', '肖晓峰', '男', '讲师');
INSERT INTO `teacher` VALUES ('22', '0118', '2', '吉格斯', '男', '教授');
