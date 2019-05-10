package com.dvoretskyi.department.repository.impl;

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

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

//@Transactional
@Repository
@CrossOrigin(origins = "http://localhost:4200")

public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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
        String sql = "SELECT employee_id, employee_first_name, employee_surname, employee_middle_name, employee_profession," +
                "employee_date_of_birth, employee_phone_number, employee_email, employee_salary," +
                "employee_active,FK_Emp_DP FROM department_employee1.employee";
        //RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        RowMapper<Employee> rowMapper = new EmployeeRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Employee findEmployeeById(long id) {
        String sql = "SELECT employee_id, employee_first_name, employee_surname, employee_middle_name, employee_profession, " +
                "employee_date_of_birth, employee_phone_number, employee_email, employee_salary, " +
                "employee_active/*,FK_Emp_DP*/ FROM department_employee1.employee WHERE employee_id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper(Employee.class);
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
        // return employee;
    }

    @Override
    public Employee addEmployee(Employee employee) {/// TODO: 5/9/2019 check 
        String sql = "INSERT INTO department_employee1.employee(employee_id,employee_first_name,employee_surname ,employee_middle_name," +
                "employee_profession ,  employee_date_of_birth ," +
                "  employee_phone_number,employee_email,employee_salary ,employee_active/*,FK_Emp_DP*/" +
                "values (?,?,?,?,?,?,?,?,?,?/*,?*/)";
        jdbcTemplate.update(sql, new Object[]{employee.getId(), employee.getFirstName(), employee.getSurname(),
                employee.getMiddleName(), employee.getProfession(), employee.getDateOfBirth(),
                employee.getPhoneNumber(), employee.getEmail(), employee.getSalary(),
                employee.getActive() /*, employee.getDepartment()*/});

        //Fetch employee id
        sql = "SELECT employee_id FROM department_employee1.employee WHERE employee_first_name =? and employee_surname=? " +
                "and employee_middle_name =? and employee_profession =? and   employee_date_of_birth=? and   employee_phone_number=?  " +
                "and employee_email =? and employee_salary =? and employee_active=?/*and FK_Emp_DP=?*/";
        int id = jdbcTemplate
                .queryForObject(sql, Integer.class, new Object[]{employee.getFirstName(), employee.getSurname(),
                        employee.getMiddleName(), employee.getProfession(), employee.getDateOfBirth(),
                        employee.getPhoneNumber(), employee.getEmail(), employee.getSalary(), employee.getActive()/*,
 //           employee.getDepartment()*/});

        //Set employee id
        employee.setId(id);
        return employee;
    }


    /*
    public void addDashboard(DynamicDashboard dynamicDashboard) {
        String sql = "INSERT INTO dynamic_dashboard "
                + "(DASHBOARD_NAME, HTML_CONTENT,SCRIPT_CONTENT,RULE_CONTENT) VALUES (?, ?, ?,?)";

        try {
            jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(sql,
                    new Object[] { dynamicDashboard.getDashboardName(), dynamicDashboard.getHtmlContent(),
                            dynamicDashboard.getScriptContent(), dynamicDashboard});
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
 public void addDashboard(DynamicDashboard dynamicDashboard) {
        String sql = "INSERT INTO dynamic_dashboard "
                + "(DASHBOARD_NAME, HTML_CONTENT,SCRIPT_CONTENT,RULE_CONTENT) VALUES (?, ?, ?,?)";

        try {
            jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(sql,
                    new Object[] { dynamicDashboard.getDashboardName(), dynamicDashboard.getHtmlContent(),
                            dynamicDashboard.getScriptContent(), dynamicDashboard.getRuleContent()});
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

    *
    * */
    @Override
    public Employee updateEmployee(Employee employee, long id) {// TODO: 5/9/2019 check
        String sql = "UPDATE department_employee1.employee SET employee_first_name =?, employee_surname=?, " +
                "employee_middle_name =?, employee_profession =?, employee_date_of_birth=?, employee_phone_number=?," +
                " employee_email =?, employee_salary =?, employee_active=? /*and FK_Emp_DP */WHERE employee_id=?";
        try {
            jdbcTemplate.update(sql, new Object[]{employee.getFirstName(), employee.getSurname(),
                    employee.getMiddleName(), employee.getProfession(), employee.getDateOfBirth(),
                    employee.getPhoneNumber(), employee.getEmail(), employee.getSalary(), employee.getActive()/*,
 //           employee.getDepartment()*/, employee.getId()}/*, employee.getDepartment()*/);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // RowMapper<Employee> rowMapper = new BeanPropertyRowMapper(Employee.class);
        //  return this.jdbcTemplate.queryForObject(sql, rowMapper, employee);
        return employee;
    }

    @Override
    public Employee deleteEmployeeById(long id) {
        Employee employee = new Employee();
        String sql = "DELETE FROM department_employee1.employee WHERE employee_id=?";
        jdbcTemplate.update(sql, id);

        // RowMapper<Employee> rowMapper = new BeanPropertyRowMapper(Employee.class);
        return employee;
    }

/*  @Override
  public List<Employee> findByName(String name) {
    *//*String sql = "id, name FROM department";
    //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
    RowMapper<Employee> rowMapper = new EmployeeRowMapper();
    return this.jdbcTemplate.query(sql, rowMapper);*//*
    return null;
  }*/

/*
    @SuppressWarnings("unchecked")*/

   /* @Override
    public List<Employee> findPagedResultByEmployeeId(long id, int offset, int limit) {
        String query = "select s.* from department_employee1 s. "
                + "join employee on employee.id = s.FK_Empl_DP "
                + "where employee.id = :employee_id";
        //+ "order by selse.date";
        Query nativeQuery = entityManager.createNativeQuery(query);
        nativeQuery.setParameter("id", id);
        //Paginering
        nativeQuery.setFirstResult(offset);
        nativeQuery.setMaxResults(limit);
        final List<Object[]> resultList = nativeQuery.getResultList();
        List<Employee> employeeList = Lists.newArrayList();
        resultList
                .forEach(object -> employeeL ist.add(new Employee("Olaf", true, 3)));
        return employeeList;
    }*/

    private Employee toEmployee(ResultSet resultSet) throws SQLException { // TODO: 5/9/2019 check if needed 
        Employee employee = new Employee();

        employee.setId(resultSet.getLong("employee_id"));
        employee.setFirstName(resultSet.getString("employee_name"));
        employee.setActive(resultSet.getBoolean("active"));
        employee.setDepartment(resultSet.getLong("FK_Emp_DP"));
        return employee;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
