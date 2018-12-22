package com.dvoretskyi.department.exception;

import com.dvoretskyi.department.entity.Department;
import com.dvoretskyi.department.entity.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDao implements Dao<Employee> {

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
  public void save(Employee employee) {
    String sql = "insert into employee (employee_name, active/*,FK_Emp_DP*/) values (? ,?)";
    jdbcTemplate.update(sql, employee.getName(), employee.getActive()
    );
  }

  @Override
  public Employee load(long id) {
    //todo
    return null;
  }

  @Override
  public void delete(long id) {
    //todo
  }

  @Override
  public void update(Employee employee) {
    //todo
  }

  @Override
  public List<Employee> loadAll() {
    return jdbcTemplate.query("select * from employee", (resultSet, i) -> {
      return toEmployee(resultSet);
    });
  }

  private Employee toEmployee(ResultSet resultSet) throws SQLException {

    Employee employee = new Employee();
    employee.setId(resultSet.getLong("employee_id"));
    employee.setName(resultSet.getString("employee_name"));
    employee.setActive(resultSet.getBoolean("active"));
    employee.setDepartment(resultSet.getLong(1));
    return employee;
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
