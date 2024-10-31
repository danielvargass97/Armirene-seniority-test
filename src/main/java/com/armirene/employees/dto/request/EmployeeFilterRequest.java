package com.armirene.employees.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeFilterRequest {
    private String firstName;
    private String middleNames;
    private String lastName;
    private String secondLastName;
    private String identificationType;
    private String identificationNumber;
    private String employmentCountry;
    private String email;
    private String status;
}
