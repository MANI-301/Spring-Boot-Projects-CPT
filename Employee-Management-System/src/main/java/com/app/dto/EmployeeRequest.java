package com.app.dto;




import jakarta.validation.constraints.*;

public class EmployeeRequest {
    
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;
    
    @NotBlank(message = "Department is required")
    @Size(min = 2, max = 50, message = "Department must be between 2 and 50 characters")
    private String department;
    
    @NotNull(message = "Salary is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")
    private Double salary;
    
    // ✅ Constructors
    public EmployeeRequest() {}
    
    // ✅ Getters
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public Double getSalary() { return salary; }
    
    // ✅ Setters
    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setSalary(Double salary) { this.salary = salary; }
}