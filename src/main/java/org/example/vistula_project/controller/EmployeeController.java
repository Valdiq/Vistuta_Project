package org.example.vistula_project.controller;

import lombok.RequiredArgsConstructor;
import org.example.vistula_project.model.EmployeeDTO;
import org.example.vistula_project.model.EmployeeResponseDTO;
import org.example.vistula_project.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/emp")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/get")
    public Optional<List<EmployeeResponseDTO>> getAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public Optional<EmployeeResponseDTO> getById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @PostMapping("/save")
    public EmployeeResponseDTO save(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.save(employeeDTO);
    }

    @PutMapping("/update/{id}")
    public EmployeeResponseDTO update(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
    }
}
