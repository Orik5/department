package com.dvoretskyi.department.controller;

import com.dvoretskyi.department.entity.Department;
import com.dvoretskyi.department.services.DepartmentService;
import io.swagger.annotations.Api;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Department controller.
 */
@RestController
@RequestMapping("/api")
@Api(value = "department")
@EnableHypermediaSupport(type = HypermediaType.HAL)

public class DepartmentController {

  public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
  @Autowired
  private DepartmentService departmentService;

  /**
   * Gets add department page.
   *
   * @return the add department page
   */
  @GetMapping("/departments")
  public String getAddDepartmentPage() {
    return "/addDepartment";
  }

  /**
   * Gets departments page.
   *
   * @param model the model
   * @return the departments page
   */
  @GetMapping("/departments")
  public String getDepartmentsPage(Model model) {
    model.addAttribute("departments", departmentService.findAllDepartments());
    return "departments";
  }

  /**
   * Add departure string.
   *
   * @param name the name
   * @return the string
   */
  @PostMapping("/departments")
  public String addDeparture(@RequestParam("name") String name) {
    departmentService.saveDepartment(new Department(name));
    return "redirect:/";
  }

  /**
   * Gets all departments.
   *
   * @return the all departments
   */
  @RequestMapping(value = "/departments", method = RequestMethod.GET)
  public List<Department> getAllDepartments() {
    return departmentService.findAllDepartments();
  }


  /**
   * Gets department.
   *
   * @param id the id
   * @return the department
   */
  @RequestMapping(value = "/departments{id}")
  public Department getDepartment(@PathVariable("id") long id) {
    return departmentService.findDepartmentById(id);
  }


  /**
   * Add department department.
   *
   * @param department the department
   * @return the department
   */
/*  @RequestMapping(value = "/departments", method = RequestMethod.POST)
  public Department addDepartment(Department department) {
    return departmentService.saveDepartment(department);
  }*/
  @RequestMapping(value = "/departments", method = RequestMethod.POST)
  public void addDepartment(Department department) {
    departmentService.saveDepartment(department);
  }


  /**
   * Delete department.
   *
   * @param id the id
   */
  @RequestMapping(value = "/departments{id}", method = RequestMethod.DELETE)
  public void deleteDepartment(@PathVariable long id) {
    departmentService.deleteDepartmentById(id);
  }
}
