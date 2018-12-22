package com.dvoretskyi.department.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class Employee {

  private long id;
  private String name;
  private Boolean active;
  private long department;

  public Employee(String name, boolean active) {
    this.name = name;
    this.active = active;
  }

  public Employee(String name, Boolean active, long department) {
    this.name = name;
    this.active = active;
    this.department = department;
  }

  public static Employee create(String name, boolean active, long department) {
    Employee employee = new Employee();
    employee.setName(name);
    employee.setActive(active);
    employee.setDepartment(department);
    //employee.setDepartment(department.getId());
    return employee;
  }
}
