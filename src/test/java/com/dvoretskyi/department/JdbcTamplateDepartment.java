package com.dvoretskyi.department;

import com.dvoretskyi.department.entity.Department;
import com.dvoretskyi.department.exception.JdbcTemplateDepartment;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class JdbcTamplateDepartment {

  private JdbcTemplateDepartment jdbcTemplateDepartment;

  @Before
  public void setup2() {
    EmbeddedDatabase db = new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.H2)
        .addScript("department.sql")
        .build();
    jdbcTemplateDepartment = new JdbcTemplateDepartment();
    jdbcTemplateDepartment.setDataSource(db);
    jdbcTemplateDepartment.postConstruct();
  }

  @Test
  public void testJdbcTemplate() {
    Department department = Department.create("HR");
    jdbcTemplateDepartment.save(department);
    List<Department> departments = jdbcTemplateDepartment.loadAll();
    System.out.println("Loaded Persons: " + jdbcTemplateDepartment);
    for (Department department1 : departments) {

      Assert.assertTrue("HR".equals(department1.getName()));

    }

  }
}