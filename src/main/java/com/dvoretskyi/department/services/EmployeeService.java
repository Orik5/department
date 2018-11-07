package com.dvoretskyi.department.services;

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

  /**
   * Save employee employee.
   *
   * @param employee the employee
   * @return the employee
   */
  Employee saveEmployee(Employee employee);

  /**
   * Find all employees list.
   *
   * @return the list
   */
  List<Employee> findAllEmployees();

}
