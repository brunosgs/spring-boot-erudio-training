package com.github.brunosgs.exception.handler;

import com.github.brunosgs.exception.ExceptionResponse;
import com.github.brunosgs.exception.ResourceNotFoundException;
import com.github.brunosgs.exception.UnsupportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(UnsupportedMathOperationException ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(ResourceNotFoundException ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
