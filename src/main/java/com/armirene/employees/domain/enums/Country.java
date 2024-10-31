package com.armirene.employees.domain.enums;

import lombok.Getter;

@Getter
public enum Country {
    COLOMBIA("Colombia"),
    ESTADOS_UNIDOS("Estados Unidos");

    private final String displayName;

    Country(String displayName) {
        this.displayName = displayName;
    }

}
