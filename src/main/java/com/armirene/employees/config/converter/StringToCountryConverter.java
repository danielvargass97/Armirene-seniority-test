package com.armirene.employees.config.converter;

import com.armirene.employees.domain.enums.Country;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCountryConverter implements Converter<String, Country> {
    @Override
    public Country convert(String source) {
        return Country.valueOf(source.toUpperCase());
    }
}