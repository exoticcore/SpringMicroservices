package net.kreckkead.organizationservice.service.imp;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.kreckkead.organizationservice.dto.OrganizationDto;
import net.kreckkead.organizationservice.entity.Organization;
import net.kreckkead.organizationservice.mapper.OrganizationMapper;
import net.kreckkead.organizationservice.repository.OrganizationRepository;
import net.kreckkead.organizationservice.service.OrganizationService;

@Service
@AllArgsConstructor
public class OrganizationImpService implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        // convert OrganizationDto into Organization jpa entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

}
