package com.github.brunosgs.utils;

import com.github.brunosgs.exception.UnsupportedMathOperationException;

public class Converter {

    public static Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        String number = strNumber.replace(",", ".");

        return Double.parseDouble(number);
    }
}
