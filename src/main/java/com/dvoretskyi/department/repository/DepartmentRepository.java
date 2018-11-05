package com.dvoretskyi.department.repository;

import com.dvoretskyi.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Department repository.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {


}
