CREATE SCHEMA /*CREATE DATABASE*/ /*IF NOT EXISTS */department_employee1;
USE department_employee1;
-- Dumping structure for table concretepage.articles
CREATE TABLE department (
  department_id   bigint(5) AUTO_INCREMENT primary key,
  department_name varchar(200)


);
USE department_employee1;
INSERT INTO department ( department_name)VALUES('HR');


CREATE TABLE employee (
  employee_id   bigint(5) AUTO_INCREMENT primary key,
  employee_name varchar(200),
  active        boolean   default 1,

  FK_Emp_DP     BIGINT(10),
  CONSTRAINT FK_Employee_department FOREIGN KEY (FK_Emp_DP)
  REFERENCES department_employee1.department (department_id)
);
USE department_employee1;
INSERT INTO `employee` (employee_name, active,FK_Emp_DP) VALUES
  ( 'Harry',1,1),
  ( 'Bob',1,null);

