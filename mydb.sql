/*
 Navicat Premium Data Transfer

 Source Server         : Jak
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : mydb

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 08/01/2019 22:18:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `addrid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户地址id',
  `userid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `province` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省/直辖市',
  `city` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `region` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `postal` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮政编码',
  `consignee` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人姓名',
  `phone` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人电话',
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0默认地址 1非默认地址',
  `createdate` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`addrid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('2MBU9qeuITb2w74I', 'VXRc6Tr1VUzkyX0S', '上海市', '上海市市辖区', '宝山区', '福建/三明市/将乐县/高唐镇', '444333', '333', '15278766900', '0', '2019-01-07 22:25:03');
INSERT INTO `address` VALUES ('uRq28EK4KLhXxkd1', '8qDMDGlLie71ycHi', '山东省', '枣庄市', '山亭区', '福建/三明市/将乐县/高唐镇', '11', '111', '111', '1', '2018-12-17 22:03:55');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parentid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', NULL, '手机', NULL);
INSERT INTO `category` VALUES ('10', '2', '普通数码相机', NULL);
INSERT INTO `category` VALUES ('11', '2', '单反镜头', NULL);
INSERT INTO `category` VALUES ('12', '2', '数码单反', NULL);
INSERT INTO `category` VALUES ('13', '2', '佳能', NULL);
INSERT INTO `category` VALUES ('14', '3', '笔记本', NULL);
INSERT INTO `category` VALUES ('15', '3', '平板电脑', NULL);
INSERT INTO `category` VALUES ('16', '3', '台式机整机', NULL);
INSERT INTO `category` VALUES ('17', '3', '显示器', NULL);
INSERT INTO `category` VALUES ('18', '3', '鼠标', NULL);
INSERT INTO `category` VALUES ('19', '3', '显卡', NULL);
INSERT INTO `category` VALUES ('2', NULL, '相机', NULL);
INSERT INTO `category` VALUES ('20', '3', 'CPU', NULL);
INSERT INTO `category` VALUES ('21', '3', '主板', NULL);
INSERT INTO `category` VALUES ('3', NULL, '电脑', NULL);
INSERT INTO `category` VALUES ('4', NULL, '家电', NULL);
INSERT INTO `category` VALUES ('5', '1', '三星', NULL);
INSERT INTO `category` VALUES ('6', '1', '华为', NULL);
INSERT INTO `category` VALUES ('7', '1', '小米', NULL);
INSERT INTO `category` VALUES ('8', '1', '苹果', NULL);
INSERT INTO `category` VALUES ('9', '2', '索尼', NULL);

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(6000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sub` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `createBy` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('asdas', '222', 'qqq', 'www', NULL, NULL);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `proid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名',
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '种类',
  `price` double(10, 2) NOT NULL COMMENT '基本价格',
  `detail` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品详情',
  `createdate` datetime(0) NOT NULL,
  `updatedate` datetime(0) NOT NULL,
  `createby` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `updateby` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片路径',
  `userid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发布人ID',
  `hits` int(10) NULL DEFAULT 0 COMMENT '浏览量',
  `min_price` double(10, 2) NULL DEFAULT NULL COMMENT '最低价格',
  `max_price` double(10, 2) NULL DEFAULT NULL COMMENT '最高价格',
  `quality` int(5) NULL DEFAULT NULL COMMENT '数量',
  `faver` int(10) NULL DEFAULT NULL COMMENT '收藏',
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0正常  1下架  2售罄',
  `sellpoint` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`proid`) USING BTREE,
  INDEX `pro_user_key`(`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('2', 'qe', '5', 123.00, 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'VXRc6Tr1VUzkyX0S', 'qwe', 'img/product/product14.jpg', 'VXRc6Tr1VUzkyX0S', 18, NULL, NULL, 9, NULL, '1', NULL);
INSERT INTO `product` VALUES ('22', 'qe', '6', 123.00, 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', 'VXRc6Tr1VUzkyX0S', 9, NULL, NULL, 5, NULL, '0', NULL);
INSERT INTO `product` VALUES ('222', 'qe', '5', 123.00, 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', 'VXRc6Tr1VUzkyX0S', 18, NULL, NULL, 0, NULL, '0', NULL);
INSERT INTO `product` VALUES ('3', 'qe', '5', 123.00, 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product15.jpg', 'VXRc6Tr1VUzkyX0S', 11, NULL, NULL, 0, NULL, '0', NULL);
INSERT INTO `product` VALUES ('324', 'qe', '6', 123.00, 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', 'VXRc6Tr1VUzkyX0S', 96, NULL, NULL, 1, NULL, '0', NULL);
INSERT INTO `product` VALUES ('3CE6V48W6mbMzcyI', '1111', '7', 111.00, '', '2018-12-02 18:58:35', '2018-12-02 18:58:35', '1231231', '5681A4l5A9dx8usC', NULL, 'd:/data/upload/imagesq7O43pqDBdXvCzoA.jpg', 'VXRc6Tr1VUzkyX0S', 12, NULL, NULL, 9, NULL, '0', NULL);
INSERT INTO `product` VALUES ('3W0Sy9BmKkLKI1aJ', '三星手机特别版特别特别特别特别特别特别', '5', 222.22, NULL, '2018-12-02 16:38:37', '2018-12-02 16:38:37', '1231231', '5681A4l5A9dx8usC', NULL, NULL, 'VXRc6Tr1VUzkyX0S', 18, NULL, NULL, 0, NULL, '0', NULL);
INSERT INTO `product` VALUES ('4', 'qe', '5', 123.00, 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product16.jpg', '5681A4l5A9dx8usC', 9, NULL, NULL, 9, NULL, '0', NULL);
INSERT INTO `product` VALUES ('5', 'qe', '1', 123.00, 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product3.jpg', '5681A4l5A9dx8usC', 9, NULL, NULL, 9, NULL, '0', NULL);
INSERT INTO `product` VALUES ('6', 'qe', '1', 123.00, 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product5.jpg', '5681A4l5A9dx8usC', 9, NULL, NULL, 9, NULL, '0', NULL);
INSERT INTO `product` VALUES ('6vO0S8suF5q164BK', '111', '7', 111.00, '<span style=\"background-color:#FFFFFF;\">阿瓦大大</span><span style=\"background-color:#FFFFFF;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 啊飒飒大阿萨德阿萨<img src=\"http://localhost/cpts_1293_byy/resource/kindeditor/plugins/emoticons/images/10.gif\" border=\"0\" alt=\"\" />德阿萨德</span>', '2018-12-02 16:42:25', '2018-12-02 16:42:25', '1231231', '5681A4l5A9dx8usC', NULL, NULL, '5681A4l5A9dx8usC', 9, NULL, NULL, 9, NULL, '0', NULL);
INSERT INTO `product` VALUES ('7', 'qe', '1', 123.00, 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', '5681A4l5A9dx8usC', 9, NULL, NULL, 9, NULL, '0', NULL);
INSERT INTO `product` VALUES ('9', 'qe', '1', 123.00, 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', '5681A4l5A9dx8usC', 9, NULL, NULL, 9, NULL, '0', NULL);
INSERT INTO `product` VALUES ('Ao6P3XcuE8OY9J66', '1111', '7', 111.00, '123123', '2018-12-02 19:01:39', '2018-12-02 19:01:39', '1231231', '5681A4l5A9dx8usC', NULL, 'd:/data/upload/imagesC81v9Sz17zJ24Naz.jpg', '5681A4l5A9dx8usC', 9, NULL, NULL, 9, NULL, '0', NULL);
INSERT INTO `product` VALUES ('B4jqyhkY9b3y177V', '1111', '7', 111.00, '', '2018-12-02 18:58:35', '2018-12-02 18:58:35', '1231231', '5681A4l5A9dx8usC', NULL, 'd:/data/upload/images2iB87PTSmqnz0aXI.jpg', '5681A4l5A9dx8usC', 9, NULL, NULL, 9, NULL, '0', NULL);
INSERT INTO `product` VALUES ('eee', 'qe', '1', 123.00, 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', '5681A4l5A9dx8usC', 9, NULL, NULL, 9, NULL, '0', NULL);
INSERT INTO `product` VALUES ('G5U12iTh9s146BD4', '小米MIX', '7', 2009.00, ',<p style=\"color:#404040;font-family:tahoma, arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">\r\n	<img src=\"https://img.alicdn.com/imgextra/i2/370627083/O1CN01SifQv922C3ooY6DAp_!!370627083.jpg\" alt=\"\" class=\"img-ks-lazyload\" /><img src=\"https://img.alicdn.com/imgextra/i3/370627083/TB27._Ja3mTBuNjy1XbXXaMrVXa-370627083.jpg\" class=\"img-ks-lazyload\" />\r\n</p>\r\n<p style=\"color:#404040;font-family:tahoma, arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\">\r\n	<img src=\"https://img.alicdn.com/imgextra/i1/370627083/TB28adUaOMnBKNjSZFzXXc_qVXa-370627083.jpg\" class=\"img-ks-lazyload\" />\r\n</p>', '2018-12-17 22:56:55', '2018-12-17 22:56:55', 'qwe', '8qDMDGlLie71ycHi', NULL, 'WF1xS18U96F1wKMx.png', 'VXRc6Tr1VUzkyX0S', 9, NULL, NULL, 0, NULL, '0', NULL);
INSERT INTO `product` VALUES ('ID3WJCoT9kkB69TJ', '三星手机', '15', 1677.00, ',小米手机就是好用', '2018-12-20 23:31:16', '2018-12-20 23:31:16', 'qwe', '8qDMDGlLie71ycHi', NULL, 'nc34mV8CA4G7S0gs.jpg', 'VXRc6Tr1VUzkyX0S', 20, NULL, NULL, 33, NULL, '0', NULL);
INSERT INTO `product` VALUES ('jf1yTXwWb5lqW0Od', '三星手机', '5', 1299.00, '', '2018-12-17 22:50:07', '2018-12-17 22:50:07', 'qwe', '8qDMDGlLie71ycHi', NULL, 'nBcYf635obkxo5E2.jpg', 'VXRc6Tr1VUzkyX0S', 16, NULL, NULL, 99, NULL, '0', NULL);
INSERT INTO `product` VALUES ('k095y8S6uy7iB5X6', '1111', '7', 111.00, '123123', '2018-12-02 19:01:39', '2018-12-02 19:01:39', '1231231', '5681A4l5A9dx8usC', NULL, 'd:/data/upload/imagesvyU24DE171W16LnH.jpg', '5681A4l5A9dx8usC', 12, NULL, NULL, 7, NULL, '0', NULL);
INSERT INTO `product` VALUES ('sad', 'qe', '1', 123.00, 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', 'img/product/product1.jpg', '5681A4l5A9dx8usC', 9, NULL, NULL, 9, NULL, '0', NULL);
INSERT INTO `product` VALUES ('VPOtuTS5DLD1oL5j', '三星手机', '5', 222.22, NULL, '2018-12-02 16:37:23', '2018-12-02 16:37:23', '1231231', '5681A4l5A9dx8usC', NULL, NULL, '5681A4l5A9dx8usC', 9, NULL, NULL, 11, NULL, '0', NULL);

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart`  (
  `cartid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `quantity` int(10) NULL DEFAULT NULL,
  `total` float NULL DEFAULT NULL,
  `productid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ischeck` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否选中0选中  1未选中',
  `createdate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`cartid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------
INSERT INTO `shoppingcart` VALUES ('RgrPN3fE92N83r9M', '8qDMDGlLie71ycHi', 2, 3354, 'ID3WJCoT9kkB69TJ', '1', NULL);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家id',
  `sellid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '卖家id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '订单创建时间',
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0未发货 1已发货 2已确认',
  `productid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品id',
  `quantity` int(10) NULL DEFAULT NULL COMMENT '商品数量',
  `payment` double(10, 2) NULL DEFAULT NULL COMMENT '实付金额',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '订单更新时间',
  `address_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址id',
  `confirm_time` datetime(0) NULL DEFAULT NULL COMMENT '订单确认时间',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('20181210202016039', '8qDMDGlLie71ycHi', '5681A4l5A9dx8usC', '2018-12-10 20:20:16', '0', 'k095y8S6uy7iB5X6', 2, 222.00, NULL, 'feyp8471R0QIQ3kb', NULL);
INSERT INTO `t_order` VALUES ('20181211164543984', '8qDMDGlLie71ycHi', '5681A4l5A9dx8usC', '2018-12-11 16:45:44', '0', '22', 3, 369.00, NULL, 'feyp8471R0QIQ3kb', NULL);
INSERT INTO `t_order` VALUES ('20181211164650571', '8qDMDGlLie71ycHi', '5681A4l5A9dx8usC', '2018-12-11 16:46:51', '0', '22', 3, 369.00, NULL, 'feyp8471R0QIQ3kb', NULL);
INSERT INTO `t_order` VALUES ('20181213225720689', '8qDMDGlLie71ycHi', '5681A4l5A9dx8usC', '2018-12-13 22:57:20', '0', '222', 5, 615.00, NULL, 'feyp8471R0QIQ3kb', NULL);
INSERT INTO `t_order` VALUES ('20181214204933284', '8qDMDGlLie71ycHi', '5681A4l5A9dx8usC', '2018-12-14 20:49:33', '0', '324', 3, 369.00, NULL, 'feyp8471R0QIQ3kb', NULL);
INSERT INTO `t_order` VALUES ('20181215183944749', '8qDMDGlLie71ycHi', '5681A4l5A9dx8usC', '2018-12-15 18:39:45', '0', '324', 3, 369.00, NULL, 'xN86AWA7K17G6i61', NULL);
INSERT INTO `t_order` VALUES ('20181215183944867', '8qDMDGlLie71ycHi', '5681A4l5A9dx8usC', '2018-12-15 18:39:45', '0', '3W0Sy9BmKkLKI1aJ', 1, 222.22, NULL, 'xN86AWA7K17G6i61', NULL);
INSERT INTO `t_order` VALUES ('20181215184058535', '8qDMDGlLie71ycHi', '5681A4l5A9dx8usC', '2018-12-15 18:40:58', '0', '3W0Sy9BmKkLKI1aJ', 1, 222.22, NULL, 'bc6zkrl8xB3sK44U', NULL);
INSERT INTO `t_order` VALUES ('20181215184058705', '8qDMDGlLie71ycHi', '5681A4l5A9dx8usC', '2018-12-15 18:40:58', '0', '324', 3, 369.00, NULL, 'bc6zkrl8xB3sK44U', NULL);
INSERT INTO `t_order` VALUES ('20181215190121911', '8qDMDGlLie71ycHi', '5681A4l5A9dx8usC', '2018-12-15 19:01:21', '0', '3', 9, 1107.00, NULL, 'uj0lHf9Ryf6M6UwH', NULL);
INSERT INTO `t_order` VALUES ('20181217231203858', '8qDMDGlLie71ycHi', '8qDMDGlLie71ycHi', '2018-12-17 23:12:04', '0', 'G5U12iTh9s146BD4', 1, 2009.00, NULL, 'uRq28EK4KLhXxkd1', NULL);
INSERT INTO `t_order` VALUES ('20181217231240576', '8qDMDGlLie71ycHi', '8qDMDGlLie71ycHi', '2018-12-17 23:12:40', '0', 'G5U12iTh9s146BD4', 1, 2009.00, NULL, 'uRq28EK4KLhXxkd1', NULL);
INSERT INTO `t_order` VALUES ('20181220232556162', '8qDMDGlLie71ycHi', '5681A4l5A9dx8usC', '2018-12-20 23:25:57', '0', '3W0Sy9BmKkLKI1aJ', 6, 1333.32, NULL, 'uRq28EK4KLhXxkd1', NULL);
INSERT INTO `t_order` VALUES ('20181220232632699', '8qDMDGlLie71ycHi', '5681A4l5A9dx8usC', '2018-12-20 23:26:33', '0', '3W0Sy9BmKkLKI1aJ', 2, 444.44, NULL, 'uRq28EK4KLhXxkd1', NULL);
INSERT INTO `t_order` VALUES ('20181222185415163', '8qDMDGlLie71ycHi', '5681A4l5A9dx8usC', '2018-12-22 18:54:16', '0', '3W0Sy9BmKkLKI1aJ', 9, 1999.98, NULL, 'uRq28EK4KLhXxkd1', NULL);

-- ----------------------------
-- Table structure for t_order_item1
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item1`;
CREATE TABLE `t_order_item1`  (
  `order_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家id',
  `address_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址id',
  `payment` float(10, 2) NULL DEFAULT NULL COMMENT '总额',
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  ` shipments_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `confirm_time` datetime(0) NULL DEFAULT NULL COMMENT '确认订单时间',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0男 1女',
  `img` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `state` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '0正常 1冻结 2未激活',
  `loginName` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `activeCode` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '激活码',
  `activeDate` datetime(0) NULL DEFAULT NULL COMMENT '激活日期',
  `adreess` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `tel` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `lastLoginTime` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `usertype` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0会员 1管理员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5681A4l5A9dx8usC', '1231231', 'ca0ac53949a35994a756c957db0f713e', '1', NULL, '2018-09-10 12:33:15', '0', '1231231', NULL, NULL, NULL, NULL, '2018-12-15 18:23:56', NULL, '0');
INSERT INTO `user` VALUES ('8qDMDGlLie71ycHi', '日日', '6e0c7f934fd8b6af270c766ec7319e36', '0', '5WaP599FW3WY32KS.png', '2018-12-03 23:01:15', '0', '851276240@163.com', '', '2018-12-03 23:28:07', NULL, '112123123', '2018-12-27 20:50:19', '851276240@163.com', '0');
INSERT INTO `user` VALUES ('9xBYQxT9Zu6Y91Gt', '111', 'ca0ac53949a35994a756c957db0f713e', '0', NULL, '2018-10-18 12:33:12', '0', '', NULL, NULL, NULL, NULL, NULL, '11', '0');
INSERT INTO `user` VALUES ('9xBYQxT9Zu6Y92w', 'admin', 'ca0ac53949a35994a756c957db0f713e', '1', NULL, NULL, '0', 'admin', NULL, NULL, NULL, '1111', '2018-12-25 22:53:51', '1111', '1');
INSERT INTO `user` VALUES ('I9WnIP6gPpl6Hi4j', NULL, 'ca0ac53949a35994a756c957db0f713e', NULL, NULL, '2019-01-01 23:32:51', '0', '18877493149@163.com', NULL, NULL, NULL, NULL, NULL, '18877493149@163.com', NULL);
INSERT INTO `user` VALUES ('VXRc6Tr1VUzkyX0S', 'adm', 'ca0ac53949a35994a756c957db0f713e', '0', NULL, '2018-12-26 23:02:17', '0', '851276240@qq.com', NULL, NULL, NULL, '13155651234', '2019-01-07 22:01:58', '851276240@qq.com', NULL);

SET FOREIGN_KEY_CHECKS = 1;
