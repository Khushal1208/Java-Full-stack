package com.khushal.crudspringbootdemo.exception;

import com.khushal.crudspringbootdemo.DTO.ExceptionResponseDTO;
import com.khushal.crudspringbootdemo.DTO.ValidationExceptionResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleResourceNotFoundException(
            ResourceNotFoundException ex,
            HttpServletRequest req) {

        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage(), req);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionResponseDTO> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex,
            HttpServletRequest req) {

        Map<String, String> feildErrors =  new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(
                        error ->
                                feildErrors.put(
                                        error.getField(),
                                        error.getDefaultMessage()
                                )
                );

        ValidationExceptionResponseDTO response = new ValidationExceptionResponseDTO(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "Validation Failed",
                req.getRequestURI(),
                feildErrors
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ExceptionResponseDTO> handleDuplicateResourceException(
            DuplicateResourceException ex,
            HttpServletRequest req) {

        return buildResponse(HttpStatus.CONFLICT, ex.getMessage(), req);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDTO> handleRuntimeException(
            RuntimeException ex,
            HttpServletRequest req) {

        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), req);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDTO> handleGenericException(
            Exception ex,
            HttpServletRequest req) {

        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), req);
    }

    private ResponseEntity<ExceptionResponseDTO> buildResponse(
            HttpStatus status,
            String message,
            HttpServletRequest req) {

        ExceptionResponseDTO response = new ExceptionResponseDTO(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message,
                req.getRequestURI()
        );

        return ResponseEntity.status(status).body(response);
    }
}