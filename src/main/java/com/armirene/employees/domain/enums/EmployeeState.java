package com.armirene.employees.domain.enums;

import lombok.Getter;

@Getter
public enum EmployeeState {
    ACTIVO("Activo"),
    INACTIVO("Inactivo");

    private final String displayName;

    EmployeeState(String displayName) {
        this.displayName = displayName;
    }

}
