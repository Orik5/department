package com.dvoretskyi.department.repository;

import com.dvoretskyi.department.entity.Department;
import java.util.List;


public interface DepartmentRepository {

  List<Department> findAllDepartments();

  Department findDepartmentById(long id);

  void addDepartment(Department department);

  void updateDepartment(Department department);

  void deleteDepartmentById(long id);

}
