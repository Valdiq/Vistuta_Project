package org.example.vistula_project.service;

import lombok.RequiredArgsConstructor;
import org.example.vistula_project.entity.DepartmentEntity;
import org.example.vistula_project.entity.EmployeeEntity;
import org.example.vistula_project.model.DepartmentDTO;
import org.example.vistula_project.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository repository;

    public List<DepartmentDTO> getAllDepartments() {
        return repository.findAll().stream()
                .map(department -> new DepartmentDTO(department.getId(), department.getName(), department.getNumOfEmp()))
                .collect(Collectors.toList());
    }

    public DepartmentDTO getById(Long id) {
        DepartmentEntity department = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department with ID: " + id + " not found!"));
        return new DepartmentDTO(department.getId(), department.getName(), department.getNumOfEmp());
    }

    public List<EmployeeEntity> getEmployeesByDepartmentId(Long departmentId) {
        DepartmentEntity department = repository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department with ID: " + departmentId + " not found!"));
        return department.getEmployeeEntities();
    }
}
