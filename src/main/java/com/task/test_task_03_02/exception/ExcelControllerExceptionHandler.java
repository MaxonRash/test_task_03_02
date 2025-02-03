package com.task.test_task_03_02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcelControllerExceptionHandler {
    @ExceptionHandler(FileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> handleFileNotFound(RuntimeException exception) {
        return new ResponseEntity<>(new ErrorMessage(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OutOfBoundsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> handleOutOfBounds(RuntimeException exception) {
        return new ResponseEntity<>(new ErrorMessage(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FileDataIsNotNumbers.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleNotOnlyNumbers(RuntimeException exception) {
        return new ResponseEntity<>(new ErrorMessage(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
