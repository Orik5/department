package com.dvoretskyi.department.repository;

import com.dvoretskyi.department.entity.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * The interface Employee repository.
 */
//@Repository
public interface EmployeeRepository /*extends JpaRepository<Employee, Long>*/ {

  List<Employee> findAllEmployees();

  Employee findEmployeeByIdById(long id);

  void addEmployee(Employee employee);

  void updateEmployee(Employee employee);

  void deleteEmployeeById(long id);

  @Query(value = "select n from Employee n where n.name like :name%")
  List<Employee> findByName(@Param("name") String name);
}
