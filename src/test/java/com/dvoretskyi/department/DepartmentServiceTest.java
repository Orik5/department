package com.dvoretskyi.department;

public class DepartmentServiceTest {
/*  @Mock
  private DepartmentRepository departmentRepository;
  @InjectMocks
  private DepartmentServiceImpl departmentService;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testAddDepartment_returnsNewDepartment() {
    when(departmentRepository.save(any(Department.class))).thenReturn(new Department());
    Department department = new Department();
    assertThat(departmentService.saveDepartment(department), is(notNullValue()));
  }

  //Using Answer to set an id to the customer which is passed in as a parameter to the mock method.
 *//* @Test
  public void testAddDepartment_returnsNewDepartmentWithId() {
    when(departmentRepository.save(any(Department.class))).thenAnswer(new Answer<Department>() {
      @Override
      public Department answer(InvocationOnMock invocation) throws Throwable {
        Object[] arguments = invocation.getArguments();
        if (arguments != null && arguments.length > 0 && arguments[0] != null) {
          Department department = (Department) arguments[0];
          department.setId(1);
          return department;
        }
        return null;
      }
    });
   Department department = new Department();
    assertThat(departmentService.saveDepartment(department), is(notNullValue()));
  }
*//*
  //Throwing an exception from the mocked method
  @Test(expected = RuntimeException.class)
  public void testAddDepartment_throwsException() {
    when(departmentRepository.save(any(Department.class))).thenThrow(RuntimeException.class);
    Department department = new Department();
    departmentService.saveDepartment(department);//
  }*/
}
