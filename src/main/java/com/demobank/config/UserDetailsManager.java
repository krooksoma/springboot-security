package com.demobank.config;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class UserDetailsManager {

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(){
//
////        ----approach 1----
////        UserDetails admin = User.withDefaultPasswordEncoder()
////                .username("admin")
////                .password("1234")
////                .authorities("admin")
////                .build();
////
////        UserDetails user = User.withDefaultPasswordEncoder()
////                .username("user")
////                .password("1234")
////                .authorities("user")
////                .build();
////
////        return new InMemoryUserDetailsManager(admin, user);
//
////        ------approach 2------
////        //initializes 1 object of type InMemoryUserDetailsManager
////        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
////
////        //creates to objects of type UserDetails
////
////        UserDetails admin = User.withUsername("admin").password("1234").authorities("admin").build();
////        UserDetails user = User.withUsername("user").password("1234").authorities("user").build();
////
////        // uses the inMemoryUserDetailsManager to create those 2 user objects
////        inMemoryUserDetailsManager.createUser(admin);
////        inMemoryUserDetailsManager.createUser(user);
//
//        return inMemoryUserDetailsManager;
//    }

    @Bean
    public UserDetailsService userDetailsService(DataSource datasource){
        return new JdbcUserDetailsManager(datasource);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
