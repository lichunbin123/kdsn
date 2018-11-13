-- MySQL dump 10.13  Distrib 5.5.62, for osx10.13 (x86_64)
--
-- Host: localhost    Database: usping
-- ------------------------------------------------------
-- Server version	5.5.62

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `comment_score` int(22) DEFAULT NULL,
  `comment_date` mediumtext,
  `comment_content` longtext,
  `news_id` char(255) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `fk_uid_comment` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (20,6,'rh5555',NULL,'1527492600919','??','AWEO35nWHB4m_dAeBhwp'),(21,NULL,NULL,NULL,'1531381702051','??','AWEO35nWHB4m_dAeBhwp');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `communicate`
--

DROP TABLE IF EXISTS `communicate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `communicate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `content` text,
  `pid` int(11) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `uname` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `communicate_uid_fk` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `communicate`
--

LOCK TABLES `communicate` WRITE;
/*!40000 ALTER TABLE `communicate` DISABLE KEYS */;
INSERT INTO `communicate` VALUES (1,6,'买卖互动添加测试？？',1,'2016-07-07 04:30:36','张六'),(2,6,'测试用户id添加。。。',1,'2016-07-07 04:30:37','张六'),(3,6,'测试数据。。。。',1,'2016-07-07 04:30:38','张六'),(4,6,'测试数据。。',1,'2016-07-07 04:30:38','张六'),(5,6,'测试数据。。',1,'2016-07-07 04:30:39','张六'),(6,6,'测试数据。。',1,'2016-07-07 04:30:40','张六'),(7,6,'测试数据。。',1,'2016-07-07 04:30:41','张六'),(8,6,'测试数据。。',1,'2016-07-07 04:30:41','张六'),(9,6,'测试数据。。',1,'2016-07-07 04:30:42','张六'),(10,6,'测试数据。。',1,'2016-07-07 04:30:43','张六'),(11,6,'测试数据。。',1,'2016-07-07 04:30:43','张六'),(12,6,'测试数据。。',1,'2016-07-07 04:30:44','张六'),(13,6,'我们的说飒飒飒飒飒飒撒飒飒飒飒飒飒飒飒飒飒撒飒飒飒飒我们的说飒飒飒飒飒飒撒飒飒飒飒飒飒飒飒飒飒撒飒飒飒飒我们的说飒飒飒飒飒飒撒飒飒飒飒飒飒飒飒飒飒撒飒飒飒飒我们的说飒飒飒飒飒飒撒飒飒飒飒飒飒飒飒飒飒撒飒飒飒飒我们的说飒飒飒飒飒飒撒飒飒飒飒飒飒飒飒飒飒撒飒飒飒飒我们的说飒飒飒飒飒飒撒飒飒飒飒飒飒飒飒飒飒撒飒飒飒飒我们的说飒飒飒飒飒飒撒飒飒飒飒飒飒飒飒飒飒撒飒飒飒飒我们的说飒飒飒飒飒飒撒飒飒飒飒飒飒飒飒飒飒撒飒飒飒飒',1,'2016-07-07 04:32:11','张六'),(14,6,'恩',81,'2016-07-10 11:43:30','张六'),(15,6,'的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶22222222222222222222的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶22222222222222222222的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶22222222222222222222的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶22222222222222222222',81,'2016-07-10 11:43:43','张六'),(16,6,'多少度',80,'2016-07-10 11:44:13','张六'),(17,6,'',80,'2016-07-10 11:44:25','张六'),(18,6,'',80,'2016-07-10 11:44:53','张六'),(19,5,'该系统我使用过效果确实不错，值得给大家推荐一下！',113,'2016-07-18 02:02:08','张武');
/*!40000 ALTER TABLE `communicate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experience`
--

DROP TABLE IF EXISTS `experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `experience` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `field` varchar(200) DEFAULT NULL,
  `example` varchar(200) DEFAULT NULL,
  `content` text,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `experience_fk_uid` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experience`
--

LOCK TABLES `experience` WRITE;
/*!40000 ALTER TABLE `experience` DISABLE KEYS */;
INSERT INTO `experience` VALUES (1,6,'激光摄像机','南昌高速测速','该激光测速仪器，精准度极高，寿命达到预期，而且后期服务到位，确实是不错的仪器，值得推荐。',1),(2,6,'道路摄像机','九江居民小区测速','该激光测速仪器，精准度极高，寿命达到预期，但是价格有点高，而且容易生锈，希望尽快改进！',1),(3,6,'城市道路测速','潍坊红路灯测速','该激光摄像机，定位准确，捕捉信息速度极快，非常的灵活，但是耗电量有点多，冬天镜片容易起雾。',1),(5,6,'投影仪','南昌学校宿舍安检','该激光仪器采用的技术是一流的，而且安全性很高，很具有价值。',1),(6,6,'北京摄像机','蓝天摄像馆','摄像机里面许多器件借用该激光里面相关的期间，拍摄效果很好，非常的适合我们。',1),(7,6,'学生考研信息采集','全国高考信息采集','该仪器采集信息不仅效率高，而且速度极快，非常适合用于拍摄信息方面。',1),(8,6,'1','1','',3),(9,6,'2','2','',0);
/*!40000 ALTER TABLE `experience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(10) DEFAULT NULL,
  `isuser` int(4) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (3,6,1,'中国数字医疗网'),(4,6,1,'中国知网'),(5,7,1,'中国知网'),(6,7,1,'光粒网');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `message_id` int(22) NOT NULL AUTO_INCREMENT,
  `sender_id` int(22) DEFAULT NULL,
  `receiver_id` int(22) DEFAULT NULL,
  `message_content` mediumtext,
  `delivery_status` int(4) DEFAULT NULL,
  `send_time` int(22) DEFAULT NULL,
  `sender_account` varchar(255) DEFAULT NULL,
  `receiver_account` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (45,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(46,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(47,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(48,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(49,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(50,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(51,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(52,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(53,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(54,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(55,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(56,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(57,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(58,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(59,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(60,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(61,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(62,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(63,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(64,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(65,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(66,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(67,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(68,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(69,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(70,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(71,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(72,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(73,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(74,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(75,NULL,NULL,'弟弟',NULL,NULL,'rh5555','admin'),(76,NULL,NULL,'??',NULL,NULL,'rh5555','admin'),(77,NULL,NULL,'??',NULL,NULL,'rh5555','admin'),(78,NULL,NULL,'??',NULL,NULL,'rh5555','admin'),(79,NULL,NULL,'??',NULL,NULL,'rh5555','admin'),(80,NULL,NULL,'??',NULL,NULL,'rh5555','admin'),(81,NULL,NULL,'??',NULL,NULL,'rh5555','admin');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `note`
--

DROP TABLE IF EXISTS `note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nid` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `userscore` tinyint(4) DEFAULT NULL,
  `content` text,
  `date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `uid` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `ispublic` int(1) DEFAULT '0',
  `note_id` int(11) DEFAULT NULL,
  `news_id` varchar(255) DEFAULT NULL,
  `note_title` varchar(255) DEFAULT NULL,
  `note_type` varchar(255) DEFAULT NULL,
  `note_score` int(11) DEFAULT NULL,
  `note_date` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `ref_url` varchar(255) DEFAULT NULL,
  `public_state` int(11) DEFAULT NULL,
  `note_comment` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note`
--

LOCK TABLES `note` WRITE;
/*!40000 ALTER TABLE `note` DISABLE KEYS */;
INSERT INTO `note` VALUES (1,6285,'诺克激光讲堂：影响光纤激光切割机切割质量的因素','',100,'aa','2016-12-10 13:48:20',6,'http://bbs.diodelaser.com.cn/thread-24245-1-1.html',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,29,'领创激光新高度--Excalibur-4020激光切割机','激光器',80,'测试！','2016-12-10 13:48:55',6,'http://laser.ofweek.com/2016-03/ART-240015-8220-29070838.html',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,6442,'基于机器学习特性的数据中心能耗优化方法_王肇国',' ',80,'ｔｅｓｔ！','2016-12-16 13:36:18',7,'../document/基于机器学习特性的数据中心能耗优化方法_王肇国.pdf',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `note` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(1) DEFAULT '0',
  `nid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (8,1,6291,6);
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `fid` int(11) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,6,2,'价格再高一点，5000，我们立马开始着手建站，当然也可以再商议，希望有合作的机会！'),(2,6,5,'恩，非常满意，希望联系我们一下，我们接受这个任务'),(3,6,513,'我要接单！');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `SearchWords` varchar(255) DEFAULT NULL,
  `UserId` int(11) DEFAULT NULL,
  `URL` varchar(255) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Date` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `requestid` int(11) DEFAULT NULL,
  `hostid` int(11) DEFAULT NULL,
  `datetime` int(22) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES (1,4,6,5,1493814150,1,'ahha'),(2,4,5,6,1493815050,0,'lala'),(3,6,5,6,1493814050,0,'la la land');
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serch`
--

DROP TABLE IF EXISTS `serch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `flagNotice` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=299 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serch`
--

LOCK TABLES `serch` WRITE;
/*!40000 ALTER TABLE `serch` DISABLE KEYS */;
INSERT INTO `serch` VALUES (1,6,'激光','2016-07-06 04:59:30','联动搜索'),(2,6,'激光,材料','2016-07-06 04:59:34','知识搜索'),(7,6,'激光,材料','2016-07-06 05:04:57','知识搜索'),(8,6,'激光,夜视,材料','2016-07-06 05:05:06','联动搜索'),(9,6,'激光,夜视','2016-07-06 05:05:42','产品搜索'),(10,7,'1','2016-07-07 00:40:37','知识搜索'),(11,7,'1','2016-07-07 00:41:20','知识搜索'),(12,7,'材料','2016-07-07 00:41:34','联动搜索'),(13,7,'材料,1','2016-07-07 00:41:44','知识搜索'),(14,7,'1','2016-07-07 00:42:04','联动搜索'),(15,7,'1,2','2016-07-07 00:42:08','知识搜索'),(18,6,'专用','2016-07-07 04:56:27','联动搜索'),(19,6,'专用','2016-07-07 04:56:35','联动搜索'),(20,6,'专用','2016-07-07 04:57:58','联动搜索'),(21,6,'专用','2016-07-07 04:58:05','联动搜索'),(22,6,'驱动','2016-07-07 04:58:38','联动搜索'),(23,6,'驱动','2016-07-07 05:00:24','联动搜索'),(24,6,'驱动','2016-07-07 05:00:25','联动搜索'),(25,6,'驱动','2016-07-07 05:00:26','联动搜索'),(26,6,'驱动','2016-07-07 05:01:11','联动搜索'),(27,6,'驱动','2016-07-07 05:10:38','联动搜索'),(28,6,'驱动','2016-07-07 05:11:42','联动搜索'),(29,6,'驱动,电源','2016-07-07 05:11:56','产品搜索'),(30,6,'驱动','2016-07-07 05:12:20','产品搜索'),(31,6,'驱动','2016-07-07 05:12:25','产品搜索'),(32,6,'高速','2016-07-07 09:28:52','产品搜索'),(33,6,'高速','2016-07-07 09:29:00','产品搜索'),(34,6,'专用,高速','2016-07-07 09:29:06','联动搜索'),(35,6,'激光','2016-07-07 09:43:24','联动搜索'),(36,6,'激光,夜视','2016-07-07 09:43:28','产品搜索'),(37,6,'激光,光纤','2016-07-07 09:43:32','知识搜索'),(38,6,'激光,脉冲','2016-07-07 09:43:45','知识搜索'),(39,6,'脉冲','2016-07-07 09:44:23','知识搜索'),(40,6,'脉冲,夜视','2016-07-07 09:44:28','联动搜索'),(41,6,'脉冲,盖亚','2016-07-07 09:44:37','产品搜索'),(42,6,'医疗','2016-07-08 11:39:02','联动搜索'),(43,6,'医疗,激光','2016-07-08 11:39:08','知识搜索'),(44,6,'激光,医疗','2016-07-08 11:40:02','知识搜索'),(45,6,'激光,医疗','2016-07-08 11:40:07','联动搜索'),(46,6,'医疗','2016-07-08 11:40:18','联动搜索'),(47,6,'医疗,器械','2016-07-08 11:40:21','知识搜索'),(48,6,'激光','2016-07-10 09:00:25','联动搜索'),(49,6,'激光,阅读','2016-07-10 09:00:29','知识搜索'),(50,6,'激光,材料','2016-07-10 09:00:33','知识搜索'),(51,6,'激光,美国','2016-07-10 09:00:39','知识搜索'),(52,6,'激光,夜视','2016-07-10 09:00:45','产品搜索'),(53,6,'打标','2016-07-10 11:42:50','联动搜索'),(54,6,'打标,激光','2016-07-10 11:43:00','知识搜索'),(55,6,'打标,材料','2016-07-10 11:43:18','产品搜索'),(56,6,'基层电路','2016-07-12 01:34:44','联动搜索'),(57,6,'集成电路','2016-07-12 01:34:51','联动搜索'),(58,6,'激光切割','2016-07-12 01:37:10','联动搜索'),(59,6,'焊接','2016-07-12 01:39:12','联动搜索'),(60,6,'激光','2016-07-12 01:43:22','联动搜索'),(61,6,'激光,医疗','2016-07-12 01:43:26','知识搜索'),(62,6,'激光,计算机','2016-07-12 01:43:29','知识搜索'),(63,6,'激光,计算机','2016-07-12 01:44:10','产品搜索'),(64,6,'激光,医疗','2016-07-12 01:44:14','产品搜索'),(65,6,'激光','2016-07-12 01:44:30','联动搜索'),(66,6,'激光','2016-07-12 03:35:33','联动搜索'),(67,6,'激光','2016-07-12 03:35:54','联动搜索'),(68,6,'光纤','2016-07-12 04:02:48','联动搜索'),(69,6,'光纤,脉冲','2016-07-12 04:03:02','知识搜索'),(70,6,'光纤,脉冲','2016-07-12 04:03:18','知识搜索'),(71,6,'光纤,脉冲','2016-07-12 04:03:30','知识搜索'),(72,6,'打标','2016-07-12 04:04:23','联动搜索'),(73,6,'打标','2016-07-12 04:04:35','联动搜索'),(74,6,'打标','2016-07-12 04:04:49','联动搜索'),(75,6,'脉冲','2016-07-12 04:10:09','知识搜索'),(76,6,'材料','2016-07-12 04:11:20','联动搜索'),(77,6,'激光,材料','2016-07-12 04:11:31','知识搜索'),(78,6,'材料','2016-07-12 04:11:50','联动搜索'),(79,6,'激光','2016-07-12 04:12:02','联动搜索'),(80,6,'材料','2016-07-12 04:12:06','联动搜索'),(81,6,'材料,激光','2016-07-12 04:12:18','知识搜索'),(82,6,'材料,脉冲','2016-07-12 09:28:07','知识搜索'),(83,6,'激光,材料','2016-07-12 09:28:34','知识搜索'),(84,6,'激光,材料','2016-07-12 09:34:53','知识搜索'),(85,6,'医疗','2016-07-12 09:35:41','联动搜索'),(86,6,'医疗,激光','2016-07-12 09:35:44','知识搜索'),(87,6,'医疗','2016-07-12 09:39:21','联动搜索'),(88,6,'激光,材料','2016-07-12 09:53:38','知识搜索'),(89,6,'激光','2016-07-12 09:58:20','联动搜索'),(90,6,'激光,材料','2016-07-12 09:58:25','知识搜索'),(91,6,'激光,材料','2016-07-12 10:07:39','产品搜索'),(92,6,'激光,材料','2016-07-12 10:08:03','产品搜索'),(93,6,'材料','2016-07-12 10:08:25','产品搜索'),(94,6,'夜视','2016-07-12 10:08:32','联动搜索'),(95,6,'夜视,智能','2016-07-12 10:08:58','产品搜索'),(96,6,'激光,智能','2016-07-12 10:09:16','联动搜索'),(97,6,'激光,夜视','2016-07-12 10:09:23','产品搜索'),(98,6,'激光,夜视','2016-07-12 10:10:33','产品搜索'),(99,6,'夜视','2016-07-12 10:10:39','产品搜索'),(100,6,'夜视','2016-07-12 10:11:43','联动搜索'),(101,6,'激光,医疗','2016-07-12 10:12:24','知识搜索'),(203,7,'半导体','2016-07-16 07:22:32',NULL),(205,7,'半导体','2016-07-16 07:33:04',NULL),(206,5,'计算机','2016-07-16 07:33:31',NULL),(207,5,'计算机,材料','2016-07-16 07:33:38','知识搜索'),(208,5,'激光','2016-07-16 07:33:46',NULL),(209,5,'1','2016-07-16 07:34:27','知识搜索'),(210,5,'1','2016-07-16 07:34:28',NULL),(211,5,'1,1','2016-07-16 07:34:34',NULL),(212,5,'激光','2016-07-16 07:35:38',NULL),(213,5,'材料','2016-07-16 07:36:06',NULL),(218,5,'计算机','2016-07-16 08:06:37',NULL),(219,5,'医疗','2016-07-16 08:07:33',NULL),(226,8,'计算机','2016-07-16 11:09:53',NULL),(227,8,'激光','2016-07-16 11:10:09',NULL),(228,7,'半导体','2016-07-16 11:12:00',NULL),(262,5,'激光','2016-07-18 01:53:35',NULL),(263,5,'医疗','2016-07-18 01:54:41',NULL),(264,5,'激光','2016-07-18 02:01:03',NULL),(265,5,'才来哦','2016-07-18 02:02:32',NULL),(266,5,'材料','2016-07-18 02:02:35',NULL),(275,6,'医疗','2016-07-18 11:21:40','产品搜索'),(276,6,'医疗','2016-07-18 11:21:52','知识搜索'),(277,5,'计算机','2016-07-18 11:38:57',NULL),(278,6,'我们','2016-07-18 11:51:22','联动搜索'),(279,6,'我们,123','2016-07-18 11:51:56','知识搜索'),(281,6,'网站','2016-07-18 12:08:09','联动搜索'),(282,6,'网站','2016-07-18 12:08:13','服务搜索'),(283,6,'企业','2016-07-18 12:08:19','服务搜索'),(284,6,'网站','2016-07-18 12:08:51','联动搜索'),(285,6,'网站','2016-07-18 12:09:04','服务搜索'),(286,6,'1','2016-07-18 12:31:29','服务搜索'),(287,6,'zwp','2016-07-18 13:06:11','服务搜索'),(288,6,'激光','2016-08-01 13:38:38','联动搜索'),(289,6,'激光','2016-08-01 13:50:28','联动搜索'),(290,6,'激光','2016-08-01 13:50:35','联动搜索'),(291,6,'激光','2016-08-01 14:15:44','联动搜索'),(292,6,'z,z','2016-08-22 03:47:45','知识搜索'),(293,6,'z,1','2016-08-22 03:47:47','知识搜索'),(294,6,'z,zwc','2016-08-22 03:47:51','知识搜索'),(295,6,'z,zw','2016-08-22 03:47:54','产品搜索'),(296,6,'z','2016-08-22 03:48:00','服务搜索'),(297,6,'激光','2016-10-29 02:10:09','联动搜索'),(298,6,'服务','2016-11-01 03:17:01','联动搜索');
/*!40000 ALTER TABLE `serch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `source`
--

DROP TABLE IF EXISTS `source`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(2) DEFAULT '0',
  `rid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `url` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `source`
--

LOCK TABLES `source` WRITE;
/*!40000 ALTER TABLE `source` DISABLE KEYS */;
INSERT INTO `source` VALUES (5,1,6,10,'www.bbb.com'),(6,1,6,10,'www.tianya.cn'),(7,2,6,10,'www.tianya.cn'),(8,1,6,10,'www.baidu.com');
/*!40000 ALTER TABLE `source` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `id` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `fromid` int(11) DEFAULT NULL,
  `progress` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `datetime` int(22) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_account` varchar(255) NOT NULL,
  `user_nickname` varchar(2000) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_phone` varchar(255) DEFAULT NULL,
  `user_industry` varchar(255) DEFAULT NULL,
  `user_genre` varchar(255) DEFAULT NULL,
  `user_role` int(1) DEFAULT NULL,
  `user_location` varchar(50) DEFAULT NULL,
  `user_school` varchar(50) DEFAULT NULL,
  `work_experience` text,
  `project_experience` text,
  `user_password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'zwc1234444','张维程','19348243@qq.com','15797655753','激光','仪器',0,NULL,NULL,NULL,NULL,'c20ad4d76fe97759aa27a0c99bff6710'),(2,'rh1234','饶泓院长','19348243@qq.com','15797655753','教育/科研','激光',0,NULL,NULL,NULL,NULL,'c20ad4d76fe97759aa27a0c99bff6710'),(3,'zwc234','张三','19348243@qq.com','15797655753','电信/保险','仪器',0,NULL,NULL,NULL,NULL,'c20ad4d76fe97759aa27a0c99bff6710'),(5,'rh2222','张四','19348243@qq.com','15797655753','医药/生物','材料',0,NULL,NULL,NULL,NULL,'c20ad4d76fe97759aa27a0c99bff6710'),(6,'rh5555','饶女士','19348243@qq.com','15797655753','激光','激光',0,'南昌大学信息中心','南昌大学','一名优秀的教师1','一名优秀的教师，接手很多项目','c20ad4d76fe97759aa27a0c99bff6710'),(7,'rh6666','张先生','19348243@qq.com','15797655753','计算机','计算机',0,NULL,NULL,NULL,NULL,'c20ad4d76fe97759aa27a0c99bff6710'),(8,'rh8888','张十','19348243@qq.com','15797655753','计算机',NULL,0,NULL,NULL,NULL,NULL,'c20ad4d76fe97759aa27a0c99bff6710'),(10,'admin','超级管理员','19348243@qq.com','15797655753','22222222','2',1,'1','江西南昌大学','','','c20ad4d76fe97759aa27a0c99bff6710'),(15,'wq1234','王琦1','19348243@qq.com','15797655753','激光',NULL,0,NULL,NULL,NULL,NULL,'c20ad4d76fe97759aa27a0c99bff6710'),(16,'wq2222','王琦2','19348243@qq.com','15797655753','计算机',NULL,0,NULL,NULL,NULL,NULL,'c20ad4d76fe97759aa27a0c99bff6710'),(17,'wq1111','111111','19348243@qq.com','15797655753','计算机',NULL,0,NULL,NULL,NULL,NULL,'c20ad4d76fe97759aa27a0c99bff6710'),(18,'wq4444','王琦22','19348243@qq.com','15797655753','计算机',NULL,0,NULL,NULL,NULL,NULL,'c20ad4d76fe97759aa27a0c99bff6710'),(19,'wq5555','王琦122','19348243@qq.com','15797655753','激光',NULL,0,NULL,NULL,NULL,NULL,'c20ad4d76fe97759aa27a0c99bff6710'),(20,'wq8888','王琦4','19348243@qq.com','15797655753','激光',NULL,0,NULL,NULL,NULL,NULL,'c20ad4d76fe97759aa27a0c99bff6710'),(21,'wangning','wangning','598850098@qq.com','18679132292','激光',NULL,0,NULL,NULL,NULL,NULL,'c20ad4d76fe97759aa27a0c99bff6710'),(22,'ceshi1','test1','test1@qq.com','13312345677','计算机',NULL,0,NULL,NULL,NULL,NULL,'c20ad4d76fe97759aa27a0c99bff6710');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-06 19:59:25
