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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@Repository
@CrossOrigin(origins = "http://localhost:4200")

public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private DataSource dataSource;

    private EntityManager entityManager;


    public JdbcTemplate getTemplate() {
        return jdbcTemplate;
    }

    public void setTemplate(JdbcTemplate template) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
                "employee_active/*,FK_Emp_DP,*/,department_name FROM department_employee1.employee111" +
                " left  JOIN department111 ON employee111.FK_Emp_DP = department111.FK_Emp_DP ";
        RowMapper<Employee> rowMapper = new EmployeeRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Employee findEmployeeById(long id) {
        String sql = "SELECT employee_id, employee_first_name, employee_surname, employee_middle_name, employee_profession, " +
                "employee_date_of_birth, employee_phone_number, employee_email, employee_salary, " +
                "employee_active FROM department_employee1.employee111 WHERE employee_id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper(Employee.class);
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
        // return employee;
    }

    @Override
    public Employee addEmployee(Employee employee) {/// TODO: 5/9/2019 check 
        String sql = "INSERT INTO department_employee1.employee111(employee_id , employee_first_name,employee_surname ,employee_middle_name, employee_profession , employee_date_of_birth ,employee_phone_number,employee_email,employee_salary ,employee_active) values(?,?,?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql, new Object[]{employee.getId(), employee.getFirstName(), employee.getSurname(),
                employee.getMiddleName(), employee.getProfession(), employee.getDateOfBirth(),
                employee.getPhoneNumber(), employee.getEmail(), employee.getSalary(),
                employee.getActive()/* , employee.getDepartment()*/});

        //Fetch employee id
        sql = "SELECT employee_id FROM department_employee1.employee111 WHERE employee_first_name =? and employee_surname=? " +
                "and employee_middle_name =? and employee_profession =? and   employee_date_of_birth=? and   employee_phone_number=?  " +
                "and employee_email =? and employee_salary =? and employee_active=? ";
        int id = jdbcTemplate
                .queryForObject(sql, Integer.class, new Object[]{employee.getFirstName(), employee.getSurname(),
                        employee.getMiddleName(), employee.getProfession(), employee.getDateOfBirth(),
                        employee.getPhoneNumber(), employee.getEmail(), employee.getSalary(), employee.getActive()/*,
            employee.getDepartment()*/});

        //Set employee id
        employee.setId(id);
        return employee;
    }


    @Override
    public Employee updateEmployee(Employee employee, long id) {// TODO: 5/9/2019 check
        String sql = "UPDATE department_employee1.employee111 SET employee_first_name =?, employee_surname=?, " +
                "employee_middle_name =?, employee_profession =?, employee_date_of_birth=?, employee_phone_number=?," +
                " employee_email =?, employee_salary =?, employee_active=? /*and FK_Emp_DP */WHERE employee_id=?";
        try {
            jdbcTemplate.update(sql, new Object[]{employee.getFirstName(), employee.getSurname(),
                    employee.getMiddleName(), employee.getProfession(), employee.getDateOfBirth(),
                    employee.getPhoneNumber(), employee.getEmail(), employee.getSalary(), employee.getActive()/*, employee.getDepartment()*/, employee.getId()});
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
        String sql = "DELETE FROM department_employee1.employee111 WHERE employee_id=?";
        jdbcTemplate.update(sql, id);

        // RowMapper<Employee> rowMapper = new BeanPropertyRowMapper(Employee.class);
        return employee;
    }


    private Employee toEmployee(ResultSet resultSet) throws SQLException { // TODO: 5/9/2019 check if needed
        Employee employee = new Employee();

        employee.setId(resultSet.getLong("employee_id"));
        employee.setFirstName(resultSet.getString("employee_name"));
        employee.setActive(resultSet.getBoolean("active"));
        //employee.setDepartment(resultSet.getLong("FK_Emp_DP"));
        return employee;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public List<Employee> getEmployeesByPage(int pageid, int total) {
        String sql = "SELECT * FROM department_employee1.employee111  left  JOIN department111 ON employee111.FK_Emp_DP = department111.FK_Emp_DP LIMIT " + (pageid - 1) + "," + total;
        RowMapper<Employee> rowMapper = new EmployeeRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);


    }

}
