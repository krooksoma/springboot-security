package com.demobank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @GetMapping("/loan")
    public String getLoanInfo(){
        return "<h1 style='color:red'>Current Loans Information</h1>";

    }
}
