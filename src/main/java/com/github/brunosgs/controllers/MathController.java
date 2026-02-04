package com.github.brunosgs.controllers;

import com.github.brunosgs.exception.UnsupportedMathOperationException;
import com.github.brunosgs.utils.Converter;
import com.github.brunosgs.utils.Validation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne,
                      @PathVariable String numberTwo) {
        if (Validation.isNumeric(numberOne) || Validation.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return Converter.convertToDouble(numberOne) + Converter.convertToDouble(numberTwo);
    }

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(@PathVariable String numberOne,
                      @PathVariable String numberTwo) {
        if (Validation.isNumeric(numberOne) || Validation.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return Converter.convertToDouble(numberOne) - Converter.convertToDouble(numberTwo);
    }

    @RequestMapping("/mult/{numberOne}/{numberTwo}")
    public Double mult(@PathVariable String numberOne,
                       @PathVariable String numberTwo) {
        if (Validation.isNumeric(numberOne) || Validation.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return Converter.convertToDouble(numberOne) * Converter.convertToDouble(numberTwo);
    }

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable String numberOne,
                      @PathVariable String numberTwo) {
        if (Validation.isNumeric(numberOne) || Validation.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        if (numberTwo.equals("0")) {
            throw new UnsupportedMathOperationException("Division by zero!");
        }

        Double division = Converter.convertToDouble(numberOne) / Converter.convertToDouble(numberTwo);

        if (division.isNaN()) {
            throw new UnsupportedMathOperationException("Undefined result, not a number (NaN).");
        }

        return division;
    }

    @RequestMapping("/average/{numberOne}/{numberTwo}")
    public Double average(@PathVariable String numberOne,
                          @PathVariable String numberTwo) {
        if (Validation.isNumeric(numberOne) || Validation.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        Double average = (Converter.convertToDouble(numberOne) + Converter.convertToDouble(numberTwo)) / 2;

        if (average.isNaN()) {
            throw new UnsupportedMathOperationException("Undefined result, not a number (NaN).");
        }

        return average;
    }

    @RequestMapping("/square/{number}")
    public Double square(@PathVariable String number) {
        if (Validation.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        Double resultSquareRoot = Math.sqrt(Converter.convertToDouble(number));

        if (resultSquareRoot.isNaN()) {
            throw new UnsupportedMathOperationException("Undefined result, not a number (NaN).");
        }

        return resultSquareRoot;
    }

}
