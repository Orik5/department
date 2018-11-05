package com.dvoretskyi.department.controller;

import com.dvoretskyi.department.entity.Employee;
import com.dvoretskyi.department.services.EmployeeService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {

  public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

  @Autowired
  private EmployeeService employeeService;


  @RequestMapping(value = "/employees", method = RequestMethod.GET)
  public List<Employee> getAllEmployees() {
    return employeeService.findAllEmployees();
  }

  /* @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
   public String addEmployee(@RequestParam("empName") String empName,@RequestParam("empActive") boolean empActive) {
     employeeService.saveEmployee();
     return "redirect:/";
   }*/
  @RequestMapping(value = "/employee{id}")
  public Employee getEmployee(@PathVariable("id") long id) {
    return employeeService.findEmployeeById(id);
  }


  @RequestMapping(value = "/employee", method = RequestMethod.POST)
  public Employee addEmployee(Employee employee) {
    return employeeService.saveEmployee(employee);
  }


  @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee,
      @PathVariable long id) {

    Optional<Employee> optionalEmployee = Optional.ofNullable(employeeService.findEmployeeById(id));

    if (!optionalEmployee.isPresent()) {
      return ResponseEntity.notFound().build();
    }

    employee.setId(id);

    employeeService.saveEmployee(employee);

    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value = "/employee{id}", method = RequestMethod.DELETE)
  public void updateEmployee(@PathVariable long id) {
    employeeService.deleteEmployeeById(id);
  }
}
