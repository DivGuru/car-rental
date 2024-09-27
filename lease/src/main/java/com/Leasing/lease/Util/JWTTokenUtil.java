package com.Leasing.lease.Util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class JWTTokenUtil {

    public void printTokenDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof Jwt) {
            Jwt jwt = (Jwt) authentication.getPrincipal();
            System.out.println("JWT Token Claims:");
            jwt.getClaims().forEach((key, value) -> {
                System.out.println(key + ": " + value);
            });
        } else {
            System.out.println("No JWT token found in SecurityContext.");
        }
    }
}
