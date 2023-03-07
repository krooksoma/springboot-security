package com.demobank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
//  The following is copied from function SpringBootWebSecurityConfiguration
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
//               visible apis with authentication. requestMatchers accepts any number of api patterns
                .requestMatchers("/account-balance", "/loan-account", "/cards-accounts", "/my-account/**").authenticated()
                .requestMatchers("/contact", "/notice-board").permitAll() //visible apis without authentication
                //.anyRequest().denyAll() -->Will be use to test the security system in dev environments
                .and().formLogin()
                .and().httpBasic();

        return http.build();
    }
}