package com.demobank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/my-account")
    public String sayWelcome(){
        return "<h1>account details come here</h1>";
    }
}
