package com.dvoretskyi.department.entity.mapper;

import com.dvoretskyi.department.entity.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

  @Override
  public Employee mapRow(ResultSet row, int rowNum) throws SQLException {
    Employee employee =  new Employee();
   // Department department = new Department();

    employee.setId(row.getLong("employee_id"));
    employee.setName(row.getString("employee_name"));
    employee.setActive(row.getBoolean(1));
    //department.setId(row.getLong();
    return employee;
  }
}
