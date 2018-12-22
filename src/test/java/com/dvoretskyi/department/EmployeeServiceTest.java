package com.dvoretskyi.department;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.dvoretskyi.department.entity.Employee;
import com.dvoretskyi.department.repository.impl.EmployeeRepositoryImpl;
import com.dvoretskyi.department.services.impl.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EmployeeServiceTest {

  @Mock
  private EmployeeRepositoryImpl employeeRepository;
  @InjectMocks
  private EmployeeServiceImpl employeeService;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }




/*  @Test
  public void testAddEmployee_returnsNewEmployee() {
    when(employeeRepository.addEmployee(any(Employee.class))).thenReturn(new Employee());
    Employee employee = new Employee();
    assertThat(employeeService.saveEmployee(employee), is(notNullValue()));
  }*/

  //Using Answer to set an id to the customer which is passed in as a parameter to the mock method.


  //Throwing an exception from the mocked method
  @Test(expected = RuntimeException.class)
  public void testAddEmployee_throwsException() {
    when(employeeRepository.addEmployee(any(Employee.class))).thenThrow(RuntimeException.class);
    Employee employee = new Employee();
    employeeService.saveEmployee(employee);//
  }
}
