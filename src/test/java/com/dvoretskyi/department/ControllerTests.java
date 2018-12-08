package com.dvoretskyi.department;


import com.dvoretskyi.department.controller.EmployeeController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DepartmentApplication.class})
public class ControllerTests {

  @Autowired
  private EmployeeController employeeController;


  @Test
  public void contextLoads() throws Exception {

    Assert.assertNotNull(employeeController);

  }

}
