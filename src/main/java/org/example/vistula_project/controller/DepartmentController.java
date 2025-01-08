package org.example.vistula_project.controller;

import lombok.RequiredArgsConstructor;
import org.example.vistula_project.entity.EmployeeEntity;
import org.example.vistula_project.model.DepartmentDTO;
import org.example.vistula_project.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dep")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class DepartmentController {

    private final DepartmentService departmentService;


    @GetMapping("/get")
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/get/{id}")
    public DepartmentDTO getById(@PathVariable Long id) {
        return departmentService.getById(id);
    }

    @GetMapping("/get/{id}/employees")
    public List<EmployeeEntity> getEmployeesByDepartmentId(@PathVariable Long id) {
        return departmentService.getEmployeesByDepartmentId(id);
    }
}
