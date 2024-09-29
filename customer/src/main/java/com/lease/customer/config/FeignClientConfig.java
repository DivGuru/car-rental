package com.lease.customer.config;


import feign.RequestInterceptor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

public class FeignClientConfig {

    public RequestInterceptor requestInterceptor(){
        return requestTemplate -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if(authentication!=null && authentication.getCredentials() instanceof Jwt){
                Jwt jwt = (Jwt) authentication.getCredentials();

                //add jwt token to header
                requestTemplate.header("Authorization","Bearer "+jwt.getTokenValue());
            }
        };
    }
}
