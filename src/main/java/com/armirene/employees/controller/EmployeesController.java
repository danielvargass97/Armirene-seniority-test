package com.armirene.employees.controller;

import com.armirene.employees.dto.request.EditEmployeeRequest;
import com.armirene.employees.dto.request.EmployeeFilterRequest;
import com.armirene.employees.dto.request.RegisterEmployeeRequest;
import com.armirene.employees.dto.response.EmployeeResponse;
import com.armirene.employees.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Endpoint para creación de empleados
    @PostMapping("/register")
    public ResponseEntity<String> createEmployee(@Valid @RequestBody RegisterEmployeeRequest request) {
        var response = employeeService.createEmployee(request);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Employee already exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee created");
    }

    // Endpoint para listar empleados con filtros y paginación
    @GetMapping
    public ResponseEntity<Page<EmployeeResponse>> listEmployees(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String middleNames,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String secondLastName,
            @RequestParam(required = false) String identificationType,
            @RequestParam(required = false) String identificationNumber,
            @RequestParam(required = false) String employmentCountry,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        // Crear una solicitud de filtros
        EmployeeFilterRequest filterRequest = new EmployeeFilterRequest(
                firstName, middleNames, lastName, secondLastName,
                identificationType, identificationNumber, employmentCountry,
                email, status);

        // Usar el servicio para obtener los empleados filtrados y paginados
        Page<EmployeeResponse> employees = employeeService.findEmployees(filterRequest, PageRequest.of(page, size));
        return ResponseEntity.ok(employees);
    }

    // Endpoint para eliminar empleados
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        boolean isDeleted = employeeService.deleteEmployee(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Employee deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }

    // Endpoint para editar empleados
    @PutMapping("/{id}")
    public ResponseEntity<String> editEmployee(@PathVariable Long id, @Valid @RequestBody EditEmployeeRequest editRequest) {
        boolean isUpdated = employeeService.updateEmployee(id, editRequest);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body("Employee update");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }
}
