package com.dvoretskyi.department.repository;

import com.dvoretskyi.department.entity.Employee;
import java.util.List;

public interface EmployeeRepository {

  List<Employee> findAllEmployees();

  Employee findEmployeeById(long id);

  Employee addEmployee(Employee employee);

  Employee updateEmployee(Employee employee);

  void deleteEmployeeById(long id);

   List<Employee> findPagedResultByEmployeeId(long id, int offset, int limit);
 /* @Query(value = "select n from Employee n where n.name like :name%")
  List<Employee> findByName(@Param("name") String name);*/
}
