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
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
public class EmployeeDto extends ResourceSupport {


  private String name;
  private Boolean active;
  private long department;


  /**
   * Convert to dto employee dto.
   *
   * @param employee the employee
   * @return the employee dto
   */
  public static EmployeeDto convertToDto(Employee employee) {
    return new EmployeeDto(employee.getName(), employee.getActive(),
        employee.getDepartment());

  }


}
