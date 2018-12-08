package com.dvoretskyi.department;

import com.dvoretskyi.department.services.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/*@RunWith(SpringRunner.class)
@WebMvcTest(HumanController.class)*/
public class DepartmentControllerIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private EmployeeServiceImpl service;

//  @Test
//  public void givenHuman_whenGetHumans_thenStatus200()
//      throws Exception {
//
//
//    mvc.perform(get("/api/humans")
//        .contentType(MediaType.APPLICATION_JSON))
//        .andExpect(status().isOk())
//        .andExpect(content()
//            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//        .andExpect((ResultMatcher) jsonPath("$[0].name", is("bob")));
//  }

  /*@Test
  public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
      throws Exception {
    Human human = new Human(3, "Boromyr", "Hortyuk", "Chernihiv", "+38986768478");

    List<Human> allHumans = Arrays.asList(human);

    given(service.findAllHumans()).willReturn(allHumans);

    mvc.perform(get("/api/humans")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect((ResultMatcher) MockRestRequestMatchers.jsonPath("$", hasSize(1)))
        .andExpect(
            (ResultMatcher) MockRestRequestMatchers
                .jsonPath("$[0].name", is(human.getSecondName())));
  }
*/

}//}
