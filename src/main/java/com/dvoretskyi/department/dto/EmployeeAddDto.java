package com.dvoretskyi.department.dto;

import com.dvoretskyi.department.entity.Department;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class EmployeeAddDto extends ResourceSupport {

    private String name;
    private Boolean active;
    private Department department;
}
