package net.kreckkead.derpartmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.kreckkead.derpartmentservice.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    Department findByDepartmentCode(String departmentCode);
}
