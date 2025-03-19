package com.UserLogin.UserLogin.exception;

import com.UserLogin.UserLogin.dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.regex.PatternSyntaxException;

@ControllerAdvice
public class ExceptionHandling {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> resourceNotFoundException(ResourceNotFoundException ex, WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),new Date(),
                webRequest.getDescription(false)

        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }


}
