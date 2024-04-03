-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: webp2
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `work_recode`
--

DROP TABLE IF EXISTS `work_recode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_recode` (
  `id` int NOT NULL,
  `work_name` varchar(50) NOT NULL,
  `start` datetime NOT NULL,
  `end` datetime NOT NULL,
  `delete_key` int NOT NULL,
  `work_memo` varchar(1200) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_recode`
--

LOCK TABLES `work_recode` WRITE;
/*!40000 ALTER TABLE `work_recode` DISABLE KEYS */;
INSERT INTO `work_recode` VALUES (1,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(2,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(3,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(4,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(5,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(6,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(7,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(8,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(9,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(10,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(11,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(12,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(13,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(14,'仕事A','2024-03-15 12:00:00','2024-03-04 00:00:00',0,'雑用',1),(15,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(16,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(17,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(18,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(19,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(20,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(21,'testA','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(22,'仕事A','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(23,'testA','2024-03-03 00:00:00','2024-03-04 00:00:00',0,'雑用',1),(24,'testA','2024-03-15 14:50:00','2024-03-15 14:50:00',0,'aaa',1),(25,'testA','2024-03-15 15:03:00','2024-03-15 15:03:00',0,'bbb',1),(26,'testA','2024-03-15 15:44:00','2024-03-15 15:44:00',0,'2024年03月15日15:44',1),(27,'testA','2024-03-15 16:12:00','2024-03-15 16:12:00',0,'ccc',1),(28,'testA','2024-03-15 16:19:00','2024-03-15 16:19:00',0,'ccc',1),(29,'仕事A','2024-03-15 16:20:00','2024-03-15 16:20:00',0,'',1),(30,'仕事A','2024-03-17 01:50:00','2024-03-17 01:50:00',0,'',1),(31,'仕事A','2024-03-18 15:11:00','2024-03-18 15:11:00',0,'',1),(32,'仕事A','2024-03-18 15:15:00','2024-03-18 15:15:00',0,'',1);
/*!40000 ALTER TABLE `work_recode` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-03 16:52:51
