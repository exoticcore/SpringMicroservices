package net.kreckkead.organizationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.kreckkead.organizationservice.dto.OrganizationDto;
import net.kreckkead.organizationservice.service.OrganizationService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    private OrganizationService organizationService;

    // Build Save Organization REST API
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {

        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);

        return new ResponseEntity<OrganizationDto>(savedOrganization, HttpStatus.CREATED);

    }
}
