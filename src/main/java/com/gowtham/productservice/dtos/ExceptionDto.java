package com.gowtham.productservice.dtos;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ExceptionDto
{
    private HttpStatus errorCode;
    private String message;

    public ExceptionDto(HttpStatus status, String message)
    {
        this.errorCode = status;
        this.message = message;
    }
}
