package com.lease.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lease.customer.dto.Customer;
import com.lease.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
	public Customer getCustomerById(@PathVariable long id) throws Exception {
		return service.getCustomerById(id);
	}

	@PostMapping("/add")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
		Customer customer2 = service.addCustomer(customer);
		return ResponseEntity.ok("Added customer with id "+customer2.getId());
		
	}
	
	@PostMapping("/add/{id}")
	public ResponseEntity<String> addCustomerToUser(@PathVariable Long id, @RequestBody Customer customer) {
		Customer customer2 = service.addCustomerToUser(id,customer);
		return ResponseEntity.ok("Added customer with id "+customer2.getId());
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable long id) throws Exception{

		service.deleteCustomer(id);
		return ResponseEntity.ok("Deleted customer with id "+id);
	}
	
	
}
