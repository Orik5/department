CREATE SCHEMA department_employee1;


CREATE TABLE department (
  department_id   bigint(5)    AUTO_INCREMENT primary key,
  department_name varchar(200)) ;
CREATE TABLE employee (
  employee_id   bigint(5)   AUTO_INCREMENT primary key,
  employee_name varchar(200),
  active      boolean      default 1,

/*  FK_Emp_DP bigint(5),
  foreign  key (FK_Emp_DP) references department(department_id ));
*//* FK_EMP_DP bigint(5), constraint FK_Emp_DP FOREIGN key (employee_id)references department (department_id))*/
 /*,
  FK_Emp_DP  BIGINT (10), CONSTRAINT FK_Employee_department FOREIGN KEY (employee_id)
REFERENCES department (department_id)*/



/*ALTER TABLE department_employee1.employee
ADD FOREIGN KEY (FK_Emp_DP)
REFERENCES department_employee1.department(department_id);*/



/*
alter table employee
  ADD  COLUMN FK_Emp_DP BIGINT (10), CONSTRAINT FK_Employee_department FOREIGN KEY (employee_id)
REFERENCES department (department_id);*/