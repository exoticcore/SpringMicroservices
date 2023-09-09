package net.kreckkead.organizationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.kreckkead.organizationservice.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
