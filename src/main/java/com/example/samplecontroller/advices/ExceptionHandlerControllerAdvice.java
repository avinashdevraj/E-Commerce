package com.example.samplecontroller.advices;

import com.example.samplecontroller.dtos.ArthemeticDto;
import com.example.samplecontroller.dtos.ExceptionDto;
import com.example.samplecontroller.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//OR @RestControllerAdvice
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArthemeticDto> handleArthemeticException(){
        ArthemeticDto arthemeticDto = new ArthemeticDto();

        arthemeticDto.setMessage("Arithmetic Exception");
        return new ResponseEntity<>(arthemeticDto, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleException(ProductNotFoundException productNotFoundException){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(productNotFoundException.getMessage());
        exceptionDto.setProductId(productNotFoundException.getProductId());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
