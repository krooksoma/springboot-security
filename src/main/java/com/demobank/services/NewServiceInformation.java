package com.demobank.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NewServiceInformation {

    @Value("${complex.value}")
    private String myNumber;

    @Value("${spring.datasource.url}")
    private String sqlConnectionURI;

    @PostConstruct
    public void postConstruct(){
        System.out.println(myNumber);
        System.out.println(sqlConnectionURI);
    }
}
