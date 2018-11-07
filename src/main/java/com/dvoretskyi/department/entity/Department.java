package com.dvoretskyi.department.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor

@Table(name = "tblDepartments")
public class Department {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "dpID")
  private long id;
  @Column(name = "dpName", nullable = false, length = 25)
  private String name;
  @ManyToMany(fetch = FetchType.LAZY,
      cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE
      })
  @JoinTable(name = "employee_department", joinColumns = @JoinColumn(name = "dpId"),
      inverseJoinColumns = @JoinColumn(name = "empId"))

  private List<Employee> employee;

  public Department(String name) {
    this.name = name;
  }
}
