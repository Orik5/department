CREATE DATABASE IF NOT EXISTS `department_employee1`;
USE `department_employee1`;
-- Dumping structure for table concretepage.articles
CREATE TABLE IF NOT EXISTS `department` (
  `id`   bigint(5)    NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,

  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;
CREATE TABLE IF NOT EXISTS `employee` (
  `id`     bigint(5)    NOT NULL AUTO_INCREMENT,
  `name`   varchar(200) NOT NULL,


  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;
-- Dumping data for table concretepage.articles
INSERT INTO `employee` (`id`, `name`) VALUES
  (1, 'Java Concurrency'),
  (2, 'Spring Boot Getting Started');