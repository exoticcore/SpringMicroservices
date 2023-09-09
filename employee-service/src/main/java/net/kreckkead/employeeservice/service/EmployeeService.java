package net.kreckkead.employeeservice.service;

import net.kreckkead.employeeservice.dto.APIResponseDto;
import net.kreckkead.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
