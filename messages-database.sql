-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: messages
-- ------------------------------------------------------
-- Server version	8.0.35-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `messages` (
  `id` binary(16) NOT NULL,
  `content` varchar(140) DEFAULT NULL,
  `created` int NOT NULL,
  `producer_id` binary(16) NOT NULL,
  PRIMARY KEY (`id`,`producer_id`),
  KEY `fk_messages_producers1_idx` (`producer_id`),
  CONSTRAINT `fk_messages_producers1` FOREIGN KEY (`producer_id`) REFERENCES `producers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (_binary '!*\�l>9FJ�\r3�Ͱ��','Guten Tag von Angela Merkel! ',1605579881,_binary '\r\�:Y}�M\0�2q�4T4'),(_binary '2̓�!�J�����\�','Hello World!',1605579881,_binary '�on�h�A3����2$'),(_binary 'F(����@���pq\�\�','Who is subscribed to Mr. Trump?',1605194769,_binary 'n\'\��L����7I��H'),(_binary '`l,\�HB�,[��(','Hello World!!!!!!!',1605579881,_binary '\r\�:Y}�M\0�2q�4T4'),(_binary '��/��oA�SA���!','Hello Woorrrld!!!!!!!',1605579881,_binary 'n\'\��L����7I��H'),(_binary '���\�.E��\� $e\�X','Hello Canada!',1605579881,_binary '�on�h�A3����2$'),(_binary '��\�\��NO㏘c��u\Z\�','And here Mr. Trump come again',1605194747,_binary 'n\'\��L����7I��H'),(_binary '\�\'[�+L\�@m?�|','Hello Woorrrld!!!!!!!',1605579881,_binary 'n\'\��L����7I��H'),(_binary '\�~=�\�DX�\�K\�XR\0�','Mr. Macron would like to say hello!',1605197637,_binary '؞`*A���\��Y\�'),(_binary '\�78\�Kx����\nM]f','Hello Woorld!!!!!!!',1605579881,_binary 'n\'\��L����7I��H'),(_binary '\�\��:v\�H��� �O��L','Donald Trump posted his first message',1605194709,_binary 'n\'\��L����7I��H'),(_binary '\�I�Y\\L��Xn<>�\�/','Hello World!!!!!!!',1605579881,_binary '\r\�:Y}�M\0�2q�4T4'),(_binary '�^Q�Ar�NMj\�Ky8','Hello Woorrrld!!!!!!!',1605579881,_binary 'n\'\��L����7I��H'),(_binary '�\�E[�(M��S�|��','Now France President is here as well',1605195323,_binary '؞`*A���\��Y\�');
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producers`
--

DROP TABLE IF EXISTS `producers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producers` (
  `id` binary(16) NOT NULL,
  `comment` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producers`
--

LOCK TABLES `producers` WRITE;
/*!40000 ALTER TABLE `producers` DISABLE KEYS */;
INSERT INTO `producers` VALUES (_binary '\r\�:Y}�M\0�2q�4T4','Deutschland'),(_binary '؞`*A���\��Y\�','France'),(_binary 'n\'\��L����7I��H','The U.S.A.'),(_binary '�on�h�A3����2$','Canada');
/*!40000 ALTER TABLE `producers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscribers`
--

DROP TABLE IF EXISTS `subscribers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscribers` (
  `id` binary(16) NOT NULL,
  `comment` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscribers`
--

LOCK TABLES `subscribers` WRITE;
/*!40000 ALTER TABLE `subscribers` DISABLE KEYS */;
INSERT INTO `subscribers` VALUES (_binary 'p�KTC\�L�\�dY�\�\�','Canada'),(_binary '�on�h�A3����2$','Canada'),(_binary '��K�]@ݐv\�\'\�v�\Z','Russia');
/*!40000 ALTER TABLE `subscribers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscriptions`
--

DROP TABLE IF EXISTS `subscriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscriptions` (
  `producers_id` binary(16) NOT NULL,
  `subscribers_id` binary(16) NOT NULL,
  PRIMARY KEY (`producers_id`,`subscribers_id`),
  KEY `fk_producers_has_subscribers_subscribers1_idx` (`subscribers_id`),
  KEY `fk_producers_has_subscribers_producers_idx` (`producers_id`),
  CONSTRAINT `fk_producers_has_subscribers_producers` FOREIGN KEY (`producers_id`) REFERENCES `producers` (`id`),
  CONSTRAINT `fk_producers_has_subscribers_subscribers1` FOREIGN KEY (`subscribers_id`) REFERENCES `subscribers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscriptions`
--

LOCK TABLES `subscriptions` WRITE;
/*!40000 ALTER TABLE `subscriptions` DISABLE KEYS */;
INSERT INTO `subscriptions` VALUES (_binary '؞`*A���\��Y\�',_binary 'p�KTC\�L�\�dY�\�\�'),(_binary '\r\�:Y}�M\0�2q�4T4',_binary '��K�]@ݐv\�\'\�v�\Z'),(_binary 'n\'\��L����7I��H',_binary '��K�]@ݐv\�\'\�v�\Z');
/*!40000 ALTER TABLE `subscriptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_has_roles`
--

DROP TABLE IF EXISTS `users_has_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_has_roles` (
  `roles_id` binary(16) NOT NULL,
  `users_id` binary(16) NOT NULL,
  PRIMARY KEY (`roles_id`,`users_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_has_roles`
--

LOCK TABLES `users_has_roles` WRITE;
/*!40000 ALTER TABLE `users_has_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_has_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-24 19:23:06
