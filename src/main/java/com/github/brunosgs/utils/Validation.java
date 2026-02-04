package com.github.brunosgs.utils;

public class Validation {
    public static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) {
            return true;
        }

        String number = strNumber.replace(",", ".");

        return !number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
