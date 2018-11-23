package com.dvoretskyi.department.repository;

import com.dvoretskyi.department.entity.Department;
import java.util.List;

/**
 * The interface Department repository.
 */
//@Repository
public interface DepartmentRepository /*extends JpaRepository<Department, Long> */ {

  List<Department> findAllDepartmentds();

  Department findDepartmentById(long id);

  void addDepartment(Department department);

  void updateDepartment(Department department);

  void deleteDepartmentById(long id);

}
