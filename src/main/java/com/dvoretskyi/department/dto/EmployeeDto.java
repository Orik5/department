package com.dvoretskyi.department.dto;

import com.dvoretskyi.department.entity.Employee;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.ResourceSupport;


/**
 * The type Employee dto.
 */

@JsonInclude(Include.NON_NULL)
public class EmployeeDto  {

  private  Long id;
  private String name;
  private Boolean active;
  private long department;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

  public EmployeeDto() {
  }


    public EmployeeDto(Long id, String name, Boolean active, long department) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.department = department;
    }

    /**
   * Convert to dto employee dto.
   *
   * @param employee the employee
   * @return the employee dto
   */
  public static EmployeeDto convertToDto(Employee employee) {
    return new EmployeeDto(employee.getId(),employee.getName(), employee.getActive(),
        employee.getDepartment());

  }

  @Override
  public String toString() {
    return "EmployeeDto{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", active=" + active +
            ", department=" + department +
            '}';
  }
}
