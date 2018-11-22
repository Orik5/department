package com.dvoretskyi.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * The type Department application.
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

public class DepartmentApplication {

 /* public final static String URL = "jdbc:mysql://localhost:3306/employee_department?createDatabaseIfNotExist=true";
  public final static String NAME = "root";
  public final static String PASSWORD = "golovach";*/


  public static void main(String[] args) /*throws SQLException*/ {
    SpringApplication.run(DepartmentApplication.class, args);
/*
    Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
    connection.prepareStatement(
        "CREATE TABLE if NOT EXISTS employee(id int primary key auto_increment(employee_id), name VARCHAR(55), surname VARCHAR(55)),active BIT(1),FOREIGN KEY (department_id),REFERENCES department(department_id);")
        .execute();

    connection.close();
    connection.prepareStatement(
        "CREATE TABLE if NOT EXISTS department(id int primary key auto_increment(department_id) ,name VARCHAR(55))");*/
  }


}