package com.armirene.employees.domain.enums;

import lombok.Getter;

@Getter
public enum WorkArea {
    ADMINISTRACION("Administración"),
    FINANCIERA("Financiera"),
    COMPRAS("Compras"),
    INFRAESTRUCTURA("Infraestructura"),
    OPERACION("Operación"),
    TALENTO_HUMANO("Talento humano"),
    SERVICIOS_VARIOS("Servicios varios");

    private final String displayName;

    WorkArea(String displayName) {
        this.displayName = displayName;
    }

}
