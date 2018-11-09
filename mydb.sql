/*
Navicat MySQL Data Transfer

Source Server         : joo
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2018-11-09 11:03:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` varchar(64) NOT NULL,
  `parentid` varchar(64) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_chil` (`parentid`),
  CONSTRAINT `parent_chil` FOREIGN KEY (`parentid`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', null, '手机', null);
INSERT INTO `category` VALUES ('10', '2', '普通数码相机', null);
INSERT INTO `category` VALUES ('11', '2', '单反镜头', null);
INSERT INTO `category` VALUES ('12', '2', '数码单反', null);
INSERT INTO `category` VALUES ('13', '2', '佳能', null);
INSERT INTO `category` VALUES ('14', '3', '笔记本', null);
INSERT INTO `category` VALUES ('15', '3', '平板电脑', null);
INSERT INTO `category` VALUES ('16', '3', '台式机整机', null);
INSERT INTO `category` VALUES ('17', '3', '显示器', null);
INSERT INTO `category` VALUES ('18', '3', '鼠标', null);
INSERT INTO `category` VALUES ('19', '3', '显卡', null);
INSERT INTO `category` VALUES ('2', null, '相机', null);
INSERT INTO `category` VALUES ('20', '3', 'CPU', null);
INSERT INTO `category` VALUES ('21', '3', '主板', null);
INSERT INTO `category` VALUES ('3', null, '电脑', null);
INSERT INTO `category` VALUES ('4', null, '家电', null);
INSERT INTO `category` VALUES ('5', '1', '三星', null);
INSERT INTO `category` VALUES ('6', '1', '华为', null);
INSERT INTO `category` VALUES ('7', '1', '小米', null);
INSERT INTO `category` VALUES ('8', '1', '苹果', null);
INSERT INTO `category` VALUES ('9', '2', '索尼', null);

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` varchar(64) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `content` varchar(6000) DEFAULT NULL,
  `sub` varchar(200) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `createby` varchar(64) DEFAULT NULL,
  `updateby` varchar(64) DEFAULT NULL,
  `istop` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('asdas', '222', 'qqq', 'www', null, null, null, null, null);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` varchar(64) NOT NULL,
  `userid` varchar(64) NOT NULL COMMENT '买家id',
  `sellid` varchar(64) NOT NULL COMMENT '卖家id',
  `createdate` datetime DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL COMMENT '0未发货 1已发货 2已签收 3未签收',
  `name` varchar(50) DEFAULT NULL,
  `productid` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_user_buy` (`userid`) USING BTREE,
  KEY `sellid` (`sellid`),
  KEY `order_pro` (`productid`),
  CONSTRAINT `order_pro` FOREIGN KEY (`productid`) REFERENCES `product` (`id`),
  CONSTRAINT `order_user` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
  CONSTRAINT `order_user_sell` FOREIGN KEY (`sellid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `category` varchar(30) DEFAULT NULL,
  `price` double(10,2) NOT NULL,
  `detail` varchar(5000) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `createby` varchar(255) DEFAULT NULL,
  `updateby` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `userid` varchar(64) DEFAULT NULL COMMENT '卖家',
  `hits` int(10) DEFAULT '0' COMMENT '浏览量',
  `minprice` float(10,2) DEFAULT NULL COMMENT '最低价格(拍卖时候使用)',
  `faver` int(8) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL COMMENT '0正常  1下架  2售罄',
  `sellpoint` varchar(60) DEFAULT NULL COMMENT '商品卖点(不可超过30个字)',
  PRIMARY KEY (`id`),
  KEY `pro_user_key` (`userid`),
  KEY `product_cate` (`category`),
  CONSTRAINT `product_cate` FOREIGN KEY (`category`) REFERENCES `category` (`id`),
  CONSTRAINT `pro_user_key` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'qe', '1', '123.00', 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', '5681A4l5A9dx8usC', null, null, null, '', null);
INSERT INTO `product` VALUES ('10', 'qe', '2', '123.00', 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product10.jpg', '5681A4l5A9dx8usC', null, null, null, '', null);
INSERT INTO `product` VALUES ('11', 'qe', '3', '123.00', 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product11.jpg', '5681A4l5A9dx8usC', null, null, null, '', null);
INSERT INTO `product` VALUES ('12', 'qe', '4', '123.00', 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product12.jpg', '5681A4l5A9dx8usC', null, null, null, '', null);
INSERT INTO `product` VALUES ('19', 'qe', '1', '123.00', 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product13.jpg', '5681A4l5A9dx8usC', null, null, null, '', null);
INSERT INTO `product` VALUES ('2', 'qe', '1', '123.00', 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product14.jpg', '5681A4l5A9dx8usC', null, null, null, '', null);
INSERT INTO `product` VALUES ('222', 'qe', '1', '123.00', 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', '5681A4l5A9dx8usC', null, null, null, '', null);
INSERT INTO `product` VALUES ('3', 'qe', '1', '123.00', 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product15.jpg', '5681A4l5A9dx8usC', null, null, null, '', null);
INSERT INTO `product` VALUES ('4', 'qe', '1', '123.00', 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product16.jpg', '5681A4l5A9dx8usC', null, null, null, '', null);
INSERT INTO `product` VALUES ('5', 'qe', '1', '123.00', 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product3.jpg', '5681A4l5A9dx8usC', null, null, null, '', null);
INSERT INTO `product` VALUES ('6', 'qe', '1', '123.00', 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product5.jpg', '5681A4l5A9dx8usC', null, null, null, '', null);
INSERT INTO `product` VALUES ('7', 'qe', '1', '123.00', 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', '5681A4l5A9dx8usC', null, null, null, '', null);
INSERT INTO `product` VALUES ('9', 'qe', '1', '123.00', 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', '5681A4l5A9dx8usC', null, null, null, '', null);
INSERT INTO `product` VALUES ('eee', 'qe', '1', '123.00', 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', '5681A4l5A9dx8usC', null, null, null, '', null);
INSERT INTO `product` VALUES ('sad', 'qe', '1', '123.00', 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', '5681A4l5A9dx8usC', null, null, null, '', null);

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart` (
  `id` varchar(64) NOT NULL,
  `userid` varchar(64) NOT NULL,
  `quantity` int(10) DEFAULT NULL,
  `total` float(8,0) DEFAULT NULL COMMENT '单项单价',
  `productid` varchar(64) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cart_user` (`userid`),
  KEY `cart_product` (`productid`),
  CONSTRAINT `cart_product` FOREIGN KEY (`productid`) REFERENCES `product` (`id`),
  CONSTRAINT `cart_user` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(64) NOT NULL,
  `username` varchar(18) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `state` varchar(1) DEFAULT '0' COMMENT '0正常  1冻结  2停用',
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `loginname` varchar(18) NOT NULL,
  `email` varchar(64) DEFAULT NULL,
  `type` varchar(1) DEFAULT NULL COMMENT '0普通用户  1系统用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5681A4l5A9dx8usC', '1231231', '202cb962ac59075b964b07152d234b70', '1', null, '2018-09-10 12:33:15', null, null, null, null, '123', null, null);
INSERT INTO `user` VALUES ('9xBYQxT9Zu6Y91Gt', 'NaN', '202cb962ac59075b964b07152d234b70', '0', null, '2018-10-18 12:33:12', null, null, null, null, '123', null, null);
INSERT INTO `user` VALUES ('FXC96CHW0Q2A1OHr', '65261', 'e10adc3949ba59abbe56e057f20f883e', '0', 'Kmwqgk1c32i441FT.jpg', '2018-10-17 12:33:09', null, null, null, null, '123', null, null);
INSERT INTO `user` VALUES ('h8MwxUZ19I2LIwdV', '123123', 'ca0ac53949a35994a756c957db0f713e', '0', null, '2018-10-10 12:33:04', null, null, null, null, '132', null, null);
INSERT INTO `user` VALUES ('NyVcmY0sJBHmwKE6', '123', '4297f44b13955235245b2497399d7a93', '0', null, '2018-10-01 17:47:20', null, null, null, null, '123', null, null);
INSERT INTO `user` VALUES ('TCI6qWC391l9912t', '15462', 'e10adc3949ba59abbe56e057f20f883e', '1', 'G:\\data\\upload\\images\\6O0Iaqj1dd7c3130.jpg', '2018-10-17 17:47:13', null, null, null, null, '123', null, null);
INSERT INTO `user` VALUES ('x0hM65ThZCnnRkOz', '123123', '4280dd4b137e5235245b248039867a7c', '0', 'd:/data/upload/imagesUTto02aKh0359I80.jpg', null, null, null, null, null, '123123', null, null);
