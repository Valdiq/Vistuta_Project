package org.example.vistula_project.mapper;

import org.example.vistula_project.entity.EmployeeEntity;
import org.example.vistula_project.model.EmployeeResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {


    public default EmployeeResponseDTO employeeEntityToResponseDTO(EmployeeEntity employeeEntity) {
        return new EmployeeResponseDTO(employeeEntity.getId(), employeeEntity.getName(), employeeEntity.getSurname(), employeeEntity.getAge(), employeeEntity.getAddress().getId(), employeeEntity.getDepartment().getId());
    }
}
