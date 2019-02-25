/*
Navicat MySQL Data Transfer

Source Server         : joo
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2019-02-25 18:17:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `addrid` varchar(64) NOT NULL,
  `userid` varchar(64) DEFAULT NULL,
  `province` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `region` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `postal` varchar(255) DEFAULT NULL,
  `consignee` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `status` varchar(1) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  PRIMARY KEY (`addrid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', 'x0hM65ThZCnnRkOz', '1', '1', '1', '1', '1', '1', '1', '1', '2019-01-30 16:04:35');
INSERT INTO `address` VALUES ('22222', 'iYvI399GqOvDvM6I', '辽宁省', '鞍山市', '铁西区', '11', '1', '1', '1', '0', '2019-02-18 10:35:55');
INSERT INTO `address` VALUES ('o315H22255710Ci5', 'iYvI399GqOvDvM6I', '辽宁省', '鞍山市', '铁西区', '11', '1', '1', '1', '0', '2019-02-18 10:35:55');
INSERT INTO `address` VALUES ('o315HPi855710Ci5', 'iYvI399GqOvDvM6I', '辽宁省', '鞍山市', '铁西区', '11', '1', '1', '1', '0', '2019-02-18 10:35:55');

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` varchar(64) NOT NULL,
  `image` varchar(100) DEFAULT NULL,
  `is_show` varchar(1) DEFAULT NULL,
  `is_top` varchar(1) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `link_url` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES ('3J0fBy5OuKkA4ezh', '11', 'q', '1', 'www', 'sss', null, null, null, null);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` varchar(64) NOT NULL,
  `parentid` varchar(64) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
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
  `title` varchar(200) NOT NULL,
  `content` varchar(6000) NOT NULL,
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
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `proid` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `category` varchar(30) DEFAULT NULL,
  `price` double(10,2) NOT NULL,
  `detail` varchar(4000) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `createby` varchar(255) DEFAULT NULL,
  `updateby` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `userid` varchar(64) DEFAULT NULL COMMENT '卖家',
  `hits` int(10) DEFAULT '0' COMMENT '浏览量',
  `min_price` float(10,2) DEFAULT NULL COMMENT '最低价格(拍卖时候使用)',
  `faver` int(8) DEFAULT NULL COMMENT '收藏数',
  `status` varchar(1) DEFAULT NULL COMMENT '0正常  1下架  2售罄',
  `sellpoint` varchar(60) DEFAULT NULL COMMENT '商品卖点(不可超过30个字)',
  `max_price` float(10,2) DEFAULT NULL COMMENT '最高价格（当前如果是最高价格拍卖时间减少为剩余时间的50%）',
  `quality` int(10) DEFAULT '0' COMMENT '数量',
  `isNotAuction` varchar(1) DEFAULT '' COMMENT '是否拍卖商品 0否 1是',
  `increments` float(10,2) DEFAULT NULL COMMENT '每次叫价最低',
  `currentBidder` varchar(255) DEFAULT NULL COMMENT '当前竞价人',
  `bidderId` varchar(255) DEFAULT NULL COMMENT '竞价人id',
  `outTime` varchar(255) DEFAULT NULL COMMENT '竞拍结束时间',
  PRIMARY KEY (`proid`),
  KEY `pro_user_key` (`userid`),
  KEY `product_cate` (`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('07Cy73hwub01w88G', '222', '16', '998.00', '/></span></s></u></em></strong>', '2019-01-21 15:21:42', '2019-01-21 15:21:42', '123123', 'x0hM65ThZCnnRkOz', null, '48PSE570HS1DEkS1.jpg', 'x0hM65ThZCnnRkOz', '15', null, null, '0', null, null, '66', null, null, null, null, null);
INSERT INTO `product` VALUES ('0tJQ0641wQ4mdq8C', 'smelz', '21', '11111.00', '/></span></s></u></em></strong>', '2019-01-21 15:27:56', '2019-01-21 15:27:56', '123123', 'x0hM65ThZCnnRkOz', null, '48PSE570HS1DEkS1.jpg', 'x0hM65ThZCnnRkOz', '4', null, null, '0', null, null, '33', null, null, null, null, null);
INSERT INTO `product` VALUES ('1', '三星百', '1', '123.00', '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', '5681A4l5A9dx8usC', '3', null, null, '', null, null, '99', null, null, null, null, null);
INSERT INTO `product` VALUES ('10', '三星百', '2', '123.00', '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product10.jpg', '5681A4l5A9dx8usC', '30', null, null, '', null, null, '87', null, null, null, null, null);
INSERT INTO `product` VALUES ('11', '三星百', '3', '123.00', '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product11.jpg', '5681A4l5A9dx8usC', '6', null, null, '', null, null, '99', null, null, null, null, null);
INSERT INTO `product` VALUES ('12', '三星百', '4', '123.00', '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product12.jpg', '5681A4l5A9dx8usC', '19', null, null, '', null, null, '99', null, null, null, null, null);
INSERT INTO `product` VALUES ('19', '三星百', '1', '123.00', '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product13.jpg', '5681A4l5A9dx8usC', '6', null, null, '0', null, null, '99', null, null, null, null, null);
INSERT INTO `product` VALUES ('2', '三星百', '1', '123.00', '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product14.jpg', '5681A4l5A9dx8usC', '8', null, null, '0', null, null, '86', null, null, null, null, null);
INSERT INTO `product` VALUES ('222', '三星百', '1', '123.00', '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', '5681A4l5A9dx8usC', '6', null, null, '0', null, null, '99', null, null, null, null, null);
INSERT INTO `product` VALUES ('2BRM88uP40Vy40YU', '8', '12', '1.00', '/></span></s></u></em></strong>', '2019-01-21 15:45:33', '2019-01-21 15:45:33', null, null, null, '48PSE570HS1DEkS1.jpg', null, '5', null, null, '0', null, null, '1', null, null, null, null, null);
INSERT INTO `product` VALUES ('3', '三星百', '1', '123.00', '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product15.jpg', '5681A4l5A9dx8usC', '7', null, null, '0', null, null, '99', null, null, null, null, null);
INSERT INTO `product` VALUES ('4', '三星百', '1', '123.00', '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product16.jpg', '5681A4l5A9dx8usC', '6', null, null, '0', null, null, '99', null, null, null, null, null);
INSERT INTO `product` VALUES ('5', '三星百', '1', '123.00', '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product3.jpg', '5681A4l5A9dx8usC', '7', null, null, '0', null, null, '99', null, null, null, null, null);
INSERT INTO `product` VALUES ('6', '三星百', '1', '123.00', '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product5.jpg', '5681A4l5A9dx8usC', '7', null, null, '0', null, null, '99', null, null, null, null, null);
INSERT INTO `product` VALUES ('7', '三星百', '1', '123.00', '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', '5681A4l5A9dx8usC', '6', null, null, '0', null, null, '99', null, null, null, null, null);
INSERT INTO `product` VALUES ('7Dlbk58NtzB4EKB3', '8', '12', '1.00', '/></span></s></u></em></strong>', '2019-01-21 15:32:34', '2019-01-21 15:32:34', '123123', 'x0hM65ThZCnnRkOz', null, '48PSE570HS1DEkS1.jpg', 'x0hM65ThZCnnRkOz', '2', null, null, '0', null, null, '1', null, null, null, null, null);
INSERT INTO `product` VALUES ('7hb5CkpKe0zF3jN3', '10', '16', '123.00', '12额2而且<span style=\"line-height:2;\"><img src=\"http://localhost/cpts_1293_byy/resource/kindeditor/plugins/emoticons/images/27.gif\" border=\"0\" alt=\"\" /></span>', '2019-01-21 15:49:40', '2019-01-21 15:49:40', null, null, null, 'BrDr8YCDvd0MWE63.jpg', null, '1', null, null, '0', null, null, '66', null, null, null, null, null);
INSERT INTO `product` VALUES ('7j507wmM1S91sv91', '111', '7', '11.00', '/></span></s></u></em></strong>', '2019-01-18 09:49:08', '2019-01-18 09:49:08', '123123', 'x0hM65ThZCnnRkOz', null, '48PSE570HS1DEkS1.jpg', 'x0hM65ThZCnnRkOz', '7', null, null, '0', null, null, '99', null, null, null, null, null);
INSERT INTO `product` VALUES ('88gwB3FPOzADd039', 'qqq', '21', '998.00', '/></span></s></u></em></strong>', '2019-01-21 15:24:58', '2019-01-21 15:24:58', '123123', 'x0hM65ThZCnnRkOz', null, '48PSE570HS1DEkS1.jpg', 'x0hM65ThZCnnRkOz', '3', null, null, '0', null, null, '66', null, null, null, null, null);
INSERT INTO `product` VALUES ('8QqQEZr4zt05PSkd', '10', '18', '0.00', '2222222', '2019-01-21 15:50:13', '2019-01-21 15:50:13', null, null, null, 'tH3Xgu57U4yIiK20.jpg', null, '6', null, null, '2', null, null, '0', null, null, null, null, null);
INSERT INTO `product` VALUES ('9', '三星百', '1', '123.00', 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', '5681A4l5A9dx8usC', '8', null, null, '0', null, null, '95', null, null, null, null, null);
INSERT INTO `product` VALUES ('BE7VhTHIrUGsktx9', '222', '17', '11111.00', '/></span></s></u></em></strong>', '2019-01-18 10:00:59', '2019-01-18 10:00:59', '123123', 'x0hM65ThZCnnRkOz', null, '48PSE570HS1DEkS1.jpg', 'x0hM65ThZCnnRkOz', '2', null, null, null, null, null, '66', null, null, null, null, null);
INSERT INTO `product` VALUES ('cMA45vea90SugK8W', '22222222', '13', '998.00', '/></span></s></u></em></strong>', '2019-01-18 09:57:49', '2019-01-18 09:57:49', '123123', 'x0hM65ThZCnnRkOz', null, '48PSE570HS1DEkS1.jpg', 'x0hM65ThZCnnRkOz', '4', null, null, '0', null, null, '66', null, null, null, null, null);
INSERT INTO `product` VALUES ('eee', '三星百', '1', '123.00', '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', '5681A4l5A9dx8usC', '6', null, null, '0', null, null, '99', null, null, null, null, null);
INSERT INTO `product` VALUES ('eee111', '小米', '1', '123.00', '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', '5681A4l5A9dx8usC', '8', null, null, '0', '', null, '99', null, null, null, null, null);
INSERT INTO `product` VALUES ('hgE0iVafIF73k4j2', 'qqq', '21', '998.00', '/></span></s></u></em></strong>', '2019-01-21 15:25:10', '2019-01-21 15:25:10', '123123', 'x0hM65ThZCnnRkOz', null, '48PSE570HS1DEkS1.jpg', 'x0hM65ThZCnnRkOz', '2', null, null, '0', null, null, '66', null, null, null, null, null);
INSERT INTO `product` VALUES ('Ie2b5Fl2jXiEL8Hg', '王大有', '14', '119.00', '<em>qwe qwe qwe <span style=\"background-color:#E53333;\"></span>wwwwwwwwww<span style=\"color:#006600;\">wwwwww</span></em>', '2019-02-13 15:51:10', '2019-02-13 15:51:10', null, 'iYvI399GqOvDvM6I', null, null, 'iYvI399GqOvDvM6I', '4', null, null, '0', null, null, '27', null, null, null, null, null);
INSERT INTO `product` VALUES ('kFQfYA78oS115plk', 'shshww', '17', '119.00', '/></span></s></u></em></strong>', '2019-01-21 15:19:39', '2019-01-21 15:19:39', '123123', 'x0hM65ThZCnnRkOz', null, '48PSE570HS1DEkS1.jpg', 'x0hM65ThZCnnRkOz', '1', null, null, '1', null, null, '33', null, null, null, null, null);
INSERT INTO `product` VALUES ('Na56e90AJ9H93unE', '调通', '17', '1111.00', '<p style=\"text-align:center;\">\r\n	这是一款很漂亮的\r\n</p>\r\n<p style=\"text-align:center;\">\r\n	<img src=\"http://localhost/cpts_1293_byy/resource/kindeditor/plugins/emoticons/images/10.gif\" border=\"0\" alt=\"\" />\r\n</p>', '2019-01-21 16:09:21', '2019-01-21 16:09:21', '123123', 'x0hM65ThZCnnRkOz', null, 'QLbpMV43xgMdH5Ak.png', 'x0hM65ThZCnnRkOz', '8', null, null, '0', null, null, '26', null, null, null, null, null);
INSERT INTO `product` VALUES ('oFuZuT24W4j7TaQS', '111', '19', '119.00', '/></span></s></u></em></strong>', '2019-01-21 15:22:34', '2019-01-21 15:22:34', '123123', 'x0hM65ThZCnnRkOz', null, '48PSE570HS1DEkS1.jpg', 'x0hM65ThZCnnRkOz', '2', null, null, '0', null, null, '33', null, null, null, null, null);
INSERT INTO `product` VALUES ('sad', '三星百', '1', '123.00', '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', '5681A4l5A9dx8usC', '6', null, null, '0', null, null, '99', null, null, null, null, null);
INSERT INTO `product` VALUES ('tGz83EiT49mu3lSn', '10', '18', '0.00', '<strong><em><u><s><span style=\"line-height:1;\">2222222<img src=\"http://localhost/cpts_1293_byy/resource/kindeditor/plugins/emoticons/images/18.gif\" border=\"0\" alt=\"\" /></span></s></u></em></strong>', '2019-01-21 15:50:38', '2019-01-21 15:50:38', null, null, null, '48PSE570HS1DEkS1.jpg', null, '8', null, null, '0', null, null, '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart` (
  `cartid` varchar(64) NOT NULL,
  `userid` varchar(64) NOT NULL,
  `quantity` int(10) DEFAULT NULL,
  `total` float(8,0) DEFAULT NULL COMMENT '单项单价',
  `productid` varchar(64) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `ischeck` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`cartid`),
  KEY `cart_user` (`userid`),
  KEY `cart_product` (`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` varchar(64) NOT NULL,
  `userid` varchar(64) DEFAULT NULL COMMENT '买家id',
  `sellid` varchar(64) DEFAULT NULL COMMENT '卖家id',
  `create_time` datetime DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL COMMENT '0待付款 1未发货 2已发货 3未签收 4已签收',
  `productid` varchar(64) DEFAULT NULL COMMENT '订单id',
  `quantity` int(10) DEFAULT NULL COMMENT '数量',
  `payment` int(10) DEFAULT NULL COMMENT '总价',
  `update_time` datetime DEFAULT NULL,
  `address_id` varchar(255) DEFAULT NULL,
  `confirm_time` datetime DEFAULT NULL COMMENT '订单确认时间',
  `price` float(10,2) DEFAULT NULL COMMENT '单价',
  PRIMARY KEY (`order_id`),
  KEY `order_user_buy` (`userid`) USING BTREE,
  KEY `sellid` (`sellid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '1', '1', '2018-11-21 17:14:13', '1', null, null, null, null, null, null, null);
INSERT INTO `t_order` VALUES ('11', '111', '1111', '2018-11-21 17:26:51', '1', null, null, null, null, null, null, null);
INSERT INTO `t_order` VALUES ('20181121172943123', '5681A4l5A9dx8usC', 'h8MwxUZ19I2LIwdV', '2018-11-21 17:29:43', '0', 'sad', null, null, null, null, null, null);
INSERT INTO `t_order` VALUES ('20190115105324131', 'x0hM65ThZCnnRkOz', '5681A4l5A9dx8usC', '2019-01-15 10:53:24', '0', '12', '1', '123', null, '9j49PnKT2OxcIJqP', null, null);
INSERT INTO `t_order` VALUES ('20190115105332153', 'x0hM65ThZCnnRkOz', '5681A4l5A9dx8usC', '2019-01-15 10:53:32', '0', '12', '1', '123', null, '9j49PnKT2OxcIJqP', null, null);
INSERT INTO `t_order` VALUES ('20190115105603279', 'x0hM65ThZCnnRkOz', '5681A4l5A9dx8usC', '2019-01-15 10:56:03', '0', '12', '1', '123', null, '9j49PnKT2OxcIJqP', null, null);
INSERT INTO `t_order` VALUES ('20190115105650036', 'x0hM65ThZCnnRkOz', '5681A4l5A9dx8usC', '2019-01-15 10:56:50', '0', '11', '1', '123', null, '9j49PnKT2OxcIJqP', null, null);
INSERT INTO `t_order` VALUES ('20190115110217579', 'x0hM65ThZCnnRkOz', '5681A4l5A9dx8usC', '2019-01-15 11:02:17', '0', '11', '2', '246', null, '9j49PnKT2OxcIJqP', null, null);
INSERT INTO `t_order` VALUES ('20190116143502217', 'x0hM65ThZCnnRkOz', '5681A4l5A9dx8usC', '2019-01-16 14:35:02', '0', '9', '4', '492', null, '9j49PnKT2OxcIJqP', null, null);
INSERT INTO `t_order` VALUES ('20190116143502884', 'x0hM65ThZCnnRkOz', '5681A4l5A9dx8usC', '2019-01-16 14:35:02', '0', '2', '5', '615', null, '9j49PnKT2OxcIJqP', null, null);
INSERT INTO `t_order` VALUES ('20190130160534824', 'x0hM65ThZCnnRkOz', null, '2019-01-30 16:05:34', '0', '8QqQEZr4zt05PSkd', '2', '0', null, '1', null, null);
INSERT INTO `t_order` VALUES ('20190130160839000', 'x0hM65ThZCnnRkOz', null, '2019-01-30 16:08:39', '0', '8QqQEZr4zt05PSkd', '2', '0', null, 'o315H22255710Ci5', null, null);
INSERT INTO `t_order` VALUES ('20190130161232984', 'x0hM65ThZCnnRkOz', null, '2019-01-30 16:12:32', '0', '8QqQEZr4zt05PSkd', '2', '0', null, '1', null, null);
INSERT INTO `t_order` VALUES ('20190130161303943', 'x0hM65ThZCnnRkOz', null, '2019-01-30 16:13:03', '0', '8QqQEZr4zt05PSkd', '2', '0', null, '1', null, null);
INSERT INTO `t_order` VALUES ('20190214155640407', 'iYvI399GqOvDvM6I', '5681A4l5A9dx8usC', '2019-02-14 15:56:40', '0', '10', '12', '1476', null, 'o315H22255710Ci5', null, null);
INSERT INTO `t_order` VALUES ('20190214155659049', 'iYvI399GqOvDvM6I', '5681A4l5A9dx8usC', '2019-02-14 15:56:59', '0', '10', '12', '1476', null, 'o315H22255710Ci5', null, null);
INSERT INTO `t_order` VALUES ('20190218093713560', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-02-18 09:37:13', '0', 'Ie2b5Fl2jXiEL8Hg', '1', '119', null, 'o315H22255710Ci5', null, null);
INSERT INTO `t_order` VALUES ('20190218093910795', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-02-18 09:39:10', '0', 'Ie2b5Fl2jXiEL8Hg', '1', '119', null, 'o315H22255710Ci5', null, null);
INSERT INTO `t_order` VALUES ('20190218094100781', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-02-18 09:41:00', '0', 'Ie2b5Fl2jXiEL8Hg', '1', '119', null, 'o315H22255710Ci5', null, null);
INSERT INTO `t_order` VALUES ('20190218094121368', 'iYvI399GqOvDvM6I', 'x0hM65ThZCnnRkOz', '2019-02-18 09:41:21', '0', 'Na56e90AJ9H93unE', '1', '1111', null, 'o315H22255710Ci5', null, null);
INSERT INTO `t_order` VALUES ('20190218094617668', 'iYvI399GqOvDvM6I', 'x0hM65ThZCnnRkOz', '2019-02-18 09:46:17', '0', 'Na56e90AJ9H93unE', '1', '1111', null, 'o315H22255710Ci5', null, null);
INSERT INTO `t_order` VALUES ('20190218094818183', 'iYvI399GqOvDvM6I', 'x0hM65ThZCnnRkOz', '2019-02-18 09:48:18', '0', 'Na56e90AJ9H93unE', '1', '1111', null, 'o315H22255710Ci5', null, null);
INSERT INTO `t_order` VALUES ('20190218095331834', 'iYvI399GqOvDvM6I', 'x0hM65ThZCnnRkOz', '2019-02-18 09:53:31', '0', 'Na56e90AJ9H93unE', '1', '1111', null, 'o315H22255710Ci5', null, null);
INSERT INTO `t_order` VALUES ('20190218095509802', 'iYvI399GqOvDvM6I', 'x0hM65ThZCnnRkOz', '2019-02-18 09:55:09', '0', 'Na56e90AJ9H93unE', '2', '2222', null, 'o315H22255710Ci5', null, null);
INSERT INTO `t_order` VALUES ('20190218095658196', 'iYvI399GqOvDvM6I', 'x0hM65ThZCnnRkOz', '2019-02-18 09:56:58', '0', 'Na56e90AJ9H93unE', '1', '1111', null, 'o315H22255710Ci5', null, null);
INSERT INTO `t_order` VALUES ('20190218100318286', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-02-18 10:03:18', '0', 'Ie2b5Fl2jXiEL8Hg', '1', '119', null, 'o315H22255710Ci5', null, null);
INSERT INTO `t_order` VALUES ('20190218100349386', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-02-18 10:03:49', '0', 'Ie2b5Fl2jXiEL8Hg', '1', '119', null, 'o315H22255710Ci5', null, null);
INSERT INTO `t_order` VALUES ('20190218100507104', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-02-18 10:05:07', '0', 'Ie2b5Fl2jXiEL8Hg', '2', '238', null, 'o315H22255710Ci5', null, null);
INSERT INTO `t_order` VALUES ('20190218100655708', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-02-18 10:06:55', '0', 'Ie2b5Fl2jXiEL8Hg', '2', '238', null, 'o315H22255710Ci5', null, null);
INSERT INTO `t_order` VALUES ('20190218100750033', 'iYvI399GqOvDvM6I', null, '2019-02-18 10:07:50', '0', 'tGz83EiT49mu3lSn', '1', '0', null, 'o315H22255710Ci5', null, null);
INSERT INTO `t_order` VALUES ('20190218151230162', 'iYvI399GqOvDvM6I', '5681A4l5A9dx8usC', '2019-02-18 15:12:30', '0', '2', '8', '984', null, 'o315H22255710Ci5', null, null);

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
  `state` varchar(1) DEFAULT '0' COMMENT '0正常  1冻结  2未激活',
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `loginname` varchar(18) NOT NULL,
  `email` varchar(64) DEFAULT NULL,
  `usertype` varchar(1) DEFAULT NULL COMMENT '0普通用户  1系统用户',
  `activeCode` varchar(50) DEFAULT NULL,
  `activeDate` datetime DEFAULT NULL,
  `adreess` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('9xBYQxT9Zu6Y91Gt', 'NaN', '202cb962ac59075b964b07152d234b70', '0', null, '2018-10-18 12:33:12', '0', null, null, null, '123', null, '0', null, null, null, null, null);
INSERT INTO `user` VALUES ('FXC96CHW0Q2A1OHr', '65261', 'e10adc3949ba59abbe56e057f20f883e', '0', 'Kmwqgk1c32i441FT.jpg', '2018-10-17 12:33:09', '0', null, null, null, '123', null, '0', null, null, null, null, null);
INSERT INTO `user` VALUES ('h8MwxUZ19I2LIwdV', '123123', 'ca0ac53949a35994a756c957db0f713e', '0', null, '2018-10-10 12:33:04', '0', null, null, null, '132', null, '0', null, null, null, null, null);
INSERT INTO `user` VALUES ('iYvI399GqOvDvM6I', '一笑倾', '4280dd4b137e5235245b248039867a7c', '0', '9hkat2VS0Nf995yQ.jpg', '2019-02-12 10:48:33', '0', null, null, null, '851276240@qq.com', '851276240@qq.com', '0', '', null, null, '1', '2019-02-25 11:20:49');
INSERT INTO `user` VALUES ('NyVcmY0sJBHmwKE6', '123', '4297f44b13955235245b2497399d7a93', '0', null, '2018-10-01 17:47:20', '0', null, null, null, '123', null, '0', null, null, null, null, null);
INSERT INTO `user` VALUES ('TCI6qWC391l9912t', '15462', 'ca0ac53949a35994a756c957db0f713e', '1', 'G:\\data\\upload\\images\\6O0Iaqj1dd7c3130.jpg', '2018-10-17 17:47:13', '0', null, null, null, '123', null, '0', null, null, null, null, null);
INSERT INTO `user` VALUES ('x0hM65ThZCnnRkOz', '123123', '4280dd4b137e5235245b248039867a7c', '0', 'cE8hsscwqX4FjeYn.jpg', null, '0', null, null, null, 'admin', '8@163.com', '1', null, null, null, '18076606840', '2019-02-25 14:09:54');
