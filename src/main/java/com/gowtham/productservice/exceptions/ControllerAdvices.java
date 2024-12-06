package com.gowtham.productservice.exceptions;

import com.gowtham.productservice.dtos.ExceptionDto;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ControllerAdvices
{
//    @ExceptionHandler( NotFoundException.class)
//    private ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException)
//    {
//        return new ResponseEntity(
//            new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
//            HttpStatus.NOT_FOUND
//        );
//    }
}
