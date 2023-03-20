package com.example.resource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class ResourceServerConfig {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests()
        .requestMatchers(HttpMethod.GET, "**/users/**").hasAuthority("SCOPE_user.read")
        .requestMatchers(HttpMethod.POST, "**/users").hasAuthority("SCOPE_user.write")
        .anyRequest()
        .authenticated()
        .and()
        .oauth2ResourceServer()
        .jwt();
    return http.build();
  }

}