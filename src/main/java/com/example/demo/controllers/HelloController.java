package com.example.demo.controllers;

import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/secure")
    @Secured("ROLE_user")
    public String secure() {
        return "This is secure api";
    }
}
