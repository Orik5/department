package com.dvoretskyi.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * The type Department application.
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })

public class DepartmentApplication {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(DepartmentApplication.class, args);
  }


}