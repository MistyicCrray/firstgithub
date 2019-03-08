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

 Date: 07/03/2019 19:52:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `addrid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `region` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `postal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `consignee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createdate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`addrid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', 'x0hM65ThZCnnRkOz', '1', '1', '1', '1', '1', '1', '1', '1', '2019-01-30 16:04:35');
INSERT INTO `address` VALUES ('5fI6033E64B1E5Ve', 'iYvI399GqOvDvM6I', '辽宁省', '丹东市', '宽甸满族自治县', '123', '123', '123', '123', '0', '2019-03-05 22:23:02');
INSERT INTO `address` VALUES ('C3cL77H6ggH88193', 'iYvI399GqOvDvM6I', '江苏省', '苏州市', '常熟市', '123', '123', '3213', '123123213', '1', '2019-03-05 22:24:30');
INSERT INTO `address` VALUES ('ftiXto68DWXq02Dg', 'iYvI399GqOvDvM6I', '黑龙江省', '伊春市', '友好区', 'qwe', '123123', '123123', '123123', '1', '2019-03-05 22:23:34');
INSERT INTO `address` VALUES ('nzCVbBB3yj7cI3zG', 'iYvI399GqOvDvM6I', '山西省', '朔州市', '山阴县', '1', '1', '1', '1', '1', '2019-03-05 22:22:16');
INSERT INTO `address` VALUES ('Qm72A5oSwM6Ynn6J', 'iYvI399GqOvDvM6I', '辽宁省', '锦州市', '义县', '地址', '344672', '黄亮兴', '18877493149', '1', '2019-03-05 22:21:06');

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_show` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_top` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `link_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES ('3J0fBy5OuKkA4ezh', '11', 'q', '1', 'www', 'sss', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parentid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `parent_chil`(`parentid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1001', '0', '手机', NULL);
INSERT INTO `category` VALUES ('100100', '1001', '三星', NULL);
INSERT INTO `category` VALUES ('100101', '1001', '华为', NULL);
INSERT INTO `category` VALUES ('100102', '1001', '小米', NULL);
INSERT INTO `category` VALUES ('100103', '1001', '苹果', NULL);
INSERT INTO `category` VALUES ('1002', '0', '相机', NULL);
INSERT INTO `category` VALUES ('100200', '1002', '普通数码相机', NULL);
INSERT INTO `category` VALUES ('100201', '1002', '单反镜头', NULL);
INSERT INTO `category` VALUES ('100202', '1002', '数码单反', NULL);
INSERT INTO `category` VALUES ('100203', '1002', '佳能', NULL);
INSERT INTO `category` VALUES ('100204', '1002', '索尼', NULL);
INSERT INTO `category` VALUES ('1003', '0', '电脑', NULL);
INSERT INTO `category` VALUES ('100300', '1003', '笔记本', NULL);
INSERT INTO `category` VALUES ('100301', '1003', '平板电脑', NULL);
INSERT INTO `category` VALUES ('100302', '1003', '台式机整机', NULL);
INSERT INTO `category` VALUES ('100303', '1003', '显示器', NULL);
INSERT INTO `category` VALUES ('100304', '1003', '鼠标', NULL);
INSERT INTO `category` VALUES ('100305', '1003', '显卡', NULL);
INSERT INTO `category` VALUES ('100306', '1003', 'CPU', NULL);
INSERT INTO `category` VALUES ('100307', '1003', '主板', NULL);
INSERT INTO `category` VALUES ('1004', '0', '家电', NULL);

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(6000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sub` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createdate` datetime(0) NULL DEFAULT NULL,
  `updatedate` datetime(0) NULL DEFAULT NULL,
  `createby` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updateby` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `istop` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('asdas', '222', 'qqq', 'www', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `proid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `category` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double(10, 2) NOT NULL,
  `detail` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createdate` datetime(0) NULL DEFAULT NULL,
  `updatedate` datetime(0) NULL DEFAULT NULL,
  `createby` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `updateby` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卖家',
  `hits` int(10) NULL DEFAULT 0 COMMENT '浏览量',
  `min_price` float(10, 2) NULL DEFAULT NULL COMMENT '最低价格(拍卖时候使用)',
  `faver` int(8) NULL DEFAULT NULL COMMENT '收藏数',
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0正常  1下架  2售罄',
  `sellpoint` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品卖点(不可超过30个字)',
  `max_price` float(10, 2) NULL DEFAULT NULL COMMENT '最高价格（当前如果是最高价格拍卖时间减少为剩余时间的50%）',
  `quality` int(10) NULL DEFAULT 0 COMMENT '数量',
  `isNotAuction` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '是否拍卖商品 0否 1是',
  `increments` float(10, 2) NULL DEFAULT NULL COMMENT '每次叫价最低',
  `currentBidder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前竞价人',
  `bidderId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '竞价人id',
  `outTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '竞拍结束时间',
  `auctionStatus` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '竞拍状态',
  PRIMARY KEY (`proid`) USING BTREE,
  INDEX `pro_user_key`(`userid`) USING BTREE,
  INDEX `product_cate`(`category`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('07Cy73hwub01w88G', '222', '16', 998.00, '/></span></s></u></em></strong>', '2019-01-21 15:21:42', '2019-01-21 15:21:42', '123123', 'x0hM65ThZCnnRkOz', NULL, '123.jpg', 'x0hM65ThZCnnRkOz', 15, NULL, NULL, '0', NULL, NULL, 66, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('0tJQ0641wQ4mdq8C', 'smelz', '21', 11111.00, '/></span></s></u></em></strong>', '2019-01-21 15:27:56', '2019-01-21 15:27:56', '123123', 'x0hM65ThZCnnRkOz', NULL, '123.jpg', 'x0hM65ThZCnnRkOz', 4, NULL, NULL, '0', NULL, NULL, 33, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('1', '三星百', '1', 123.00, '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', '123.jpg', '5681A4l5A9dx8usC', 3, NULL, NULL, '', NULL, NULL, 99, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('10', '三星百', '2', 123.00, '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', '123.jpg', '5681A4l5A9dx8usC', 30, NULL, NULL, '', NULL, NULL, 87, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('11', '三星百', '3', 123.00, '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', '123.jpg', '5681A4l5A9dx8usC', 6, NULL, NULL, '', NULL, NULL, 99, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('12', '三星百', '4', 123.00, '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', '123.jpg', '5681A4l5A9dx8usC', 19, NULL, NULL, '', NULL, NULL, 99, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('19', '三星百', '1', 123.00, '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', '123.jpg', '5681A4l5A9dx8usC', 6, NULL, NULL, '0', NULL, NULL, 99, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('2', '三星百', '1', 123.00, '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', '123.jpg', '5681A4l5A9dx8usC', 8, NULL, NULL, '0', NULL, NULL, 86, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('222', '三星百', '1', 123.00, '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', '123.jpg', '5681A4l5A9dx8usC', 6, NULL, NULL, '0', NULL, NULL, 99, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('2BRM88uP40Vy40YU', '8', '12', 1.00, '/></span></s></u></em></strong>', '2019-01-21 15:45:33', '2019-01-21 15:45:33', NULL, NULL, NULL, '123.jpg', NULL, 5, NULL, NULL, '0', NULL, NULL, 1, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('3', '三星百', '1', 123.00, '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', '123.jpg', '5681A4l5A9dx8usC', 7, NULL, NULL, '0', NULL, NULL, 99, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('4', '三星百', '1', 123.00, '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', '123.jpg', '5681A4l5A9dx8usC', 6, NULL, NULL, '0', NULL, NULL, 99, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('5', '三星百', '1', 123.00, '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', '123.jpg', '5681A4l5A9dx8usC', 7, NULL, NULL, '0', NULL, NULL, 99, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('6', '三星百', '1', 123.00, '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', '123.jpg', '5681A4l5A9dx8usC', 7, NULL, NULL, '0', NULL, NULL, 99, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('7', '三星百', '1', 123.00, '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', '123.jpg', '5681A4l5A9dx8usC', 6, NULL, NULL, '0', NULL, NULL, 99, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('7Dlbk58NtzB4EKB3', '8', '12', 1.00, '/></span></s></u></em></strong>', '2019-01-21 15:32:34', '2019-01-21 15:32:34', '123123', 'x0hM65ThZCnnRkOz', NULL, '123.jpg', 'x0hM65ThZCnnRkOz', 2, NULL, NULL, '0', NULL, NULL, 1, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('7hb5CkpKe0zF3jN3', '10', '16', 123.00, '12额2而且<span style=\"line-height:2;\"><img src=\"http://localhost/cpts_1293_byy/resource/kindeditor/plugins/emoticons/images/27.gif\" border=\"0\" alt=\"\" /></span>', '2019-01-21 15:49:40', '2019-01-21 15:49:40', NULL, NULL, NULL, '123.jpg', NULL, 2, NULL, NULL, '0', NULL, NULL, 66, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('7j507wmM1S91sv91', '111', '7', 11.00, '/></span></s></u></em></strong>', '2019-01-18 09:49:08', '2019-01-18 09:49:08', '123123', 'x0hM65ThZCnnRkOz', NULL, '123.jpg', 'x0hM65ThZCnnRkOz', 10, NULL, NULL, '0', NULL, NULL, 96, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('88gwB3FPOzADd039', 'qqq', '21', 998.00, '/></span></s></u></em></strong>', '2019-01-21 15:24:58', '2019-01-21 15:24:58', '123123', 'x0hM65ThZCnnRkOz', NULL, '123.jpg', 'x0hM65ThZCnnRkOz', 3, NULL, NULL, '0', NULL, NULL, 66, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('8QqQEZr4zt05PSkd', '10', '18', 0.00, '2222222', '2019-01-21 15:50:13', '2019-01-21 15:50:13', NULL, NULL, NULL, '123.jpg', NULL, 8, NULL, NULL, '2', NULL, NULL, 0, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('9', '三星百', '1', 123.00, 'qwe', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', '123.jpg', '5681A4l5A9dx8usC', 9, NULL, NULL, '0', NULL, NULL, 93, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('BE7VhTHIrUGsktx9', '222', '17', 11111.00, '/></span></s></u></em></strong>', '2019-01-18 10:00:59', '2019-01-18 10:00:59', '123123', 'x0hM65ThZCnnRkOz', NULL, '123.jpg', 'x0hM65ThZCnnRkOz', 2, NULL, NULL, NULL, NULL, NULL, 66, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('cMA45vea90SugK8W', '22222222', '13', 998.00, '/></span></s></u></em></strong>', '2019-01-18 09:57:49', '2019-01-18 09:57:49', '123123', 'x0hM65ThZCnnRkOz', NULL, '123.jpg', 'x0hM65ThZCnnRkOz', 4, NULL, NULL, '0', NULL, NULL, 66, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('CUufBZrv1pVD3MT1', 'Xiaomi/小米 小米8 屏幕指纹版全面屏智能拍照游戏手机官方正品', '7', 109.00, '<div id=\"attributes\" class=\"attributes\" style=\"padding:10px;font-family:tahoma, arial, &quot;background-color:#FFFFFF;\">\r\n	<div id=\"tb_attributes\" class=\"tb-attributes\">\r\n		<h3 class=\"tb-attributes-title\" style=\"font-size:12px;font-weight:normal;\">\r\n			产品参数<a class=\"tb-attributes-more\">更多参数</a>\r\n		</h3>\r\n		<ul class=\"tb-attributes-list tb-attributes-fix\">\r\n			<li style=\"text-indent:5px;\">\r\n				<img src=\"https://gd1.alicdn.com/bao/uploaded/TB1hRW7IpXXXXXHXpXX760XFXXX\" alt=\"基本信息\" style=\"width:32px;height:32px;\" />\r\n				<p>\r\n					品牌: Xiaomi/小米\r\n				</p>\r\n				<p>\r\n					型号: 小米8 屏幕指纹版\r\n				</p>\r\n			</li>\r\n			<li style=\"text-indent:5px;\">\r\n				<img src=\"https://gd1.alicdn.com/bao/uploaded/TB14LG.IpXXXXbfXpXX760XFXXX\" alt=\"屏幕\" style=\"width:32px;height:32px;\" />\r\n				<p>\r\n					分辨率: 2248x1080\r\n				</p>\r\n			</li>\r\n			<li style=\"text-indent:5px;\">\r\n				<img src=\"https://gd1.alicdn.com/bao/uploaded/TB1kW11IpXXXXbVXFXX760XFXXX\" alt=\"网络\" style=\"width:32px;height:32px;\" />\r\n				<p>\r\n					网络类型: 4G全网通\r\n				</p>\r\n				<p>\r\n					网络模式: 双卡双待\r\n				</p>\r\n			</li>\r\n			<li style=\"text-indent:5px;\">\r\n				<img src=\"https://gd1.alicdn.com/bao/uploaded/TB1LfniIpXXXXaYXXXX760XFXXX\" alt=\"CPU信息\" style=\"width:32px;height:32px;\" />\r\n				<p>\r\n					核心数: 八核 最高主频2.8GHz\r\n				</p>\r\n			</li>\r\n			<li style=\"text-indent:5px;\">\r\n				<img src=\"https://gd1.alicdn.com/bao/uploaded/TB13LiTIpXXXXbPXVXX760XFXXX\" alt=\"存储\" style=\"width:32px;height:32px;\" />\r\n				<p>\r\n					运行内存RAM: 6GB 8GB\r\n				</p>\r\n				<p>\r\n					存储容量: 256GB\r\n				</p>\r\n			</li>\r\n			<li style=\"text-indent:5px;\">\r\n				<img src=\"https://gd1.alicdn.com/bao/uploaded/TB10U53IpXXXXbrXFXX760XFXXX\" alt=\"拍照\" style=\"width:32px;height:32px;\" />\r\n				<p>\r\n					后置摄像头: 1200万+1200万双摄\r\n				</p>\r\n				<p>\r\n					摄像头类型: 三摄像头（后双）\r\n				</p>\r\n			</li>\r\n		</ul>\r\n		<ul class=\"tb-attributes-sell tb-attributes-fix\">\r\n			<li>\r\n				机身颜色: 小米8黑色6G+256G 小米8蓝色6G+256G 小米8白色6G+256G\r\n			</li>\r\n			<li>\r\n				套餐类型: 官方标配\r\n			</li>\r\n			<li>\r\n				售后服务: 全国联保\r\n			</li>\r\n			<li>\r\n				版本类型: 中国大陆\r\n			</li>\r\n		</ul>\r\n	</div>\r\n</div>\r\n<div id=\"tad_second_area\" class=\"tad-stage\" style=\"font-family:tahoma, arial, &quot;background-color:#FFFFFF;\">\r\n</div>\r\n<div id=\"description\" class=\"J_DetailSection tshop-psm ke-post\" style=\"font-size:14px;font-family:tahoma, arial, 宋体, sans-serif;background:#FFFFFF !important;\">\r\n	<div id=\"J_DivItemDesc\" class=\"content\" style=\"padding:10px 0px 0px;\">\r\n		<p>\r\n			<img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/4074624802/O1CN013C1kF31lLMP9Wj8Nc_!!4074624802.jpg\" /><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/4074624802/O1CN01wRPW3M1lLMP802PaM_!!4074624802.jpg\" /><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/4074624802/O1CN01SfXzmg1lLMP8Y91Sh_!!4074624802.jpg\" /><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/4074624802/O1CN01E375yQ1lLMP4rHzg1_!!4074624802.jpg\" /><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/4074624802/O1CN01gMM6Ve1lLMP0TNPDG_!!4074624802.jpg\" class=\"\" /><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/4074624802/O1CN01WhwkrN1lLMP5Ym70W_!!4074624802.jpg\" class=\"\" />\r\n		</p>\r\n	</div>\r\n</div>', '2019-03-04 21:34:50', '2019-03-04 21:34:50', '一笑倾', 'iYvI399GqOvDvM6I', NULL, '123.jpg', 'iYvI399GqOvDvM6I', 11, 109.00, NULL, '0', NULL, NULL, 1, '1', 100.00, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('eee', '三星百', '1', 123.00, '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', '123.jpg', '5681A4l5A9dx8usC', 6, NULL, NULL, '0', NULL, NULL, 99, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('eee111', '小米', '1', 123.00, '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', '123.jpg', '5681A4l5A9dx8usC', 9, NULL, NULL, '0', '', NULL, 98, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('hgE0iVafIF73k4j2', 'qqq', '21', 998.00, '/></span></s></u></em></strong>', '2019-01-21 15:25:10', '2019-01-21 15:25:10', '123123', 'x0hM65ThZCnnRkOz', NULL, '123.jpg', 'x0hM65ThZCnnRkOz', 2, NULL, NULL, '0', NULL, NULL, 66, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('Ie2b5Fl2jXiEL8Hg', '王大有', '14', 119.00, '<em>qwe qwe qwe <span style=\"background-color:#E53333;\"></span>wwwwwwwwww<span style=\"color:#006600;\">wwwwww</span></em>', '2019-02-13 15:51:10', '2019-02-13 15:51:10', NULL, 'iYvI399GqOvDvM6I', NULL, '123.jpg', 'iYvI399GqOvDvM6I', 81, NULL, NULL, '0', NULL, NULL, 23, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('kFQfYA78oS115plk', 'shshww', '17', 119.00, '/></span></s></u></em></strong>', '2019-01-21 15:19:39', '2019-01-21 15:19:39', '123123', 'x0hM65ThZCnnRkOz', NULL, '123.jpg', 'x0hM65ThZCnnRkOz', 1, NULL, NULL, '1', NULL, NULL, 33, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('Na56e90AJ9H93unE', '调通', '17', 1111.00, '<p style=\"text-align:center;\">\r\n	这是一款很漂亮的\r\n</p>\r\n<p style=\"text-align:center;\">\r\n	<img src=\"http://localhost/cpts_1293_byy/resource/kindeditor/plugins/emoticons/images/10.gif\" border=\"0\" alt=\"\" />\r\n</p>', '2019-01-21 16:09:21', '2019-01-21 16:09:21', '123123', 'x0hM65ThZCnnRkOz', NULL, '123.jpg', 'x0hM65ThZCnnRkOz', 9, NULL, NULL, '0', NULL, NULL, 25, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('oFuZuT24W4j7TaQS', '111', '19', 119.00, '/></span></s></u></em></strong>', '2019-01-21 15:22:34', '2019-01-21 15:22:34', '123123', 'x0hM65ThZCnnRkOz', NULL, '123.jpg', 'x0hM65ThZCnnRkOz', 2, NULL, NULL, '0', NULL, NULL, 33, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('sad', '三星百', '1', 123.00, '/></span></s></u></em></strong>', '2018-10-09 14:01:21', '2018-10-09 14:01:18', 'we', 'qwe', 'qwe', '123.jpg', '5681A4l5A9dx8usC', 6, NULL, NULL, '0', NULL, NULL, 99, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES ('tGz83EiT49mu3lSn', '10', '18', 0.00, '<strong><em><u><s><span style=\"line-height:1;\">2222222<img src=\"http://localhost/cpts_1293_byy/resource/kindeditor/plugins/emoticons/images/18.gif\" border=\"0\" alt=\"\" /></span></s></u></em></strong>', '2019-01-21 15:50:38', '2019-01-21 15:50:38', NULL, NULL, NULL, '123.jpg', NULL, 11, NULL, NULL, '0', NULL, NULL, 1, '0', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart`  (
  `cartid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `quantity` int(10) NULL DEFAULT NULL,
  `total` float(8, 0) NULL DEFAULT NULL COMMENT '单项单价',
  `productid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createdate` datetime(0) NULL DEFAULT NULL,
  `ischeck` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cartid`) USING BTREE,
  INDEX `cart_user`(`userid`) USING BTREE,
  INDEX `cart_product`(`productid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家id',
  `sellid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卖家id',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0待付款 1未发货 2已发货 3未签收 4已签收',
  `productid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单id',
  `quantity` int(10) NULL DEFAULT NULL COMMENT '数量',
  `payment` int(10) NULL DEFAULT NULL COMMENT '总价',
  `update_time` datetime(0) NULL DEFAULT NULL,
  `address_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `confirm_time` datetime(0) NULL DEFAULT NULL COMMENT '订单确认时间',
  `price` float(10, 2) NULL DEFAULT NULL COMMENT '单价',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `order_user_buy`(`userid`) USING BTREE,
  INDEX `sellid`(`sellid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '1', '1', '2018-11-21 17:14:13', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_order` VALUES ('11', '111', '1111', '2018-11-21 17:26:51', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_order` VALUES ('20181121172943123', '5681A4l5A9dx8usC', 'h8MwxUZ19I2LIwdV', '2018-11-21 17:29:43', '0', 'sad', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_order` VALUES ('20190115105324131', 'x0hM65ThZCnnRkOz', '5681A4l5A9dx8usC', '2019-01-15 10:53:24', '0', '12', 1, 123, NULL, '9j49PnKT2OxcIJqP', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190115105332153', 'x0hM65ThZCnnRkOz', '5681A4l5A9dx8usC', '2019-01-15 10:53:32', '0', '12', 1, 123, NULL, '9j49PnKT2OxcIJqP', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190115105603279', 'x0hM65ThZCnnRkOz', '5681A4l5A9dx8usC', '2019-01-15 10:56:03', '0', '12', 1, 123, NULL, '9j49PnKT2OxcIJqP', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190115105650036', 'x0hM65ThZCnnRkOz', '5681A4l5A9dx8usC', '2019-01-15 10:56:50', '0', '11', 1, 123, NULL, '9j49PnKT2OxcIJqP', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190115110217579', 'x0hM65ThZCnnRkOz', '5681A4l5A9dx8usC', '2019-01-15 11:02:17', '0', '11', 2, 246, NULL, '9j49PnKT2OxcIJqP', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190116143502217', 'x0hM65ThZCnnRkOz', '5681A4l5A9dx8usC', '2019-01-16 14:35:02', '0', '9', 4, 492, NULL, '9j49PnKT2OxcIJqP', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190116143502884', 'x0hM65ThZCnnRkOz', '5681A4l5A9dx8usC', '2019-01-16 14:35:02', '0', '2', 5, 615, NULL, '9j49PnKT2OxcIJqP', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190130160534824', 'x0hM65ThZCnnRkOz', NULL, '2019-01-30 16:05:34', '0', '8QqQEZr4zt05PSkd', 2, 0, NULL, '1', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190130160839000', 'x0hM65ThZCnnRkOz', NULL, '2019-01-30 16:08:39', '0', '8QqQEZr4zt05PSkd', 2, 0, NULL, 'o315H22255710Ci5', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190130161232984', 'x0hM65ThZCnnRkOz', NULL, '2019-01-30 16:12:32', '0', '8QqQEZr4zt05PSkd', 2, 0, NULL, '1', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190130161303943', 'x0hM65ThZCnnRkOz', NULL, '2019-01-30 16:13:03', '0', '8QqQEZr4zt05PSkd', 2, 0, NULL, '1', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190214155640407', 'iYvI399GqOvDvM6I', '5681A4l5A9dx8usC', '2019-02-14 15:56:40', '0', '10', 12, 1476, NULL, 'o315H22255710Ci5', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190214155659049', 'iYvI399GqOvDvM6I', '5681A4l5A9dx8usC', '2019-02-14 15:56:59', '0', '10', 12, 1476, NULL, 'o315H22255710Ci5', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190218093713560', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-02-18 09:37:13', '0', 'Ie2b5Fl2jXiEL8Hg', 1, 119, NULL, 'o315H22255710Ci5', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190218093910795', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-02-18 09:39:10', '0', 'Ie2b5Fl2jXiEL8Hg', 1, 119, NULL, 'o315H22255710Ci5', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190218094100781', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-02-18 09:41:00', '0', 'Ie2b5Fl2jXiEL8Hg', 1, 119, NULL, 'o315H22255710Ci5', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190218094121368', 'iYvI399GqOvDvM6I', 'x0hM65ThZCnnRkOz', '2019-02-18 09:41:21', '0', 'Na56e90AJ9H93unE', 1, 1111, NULL, 'o315H22255710Ci5', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190218094617668', 'iYvI399GqOvDvM6I', 'x0hM65ThZCnnRkOz', '2019-02-18 09:46:17', '0', 'Na56e90AJ9H93unE', 1, 1111, NULL, 'o315H22255710Ci5', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190218094818183', 'iYvI399GqOvDvM6I', 'x0hM65ThZCnnRkOz', '2019-02-18 09:48:18', '0', 'Na56e90AJ9H93unE', 1, 1111, NULL, 'o315H22255710Ci5', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190218095331834', 'iYvI399GqOvDvM6I', 'x0hM65ThZCnnRkOz', '2019-02-18 09:53:31', '0', 'Na56e90AJ9H93unE', 1, 1111, NULL, 'o315H22255710Ci5', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190218095509802', 'iYvI399GqOvDvM6I', 'x0hM65ThZCnnRkOz', '2019-02-18 09:55:09', '0', 'Na56e90AJ9H93unE', 2, 2222, NULL, 'o315H22255710Ci5', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190218095658196', 'iYvI399GqOvDvM6I', 'x0hM65ThZCnnRkOz', '2019-02-18 09:56:58', '0', 'Na56e90AJ9H93unE', 1, 1111, NULL, 'o315H22255710Ci5', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190218100318286', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-02-18 10:03:18', '0', 'Ie2b5Fl2jXiEL8Hg', 1, 119, NULL, 'o315H22255710Ci5', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190218100349386', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-02-18 10:03:49', '0', 'Ie2b5Fl2jXiEL8Hg', 1, 119, NULL, 'o315H22255710Ci5', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190218100507104', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-02-18 10:05:07', '0', 'Ie2b5Fl2jXiEL8Hg', 2, 238, NULL, 'o315H22255710Ci5', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190218100655708', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-02-18 10:06:55', '0', 'Ie2b5Fl2jXiEL8Hg', 2, 238, NULL, 'o315H22255710Ci5', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190218100750033', 'iYvI399GqOvDvM6I', NULL, '2019-02-18 10:07:50', '0', 'tGz83EiT49mu3lSn', 1, 0, NULL, 'o315H22255710Ci5', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190218151230162', 'iYvI399GqOvDvM6I', '5681A4l5A9dx8usC', '2019-02-18 15:12:30', '0', '2', 8, 984, NULL, 'o315H22255710Ci5', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190302212900101', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-03-02 21:29:01', '0', 'Ie2b5Fl2jXiEL8Hg', 4, 476, NULL, '22222', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190302231449995', 'iYvI399GqOvDvM6I', 'x0hM65ThZCnnRkOz', '2019-03-02 23:14:49', '0', '7j507wmM1S91sv91', 1, 11, NULL, 'Y4y5KR8T0V0Xe8D5', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190302231539340', 'iYvI399GqOvDvM6I', 'x0hM65ThZCnnRkOz', '2019-03-02 23:15:39', '0', '7j507wmM1S91sv91', 2, 22, NULL, 'oC7L3fOY3GIroKC7', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190302231636250', 'iYvI399GqOvDvM6I', '5681A4l5A9dx8usC', '2019-03-02 23:16:36', '0', '9', 2, 246, NULL, 'oC7L3fOY3GIroKC7', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190302232146295', 'iYvI399GqOvDvM6I', '5681A4l5A9dx8usC', '2019-03-02 23:21:46', '0', '9', 2, 246, NULL, 'oC7L3fOY3GIroKC7', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190302232220680', 'iYvI399GqOvDvM6I', '5681A4l5A9dx8usC', '2019-03-02 23:22:21', '0', 'eee111', 1, 123, NULL, 'oC7L3fOY3GIroKC7', NULL, NULL);
INSERT INTO `t_order` VALUES ('20190302232420864', 'iYvI399GqOvDvM6I', 'x0hM65ThZCnnRkOz', '2019-03-02 23:24:20', '0', 'Na56e90AJ9H93unE', 1, 1111, NULL, 'oC7L3fOY3GIroKC7', NULL, NULL);

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
  `username` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `state` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '0正常  1冻结  2未激活',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createdate` datetime(0) NULL DEFAULT NULL,
  `loginname` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `usertype` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0普通用户  1系统用户',
  `activeCode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `activeDate` datetime(0) NULL DEFAULT NULL,
  `adreess` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lastLoginTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('9xBYQxT9Zu6Y91Gt', 'NaN', '202cb962ac59075b964b07152d234b70', '0', NULL, '2018-10-18 12:33:12', '0', NULL, NULL, NULL, '123', NULL, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('FXC96CHW0Q2A1OHr', '65261', 'e10adc3949ba59abbe56e057f20f883e', '0', 'Kmwqgk1c32i441FT.jpg', '2018-10-17 12:33:09', '0', NULL, NULL, NULL, '123', NULL, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('h8MwxUZ19I2LIwdV', '123123', 'ca0ac53949a35994a756c957db0f713e', '0', NULL, '2018-10-10 12:33:04', '0', NULL, NULL, NULL, '132', NULL, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('iYvI399GqOvDvM6I', '一笑倾', 'ca0ac53949a35994a756c957db0f713e', '1', '1J7nC699jJC8t6Ko.jpg', '2019-02-12 10:48:33', '0', NULL, NULL, NULL, '851276240@qq.com', '851276240@qq.com', '0', '', NULL, NULL, '18877493149', '2019-03-07 19:12:33');
INSERT INTO `user` VALUES ('NyVcmY0sJBHmwKE6', '123', '4297f44b13955235245b2497399d7a93', '0', NULL, '2018-10-01 17:47:20', '0', NULL, NULL, NULL, '123', NULL, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('TCI6qWC391l9912t', '15462', 'ca0ac53949a35994a756c957db0f713e', '1', 'G:\\data\\upload\\images\\6O0Iaqj1dd7c3130.jpg', '2018-10-17 17:47:13', '0', NULL, NULL, NULL, '123', NULL, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('x0hM65ThZCnnRkOz', '一笑倾城', 'ca0ac53949a35994a756c957db0f713e', '1', '1J7nC699jJC8t6Ko.jpg', NULL, '0', NULL, NULL, NULL, 'admin', '8540@qq.com', '1', NULL, NULL, NULL, '18877493149', '2019-03-05 22:14:39');

SET FOREIGN_KEY_CHECKS = 1;
