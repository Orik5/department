package com.dvoretskyi.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Department application.
 */
@SpringBootApplication

public class DepartmentApplication {

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
    return (args) -> {
      // save a couple of customers
      employeeRepository.save(new Employee(1, "Yura",  true, "+44343468"));
      employeeRepository.save(new Employee(2, "George, true, "));
      employeeRepository.save(new Employee(3, "Mykola", "Bob", "Mumbai", "+3398909"));
      employeeRepository.save(new Employee(4, "David", "Palmer", "Saul", "+3478890"));
      employeeRepository.save(new Employee(5, "Max", "Tony", "Ohtyrka", "+33235t78"));

      // fetch all customers
      log.info("Customers found with findAll():");
      log.info("-------------------------------");
      for (Human human : humanRepository.findAll()) {
        log.info(humanRepository.toString());
      }
      log.info("");*/

      // fetch an individual customer by ID
     /* humanRepository.findById(1L)
          .ifPresent(human -> {
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(human.toString());
            log.info("");
          });*/

      // fetch customers by last name
     /* log.info("Customer found with findByLastName('Bauer'):");
      log.info("--------------------------------------------");*/
  //   humanRepository.findBySecondName("Yura").forEach(yura -> {
  //    log.info(yura.toString());
   // });
     //  for (Human bob : humanRepository.findBySecondName("Bob")) {
   // log.info(bob.toString());
 // }
   //   log.info("");
}
