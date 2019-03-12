/*
Navicat MySQL Data Transfer

Source Server         : joo
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2019-03-12 18:08:14
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
  `status` varchar(1) DEFAULT NULL COMMENT '0默认   1非默认',
  `createdate` datetime DEFAULT NULL,
  PRIMARY KEY (`addrid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('a8wF16e0c46c558y', 'iYvI399GqOvDvM6I', '广西壮族自治区', '钦州市', '钦北区', '板城镇', '535000', '黄亮兴', '18877493149', '0', '2019-03-12 16:10:45');
INSERT INTO `address` VALUES ('T0n47cW7xYRlctpZ', 'iYvI399GqOvDvM6I', '广西壮族自治区', '钦州市', '钦北区', '北区', '000000', '黄亮兴', '18877493149', '1', '2019-03-12 16:37:29');
INSERT INTO `address` VALUES ('z55J8V9S4T8l56HP', 'iYvI399GqOvDvM6I', '广西壮族自治区', '防城港市', '东兴市', '东兴', '562122', '黄亮兴', '18877493149', '1', '2019-03-12 16:37:06');

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
INSERT INTO `banner` VALUES ('djA6oN6QTCeY2yZi', '3qCw5Jw1C1dLIo9n.jpg', '1', '1', null, '666666', null, null, null, null);
INSERT INTO `banner` VALUES ('h4CK3E9rMcQ8Yk3b', 'CXbRR1UbKAu2tn4A.jpg', '0', '1', null, 'sss', null, null, null, null);
INSERT INTO `banner` VALUES ('Hhz61GPtTNRZpZcG', 'z8Pd6K3y1LxIkXKA.jpg', '0', '1', null, '1111', null, null, null, null);
INSERT INTO `banner` VALUES ('J5i8z7PQ3D7Zgg6H', 'YM8d8dH5xG3tbSp8.jpg', '0', '0', null, '123434', null, null, null, null);

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
  KEY `parent_chil` (`parentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1001', '0', '手机', null);
INSERT INTO `category` VALUES ('100100', '1001', '苹果', null);
INSERT INTO `category` VALUES ('100101', '1001', '华为', null);
INSERT INTO `category` VALUES ('100102', '1001', '小米', null);
INSERT INTO `category` VALUES ('100103', '1001', '三星', null);
INSERT INTO `category` VALUES ('100104', '1001', '努比亚', null);
INSERT INTO `category` VALUES ('1002', '0', '相机', null);
INSERT INTO `category` VALUES ('100200', '1002', '索尼', null);
INSERT INTO `category` VALUES ('100201', '1002', '普通数码相机', null);
INSERT INTO `category` VALUES ('100202', '1002', '单反镜头', null);
INSERT INTO `category` VALUES ('100203', '1002', '数码单反', null);
INSERT INTO `category` VALUES ('100204', '1002', '佳能', null);
INSERT INTO `category` VALUES ('1003', '0', '电脑', null);
INSERT INTO `category` VALUES ('100300', '1003', 'CPU', null);
INSERT INTO `category` VALUES ('100301', '1003', '笔记本', null);
INSERT INTO `category` VALUES ('100302', '1003', '平板电脑', null);
INSERT INTO `category` VALUES ('100303', '1003', '台式机整机', null);
INSERT INTO `category` VALUES ('100304', '1003', '显示器', null);
INSERT INTO `category` VALUES ('100305', '1003', '鼠标', null);
INSERT INTO `category` VALUES ('100306', '1003', '显卡', null);
INSERT INTO `category` VALUES ('100307', '1003', '主板', null);
INSERT INTO `category` VALUES ('1004', '0', '家电', null);
INSERT INTO `category` VALUES ('100400', '1004', '小米电视', null);
INSERT INTO `category` VALUES ('1005', '0', '文具', null);

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

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `proid` varchar(64) NOT NULL DEFAULT '',
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
  `auctionStatus` varchar(1) DEFAULT NULL COMMENT '竞拍状态 0-未开始 1-已开始 2- 成交',
  PRIMARY KEY (`proid`),
  KEY `pro_user_key` (`userid`),
  KEY `product_cate` (`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('EUD4eu23Nl8gxUIO', '戴尔二手笔记本电脑/e6220/e6230/e6430/i7独显四核游戏本超级本', '100301', '2398.00', '<ul class=\"attributes-list\" style=\"font-family:tahoma, arial, &quot;background-color:#FFFFFF;\">\r\n	<li>\r\n		品牌:&nbsp;Dell/戴尔&nbsp; &nbsp;系列:&nbsp;Latitude E6220\r\n	</li>\r\n	<li>\r\n		Latitude E6220系列:&nbsp;Latitude E6220 i5-2540M&nbsp; &nbsp;<span>内存容量:&nbsp;4G&nbsp; &nbsp;机械硬盘容量:&nbsp;320GB</span>\r\n	</li>\r\n	<li>\r\n		CPU:&nbsp;Core/酷睿 i7&nbsp; &nbsp;Intel Core/酷睿 i7:&nbsp;i7-3520M&nbsp; &nbsp;<span>成色:&nbsp;9成新以上</span>\r\n	</li>\r\n	<li>\r\n		屏幕尺寸:&nbsp;13英寸&nbsp; &nbsp;屏幕比例:&nbsp;16:9&nbsp; &nbsp;分辨率:&nbsp;1366x768&nbsp; &nbsp;<span>显存容量:&nbsp;2G</span>\r\n	</li>\r\n	<li>\r\n		颜色分类:&nbsp;白色 银色 黑色 蓝色 粉色\r\n	</li>\r\n	<li>\r\n		毛重:&nbsp;1.38kg&nbsp; &nbsp;重量:&nbsp;1kg(含)-1.5kg(不含)\r\n	</li>\r\n	<li>\r\n		上市时间:&nbsp;2014年&nbsp; &nbsp;<span>输入设备:&nbsp;触摸板&nbsp; &nbsp;固态硬盘:&nbsp;120g</span>\r\n	</li>\r\n	<li>\r\n		显卡类型:&nbsp;HD4000&nbsp; &nbsp;附加功能:&nbsp;HDMI接口 扬声器 USB 3.0&nbsp; &nbsp;<span>版本类型:&nbsp;中国大陆</span>\r\n	</li>\r\n	<li>\r\n		适用场景:&nbsp;移动工作站 家庭影音 女性定位 轻薄便携 学生 商务办公 高清游戏 家庭娱乐\r\n	</li>\r\n	<li>\r\n		通信技术类型:&nbsp;无线网卡&nbsp; 屏幕类型:&nbsp;LED\r\n	</li>\r\n	<li>\r\n		<img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/57757972/TB2vAKYb4PI8KJjSspfXXcCFXXa_!!57757972.jpg\" class=\"\" /><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/57757972/O1CN016fMEIj28lDvQKvFu6_!!57757972.jpg\" class=\"\" style=\"height:800px;width:800px;\" /><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/57757972/O1CN01oGP8pU28lDvQKuaKG_!!57757972.jpg\" class=\"\" style=\"height:800px;width:800px;\" /><span style=\"font-family:tahoma, arial, 宋体, sans-serif;font-size:14px;background-color:#FFFFFF;\"></span><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/57757972/TB2AElkXPgy_uJjSZR0XXaK5pXa_!!57757972.jpg\" class=\"\" width=\"750\" height=\"500\" /><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/57757972/O1CN01O9Mmsq28lDvQYskuI_!!57757972.jpg\" class=\"\" style=\"width:800px;height:800px;\" /><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/57757972/O1CN01YbccTb28lDw1OLz4H_!!57757972.jpg\" class=\"\" width=\"750\" height=\"500\" /><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/57757972/O1CN01SYOVq728lDw1se4lo_!!57757972.jpg\" class=\"\" style=\"height:800px;width:800px;\" /><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/57757972/O1CN01xHwRIr28lDw1shYyS_!!57757972.jpg\" class=\"\" style=\"width:800px;height:800px;\" /><br />\r\n	</li>\r\n</ul>', '2019-03-11 14:39:38', '2019-03-11 14:39:38', '一笑倾', 'iYvI399GqOvDvM6I', null, '88v6xAppRuvCEz75.jpg', 'iYvI399GqOvDvM6I', '10', null, null, '0', null, null, '999', '0', null, null, null, null, null);
INSERT INTO `product` VALUES ('FSRRUl9HglmT8iDs', '库存全新原封努比亚Z17+64G骁龙821版全网通手机', '100104', '999.00', '<div class=\"intro-para clearfix\" style=\"margin:0px 0px 15px;color:#333333;font-family:tahoma, arial, 宋体;\">\r\n	<ul>\r\n		<li>\r\n			<span class=\"title\" style=\"font-size:14px;background-color:#F5F5F5;\">品牌</span>&nbsp;<span style=\"font-size:14px;\">other/其他</span>\r\n		</li>\r\n	</ul>\r\n</div>\r\n<div class=\"describe\" id=\"J_DescContent\" style=\"font-size:14px;font-family:tahoma, arial, simsun;color:#333333;\">\r\n	库存全新乐pro3 x720标准版手机，原力金，双卡双待全网通4G，5.5英寸1920*1080高分辨率屏幕，高通骁龙821满血版处理器，运存4G+32G存储，带NFC功能和红外遥控，4070mAh大容量电池，支持3.0快充。未拆封全新库存机。新到一小批，数量不多，机不可失，爽快的包邮！\r\n</div>', '2019-03-11 14:52:20', '2019-03-11 14:52:20', '一笑倾', 'iYvI399GqOvDvM6I', null, 'Q13t2Bk9AyXq1s8F.jpg', 'iYvI399GqOvDvM6I', '3', null, null, '0', null, null, '63', '0', null, null, null, null, null);
INSERT INTO `product` VALUES ('q0U4pfNOvpoue1E1', '二手台式电脑主机高配i7组装机游戏发烧高端吃鸡全套网吧游戏型32', '100303', '2599.00', '<ul class=\"attributes-list\" style=\"font-family:tahoma, arial, &quot;background-color:#FFFFFF;\">\r\n	<li style=\"text-indent:5px;\">\r\n		品牌:&nbsp;Intel/英特尔&nbsp; &nbsp; &nbsp;内存容量:&nbsp;16GB&nbsp; &nbsp; 硬盘容量:&nbsp;120GB\r\n	</li>\r\n	<li style=\"text-indent:5px;\">\r\n		电源功率:&nbsp;300W&nbsp; &nbsp; &nbsp; &nbsp; 内存类型:&nbsp;DDR3&nbsp; &nbsp;显存容量:&nbsp;8GB\r\n	</li>\r\n	<li style=\"text-indent:5px;\">\r\n		显存位宽:&nbsp;512bit&nbsp; &nbsp; &nbsp; &nbsp;显存类型:&nbsp;GDDR5&nbsp; &nbsp;主板结构:&nbsp;ATX\r\n	</li>\r\n	<li style=\"text-indent:5px;\">\r\n		光驱类型:&nbsp;无光驱&nbsp; &nbsp; &nbsp; CPU核心数:&nbsp;四核心&nbsp; &nbsp;机箱结构:&nbsp;ATX\r\n	</li>\r\n	<li style=\"text-indent:5px;\">\r\n		CPU主频:&nbsp;2.8GHz(含)-3.0GHz(不含)&nbsp; &nbsp;配置类型:&nbsp;疯狂游戏型\r\n	</li>\r\n	<li style=\"text-indent:5px;\">\r\n		电源80 PLUS认证:&nbsp;不支持&nbsp; &nbsp;显卡系列:&nbsp;GTX 1070&nbsp; &nbsp;显卡类型:&nbsp;独立显卡\r\n	</li>\r\n	<li style=\"text-indent:5px;\">\r\n		内存频率:&nbsp;1600MHz&nbsp; &nbsp;散热方式:&nbsp;风冷&nbsp; &nbsp;硬盘类型:&nbsp;固态硬盘(SSD)\r\n	</li>\r\n	<li style=\"text-indent:5px;\">\r\n		CPU系列:&nbsp;Intel/英特尔酷睿i7&nbsp; &nbsp;主板芯片组类型:&nbsp;Intel B75&nbsp; &nbsp;显卡品牌:&nbsp;Asus/华硕\r\n	</li>\r\n	<li style=\"text-indent:5px;\">\r\n		机箱品牌:&nbsp;Aigo/爱国者&nbsp; &nbsp;电源品牌:&nbsp;BUBALUS/大水牛&nbsp; &nbsp;主板品牌:&nbsp;Asus/华硕&nbsp; &nbsp;散热设备品牌:&nbsp;pccooler/超频三\r\n	</li>\r\n	<li style=\"text-indent:5px;\">\r\n		内存品牌:&nbsp;AData/威刚&nbsp; &nbsp;硬盘品牌:&nbsp;AData/威刚&nbsp; &nbsp;CPU型号:&nbsp;860K\r\n	</li>\r\n	<li style=\"text-indent:5px;\">\r\n		<img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/408188478/O1CN012CUyJlvje5HGzpK_!!408188478.jpg\" class=\"\" /><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i1/408188478/O1CN01iskGBN2CUyLCDIoKj_!!408188478.jpg\" class=\"\" style=\"width:750px;height:539px;\" /><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/408188478/O1CN01NJyqsh2CUyK5tx7bJ_!!408188478.jpg\" class=\"\" /><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i4/408188478/O1CN012YFzjW2CUyK7bdGQf_!!408188478.jpg\" class=\"\" /><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/408188478/O1CN01az1OSI2CUyKNGAcwi_!!408188478.jpg\" class=\"\" /><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i2/408188478/O1CN01tnyTOF2CUyKPYTfNX_!!408188478.jpg\" class=\"\" /><img align=\"absmiddle\" src=\"https://img.alicdn.com/imgextra/i3/408188478/O1CN01bLE48F2CUyLFcrb1c_!!408188478.jpg\" class=\"\" /><br />\r\n	</li>\r\n</ul>', '2019-03-11 14:34:56', '2019-03-11 14:34:56', '一笑倾', 'iYvI399GqOvDvM6I', null, '8S5z6vE4D294OsT8.jpg', 'iYvI399GqOvDvM6I', '9', null, null, '0', null, null, '999', '0', null, null, null, null, null);
INSERT INTO `product` VALUES ('QzM6K1cd8lsJpiub', 'xiaomi小米8全面屏全新正品智能手机原封小米8全网通', '100102', '1120.00', '<div class=\"intro-para clearfix\" style=\"margin:0px 0px 15px;color:#333333;font-family:tahoma, arial, 宋体;\">\r\n	<ul>\r\n		<li>\r\n			<span class=\"title\" style=\"font-size:14px;background-color:#F5F5F5;\">品牌</span>&nbsp;<span style=\"font-size:14px;\">other/其他</span>\r\n		</li>\r\n	</ul>\r\n</div>\r\n<div class=\"describe\" id=\"J_DescContent\" style=\"font-size:14px;font-family:tahoma, arial, simsun;color:#333333;\">\r\n	图片都为实物图！全网通4G智能手机 容量128GB ， RAM容量6GB全新正品原封智能手机低价出售 ，黑色 白色全新正品原封，指纹解锁，全网通4G，1200万像素双摄，耳机，数据线，充电器配件齐全，1年保修，图片都为实物图！支持全国包邮货到付款需要先交30元定金，【1150元包邮的，需要先拍下付款30元定金，剩下1120元货到后快递代收本交易仅支持邮寄\r\n</div>', '2019-03-11 14:56:55', '2019-03-11 14:56:55', '一笑倾', 'iYvI399GqOvDvM6I', null, 'o1n19v3P5xt6n4yO.jpg', 'iYvI399GqOvDvM6I', '3', null, null, '0', null, null, '992', '0', null, null, null, null, null);
INSERT INTO `product` VALUES ('RtxWjobQl9uILPyu', 'GTX1060 6gb', '100306', '1499.00', '<div class=\"tm-clear tb-hidden tm_brandAttr\" id=\"J_BrandAttr\" style=\"margin:0px;padding:8px 20px 10px;color:#404040;font-family:tahoma, arial, 微软雅黑, sans-serif;background-color:#FFFFFF;\">\r\n	<div class=\"name\" style=\"margin:0px 15px 0px 0px;padding:0px;color:#666666;\">\r\n		品牌名称：<span class=\"J_EbrandLogo\" style=\"color:#333333;\">Colorful/七彩虹</span>\r\n	</div>\r\n</div>\r\n<p class=\"attr-list-hd tm-clear\" style=\"color:#999999;font-family:tahoma, arial, 微软雅黑, sans-serif;background-color:#FFFFFF;\">\r\n	<span style=\"font-weight:700;\">产品参数：</span>\r\n</p>\r\n<ul id=\"J_AttrUL\" style=\"color:#404040;font-family:tahoma, arial, 微软雅黑, sans-serif;background-color:#FFFFFF;\">\r\n	<li style=\"vertical-align:top;color:#666666;\">\r\n		产品名称：Colorful/七彩虹 烈焰战神&nbsp; &nbsp;品牌:&nbsp;Colorful/七彩虹\r\n	</li>\r\n	<li style=\"vertical-align:top;color:#666666;\">\r\n		七彩虹:&nbsp;烈焰战神&nbsp; &nbsp;成色:&nbsp;9成新&nbsp; &nbsp;售后服务:&nbsp;全国联保&nbsp; &nbsp;显卡芯片型号:&nbsp;GTX1060\r\n	</li>\r\n	<li style=\"vertical-align:top;color:#666666;\">\r\n		接口类型:&nbsp;PCI-E 3.0&nbsp; &nbsp;显存容量:&nbsp;6GB&nbsp; &nbsp;输出接口:&nbsp;DVI&nbsp;HDMI&nbsp;DP\r\n	</li>\r\n	<li style=\"vertical-align:top;color:#666666;\">\r\n		显存位宽:&nbsp;192bit&nbsp; &nbsp;显存类型:&nbsp;GDDR5\r\n	</li>\r\n	<li style=\"vertical-align:top;color:#666666;\">\r\n		颜色分类:&nbsp;iGame 1060 烈焰战神U-6GD TOP&nbsp;iGame GTX1060 Advanced OC 6G&nbsp;iGame GTX1060 Vulcan X OC&nbsp;iGame 1060 烈焰战神U-6GD TOP+额定500电源\r\n	</li>\r\n	<li style=\"vertical-align:top;color:#666666;\">\r\n		毛重:&nbsp;2Kg&nbsp; &nbsp;生产企业:&nbsp;深圳市七彩虹科技发展有限公司&nbsp; &nbsp;NVIDIA芯片型号:&nbsp;GTX1060\r\n	</li>\r\n	<li style=\"vertical-align:top;color:#666666;\">\r\n		质保时间:&nbsp;三年&nbsp; &nbsp;芯片:&nbsp;nVIDIA&nbsp; &nbsp;芯片制程:&nbsp;16纳米\r\n	</li>\r\n	<li style=\"vertical-align:top;color:#666666;\">\r\n		散热方式:&nbsp;风冷&nbsp; &nbsp;显卡芯片组:&nbsp;GTX1060(OC)&nbsp; &nbsp; 是否支持显卡交火:&nbsp;否\r\n	</li>\r\n	<li style=\"vertical-align:top;color:#666666;\">\r\n		<br />\r\n	</li>\r\n</ul>\r\n<s class=\"skin-box-bt\"><b></b></s>\r\n<div class=\"J_TModule\" id=\"shop18820213686\" style=\"margin:0px;padding:0px;\">\r\n	<div class=\"skin-box tb-module tshop-pbsm tshop-pbsm-shop-self-defined\" style=\"margin:0px;padding:0px;\">\r\n		<s class=\"skin-box-tp\"><b></b></s>\r\n		<div class=\"skin-box-bd clear-fix\" style=\"margin:0px;padding:0px;border:none;background:none;color:#666666;\">\r\n			<span>\r\n			<p>\r\n				<a href=\"https://huichuansm.tmall.com/p/rd936248.htm?scene=taobao_shop\" target=\"_blank\"></a>\r\n			</p>\r\n</span>\r\n		</div>\r\n<s class=\"skin-box-bt\"><b></b></s>\r\n	</div>\r\n</div>\r\n<div id=\"description\" class=\"J_DetailSection tshop-psm tshop-psm-bdetaildes\" style=\"margin:0px;padding:0px;color:#404040;font-family:tahoma, arial, 微软雅黑, sans-serif;background-color:#FFFFFF;\">\r\n	<div class=\"content ke-post\" style=\"margin:10px 0px 0px;padding:0px;font-size:14px;font-family:tahoma, arial, 宋体, sans-serif;\">\r\n		<p>\r\n			<img src=\"https://img.alicdn.com/imgextra/i1/1134114936/O1CN011mKjRf1KeP3Dsmv_!!1134114936.jpg\" align=\"absmiddle\" class=\"img-ks-lazyload\" /><img src=\"https://img.alicdn.com/imgextra/i1/1134114936/O1CN01IzKlTo1mKjU4dKTgf_!!1134114936.jpg\" align=\"absmiddle\" class=\"img-ks-lazyload\" /><a href=\"https://detail.tmall.com/item.htm?spm=a1z10.5-b-s.w4011-14449717902.262.558c1050P35dHv&amp;id=586991492715&amp;rn=c49d6e5449b71055f84cb50e68e4f0e0&amp;abbucket=10\" target=\"_blank\"><img src=\"https://img.alicdn.com/imgextra/i1/1134114936/O1CN01kcDpxE1mKjTn53HDc_!!1134114936.jpg\" align=\"absmiddle\" class=\"img-ks-lazyload\" /></a>\r\n		</p>\r\n	</div>\r\n</div>', '2019-03-11 14:46:12', '2019-03-11 14:46:12', '一笑倾', 'iYvI399GqOvDvM6I', null, 'yL0vmvNtQ0C0dBgV.jpg', 'iYvI399GqOvDvM6I', '1', null, null, '0', null, null, '5', '0', null, null, null, null, null);

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
INSERT INTO `t_order` VALUES ('20190312161056717', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-03-12 16:10:56', '0', 'QzM6K1cd8lsJpiub', '3', '3360', null, 'a8wF16e0c46c558y', null, null);
INSERT INTO `t_order` VALUES ('20190312161534690', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-03-12 16:15:34', '0', 'FSRRUl9HglmT8iDs', '3', '2997', null, 'a8wF16e0c46c558y', null, null);
INSERT INTO `t_order` VALUES ('20190312162356057', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-03-12 16:23:56', '0', 'QzM6K1cd8lsJpiub', '1', '1120', null, 'a8wF16e0c46c558y', null, null);
INSERT INTO `t_order` VALUES ('20190312162402150', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-03-12 16:24:02', '0', 'QzM6K1cd8lsJpiub', '1', '1120', null, 'a8wF16e0c46c558y', null, null);
INSERT INTO `t_order` VALUES ('20190312162413083', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-03-12 16:24:13', '0', 'QzM6K1cd8lsJpiub', '1', '1120', null, 'a8wF16e0c46c558y', null, null);
INSERT INTO `t_order` VALUES ('20190312162420747', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-03-12 16:24:20', '0', 'QzM6K1cd8lsJpiub', '1', '1120', null, 'a8wF16e0c46c558y', null, null);
INSERT INTO `t_order` VALUES ('20190312164905823', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-03-12 16:49:05', '0', 'QzM6K1cd8lsJpiub', '1', '1120', null, 'a8wF16e0c46c558y', null, null);
INSERT INTO `t_order` VALUES ('20190312164934637', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-03-12 16:49:34', '0', 'QzM6K1cd8lsJpiub', '1', '1120', null, 'a8wF16e0c46c558y', null, null);
INSERT INTO `t_order` VALUES ('20190312164942496', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-03-12 16:49:42', '0', 'QzM6K1cd8lsJpiub', '1', '1120', null, 'T0n47cW7xYRlctpZ', null, null);
INSERT INTO `t_order` VALUES ('20190312164945036', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-03-12 16:49:45', '0', 'QzM6K1cd8lsJpiub', '1', '1120', null, 'z55J8V9S4T8l56HP', null, null);
INSERT INTO `t_order` VALUES ('20190312170124013', 'iYvI399GqOvDvM6I', 'iYvI399GqOvDvM6I', '2019-03-12 17:01:24', '0', 'QzM6K1cd8lsJpiub', '1', '1120', null, 'T0n47cW7xYRlctpZ', null, null);

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
  `loginname` varchar(36) NOT NULL,
  `email` varchar(64) DEFAULT NULL,
  `usertype` varchar(1) DEFAULT NULL COMMENT '0普通用户  1系统用户',
  `activeCode` varchar(50) DEFAULT NULL,
  `activeDate` datetime DEFAULT NULL,
  `adreess` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `province` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `area` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3qsgx0N7j1OxdncQ', 'admin1', 'ca0ac53949a35994a756c957db0f713e', null, null, '2019-03-12 17:09:55', null, null, null, 'admin1', 'admin1', '1', null, null, null, '18877493149', null, null, null, null);
INSERT INTO `user` VALUES ('iYvI39933OvDvM6I', '一笑倾', 'ca0ac53949a35994a756c957db0f713e', '0', '9u73d3oH7D1783s5.jpg', '2019-02-12 10:48:33', '0', '', '', 'admin', '851276240@qq.com', '1', '', '2019-03-21 17:07:50', '', '15632145632', '2019-03-12 17:08:41', '广西壮族自治区', '梧州市', '岑溪市');
INSERT INTO `user` VALUES ('iYvI399GqOvDvM6I', '一笑倾', 'ca0ac53949a35994a756c957db0f713e', '0', '9u73d3oH7D1783s5.jpg', '2019-02-12 10:48:33', '0', null, null, '851276240@qq.com', '851276240@qq.com', '0', '', null, null, '15632145632', '2019-03-12 15:27:03', '广西壮族自治区', '梧州市', '岑溪市');
