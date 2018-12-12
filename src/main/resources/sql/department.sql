CREATE DATABASE IF NOT EXISTS `department_employee1`;
USE `department_employee1`;
-- Dumping structure for table concretepage.articles
CREATE TABLE IF NOT EXISTS `department` (
  department_id   bigint(5)    AUTO_INCREMENT primary key,
  department_name varchar(200)


  /*,PRIMARY KEY (department_id)*/
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;
CREATE TABLE IF NOT EXISTS `employee` (
  employee_id   bigint(5)   AUTO_INCREMENT primary key,
  employee_name varchar(200),
  active      boolean      default 1/*,

  PRIMARY KEY (employee_id)*/
  /*,CONSTRAINT FK_Employee_department FOREIGN KEY (employee_id)
REFERENCES department_employee1.department (department_id)
  ON DELETE NO ACTION
  ON UPDATE CASCADE*/
)

  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;
-- Dumping data for table concretepage.articles
use department_employee1;
INSERT INTO department ( department_name)VALUES('HR');
alter table employee
  ADD  COLUMN FK_Emp_DP BIGINT (10),add CONSTRAINT FK_Employee_department FOREIGN KEY (FK_Emp_DP)
REFERENCES department_employee1.department (department_id)   ON DELETE NO ACTION
  ON UPDATE NO ACTION ;

INSERT INTO `employee` (employee_name, active,FK_Emp_DP) VALUES
  ( 'Harry',1,1),
  ( 'Bob',1,null);
