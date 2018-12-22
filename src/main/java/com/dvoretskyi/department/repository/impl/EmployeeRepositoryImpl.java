package com.dvoretskyi.department.repository.impl;

import com.dvoretskyi.department.entity.Department;
import com.dvoretskyi.department.entity.Employee;
import com.dvoretskyi.department.entity.mapper.EmployeeRowMapper;
import com.dvoretskyi.department.repository.EmployeeRepository;
import com.google.common.collect.Lists;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

@Transactional
@Repository
@CrossOrigin(origins = "http://localhost:4200")

public class EmployeeRepositoryImpl implements EmployeeRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  private DataSource dataSource;
  //@Autowired
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
  public List<Employee> findAllEmployees() {
    String sql = "SELECT employee_id, employee_name,active,FK_Emp_DP FROM  department_employee1.employee";
    //RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
    RowMapper<Employee> rowMapper = new EmployeeRowMapper();
    return this.jdbcTemplate.query(sql, rowMapper);
  }

  @Override
  public Employee findEmployeeById(long id) {
    String sql = "SELECT  employee_id, employee_name, active,FK_Emp_DP FROM department_employee1.employee WHERE employee_id = ?";
    RowMapper<Employee> rowMapper = new BeanPropertyRowMapper(Employee.class);
    return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    // return employee;
  }

  @Override
  public Employee addEmployee(Employee employee) {
    String sql = "INSERT INTO department_employee1.employee(employee_id,employee_name,active/*,FK_Emp_DP*/) values (?,?,?)";
    jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getActive()
        /*,
        employee.getDepartment()*/);

    //Fetch employee id
    sql = "SELECT employee_id FROM department_employee1.employee WHERE employee_name = ? and active=? /*and FK_Emp_DP=?*/";
    int id = jdbcTemplate
        .queryForObject(sql, Integer.class, employee.getName(), employee.getActive()/*,
            employee.getDepartment()*/);

    //Set employee id
    // employee.setId(id);
    return employee;
  }

  @Override
  public Employee updateEmployee(Employee employee) {
    String sql = "UPDATE department_employee1.employee SET employee_name=? and active=? and FK_Emp_DP WHERE employee_id=?";
    jdbcTemplate.update(sql, employee.getId(), employee.getName(),
        employee.getActive(), employee.getDepartment());

    RowMapper<Employee> rowMapper = new BeanPropertyRowMapper(Employee.class);
    return this.jdbcTemplate.queryForObject(sql, rowMapper, employee);
    // return employee;
  }

  @Override
  public void deleteEmployeeById(long id) {
    String sql = "DELETE FROM department_employee1.employee WHERE employee_id=?";
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




  @SuppressWarnings("unchecked")
  @Override
  public List<Employee> findPagedResultByEmployeeId(long id, int offset, int limit) {
    String query = "select s.* from department_employee1 s. "
        + "join department on department.id = s.FK_Empl_DP "
        + "where department.id = :department_id";
    //+ "order by selse.date";
    Query nativeQuery = entityManager.createNativeQuery(query);
    nativeQuery.setParameter("id", id);
    //Paginering
    nativeQuery.setFirstResult(offset);
    nativeQuery.setMaxResults(limit);
    final List<Object[]> resultList = nativeQuery.getResultList();
    List<Employee> employeeList = Lists.newArrayList();
    resultList
        .forEach(object -> employeeList.add(new Employee("Olaf", true, 3)));
    return employeeList;
  }

  private Employee toEmployee(ResultSet resultSet) throws SQLException {
    Employee employee = new Employee();

    employee.setId(resultSet.getLong("employee_id"));
    employee.setName(resultSet.getString("employee_name"));
    employee.setActive(resultSet.getBoolean("active"));
    employee.setDepartment(resultSet.getLong("FK_Emp_DP"));
    return employee;
  }

  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }
}
