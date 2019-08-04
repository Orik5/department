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


    public static void main(String[] args) throws SQLException {
        SpringApplication.run(DepartmentApplication.class, args);

    }

}
