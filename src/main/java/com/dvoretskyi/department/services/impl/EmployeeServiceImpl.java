package com.dvoretskyi.department.services.impl;

import com.dvoretskyi.department.dto.EmployeeDto;
import com.dvoretskyi.department.entity.Employee;
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

    @Override
    public List<EmployeeDto> findAllEmployees() {
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAllEmployees();
        for (Employee employee : employees) {
            employeeDtos.add(EmployeeDto.convertToDto(employee));
            employeeDtos.subList(0, 1);
        }

        return employeeDtos;
    }


    @Override
    public Employee editEmployee(Employee employee, long id) {
        return employeeRepository.updateEmployee(employee, id);
    }

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


        return employeeRepository.getEmployeesByPage(pageId, total);
    }

}
