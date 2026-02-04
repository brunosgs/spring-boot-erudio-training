package com.github.brunosgs.controllers;

import com.github.brunosgs.exception.UnsupportedMathOperationException;
import com.github.brunosgs.math.SimpleMath;
import com.github.brunosgs.utils.NumberConverter;
import com.github.brunosgs.utils.NumberValidator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {
    private SimpleMath math = new SimpleMath();

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne,
                      @PathVariable String numberTwo) {
        if (NumberValidator.isNumeric(numberOne) || NumberValidator.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(@PathVariable String numberOne,
                      @PathVariable String numberTwo) {
        if (NumberValidator.isNumeric(numberOne) || NumberValidator.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/mult/{numberOne}/{numberTwo}")
    public Double mult(@PathVariable String numberOne,
                       @PathVariable String numberTwo) {
        if (NumberValidator.isNumeric(numberOne) || NumberValidator.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable String numberOne,
                      @PathVariable String numberTwo) {
        if (NumberValidator.isNumeric(numberOne) || NumberValidator.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        if (numberTwo.equals("0")) {
            throw new UnsupportedMathOperationException("Division by zero!");
        }

        return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/average/{numberOne}/{numberTwo}")
    public Double average(@PathVariable String numberOne,
                          @PathVariable String numberTwo) {
        if (NumberValidator.isNumeric(numberOne) || NumberValidator.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        Double average = math.average(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

        if (average.isNaN()) {
            throw new UnsupportedMathOperationException("Undefined result, not a number (NaN).");
        }

        return average;
    }

    @RequestMapping("/square/{number}")
    public Double square(@PathVariable String number) {
        if (NumberValidator.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        Double resultSquareRoot = math.square(NumberConverter.convertToDouble(number));

        if (resultSquareRoot.isNaN()) {
            throw new UnsupportedMathOperationException("Undefined result, not a number (NaN).");
        }

        return resultSquareRoot;
    }
}
