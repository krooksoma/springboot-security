package com.demobank.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeBoardController {

    @GetMapping("/notice-board")
    public String noticeBoardInfo(){
        return "Here is the notice board";
    }
}
