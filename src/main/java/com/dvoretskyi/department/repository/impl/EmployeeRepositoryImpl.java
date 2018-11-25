package com.dvoretskyi.department.repository.impl;

import com.dvoretskyi.department.entity.Employee;
import com.dvoretskyi.department.entity.mapper.EmployeeRowMapper;
import com.dvoretskyi.department.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository

public class EmployeeRepositoryImpl implements EmployeeRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<Employee> findAllEmployees() {
    String sql = "SELECT id, name, active ,department FROM employee";
    //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
    RowMapper<Employee> rowMapper = new EmployeeRowMapper();
    return this.jdbcTemplate.query(sql, rowMapper);
  }

  @Override
  public Employee findEmployeeById(long id) {
    String sql = "SELECT  id, name,  FROM employee WHERE id = ?";
    RowMapper<Employee> rowMapper = new BeanPropertyRowMapper(Employee.class);
    Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, id);
    return employee;
  }

  @Override
  public void addEmployee(Employee employee) {
    String sql = "INSERT INTO employee (id,name,active,department) values (?,?,?,?)";
    jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getActive(),
        employee.getDepartment());

    //Fetch article id
    sql = "SELECT id FROM employee WHERE name = ? and active=? and department=?";
    int id = jdbcTemplate
        .queryForObject(sql, Integer.class, employee.getName(), employee.getActive(),
            employee.getDepartment());

    //Set article id
    employee.setId(id);
  }

  @Override
  public void updateEmployee(Employee employee) {
    String sql = "UPDATE employee SET name=?,active=? WHERE id=?";
    jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getActive());
  }

  @Override
  public void deleteEmployeeById(long id) {
    String sql = "DELETE FROM articles WHERE articleId=?";
    jdbcTemplate.update(sql, id);
  }

/*  @Override
  public List<Employee> findByName(String name) {
    *//*String sql = "id, name FROM department";
    //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
    RowMapper<Employee> rowMapper = new EmployeeRowMapper();
    return this.jdbcTemplate.query(sql, rowMapper);*//*
    return null;
  }*/
}
