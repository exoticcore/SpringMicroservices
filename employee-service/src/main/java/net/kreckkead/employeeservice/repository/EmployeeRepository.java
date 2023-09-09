package net.kreckkead.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.kreckkead.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
