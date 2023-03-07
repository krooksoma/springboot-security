package com.demobank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping("/cards-accounts")
    public String getCardsInfo(){
        return "<h1> Those are your cards </h1>";

    }

}
