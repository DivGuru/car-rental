package com.lease.customer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lease.customer.dto.UserLogin;
import com.lease.customer.service.UserLoginService;

@RestController
@RequestMapping("/login")
public class SignUpController {
	
	private UserLoginService loginService;
	
	
	public SignUpController(UserLoginService loginService) {
		super();
		this.loginService = loginService;
	}


	@PostMapping("/signup")
	public ResponseEntity<String> signUpUser(@RequestBody UserLogin user){
		System.out.println("user is "+user);
		UserLogin newUser=loginService.signUpUser(user);
		System.out.println("user Saved  "+newUser);
		return ResponseEntity.ok("Signed up user "+user.getUsername());
	}
	
	@GetMapping("/")
	public ResponseEntity<String> signUpUser1(){
		
		return ResponseEntity.ok("Hello");
	}

}
