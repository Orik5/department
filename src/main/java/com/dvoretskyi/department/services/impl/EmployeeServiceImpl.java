package com.dvoretskyi.department.services.impl;

import com.dvoretskyi.department.dto.EmployeeDto;
import com.dvoretskyi.department.entity.Employee;
import com.dvoretskyi.department.repository.PaginationRepository;
import com.dvoretskyi.department.repository.impl.EmployeeRepositoryImpl;
import com.dvoretskyi.department.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Employee service.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepositoryImpl employeeRepository;
    @Autowired
    private PaginationRepository paginationRepository;

    @Override
    public Employee findEmployeeById(long id) {
        Employee employee = employeeRepository.findEmployeeById(id);
        return employee;
    }

    @Override
    public Employee deleteEmployeeById(long id) {
        Employee employee = employeeRepository.deleteEmployeeById(id);
        return employee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    /*  @Override
      public List<Employee> findAllEmployees() {
        return employeeRepository.findAllEmployees();
      }*/
    @Override
    public List<EmployeeDto> findAllEmployees() {
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAllEmployees();
        for (Employee employee : employees) {
            employeeDtos.add(EmployeeDto.convertToDto(employee));
            employeeDtos.subList(0,1);
        }

        return employeeDtos;
    }

    /*  @Override
    public List<Employee> findByName(String name) {
      return employeeRepository.findByName(name);
    }*/
/*   @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }*/
    @Override
    public Employee editEmployee(Employee employee, long id) {
        return employeeRepository.updateEmployee(employee, id);
    }

//    public Page<Employee> findPaginated(Pageable pageable) {
//        int pageSize = pageable.getPageSize();
//        int currentPage = pageable.getPageNumber();
//        int startItem = currentPage * pageSize;
//        List<EmployeeDto> list;
//        if (findAllEmployees().size() < startItem) {
//            list = Collections.emptyList();
//        } else {
//            int toIndex = Math.min(startItem + pageSize, findAllEmployees().size());
//            list = findAllEmployees().subList(startItem, toIndex);
//        }
//        Page<Employee> bookPage = new PageImpl(list, PageRequest.of(currentPage, pageSize),
//                findAllEmployees().size());
//        return bookPage;
//    }
    public static Employee create(String firstName, boolean active, String department) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setActive(active);
        employee.setDepartment(department);

        return employee;
    }

    public static String employeeRegex(String phoneNumber) {
        Employee employee = new Employee();

        phoneNumber = employee.getPhoneNumber();
        //String phNumber = "123 123 1234";

        Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
        Matcher matcher = pattern.matcher(phoneNumber);

        if (matcher.matches()) {
            System.out.println("Phone Number is Valid");
        } else {
            System.out
                    .println("Phone Number isn't in this formate XXX-XXX-XXXX");
        }
        return phoneNumber;
    }

    @Override
    public List<Employee> getEmployeesByPage(int pageId, int total) {


        return employeeRepository.getEmployeesByPage(pageId,total);
    }



   /* @Override
    public EmployeesResponse getEmployees(Paginator paginator,String searchValue) {
        EmployeesResponse employees = new EmployeesResponse();
        employees.setTotalCount(0);
        employees.setEmployees(new ArrayList<>());
        //if(nonNull(authUserId) && nonNull(authUserRole) && authUserRole.equals(Role.ORGANIZATION)){
//            Employee employee = employeeRepository.g(authUserId);
//            if(isNull(user)){
//                String error = "The user does not exist!";
//                LOG.error(error);
//                throw new IllegalArgumentException(error);
//            }
//            PersonalData personalData = user.getPersonalData();
//            if(isNull(personalData) || !(personalData instanceof ProPersonalData)){
//                String error = "Invalid user's data!";
//                LOG.error(error);
//                throw new IllegalArgumentException(error);
//            }

                employees = paginationRepository.getEmployees(paginator, searchValue);

               // List<ProPersonalData> allByOrganization = proPersonalDataRepository.findAllByOrganization(organization);
               // if(nonNull(allByOrganization)){
                  //  for (ProPersonalData pData : allByOrganization) {
                      //  Long userIdByPersonalData = userRepository.findUserIdByPersonalData(pData);
                      //  if(nonNull(userIdByPersonalData)){
        EmployeesResponse employeesResponse = paginationRepository.getEmployees(paginator, searchValue);
        if (Objects.nonNull(employeesResponse)) {
            employeesResponse.getEmployees().addAll(employeesResponse.getEmployees());
            employeesResponse.setTotalCount(employeesResponse.getTotalCount() + employeesResponse.getTotalCount());
                         //   }
                      //  }
                    }
             //   }
          //  }
       // }
        return employees;
                }*/








}
