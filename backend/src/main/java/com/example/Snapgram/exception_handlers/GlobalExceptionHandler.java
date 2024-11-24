package com.example.Snapgram.exception_handlers;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Snapgram.models.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler  {
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorResponse> handleDatabaseOperationException(SQLException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
