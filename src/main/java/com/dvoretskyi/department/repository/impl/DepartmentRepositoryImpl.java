package com.dvoretskyi.department.repository.impl;

import com.dvoretskyi.department.entity.Department;
import com.dvoretskyi.department.entity.mapper.DepartmentRowMapper;
import com.dvoretskyi.department.repository.DepartmentRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository

public class DepartmentRepositoryImpl implements DepartmentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;
    private EntityManager entityManager;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Department> findAllDepartments() {
        String sql = "SELECT department_id, department_name FROM department_employee1.department";
        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
        RowMapper<Department> rowMapper = new DepartmentRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Department findDepartmentById(long id) {
        String sql = "SELECT  department_id, department_name  FROM department_employee1.department WHERE id = ?";
        RowMapper<Department> rowMapper = new BeanPropertyRowMapper<Department>(Department.class);
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public void addDepartment(Department department) {
        String sql = "INSERT INTO department_employee1.department (department_id, department_name) values (?, ?)";
        jdbcTemplate.update(sql, department.getId(), department.getName());

        sql = "SELECT department_id FROM department_employee1.department WHERE department_name = ? ";
        int id = jdbcTemplate
                .queryForObject(sql, Integer.class, department.getName());

        department.setId(id);
    }

    @Override
    public void updateDepartment(Department department) {
        String sql = "UPDATE department_employee1.department SET department_name=? WHERE department_id=?";
        jdbcTemplate.update(sql, department.getName(), department.getId());
    }

    @Override
    public void deleteDepartmentById(long id) {
        String sql = "DELETE FROM department_employee1.department WHERE department_id=?";
        jdbcTemplate.update(sql, id);

    }

    private Department toDepartment(ResultSet resultSet) throws SQLException {
        Department department = new Department();

        department.setId(resultSet.getLong("department_id"));
        department.setName(resultSet.getString("department_name"));

        return department;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
