package com.dvoretskyi.department.entity;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Department.
 */



public class Department {

  private long id;
  private String name;
  private List<Employee> employee;

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

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employee=" + employee +
                '}';
    }

    /**
   * Instantiates a new Department.
   *
   * @param name the name
   */
  public Department(String name) {
    this.name = name;
  }

    public Department() {
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
