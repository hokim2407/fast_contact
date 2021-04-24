package com.example.mycontact.Exception.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {
    private int code;
    private String message;

    public static ErrorResponse of(HttpStatus status, String msg) {
        return new ErrorResponse(status.value(),msg);
    }
    public static ErrorResponse of(HttpStatus status, FieldError error) {
        if(error == null)
            return new ErrorResponse(status.value(),"invalid params");
        else
            return new ErrorResponse(status.value(),error.getDefaultMessage());
    }
}
