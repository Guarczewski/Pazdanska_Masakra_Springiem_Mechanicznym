package com.example.springwithsql;

import com.example.springwithsql.Entity.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)

public class SecurityConfig {


   // @Autowired
    //private MyUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {
                http

                        //.userDetailsService(userDetailsService)
                        //.httpBasic(Customizer.withDefaults())
                        .authorizeHttpRequests((requests) -> requests
                                // Allow access to all other requests
                                .requestMatchers("/api/user").authenticated() // Require authentication for /api/user
                                .requestMatchers("/api2/**").permitAll()) // Require authentication for /api/user
                        .formLogin(form -> form
                                .loginPage("/api/error")
                                .permitAll()
                        );

        return http.build();
    }
}
