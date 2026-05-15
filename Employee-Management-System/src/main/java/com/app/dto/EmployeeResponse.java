package com.app.dto;



public class EmployeeResponse {
    
    private Long id;
    private String name;
    private String department;
    private Double salary;
    
    // ✅ Constructors
    public EmployeeResponse() {}
    
    // ✅ Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public Double getSalary() { return salary; }
    
    // ✅ Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setSalary(Double salary) { this.salary = salary; }
}