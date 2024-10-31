package com.armirene.employees.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(name = "second_last_name", nullable = false, length = 20)
    private String secondLastName;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "middle_names", length = 50)
    private String middleNames;

    @Column(name = "employment_country", nullable = false, length = 50)
    private String employmentCountry;

    @Column(name = "identification_type", nullable = false, length = 50)
    private String identificationType;

    @Column(name = "identification_number", nullable = false, length = 20)
    private String identificationNumber;

    @Column(name = "email", nullable = false, length = 300, unique = true)
    private String email;

    @Column(name = "hire_date", nullable = false)
    private Date hireDate;

    @Column(name = "area", nullable = false, length = 50)
    private String area;

    @Column(name = "status", length = 10, columnDefinition = "varchar(10) default 'Active'")
    private String status;

    @Column(name = "registration_timestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp registrationTimestamp;

    @Column(name = "edit_timestamp")
    private Timestamp editTimestamp;

    @Column(name = "employee_photo")
    private String employeePhoto;
}


