package com.gt_enterprise.auth_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("api/auth/**").permitAll() // Permit all requests that starts with /auth, this requests does not have to be authenticated
                .anyRequest().authenticated() //Any other requests must be authenticated
            ).formLogin(form -> form.loginPage("/login").permitAll()) //Set the custom login page URL to "/login". If there is any request which authentication is required, it will be redirected to this URL.
            .logout(logout -> logout.logoutUrl("/logout").permitAll()) //Sets the logout URL to "/logout" and any request is allowed to call this url
            .csrf(csrf -> csrf.disable()) //Disable Cross-Site Request Forgery protection
            .build(); //Builds and returns the configured SecurityFilterChain
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();//Create a singleton instance that is stored in the ApplicationContext to be injected anywhere it is needed.
    }
}


