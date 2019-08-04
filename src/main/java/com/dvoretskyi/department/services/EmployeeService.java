package com.dvoretskyi.department.services;

import com.dvoretskyi.department.dto.EmployeeDto;
import com.dvoretskyi.department.entity.Employee;
import com.dvoretskyi.department.entity.EmployeesResponse;
import com.dvoretskyi.department.util.Paginator;

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

    List<Employee> getEmployeesByPage(int pageId, int total);


    //EmployeesResponse getEmployees(Paginator paginator,String searchValue);
}
