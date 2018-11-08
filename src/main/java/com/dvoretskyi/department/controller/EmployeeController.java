package com.dvoretskyi.department.controller;

import com.dvoretskyi.department.entity.Department;
import com.dvoretskyi.department.entity.Employee;
import com.dvoretskyi.department.services.DepartmentService;
import com.dvoretskyi.department.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
  public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private DepartmentService departmentService;

  @PostMapping(value = "/addEmployee")
  public String addEmployee(@RequestParam("empName") String empName, @RequestParam("empActive") Boolean empActive, @RequestParam("department") Department department) {
    System.out.println(department);
    if (department == null || department.toString().equals("")) {
      employeeService.saveEmployee(new Employee(empName, empActive));
    } else {
      employeeService.saveEmployee(new Employee(empName, empActive, department));
    }
    return "redirect:/";
  }

  @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
  public String getEmployeeInformationById(@PathVariable("id") long id, Model model) {
    model.addAttribute("employee", employeeService.findEmployeeById(id));
    return "employee";
  }

  @RequestMapping(value = "/employees", method = RequestMethod.POST)
  public Employee addEmployee(Employee employee) {
    return employeeService.saveEmployee(employee);
  }

  @RequestMapping(value = "/removeEmployee/{id}", method = RequestMethod.GET)
  public String deleteEmployee(@PathVariable long id) {
    employeeService.deleteEmployeeById(id);
    return "redirect:/";
  }

  @RequestMapping(value = "search", method = RequestMethod.POST)
  public String searchEmployees(@RequestParam("name") String name, Model model) {
    model.addAttribute("employeesSearched", employeeService.findByName(name));
    return "searchEmployee";
  }

  @GetMapping("/editEmployee/{id}")
  public String getPageEditEmployee(@PathVariable("id") Long id, Model model) {
    model.addAttribute("employee", employeeService.findEmployeeById(id));
    model.addAttribute("departments", departmentService.findAllDepartments());
    return "editEmployee";
  }

  @PostMapping("/editEmployee")
  public String editEmployee(@RequestParam("id") Long id, @RequestParam("empName") String empName,
      @RequestParam("empActive") Boolean empActive,
      @RequestParam("department") Department department) {
    employeeService.editEmployee(id, new Employee(empName, empActive, department));
    return "redirect:/";
  }
}
