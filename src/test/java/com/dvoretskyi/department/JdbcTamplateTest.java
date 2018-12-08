package com.dvoretskyi.department;

import com.dvoretskyi.department.repository.impl.EmployeeRepositoryImpl;


//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = AppConfig.class)
public class JdbcTamplateTest {

  private EmployeeRepositoryImpl repository;

  /*@Before
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
  public void testJdbcTemplate() {
    Employee employee = Employee.create("Java Concurrency", true,"");
    repository.addEmployee(employee);
   // Department department =Department.create();

    List<Employee> employees = repository.findAllEmployees();
    System.out.println("Loaded Persons: " + employees);
    for (Employee employee1 : employees) {
      Assert.assertTrue("Java Concurrency".equals(employee1.getName()));
    //Assert.assertTrue(true.(employee1.getActive()));
     Assert.assertTrue("Spring Boot Getting Started".equals(employee1.getDepartment()));
    }*/
  //}





}
