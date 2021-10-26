package com.example.demo.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()// NEVER do this. CSRF protection is disabled here to simplify the example and more clearly illustrate the topic (XSS). Disabling CSRF protection should never be in a real application.
                .authorizeRequests().anyRequest().authenticated()
                .and().httpBasic()
                .and()
                .headers().contentSecurityPolicy("script-src 'self'");
    }
}