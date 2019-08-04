package com.dvoretskyi.department.repository;

import com.dvoretskyi.department.entity.Employee;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> findAllEmployees();

    Employee findEmployeeById(long id);

    Employee addEmployee(Employee employee);

    Employee updateEmployee(Employee employee, long id);

    Employee deleteEmployeeById(long id);

    List<Employee> findPagedResultByEmployeeId(long id, int offset, int limit);

}
