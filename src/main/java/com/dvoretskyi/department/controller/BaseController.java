package com.dvoretskyi.department.controller;

import com.dvoretskyi.department.entity.Employee;
import com.dvoretskyi.department.services.impl.DepartmentServiceImpl;
import com.dvoretskyi.department.services.impl.EmployeeServiceImpl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The type Base controller.
 */
@Controller
public class BaseController {

  private static int currentPage = 1;
  private static int pageSize = 5;

  @Autowired
  private EmployeeServiceImpl employeeService;

  @Autowired
  private DepartmentServiceImpl departmentService;

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

}
