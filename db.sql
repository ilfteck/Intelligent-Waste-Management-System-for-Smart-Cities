/*
SQLyog Ultimate v11.3 (64 bit)
MySQL - 5.7.32-log : Database - garbage_classification_and_recycling
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`garbage_classification_and_recycling` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `garbage_classification_and_recycling`;

/*Table structure for table `transport` */

DROP TABLE IF EXISTS `transport`;

CREATE TABLE `transport` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID ',
  `recycle_reserve_id` int(11) DEFAULT NULL COMMENT 'recycle reserve id',
  `transport_name` varchar(200) DEFAULT NULL COMMENT 'transport name  Search111 ',
  `transport_uuid_number` varchar(200) DEFAULT NULL COMMENT 'transport uuid number',
  `transport_photo` varchar(200) DEFAULT NULL COMMENT 'transport photo',
  `transport_address` varchar(200) DEFAULT NULL COMMENT 'transport address',
  `transport_types` int(11) DEFAULT NULL COMMENT 'transport types Search111',
  `transport_mudi_address` varchar(200) DEFAULT NULL COMMENT 'transport mudi address',
  `transport_content` longtext COMMENT 'transport content ',
  `transport_delete` int(11) DEFAULT NULL COMMENT 'transport delete',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT 'insert time',
  `create_time` timestamp NULL DEFAULT NULL COMMENT 'create time  show1 show2 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='运输';

/*Data for the table `transport` */

