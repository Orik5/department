package com.dvoretskyi.department.controller;

import com.dvoretskyi.department.entity.Department;
import com.dvoretskyi.department.services.DepartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class DepartmentController {



  @Autowired
  private DepartmentService departmentService;

  @RequestMapping(value = "/departments", method = RequestMethod.GET)
  public List<Department> getAllDepartments() {
    return departmentService.findAllDepartments();
  }


  @RequestMapping(value = "/departments{id}")
  public Department getDepartment(@PathVariable("id") long id) {
    return departmentService.findDepartmentById(id);
  }


  @RequestMapping(value = "/departments", method = RequestMethod.POST)
  public Department addDepartment(Department department) {
    return departmentService.saveDepartment(department);
  }


  @RequestMapping(value = "/departments/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Object> updateEmployee(@RequestBody Department department,
      @PathVariable long id) {

    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value = "/departments{id}", method = RequestMethod.DELETE)
  public void deleteDepartment(@PathVariable long id) {
    departmentService.deleteDepartmentById(id);
  }
}
