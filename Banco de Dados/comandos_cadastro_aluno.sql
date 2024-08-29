-- CREATE DATABASE  IF NOT EXISTS `Teste` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
-- USE `Teste`;
-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: 200.18.128.50    Database: profasuelen
-- ------------------------------------------------------
-- Server version	8.0.26-0ubuntu0.20.04.2

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
-- Table structure for table `aluno`
--

create database faculdade;
use faculdade;
DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `profissao` varchar(20) DEFAULT NULL,
  `nascimento` date DEFAULT NULL,
  `sexo` enum('M','F') DEFAULT NULL,
  `peso` decimal(5,2) DEFAULT NULL,
  `altura` decimal(3,2) DEFAULT NULL,
  `nacionalidade` varchar(20) DEFAULT 'Brasil',
  `cursopreferido` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cursopreferido` (`cursopreferido`),
  CONSTRAINT `aluno_ibfk_1` FOREIGN KEY (`cursopreferido`) REFERENCES `curso` (`idcurso`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'Daniel Morais','Auxiliar Administrat','1984-01-02','M',78.50,1.83,'Brasil',3),(2,'Talita Nascimento','Farmacêutico','1999-12-30','F',35.90,1.65,'Portugal',20),(3,'Emerson Gabriel','Programador','1920-12-30','M',50.20,1.65,'Moçambique',7),(4,'Lucas Damasceno','Auxiliar Administrat','1930-11-02','M',63.20,1.75,'Irlanda',20),(5,'Leila Martins','Farmacêutico','1975-04-22','F',99.00,2.15,'Brasil',3),(6,'Letícia Neves','Programador','1999-12-03','F',87.00,2.00,'Brasil',7),(7,'Janaína Couto','Auxiliar Administrat','1987-11-12','F',75.40,1.66,'EUA',3),(8,'Carlisson Rosa','Professor','2010-08-01','M',78.22,1.98,'Brasil',29),(9,'Jackson Telles','Programador','1999-01-23','M',55.75,1.33,'Portugal',8),(10,'Danilo Araujo','Dentista','1975-12-10','M',99.21,1.87,'EUA',31),(11,'Andreia Delfino','Auxiliar Administrat','1975-07-01','F',48.64,1.54,'Irlanda',4),(12,'Valter Vilmerson','Ator','1985-10-12','M',88.55,2.03,'Brasil',8),(13,'Allan Silva','Programador','1993-11-11','M',76.99,1.55,'Brasil',8),(14,'Rosana Kunz','Professor','1935-01-16','F',55.24,1.87,'Brasil',4),(15,'Josiane Dutra','Empreendedor','1950-01-20','F',98.70,1.04,'Portugal',8),(16,'Elvis Schwarz','Dentista','2011-05-07','M',66.69,1.76,'EUA',11),(17,'Paulo Narley','Auxiliar Administrat','1997-03-17','M',120.10,2.22,'Brasil',4),(18,'Joade Assis','Médico','1930-12-01','M',65.88,1.78,'França',3),(19,'Nara Matos','Programador','1978-03-17','F',65.90,1.33,'Brasil',31),(20,'Marcos Dissotti','Empreendedor','2010-01-01','M',53.79,1.54,'Portugal',4),(21,'Ana Carolina Mendes','Ator','2000-12-15','F',88.30,1.54,'Brasil',29),(22,'Guilherme de Sousa','Dentista','2001-05-18','M',132.70,1.97,'Moçambique',4),(23,'Bruno Torres','Auxiliar Administrat','2000-01-30','M',44.65,1.65,'Brasil',8),(24,'Yuji Homa','Empreendedor','1996-12-25','M',33.90,1.22,'Japão',14),(25,'Raian Porto','Programador','1989-05-05','M',54.89,1.54,'Brasil',6),(26,'Paulo Batista','Ator','1999-03-15','M',110.12,1.87,'Portugal',7),(27,'Monique Precivalli','Auxiliar Administrat','2013-12-30','F',48.20,1.22,'Brasil',8),(28,'Herisson Silva','Auxiliar Administrat','1965-10-10','M',74.65,1.56,'EUA',8),(29,'Tiago Ulisses','Dentista','1993-04-22','M',150.30,2.35,'Brasil',16),(30,'Anderson Rafael','Programador','1989-12-01','M',64.22,1.44,'Irlanda',10),(31,'Karine Ribeiro','Empreendedor','1988-10-01','F',42.10,1.65,'Brasil',14),(32,'Roberto Luiz Debarba','Ator','2007-01-09','M',77.44,1.56,'Brasil',16),(33,'Jarismar Andrade','Dentista','2000-06-23','F',63.70,1.33,'Brasil',29),(34,'Janaina Oliveira','Professor','1955-03-12','F',52.90,1.76,'Canadá',16),(35,'Márcio Mello','Programador','2011-11-20','M',54.11,1.55,'EUA',3),(36,'Robson Rodolpho','Auxiliar Administrat','2000-08-08','M',110.10,1.76,'Brasil',11),(37,'Daniele Moledo','Empreendedor','2006-08-11','F',101.30,1.99,'Brasil',16),(38,'Neto Sophiate','Ator','1996-05-17','M',59.28,1.65,'Portugal',31),(39,'Neriton Dias','Auxiliar Administrat','2009-10-30','M',48.99,1.29,'Brasil',14),(40,'André Schmidt','Programador','1993-07-26','M',55.37,1.22,'Angola',7),(41,'Isaias Buscarino','Dentista','2001-01-07','M',99.90,1.55,'Moçambique',31),(42,'Rafael Guimma','Empreendedor','1968-04-11','M',88.88,1.54,'Brasil',20),(43,'Ana Carolina Hernandes','Ator','1970-10-11','F',65.40,2.08,'EUA',10),(44,'Luiz Paulo','Professor','1984-11-01','M',75.12,1.38,'Portugal',21),(45,'Bruna Teles','Programador','1980-11-07','F',55.10,1.86,'Brasil',29),(46,'Diogo Padilha','Auxiliar Administrat','2000-03-03','M',54.34,1.88,'Angola',21),(47,'Bruno Miltersteiner','Dentista','1986-02-19','M',77.45,1.65,'Alemanha',29),(48,'Elaine Nunes','Programador','1998-08-15','F',35.90,2.00,'Canadá',21),(49,'Silvio Ricardo','Programador','2012-03-12','M',65.99,1.23,'EUA',31),(50,'Denilson Barbosa da Silva','Empreendedor','2000-01-08','M',97.30,2.00,'Brasil',20),(51,'Jucinei Teixeira','Professor','1977-11-22','F',44.80,1.76,'Portugal',7),(52,'Bruna Santos','Auxiliar Administrat','1991-12-01','F',76.30,1.45,'Canadá',8),(53,'André Vitebo','Médico','1970-07-01','M',44.11,1.55,'Brasil',14),(54,'Andre Santini','Programador','1991-08-15','M',66.00,1.76,'Itália',4),(55,'Ruan Valente','Programador','1998-03-19','M',101.90,1.76,'Canadá',11),(56,'Nailton Mauricio','Médico','1992-04-25','M',86.01,1.43,'EUA',3),(57,'Rita Pontes','Professor','1999-09-02','F',54.10,1.35,'Angola',31),(58,'Carlos Camargo','Programador','2005-02-22','M',124.65,1.33,'Brasil',16),(64,'Jurandir','pedreiro','2001-02-02','M',60.00,1.70,'Libano',10),(65,'João','Ator','2001-07-23','M',250.00,1.80,'Brasil',10),(66,'Isa','dentista','2001-01-25','F',58.00,1.63,'Brasil',14),(67,'Pedro','Ator','2001-07-17','M',75.00,1.70,'Brasil',4),(69,'Suelen','Professor','1990-02-24','F',55.00,1.72,'Brasil',21),(77,'Fernanda','estudante','2002-04-09','F',65.00,1.70,'Brasil',NULL),(78,'Mary','pedagoga','1989-06-06','M',62.00,1.55,'EUA',NULL),(79,'Petrus','dentista','1979-12-29','M',80.00,1.80,'Brasil',NULL),(80,'Andrea','locutor','1980-01-10','M',85.00,1.88,'Italia',NULL);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assiste`
