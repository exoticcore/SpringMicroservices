package net.kreckkead.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.kreckkead.employeeservice.dto.DepartmantDto;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    // Build get department rest api
    @GetMapping("/api/departments/{code}")
    DepartmantDto getDepartmentByCode(@PathVariable("code") String departmentCode);
}
