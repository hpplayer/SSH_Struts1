/*
SQLyog Enterprise - MySQL GUI v6.03
Host - 5.0.24a-community-nt : Database - studb
*********************************************************************
Server version : 5.0.24a-community-nt
*/
/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `studb`;

USE `studb`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`id`,`username`,`password`) values (1,'xmh','xmh'),(2,'zah','zah'),(3,'天涯浪子','123'),(4,'无怨无悔','345'),(5,'大漠佳人','321'),(6,'小小栅栏','632'),(7,'俏丽佳人','987');
