package org.example.vistula_project.service;

import org.example.vistula_project.entity.AddressEntity;
import org.example.vistula_project.entity.DepartmentEntity;
import org.example.vistula_project.entity.EmployeeEntity;
import org.example.vistula_project.mapper.EmployeeMapper;
import org.example.vistula_project.model.EmployeeDTO;
import org.example.vistula_project.model.EmployeeResponseDTO;
import org.example.vistula_project.repository.AddressRepository;
import org.example.vistula_project.repository.DepartmentRepository;
import org.example.vistula_project.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final DepartmentRepository departmentRepository;
    private final AddressRepository addressRepository;
    private final EmployeeMapper mapper;

    public EmployeeService(EmployeeRepository repository, DepartmentRepository departmentRepository, AddressRepository addressRepository, EmployeeMapper employeeMapper) {
        this.repository = repository;
        this.departmentRepository = departmentRepository;
        this.addressRepository = addressRepository;
        this.mapper = employeeMapper;
    }

    public Optional<List<EmployeeResponseDTO>> getAllEmployees() {
        List<EmployeeResponseDTO> employees = repository.findAll().stream()
                .map(mapper::employeeEntityToResponseDTO)
                .collect(Collectors.toList());
        return Optional.of(employees);
    }

    public Optional<EmployeeResponseDTO> getById(Long id) {
        EmployeeEntity employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with ID: " + id + " not found!"));
        return Optional.of(mapper.employeeEntityToResponseDTO(employee));
    }

    @Transactional
    public EmployeeResponseDTO save(EmployeeDTO employeeDTO) {
        AddressEntity addressEntity = addressRepository.save(employeeDTO.addressEntity());

        EmployeeEntity employeeEntity = new EmployeeEntity()
                .setName(employeeDTO.name())
                .setSurname(employeeDTO.surname())
                .setAge(employeeDTO.age())
                .setAddress(addressEntity);

        DepartmentEntity department = departmentRepository.findById(employeeDTO.departmentId())
                .orElseThrow(() -> new RuntimeException("Department with ID: " + employeeDTO.departmentId() + " not found!"));
        employeeEntity.setDepartment(department);

        EmployeeEntity savedEmployee = repository.save(employeeEntity);
        return mapper.employeeEntityToResponseDTO(savedEmployee);
    }

    public EmployeeResponseDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        EmployeeEntity existingEmployee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with ID: " + id + " not found!"));

        existingEmployee.setName(employeeDTO.name())
                .setSurname(employeeDTO.surname())
                .setAge(employeeDTO.age())
                .setAddress(employeeDTO.addressEntity());

        DepartmentEntity department = departmentRepository.findById(employeeDTO.departmentId())
                .orElseThrow(() -> new RuntimeException("Department with ID: " + employeeDTO.departmentId() + " not found!"));
        existingEmployee.setDepartment(department);

        EmployeeEntity updatedEmployee = repository.save(existingEmployee);
        return mapper.employeeEntityToResponseDTO(updatedEmployee);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
