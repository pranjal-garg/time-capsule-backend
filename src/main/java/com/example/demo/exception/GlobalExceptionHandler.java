package com.example.demo.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CapsuleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleCapsuleNotFound(CapsuleNotFoundException exception, HttpServletRequest request) {
        return ErrorResponse.notFound(exception.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(CapsuleAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleCapsuleAlreadyExists(CapsuleAlreadyExistsException exception, HttpServletRequest request) {
        return ErrorResponse.conflict(exception.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(CapsuleValidationException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponse handleValidationError(CapsuleValidationException exception, HttpServletRequest request) {
        ErrorResponse errorResponse = ErrorResponse.validationError(exception.getMessage(), request.getRequestURI());
        if (exception.getDetails() != null) {
            errorResponse.setDetails(exception.getDetails());
        }
        return errorResponse;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleIllegalArgument(IllegalArgumentException exception, HttpServletRequest request) {
        return ErrorResponse.badRequest(exception.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        logger.warn("Validation failed for request: {}", request.getRequestURI());
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage()));
        return ErrorResponse.fieldValidationError(request.getRequestURI(), errors);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ErrorResponse handleMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        logger.warn("Method not supported: {} for {}", ex.getMethod(), request.getRequestURI());
        return ErrorResponse.badRequest("HTTP method " + ex.getMethod() + " not supported", request.getRequestURI());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleRuntimeException(RuntimeException ex, HttpServletRequest request) {
        logger.error("Runtime exception occurred: {}", ex.getMessage(), ex);
        return ErrorResponse.internalError(request.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleGenericException(Exception ex, HttpServletRequest request) {
        logger.error("Unexpected exception occurred: {}", ex.getMessage(), ex);
        return ErrorResponse.internalError(request.getRequestURI());
    }

}
