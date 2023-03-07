package com.demobank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @GetMapping("/account-balance")
    public String currentBalance(){
        return "<h1>Here is the current balance</h1>";
    }
}
