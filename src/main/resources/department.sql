CREATE SCHEMA --CREATE DATABASE
IF NOT EXISTS department_employee1;
USE department_employee1;
-- Dumping structure for table concretepage.articles
CREATE TABLE department111 (
  department_id   bigint(5) AUTO_INCREMENT primary key,
  department_name varchar(200),
FK_Emp_DP     BIGINT(10),
  FOREIGN KEY (FK_Emp_DP)
  REFERENCES department_employee1.employee (employee_id)

);
USE department_employee1;
INSERT INTO department ( department_name)VALUES('HR');


USE department_employee1;
CREATE TABLE employee111 (
  employee_id bigint(5) AUTO_INCREMENT primary key,
  employee_first_name varchar(100),
  employee_surname varchar (100),
  employee_middle_name varchar (100),
  employee_profession varchar (50),
  employee_date_of_birth varchar (50),
  employee_phone_number varchar (50),
  employee_email varchar (50),
  employee_salary decimal (50),
  employee_active boolean   default 1,

  FK_Emp_DP     BIGINT(10),
  FOREIGN KEY (FK_Emp_DP)
  REFERENCES department_employee1.department (department_id)
);
USE department_employee1;
INSERT INTO `employee`(employee_name, active,FK_Emp_DP) VALUES
  ( 'Harry',1,1),
  ( 'Bob',1,null);

