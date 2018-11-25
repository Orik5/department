package com.dvoretskyi.department.entity.mapper;

import com.dvoretskyi.department.entity.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

  @Override
  public Employee mapRow(ResultSet row, int rowNum) throws SQLException {
    Employee employee =  new Employee();

    employee.setId(row.getInt("id"));
    employee.setName(row.getString("name"));
    employee.setActive(row.getBoolean(1));
    //employee.setDepartment(row.getString("fef"));
    return employee;
  }
}
