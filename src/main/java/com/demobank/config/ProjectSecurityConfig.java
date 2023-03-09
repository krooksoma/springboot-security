package com.demobank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        /* Approach 1 where use withDefaultPasswordEncoder() method
        while creating user details - Not to be used in production environment

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin123")
                .authorities("admin")
                .build();

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user123")
                .authorities("user")
                .build();

        */

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

        UserDetails admin = User.withUsername("admin").password("12345").authorities("admin").build();
        UserDetails user = User.withUsername("user").password("12345").authorities("user").build();

        inMemoryUserDetailsManager.createUser(admin);
        inMemoryUserDetailsManager.createUser(user);

        return inMemoryUserDetailsManager;
    }

    /* Not recommended for production environment */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
