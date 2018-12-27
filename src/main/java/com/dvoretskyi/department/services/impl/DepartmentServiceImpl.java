package com.dvoretskyi.department.services.impl;

import com.dvoretskyi.department.entity.Department;
import com.dvoretskyi.department.repository.DepartmentRepository;
import com.dvoretskyi.department.services.DepartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Department service.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  /* @Override
   public Department findDepartmentById(long id) {
     return departmentRepository.findById(id).get();
   }
 */
  @Override
  public Department findDepartmentById(long id) {
    Department department = departmentRepository.findDepartmentById(id);
    return department;
  }
/*
  @Override
  public void deleteDepartmentById(long id) {
    departmentRepository.deleteById(id);
  }*/

  @Override
  public void deleteDepartmentById(long id) {
    departmentRepository.deleteDepartmentById(id);
  }
/*  @Overridel
  public Department saveDepartment(Department department) {
    return departmentRepository.save(department);
  }*/

  @Override
  public void saveDepartment(Department department) {
    departmentRepository.addDepartment(department);
  }


  /* @Override
   public List<Department> findAllDepartments() {
     return departmentRepository.findAll();
   }*/
  @Override
  public List<Department> findAllDepartments() {
    return departmentRepository.findAllDepartments();
  }
}
