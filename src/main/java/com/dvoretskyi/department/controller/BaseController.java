package com.dvoretskyi.department.controller;

import com.dvoretskyi.department.services.DepartmentService;
import com.dvoretskyi.department.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The type Base controller.
 */
@Controller
public class BaseController {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private DepartmentService departmentService;

  /**
   * List employees string.
   *
   * @param model the model
   * @return the string
   */
  @GetMapping("/")
  public String listEmployees(Model model) {
    model.addAttribute("employees", employeeService.findAllEmployees());
    model.addAttribute("departments", departmentService.findAllDepartments());
    return "index";
  }
}
