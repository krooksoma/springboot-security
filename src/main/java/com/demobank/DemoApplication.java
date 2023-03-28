package com.demobank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//next Annot.-> This allows the application to scan the directory for controller components outside the root folder. Otherwise, it is optional
//@ComponentScan("com.demobank.controller")
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);


	}

}
