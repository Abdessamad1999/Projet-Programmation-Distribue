package com.example.servicestructureenseignement.exception;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handelFiliereNotFound(NoSuchElementException exception, WebRequest request){
       return new ResponseEntity<Object>(new AppError(exception.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handelInvalidArgument(MethodArgumentNotValidException e){
        Map<String,String> errorMap = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return errorMap;
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> handelSqlConstraintDuplicate(SQLIntegrityConstraintViolationException e){
        return new ResponseEntity<Object>(new AppError(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<Object> handelSqlConstraintNull(PropertyValueException e){
        return new ResponseEntity<Object>(new AppError(e.getPropertyName()+" not null", HttpStatus.BAD_REQUEST, LocalDateTime.now()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> handelHttpMethod(HttpRequestMethodNotSupportedException e){
        return new ResponseEntity<Object>(new AppError(e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED, LocalDateTime.now()),HttpStatus.METHOD_NOT_ALLOWED);
    }
}
