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

//@Table(name = "tblDepartments")
public class Department {

  //@Id
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  // @Column(name = "dpID")
  private long id;
  // @Column(name = "dpName", nullable = false, length = 25)
  private String name;

  //@OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = CascadeType.ALL)
  private List<Employee> employee;

  public Department(String name) {
    this.name = name;
  }
}
