CREATE DATABASE IF NOT EXISTS `department_employee1`;
USE `department_employee1`;
-- Dumping structure for table concretepage.articles
CREATE TABLE IF NOT EXISTS `department` (
  department_id   bigint(5)    NOT NULL AUTO_INCREMENT primary key,
  department_name varchar(200) NOT NULL


  /*,PRIMARY KEY (department_id)*/
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;
CREATE TABLE IF NOT EXISTS `employee` (
  employee_id   bigint(5)    NOT NULL AUTO_INCREMENT primary key,
  employee_name varchar(200) NOT NULL,
  active      boolean      default 1/*,

  PRIMARY KEY (employee_id)*/
  ,CONSTRAINT FK_Employee_department FOREIGN KEY (employee_id)
REFERENCES department_employee1.department (department_id)
  ON DELETE NO ACTION
  ON UPDATE CASCADE
)

  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;
-- Dumping data for table concretepage.articles
INSERT INTO `employee` (employee_id, employee_name, active) VALUES
  (1, 'Java Concurrency', 1),
  (2, 'Spring Boot Getting Started', 1);