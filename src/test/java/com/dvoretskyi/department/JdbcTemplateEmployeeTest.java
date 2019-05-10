package com.dvoretskyi.department;

import com.dvoretskyi.department.entity.Employee;
import com.dvoretskyi.department.repository.impl.EmployeeRepositoryImpl;

import java.util.List;

import com.dvoretskyi.department.services.impl.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;


public class JdbcTemplateEmployeeTest {

    private EmployeeRepositoryImpl repository;

    private EmployeeServiceImpl employeeService;


    @Before
    public void setup() {
        EmbeddedDatabase db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("department.sql")
                .build();
        repository = new EmployeeRepositoryImpl();
        repository.setDataSource(db);
        repository.postConstruct();
    }

    @Test
    public void testJdbcTemplate(Employee employee) {
        employeeService.create("Bob", true, 1);
        repository.addEmployee(employee);
   /* Department department = Department.create("HR");
    jdbcTemplateDepartment.save(department);*/
        // Department department =Department.create();

        List<Employee> employees = repository.findAllEmployees();

        System.out.println("Loaded Persons: " + employees);
    /*List<Department> departments = jdbcTemplateDepartment.loadAll();
    System.out.println("Loaded Persons: " + jdbcTemplateDepartment);*/
        for (Employee employee1 : employees) {

            //Assert.assertTrue("1".equals(employee1.getId()));

            //     Assert.assertTrue(employee.getFirstName().equals(employee1.getFirstName()));
            //Assert.assertTrue(true);
            Assert.assertNotNull(repository);
            Assert.assertNotNull(employee1.getId());
            Assert.assertNotNull(employee1.getDepartment());
        }


    }


}









