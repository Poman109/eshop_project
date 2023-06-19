package com.fsse2305.eshop_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {CannotFoundProductException.class})
    public ResponseEntity<Object> handleApiRequestException(CannotFoundProductException c) {
        //1.Create payload containing exception details

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(
                c.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Asia/Hong_Kong"))
        );
        //2.return response entity
        return new ResponseEntity<>(apiException, badRequest);
    }
}
