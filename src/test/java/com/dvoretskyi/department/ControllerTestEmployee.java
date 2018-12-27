package com.dvoretskyi.department;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DepartmentApplication.class,
  //  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTestEmployee {
/*

  @LocalServerPort
  private int port;

  TestRestTemplate restTemplate = new TestRestTemplate();

  HttpHeaders headers = new HttpHeaders();

  @Test
  public void testRetrieveStudentCourse() throws JSONException {

    HttpEntity<String> entity = new HttpEntity<String>(null, headers);

    ResponseEntity<String> response = restTemplate.exchange(
        createURLWithPort("/api/employees"),
        HttpMethod.GET, entity, String.class);

    String expected = "{id:1,name:Spring,active:true,department:1}";

    JSONAssert.assertEquals(expected, response.getBody(), false);
  }


  @Test
  public void addCourse() {
*/

   /* EmployeeDto employee = new EmployeeDto("hbhbhbhb", true,
        Arrays.asList("yuguugu", "Import Project", "First Example",
            "Second Example"));*/

   /* HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);

    ResponseEntity<String> response = restTemplate.exchange(
        createURLWithPort("/students/Student1/courses"),
        HttpMethod.POST, entity, String.class);

    String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

    assertTrue(actual.contains("/students/Student1/courses/"));

  }

  private String createURLWithPort(String uri) {
    return "http://localhost:" + port + uri;*/
  }

