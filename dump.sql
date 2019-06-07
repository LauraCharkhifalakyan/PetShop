/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.18-log : Database - pet_shop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pet_shop` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `pet_shop`;

/*Table structure for table `accessories_image` */

DROP TABLE IF EXISTS `accessories_image`;

CREATE TABLE `accessories_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

/*Data for the table `accessories_image` */

insert  into `accessories_image`(`id`,`path`) values (10,'1556355513403_images.jpg'),(11,'1556367463746_images.jpg');

/*Table structure for table `accessories_images` */

DROP TABLE IF EXISTS `accessories_images`;

CREATE TABLE `accessories_images` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) NOT NULL,
  `accessories_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `accessories_id` (`accessories_id`),
  CONSTRAINT `FKjdto7xr2gwbc61id9b8pjo9s9` FOREIGN KEY (`accessories_id`) REFERENCES `accessories` (`id`),
  CONSTRAINT `accessories_images_ibfk_1` FOREIGN KEY (`accessories_id`) REFERENCES `accessories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `accessories_images` */

insert  into `accessories_images`(`id`,`path`,`accessories_id`) values (1,'1554997664885_alogo.png',3),(2,'1554997664885_urocza-kolekcja-logo-sklepu-zoologicznego_23-2147765840.jpg',3);

/*Table structure for table `animal_category` */

DROP TABLE IF EXISTS `animal_category`;

CREATE TABLE `animal_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

/*Data for the table `animal_category` */

insert  into `animal_category`(`id`,`name`) values (12,'Dog'),(13,'Cat'),(14,'Farm'),(15,'Fish '),(16,'Reptiles'),(17,'Other');

/*Table structure for table `animal_image` */

DROP TABLE IF EXISTS `animal_image`;

CREATE TABLE `animal_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4;

/*Data for the table `animal_image` */

insert  into `animal_image`(`id`,`path`) values (63,'1556397040956__wNBgehb_400x400.jpg'),(64,'1556440319695_s-l300.jpg');

/*Table structure for table `animal_images` */

DROP TABLE IF EXISTS `animal_images`;

CREATE TABLE `animal_images` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) NOT NULL,
  `animal_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `animal_id` (`animal_id`),
  CONSTRAINT `animal_images_ibfk_1` FOREIGN KEY (`animal_id`) REFERENCES `animals` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

/*Data for the table `animal_images` */

insert  into `animal_images`(`id`,`path`,`animal_id`) values (22,'1556897609497_10181.jpg',10),(23,'1556897609516_s1200 (1).jpg',10),(24,'1556897609522_s1200.jpg',10),(25,'1556897717154_s1200 (1).jpg',11),(26,'1556897717164_s1200 (2).jpg',11),(27,'1556897717170_s1200.jpg',11),(28,'1556897758255_s1200 (2).jpg',12),(29,'1556897758261_s1200.jpg',12),(30,'1556897758267_vyglyadit_sobaka_doberman.jpg',12),(31,'1556897800425_28.JPG',13),(32,'1556897800431_453f6e5744402bd2d7ea02edddaec9f7.jpg',13),(33,'1556897800437_org_2017081413181580479.JPG',13),(34,'1556906938742_macaw-ara-1.jpg',14),(35,'1556906938752_orig (1).jpg',14),(36,'1556906938760_orig.jpg',14),(37,'1557317341949_39312666-twee-siberische-husky-puppies-zoenen-op-een-witte-achtergrond-geïsoleerd.jpg',15),(38,'1557317341957_husky-6.jpg',15),(39,'1557317341963_siberian-husky-price.jpg',15),(40,'1557610118834_cow-in-pasture.jpg.653x0_q80_crop-smart.jpg',16),(41,'1557610118842_dairy-cow500.jpg',16),(42,'1557610118849_eight_col_20478092_xxl.jpg',16),(43,'1557611524738_4694899147_fcd4b69350_o.jpg',17),(44,'1557611524743_fotolia_6187031_XS.jpg',17),(45,'1557611524748_Hu5pFU.jpg',17),(46,'1557611524755_lg_39290_Red_Ryukin.jpg',17),(47,'1557613675201_1a9ffd728d5dcf0a72bf12cc588f08f2.jpg',18),(48,'1557613675208_featured-choosing-new-bird-011019-tile-250w-175h.png',18),(49,'1557613675213_stephanophorus_diadematus.jpg',18),(50,'1557647565200_4694899147_fcd4b69350_o.jpg',19),(51,'1557647565209_Acute-Dog-Diarrhea-47066074.jpg',19),(52,'1557647565213_Bird-vet.jpg',19),(53,'1557647565217_dairy-cow500.jpg',19);

/*Table structure for table `animals` */

DROP TABLE IF EXISTS `animals`;

CREATE TABLE `animals` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `short_text` varchar(255) DEFAULT NULL,
  `description` text,
  `location` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `breed` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `pic_url` varchar(255) DEFAULT NULL,
  `views_count` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `FKavks7tk1yyxmv4ald7qanatf5` (`category_id`),
  CONSTRAINT `FKavks7tk1yyxmv4ald7qanatf5` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `animals_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `animals` */