insert  into `transport`(`id`,`recycle_reserve_id`,`transport_name`,`transport_uuid_number`,`transport_photo`,`transport_address`,`transport_types`,`transport_mudi_address`,`transport_content`,`transport_delete`,`insert_time`,`create_time`) values (1,1,'transport name1','1679369909491','upload/transport1.jpg','transport address1',3,'transport mudi address1','transport content1',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(2,2,'transport name2','1679369909477','upload/transport2.jpg','transport address2',1,'transport mudi address2','transport content2',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(3,3,'transport name3','1679369909461','upload/transport3.jpg','transport address3',1,'transport mudi address3','transport content3',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(4,4,'transport name4','1679369909433','upload/transport4.jpg','transport address4',3,'transport mudi address4','transport content4',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(5,5,'transport name5','1679369909450','upload/transport5.jpg','transport address5',2,'transport mudi address5','transport content5',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(6,6,'transport name6','1679369909501','upload/transport6.jpg','transport address6',4,'transport mudi address6','transport content6',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(7,7,'transport name7','1679369909474','upload/transport7.jpg','transport address7',3,'transport mudi address7','transport content7',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(8,8,'transport name8','1679369909445','upload/transport8.jpg','transport address8',2,'transport mudi address8','transport content8',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(9,9,'transport name9','1679369909424','upload/transport9.jpg','transport address9',2,'transport mudi address9','transport content9',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(10,10,'transport name10','1679369909415','upload/transport10.jpg','transport address10',3,'transport mudi address10','transport content10',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(11,11,'transport name11','1679369909505','upload/transport11.jpg','transport address11',1,'transport mudi address11','transport content11',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(12,12,'transport name12','1679369909434','upload/transport12.jpg','transport address12',4,'transport mudi address12','transport content12',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(13,13,'transport name13','1679369909506','upload/transport13.jpg','transport address13',1,'transport mudi address13','transport content13',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(14,14,'transport name14','1679369909438','upload/transport14.jpg','transport address14',1,'transport mudi address14','transport content14',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(15,16,'111','1679376162582','/upload/1679376177983.jpg','家里',3,'12651','<p>手打打算</p>',1,'2023-03-21 13:23:00','2023-03-21 13:23:00');

/*Table structure for table `config` */

DROP TABLE IF EXISTS `config`;

CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(100) NOT NULL COMMENT 'Configuration parameter name',
  `value` varchar(100) DEFAULT NULL COMMENT 'Configuration parameter value',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Configuration file';

/*Data for the table `config` */

/*Table structure for table `dictionary` */

DROP TABLE IF EXISTS `dictionary`;

CREATE TABLE `dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `dic_code` varchar(200) DEFAULT NULL COMMENT 'dic code',
  `dic_name` varchar(200) DEFAULT NULL COMMENT 'dic name',
  `code_index` int(11) DEFAULT NULL COMMENT 'code index',
  `index_name` varchar(200) DEFAULT NULL COMMENT 'index name  Search111 ',
  `super_id` int(11) DEFAULT NULL COMMENT 'super idid',
  `remark` varchar(200) DEFAULT NULL COMMENT 'remark',
  `create_time` timestamp NULL DEFAULT NULL COMMENT 'create time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='dictionary';

/*Data for the table `dictionary` */

insert  into `dictionary`(`id`,`dic_code`,`dic_name`,`code_index`,`index_name`,`super_id`,`beizhu`,`create_time`) values (1,'sex_types','sex types',1,'man',NULL,NULL,'2023-03-21 11:37:24'),(2,'sex_types','sex types',2,'woman',NULL,NULL,'2023-03-21 11:37:24'),(3,'announcement_types','announcement types',1,'announcement types1',NULL,NULL,'2023-03-21 11:37:24'),(4,'announcement_types','announcement types',2,'announcement types2',NULL,NULL,'2023-03-21 11:37:24'),(5,'recycle_types','recycle types',1,'recycle types1',NULL,NULL,'2023-03-21 11:37:24'),(6,'recycle_types','recycle types',2,'recycle types2',NULL,NULL,'2023-03-21 11:37:24'),(7,'recycle_types','recycle types',3,'recycle types3',NULL,NULL,'2023-03-21 11:37:24'),(8,'recycle_types','recycle types',4,'recycle types4',NULL,NULL,'2023-03-21 11:37:24'),(9,'recycle_reserve_yesno_types','Application status',1,'review',NULL,NULL,'2023-03-21 11:37:24'),(10,'recycle_reserve_yesno_types','Application status',2,'yes',NULL,NULL,'2023-03-21 11:37:24'),(11,'recycle_reserve_yesno_types','Application status',3,'no',NULL,NULL,'2023-03-21 11:37:24'),(12,'transport_types','transport types',1,'transport types1',NULL,NULL,'2023-03-21 11:37:24'),(13,'transport_types','transport types',2,'transport types2',NULL,NULL,'2023-03-21 11:37:24'),(14,'transport_types','transport types',3,'transport types3',NULL,NULL,'2023-03-21 11:37:24'),(15,'transport_types','transport types',4,'transport types4',NULL,NULL,'2023-03-21 11:37:24');

/*Table structure for table `announcement` */

DROP TABLE IF EXISTS `announcement`;

CREATE TABLE `announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID ',
  `announcement_name` varchar(200) DEFAULT NULL COMMENT 'announcement name Search111  ',
  `announcement_photo` varchar(200) DEFAULT NULL COMMENT 'announcement photo ',
  `announcement_types` int(11) NOT NULL COMMENT 'announcement types Search111 ',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT 'insert time ',
  `announcement_content` longtext COMMENT 'announcement content ',
  `create_time` timestamp NULL DEFAULT NULL COMMENT 'create time show1 show2 nameShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='announcement';

/*Data for the table `announcement` */

insert  into `announcement`(`id`,`announcement_name`,`announcement_photo`,`announcement_types`,`insert_time`,`announcement_content`,`create_time`) values (1,'announcement name1','upload/announcement1.jpg',2,'2023-03-21 11:38:29','announcement content1','2023-03-21 11:38:29'),(2,'announcement name2','upload/announcement2.jpg',2,'2023-03-21 11:38:29','announcement content2','2023-03-21 11:38:29'),(3,'announcement name3','upload/announcement3.jpg',1,'2023-03-21 11:38:29','announcement content3','2023-03-21 11:38:29'),(4,'announcement name4','upload/announcement4.jpg',1,'2023-03-21 11:38:29','announcement content4','2023-03-21 11:38:29'),(5,'announcement name5','upload/announcement5.jpg',1,'2023-03-21 11:38:29','announcement content5','2023-03-21 11:38:29'),(6,'announcement name6','upload/announcement6.jpg',1,'2023-03-21 11:38:29','announcement content6','2023-03-21 11:38:29'),(7,'announcement name7','upload/announcement7.jpg',2,'2023-03-21 11:38:29','announcement content7','2023-03-21 11:38:29'),(8,'announcement name8','upload/announcement8.jpg',1,'2023-03-21 11:38:29','announcement content8','2023-03-21 11:38:29'),(9,'announcement name9','upload/announcement9.jpg',1,'2023-03-21 11:38:29','announcement content9','2023-03-21 11:38:29'),(10,'announcement name10','upload/announcement10.jpg',2,'2023-03-21 11:38:29','announcement content10','2023-03-21 11:38:29'),(11,'announcement name11','upload/announcement11.jpg',1,'2023-03-21 11:38:29','announcement content11','2023-03-21 11:38:29'),(12,'announcement name12','upload/announcement12.jpg',2,'2023-03-21 11:38:29','announcement content12','2023-03-21 11:38:29'),(13,'announcement name13','upload/announcement13.jpg',1,'2023-03-21 11:38:29','announcement content13','2023-03-21 11:38:29'),(14,'announcement name14','upload/announcement14.jpg',2,'2023-03-21 11:38:29','announcement content14','2023-03-21 11:38:29');

/*Table structure for table `recycle` */

DROP TABLE IF EXISTS `recycle`;

CREATE TABLE `recycle` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID ',
  `recycle_name` varchar(200) DEFAULT NULL COMMENT 'recycle name  Search111 ',
  `recycle_uuid_number` varchar(200) DEFAULT NULL COMMENT 'recycle uuid number',
  `recycle_photo` varchar(200) DEFAULT NULL COMMENT 'recycle photo',
  `recycle_address` varchar(200) DEFAULT NULL COMMENT 'recycle address',
  `recycle_types` int(11) DEFAULT NULL COMMENT 'recycle types Search111',
  `recycle_kucun_number` int(11) DEFAULT NULL COMMENT 'recycle kucun number',
  `recycle_time` timestamp NULL DEFAULT NULL COMMENT 'recycle time',
  `recycle_content` longtext COMMENT 'recycle content ',
  `recycle_delete` int(11) DEFAULT NULL COMMENT 'transport delete',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT 'insert time',
  `create_time` timestamp NULL DEFAULT NULL COMMENT 'create time  show1 show2 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='recycle';

/*Data for the table `recycle` */

insert  into `recycle`(`id`,`recycle_name`,`recycle_uuid_number`,`recycle_photo`,`recycle_address`,`recycle_types`,`recycle_kucun_number`,`recycle_time`,`recycle_content`,`recycle_delete`,`insert_time`,`create_time`) values (1,'recycle name1','1679369909448','upload/recycle1.jpg','recycle address1',4,101,'2023-03-21 11:38:29','recycle content1',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(2,'recycle name2','1679369909479','upload/recycle2.jpg','recycle address2',3,102,'2023-03-21 11:38:29','recycle content2',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(3,'recycle name3','1679369909487','upload/recycle3.jpg','recycle address3',1,103,'2023-03-21 11:38:29','recycle content3',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(4,'recycle name4','1679369909445','upload/recycle4.jpg','recycle address4',4,104,'2023-03-21 11:38:29','recycle content4',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(5,'recycle name5','1679369909496','upload/recycle5.jpg','recycle address5',2,105,'2023-03-21 11:38:29','recycle content5',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(6,'recycle name6','1679369909499','upload/recycle6.jpg','recycle address6',3,106,'2023-03-21 11:38:29','recycle content6',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(7,'recycle name7','1679369909457','upload/recycle7.jpg','recycle address7',3,107,'2023-03-21 11:38:29','recycle content7',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(8,'recycle name8','1679369909448','upload/recycle8.jpg','recycle address8',3,108,'2023-03-21 11:38:29','recycle content8',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(9,'recycle name9','1679369909516','upload/recycle9.jpg','recycle address9',3,109,'2023-03-21 11:38:29','recycle content9',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(10,'recycle name10','1679369909452','upload/recycle10.jpg','recycle address10',3,1010,'2023-03-21 11:38:29','recycle content10',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(11,'recycle name11','1679369909517','upload/recycle11.jpg','recycle address11',1,1011,'2023-03-21 11:38:29','recycle content11',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(12,'recycle name12','1679369909505','upload/recycle12.jpg','recycle address12',2,1012,'2023-03-21 11:38:29','recycle content12',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(13,'recycle name13','1679369909472','upload/recycle13.jpg','recycle address13',1,1013,'2023-03-21 11:38:29','recycle content13',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(14,'recycle name14','1679369909498','upload/recycle14.jpg','recycle address14',1,1014,'2023-03-21 11:38:29','recycle content14',1,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(15,'111','1679370417527','/upload/1679370435476.jpg','地点',1,50,'2023-03-21 11:47:10','<p>呀呀呀</p>',2,'2023-03-21 11:47:19','2023-03-21 11:47:19'),(16,'11','1679375989240','/upload/1679375999499.jpg','165',3,23,'2023-03-21 13:19:56','<p>525162</p>',1,'2023-03-21 13:20:01','2023-03-21 13:20:01');

/*Table structure for table `recycle_reserve` */

DROP TABLE IF EXISTS `recycle_reserve`;

CREATE TABLE `recycle_reserve` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `recycle_reserve_uuid_number` varchar(200) DEFAULT NULL COMMENT 'recycle reserve uuid number Search111 ',
  `recycle_id` int(11) DEFAULT NULL COMMENT 'recycle',
  `member_id` int(11) DEFAULT NULL COMMENT 'User',
  `recycle_reserve_text` longtext COMMENT 'Reason for registration',
  `recycle_transport_time` timestamp NULL DEFAULT NULL COMMENT 'recycle transport time',
  `recycle_reserve_yesno_types` int(11) DEFAULT NULL COMMENT 'Application status Search111 ',
  `recycle_reserve_yesno_text` longtext COMMENT 'Review reply',
  `recycle_reserve_shenhe_time` timestamp NULL DEFAULT NULL COMMENT 'Audit time',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT 'Event registration time',
  `create_time` timestamp NULL DEFAULT NULL COMMENT 'create time show3 listShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='Garbage disposal application';

/*Data for the table `recycle_reserve` */

insert  into `recycle_reserve`(`id`,`recycle_reserve_uuid_number`,`recycle_id`,`member_id`,`recycle_reserve_text`,`recycle_transport_time`,`recycle_reserve_yesno_types`,`recycle_reserve_yesno_text`,`recycle_reserve_shenhe_time`,`insert_time`,`create_time`) values (1,'1679369909425',1,1,'Reason for registration1','2023-03-21 11:38:29',3,NULL,NULL,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(2,'1679369909463',2,1,'Reason for registration2','2023-03-21 11:38:29',3,NULL,NULL,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(3,'1679369909451',3,3,'Reason for registration3','2023-03-21 11:38:29',3,NULL,NULL,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(4,'1679369909453',4,1,'Reason for registration4','2023-03-21 11:38:29',3,NULL,NULL,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(5,'1679369909504',5,1,'Reason for registration5','2023-03-21 11:38:29',3,NULL,NULL,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(6,'1679369909502',6,1,'Reason for registration6','2023-03-21 11:38:29',3,NULL,NULL,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(7,'1679369909474',7,3,'Reason for registration7','2023-03-21 11:38:29',3,NULL,NULL,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(8,'1679369909482',8,1,'Reason for registration8','2023-03-21 11:38:29',3,NULL,NULL,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(9,'1679369909424',9,3,'Reason for registration9','2023-03-21 11:38:29',3,NULL,NULL,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(10,'1679369909436',10,1,'Reason for registration10','2023-03-21 11:38:29',3,NULL,NULL,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(11,'1679369909445',11,3,'Reason for registration11','2023-03-21 11:38:29',3,NULL,NULL,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(12,'1679369909440',12,3,'Reason for registration12','2023-03-21 11:38:29',3,NULL,NULL,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(13,'1679369909483',13,2,'Reason for registration13','2023-03-21 11:38:29',2,NULL,NULL,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(14,'1679369909521',14,1,'Reason for registration14','2023-03-21 11:38:29',2,NULL,NULL,'2023-03-21 11:38:29','2023-03-21 11:38:29'),(16,'1679376005057',16,1,'26','2023-03-21 13:20:09',2,'好的','2023-03-21 13:21:03',NULL,NULL);

/*Table structure for table `token` */

DROP TABLE IF EXISTS `token`;

CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `userid` bigint(20) NOT NULL COMMENT 'useridid',
  `username` varchar(100) NOT NULL COMMENT 'username',
  `tablename` varchar(100) DEFAULT NULL COMMENT 'tablename',
  `role` varchar(100) DEFAULT NULL COMMENT 'role',
  `token` varchar(200) NOT NULL COMMENT 'password',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'addtime',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'expiratedtime',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='token table';

/*Data for the table `token` */

insert  into `token`(`id`,`userid`,`username`,`tablename`,`role`,`token`,`addtime`,`expiratedtime`) values (1,1,'admin','users','Administrator','mkxs5e7yjybvtk0gkf7p538x12vqcjoh','2023-03-21 11:43:09','2023-03-21 14:20:31'),(2,1,'a1','member','User','eaumo6537amrc6t7brkbhkq9xsdirl40','2023-03-21 11:45:33','2023-03-21 14:19:16');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(100) NOT NULL COMMENT 'username',
  `password` varchar(100) NOT NULL COMMENT 'password',
  `role` varchar(100) DEFAULT 'Administrator' COMMENT 'role',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'addtime',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Administrator';

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`role`,`addtime`) values (1,'admin','admin','Administrator','2023-03-21 11:37:24');

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(200) DEFAULT NULL COMMENT 'account',
  `password` varchar(200) DEFAULT NULL COMMENT 'password',
  `member_name` varchar(200) DEFAULT NULL COMMENT 'User name Search111 ',
  `member_phone` varchar(200) DEFAULT NULL COMMENT 'User phone',
  `member_id_number` varchar(200) DEFAULT NULL COMMENT 'User id number',
  `member_photo` varchar(200) DEFAULT NULL COMMENT 'User photo',
  `sex_types` int(11) DEFAULT NULL COMMENT 'sex',
  `member_email` varchar(200) DEFAULT NULL COMMENT 'User email',
  `create_time` timestamp NULL DEFAULT NULL COMMENT 'create time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='User';

/*Data for the table `member` */

insert  into `member`(`id`,`username`,`password`,`member_name`,`member_phone`,`member_id_number`,`member_photo`,`sex_types`,`member_email`,`create_time`) values (1,'a1','123456','User姓名1','17703786901','410224199010102001','upload/member1.jpg',1,'1@qq.com','2023-03-21 11:38:29'),(2,'a2','123456','User姓名2','17703786902','410224199010102002','upload/member2.jpg',2,'2@qq.com','2023-03-21 11:38:29'),(3,'a3','123456','User姓名3','17703786903','410224199010102003','upload/member3.jpg',1,'3@qq.com','2023-03-21 11:38:29');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
