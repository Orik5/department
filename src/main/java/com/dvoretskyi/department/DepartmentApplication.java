package com.dvoretskyi.department;

import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * The type Department application.
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

public class DepartmentApplication {

  /*public final static String URL = "jdbc:mysql://localhost:3306/employee_department?createDatabaseIfNotExist=true";
  public final static String NAME = "root";
  public final static String PASSWORD = "golovach";*/


  public static void main(String[] args) throws SQLException /*throws SQLException*/ {
    SpringApplication.run(DepartmentApplication.class, args);
  /*  try {
      // The newInstance() call is a work around for some
      // broken Java implementations

      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    } catch (Exception ex) {
      // handle the error
    }*/
//) ,name VARCHAR(55))");*//*
   /* Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
    connection.prepareStatement(
        "CREATE TABLE if NOT EXISTS employee(id int primary key auto_increment(employee_id),"
            + " name VARCHAR(55), active booleandefault 1,"
            + "FOREIGN KEY (department_id),REFERENCES department(department_id);")
        .execute();

    connection.close();
    connection.prepareStatement(
        "CREATE TABLE IF NOT EXISTS `department` (  department_id   bigint(5) NOT NULL AUTO_INCREMENT,"
            + "department_name varchar(200) NOT NULL, PRIMARY KEY (department_id));")
        .execute();
  }*/

  }
}