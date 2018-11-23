package com.dvoretskyi.department.repository.impl;

import com.dvoretskyi.department.entity.Employee;
import com.dvoretskyi.department.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<Employee> findAllEmployees() {
    return null;
  }

  @Override
  public Employee findEmployeeByIdById(long id) {
    return null;
  }

  @Override
  public void addEmployee(Employee employee) {

  }

  @Override
  public void updateEmployee(Employee employee) {

  }

  @Override
  public void deleteEmployeeById(long id) {
    String sql = "DELETE FROM articles WHERE articleId=?";
    jdbcTemplate.update(sql, id);
  }

  @Override
  public List<Employee> findByName(String name) {
    return null;
  }
}
