package net.kreckkead.employeeservice.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

// import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import net.kreckkead.employeeservice.dto.APIResponseDto;
import net.kreckkead.employeeservice.dto.DepartmantDto;
import net.kreckkead.employeeservice.dto.EmployeeDto;
import net.kreckkead.employeeservice.dto.OrganizationDto;
import net.kreckkead.employeeservice.entity.Employee;
import net.kreckkead.employeeservice.mapper.EmployeeMapper;
import net.kreckkead.employeeservice.repository.EmployeeRepository;
// import net.kreckkead.employeeservice.service.APIClient;
import net.kreckkead.employeeservice.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImp.class);

    private EmployeeRepository employeeRepository;

    // private RestTemplate restTemplate;

    private WebClient webClient;

    // private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    // @CircuitBreaker(name = "${spring.application.name}", fallbackMethod =
    // "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {

        LOGGER.info("inside getEmployeeById() method");

        Employee employee = employeeRepository.findById(employeeId).get();

        // ResponseEntity<DepartmantDto> responseEntity =
        // restTemplate.getForEntity("http://localhost:8080/api/departments/" +
        // employee.getDepartmentCode(), DepartmantDto.class);

        // DepartmantDto departmantDto = responseEntity.getBody();

        DepartmantDto departmantDto = webClient.get()
                .uri("http://localhost:9191/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmantDto.class)
                .block();

        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:9191/api/organizations/" + employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

        // DepartmantDto departmantDto =
        // apiClient.getDepartmentByCode(employee.getDepartmentCode());

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartmant(departmantDto);
        apiResponseDto.setOrganization(organizationDto);

        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {

        LOGGER.info("inside getDefaultDepartmetn() method");

        Employee employee = employeeRepository.findById(employeeId).get();

        DepartmantDto departmantDto = new DepartmantDto();
        departmantDto.setDepartmentName("R&D Department");
        departmantDto.setDepartmentCode("RD001");
        departmantDto.setDepartmentDescription("Research and Development Department");

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartmant(departmantDto);

        return apiResponseDto;
    }

}
