package com.dvoretskyi.department.services.impl;

import com.dvoretskyi.department.entity.Department;
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
  public Employee saveEmployee(String empName, Boolean empActive, Department department) {
    if (department == null || department.toString().equals("")) {
      return employeeRepository.save(new Employee(empName, empActive));
    } else {
      return employeeRepository.save(new Employee(empName, empActive, department));
    }
  }

  @Override
  public List<Employee> findAllEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public List<Employee> findByName(String name) {
    return employeeRepository.findByName(name);
  }

  @Override
  public void editEmployee(Long id, Employee employee) {
    Employee changedEmployee = findEmployeeById(id);
    changedEmployee.setActive(employee.getActive());
    changedEmployee.setName(employee.getName());
    changedEmployee.setDepartment(employee.getDepartment());
    employeeRepository.save(changedEmployee);
  }
}