insert  into `animals`(`id`,`title`,`short_text`,`description`,`location`,`color`,`weight`,`breed`,`size`,`dob`,`age`,`gender`,`price`,`created_date`,`user_id`,`category_id`,`pic_url`,`views_count`) values (10,'Rotfeller','qqqqq','qqq','qqq','qq','qqqq','qqq','qqq','2019-05-03','2','FEMALE','$124,500',NULL,NULL,1,'1556897609466_6a4eb33373f0.jpg',23),(11,'German Shephard','zzzz','zzzz','zzzz','zzzz','zzzz','zzzz','zzz','2019-03-01','1','MALE','$102,700',NULL,NULL,1,'1556897717127_sobaki-zhivotnye-43403.jpg',3),(12,'Doberman','cccc','ccc','ccc','ccc','ccc','cc','cc','2019-02-02','3','FEMALE','$74,895',NULL,NULL,1,'1556897758247_s1200 (1).jpg',10),(13,'Maine Coon','bb','bb','bb','bb','bb','bb','bb','2018-09-07','2','MALE','$227,300',NULL,NULL,2,'1556897800417_1422296942.jpg',7),(14,'Ara Parrot','gew','gewg','ew','gew','gew','gew','gew','2019-04-13','1','FEMALE','$33,333',NULL,NULL,4,'1556906938714_popugay_ara.600x600.jpg',5),(15,'Shunik','Сибирские хаски родом с бескрайних заснеженных просторов Сибири. В этих краях люди были вынуждены искать себе не просто спутника, а верного друга и надежного помощника.','Разновидности той или иной породы обычно создаются с целью улучшения стандартных характеристик. Чтобы порода стала завершенной и получила статус официальной, необходим ряд формальностей.','Gyumri','Black and white','25kg','Husky','','2019-05-02','1 year','MALE','$3000',NULL,NULL,1,'1557317341929_husky-5.jpg',28),(16,'Cow','If you\'re a fan of humanely raised, sustainable beef, you may want to become a \'steakholder.\'','Cow sharing, or cowpooling, isn\'t anything new. Buying a portion of a cow is something people have done ever since the invention of refrigerators and freezers. With the increased focus on humanely raised meat over the past 15 years or so, cow sharing has become popular — as long as you have the freezer storage for a quarter or half of a cow. ','Vanadzor','White, Black','250kg','German Cow','2m','2019-05-12','8month','FEMALE','$300',NULL,NULL,6,'1557610118815_250px-Cow_female_black_white.jpg',7),(17,'Gold Fish','Redfish is a common name for several species of fish','It is most commonly applied to certain deep-sea rockfish in the genus Sebastes, or the reef dwelling snappers in the genus Lutjanus. It is also applied to the slimeheads or roughies (family Trachichthyidae), and the alfonsinos (Berycidae). ','Gyumri','Red','120g','Red Fish','5cm','2019-05-12','20 day','MALE','$15',NULL,NULL,3,'1557611524727_goldfish-gold-fish-generic_240x180_41455699490.jpg',1),(18,'BRAZIL Birding','Diademed Tanager   Stephanophorus diadematus','Diademed Tanager   Stephanophorus diadematusDiademed Tanager   Stephanophorus diadematusDiademed Tanager   Stephanophorus diadematusDiademed Tanager   Stephanophorus diadematusDiademed Tanager   Stephanophorus diadematus','Brasil','Blue','25g','Diadematus','10cm','2019-05-12','1 month','FEMALE','$50',NULL,NULL,4,'1557613675193_21922_stephanophorus_diadematus.jpg',2),(19,'Kria','hdgjhgjhgjjlkj','llkjlk','Gyumri','Black','20kg','Soghun','50cm','2019-05-12','5 year','MALE','$700',NULL,NULL,5,'1557647565180_cow-in-pasture.jpg.653x0_q80_crop-smart.jpg',1);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`name`) values (1,'Dog'),(2,'Cat'),(3,'Fish'),(4,'Bird'),(5,'Reptiles'),(6,'Mammal'),(7,'Other');

/*Table structure for table `feed_category` */

DROP TABLE IF EXISTS `feed_category`;

CREATE TABLE `feed_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `feed_category` */

/*Table structure for table `feed_image` */

DROP TABLE IF EXISTS `feed_image`;

CREATE TABLE `feed_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

/*Data for the table `feed_image` */

insert  into `feed_image`(`id`,`path`) values (14,'1556355418048_1b13d52cad048fa2640b45f2d3fbe4949933c77d.jpg'),(15,'1556355418169_images.jpg'),(16,'1556367409022_images.jpg');

/*Table structure for table `feed_images` */

DROP TABLE IF EXISTS `feed_images`;

CREATE TABLE `feed_images` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) NOT NULL,
  `feed_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `feed_id` (`feed_id`),
  CONSTRAINT `feed_images_ibfk_1` FOREIGN KEY (`feed_id`) REFERENCES `feed` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `feed_images` */

/*Table structure for table `for_dog_accessory` */

DROP TABLE IF EXISTS `for_dog_accessory`;

CREATE TABLE `for_dog_accessory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `for_dog_accessory` */

insert  into `for_dog_accessory`(`id`,`name`) values (1,'Sofas'),(2,'Huses'),(3,'Sun beds'),(4,'Carryng bags'),(5,'Clothing');

/*Table structure for table `for_kat_accessory` */

DROP TABLE IF EXISTS `for_kat_accessory`;

CREATE TABLE `for_kat_accessory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

/*Data for the table `for_kat_accessory` */

insert  into `for_kat_accessory`(`id`,`name`) values (5,'Houses'),(6,'Sun beds'),(7,'Carryng bads'),(8,'Clothing ');

/*Table structure for table `other_accessory` */

DROP TABLE IF EXISTS `other_accessory`;

CREATE TABLE `other_accessory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `other_accessory` */

insert  into `other_accessory`(`id`,`name`) values (1,'Aquarium'),(2,'Oars'),(3,'Limbs'),(4,'Belts'),(5,'Other');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_type` enum('ADMIN','USER') NOT NULL DEFAULT 'USER',
  `phone_number` varchar(255) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `created_date` date NOT NULL,
  PRIMARY KEY (`id`,`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
