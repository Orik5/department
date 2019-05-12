package com.dvoretskyi.department.dto;

import com.dvoretskyi.department.entity.Department;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

/**
 * The type Department dto.
 */

@JsonInclude(Include.NON_NULL)
public class DepartmentDto extends ResourceSupport {

    private String name;

    public String getName() {
        return name;
    }

    public DepartmentDto(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentDto() {
    }

    /**
     * Convert to dto department dto.
     *
     * @param department the department
     * @return the department dto
     */
    public static DepartmentDto convertToDto(Department department) {
        return new DepartmentDto(department.getName());
    }

    @Override
    public String toString() {
        return "DepartmentDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
