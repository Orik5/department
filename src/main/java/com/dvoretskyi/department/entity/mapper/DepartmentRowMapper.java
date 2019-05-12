package com.dvoretskyi.department.entity.mapper;

import com.dvoretskyi.department.entity.Department;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * The type Department row mapper.
 */
public class DepartmentRowMapper implements RowMapper<Department> {

    @Override
    public Department mapRow(ResultSet row, int rowNum) throws SQLException {
        Department department = new Department();

        department.setId(row.getInt("department_id"));
        department.setName(row.getString("department_name"));
        return department;
    }
}
