package com.armirene.employees.repository;

import com.armirene.employees.domain.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

    Optional<Employee> findByIdentificationTypeAndIdentificationNumber(String identificationType, String identificationNumber);

    @Query("SELECT e FROM Employee e WHERE " +
            "(:firstName IS NULL OR e.firstName = :firstName) AND " +
            "(:middleNames IS NULL OR e.middleNames = :middleNames) AND " +
            "(:lastName IS NULL OR e.lastName = :lastName) AND " +
            "(:secondLastName IS NULL OR e.secondLastName = :secondLastName) AND " +
            "(:identificationType IS NULL OR e.identificationType = :identificationType) AND " +
            "(:identificationNumber IS NULL OR e.identificationNumber = :identificationNumber) AND " +
            "(:employmentCountry IS NULL OR e.employmentCountry = :employmentCountry) AND " +
            "(:email IS NULL OR e.email = :email) AND " +
            "(:status IS NULL OR e.status = :status)")
    Page<Employee> findEmployeesWithFilters(
            @Param("firstName") String firstName,
            @Param("middleNames") String middleNames,
            @Param("lastName") String lastName,
            @Param("secondLastName") String secondLastName,
            @Param("identificationType") String identificationType,
            @Param("identificationNumber") String identificationNumber,
            @Param("employmentCountry") String employmentCountry,
            @Param("email") String email,
            @Param("status") String status,
            Pageable pageable);

}