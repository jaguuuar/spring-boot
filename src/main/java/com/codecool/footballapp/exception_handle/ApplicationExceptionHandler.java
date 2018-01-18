package com.codecool.footballapp.exception_handle;

import com.codecool.footballapp.exception_handle.custom_exception.NoSuchIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(NoSuchIdException.class)
    public ResponseEntity<Error> handleIfNoId() {
        Error error = new Error(ErrorCode.NO_SUCH_ID_IN_DATABASE, "No id in database");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


}
