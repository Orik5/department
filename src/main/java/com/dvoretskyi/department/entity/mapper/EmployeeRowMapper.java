package com.dvoretskyi.department.entity.mapper;

import com.dvoretskyi.department.entity.Employee;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

/**
 * The type Employee row mapper.
 */
public class EmployeeRowMapper implements RowMapper<Employee> {


    @Override
    public Employee mapRow(ResultSet row, int rowNum) throws SQLException {

        Employee employee = new Employee();

        employee.setId(row.getLong("employee_id"));
        employee.setFirstName(row.getString("employee_first_name"));
        employee.setSurname(row.getString("employee_surname"));
        employee.setMiddleName(row.getString("employee_middle_name"));
        employee.setProfession(row.getString("employee_profession"));
        employee.setDateOfBirth(row.getString("employee_date_of_birth"));
        employee.setPhoneNumber(row.getString("employee_phone_number"));
        employee.setEmail(row.getString("employee_email"));
        employee.setSalary(row.getBigDecimal("employee_salary"));
        employee.setActive(row.getBoolean("employee_active"));
        employee.setDepartment(row.getLong("FK_Emp_DP"));

        return employee;


    }
}
