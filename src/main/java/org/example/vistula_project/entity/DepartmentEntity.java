package org.example.vistula_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Entity
@Table(name = "department")
@Data
@Accessors(chain = true)
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int numOfEmp;

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<EmployeeEntity> employeeEntities;
}
