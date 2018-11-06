package com.dvoretskyi.department;

import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Department application.
 */
@SpringBootApplication

public class DepartmentApplication {

  private static final Logger log = LoggerFactory.getLogger(Application.class);

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(DepartmentApplication.class, args);
  }


  /*@Bean
  public CommandLineRunner istertingIntoDatabase(EmployeeRepository employeeRepository) {
    return (args) -> {*/
      // save a couple of customers
    /*  List<Department>departments = new ArrayList();
      departments.add(new Department(1,"d3",t));

      employeeRepository.save(new Employee(1, "Yura", true, departments));
      employeeRepository.save(new Employee(2, "George", true, departments));
      employeeRepository.save(new Employee(3, "Mykola", true,departments ));
      employeeRepository.save(new Employee(4, "David", true,departments ));
      employeeRepository.save(new Employee(5, "Max", true, departments));*/

      // fetch all customers
    /*  log.info("Customers found with findAll():");
      log.info("-------------------------------");
      for (Employee:
      employeeRepository.findAll()) {
        log.info(employeeRepository.toString());
      }
      log.info("");*/

      // fetch an individual customer by ID
     /* employeeRepository.findById(1L)
          .ifPresent(human -> {
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(human.toString());
            log.info("");
          });*/

      // fetch customers by last name
      //log.info("Customer found with findByLastName('Bauer'):");
      //log.info("--------------------------------------------");*/
      // employeeRepository.findById(3L).forEach(yura -> {
      // log.info(yura.toString());
      //});
 /*     for (Employee bob : employeeRepository.findById()) {
        log.info(bob.toString());
      }
      log.info("");*/
   // };
 // }
}