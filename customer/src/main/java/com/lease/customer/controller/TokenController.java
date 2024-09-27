package com.lease.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lease.customer.service.TokenService;

@RestController
public class TokenController {
	
	TokenService tokenService;
	
	
	public TokenController(TokenService tokenService) {
		super();
		this.tokenService = tokenService;
	}

	private static final Logger log = LoggerFactory.getLogger(TokenController.class);
	
	@GetMapping("/token")
	public String getToken(Authentication authentication) {
		log.debug("Generating token for user {}",authentication.getName());
		String token = tokenService.generateToken(authentication);
		log.debug("Generated token is {}",token);
		return token;
		
	}

}
