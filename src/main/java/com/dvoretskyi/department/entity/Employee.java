package com.dvoretskyi.department.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




public class Employee {

  private long id;
  private String name;
  private Boolean active;
  private long department;

  public Employee(String name, boolean active) {
    this.name = name;
    this.active = active;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", active=" + active +
            ", department=" + department +
            '}';
  }

  public Employee(String name, Boolean active, long department) {
    this.name = name;
    this.active = active;
    this.department = department;
  }

  public Employee() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public long getDepartment() {
    return department;
  }

  public void setDepartment(long department) {
    this.department = department;
  }

  public static Employee create(String name, boolean active, long department) {
    Employee employee = new Employee();
    employee.setName(name);
    employee.setActive(active);
    employee.setDepartment(department);

    return employee;
  }
}
