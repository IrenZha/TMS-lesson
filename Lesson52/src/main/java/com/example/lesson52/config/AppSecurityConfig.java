package com.example.lesson52.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@RequiredArgsConstructor
@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    private final TokenValidationFilter filter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and()
                .authorizeHttpRequests()
                .antMatchers("/reg", "/auth").permitAll()
                .antMatchers("private").authenticated()
                .and()
                .addFilterBefore(filter, LogoutFilter.class);
    }
}
