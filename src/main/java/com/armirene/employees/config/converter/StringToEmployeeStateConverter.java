package com.armirene.employees.config.converter;

import com.armirene.employees.domain.enums.EmployeeState;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToEmployeeStateConverter implements Converter<String, EmployeeState> {
    @Override
    public EmployeeState convert(String source) {
        return EmployeeState.valueOf(source.toUpperCase());
    }
}
