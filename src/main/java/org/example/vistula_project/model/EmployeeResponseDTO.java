package org.example.vistula_project.model;

public record EmployeeResponseDTO(Long id, String name, String surname, int age, Long addressId, Long departmentId) {
}
