package com.lease.customer.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import feign.RequestInterceptor;

@Configuration
public class FeignClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor(){
        System.out.println("Configuring feign client");
        return requestTemplate -> {
        	System.out.println("Inside her");
        	
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null) {
                System.out.println("Authentication object exists: " + authentication);
            }
            if(authentication!=null && authentication.getCredentials() instanceof Jwt){
                Jwt jwt = (Jwt) authentication.getCredentials();
                System.out.println("token value :"+jwt.getTokenValue());

                //add jwt token to header
                requestTemplate.header("Authorization","Bearer "+jwt.getTokenValue());
            }
        };
    }
}
