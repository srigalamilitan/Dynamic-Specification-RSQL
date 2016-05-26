/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.0.21-MariaDB : Database - ptcd
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ptcd` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ptcd`;

/*Table structure for table `table_testing_rsql` */

DROP TABLE IF EXISTS `table_testing_rsql`;

CREATE TABLE `table_testing_rsql` (
  `id` bigint(20) NOT NULL,
  `date_test` date DEFAULT NULL,
  `big_decimal_test` decimal(38,10) DEFAULT NULL,
  `date_time_test` datetime DEFAULT NULL,
  `varchar_test` varchar(100) DEFAULT NULL,
  `int_test` int(11) DEFAULT NULL,
  `float_test` float(10,1) DEFAULT NULL,
  `char_test` char(1) DEFAULT NULL,
  `double_test` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `table_testing_rsql` */

insert  into `table_testing_rsql`(`id`,`date_test`,`big_decimal_test`,`date_time_test`,`varchar_test`,`int_test`,`float_test`,`char_test`,`double_test`) values (1,'2016-05-24',1234556.1234567890,'2016-05-24 15:03:56','One',1,1.1,'A',156789.56789),(2,'2016-05-25',32132131.0000000000,'2016-05-25 15:04:38','Two',2,2.2,'B',1.456789),(3,'2016-05-26',87655.0000000000,'2016-05-26 15:05:15','Three',3,3.3,'C',0.654321),(4,'2016-05-27',123123.0000000000,'2016-05-27 15:05:40','Four',4,4.4,'D',1.56789),(5,'2016-05-28',5433.0000000000,'2016-05-28 15:06:14','Five',5,5.5,'E',8.56789);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
