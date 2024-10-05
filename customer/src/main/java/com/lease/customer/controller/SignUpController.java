package com.lease.customer.controller;

import com.lease.customer.dto.Customer;
import com.lease.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lease.customer.dto.UserLogin;
import com.lease.customer.service.UserLoginService;

@RestController
@RequestMapping("/login")
public class SignUpController {
	
	private UserLoginService loginService;

	@Autowired
	private CustomerService customerService;
	
	
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

	@PostMapping("/add/{id}")
	public ResponseEntity<String> addCustomerToUser(@PathVariable Long id, @RequestBody Customer customer) {
		Customer customer2 = customerService.addCustomerToUser(id,customer);
		return ResponseEntity.ok("Added customer with id "+customer2.getId());

	}

	@GetMapping("/")
	public ResponseEntity<String> signUpUser1(){
		
		return ResponseEntity.ok("Hello");
	}

}
