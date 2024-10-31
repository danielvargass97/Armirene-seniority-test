package com.armirene.employees.domain.enums;

import lombok.Getter;

@Getter
public enum IdentificationType {
    CEDULA_DE_CIUDADANIA("Cédula de ciudadanía"),
    CEDULA_DE_EXTRANJERIA("Cédula de extranjería"),
    PASAPORTE("Pasaporte"),
    PERMISO_ESPECIAL("Permiso especial");

    private final String displayName;

    IdentificationType(String displayName) {
        this.displayName = displayName;
    }

}
