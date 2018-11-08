package com.dvoretskyi.department.services.impl;

import com.dvoretskyi.department.entity.Employee;
import com.dvoretskyi.department.repository.EmployeeRepository;
import com.dvoretskyi.department.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The type Employee service.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  private List<Employee> employeeList;

  @Override
  public Employee findEmployeeById(long id) {
    return employeeRepository.findById(id).get();
  }

  @Override
  @Transactional
  public void deleteEmployeeById(long id) {
    employeeRepository.delete(findEmployeeById(id));
  }

  @Override
  public Employee saveEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public List<Employee> findAllEmployees() {
    return employeeRepository.findAll();
  }

}
