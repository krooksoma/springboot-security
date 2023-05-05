package com.demobank.services;

import com.demobank.dao.Customer;
import com.demobank.repositories.CustomerRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoBankUserDetails{

    private static final Logger log = LoggerFactory.getLogger(DemoBankUserDetails.class);

    @Autowired
    CustomerRepository customerRepository;

    @PostConstruct
    public void postConstruct(){
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setEmail("mark_stevens@example.com");
        customer.setPwd("12345");
        customer.setRole("general_user");

        log.info("Saving new customer information into DB");
        System.out.println("Saving new customer");
        customerRepository.save(customer);

        log.info("Retrieving all records");
        List<Customer> customers = customerRepository.findByEmail("mark_stevens@example.com");
        System.out.println(customers.toString());
        log.info("Customers: " + customer);
    }


}
