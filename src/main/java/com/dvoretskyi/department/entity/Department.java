package com.dvoretskyi.department.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Department.
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

@Table(name = "tblDepartments")
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "dpID")
  private Long id;
  @Column(name = "dpName", nullable = false, length = 25)
  private String name;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = CascadeType.ALL)
  private List<Employee> employee;

  public Department(String name) {
    this.name = name;
  }
}
