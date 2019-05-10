package com.dvoretskyi.department.services;

import com.dvoretskyi.department.dto.EmployeeDto;
import com.dvoretskyi.department.entity.Employee;

import java.util.List;

/**
 * The interface Employee service.
 */
public interface EmployeeService {


    Employee findEmployeeById(long id);


    Employee saveEmployee(Employee employee);

    List<EmployeeDto> findAllEmployees();

    Employee editEmployee(Employee employee, long id);

    Employee deleteEmployeeById(long id);
    /*  Department findEmployeeByName(String name);*/

    // Employee saveEmployee(String empName, Boolean empActive, Department department);

//  List<Employee> findByName(String name);


}
