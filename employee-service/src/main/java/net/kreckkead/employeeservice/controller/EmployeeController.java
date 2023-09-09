package net.kreckkead.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.kreckkead.employeeservice.dto.APIResponseDto;
import net.kreckkead.employeeservice.dto.EmployeeDto;
import net.kreckkead.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    
    private EmployeeService employeeService;

    // Build Save Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);

        return new ResponseEntity<EmployeeDto>(savedEmployee, HttpStatus.CREATED);
    }

    // Build Get Employee By ID REST API
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        APIResponseDto employeeDto = employeeService.getEmployeeById(employeeId);

        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
}
