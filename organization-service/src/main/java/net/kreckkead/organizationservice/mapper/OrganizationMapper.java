package net.kreckkead.organizationservice.mapper;

import net.kreckkead.organizationservice.dto.OrganizationDto;
import net.kreckkead.organizationservice.entity.Organization;

public class OrganizationMapper {

    public static OrganizationDto mapToOrganizationDto(Organization organization) {

        OrganizationDto organizationDto = new OrganizationDto(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getCreateDate());

        return organizationDto;
    }

    public static Organization mapToOrganization(OrganizationDto organizationDto) {

        Organization organization = new Organization(
                organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getOrganizationCode(),
                organizationDto.getCreateDate());

        return organization;
    }
}
