package com.dvoretskyi.department.dto;

import com.dvoretskyi.department.entity.Department;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class DepartmentDto extends ResourceSupport {

  private String name;

  public static DepartmentDto convertToDto(Department department) {
    return new DepartmentDto(department.getName());
  }
}
