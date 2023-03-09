package com.demobank.services;

import com.demobank.dao.Customer;
import com.demobank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoBankUserDetails implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        List<Customer> customer = customerRepository.findByEmail(username);

        if(customer.size() == 0){
            throw new UsernameNotFoundException("User Details not found for: " + username);
        }

        return new SecurityCustomer(customer.get(0));
    }
}
