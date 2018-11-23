package com.dvoretskyi.department.services;

import com.dvoretskyi.department.entity.Department;
import java.util.List;

/**
 * The interface Department service.
 */
public interface DepartmentService {

  /**
   * Find department by id department.
   *
   * @param id the id
   * @return the department
   */
  Department findDepartmentById(long id);

  /**
   * Delete department by id.
   *
   * @param id the id
   */
  void deleteDepartmentById(long id);

  /*  Department findDepartmantByName(String name);*/

  /**
   * Save department department.
   *
   * @param department the department
   * @return the department
   */
 //Department saveDepartment(Department department);

  void saveDepartment(Department department);
  /**
   * Find all departments list.
   *
   * @return the list
   */
  List<Department> findAllDepartments();


}
