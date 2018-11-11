package com.dvoretskyi.department.services;

import com.dvoretskyi.department.entity.Department;
import com.dvoretskyi.department.entity.Employee;
import java.util.List;

/**
 * The interface Employee service.
 */
public interface EmployeeService {
  /**
   * Find employee by id employee.
   *
   * @param id the id
   * @return the employee
   */
  Employee findEmployeeById(long id);

  /**
   * Delete employee by id.
   *
   * @param id the id
   */
  void deleteEmployeeById(long id);

  /*  Department findEmployeeByName(String name);*/


  Employee saveEmployee(String empName, Boolean empActive, Department department);

  /**
   * Find all employees list.
   *
   * @return the list
   */
  List<Employee> findAllEmployees();
  List<Employee> findByName(String name);

  void editEmployee(Long id, Employee employee);

}
