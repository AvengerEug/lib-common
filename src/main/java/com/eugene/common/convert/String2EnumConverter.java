package com.eugene.common.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

public class String2EnumConverter implements ConverterFactory<String, Enum> {

    @Override
    public <T extends Enum> Converter<String, T> getConverter(final Class<T> targetType) {
        if (!targetType.isEnum()) {
            throw new UnsupportedOperationException("Only Support Enum Type");
        }

        return new Converter<String, T>() {
            @Override
            public T convert(String source) {
                for (T enumConstant : targetType.getEnumConstants()) {
                    if (enumConstant.toString().equals(source)) return enumConstant;
                }
                return null;
            }
        };
    }

}
