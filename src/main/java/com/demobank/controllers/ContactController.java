package com.demobank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/contact")
    public String contactInfo(){
        return "<h1> Contact Page </h1>";
    }
}
