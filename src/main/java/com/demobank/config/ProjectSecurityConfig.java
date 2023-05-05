package com.demobank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class ProjectSecurityConfig {
//  The following is copied from function SpringBootWebSecurityConfiguration
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
//               visible apis with authentication. requestMatchers accepts any number of api patterns
                .requestMatchers("/balance", "/loan", "/cards", "/my-account/**").authenticated()
                .requestMatchers("/contact", "/notice-board").permitAll() //visible apis without authentication
                //.anyRequest().denyAll() -->Will be use to test the security system in dev environments
                .and().formLogin()
                .and().httpBasic();

        return http.build();
    }

}
