package com.dvoretskyi.department.controller;

import com.dvoretskyi.department.entity.Employee;
import com.dvoretskyi.department.services.EmployeeService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
public class EmployeeController {

  public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

  @Autowired
  private EmployeeService employeeService;


  @GetMapping("/")
  public String listEmployees(Model model) {
    model.addAttribute("employees", employeeService.findAllEmployees());
    return "index";
  }

  @PostMapping(value = "/addEmployee")
  public String addEmployee(@RequestParam("empName") String empName,
      @RequestParam("empActive") boolean empActive) {
    employeeService.saveEmployee(new Employee(empName, empActive));
    return "redirect:/";
  }

  @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
  public String getEmployee(@PathVariable("id") long id, Model model) {
    model.addAttribute("employee", employeeService.findEmployeeById(id));
    return "employee";
  }

  @RequestMapping(value = "/employees", method = RequestMethod.POST)
  public Employee addEmployee(Employee employee) {
    return employeeService.saveEmployee(employee);
  }


  @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
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

  @RequestMapping(value = "/removeEmployee/{id}", method = RequestMethod.GET)
  public String deleteEmployee(@PathVariable long id) {
    employeeService.deleteEmployeeById(id);
    return "redirect:/";
  }
}
