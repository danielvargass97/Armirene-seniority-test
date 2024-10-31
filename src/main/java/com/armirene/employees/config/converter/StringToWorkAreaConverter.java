package com.armirene.employees.config.converter;

import com.armirene.employees.domain.enums.WorkArea;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToWorkAreaConverter implements Converter<String, WorkArea> {
    @Override
    public WorkArea convert(String source) {
        return WorkArea.valueOf(source.toUpperCase());
    }
}
