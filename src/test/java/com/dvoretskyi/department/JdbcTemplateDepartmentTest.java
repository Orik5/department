package com.dvoretskyi.department;

import com.dvoretskyi.department.entity.Department;
import com.dvoretskyi.department.repository.impl.DepartmentRepositoryImpl;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class JdbcTemplateDepartmentTest {

  private DepartmentRepositoryImpl departmentRepository = new DepartmentRepositoryImpl();

  @Before
  public void setup2() {
    EmbeddedDatabase db = new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.H2)
        .addScript("department.sql")
        .build();
    departmentRepository = new DepartmentRepositoryImpl();
    departmentRepository.setDataSource(db);
    departmentRepository.postConstruct();
  }

//  @Test
  public void testJdbcTemplate() {
    Department department = Department.create("HR");
    departmentRepository.addDepartment(department);
    List<Department> departments = departmentRepository.findAllDepartments();
    System.out.println("Loaded Persons: " + departmentRepository);
    for (Department department1 : departments) {

      Assert.assertTrue("HR".equals(department1.getName()));

    }
  }
}
