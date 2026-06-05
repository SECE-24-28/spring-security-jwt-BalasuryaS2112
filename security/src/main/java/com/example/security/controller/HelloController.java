package com.example.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
    @GetMapping("/")
    public String index(){
        return "Welcome to the Home page";
    }
    @GetMapping("/session")
    public String session(HttpServletRequest request){
        return request.getSession().getId();
    }

}
