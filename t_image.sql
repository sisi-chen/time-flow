# Host: localhost  (Version: 5.5.46)
# Date: 2016-09-14 09:58:53
# Generator: MySQL-Front 5.3  (Build 2.42)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

USE `iteam`;

#
# Source for table "t_image"
#

DROP TABLE IF EXISTS `t_image`;
CREATE TABLE `t_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;

#
# Data for table "t_image"
#

INSERT INTO `t_image` VALUES (84,'1111','upload/house2.jpg'),(85,'1111','upload/house2.jpg'),(86,'很好看','upload/man1.jpg'),(87,'笑的很开心','upload/man3.jpg'),(88,'哈哈','upload/man2.jpg'),(89,'嘻嘻','upload/t1.jpg'),(90,'嘻嘻哈哈','upload/t3.jpg'),(91,'ssss','upload/t7.jpg'),(92,'ssss','upload/t7.jpg'),(93,'ddddd','upload/t6.jpg'),(94,'滚滚滚滚滚g','upload/t3.jpg'),(95,'点点点点点点','upload/t5.jpg'),(96,'点点点点点点','upload/t2.jpg'),(97,'嘿嘿嘿嘿嘿嘿嘿嘿','upload/t7.jpg'),(98,'嘎嘎嘎嘎嘎嘎过','upload/t5.jpg'),(99,'111111','upload/t7.jpg'),(100,'11111','upload/error.png'),(101,'22222','upload/account_out.png'),(102,'22222','upload/account_out.png');

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
