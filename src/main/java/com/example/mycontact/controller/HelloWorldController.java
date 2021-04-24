package com.example.mycontact.controller;

import com.example.mycontact.Exception.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.jvm.hotspot.HelloWorld;


@RestController
public class HelloWorldController {
    @GetMapping(value ="/api/helloWorld")
    public String helloWorld(){
        return "HelloWorld";
    }

    @GetMapping(value ="/api/helloException")
    public String helloWorldException(){
        throw  new RuntimeException("helloWorldException");
    }

}
