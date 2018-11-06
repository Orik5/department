package com.dvoretskyi.department.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblEmployees")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "empID")
  private long id;
 // @Column(name = "empName", nullable = false, length = 55)
  private String name;
 // @Column(name = "empActive")
  private boolean active;
  @ManyToMany//(mappedBy = "tblEmployees")
  @JoinTable(name = "employee_department",
    joinColumns = @JoinColumn(name = "empId"), inverseJoinColumns =@JoinColumn(name = "dpId"))
  private List<Department> department;
}
