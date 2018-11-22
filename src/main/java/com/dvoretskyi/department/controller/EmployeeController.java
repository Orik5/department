package com.dvoretskyi.department.controller;

import com.dvoretskyi.department.entity.Department;
import com.dvoretskyi.department.entity.Employee;
import com.dvoretskyi.department.services.impl.EmployeeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "department")
@EnableHypermediaSupport(type = HypermediaType.HAL)
public class EmployeeController {

  public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
  @Autowired
  private EmployeeServiceImpl employeeService;


  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully retrieved list"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
  }
  )

  @ApiOperation(value = "View a list of employees", response = Iterable.class)
  @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = {
      "application/hal+json"})
  public List<Employee> getAllEmployees() {
    return employeeService.findAllEmployees();


  }


  @ApiOperation(value = "Search employee by Id", response = Employee.class)
  @RequestMapping(value = "/employees{id}", method = RequestMethod.GET, produces = {
      "application/hal+json"})
  public Employee getEmployee(@PathVariable("id") long id) {
    return employeeService.findEmployeeById(id);
  }

  @ApiOperation(value = "Add employee")
  @RequestMapping(value = "/employees", method = RequestMethod.POST, produces = {
      "application/hal+json"})
  public Employee addEmployee(String empName, Boolean empActive, Department department) {
    return employeeService.saveEmployee(empName, empActive, department);
  }


  @ApiOperation(value = "Update employee")
  @RequestMapping(value = "/employees{id}", method = RequestMethod.PUT, produces = {
      "application/hal+json"})
  public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee,
      @PathVariable long id) {

    Optional<Employee> employeeOptional = Optional.ofNullable(employeeService.findEmployeeById(id));

    if (!employeeOptional.isPresent()) {
      return ResponseEntity.notFound().build();
    }

    employee.setId(id);

    employeeService.editEmployee(id, employee);

    return ResponseEntity.noContent().build();
  }


  @ApiOperation(value = "Delete employee")
  @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE, produces = {
      "application/hal+json"})
  public void deleteEmployee(@PathVariable long id) {
    employeeService.deleteEmployeeById(id);

  }
}
