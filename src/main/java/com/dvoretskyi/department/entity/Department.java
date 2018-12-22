package com.dvoretskyi.department.entity;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Department.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Department {

  private long id;
  private String name;
  private List<Employee> employee;

  /**
   * Instantiates a new Department.
   *
   * @param name the name
   */
  public Department(String name) {
    this.name = name;
  }

  /**
   * Create department.
   *
   * @param name the name
   * @return the department
   */
  public static Department create(String name) {
    Department department = new Department();
    department.setName(name);

    return department;
  }

}
