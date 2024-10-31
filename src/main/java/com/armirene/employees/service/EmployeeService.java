package com.armirene.employees.service;

import com.armirene.employees.domain.enums.Country;
import com.armirene.employees.domain.model.Employee;
import com.armirene.employees.dto.request.EditEmployeeRequest;
import com.armirene.employees.dto.request.EmployeeFilterRequest;
import com.armirene.employees.dto.request.RegisterEmployeeRequest;
import com.armirene.employees.dto.response.EmployeeResponse;
import com.armirene.employees.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Bogota"));

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(RegisterEmployeeRequest request) {
        // Validar que la identificación no exista
        if (identificationExists(request.getIdentificationType().getDisplayName(), request.getIdentificationNumber())) {
            return null;
        }

        // Convertir RegisterEmployeeRequest a Employee
        Employee employee = convertToEmployee(request);

        return employeeRepository.save(employee);
    }

    private Employee convertToEmployee(RegisterEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setSecondLastName(request.getSecondLastName());
        employee.setLastName(request.getLastName());
        employee.setMiddleNames(request.getSecondName());
        employee.setEmploymentCountry(request.getCountry().getDisplayName());
        employee.setIdentificationType(request.getIdentificationType().getDisplayName());
        employee.setIdentificationNumber(request.getIdentificationNumber());
        employee.setHireDate(Date.valueOf(request.getStartDate()));
        employee.setArea(request.getArea().getDisplayName());
        employee.setStatus("Activo"); // Asignar estado predeterminado
        employee.setRegistrationTimestamp(Timestamp.from(zonedDateTime.toInstant())); // Registrar fecha y hora
        employee.setEmployeePhoto(request.getPhoto());

        // Generar el correo electrónico
        String email = generateEmail(employee);
        employee.setEmail(email);

        return employee;
    }

    private String generateEmail(Employee employee) {
        String domain = employee.getEmploymentCountry().equalsIgnoreCase(String.valueOf(Country.COLOMBIA))
                ? "tuarmi.com.co"
                : "armirene.com.ve";

        String baseEmail = String.format("%s.%s",
                String.join("", employee.getFirstName().toLowerCase().split(" ")),
                String.join("", employee.getLastName().toLowerCase().split(" ")));

        String email = baseEmail + "@" + domain;

        int counter = 1;
        while (emailExists(email)) {
            email = baseEmail + "." + counter + "@" + domain;
            counter++;
        }

        return email;
    }

    public boolean emailExists(String email) {
        Optional<Employee> employee = employeeRepository.findByEmail(email);
        return employee.isPresent();
    }

    public boolean identificationExists(String identificationType, String identificationNumber) {
        Optional<Employee> employee = employeeRepository.findByIdentificationTypeAndIdentificationNumber(identificationType, identificationNumber);
        return employee.isPresent();
    }

    public Page<EmployeeResponse> findEmployees(EmployeeFilterRequest filterRequest, PageRequest pageRequest) {
        Page<Employee> employees = employeeRepository.findEmployeesWithFilters(
                filterRequest.getFirstName(),
                filterRequest.getMiddleNames(),
                filterRequest.getLastName(),
                filterRequest.getSecondLastName(),
                filterRequest.getIdentificationType(),
                filterRequest.getIdentificationNumber(),
                filterRequest.getEmploymentCountry(),
                filterRequest.getEmail(),
                filterRequest.getStatus(),
                pageRequest);

        return employees.map(this::convertToEmployeeResponse);
    }

    private EmployeeResponse convertToEmployeeResponse(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getMiddleNames(),
                employee.getLastName(),
                employee.getSecondLastName(),
                employee.getIdentificationType(),
                employee.getIdentificationNumber(),
                employee.getEmail(),
                employee.getEmploymentCountry(),
                employee.getArea(),
                employee.getStatus(),
                employee.getHireDate(),
                employee.getRegistrationTimestamp(),
                employee.getEditTimestamp(),
                employee.getEmployeePhoto()
        );
    }

    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true; // El empleado fue eliminado
        }
        return false; // El empleado no fue encontrado
    }

    public Boolean updateEmployee(Long id, EditEmployeeRequest editRequest) {
        Optional<Employee> OptionalEmployee = employeeRepository.findById(id);

        if (OptionalEmployee.isEmpty()) {
            return false; // El empleado no fue encontrado
        }
        Employee employee = OptionalEmployee.get();
        // Verificar cambios en el nombre y apellidos
        boolean needNewEmail = !employee.getFirstName().equals(editRequest.getFirstName()) ||
                !employee.getLastName().equals(editRequest.getLastName()) ||
                !employee.getEmploymentCountry().equals(editRequest.getCountry().getDisplayName());

        // Actualizar todos los campos
        employee.setLastName(editRequest.getLastName());
        employee.setSecondLastName(editRequest.getSecondLastName());
        employee.setFirstName(editRequest.getFirstName());
        employee.setMiddleNames(editRequest.getSecondName());
        employee.setEmploymentCountry(editRequest.getCountry().getDisplayName());
        employee.setIdentificationType(editRequest.getIdentificationType().getDisplayName());
        employee.setIdentificationNumber(editRequest.getIdentificationNumber());
        employee.setArea(editRequest.getArea().getDisplayName());
        employee.setEmployeePhoto(editRequest.getPhoto());

        // Solo generar un nuevo correo si hay un cambio en los nombres o apellidos
        if (needNewEmail) {
            employee.setEmail(generateEmail(employee));
        } else {
            // Conservar el correo actual si no hubo cambios en el nombre y apellido
            employee.setEmail(employee.getEmail());
        }

        // Establecer la fecha de edición
        employee.setEditTimestamp(Timestamp.from(zonedDateTime.toInstant()));

        employeeRepository.save(employee);
        return true; // El empleado fue actualizado
    }
}