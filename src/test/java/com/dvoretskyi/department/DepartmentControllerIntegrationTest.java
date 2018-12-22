package com.dvoretskyi.department;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.dvoretskyi.department.controller.EmployeeController;
import com.dvoretskyi.department.entity.Employee;
import com.dvoretskyi.department.services.impl.EmployeeServiceImpl;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class DepartmentControllerIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private EmployeeServiceImpl service;

 @Test
  public void givenHuman_whenGetHumans_thenStatus200()
      throws Exception {


    mvc.perform(get("/api/employees")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
       .andExpect(content()
            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect((ResultMatcher) jsonPath("$[0].name", is("bob")));
  }

  @Test
  public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
      throws Exception {
   Employee employee = new Employee( "bob",true,1);

    List<Employee> employees= Arrays.asList(employee);

   // given(service.findAllEmployees().(willReturn(employees);

    mvc.perform(get("/api/employees")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect((ResultMatcher) MockRestRequestMatchers.jsonPath("$", hasSize(1)))
        .andExpect(
            (ResultMatcher) MockRestRequestMatchers
                .jsonPath("$[0].name", is(employee.getName())));
  }

}
