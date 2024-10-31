package com.armirene.employees.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class EmployeeResponse {
    private Long id;
    private String firstName;
    private String middleNames;
    private String lastName;
    private String secondLastName;
    private String identificationType;
    private String identificationNumber;
    private String email;
    private String employmentCountry;
    private String area;
    private String status;
    private Date hireDate;
    private Timestamp registrationTimestamp;
    private Timestamp editTimestamp;
    private String photo;
}