--

DROP TABLE IF EXISTS `assiste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assiste` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `idaluno` int DEFAULT NULL,
  `idcurso` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idaluno` (`idaluno`),
  KEY `idcurso` (`idcurso`),
  CONSTRAINT `assiste_ibfk_1` FOREIGN KEY (`idaluno`) REFERENCES `aluno` (`id`),
  CONSTRAINT `assiste_ibfk_2` FOREIGN KEY (`idcurso`) REFERENCES `curso` (`idcurso`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assiste`
--

LOCK TABLES `assiste` WRITE;
/*!40000 ALTER TABLE `assiste` DISABLE KEYS */;
INSERT INTO `assiste` VALUES (1,'2019-10-03',1,4),(2,'2018-03-05',2,8),(3,'2021-07-08',5,8),(4,'2020-01-20',1,8),(5,'2019-10-23',7,7),(6,'2015-09-25',9,3),(7,'2021-06-09',12,16),(8,'2021-05-08',21,20),(9,'2021-04-09',24,4),(10,'2021-02-12',25,31);
/*!40000 ALTER TABLE `assiste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `idcurso` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `descricao` text,
  `carga` int unsigned DEFAULT NULL,
  `totaulas` int unsigned DEFAULT NULL,
  `ano` year DEFAULT '2016',
  PRIMARY KEY (`idcurso`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (3,'HTML5','Curso de HTML5',40,37,2014),(4,'Algoritmos','Lógica de Programação',20,15,2014),(5,'Photoshop5','Dicas de Photoshop CC',10,8,2014),(6,'PHP','Curso de PHP para iniciantes',40,20,2015),(7,'Java','Introdução à Linguagem Java',40,29,2015),(8,'MySQL','Bancos de Dados MySQL',30,15,2016),(9,'Word','Curso completo de Word',40,30,2016),(10,'Python','Curso de Python',40,18,2017),(11,'POO','Curso de Programação Orientada a Objetos',60,35,2016),(12,'Excel','Curso completo de Excel',40,30,2017),(13,'Responsividade','Curso de Responsividade',30,15,2018),(14,'C++','Curso de C++ com Orientação a Objetos',40,25,2017),(15,'C#','Curso de C#',30,12,2017),(16,'Android','Curso de Desenvolvimento de Aplicativos para Android',60,30,2018),(17,'JavaScript','Curso de JavaScript',35,18,2017),(18,'PowerPoint','Curso completo de PowerPoint',30,12,2018),(19,'Swift','Curso de Desenvolvimento de Aplicativos para iOS',60,30,2019),(20,'Hardware','Curso de Montagem e Manutenção de PCs',30,12,2017),(21,'Redes','Curso de Redes para Iniciantes',40,15,2016),(22,'Segurança','Curso de Segurança',15,8,2018),(23,'SEO','Curso de Otimização de Sites',30,12,2017),(24,'Premiere','Curso de Edição de Vídeos com Premiere',20,10,2017),(25,'After Effects','Curso de Efeitos em Vídeos com After Effects',20,10,2018),(26,'WordPress','Curso de Criação de Sites com WordPress',60,30,2019),(27,'Joomla','Curso de Criação de Sites com Joomla',60,30,2019),(28,'Magento','Curso de Criação de Lojas Virtuais com Magento',50,25,2019),(29,'Modelagem de Dados','Curso de Modelagem de Dados',30,12,2020),(30,'HTML4','Curso Básico de HTML, versão 4.0',20,9,2010),(31,'PHP7','Curso de PHP, versão 7.0',40,20,2020);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'profasuelen'
--

--
-- Dumping routines for database 'profasuelen'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-18  1:34:09