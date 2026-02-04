package com.github.brunosgs.controllers;

import com.github.brunosgs.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne,
                      @PathVariable String numberTwo) {
        if (isNumeric(numberOne) || isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(@PathVariable String numberOne,
                      @PathVariable String numberTwo) {
        if (isNumeric(numberOne) || isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping("/mult/{numberOne}/{numberTwo}")
    public Double mult(@PathVariable String numberOne,
                       @PathVariable String numberTwo) {
        if (isNumeric(numberOne) || isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable String numberOne,
                      @PathVariable String numberTwo) {
        if (isNumeric(numberOne) || isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        Double division = convertToDouble(numberOne) / convertToDouble(numberTwo);

        if (division.isNaN()) {
            throw new UnsupportedMathOperationException("Undefined result, not a number (NaN).");
        }

        return division;
    }

    @RequestMapping("/average/{numberOne}/{numberTwo}")
    public Double average(@PathVariable String numberOne,
                          @PathVariable String numberTwo) {
        if (isNumeric(numberOne) || isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        Double average = (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;

        if (average.isNaN()) {
            throw new UnsupportedMathOperationException("Undefined result, not a number (NaN).");
        }

        return average;
    }

    @RequestMapping("/square/{number}")
    public Double square(@PathVariable String number) {
        if (isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        Double resultSquareRoot = Math.sqrt(convertToDouble(number));

        if (resultSquareRoot.isNaN()) {
            throw new UnsupportedMathOperationException("Undefined result, not a number (NaN).");
        }

        return resultSquareRoot;
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        String number = strNumber.replace(",", ".");

        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) {
            return true;
        }

        String number = strNumber.replace(",", ".");

        return !number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
