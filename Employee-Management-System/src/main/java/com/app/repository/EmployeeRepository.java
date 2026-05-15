
package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    // Custom query to find employees by department using @Query
    @Query("SELECT e FROM Employee e WHERE e.department = :department")
    List<Employee> findByDepartment(@Param("department") String department);
    
    // Custom query to find employees with salary greater than X
    @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
    List<Employee> findBySalaryGreaterThan(@Param("salary") Double salary);
    
    // Update salary using @Modifying @Query
    @Modifying
    @Query("UPDATE Employee e SET e.salary = :salary WHERE e.id = :id")
    int updateEmployeeSalary(@Param("id") Long id, @Param("salary") Double salary);
}