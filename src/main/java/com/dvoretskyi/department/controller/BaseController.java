package com.dvoretskyi.department.controller;

import com.dvoretskyi.department.services.impl.DepartmentServiceImpl;
import com.dvoretskyi.department.services.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The type Base controller.
 */
//@Controller
public class BaseController {

  private static int currentPage = 1;
  private static int pageSize = 5;

  @Autowired
  private EmployeeServiceImpl employeeService;

  @Autowired
  private DepartmentServiceImpl departmentService;
/*

  @GetMapping("/")
  public String listEmployees(Model model,
      @RequestParam("page") Optional<Integer> page,
      @RequestParam("size") Optional<Integer> size) {
    page.ifPresent(p -> currentPage = p);
    size.ifPresent(s -> pageSize = s);

    Page<Employee> employeePage = employeeService.findPaginated(PageRequest
        .of(currentPage - 1, pageSize));

    model.addAttribute("employeePage", employeePage);

    int totalPages = employeePage.getTotalPages();
    if (totalPages > 0) {
      List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
          .boxed()
          .collect(Collectors.toList());
      model.addAttribute("pageNumbers", pageNumbers);
    }
    model.addAttribute("employees", employeePage.getContent());
    model.addAttribute("departments", departmentService.findAllDepartments());
    return "index";
  }
*/

}
