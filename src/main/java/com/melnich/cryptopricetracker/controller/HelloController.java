package com.melnich.cryptopricetracker.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/ok")
    public String hello() {
        return "Hello World";
    }
}
