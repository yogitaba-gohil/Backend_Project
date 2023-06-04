package com.rest_api.fs14backend.securityConfig;


import com.rest_api.fs14backend.filters.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

  @Autowired
  private JwtFilter jwtFilter;
  @Bean
  public AuthenticationManager authenticationManagerBean(
          AuthenticationConfiguration authenticationConfiguration
  ) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
            .cors()
            .and()
            .csrf()
            .disable()
            .authorizeHttpRequests().requestMatchers("/api/v1/users/signup", "/api/v1/users/signin","/api/v1/products","/api/v1/products/{id}", "api/v1/payment","api/v1/users/{id}", "api/v1/users","/api/v1/addresses","api/v1/addresses/user/{id}","api/v1/payment/user/{id}","api/v1/orders","api/v1/orders/{id}","api/v1/order-details/all-order-details")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .httpBasic(withDefaults()).formLogin()
            .and()
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class );
    return http.build();
  }
}