package org.example.vistula_project.model;

import org.example.vistula_project.entity.AddressEntity;

public record EmployeeDTO(String name, String surname, int age, AddressEntity addressEntity,
                          Long departmentId) {
}
