CREATE SCHEMA /*CREATE DATABASE*/ /*IF NOT EXISTS */department_employee1;
USE department_employee1;
-- Dumping structure for table concretepage.articles
CREATE TABLE department (
  department_id   bigint(5)    AUTO_INCREMENT primary key,
  department_name varchar(200)

  /*,PRIMARY KEY (department_id)*/
)
  /*ENGINE = InnoDB
  DEFAULT CHARSET = latin1*/;

/*INSERT INTO department ( department_name)VALUES('HR');*/


CREATE TABLE employee (
  employee_id   bigint(5)   AUTO_INCREMENT primary key,
  employee_name varchar(200),
  active      boolean      default 1,

 FK_Emp_DP BIGINT (10), CONSTRAINT FK_Employee_department FOREIGN KEY (FK_Emp_DP)
REFERENCES department_employee1.department (department_id));


  /*,



  PRIMARY KEY (employee_id)*/
  /*,CONSTRAINT FK_Employee_department FOREIGN KEY (employee_id)
REFERENCES department_employee1.department (department_id)
  ON DELETE NO ACTION
  ON UPDATE CASCADE*/


/*alter table department_employee1.employee
  ADD  COLUMN FK_Emp_DP BIGINT (10),add CONSTRAINT FK_Employee_department FOREIGN KEY (FK_Emp_DP)
REFERENCES department_employee1.department (department_id);
*/
/*ON DELETE NO ACTION
  ON UPDATE NO ACTION*/

 /* ENGINE = InnoDB
  DEFAULT CHARSET = latin1;*/
-- Dumping data for table concretepage.articles
/*use department_employee1;
INSERT INTO department ( department_name)VALUES('HR');
alter table employee
  ADD  COLUMN FK_Emp_DP BIGINT (10),add CONSTRAINT FK_Employee_department FOREIGN KEY (FK_Emp_DP)
REFERENCES department_employee1.department (department_id)*/   /*ON DELETE NO ACTION
  ON UPDATE NO ACTION;*/

/*INSERT INTO `employee` (employee_name, active,FK_Emp_DP) VALUES
  ( 'Harry',1,1),
  ( 'Bob',1,null);
*/