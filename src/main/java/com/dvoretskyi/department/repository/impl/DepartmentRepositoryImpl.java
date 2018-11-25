package com.dvoretskyi.department.repository.impl;

import com.dvoretskyi.department.entity.Department;
import com.dvoretskyi.department.entity.mapper.DepartmentRowMapper;
import com.dvoretskyi.department.repository.DepartmentRepository;
import java.util.List;
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

  @Override
  public List<Department> findAllDepartmentds() {
    String sql = "id, name FROM department";
    //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
    RowMapper<Department> rowMapper = new DepartmentRowMapper();
    return this.jdbcTemplate.query(sql, rowMapper);
  }

  @Override
  public Department findDepartmentById(long id) {
    String sql = "SELECT  id, name,  FROM department WHERE id = ?";
    RowMapper<Department> rowMapper = new BeanPropertyRowMapper<Department>(Department.class);
    Department department = jdbcTemplate.queryForObject(sql, rowMapper, id);
    return department;
  }

  @Override
  public void addDepartment(Department department) {
    String sql = "INSERT INTO department (id, name) values (?, ?)";
    jdbcTemplate.update(sql, department.getId(), department.getName());

    //Fetch article id
    sql = "SELECT id FROM department WHERE name = ? /*and category=?*/";
    int id = jdbcTemplate
        .queryForObject(sql, Integer.class, department.getName()/*, department.getEmployee()*/);

    //Set article id
    department.setId(id);
  }

  @Override
  public void updateDepartment(Department department) {
    String sql = "UPDATE department SET name=? WHERE articleId=?";
    jdbcTemplate.update(sql, department.getName(),  department.getId());
  }

  @Override
  public void deleteDepartmentById(long id) {
    String sql = "DELETE FROM department WHERE id=?";
    jdbcTemplate.update(sql, id);

  }
}
