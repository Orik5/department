package com.dvoretskyi.department.repository.impl;

import com.dvoretskyi.department.entity.Employee;
import com.dvoretskyi.department.entity.mapper.EmployeeRowMapper;
import com.dvoretskyi.department.repository.EmployeeRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
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

  private DataSource dataSource;
  //@Autowired
  //private EntityManager entityManager;

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
    String sql = "SELECT employee_id, employee_name,active FROM employee";
    //RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
    RowMapper<Employee> rowMapper = new EmployeeRowMapper();
    return this.jdbcTemplate.query(sql, rowMapper);
  }

  @Override
  public Employee findEmployeeById(long id) {
    String sql = "SELECT  employee_id, employee_name,  FROM employee WHERE employee_id = ?";
    RowMapper<Employee> rowMapper = new BeanPropertyRowMapper(Employee.class);
    return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    // return employee;
  }

  @Override
  public Employee addEmployee(Employee employee) {
    String sql = "INSERT INTO employee (employee_id,employee_name,active,FK_Employee_department) values (?,?,?,?)";
    jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getActive(),
        employee.getDepartment());

    //Fetch employee id
    sql = "SELECT employee_id FROM employee WHERE employee_name = ? and active=? /*and department=?*/";
    int id = jdbcTemplate
        .queryForObject(sql, Integer.class, employee.getName(), employee.getActive()/*,
            employee.getDepartment()*/);

    //Set employee id
    employee.setId(id);
    return employee;
  }

  @Override
  public Employee updateEmployee(Employee employee) {
    String sql = "UPDATE employee SET employee_name=?/*,active=?*/ WHERE employee_id=?";
    jdbcTemplate.update(sql, employee.getId(), employee.getName()/*, employee.getActive()*/);
    return employee;
  }

  @Override
  public void deleteEmployeeById(long id) {
    String sql = "DELETE FROM employee WHERE employee_id=?";
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

  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }

/*  private Employee toEmployee(ResultSet resultSet) throws SQLException {
    Employee employee = new Employee();
    employee.setId(resultSet.getLong("ID"));
    employee.setName(resultSet.getString("FIRST_NAME"));
    employee.setActive(resultSet.getBoolean(1));

    return employee;
  }*/


 /* @SuppressWarnings("unchecked")
  @Override
  public List<Employee> findPagedResultByEmployeeId(long id, int offset, int limit) {
    String query = "select s.* from Employee s "
        + "join somethingelse selse on selse.id = s.fk_somethingelse "
        + "where selse.id = :id";
    //+ "order by selse.date";
    Query nativeQuery = entityManager.createNativeQuery(query);
    nativeQuery.setParameter("id", id);
    //Paginering
    nativeQuery.setFirstResult(offset);
    nativeQuery.setMaxResults(limit);
    final List<Object[]> resultList = nativeQuery.getResultList();
    List<Employee> employeeList = Lists.newArrayList();
    resultList
        .forEach(object -> employeeList.add(new Employee("Olaf", true)*//*map obj to something*//*));
    return employeeList;
  }*/


}
