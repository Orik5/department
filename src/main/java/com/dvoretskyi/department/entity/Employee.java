package com.dvoretskyi.department.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

//@Table(name = "tblEmployees")
public class Employee {
  //@Id
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  //@Column(name = "empID")
  private long id;
 //@Column(name = "empName", length = 55)
  private String name;

 //@Column(name = "empActive")
  private Boolean active;

 //@ManyToOne(fetch = FetchType.EAGER)
 //@JoinColumn(name = "emp_dpID", referencedColumnName = "dpID")
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
  public static Employee create(String name, boolean active,long department) {
    Employee employee = new Employee();
    employee.setName(name);
    employee.setActive(active);
    employee.setDepartment(department);
   //employee.setDepartment(department.getId());
    return employee;
  }
}
