package com.dvoretskyi.department.exception;

import com.dvoretskyi.department.entity.Department;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDepartment  implements Dao<Department> {

  private DataSource dataSource;
  private JdbcTemplate jdbcTemplate;

  @Autowired
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @PostConstruct
  public void postConstruct() {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }


  @Override
  public void save(Department department) {
    String sql = "insert into department (department_name) values (? )";
    jdbcTemplate.update(sql, department.getName()
    );
  }

  @Override
  public Department load(long id) {
    //todo
    return null;
  }

  @Override
  public void delete(long id) {
    //todo
  }

  @Override
  public void update(Department department) {
    //todo
  }

  @Override
  public List<Department> loadAll() {
    return jdbcTemplate.query("select * from department", (resultSet, i) -> {
      return toDepartment(resultSet);
    });
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
