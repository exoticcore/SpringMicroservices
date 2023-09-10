package net.kreckkead.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.kreckkead.employeeservice.dto.APIResponseDto;
import net.kreckkead.employeeservice.dto.EmployeeDto;
import net.kreckkead.employeeservice.service.EmployeeService;

@Tag(name = "Employee Service - Employee Controller", description = "Employee Controller Exposes REST APIs for Employee-Service")
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @Operation(summary = "Save Employee REST API", description = "Save Employee REST API is used to save employee object in a database")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    // Build Save Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);

        return new ResponseEntity<EmployeeDto>(savedEmployee, HttpStatus.CREATED);
    }

    @Operation(summary = "Get Employee REST API", description = "Get Employee REST API is used to get employee object from the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    // Build Get Employee By ID REST API
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        APIResponseDto employeeDto = employeeService.getEmployeeById(employeeId);

        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
}
