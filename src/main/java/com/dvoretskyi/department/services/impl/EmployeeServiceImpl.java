package com.dvoretskyi.department.services.impl;

import com.dvoretskyi.department.dto.EmployeeDto;
import com.dvoretskyi.department.entity.Employee;
import com.dvoretskyi.department.repository.EmployeeRepository;
import com.dvoretskyi.department.services.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Employee service.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public Employee findEmployeeById(long id) {
    Employee employee = employeeRepository.findEmployeeById(id);
    return employee;
  }

  @Override
  //@Transactional
  public void deleteEmployeeById(long id) {
    employeeRepository.deleteEmployeeById(id);
  }

  /* @Override
   public Employee saveEmployee(String empName, Boolean empActive, Department department) {
     if (department == null || department.toString().equals("")) {
       return employeeRepository.save(new Employee(empName, empActive));
     } else {
       return employeeRepository.save(new Employee(empName, empActive, department));
     }
   }
 */
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  @Override
  public Employee saveEmployee(Employee employee) {
    return employeeRepository.addEmployee(employee);
  }

  /*  @Override
    public List<Employee> findAllEmployees() {
      return employeeRepository.findAllEmployees();
    }*/
  @Override
  public List<EmployeeDto> findAllEmployees() {
    List<EmployeeDto> employeeDtos = new ArrayList<>();
    List<Employee> employees = employeeRepository.findAllEmployees();
    for (Employee employee : employees) {
      employeeDtos.add(EmployeeDto.convertToDto(employee));
    }

    return employeeDtos;
  }

/*  @Override
  public Employee editEmployee(long id, Employee employee) {
    Employee changedEmployee = findEmployeeById(id);
    return null;
  }*/
/*  @Override
  public List<Employee> findByName(String name) {
    return employeeRepository.findByName(name);
  }*/

  @Override
  public Employee editEmployee(long id, Employee employee) {
    Employee changedEmployee = findEmployeeById(id);
    changedEmployee.setActive(employee.getActive());
    changedEmployee.setName(employee.getName());
    changedEmployee.setDepartment(employee.getDepartment());
    return employeeRepository.addEmployee(changedEmployee);
  }

/*  public Page<Employee> findPaginated(Pageable pageable) {
    int pageSize = pageable.getPageSize();
    int currentPage = pageable.getPageNumber();
    int startItem = currentPage * pageSize;
    List<Employee> list;
    if (findAllEmployees().size() < startItem) {
      list = Collections.emptyList();
    } else {
      int toIndex = Math.min(startItem + pageSize, findAllEmployees().size());
      list = findAllEmployees().subList(startItem, toIndex);
    }
    Page<Employee> bookPage = new PageImpl<>(list, PageRequest.of(currentPage, pageSize),
        findAllEmployees().size());
    return bookPage;
  }*/
}
