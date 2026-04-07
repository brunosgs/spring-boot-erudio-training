package com.github.brunosgs.serializer;

import com.github.dozermapper.core.DozerConverter;

public class GenderSerializer extends DozerConverter<String, String> {    
    public GenderSerializer() {
        super(String.class, String.class);
    }

    @Override
    public String convertTo(String source, String destination) {
        return null;
    }

    @Override
    public String convertFrom(String source, String destination) {
        if (source == null) return null;

        return "Male".equalsIgnoreCase(source) ? "M" : "F";
    }
}
