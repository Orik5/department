package com.dvoretskyi.department.repository;

import com.dvoretskyi.department.entity.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * The interface Employee repository.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  @Query(value = "select n from Employee n where n.name like :name%")
  List<Employee> findByName(@Param("name") String name);
}
