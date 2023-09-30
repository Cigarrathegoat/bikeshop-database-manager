package com.commerce.bikes.handlers;

import com.commerce.bikes.apis.dtos.responses.errors.ErrorResponseDTO;
import com.commerce.bikes.apis.dtos.responses.errors.ErrorSpecificationDTO;
import com.commerce.bikes.exceptions.ObjectNotFoundException;
import com.commerce.bikes.exceptions.SaveMethodException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ApplicationExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> PersonNotFoundExceptionHandler(ObjectNotFoundException exception) {
        log.info("wound up on exception handler, for not having found an object");

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponseDTO.builder()
                        .data(ErrorSpecificationDTO.builder()
                                .errorCode("100")
                                .errorMessage(exception.getMessage())
                                .build())
                        .build());
    }

    @ExceptionHandler(SaveMethodException.class)
    public ResponseEntity<ErrorResponseDTO> SaveMethodExceptionHandler(SaveMethodException exception) {
        log.info("wound up on exception handler, for invalid input");

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponseDTO.builder()
                        .data(ErrorSpecificationDTO.builder()
                                .errorCode("100")
                                .errorMessage(exception.getMessage())
                                .build())
                        .build());
    }
}
