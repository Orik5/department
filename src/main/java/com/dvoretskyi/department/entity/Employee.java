package com.dvoretskyi.department.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

@Table(name = "tblEmployees")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "empID")
  private long id;
 @Column(name = "empName", length = 55)
  private String name;

 @Column(name = "empActive")
  private Boolean active;

 @ManyToOne(fetch = FetchType.EAGER)
 @JoinColumn(name = "emp_dpID", referencedColumnName = "dpID")
  private Department department;

  public Employee(String name, boolean active) {
    this.name = name;
    this.active = active;
  }

  public Employee(String name, Boolean active, Department department) {
    this.name = name;
    this.active = active;
    this.department = department;
  }
}
