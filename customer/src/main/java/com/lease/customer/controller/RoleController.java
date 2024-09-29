package com.lease.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lease.customer.dto.Customer;
import com.lease.customer.dto.Role;
import com.lease.customer.dto.UserLogin;
import com.lease.customer.service.RoleService;
import com.lease.customer.service.repository.UserLoginRepository;

@RestController
@RequestMapping("/role")
public class RoleController {

	
	private final RoleService roleService;
	

	public RoleController(RoleService roleService) {
		super();
		this.roleService = roleService;
	}


	@PostMapping("/{id}")
	private ResponseEntity<UserLogin> AddRoleToUser(@PathVariable Long id, @RequestBody  Role role){
		return roleService.AddRoleToUser(id,role);
	}
	
}
