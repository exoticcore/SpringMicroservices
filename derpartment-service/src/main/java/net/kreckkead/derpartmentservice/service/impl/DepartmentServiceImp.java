package net.kreckkead.derpartmentservice.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.kreckkead.derpartmentservice.dto.DepartmentDto;
import net.kreckkead.derpartmentservice.entity.Department;
import net.kreckkead.derpartmentservice.mapper.DepartmentMapper;
import net.kreckkead.derpartmentservice.repository.DepartmentRepository;
import net.kreckkead.derpartmentservice.service.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImp implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        
        // convert department dto to department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        departmentRepository.save(department);

        // convert department jpa entity to department dto
        DepartmentDto savedDepartment = DepartmentMapper.mapToDepartmentDto(department);

        return savedDepartment;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        
        Department department = departmentRepository.findByDepartmentCode(code);
        
        return DepartmentMapper.mapToDepartmentDto(department);
    }
    
}
