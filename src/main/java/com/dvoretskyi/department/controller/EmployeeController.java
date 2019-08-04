package com.dvoretskyi.department.controller;

import com.dvoretskyi.department.dto.EmployeeDto;
import com.dvoretskyi.department.entity.Employee;
import com.dvoretskyi.department.services.impl.EmployeeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/department")
@Api(value = "department")

@EnableHypermediaSupport(type = HypermediaType.HAL)
public class EmployeeController {

    public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeServiceImpl employeeService;


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully l list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )

    @ApiOperation(value = "View a list of employees", response = Iterable.class)
    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = {
            "application/hal+json"})
      public List<EmployeeDto> getAllEmployees() {
        return employeeService.findAllEmployees();


    }

    @ApiOperation(value = "Search employee by Id", response = EmployeeDto.class)
    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET, produces = {
            "application/hal+json"})
    public EmployeeDto getEmployee(@PathVariable long id) {

        return EmployeeDto.convertToDto(
                employeeService.findEmployeeById(id));
    }

    @ApiOperation(value = "Add employee", response = EmployeeDto.class)
    @RequestMapping(value = "/employees", method = RequestMethod.POST, produces = {
            "application/hal+json"})
    public EmployeeDto addEmployee(@RequestBody Employee employee) {
        return EmployeeDto.convertToDto(employeeService.saveEmployee(employee));
    }


    @ApiOperation(value = "Update employee", response = EmployeeDto.class)
    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT, produces = {
            "application/hal+json"})

    public EmployeeDto updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
        return EmployeeDto.convertToDto(employeeService.editEmployee(employee, id));
    }


    @ApiOperation(value = "Delete employee")

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE, produces = {
            "application/hal+json"})

    public EmployeeDto deleteEmployee(@PathVariable long id) {

        return EmployeeDto.convertToDto(employeeService.deleteEmployeeById(id));

    }

    @ApiOperation(value = "Page employees", response = Iterable.class)
    @RequestMapping(value = "/init/{page_id}", method = RequestMethod.GET, produces = {
            "application/hal+json"})

    public List<Employee> paginate(@PathVariable int page_id) {
        int total = 5;
        if (page_id == 1) {
        } else {
            page_id = (page_id - 1) * total + 1;
        }
        List<Employee> list = employeeService.getEmployeesByPage(page_id, total);
        return list;
    }

}
