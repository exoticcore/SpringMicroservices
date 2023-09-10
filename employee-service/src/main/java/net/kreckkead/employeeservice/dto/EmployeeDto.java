package net.kreckkead.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "EmployeeDto Model Information")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Long id;

    @Schema(description = "Employee First Name")
    private String firstName;

    @Schema(description = "Employee Last Name")
    private String lastName;

    @Schema(description = "Employee Email")
    private String email;

    @Schema(description = "Department Code of Employee")
    private String departmentCode;

    @Schema(description = "Organization Code of Employee")
    private String organizationCode;

}
