package com.hoinguyen.SpringSecurityDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot";
    }

    @GetMapping("/bye")
    public String bye() {
        return "Bye Spring Boot";
    }

}
