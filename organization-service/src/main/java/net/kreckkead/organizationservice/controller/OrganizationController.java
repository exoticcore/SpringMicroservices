package net.kreckkead.organizationservice.controller;

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
import net.kreckkead.organizationservice.dto.OrganizationDto;
import net.kreckkead.organizationservice.service.OrganizationService;

@Tag(name = "Organization Service - Organization Controller", description = "Organization Controller Exposes REST APIs for Organization-Service")
@AllArgsConstructor
@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    private OrganizationService organizationService;

    @Operation(summary = "Save Organization REST API", description = "Save Organization REST API is used to save organization object in a database")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    // Build Save Organization REST API
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {

        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);

        return new ResponseEntity<OrganizationDto>(savedOrganization, HttpStatus.CREATED);

    }

    @Operation(summary = "Get Organization REST API", description = "Get Organization REST API is used to get organization object from the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    @GetMapping("/{code}")
    public ResponseEntity<OrganizationDto> findOrganizationByCode(@PathVariable("code") String organizationCode) {

        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);

        return ResponseEntity.ok(organizationDto);
    }

}
