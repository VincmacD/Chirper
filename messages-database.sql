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
INSERT INTO `messages` VALUES (_binary '!*\∆l>9FJÉ\r3˙Õ∞ô´','Guten Tag von Angela Merkel! ',1605579881,_binary '\r\–:Y}ºM\0Å2q≥4T4'),(_binary '2ÕÉ!¸JØ˛ó°´\€','Hello World!',1605579881,_binary 'åon∑hæA3í©¶Ü2$'),(_binary 'F(î≤µ°@à∑Øpq\÷\”','Who is subscribed to Mr. Trump?',1605194769,_binary 'n\'\ÍßLâØàÅ7I®ΩH'),(_binary '`l,\’HB§,[˝â(','Hello World!!!!!!!',1605579881,_binary '\r\–:Y}ºM\0Å2q≥4T4'),(_binary 'ßï/Ö©oAôSAâ±ë!','Hello Woorrrld!!!!!!!',1605579881,_binary 'n\'\ÍßLâØàÅ7I®ΩH'),(_binary '±Éó\„.EªÜ\Œ $e\·X','Hello Canada!',1605579881,_binary 'åon∑hæA3í©¶Ü2$'),(_binary '∑°\»\’¿NO„èòcíªu\Z\Ÿ','And here Mr. Trump come again',1605194747,_binary 'n\'\ÍßLâØàÅ7I®ΩH'),(_binary '\∆\'[ç+L\‚Ω@m?ø|','Hello Woorrrld!!!!!!!',1605579881,_binary 'n\'\ÍßLâØàÅ7I®ΩH'),(_binary '\ﬂ~=è\·öDX∫\÷K\ÁXR\0ı','Mr. Macron would like to say hello!',1605197637,_binary 'ÿû`*AÜØø\‡õY\Î'),(_binary '\Âª78\ŒKx°ˇÆ¨\nM]f','Hello Woorld!!!!!!!',1605579881,_binary 'n\'\ÍßLâØàÅ7I®ΩH'),(_binary '\Â\∆Ò:v\÷H∂Å ∑O©L','Donald Trump posted his first message',1605194709,_binary 'n\'\ÍßLâØàÅ7I®ΩH'),(_binary '\ÈI≥Y\\L£áXn<>¡\Ó/','Hello World!!!!!!!',1605579881,_binary '\r\–:Y}ºM\0Å2q≥4T4'),(_binary 'π†^QíArÜNMj\œKy8','Hello Woorrrld!!!!!!!',1605579881,_binary 'n\'\ÍßLâØàÅ7I®ΩH'),(_binary '¸\ÃE[ˇ(M˝ÅS|Üë','Now France President is here as well',1605195323,_binary 'ÿû`*AÜØø\‡õY\Î');
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
INSERT INTO `producers` VALUES (_binary '\r\–:Y}ºM\0Å2q≥4T4','Deutschland'),(_binary 'ÿû`*AÜØø\‡õY\Î','France'),(_binary 'n\'\ÍßLâØàÅ7I®ΩH','The U.S.A.'),(_binary 'åon∑hæA3í©¶Ü2$','Canada');
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
INSERT INTO `subscribers` VALUES (_binary 'p¶KTC\√Lª\ÏdY˜\‡\Ã','Canada'),(_binary 'åon∑hæA3í©¶Ü2$','Canada'),(_binary '´∞Kü]@›êv\Î\'\ vâ\Z','Russia');
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
INSERT INTO `subscriptions` VALUES (_binary 'ÿû`*AÜØø\‡õY\Î',_binary 'p¶KTC\√Lª\ÏdY˜\‡\Ã'),(_binary '\r\–:Y}ºM\0Å2q≥4T4',_binary '´∞Kü]@›êv\Î\'\ vâ\Z'),(_binary 'n\'\ÍßLâØàÅ7I®ΩH',_binary '´∞Kü]@›êv\Î\'\ vâ\Z');
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
