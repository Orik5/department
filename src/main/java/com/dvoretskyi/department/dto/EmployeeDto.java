package com.dvoretskyi.department.dto;

import com.dvoretskyi.department.entity.Employee;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.math.BigDecimal;


/**
 * The type Employee dto.
 */

@JsonInclude(Include.NON_NULL)
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String surname;
    private String middleName;
    private String profession;
    private String dateOfBirth;
    private String phoneNumber;
    private String email;
    private BigDecimal salary;
    private boolean active;
    private Long department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department = department;
    }

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String firstName, String surname, String middleName,
                       String profession, String dateOfBirth, String phoneNumber,
                       String email, BigDecimal salary, Boolean active, Long department) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.middleName = middleName;
        this.profession = profession;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.salary = salary;
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
        return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getSurname(), employee.getMiddleName(),
                employee.getProfession(), employee.getDateOfBirth(), employee.getPhoneNumber(), employee.getEmail(), employee.getSalary(), employee.getActive()
                , employee.getDepartment());

    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", active=" + active +
                ", department=" + department +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", profession='" + profession + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
