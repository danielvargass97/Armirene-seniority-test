package com.armirene.employees.config.converter;

import com.armirene.employees.domain.enums.IdentificationType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToIdentificationTypeConverter implements Converter<String, IdentificationType> {
    @Override
    public IdentificationType convert(String source) {
        return IdentificationType.valueOf(source.toUpperCase());
    }
}
